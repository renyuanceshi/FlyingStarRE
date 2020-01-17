package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

@zzhb
public final class zzff implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzez zzCK;
    private NativeAdMapper zzCL;

    public zzff(zzez zzez) {
        this.zzCK = zzez;
    }

    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClicked.");
        try {
            this.zzCK.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClicked.");
        try {
            this.zzCK.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        zzx.zzcD("onAdClicked must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClicked.");
        try {
            this.zzCK.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClosed.");
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClosed.");
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        zzx.zzcD("onAdClosed must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdClosed.");
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.zzCK.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zzCK.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        zzx.zzcD("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zzCK.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        zzx.zzcD("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLeftApplication.");
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLoaded.");
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLoaded.");
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        zzx.zzcD("onAdLoaded must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdLoaded.");
        this.zzCL = nativeAdMapper;
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdOpened.");
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdOpened.");
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        zzx.zzcD("onAdOpened must be called on the main UI thread.");
        zzb.zzaI("Adapter called onAdOpened.");
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public NativeAdMapper zzeJ() {
        return this.zzCL;
    }
}
