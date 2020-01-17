package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzhb
public final class zzfk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzez zzCK;

    public zzfk(zzez zzez) {
        this.zzCK = zzez;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onClick.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onClick must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClicked();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onDismissScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onDismissScreen must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        zzb.zzaI("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdFailedToLoad(zzfl.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onLeaveApplication.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onLeaveApplication must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onPresentScreen.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onPresentScreen must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaI("Adapter called onReceivedAd.");
        if (!zzn.zzcS().zzhJ()) {
            zzb.zzaK("onReceivedAd must be called on the main UI thread.");
            zza.zzMS.post(new Runnable() {
                public void run() {
                    try {
                        zzfk.this.zzCK.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzCK.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
