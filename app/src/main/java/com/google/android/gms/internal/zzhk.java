package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhj;
import java.util.WeakHashMap;

@zzhb
public final class zzhk {
    private WeakHashMap<Context, zza> zzKm = new WeakHashMap<>();

    private class zza {
        public final long zzKn = zzr.zzbG().currentTimeMillis();
        public final zzhj zzKo;

        public zza(zzhj zzhj) {
            this.zzKo = zzhj;
        }

        public boolean hasExpired() {
            return zzbt.zzwM.get().longValue() + this.zzKn < zzr.zzbG().currentTimeMillis();
        }
    }

    public zzhj zzE(Context context) {
        zza zza2 = this.zzKm.get(context);
        zzhj zzgI = (zza2 == null || zza2.hasExpired() || !zzbt.zzwL.get().booleanValue()) ? new zzhj.zza(context).zzgI() : new zzhj.zza(context, zza2.zzKo).zzgI();
        this.zzKm.put(context, new zza(zzgI));
        return zzgI;
    }
}
