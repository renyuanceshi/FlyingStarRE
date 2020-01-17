package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.internal.zzhb;
import java.lang.ref.WeakReference;

@zzhb
public final class zzg extends zzk.zza {
    private final WeakReference<zzc.zza> zzHR;

    public zzg(zzc.zza zza) {
        this.zzHR = new WeakReference<>(zza);
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zza = (zzc.zza) this.zzHR.get();
        if (zza != null) {
            zza.zzb(adResponseParcel);
        }
    }
}
