package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzl extends zzk.zza {
    private final OnDataPointListener zzaxb;

    public static class zza {
        private static final zza zzaxc = new zza();
        private final Map<OnDataPointListener, zzl> zzaxd = new HashMap();

        private zza() {
        }

        public static zza zzuu() {
            return zzaxc;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl zzl;
            synchronized (this.zzaxd) {
                zzl = this.zzaxd.get(onDataPointListener);
                if (zzl == null) {
                    zzl = new zzl(onDataPointListener);
                    this.zzaxd.put(onDataPointListener, zzl);
                }
            }
            return zzl;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl zzl;
            synchronized (this.zzaxd) {
                zzl = this.zzaxd.get(onDataPointListener);
            }
            return zzl;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl remove;
            synchronized (this.zzaxd) {
                remove = this.zzaxd.remove(onDataPointListener);
                if (remove == null) {
                    remove = new zzl(onDataPointListener);
                }
            }
            return remove;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzaxb = (OnDataPointListener) zzx.zzz(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzaxb.onDataPoint(dataPoint);
    }
}
