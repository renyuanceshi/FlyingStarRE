package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzey;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzhb
public final class zzfe extends zzey.zza {
    private final MediationAdapter zzCI;
    private zzff zzCJ;

    public zzfe(MediationAdapter mediationAdapter) {
        this.zzCI = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        zzb.zzaK("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zzCI instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzb.zzd("Could not get Server Parameters Bundle.", th);
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.zzCI.onDestroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        if (this.zzCI instanceof zzka) {
            return ((zzka) this.zzCI).getInterstitialAdapterInfo();
        }
        zzb.zzaK("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
        return new Bundle();
    }

    public zzd getView() throws RemoteException {
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return zze.zzC(((MediationBannerAdapter) this.zzCI).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public boolean isInitialized() throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzCI).isInitialized();
        } catch (Throwable th) {
            zzb.zzd("Could not check if adapter is initialized.", th);
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.zzCI.onPause();
        } catch (Throwable th) {
            zzb.zzd("Could not pause adapter.", th);
            throw new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.zzCI.onResume();
        } catch (Throwable th) {
            zzb.zzd("Could not resume adapter.", th);
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCI).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showVideo() throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzCI).showVideo();
        } catch (Throwable th) {
            zzb.zzd("Could not show rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            mediationRewardedVideoAdAdapter.loadAd(new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), zza(str, adRequestParcel.zztG, str2), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not load rewarded video ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zza zza, String str2) throws RemoteException {
        if (!(this.zzCI instanceof MediationRewardedVideoAdAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzCI;
            mediationRewardedVideoAdAdapter.initialize((Context) zze.zzp(zzd), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(zza), zza(str2, adRequestParcel.zztG, (String) null), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        if (!(this.zzCI instanceof MediationInterstitialAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzCI;
            mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzp(zzd), new zzff(zzez), zza(str, adRequestParcel.zztG, str2), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        if (!(this.zzCI instanceof MediationNativeAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationNativeAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzCI;
            zzfi zzfi = new zzfi(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, nativeAdOptionsParcel, list, adRequestParcel.zztR);
            Bundle bundle = adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.zzCJ = new zzff(zzez);
            mediationNativeAdapter.requestNativeAd((Context) zze.zzp(zzd), this.zzCJ, zza(str, adRequestParcel.zztG, str2), zzfi, bundle);
        } catch (Throwable th) {
            zzb.zzd("Could not request native ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adSizeParcel, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        if (!(this.zzCI instanceof MediationBannerAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzCI;
            mediationBannerAdapter.requestBannerAd((Context) zze.zzp(zzd), new zzff(zzez), zza(str, adRequestParcel.zztG, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzuh), new zzfd(adRequestParcel.zztC == -1 ? null : new Date(adRequestParcel.zztC), adRequestParcel.zztD, adRequestParcel.zztE != null ? new HashSet(adRequestParcel.zztE) : null, adRequestParcel.zztK, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztR), adRequestParcel.zztM != null ? adRequestParcel.zztM.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        zza(adRequestParcel, str, (String) null);
    }

    public zzfb zzeF() {
        NativeAdMapper zzeJ = this.zzCJ.zzeJ();
        if (zzeJ instanceof NativeAppInstallAdMapper) {
            return new zzfg((NativeAppInstallAdMapper) zzeJ);
        }
        return null;
    }

    public zzfc zzeG() {
        NativeAdMapper zzeJ = this.zzCJ.zzeJ();
        if (zzeJ instanceof NativeContentAdMapper) {
            return new zzfh((NativeContentAdMapper) zzeJ);
        }
        return null;
    }

    public Bundle zzeH() {
        if (this.zzCI instanceof zzjz) {
            return ((zzjz) this.zzCI).zzeH();
        }
        zzb.zzaK("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzCI.getClass().getCanonicalName());
        return new Bundle();
    }

    public Bundle zzeI() {
        return new Bundle();
    }
}
