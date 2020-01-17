package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzcs;

@zzhb
public class zzcx extends zzcs.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzyT;

    public zzcx(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzyT = onContentAdLoadedListener;
    }

    public void zza(zzcn zzcn) {
        this.zzyT.onContentAdLoaded(zzb(zzcn));
    }

    /* access modifiers changed from: package-private */
    public zzco zzb(zzcn zzcn) {
        return new zzco(zzcn);
    }
}
