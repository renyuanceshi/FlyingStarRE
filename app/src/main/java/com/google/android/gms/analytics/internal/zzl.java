package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzg;
import java.util.HashMap;
import java.util.Map;

class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzQY;
    private final zzah zzQZ;
    private final zzag zzRa;
    private final zzi zzRb;
    private long zzRc = Long.MIN_VALUE;
    private final zzt zzRd;
    private final zzt zzRe;
    private final zzaj zzRf;
    private long zzRg;
    private boolean zzRh;

    protected zzl(zzf zzf, zzg zzg) {
        super(zzf);
        zzx.zzz(zzg);
        this.zzRa = zzg.zzk(zzf);
        this.zzQY = zzg.zzm(zzf);
        this.zzQZ = zzg.zzn(zzf);
        this.zzRb = zzg.zzo(zzf);
        this.zzRf = new zzaj(zzjl());
        this.zzRd = new zzt(zzf) {
            public void run() {
                zzl.this.zzjV();
            }
        };
        this.zzRe = new zzt(zzf) {
            public void run() {
                zzl.this.zzjW();
            }
        };
    }

    private void zza(zzh zzh, zzpr zzpr) {
        zzx.zzz(zzh);
        zzx.zzz(zzpr);
        zza zza = new zza(zzji());
        zza.zzaS(zzh.zzjE());
        zza.enableAdvertisingIdCollection(zzh.zzjF());
        zzc zziy = zza.zziy();
        zzke zzke = (zzke) zziy.zzf(zzke.class);
        zzke.zzaX("data");
        zzke.zzI(true);
        zziy.zzb(zzpr);
        zzkd zzkd = (zzkd) zziy.zzf(zzkd.class);
        zzpq zzpq = (zzpq) zziy.zzf(zzpq.class);
        for (Map.Entry next : zzh.zzn().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if ("an".equals(str)) {
                zzpq.setAppName(str2);
            } else if ("av".equals(str)) {
                zzpq.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzpq.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzpq.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                zzke.setUserId(str2);
            } else {
                zzkd.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzh.zzjE(), zzpr);
        zziy.zzM(zzjq().zzlF());
        zziy.zzAy();
    }

    private boolean zzbk(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    private void zzjT() {
        Context context = zzji().getContext();
        if (!AnalyticsReceiver.zzY(context)) {
            zzbg("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzZ(context)) {
            zzbh("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzY(context)) {
            zzbg("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzZ(context)) {
            zzbg("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* access modifiers changed from: private */
    public void zzjV() {
        zzb((zzw) new zzw() {
            public void zzc(Throwable th) {
                zzl.this.zzkb();
            }
        });
    }

    /* access modifiers changed from: private */
    public void zzjW() {
        try {
            this.zzQY.zzjN();
            zzkb();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzRe.zzt(zzjn().zzkT());
    }

    private boolean zzkc() {
        if (this.zzRh) {
            return false;
        }
        return (!zzjn().zzkr() || zzjn().zzks()) && zzki() > 0;
    }

    private void zzkd() {
        zzv zzjp = zzjp();
        if (zzjp.zzlb() && !zzjp.zzbw()) {
            long zzjO = zzjO();
            if (zzjO != 0 && Math.abs(zzjl().currentTimeMillis() - zzjO) <= zzjn().zzkB()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzjn().zzkA()));
                zzjp.zzlc();
            }
        }
    }

    private void zzke() {
        long min;
        zzkd();
        long zzki = zzki();
        long zzlH = zzjq().zzlH();
        if (zzlH != 0) {
            min = zzki - Math.abs(zzjl().currentTimeMillis() - zzlH);
            if (min <= 0) {
                min = Math.min(zzjn().zzky(), zzki);
            }
        } else {
            min = Math.min(zzjn().zzky(), zzki);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(min));
        if (this.zzRd.zzbw()) {
            this.zzRd.zzu(Math.max(1, min + this.zzRd.zzkY()));
            return;
        }
        this.zzRd.zzt(min);
    }

    private void zzkf() {
        zzkg();
        zzkh();
    }

    private void zzkg() {
        if (this.zzRd.zzbw()) {
            zzbd("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzRd.cancel();
    }

    private void zzkh() {
        zzv zzjp = zzjp();
        if (zzjp.zzbw()) {
            zzjp.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        zzjk();
        if (!zzjn().zzkr()) {
            zzjY();
        }
    }

    /* access modifiers changed from: package-private */
    public void start() {
        zzjv();
        zzx.zza(!this.mStarted, (Object) "Analytics backend already started");
        this.mStarted = true;
        if (!zzjn().zzkr()) {
            zzjT();
        }
        zzjo().zzf(new Runnable() {
            public void run() {
                zzl.this.zzjU();
            }
        });
    }

    public void zzJ(boolean z) {
        zzkb();
    }

    public long zza(zzh zzh, boolean z) {
        long j;
        zzx.zzz(zzh);
        zzjv();
        zzjk();
        try {
            this.zzQY.beginTransaction();
            this.zzQY.zza(zzh.zzjD(), zzh.getClientId());
            j = this.zzQY.zza(zzh.zzjD(), zzh.getClientId(), zzh.zzjE());
            if (!z) {
                zzh.zzn(j);
            } else {
                zzh.zzn(1 + j);
            }
            this.zzQY.zzb(zzh);
            this.zzQY.setTransactionSuccessful();
            try {
                this.zzQY.endTransaction();
            } catch (SQLiteException e) {
                zze("Failed to end transaction", e);
            }
        } catch (SQLiteException e2) {
            zze("Failed to update Analytics property", e2);
            j = -1;
            try {
                this.zzQY.endTransaction();
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
        } catch (Throwable th) {
            try {
                this.zzQY.endTransaction();
            } catch (SQLiteException e4) {
                zze("Failed to end transaction", e4);
            }
            throw th;
        }
        return j;
    }

    public void zza(zzab zzab) {
        zzx.zzz(zzab);
        zzg.zzjk();
        zzjv();
        if (this.zzRh) {
            zzbe("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzab);
        }
        zzab zzf = zzf(zzab);
        zzjX();
        if (this.zzRb.zzb(zzf)) {
            zzbe("Hit sent to the device AnalyticsService for delivery");
        } else if (zzjn().zzkr()) {
            zzjm().zza(zzf, "Service unavailable on package side");
        } else {
            try {
                this.zzQY.zzc(zzf);
                zzkb();
            } catch (SQLiteException e) {
                zze("Delivery failed to save hit to a database", e);
                zzjm().zza(zzf, "deliver: failed to insert hit to database");
            }
        }
    }

    public void zza(final zzw zzw, final long j) {
        zzg.zzjk();
        zzjv();
        long j2 = -1;
        long zzlH = zzjq().zzlH();
        if (zzlH != 0) {
            j2 = Math.abs(zzjl().currentTimeMillis() - zzlH);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!zzjn().zzkr()) {
            zzjX();
        }
        try {
            if (zzjZ()) {
                zzjo().zzf(new Runnable() {
                    public void run() {
                        zzl.this.zza(zzw, j);
                    }
                });
                return;
            }
            zzjq().zzlI();
            zzkb();
            if (zzw != null) {
                zzw.zzc((Throwable) null);
            }
            if (this.zzRg != j) {
                this.zzRa.zzlA();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzjq().zzlI();
            zzkb();
            if (zzw != null) {
                zzw.zzc(th);
            }
        }
    }

    public void zzb(zzw zzw) {
        zza(zzw, this.zzRg);
    }

    public void zzbl(String str) {
        zzx.zzcM(str);
        zzjk();
        zzjj();
        zzpr zza = zzam.zza(zzjm(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzlJ = zzjq().zzlJ();
        if (str.equals(zzlJ)) {
            zzbg("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(zzlJ)) {
            zzd("Ignoring multiple install campaigns. original, new", zzlJ, str);
        } else {
            zzjq().zzbp(str);
            if (zzjq().zzlG().zzv(zzjn().zzkW())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzh zza2 : this.zzQY.zzr(0)) {
                zza(zza2, zza);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(zzh zzh) {
        zzjk();
        zzb("Sending first hit to property", zzh.zzjE());
        if (!zzjq().zzlG().zzv(zzjn().zzkW())) {
            String zzlJ = zzjq().zzlJ();
            if (!TextUtils.isEmpty(zzlJ)) {
                zzpr zza = zzam.zza(zzjm(), zzlJ);
                zzb("Found relevant installation campaign", zza);
                zza(zzh, zza);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzab zzf(zzab zzab) {
        Pair<String, Long> zzlN;
        if (!TextUtils.isEmpty(zzab.zzlv()) || (zzlN = zzjq().zzlK().zzlN()) == null) {
            return zzab;
        }
        String str = ((Long) zzlN.second) + ":" + ((String) zzlN.first);
        HashMap hashMap = new HashMap(zzab.zzn());
        hashMap.put("_m", str);
        return zzab.zza(this, zzab, hashMap);
    }

    /* access modifiers changed from: protected */
    public void zziJ() {
        this.zzQY.zza();
        this.zzQZ.zza();
        this.zzRb.zza();
    }

    public long zzjO() {
        zzg.zzjk();
        zzjv();
        try {
            return this.zzQY.zzjO();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void zzjU() {
        zzjv();
        zzjq().zzlF();
        if (!zzbk("android.permission.ACCESS_NETWORK_STATE")) {
            zzbh("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (!zzbk("android.permission.INTERNET")) {
            zzbh("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzkj();
        }
        if (AnalyticsService.zzZ(getContext())) {
            zzbd("AnalyticsService registered in the app manifest and enabled");
        } else if (zzjn().zzkr()) {
            zzbh("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzbg("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzRh && !zzjn().zzkr() && !this.zzQY.isEmpty()) {
            zzjX();
        }
        zzkb();
    }

    /* access modifiers changed from: protected */
    public void zzjX() {
        if (!this.zzRh && zzjn().zzkt() && !this.zzRb.isConnected()) {
            if (this.zzRf.zzv(zzjn().zzkO())) {
                this.zzRf.start();
                zzbd("Connecting to service");
                if (this.zzRb.connect()) {
                    zzbd("Connected to service");
                    this.zzRf.clear();
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[LOOP:1: B:18:0x0062->B:17:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzjY() {
        /*
            r6 = this;
            com.google.android.gms.measurement.zzg.zzjk()
            r6.zzjv()
            r6.zzjj()
            com.google.android.gms.analytics.internal.zzr r0 = r6.zzjn()
            boolean r0 = r0.zzkt()
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r6.zzbg(r0)
        L_0x0018:
            com.google.android.gms.analytics.internal.zzi r0 = r6.zzRb
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "Service not connected"
            r6.zzbd(r0)
        L_0x0025:
            return
        L_0x0026:
            com.google.android.gms.analytics.internal.zzj r0 = r6.zzQY
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r6.zzbd(r0)
        L_0x0033:
            com.google.android.gms.analytics.internal.zzj r0 = r6.zzQY     // Catch:{ SQLiteException -> 0x004c }
            com.google.android.gms.analytics.internal.zzr r1 = r6.zzjn()     // Catch:{ SQLiteException -> 0x004c }
            int r1 = r1.zzkC()     // Catch:{ SQLiteException -> 0x004c }
            long r2 = (long) r1     // Catch:{ SQLiteException -> 0x004c }
            java.util.List r1 = r0.zzp(r2)     // Catch:{ SQLiteException -> 0x004c }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x004c }
            if (r0 == 0) goto L_0x0062
            r6.zzkb()     // Catch:{ SQLiteException -> 0x004c }
            goto L_0x0025
        L_0x004c:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r6.zze(r1, r0)
            r6.zzkf()
            goto L_0x0025
        L_0x0056:
            r1.remove(r0)
            com.google.android.gms.analytics.internal.zzj r2 = r6.zzQY     // Catch:{ SQLiteException -> 0x007b }
            long r4 = r0.zzlq()     // Catch:{ SQLiteException -> 0x007b }
            r2.zzq(r4)     // Catch:{ SQLiteException -> 0x007b }
        L_0x0062:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0033
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0
            com.google.android.gms.analytics.internal.zzi r2 = r6.zzRb
            boolean r2 = r2.zzb((com.google.android.gms.analytics.internal.zzab) r0)
            if (r2 != 0) goto L_0x0056
            r6.zzkb()
            goto L_0x0025
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r6.zze(r1, r0)
            r6.zzkf()
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzjY():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f9, code lost:
        if (r12.zzRb.isConnected() == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0103, code lost:
        if (zzjn().zzkr() != false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        zzbd("Service connected, sending hits to the service");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010e, code lost:
        if (r3.isEmpty() != false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0110, code lost:
        r0 = r3.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011d, code lost:
        if (r12.zzRb.zzb(r0) != false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0125, code lost:
        if (r12.zzQZ.zzlB() == false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0127, code lost:
        r8 = r12.zzQZ.zzq(r3);
        r9 = r8.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0135, code lost:
        if (r9.hasNext() == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0137, code lost:
        r4 = java.lang.Math.max(r4, r9.next().longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0146, code lost:
        r4 = java.lang.Math.max(r4, r0.zzlq());
        r3.remove(r0);
        zzb("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r12.zzQY.zzq(r0.zzlq());
        r1.add(java.lang.Long.valueOf(r0.zzlq()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        zze("Failed to remove hit that was send for delivery", r0);
        zzkf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0180, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0181, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r3.removeAll(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r12.zzQY.zzo(r8);
        r1.addAll(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x019a, code lost:
        if (r1.isEmpty() == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a9, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        zze("Failed to remove successfully uploaded hits", r0);
        zzkf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r12.zzQY.setTransactionSuccessful();
        r12.zzQY.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c9, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01df, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e0, code lost:
        zze("Failed to commit local dispatch transaction", r0);
        zzkf();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzjZ() {
        /*
            r12 = this;
            r1 = 1
            r2 = 0
            com.google.android.gms.measurement.zzg.zzjk()
            r12.zzjv()
            java.lang.String r0 = "Dispatching a batch of local hits"
            r12.zzbd(r0)
            com.google.android.gms.analytics.internal.zzi r0 = r12.zzRb
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x0032
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzjn()
            boolean r0 = r0.zzkr()
            if (r0 != 0) goto L_0x0032
            r0 = r1
        L_0x0020:
            com.google.android.gms.analytics.internal.zzah r3 = r12.zzQZ
            boolean r3 = r3.zzlB()
            if (r3 != 0) goto L_0x0034
        L_0x0028:
            if (r0 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0036
            java.lang.String r0 = "No network or service available. Will retry later"
            r12.zzbd(r0)
        L_0x0031:
            return r2
        L_0x0032:
            r0 = r2
            goto L_0x0020
        L_0x0034:
            r1 = r2
            goto L_0x0028
        L_0x0036:
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzjn()
            int r0 = r0.zzkC()
            com.google.android.gms.analytics.internal.zzr r1 = r12.zzjn()
            int r1 = r1.zzkD()
            int r0 = java.lang.Math.max(r0, r1)
            long r6 = (long) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4 = 0
        L_0x0052:
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ all -> 0x01ea }
            r0.beginTransaction()     // Catch:{ all -> 0x01ea }
            r1.clear()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.List r3 = r0.zzp(r6)     // Catch:{ SQLiteException -> 0x00d3 }
            boolean r0 = r3.isEmpty()     // Catch:{ SQLiteException -> 0x00d3 }
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = "Store is empty, nothing to dispatch"
            r12.zzbd(r0)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.zzkf()     // Catch:{ SQLiteException -> 0x00d3 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x0079 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x0079 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0079 }
            goto L_0x0031
        L_0x0079:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x0083:
            java.lang.String r0 = "Hits loaded from store. count"
            int r8 = r3.size()     // Catch:{ SQLiteException -> 0x00d3 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.zza(r0, r8)     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.Iterator r8 = r3.iterator()     // Catch:{ all -> 0x01ea }
        L_0x0094:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x01ea }
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0     // Catch:{ all -> 0x01ea }
            long r10 = r0.zzlq()     // Catch:{ all -> 0x01ea }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0094
            java.lang.String r0 = "Database contains successfully uploaded hit"
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01ea }
            int r3 = r3.size()     // Catch:{ all -> 0x01ea }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01ea }
            r12.zzd(r0, r1, r3)     // Catch:{ all -> 0x01ea }
            r12.zzkf()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x00c8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x00c8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x00c8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x00c8 }
            goto L_0x0031
        L_0x00c8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from persisted store"
            r12.zzd(r1, r0)     // Catch:{ all -> 0x01ea }
            r12.zzkf()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x00e8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x00e8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x00e8 }
            goto L_0x0031
        L_0x00e8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x00f3:
            com.google.android.gms.analytics.internal.zzi r0 = r12.zzRb     // Catch:{ all -> 0x01ea }
            boolean r0 = r0.isConnected()     // Catch:{ all -> 0x01ea }
            if (r0 == 0) goto L_0x011f
            com.google.android.gms.analytics.internal.zzr r0 = r12.zzjn()     // Catch:{ all -> 0x01ea }
            boolean r0 = r0.zzkr()     // Catch:{ all -> 0x01ea }
            if (r0 != 0) goto L_0x011f
            java.lang.String r0 = "Service connected, sending hits to the service"
            r12.zzbd(r0)     // Catch:{ all -> 0x01ea }
        L_0x010a:
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x01ea }
            if (r0 != 0) goto L_0x011f
            r0 = 0
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzab r0 = (com.google.android.gms.analytics.internal.zzab) r0     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzi r8 = r12.zzRb     // Catch:{ all -> 0x01ea }
            boolean r8 = r8.zzb((com.google.android.gms.analytics.internal.zzab) r0)     // Catch:{ all -> 0x01ea }
            if (r8 != 0) goto L_0x0146
        L_0x011f:
            com.google.android.gms.analytics.internal.zzah r0 = r12.zzQZ     // Catch:{ all -> 0x01ea }
            boolean r0 = r0.zzlB()     // Catch:{ all -> 0x01ea }
            if (r0 == 0) goto L_0x0196
            com.google.android.gms.analytics.internal.zzah r0 = r12.zzQZ     // Catch:{ all -> 0x01ea }
            java.util.List r8 = r0.zzq(r3)     // Catch:{ all -> 0x01ea }
            java.util.Iterator r9 = r8.iterator()     // Catch:{ all -> 0x01ea }
        L_0x0131:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x01ea }
            if (r0 == 0) goto L_0x018b
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x01ea }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x01ea }
            long r10 = r0.longValue()     // Catch:{ all -> 0x01ea }
            long r4 = java.lang.Math.max(r4, r10)     // Catch:{ all -> 0x01ea }
            goto L_0x0131
        L_0x0146:
            long r8 = r0.zzlq()     // Catch:{ all -> 0x01ea }
            long r4 = java.lang.Math.max(r4, r8)     // Catch:{ all -> 0x01ea }
            r3.remove(r0)     // Catch:{ all -> 0x01ea }
            java.lang.String r8 = "Hit sent do device AnalyticsService for delivery"
            r12.zzb(r8, r0)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r8 = r12.zzQY     // Catch:{ SQLiteException -> 0x016b }
            long r10 = r0.zzlq()     // Catch:{ SQLiteException -> 0x016b }
            r8.zzq(r10)     // Catch:{ SQLiteException -> 0x016b }
            long r8 = r0.zzlq()     // Catch:{ SQLiteException -> 0x016b }
            java.lang.Long r0 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x016b }
            r1.add(r0)     // Catch:{ SQLiteException -> 0x016b }
            goto L_0x010a
        L_0x016b:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r12.zze(r1, r0)     // Catch:{ all -> 0x01ea }
            r12.zzkf()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x0180 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0180 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x0180 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0180 }
            goto L_0x0031
        L_0x0180:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x018b:
            r3.removeAll(r8)     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01b3 }
            r0.zzo((java.util.List<java.lang.Long>) r8)     // Catch:{ SQLiteException -> 0x01b3 }
            r1.addAll(r8)     // Catch:{ SQLiteException -> 0x01b3 }
        L_0x0196:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x01ea }
            if (r0 == 0) goto L_0x01d3
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01a8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01a8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01a8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x01a8 }
            goto L_0x0031
        L_0x01a8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x01b3:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove successfully uploaded hits"
            r12.zze(r1, r0)     // Catch:{ all -> 0x01ea }
            r12.zzkf()     // Catch:{ all -> 0x01ea }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01c8 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01c8 }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01c8 }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x01c8 }
            goto L_0x0031
        L_0x01c8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x01d3:
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01df }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01df }
            com.google.android.gms.analytics.internal.zzj r0 = r12.zzQY     // Catch:{ SQLiteException -> 0x01df }
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x01df }
            goto L_0x0052
        L_0x01df:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        L_0x01ea:
            r0 = move-exception
            com.google.android.gms.analytics.internal.zzj r1 = r12.zzQY     // Catch:{ SQLiteException -> 0x01f6 }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x01f6 }
            com.google.android.gms.analytics.internal.zzj r1 = r12.zzQY     // Catch:{ SQLiteException -> 0x01f6 }
            r1.endTransaction()     // Catch:{ SQLiteException -> 0x01f6 }
            throw r0
        L_0x01f6:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.zze(r1, r0)
            r12.zzkf()
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzjZ():boolean");
    }

    public void zzjc() {
        zzg.zzjk();
        zzjv();
        if (!zzjn().zzkr()) {
            zzbd("Delete all hits from local store");
            try {
                this.zzQY.zzjL();
                this.zzQY.zzjM();
                zzkb();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zzjX();
        if (this.zzRb.zzjH()) {
            zzbd("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzjf() {
        zzg.zzjk();
        zzjv();
        zzbd("Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public void zzjh() {
        zzjk();
        this.zzRg = zzjl().currentTimeMillis();
    }

    public void zzka() {
        zzg.zzjk();
        zzjv();
        zzbe("Sync dispatching local hits");
        long j = this.zzRg;
        if (!zzjn().zzkr()) {
            zzjX();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zzkb();
                return;
            }
        } while (zzjZ());
        zzjq().zzlI();
        zzkb();
        if (this.zzRg != j) {
            this.zzRa.zzlA();
        }
    }

    public void zzkb() {
        boolean z;
        zzji().zzjk();
        zzjv();
        if (!zzkc()) {
            this.zzRa.unregister();
            zzkf();
        } else if (this.zzQY.isEmpty()) {
            this.zzRa.unregister();
            zzkf();
        } else {
            if (!zzy.zzSs.get().booleanValue()) {
                this.zzRa.zzly();
                z = this.zzRa.isConnected();
            } else {
                z = true;
            }
            if (z) {
                zzke();
                return;
            }
            zzkf();
            zzkd();
        }
    }

    public long zzki() {
        if (this.zzRc != Long.MIN_VALUE) {
            return this.zzRc;
        }
        return zziI().zzll() ? ((long) zziI().zzmc()) * 1000 : zzjn().zzkz();
    }

    public void zzkj() {
        zzjv();
        zzjk();
        this.zzRh = true;
        this.zzRb.disconnect();
        zzkb();
    }

    public void zzs(long j) {
        zzg.zzjk();
        zzjv();
        if (j < 0) {
            j = 0;
        }
        this.zzRc = j;
        zzkb();
    }
}
