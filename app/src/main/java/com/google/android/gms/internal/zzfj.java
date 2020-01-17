package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzhb
public final class zzfj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzey.zza {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzCO;
    private final NETWORK_EXTRAS zzCP;

    public zzfj(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzCO = mediationAdapter;
        this.zzCP = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class<SERVER_PARAMETERS> serverParametersType = this.zzCO.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        SERVER_PARAMETERS server_parameters = (MediationServerParameters) serverParametersType.newInstance();
        server_parameters.load(hashMap);
        return server_parameters;
    }

    public void destroy() throws RemoteException {
        try {
            this.zzCO.destroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    public zzd getView() throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return zze.zzC(((MediationBannerAdapter) this.zzCO).getBannerView());
        } catch (Throwable th) {
            zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCO).showInterstitial();
        } catch (Throwable th) {
            zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zza zza, String str2) throws RemoteException {
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzCO).requestInterstitialAd(new zzfk(zzez), (Activity) zze.zzp(zzd), zzb(str, adRequestParcel.zztG, str2), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
        zza(zzd, adSizeParcel, adRequestParcel, str, (String) null, zzez);
    }

    public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        zzb.zzaI("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.zzCO).requestBannerAd(new zzfk(zzez), (Activity) zze.zzp(zzd), zzb(str, adRequestParcel.zztG, str2), zzfl.zzb(adSizeParcel), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, String str) {
    }

    public zzfb zzeF() {
        return null;
    }

    public zzfc zzeG() {
        return null;
    }

    public Bundle zzeH() {
        return new Bundle();
    }

    public Bundle zzeI() {
        return new Bundle();
    }
}
