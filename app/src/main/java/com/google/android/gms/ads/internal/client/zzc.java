package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzc extends zzq.zza {
    private final AdListener zztA;

    public zzc(AdListener adListener) {
        this.zztA = adListener;
    }

    public void onAdClosed() {
        this.zztA.onAdClosed();
    }

    public void onAdFailedToLoad(int i) {
        this.zztA.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication() {
        this.zztA.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.zztA.onAdLoaded();
    }

    public void onAdOpened() {
        this.zztA.onAdOpened();
    }
}
