package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzhb
public class zzeu implements zzem {
    private final Context mContext;
    private final zzeo zzCf;
    private final AdRequestInfoParcel zzCu;
    /* access modifiers changed from: private */
    public final long zzCv;
    /* access modifiers changed from: private */
    public final long zzCw;
    private final int zzCx;
    /* access modifiers changed from: private */
    public boolean zzCy = false;
    /* access modifiers changed from: private */
    public final Map<zzjg<zzes>, zzer> zzCz = new HashMap();
    /* access modifiers changed from: private */
    public final Object zzpV = new Object();
    private final zzex zzpn;
    private final boolean zzsA;
    private final boolean zzuS;

    public zzeu(Context context, AdRequestInfoParcel adRequestInfoParcel, zzex zzex, zzeo zzeo, boolean z, boolean z2, long j, long j2, int i) {
        this.mContext = context;
        this.zzCu = adRequestInfoParcel;
        this.zzpn = zzex;
        this.zzCf = zzeo;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzCv = j;
        this.zzCw = j2;
        this.zzCx = i;
    }

    private void zza(final zzjg<zzes> zzjg) {
        zzir.zzMc.post(new Runnable() {
            public void run() {
                for (zzjg zzjg : zzeu.this.zzCz.keySet()) {
                    if (zzjg != zzjg) {
                        ((zzer) zzeu.this.zzCz.get(zzjg)).cancel();
                    }
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r2.hasNext() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r0 = r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = (com.google.android.gms.internal.zzes) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r1 == null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r1.zzCo != 0) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        com.google.android.gms.internal.zzin.zzd("Exception while processing an adapter; continuing with other adapters", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return new com.google.android.gms.internal.zzes(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r2 = r5.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzes zzd(java.util.List<com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>> r5) {
        /*
            r4 = this;
            java.lang.Object r2 = r4.zzpV
            monitor-enter(r2)
            boolean r0 = r4.zzCy     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.zzes r1 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x0037 }
            r0 = -1
            r1.<init>(r0)     // Catch:{ all -> 0x0037 }
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
        L_0x000e:
            return r1
        L_0x000f:
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            java.util.Iterator r2 = r5.iterator()
        L_0x0014:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003a
            java.lang.Object r0 = r2.next()
            com.google.android.gms.internal.zzjg r0 = (com.google.android.gms.internal.zzjg) r0
            java.lang.Object r1 = r0.get()     // Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
            com.google.android.gms.internal.zzes r1 = (com.google.android.gms.internal.zzes) r1     // Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
            if (r1 == 0) goto L_0x0014
            int r3 = r1.zzCo     // Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
            if (r3 != 0) goto L_0x0014
            r4.zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) r0)     // Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
            goto L_0x000e
        L_0x0030:
            r0 = move-exception
        L_0x0031:
            java.lang.String r1 = "Exception while processing an adapter; continuing with other adapters"
            com.google.android.gms.internal.zzin.zzd(r1, r0)
            goto L_0x0014
        L_0x0037:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x003a:
            r0 = 0
            r4.zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) r0)
            com.google.android.gms.internal.zzes r1 = new com.google.android.gms.internal.zzes
            r0 = 1
            r1.<init>(r0)
            goto L_0x000e
        L_0x0045:
            r0 = move-exception
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zzd(java.util.List):com.google.android.gms.internal.zzes");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r14.zzCf.zzBY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r8 = r15.iterator();
        r6 = r0;
        r3 = null;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r8.hasNext() == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0 = r8.next();
        r10 = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r6 != 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r0.isDone() == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r1 = (com.google.android.gms.internal.zzes) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r1 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r1.zzCo != 0) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        r5 = r1.zzCt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r5 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r5.zzeD() <= r2) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r2 = r5.zzeD();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        r3 = r0;
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        r0 = java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - r10), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0077, code lost:
        r0 = 10000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1 = (com.google.android.gms.internal.zzes) r0.get(r6, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.google.android.gms.internal.zzin.zzd("Exception while processing an adapter; continuing with other adapters", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0089, code lost:
        r0 = java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - r10), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0099, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        java.lang.Math.max(r6 - (com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis() - r10), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
        zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
        if (r4 != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return new com.google.android.gms.internal.zzes(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r14.zzCf.zzBY == -1) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzes zze(java.util.List<com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>> r15) {
        /*
            r14 = this;
            r5 = 0
            r2 = -1
            r12 = 0
            java.lang.Object r1 = r14.zzpV
            monitor-enter(r1)
            boolean r0 = r14.zzCy     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.internal.zzes r4 = new com.google.android.gms.internal.zzes     // Catch:{ all -> 0x0074 }
            r0 = -1
            r4.<init>(r0)     // Catch:{ all -> 0x0074 }
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
        L_0x0012:
            return r4
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.internal.zzeo r0 = r14.zzCf
            long r0 = r0.zzBY
            r6 = -1
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0077
            com.google.android.gms.internal.zzeo r0 = r14.zzCf
            long r0 = r0.zzBY
        L_0x0022:
            java.util.Iterator r8 = r15.iterator()
            r6 = r0
            r3 = r5
            r4 = r5
        L_0x0029:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00a9
            java.lang.Object r0 = r8.next()
            com.google.android.gms.internal.zzjg r0 = (com.google.android.gms.internal.zzjg) r0
            com.google.android.gms.internal.zzmq r1 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r10 = r1.currentTimeMillis()
            int r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x007a
            boolean r1 = r0.isDone()     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.get()     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            com.google.android.gms.internal.zzes r1 = (com.google.android.gms.internal.zzes) r1     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
        L_0x004d:
            if (r1 == 0) goto L_0x0063
            int r5 = r1.zzCo     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            if (r5 != 0) goto L_0x0063
            com.google.android.gms.internal.zzfa r5 = r1.zzCt     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            if (r5 == 0) goto L_0x0063
            int r9 = r5.zzeD()     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            if (r9 <= r2) goto L_0x0063
            int r2 = r5.zzeD()     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            r3 = r0
            r4 = r1
        L_0x0063:
            com.google.android.gms.internal.zzmq r0 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r0 = r0.currentTimeMillis()
            long r0 = r0 - r10
            long r0 = r6 - r0
            long r0 = java.lang.Math.max(r0, r12)
        L_0x0072:
            r6 = r0
            goto L_0x0029
        L_0x0074:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0074 }
            throw r0
        L_0x0077:
            r0 = 10000(0x2710, double:4.9407E-320)
            goto L_0x0022
        L_0x007a:
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            java.lang.Object r1 = r0.get(r6, r1)     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            com.google.android.gms.internal.zzes r1 = (com.google.android.gms.internal.zzes) r1     // Catch:{ InterruptedException -> 0x00b8, ExecutionException -> 0x00b6, RemoteException -> 0x00ba, TimeoutException -> 0x0083 }
            goto L_0x004d
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            java.lang.String r1 = "Exception while processing an adapter; continuing with other adapters"
            com.google.android.gms.internal.zzin.zzd(r1, r0)     // Catch:{ all -> 0x0099 }
            com.google.android.gms.internal.zzmq r0 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r0 = r0.currentTimeMillis()
            long r0 = r0 - r10
            long r0 = r6 - r0
            long r0 = java.lang.Math.max(r0, r12)
            goto L_0x0072
        L_0x0099:
            r0 = move-exception
            com.google.android.gms.internal.zzmq r1 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r2 = r1.currentTimeMillis()
            long r2 = r2 - r10
            long r2 = r6 - r2
            java.lang.Math.max(r2, r12)
            throw r0
        L_0x00a9:
            r14.zza((com.google.android.gms.internal.zzjg<com.google.android.gms.internal.zzes>) r3)
            if (r4 != 0) goto L_0x0012
            com.google.android.gms.internal.zzes r4 = new com.google.android.gms.internal.zzes
            r0 = 1
            r4.<init>(r0)
            goto L_0x0012
        L_0x00b6:
            r0 = move-exception
            goto L_0x0084
        L_0x00b8:
            r0 = move-exception
            goto L_0x0084
        L_0x00ba:
            r0 = move-exception
            goto L_0x0084
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zze(java.util.List):com.google.android.gms.internal.zzes");
    }

    public void cancel() {
        synchronized (this.zzpV) {
            this.zzCy = true;
            for (zzer cancel : this.zzCz.values()) {
                cancel.cancel();
            }
        }
    }

    public zzes zzc(List<zzen> list) {
        zzin.zzaI("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        for (zzen next : list) {
            zzin.zzaJ("Trying mediation network: " + next.zzBA);
            for (String zzer : next.zzBB) {
                final zzer zzer2 = new zzer(this.mContext, zzer, this.zzpn, this.zzCf, next, this.zzCu.zzHt, this.zzCu.zzrp, this.zzCu.zzrl, this.zzsA, this.zzuS, this.zzCu.zzrD, this.zzCu.zzrH);
                zzjg zza = zziq.zza(newCachedThreadPool, new Callable<zzes>() {
                    /* renamed from: zzeE */
                    public zzes call() throws Exception {
                        synchronized (zzeu.this.zzpV) {
                            if (zzeu.this.zzCy) {
                                return null;
                            }
                            return zzer2.zza(zzeu.this.zzCv, zzeu.this.zzCw);
                        }
                    }
                });
                this.zzCz.put(zza, zzer2);
                arrayList.add(zza);
            }
        }
        switch (this.zzCx) {
            case 2:
                return zze((List<zzjg<zzes>>) arrayList);
            default:
                return zzd((List<zzjg<zzes>>) arrayList);
        }
    }
}
