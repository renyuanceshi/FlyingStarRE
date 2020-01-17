package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzew;

public class AdLoader {
    private final Context mContext;
    private final zzh zzoB;
    private final zzr zzoC;

    public static class Builder {
        private final Context mContext;
        private final zzs zzoD;

        Builder(Context context, zzs zzs) {
            this.mContext = context;
            this.zzoD = zzs;
        }

        public Builder(Context context, String str) {
            this((Context) zzx.zzb(context, (Object) "context cannot be null"), zzd.zza(context, str, new zzew()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzoD.zzbn());
            } catch (RemoteException e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzoD.zza((zzcr) new zzcw(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzoD.zza((zzcs) new zzcx(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzoD.zza(str, new zzcz(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzcy(onCustomClickListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzoD.zzb((zzq) new zzc(adListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            zzx.zzz(correlator);
            try {
                this.zzoD.zzb((com.google.android.gms.ads.internal.client.zzx) correlator.zzaF());
            } catch (RemoteException e) {
                zzb.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzoD.zza(new NativeAdOptionsParcel(nativeAdOptions));
            } catch (RemoteException e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzr zzr) {
        this(context, zzr, zzh.zzcO());
    }

    AdLoader(Context context, zzr zzr, zzh zzh) {
        this.mContext = context;
        this.zzoC = zzr;
        this.zzoB = zzh;
    }

    private void zza(zzaa zzaa) {
        try {
            this.zzoC.zzf(this.zzoB.zza(this.mContext, zzaa));
        } catch (RemoteException e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzoC.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzoC.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaE());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaE());
    }
}
