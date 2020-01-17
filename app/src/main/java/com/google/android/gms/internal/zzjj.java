package com.google.android.gms.internal;

import com.google.android.gms.internal.zzji;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzhb
public class zzjj<T> implements zzji<T> {
    protected int zzBc = 0;
    protected final BlockingQueue<zzjj<T>.zza> zzNq = new LinkedBlockingQueue();
    protected T zzNr;
    private final Object zzpV = new Object();

    class zza {
        public final zzji.zzc<T> zzNs;
        public final zzji.zza zzNt;

        public zza(zzji.zzc<T> zzc, zzji.zza zza) {
            this.zzNs = zzc;
            this.zzNt = zza;
        }
    }

    public int getStatus() {
        return this.zzBc;
    }

    public void reject() {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzBc = -1;
            for (zza zza2 : this.zzNq) {
                zza2.zzNt.run();
            }
            this.zzNq.clear();
        }
    }

    public void zza(zzji.zzc<T> zzc, zzji.zza zza2) {
        synchronized (this.zzpV) {
            if (this.zzBc == 1) {
                zzc.zze(this.zzNr);
            } else if (this.zzBc == -1) {
                zza2.run();
            } else if (this.zzBc == 0) {
                this.zzNq.add(new zza(zzc, zza2));
            }
        }
    }

    public void zzh(T t) {
        synchronized (this.zzpV) {
            if (this.zzBc != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzNr = t;
            this.zzBc = 1;
            for (zza zza2 : this.zzNq) {
                zza2.zzNs.zze(t);
            }
            this.zzNq.clear();
        }
    }
}
