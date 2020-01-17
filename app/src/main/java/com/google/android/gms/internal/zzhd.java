package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjq;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzhd extends zzj.zza {
    private static zzhd zzIQ;
    private static final Object zzqy = new Object();
    private final Context mContext;
    private final zzhc zzIR;
    private final zzbm zzIS;
    private final zzeg zzIT;

    zzhd(Context context, zzbm zzbm, zzhc zzhc) {
        this.mContext = context;
        this.zzIR = zzhc;
        this.zzIS = zzbm;
        this.zzIT = new zzeg(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8487000, 8487000, true), zzbm.zzdp(), new zzeg.zzb<zzed>() {
            /* renamed from: zza */
            public void zze(zzed zzed) {
                zzed.zza("/log", zzde.zzzf);
            }
        }, new zzeg.zzc());
    }

    private static AdResponseParcel zza(Context context, zzeg zzeg, zzbm zzbm, zzhc zzhc, AdRequestInfoParcel adRequestInfoParcel) {
        final Bundle bundle;
        zzjg zzjg;
        String string;
        zzin.zzaI("Starting ad request from service.");
        zzbt.initialize(context);
        final zzcb zzcb = new zzcb(zzbt.zzwg.get().booleanValue(), "load_ad", adRequestInfoParcel.zzrp.zzuh);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzHL != -1) {
            zzcb.zza(zzcb.zzb(adRequestInfoParcel.zzHL), "cts");
        }
        zzbz zzdB = zzcb.zzdB();
        Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzHA == null) ? null : adRequestInfoParcel.zzHA;
        if (!zzbt.zzwp.get().booleanValue() || zzhc.zzIP == null) {
            bundle = bundle2;
            zzjg = null;
        } else {
            if (bundle2 != null || !zzbt.zzwq.get().booleanValue()) {
                bundle = bundle2;
            } else {
                zzin.v("contentInfo is not present, but we'll still launch the app index task");
                bundle = new Bundle();
            }
            if (bundle != null) {
                final zzhc zzhc2 = zzhc;
                final Context context2 = context;
                final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
                zzjg = zziq.zza(new Callable<Void>() {
                    /* renamed from: zzdt */
                    public Void call() throws Exception {
                        zzhc2.zzIP.zza(context2, adRequestInfoParcel2.zzHu.packageName, bundle);
                        return null;
                    }
                });
            } else {
                zzjg = null;
            }
        }
        zzhc.zzIK.zzex();
        zzhj zzE = zzr.zzbI().zzE(context);
        if (zzE.zzKc == -1) {
            zzin.zzaI("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzHI : UUID.randomUUID().toString();
        final zzhf zzhf = new zzhf(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzHt.extras != null && (string = adRequestInfoParcel.zzHt.extras.getString("_ad")) != null) {
            return zzhe.zza(context, adRequestInfoParcel, string);
        }
        Location zzd = zzhc.zzIK.zzd(250);
        String token = zzhc.zzIL.getToken(context, adRequestInfoParcel.zzrj, adRequestInfoParcel.zzHu.packageName);
        List<String> zza = zzhc.zzII.zza(adRequestInfoParcel);
        String zzf = zzhc.zzIM.zzf(adRequestInfoParcel);
        zzhn.zza zzF = zzhc.zzIN.zzF(context);
        if (zzjg != null) {
            try {
                zzin.v("Waiting for app index fetching task.");
                zzjg.get(zzbt.zzwr.get().longValue(), TimeUnit.MILLISECONDS);
                zzin.v("App index fetching task completed.");
            } catch (InterruptedException | ExecutionException e) {
                zzin.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e2) {
                zzin.zzaI("Timed out waiting for app index fetching task");
            }
        }
        JSONObject zza2 = zzhe.zza(context, adRequestInfoParcel, zzE, zzF, zzd, zzbm, token, zzf, zza, bundle);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza2.put("request_id", uuid);
            } catch (JSONException e3) {
            }
        }
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza2.toString();
        zzcb.zza(zzdB, "arc");
        final zzbz zzdB2 = zzcb.zzdB();
        if (zzbt.zzvC.get().booleanValue()) {
            final zzeg zzeg2 = zzeg;
            final zzhf zzhf2 = zzhf;
            final zzcb zzcb2 = zzcb;
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    zzeg.zzd zzer = zzeg2.zzer();
                    zzhf2.zzb(zzer);
                    zzcb2.zza(zzdB2, "rwc");
                    final zzbz zzdB = zzcb2.zzdB();
                    zzer.zza(new zzji.zzc<zzeh>() {
                        /* renamed from: zzd */
                        public void zze(zzeh zzeh) {
                            zzcb2.zza(zzdB, "jsf");
                            zzcb2.zzdC();
                            zzeh.zza("/invalidRequest", zzhf2.zzJk);
                            zzeh.zza("/loadAdURL", zzhf2.zzJl);
                            try {
                                zzeh.zze("AFMA_buildAdURL", jSONObject);
                            } catch (Exception e) {
                                zzin.zzb("Error requesting an ad url", e);
                            }
                        }
                    }, new zzji.zza() {
                        public void run() {
                        }
                    });
                }
            });
        } else {
            final Context context3 = context;
            final AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel;
            final zzbz zzbz = zzdB2;
            final String str = jSONObject;
            final zzbm zzbm2 = zzbm;
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    zzjp zza = zzr.zzbD().zza(context3, new AdSizeParcel(), false, false, (zzan) null, adRequestInfoParcel3.zzrl);
                    if (zzr.zzbF().zzhi()) {
                        zza.clearCache(true);
                    }
                    zza.getWebView().setWillNotDraw(true);
                    zzhf.zzh(zza);
                    zzcb.zza(zzbz, "rwc");
                    zzjq.zza zzb = zzhd.zza(str, zzcb, zzcb.zzdB());
                    zzjq zzhU = zza.zzhU();
                    zzhU.zza("/invalidRequest", zzhf.zzJk);
                    zzhU.zza("/loadAdURL", zzhf.zzJl);
                    zzhU.zza("/log", zzde.zzzf);
                    zzhU.zza(zzb);
                    zzin.zzaI("Loading the JS library.");
                    zza.loadUrl(zzbm2.zzdp());
                }
            });
        }
        try {
            zzhi zzhi = zzhf.zzgC().get(10, TimeUnit.SECONDS);
            if (zzhi == null) {
                return new AdResponseParcel(0);
            }
            if (zzhi.getErrorCode() != -2) {
                return new AdResponseParcel(zzhi.getErrorCode());
            }
            if (zzcb.zzdE() != null) {
                zzcb.zza(zzcb.zzdE(), "rur");
            }
            String str2 = null;
            if (zzhi.zzgG()) {
                str2 = zzhc.zzIH.zzaz(adRequestInfoParcel.zzHu.packageName);
            }
            AdResponseParcel zza3 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzrl.afmaVersion, zzhi.getUrl(), str2, zzhi.zzgH() ? token : null, zzhi, zzcb, zzhc);
            if (zza3.zzIf == 1) {
                zzhc.zzIL.clearToken(context, adRequestInfoParcel.zzHu.packageName);
            }
            zzcb.zza(zzdB, "tts");
            zza3.zzIh = zzcb.zzdD();
            final zzhc zzhc3 = zzhc;
            final Context context4 = context;
            final AdRequestInfoParcel adRequestInfoParcel4 = adRequestInfoParcel;
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    r0.zzIJ.zza(r1, zzhf, r2.zzrl);
                }
            });
            return zza3;
        } catch (Exception e4) {
            return new AdResponseParcel(0);
        } finally {
            final zzhc zzhc4 = zzhc;
            final Context context5 = context;
            final AdRequestInfoParcel adRequestInfoParcel5 = adRequestInfoParcel;
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    zzhc4.zzIJ.zza(context5, zzhf, adRequestInfoParcel5.zzrl);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
        r5 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r4 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r11 = com.google.android.gms.ads.internal.zzr.zzbC().zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        com.google.android.gms.internal.zzna.zzb(r4);
        zza(r5, r10, r11, r3);
        r7.zzb(r5, r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r19 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d1, code lost:
        r19.zza(r6, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00de, code lost:
        r3 = r7.zzj(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e5, code lost:
        if (r20 == null) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e7, code lost:
        r20.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012b, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012c, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        com.google.android.gms.internal.zzna.zzb(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0130, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014d, code lost:
        com.google.android.gms.internal.zzin.zzaK("No location header to follow redirect.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015b, code lost:
        if (r20 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015d, code lost:
        r20.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0170, code lost:
        com.google.android.gms.internal.zzin.zzaK("Too many redirects.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017e, code lost:
        if (r20 == null) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0180, code lost:
        r20.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        com.google.android.gms.internal.zzin.zzaK("Received error HTTP response code: " + r3);
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a9, code lost:
        if (r20 == null) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ab, code lost:
        r20.zzIO.zzgK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cb, code lost:
        r3 = th;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00f7=Splitter:B:46:0x00f7, B:83:0x018a=Splitter:B:83:0x018a, B:59:0x012d=Splitter:B:59:0x012d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r12, android.content.Context r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zzhi r18, com.google.android.gms.internal.zzcb r19, com.google.android.gms.internal.zzhc r20) {
        /*
            if (r19 == 0) goto L_0x00f0
            com.google.android.gms.internal.zzbz r2 = r19.zzdB()
            r6 = r2
        L_0x0007:
            com.google.android.gms.internal.zzhg r7 = new com.google.android.gms.internal.zzhg     // Catch:{ IOException -> 0x0109 }
            r7.<init>(r12)     // Catch:{ IOException -> 0x0109 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0109 }
            r2.<init>()     // Catch:{ IOException -> 0x0109 }
            java.lang.String r3 = "AdRequestServiceImpl: Sending request: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x0109 }
            java.lang.StringBuilder r2 = r2.append(r15)     // Catch:{ IOException -> 0x0109 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0109 }
            com.google.android.gms.internal.zzin.zzaI(r2)     // Catch:{ IOException -> 0x0109 }
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x0109 }
            r3.<init>(r15)     // Catch:{ IOException -> 0x0109 }
            com.google.android.gms.internal.zzmq r2 = com.google.android.gms.ads.internal.zzr.zzbG()     // Catch:{ IOException -> 0x0109 }
            long r8 = r2.elapsedRealtime()     // Catch:{ IOException -> 0x0109 }
            r2 = 0
            r4 = r2
            r5 = r3
        L_0x0032:
            if (r20 == 0) goto L_0x003b
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgJ()     // Catch:{ IOException -> 0x0109 }
        L_0x003b:
            java.net.URLConnection r2 = r5.openConnection()     // Catch:{ IOException -> 0x0109 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0109 }
            com.google.android.gms.internal.zzir r3 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x00fb }
            r10 = 0
            r3.zza((android.content.Context) r13, (java.lang.String) r14, (boolean) r10, (java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x00fb }
            boolean r3 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = "x-afma-drt-cookie"
            r0 = r16
            r2.addRequestProperty(r3, r0)     // Catch:{ all -> 0x00fb }
        L_0x0056:
            boolean r3 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x0076
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r3.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r10 = "Authorization"
            java.lang.String r11 = "Bearer "
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ all -> 0x00fb }
            r0 = r17
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fb }
            r2.addRequestProperty(r10, r3)     // Catch:{ all -> 0x00fb }
        L_0x0076:
            if (r18 == 0) goto L_0x00a1
            java.lang.String r3 = r18.zzgF()     // Catch:{ all -> 0x00fb }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x00a1
            r3 = 1
            r2.setDoOutput(r3)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r18.zzgF()     // Catch:{ all -> 0x00fb }
            byte[] r10 = r3.getBytes()     // Catch:{ all -> 0x00fb }
            int r3 = r10.length     // Catch:{ all -> 0x00fb }
            r2.setFixedLengthStreamingMode(r3)     // Catch:{ all -> 0x00fb }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f4 }
            java.io.OutputStream r11 = r2.getOutputStream()     // Catch:{ all -> 0x00f4 }
            r3.<init>(r11)     // Catch:{ all -> 0x00f4 }
            r3.write(r10)     // Catch:{ all -> 0x01c7 }
            com.google.android.gms.internal.zzna.zzb(r3)     // Catch:{ all -> 0x00fb }
        L_0x00a1:
            int r3 = r2.getResponseCode()     // Catch:{ all -> 0x00fb }
            java.util.Map r10 = r2.getHeaderFields()     // Catch:{ all -> 0x00fb }
            r11 = 200(0xc8, float:2.8E-43)
            if (r3 < r11) goto L_0x0131
            r11 = 300(0x12c, float:4.2E-43)
            if (r3 >= r11) goto L_0x0131
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00fb }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x012b }
            java.io.InputStream r11 = r2.getInputStream()     // Catch:{ all -> 0x012b }
            r4.<init>(r11)     // Catch:{ all -> 0x012b }
            com.google.android.gms.internal.zzir r11 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x01cb }
            java.lang.String r11 = r11.zza((java.io.InputStreamReader) r4)     // Catch:{ all -> 0x01cb }
            com.google.android.gms.internal.zzna.zzb(r4)     // Catch:{ all -> 0x00fb }
            zza(r5, r10, r11, r3)     // Catch:{ all -> 0x00fb }
            r7.zzb(r5, r10, r11)     // Catch:{ all -> 0x00fb }
            if (r19 == 0) goto L_0x00de
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x00fb }
            r4 = 0
            java.lang.String r5 = "ufe"
            r3[r4] = r5     // Catch:{ all -> 0x00fb }
            r0 = r19
            r0.zza(r6, r3)     // Catch:{ all -> 0x00fb }
        L_0x00de:
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = r7.zzj((long) r8)     // Catch:{ all -> 0x00fb }
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x00ee
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x00ee:
            r2 = r3
        L_0x00ef:
            return r2
        L_0x00f0:
            r2 = 0
            r6 = r2
            goto L_0x0007
        L_0x00f4:
            r3 = move-exception
            r4 = 0
            r5 = r3
        L_0x00f7:
            com.google.android.gms.internal.zzna.zzb(r4)     // Catch:{ all -> 0x00fb }
            throw r5     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x0108
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x0108:
            throw r3     // Catch:{ IOException -> 0x0109 }
        L_0x0109:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error while connecting to ad server: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.zzin.zzaK(r2)
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r3 = 2
            r2.<init>(r3)
            goto L_0x00ef
        L_0x012b:
            r3 = move-exception
            r4 = 0
        L_0x012d:
            com.google.android.gms.internal.zzna.zzb(r4)     // Catch:{ all -> 0x00fb }
            throw r3     // Catch:{ all -> 0x00fb }
        L_0x0131:
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00fb }
            r11 = 0
            zza(r5, r10, r11, r3)     // Catch:{ all -> 0x00fb }
            r5 = 300(0x12c, float:4.2E-43)
            if (r3 < r5) goto L_0x018a
            r5 = 400(0x190, float:5.6E-43)
            if (r3 >= r5) goto L_0x018a
            java.lang.String r3 = "Location"
            java.lang.String r3 = r2.getHeaderField(r3)     // Catch:{ all -> 0x00fb }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00fb }
            if (r5 == 0) goto L_0x0166
            java.lang.String r3 = "No location header to follow redirect."
            com.google.android.gms.internal.zzin.zzaK(r3)     // Catch:{ all -> 0x00fb }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x00fb }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x00fb }
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x0164
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x0164:
            r2 = r3
            goto L_0x00ef
        L_0x0166:
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x00fb }
            r5.<init>(r3)     // Catch:{ all -> 0x00fb }
            int r3 = r4 + 1
            r4 = 5
            if (r3 <= r4) goto L_0x01b5
            java.lang.String r3 = "Too many redirects."
            com.google.android.gms.internal.zzin.zzaK(r3)     // Catch:{ all -> 0x00fb }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x00fb }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x00fb }
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x0187
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x0187:
            r2 = r3
            goto L_0x00ef
        L_0x018a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r4.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r5 = "Received error HTTP response code: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00fb }
            com.google.android.gms.internal.zzin.zzaK(r3)     // Catch:{ all -> 0x00fb }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x00fb }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x00fb }
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x01b2
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x01b2:
            r2 = r3
            goto L_0x00ef
        L_0x01b5:
            r7.zzj((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r10)     // Catch:{ all -> 0x00fb }
            r2.disconnect()     // Catch:{ IOException -> 0x0109 }
            if (r20 == 0) goto L_0x01c4
            r0 = r20
            com.google.android.gms.internal.zzhm r2 = r0.zzIO     // Catch:{ IOException -> 0x0109 }
            r2.zzgK()     // Catch:{ IOException -> 0x0109 }
        L_0x01c4:
            r4 = r3
            goto L_0x0032
        L_0x01c7:
            r5 = move-exception
            r4 = r3
            goto L_0x00f7
        L_0x01cb:
            r3 = move-exception
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzhi, com.google.android.gms.internal.zzcb, com.google.android.gms.internal.zzhc):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzhd zza(Context context, zzbm zzbm, zzhc zzhc) {
        zzhd zzhd;
        synchronized (zzqy) {
            if (zzIQ == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzIQ = new zzhd(context, zzbm, zzhc);
            }
            zzhd = zzIQ;
        }
        return zzhd;
    }

    /* access modifiers changed from: private */
    public static zzjq.zza zza(final String str, final zzcb zzcb, final zzbz zzbz) {
        return new zzjq.zza() {
            public void zza(zzjp zzjp, boolean z) {
                zzcb.zza(zzbz, "jsf");
                zzcb.zzdC();
                zzjp.zze("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzin.zzQ(2)) {
            zzin.v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String next : map.keySet()) {
                    zzin.v("    " + next + ":");
                    for (String str3 : map.get(next)) {
                        zzin.v("      " + str3);
                    }
                }
            }
            zzin.v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzin.v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzin.v("    null");
            }
            zzin.v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzk zzk) {
        zzr.zzbF().zzb(this.mContext, adRequestInfoParcel.zzrl);
        zziq.zza((Runnable) new Runnable() {
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzhd.this.zzd(adRequestInfoParcel);
                } catch (Exception e) {
                    zzr.zzbF().zzb((Throwable) e, true);
                    zzin.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzk.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzin.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzIT, this.zzIS, this.zzIR, adRequestInfoParcel);
    }
}
