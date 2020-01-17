package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzhb
public class zzev implements zzem {
    private final Context mContext;
    private zzer zzCD;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    private final long zzCv;
    private final long zzCw;
    private boolean zzCy = false;
    private final Object zzpV = new Object();
    private final zzcb zzpe;
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;

    public zzev(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzex, zzeo zzeo, boolean z, boolean z2, long j, long j2, zzcb zzcb) {
        this.mContext = context;
        this.zzCu = adRequestInfoParcel;
        this.zzpn = zzex;
        this.zzCf = zzeo;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzCv = j;
        this.zzCw = j2;
        this.zzpe = zzcb;
    }

    public void cancel() {
        synchronized (this.zzpV) {
            this.zzCy = true;
            if (this.zzCD != null) {
                this.zzCD.cancel();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a5, code lost:
        r2 = r21.zzCD.zza(r21.zzCv, r21.zzCw);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b7, code lost:
        if (r2.zzCo != 0) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b9, code lost:
        com.google.android.gms.internal.zzin.zzaI("Adapter succeeded.");
        r21.zzpe.zzc("mediation_network_succeed", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00cb, code lost:
        if (r15.isEmpty() != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cd, code lost:
        r21.zzpe.zzc("mediation_networks_fail", android.text.TextUtils.join(",", r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00dc, code lost:
        r21.zzpe.zza(r19, "mls");
        r21.zzpe.zza(r16, "ttm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0103, code lost:
        r15.add(r4);
        r21.zzpe.zza(r19, "mlf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0119, code lost:
        if (r2.zzCq == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x011b, code lost:
        com.google.android.gms.internal.zzir.zzMc.post(new com.google.android.gms.internal.zzev.AnonymousClass1(r21));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzes zzc(java.util.List<com.google.android.gms.internal.zzen> r22) {
        /*
            r21 = this;
            java.lang.String r2 = "Starting mediation."
            com.google.android.gms.internal.zzin.zzaI(r2)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0 = r21
            com.google.android.gms.internal.zzcb r2 = r0.zzpe
            com.google.android.gms.internal.zzbz r16 = r2.zzdB()
            java.util.Iterator r17 = r22.iterator()
        L_0x0016:
            boolean r2 = r17.hasNext()
            if (r2 == 0) goto L_0x0129
            java.lang.Object r7 = r17.next()
            com.google.android.gms.internal.zzen r7 = (com.google.android.gms.internal.zzen) r7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Trying mediation network: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r7.zzBA
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.zzin.zzaJ(r2)
            java.util.List<java.lang.String> r2 = r7.zzBB
            java.util.Iterator r18 = r2.iterator()
        L_0x0040:
            boolean r2 = r18.hasNext()
            if (r2 == 0) goto L_0x0016
            java.lang.Object r4 = r18.next()
            java.lang.String r4 = (java.lang.String) r4
            r0 = r21
            com.google.android.gms.internal.zzcb r2 = r0.zzpe
            com.google.android.gms.internal.zzbz r19 = r2.zzdB()
            r0 = r21
            java.lang.Object r0 = r0.zzpV
            r20 = r0
            monitor-enter(r20)
            r0 = r21
            boolean r2 = r0.zzCy     // Catch:{ all -> 0x0100 }
            if (r2 == 0) goto L_0x0069
            com.google.android.gms.internal.zzes r2 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x0100 }
            r3 = -1
            r2.<init>(r3)     // Catch:{ all -> 0x0100 }
            monitor-exit(r20)     // Catch:{ all -> 0x0100 }
        L_0x0068:
            return r2
        L_0x0069:
            com.google.android.gms.internal.zzer r2 = new com.google.android.gms.internal.zzer     // Catch:{ all -> 0x0100 }
            r0 = r21
            android.content.Context r3 = r0.mContext     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.internal.zzex r5 = r0.zzpn     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.internal.zzeo r6 = r0.zzCf     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r8 = r0.zzCu     // Catch:{ all -> 0x0100 }
            com.google.android.gms.ads.internal.client.AdRequestParcel r8 = r8.zzHt     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r9 = r0.zzCu     // Catch:{ all -> 0x0100 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r9 = r9.zzrp     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r10 = r0.zzCu     // Catch:{ all -> 0x0100 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r10 = r10.zzrl     // Catch:{ all -> 0x0100 }
            r0 = r21
            boolean r11 = r0.zzsA     // Catch:{ all -> 0x0100 }
            r0 = r21
            boolean r12 = r0.zzuS     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13 = r0.zzCu     // Catch:{ all -> 0x0100 }
            com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r13 = r13.zzrD     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r14 = r0.zzCu     // Catch:{ all -> 0x0100 }
            java.util.List<java.lang.String> r14 = r14.zzrH     // Catch:{ all -> 0x0100 }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0100 }
            r0 = r21
            r0.zzCD = r2     // Catch:{ all -> 0x0100 }
            monitor-exit(r20)     // Catch:{ all -> 0x0100 }
            r0 = r21
            com.google.android.gms.internal.zzer r2 = r0.zzCD
            r0 = r21
            long r8 = r0.zzCv
            r0 = r21
            long r10 = r0.zzCw
            com.google.android.gms.internal.zzes r2 = r2.zza((long) r8, (long) r10)
            int r3 = r2.zzCo
            if (r3 != 0) goto L_0x0103
            java.lang.String r3 = "Adapter succeeded."
            com.google.android.gms.internal.zzin.zzaI(r3)
            r0 = r21
            com.google.android.gms.internal.zzcb r3 = r0.zzpe
            java.lang.String r5 = "mediation_network_succeed"
            r3.zzc(r5, r4)
            boolean r3 = r15.isEmpty()
            if (r3 != 0) goto L_0x00dc
            r0 = r21
            com.google.android.gms.internal.zzcb r3 = r0.zzpe
            java.lang.String r4 = "mediation_networks_fail"
            java.lang.String r5 = ","
            java.lang.String r5 = android.text.TextUtils.join(r5, r15)
            r3.zzc(r4, r5)
        L_0x00dc:
            r0 = r21
            com.google.android.gms.internal.zzcb r3 = r0.zzpe
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mls"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            r0 = r21
            com.google.android.gms.internal.zzcb r3 = r0.zzpe
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "ttm"
            r4[r5] = r6
            r0 = r16
            r3.zza(r0, r4)
            goto L_0x0068
        L_0x0100:
            r2 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x0100 }
            throw r2
        L_0x0103:
            r15.add(r4)
            r0 = r21
            com.google.android.gms.internal.zzcb r3 = r0.zzpe
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mlf"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            com.google.android.gms.internal.zzey r3 = r2.zzCq
            if (r3 == 0) goto L_0x0040
            android.os.Handler r3 = com.google.android.gms.internal.zzir.zzMc
            com.google.android.gms.internal.zzev$1 r4 = new com.google.android.gms.internal.zzev$1
            r0 = r21
            r4.<init>(r2)
            r3.post(r4)
            goto L_0x0040
        L_0x0129:
            boolean r2 = r15.isEmpty()
            if (r2 != 0) goto L_0x013e
            r0 = r21
            com.google.android.gms.internal.zzcb r2 = r0.zzpe
            java.lang.String r3 = "mediation_networks_fail"
            java.lang.String r4 = ","
            java.lang.String r4 = android.text.TextUtils.join(r4, r15)
            r2.zzc(r3, r4)
        L_0x013e:
            com.google.android.gms.internal.zzes r2 = new com.google.android.gms.internal.zzes
            r3 = 1
            r2.<init>(r3)
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzev.zzc(java.util.List):com.google.android.gms.internal.zzes");
    }
}
