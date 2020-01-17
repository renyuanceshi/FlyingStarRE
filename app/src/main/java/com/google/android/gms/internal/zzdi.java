package com.google.android.gms.internal;

import java.util.Map;

@zzhb
public class zzdi implements zzdf {
    private final zzdj zzzy;

    public zzdi(zzdj zzdj) {
        this.zzzy = zzdj;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        float f;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat(map.get("blurRadius"));
                this.zzzy.zzd(equals);
                this.zzzy.zza(equals2, f);
            }
        } catch (NumberFormatException e) {
            zzin.zzb("Fail to parse float", e);
        }
        f = 0.0f;
        this.zzzy.zzd(equals);
        this.zzzy.zza(equals2, f);
    }
}
