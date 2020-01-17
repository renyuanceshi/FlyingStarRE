package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzq;
import java.util.HashMap;
import java.util.Map;

public class zza extends zzq.zza {
    private final BleScanCallback zzaAy;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza  reason: collision with other inner class name */
    public static class C0062zza {
        private static final C0062zza zzaAz = new C0062zza();
        private final Map<BleScanCallback, zza> zzaAA = new HashMap();

        private C0062zza() {
        }

        public static C0062zza zzuJ() {
            return zzaAz;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzaAA) {
                zza = this.zzaAA.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                    this.zzaAA.put(bleScanCallback, zza);
                }
            }
            return zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzaAA) {
                zza = this.zzaAA.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                }
            }
            return zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaAy = (BleScanCallback) zzx.zzz(bleScanCallback);
    }

    public void onDeviceFound(BleDevice bleDevice) throws RemoteException {
        this.zzaAy.onDeviceFound(bleDevice);
    }

    public void onScanStopped() throws RemoteException {
        this.zzaAy.onScanStopped();
    }
}
