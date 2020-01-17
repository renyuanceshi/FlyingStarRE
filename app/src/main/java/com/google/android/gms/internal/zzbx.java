package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzhb
public class zzbx {
    @Nullable
    public static zzbz zza(@Nullable zzcb zzcb, long j) {
        if (zzcb == null) {
            return null;
        }
        return zzcb.zzb(j);
    }

    public static boolean zza(@Nullable zzcb zzcb, @Nullable zzbz zzbz, long j, String... strArr) {
        if (zzcb == null || zzbz == null) {
            return false;
        }
        return zzcb.zza(zzbz, j, strArr);
    }

    public static boolean zza(@Nullable zzcb zzcb, @Nullable zzbz zzbz, String... strArr) {
        if (zzcb == null || zzbz == null) {
            return false;
        }
        return zzcb.zza(zzbz, strArr);
    }

    @Nullable
    public static zzbz zzb(@Nullable zzcb zzcb) {
        if (zzcb == null) {
            return null;
        }
        return zzcb.zzdB();
    }
}
