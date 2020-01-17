package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzcu;

@zzhb
public class zzcz extends zzcu.zza {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzyV;

    public zzcz(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzyV = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzcp zzcp) {
        this.zzyV.onCustomTemplateAdLoaded(new zzcq(zzcp));
    }
}
