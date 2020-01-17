package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzcr;

@zzhb
public class zzcw extends zzcr.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzyS;

    public zzcw(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzyS = onAppInstallAdLoadedListener;
    }

    public void zza(zzcl zzcl) {
        this.zzyS.onAppInstallAdLoaded(zzb(zzcl));
    }

    /* access modifiers changed from: package-private */
    public zzcm zzb(zzcl zzcl) {
        return new zzcm(zzcl);
    }
}
