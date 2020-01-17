package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.zzau;

public final class zzt extends zzau.zza {
    private zzm zzbsk;
    private zzu zzbso;
    private final Object zzpV = new Object();

    public void zza(zzu zzu) {
        zzm zzm;
        synchronized (this.zzpV) {
            this.zzbso = (zzu) zzx.zzz(zzu);
            zzm = this.zzbsk;
        }
        if (zzm != null) {
            zzu.zzb(zzm);
        }
    }

    public void zzy(int i, int i2) {
        zzu zzu;
        zzm zzm;
        synchronized (this.zzpV) {
            zzu = this.zzbso;
            zzm = new zzm(i, i2);
            this.zzbsk = zzm;
        }
        if (zzu != null) {
            zzu.zzb(zzm);
        }
    }
}
