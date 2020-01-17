package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzg extends zzd.zza {
    private final RewardedVideoAdListener zzaX;

    public zzg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzaX = rewardedVideoAdListener;
    }

    public void onRewardedVideoAdClosed() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdClosed();
        }
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdFailedToLoad(i);
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdLeftApplication();
        }
    }

    public void onRewardedVideoAdLoaded() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdLoaded();
        }
    }

    public void onRewardedVideoAdOpened() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoAdOpened();
        }
    }

    public void onRewardedVideoStarted() {
        if (this.zzaX != null) {
            this.zzaX.onRewardedVideoStarted();
        }
    }

    public void zza(zza zza) {
        if (this.zzaX != null) {
            this.zzaX.onRewarded(new zze(zza));
        }
    }
}
