package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class zzay<T> {
    private final Map<T, zzbq<T>> zzaxd = new HashMap();

    private static class zza<T> extends zzbo.zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zza(Map<T, zzbq<T>> map, T t, zza.zzb<Status> zzb) {
            super(zzb);
            this.zzbsM = new WeakReference<>(map);
            this.zzbsN = new WeakReference<>(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbq zzbq = (zzbq) map.remove(obj);
                    if (zzbq != null) {
                        zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    private static class zzb<T> extends zzbo.zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zzb(Map<T, zzbq<T>> map, T t, zza.zzb<Status> zzb) {
            super(zzb);
            this.zzbsM = new WeakReference<>(map);
            this.zzbsN = new WeakReference<>(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbsM.get();
            Object obj = this.zzbsN.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbq zzbq = (zzbq) map.remove(obj);
                    if (zzbq != null) {
                        zzbq.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzay() {
    }

    public void zza(zzbp zzbp, zza.zzb<Status> zzb2, T t) throws RemoteException {
        synchronized (this.zzaxd) {
            zzbq remove = this.zzaxd.remove(t);
            if (remove == null) {
                zzb2.zzs(new Status(4002));
                return;
            }
            remove.clear();
            ((zzax) zzbp.zzqJ()).zza((zzav) new zzb(this.zzaxd, t, zzb2), new RemoveListenerRequest(remove));
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.wearable.internal.zzbp r5, com.google.android.gms.common.api.internal.zza.zzb<com.google.android.gms.common.api.Status> r6, T r7, com.google.android.gms.wearable.internal.zzbq<T> r8) throws android.os.RemoteException {
        /*
            r4 = this;
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbq<T>> r1 = r4.zzaxd
            monitor-enter(r1)
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbq<T>> r0 = r4.zzaxd     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0033 }
            r2 = 4001(0xfa1, float:5.607E-42)
            r0.<init>(r2)     // Catch:{ all -> 0x0033 }
            r6.zzs(r0)     // Catch:{ all -> 0x0033 }
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
        L_0x0016:
            return
        L_0x0017:
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbq<T>> r0 = r4.zzaxd     // Catch:{ all -> 0x0033 }
            r0.put(r7, r8)     // Catch:{ all -> 0x0033 }
            android.os.IInterface r0 = r5.zzqJ()     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.zzax r0 = (com.google.android.gms.wearable.internal.zzax) r0     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.zzay$zza r2 = new com.google.android.gms.wearable.internal.zzay$zza     // Catch:{ RemoteException -> 0x0036 }
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbq<T>> r3 = r4.zzaxd     // Catch:{ RemoteException -> 0x0036 }
            r2.<init>(r3, r7, r6)     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.AddListenerRequest r3 = new com.google.android.gms.wearable.internal.AddListenerRequest     // Catch:{ RemoteException -> 0x0036 }
            r3.<init>(r8)     // Catch:{ RemoteException -> 0x0036 }
            r0.zza((com.google.android.gms.wearable.internal.zzav) r2, (com.google.android.gms.wearable.internal.AddListenerRequest) r3)     // Catch:{ RemoteException -> 0x0036 }
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0016
        L_0x0033:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            r0 = move-exception
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbq<T>> r2 = r4.zzaxd     // Catch:{ all -> 0x0033 }
            r2.remove(r7)     // Catch:{ all -> 0x0033 }
            throw r0     // Catch:{ all -> 0x0033 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzay.zza(com.google.android.gms.wearable.internal.zzbp, com.google.android.gms.common.api.internal.zza$zzb, java.lang.Object, com.google.android.gms.wearable.internal.zzbq):void");
    }

    public void zzev(IBinder iBinder) {
        synchronized (this.zzaxd) {
            zzax zzeu = zzax.zza.zzeu(iBinder);
            zzbo.zzo zzo = new zzbo.zzo();
            for (Map.Entry next : this.zzaxd.entrySet()) {
                zzbq zzbq = (zzbq) next.getValue();
                try {
                    zzeu.zza((zzav) zzo, new AddListenerRequest(zzbq));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + next.getKey() + "/" + zzbq);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + next.getKey() + "/" + zzbq);
                }
            }
        }
    }
}
