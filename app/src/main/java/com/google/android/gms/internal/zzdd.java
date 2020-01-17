package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzhb
public final class zzdd implements zzdf {
    private void zzb(zzjp zzjp, Map<String, String> map) {
        String str = map.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
        String str2 = map.get("start_label");
        String str3 = map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzin.zzaK("No timestamp given for CSI tick.");
        } else {
            try {
                long zzc = zzc(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                zzjp.zzic().zza(str, str2, zzc);
            } catch (NumberFormatException e) {
                zzin.zzd("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private long zzc(long j) {
        return (j - zzr.zzbG().currentTimeMillis()) + zzr.zzbG().elapsedRealtime();
    }

    private void zzc(zzjp zzjp, Map<String, String> map) {
        String str = map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No value given for CSI experiment.");
            return;
        }
        zzcb zzdA = zzjp.zzic().zzdA();
        if (zzdA == null) {
            zzin.zzaK("No ticker for WebView, dropping experiment ID.");
        } else {
            zzdA.zzc("e", str);
        }
    }

    private void zzd(zzjp zzjp, Map<String, String> map) {
        String str = map.get("name");
        String str2 = map.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzin.zzaK("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzin.zzaK("No name given for CSI extra.");
        } else {
            zzcb zzdA = zzjp.zzic().zzdA();
            if (zzdA == null) {
                zzin.zzaK("No ticker for WebView, dropping extra parameter.");
            } else {
                zzdA.zzc(str, str2);
            }
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        String str = map.get("action");
        if ("tick".equals(str)) {
            zzb(zzjp, map);
        } else if ("experiment".equals(str)) {
            zzc(zzjp, map);
        } else if ("extra".equals(str)) {
            zzd(zzjp, map);
        }
    }
}
