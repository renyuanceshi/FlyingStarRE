package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzb;
import java.util.Map;

@zzhb
public class zzds implements zzdf {
    public void zza(zzjp zzjp, Map<String, String> map) {
        int i;
        zzdq zzbR = zzr.zzbR();
        if (!map.containsKey("abort")) {
            String str = map.get("src");
            if (str == null) {
                zzin.zzaK("Precache video action is missing the src parameter.");
                return;
            }
            try {
                i = Integer.parseInt(map.get("player"));
            } catch (NumberFormatException e) {
                i = 0;
            }
            String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
            if (zzbR.zze(zzjp)) {
                zzin.zzaK("Precache task already running.");
                return;
            }
            zzb.zzv(zzjp.zzhR());
            new zzdp(zzjp, zzjp.zzhR().zzpw.zza(zzjp, i, str2), str).zzgd();
        } else if (!zzbR.zzd(zzjp)) {
            zzin.zzaK("Precache abort but no preload task running.");
        }
    }
}
