package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcf;

@zzhb
public final class zzcg extends zzcf.zza {
    private final OnCustomRenderedAdLoadedListener zzuQ;

    public zzcg(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuQ = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzce zzce) {
        this.zzuQ.onCustomRenderedAdLoaded(new zzcd(zzce));
    }
}
