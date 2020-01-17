package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzKR;

    public zzb(zza zza) {
        this.zzKR = zza;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClicked.");
        try {
            this.zzKR.zzl(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdClosed.");
        try {
            this.zzKR.zzk(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdFailedToLoad.");
        try {
            this.zzKR.zzc(zze.zzC(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzKR.zzm(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdLoaded.");
        try {
            this.zzKR.zzh(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzin.zzaI("Adapter called onAdOpened.");
        try {
            this.zzKR.zzi(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzx.zzcD("onInitializationFailed must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationFailed.");
        try {
            this.zzKR.zzb(zze.zzC(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onInitializationSucceeded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onInitializationSucceeded.");
        try {
            this.zzKR.zzg(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        zzx.zzcD("onRewarded must be called on the main UI thread.");
        zzin.zzaI("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzKR.zza(zze.zzC(mediationRewardedVideoAdAdapter), new RewardItemParcel(rewardItem));
            } catch (RemoteException e) {
                zzin.zzd("Could not call onRewarded.", e);
            }
        } else {
            this.zzKR.zza(zze.zzC(mediationRewardedVideoAdAdapter), new RewardItemParcel(mediationRewardedVideoAdAdapter.getClass().getName(), 1));
        }
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzx.zzcD("onVideoStarted must be called on the main UI thread.");
        zzin.zzaI("Adapter called onVideoStarted.");
        try {
            this.zzKR.zzj(zze.zzC(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            zzin.zzd("Could not call onVideoStarted.", e);
        }
    }
}
