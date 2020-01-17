package com.google.android.gms.ads.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzax;
import com.google.android.gms.internal.zzbc;
import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhr;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzin;
import java.util.HashSet;

@zzhb
public abstract class zza extends zzu.zza implements com.google.android.gms.ads.internal.client.zza, zzp, zza.C0012zza, zzdb, zzgr.zza, zzij {
    protected zzcb zzpe;
    protected zzbz zzpf;
    protected zzbz zzpg;
    protected boolean zzph = false;
    protected final zzq zzpi;
    protected final zzs zzpj;
    protected transient AdRequestParcel zzpk;
    protected final zzax zzpl;
    protected final zzd zzpm;

    zza(zzs zzs, zzq zzq, zzd zzd) {
        this.zzpj = zzs;
        this.zzpi = zzq == null ? new zzq(this) : zzq;
        this.zzpm = zzd;
        zzr.zzbC().zzJ(this.zzpj.context);
        zzr.zzbF().zzb(this.zzpj.context, this.zzpj.zzrl);
        this.zzpl = zzr.zzbF().zzhh();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!zze.zzap(this.zzpj.context) || adRequestParcel.zztK == null) ? adRequestParcel : new zzf(adRequestParcel).zza((Location) null).zzcN();
    }

    public void destroy() {
        zzx.zzcD("destroy must be called on the main UI thread.");
        this.zzpi.cancel();
        this.zzpl.zzj(this.zzpj.zzrq);
        this.zzpj.destroy();
    }

    public boolean isLoading() {
        return this.zzph;
    }

    public boolean isReady() {
        zzx.zzcD("isLoaded must be called on the main UI thread.");
        return this.zzpj.zzrn == null && this.zzpj.zzro == null && this.zzpj.zzrq != null;
    }

    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzin.zzaI("Pinging click URLs.");
        this.zzpj.zzrs.zzgT();
        if (this.zzpj.zzrq.zzBQ != null) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzBQ);
        }
        if (this.zzpj.zzrt != null) {
            try {
                this.zzpj.zzrt.onAdClicked();
            } catch (RemoteException e) {
                zzin.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, String str2) {
        if (this.zzpj.zzrv != null) {
            try {
                this.zzpj.zzrv.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzin.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        zzx.zzcD("setUserId must be called on the main UI thread.");
        this.zzpj.setUserId(str);
    }

    public void stopLoading() {
        zzx.zzcD("stopLoading must be called on the main UI thread.");
        this.zzph = false;
        this.zzpj.zzf(true);
    }

    /* access modifiers changed from: package-private */
    public Bundle zza(zzbf zzbf) {
        String zzhf;
        String str;
        Bundle bundle = null;
        if (zzbf != null) {
            if (zzbf.zzcK()) {
                zzbf.wakeup();
            }
            zzbc zzcI = zzbf.zzcI();
            if (zzcI != null) {
                zzhf = zzcI.zzcy();
                str = zzcI.zzcz();
                zzin.zzaI("In AdManager: loadAd, " + zzcI.toString());
                if (zzhf != null) {
                    zzr.zzbF().zzaA(zzhf);
                }
            } else {
                zzhf = zzr.zzbF().zzhf();
                str = null;
            }
            if (zzhf != null) {
                bundle = new Bundle(1);
                bundle.putString("fingerprint", zzhf);
                if (!zzhf.equals(str)) {
                    bundle.putString("v_fp", str);
                }
            }
        }
        return bundle;
    }

    public void zza(AdSizeParcel adSizeParcel) {
        zzx.zzcD("setAdSize must be called on the main UI thread.");
        this.zzpj.zzrp = adSizeParcel;
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || this.zzpj.zzrL != 0)) {
            this.zzpj.zzrq.zzED.zza(adSizeParcel);
        }
        if (this.zzpj.zzrm != null) {
            if (this.zzpj.zzrm.getChildCount() > 1) {
                this.zzpj.zzrm.removeView(this.zzpj.zzrm.getNextView());
            }
            this.zzpj.zzrm.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzpj.zzrm.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzpj.zzrm.requestLayout();
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zzp zzp) {
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzrt = zzp;
    }

    public void zza(zzq zzq) {
        zzx.zzcD("setAdListener must be called on the main UI thread.");
        this.zzpj.zzru = zzq;
    }

    public void zza(zzw zzw) {
        zzx.zzcD("setAppEventListener must be called on the main UI thread.");
        this.zzpj.zzrv = zzw;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzx zzx) {
        zzx.zzcD("setCorrelationIdProvider must be called on the main UI thread");
        this.zzpj.zzrw = zzx;
    }

    public void zza(zzd zzd) {
        zzx.zzcD("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzpj.zzrF = zzd;
    }

    /* access modifiers changed from: protected */
    public void zza(RewardItemParcel rewardItemParcel) {
        if (this.zzpj.zzrF != null) {
            String str = "";
            int i = 0;
            if (rewardItemParcel != null) {
                try {
                    str = rewardItemParcel.type;
                    i = rewardItemParcel.zzKS;
                } catch (RemoteException e) {
                    zzin.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                    return;
                }
            }
            this.zzpj.zzrF.zza(new zzhr(str, i));
        }
    }

    public void zza(zzcf zzcf) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzgd zzgd) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzgh zzgh, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(zzif.zza zza) {
        if (zza.zzLe.zzHX != -1 && !TextUtils.isEmpty(zza.zzLe.zzIh)) {
            long zzp = zzp(zza.zzLe.zzIh);
            if (zzp != -1) {
                zzbz zzb = this.zzpe.zzb(zzp + zza.zzLe.zzHX);
                this.zzpe.zza(zzb, "stc");
            }
        }
        this.zzpe.zzN(zza.zzLe.zzIh);
        this.zzpe.zza(this.zzpf, "arf");
        this.zzpg = this.zzpe.zzdB();
        this.zzpe.zzc("gqi", zza.zzLe.zzIi);
        this.zzpj.zzrn = null;
        this.zzpj.zzrr = zza;
        zza(zza, this.zzpe);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzif.zza zza, zzcb zzcb);

    public void zza(HashSet<zzig> hashSet) {
        this.zzpj.zza(hashSet);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(AdRequestParcel adRequestParcel, zzcb zzcb);

    /* access modifiers changed from: package-private */
    public boolean zza(zzif zzif) {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzif zzif, zzif zzif2);

    /* access modifiers changed from: package-private */
    public void zzaL() {
        this.zzpe = new zzcb(zzbt.zzwg.get().booleanValue(), "load_ad", this.zzpj.zzrp.zzuh);
        this.zzpf = new zzbz(-1, (String) null, (zzbz) null);
        this.zzpg = new zzbz(-1, (String) null, (zzbz) null);
    }

    public com.google.android.gms.dynamic.zzd zzaM() {
        zzx.zzcD("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.zze.zzC(this.zzpj.zzrm);
    }

    public AdSizeParcel zzaN() {
        zzx.zzcD("getAdSize must be called on the main UI thread.");
        if (this.zzpj.zzrp == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.zzpj.zzrp);
    }

    public void zzaO() {
        zzaR();
    }

    public void zzaP() {
        zzx.zzcD("recordManualImpression must be called on the main UI thread.");
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzin.zzaI("Pinging manual tracking URLs.");
        if (this.zzpj.zzrq.zzHV != null && !this.zzpj.zzrq.zzLc) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzHV);
            this.zzpj.zzrq.zzLc = true;
        }
    }

    /* access modifiers changed from: protected */
    public void zzaQ() {
        zzin.zzaJ("Ad closing.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdClosed();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaR() {
        zzin.zzaJ("Ad leaving application.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLeftApplication();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaS() {
        zzin.zzaJ("Ad opening.");
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdOpened();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaT() {
        zzin.zzaJ("Ad finished loading.");
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdLoaded();
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaU() {
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzin.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(View view) {
        this.zzpj.zzrm.addView(view, zzr.zzbE().zzhy());
    }

    public void zzb(zzif zzif) {
        this.zzpe.zza(this.zzpg, "awr");
        this.zzpj.zzro = null;
        if (!(zzif.errorCode == -2 || zzif.errorCode == 3)) {
            zzr.zzbF().zzb(this.zzpj.zzbS());
        }
        if (zzif.errorCode == -1) {
            this.zzph = false;
            return;
        }
        if (zza(zzif)) {
            zzin.zzaI("Ad refresh scheduled.");
        }
        if (zzif.errorCode != -2) {
            zzf(zzif.errorCode);
            return;
        }
        if (this.zzpj.zzrJ == null) {
            this.zzpj.zzrJ = new zzik(this.zzpj.zzrj);
        }
        this.zzpl.zzi(this.zzpj.zzrq);
        if (zza(this.zzpj.zzrq, zzif)) {
            this.zzpj.zzrq = zzif;
            this.zzpj.zzcb();
            this.zzpe.zzc("is_mraid", this.zzpj.zzrq.zzcv() ? "1" : "0");
            this.zzpe.zzc("is_mediation", this.zzpj.zzrq.zzHT ? "1" : "0");
            if (!(this.zzpj.zzrq.zzED == null || this.zzpj.zzrq.zzED.zzhU() == null)) {
                this.zzpe.zzc("is_video", this.zzpj.zzrq.zzED.zzhU().zzih() ? "1" : "0");
            }
            this.zzpe.zza(this.zzpf, "ttc");
            if (zzr.zzbF().zzhb() != null) {
                zzr.zzbF().zzhb().zza(this.zzpe);
            }
            if (this.zzpj.zzbW()) {
                zzaT();
            }
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzx.zzcD("loadAd must be called on the main UI thread.");
        AdRequestParcel zza = zza(adRequestParcel);
        if (this.zzpj.zzrn == null && this.zzpj.zzro == null) {
            zzin.zzaJ("Starting ad request.");
            zzaL();
            this.zzpf = this.zzpe.zzdB();
            if (!zza.zztF) {
                zzin.zzaJ("Use AdRequest.Builder.addTestDevice(\"" + zzn.zzcS().zzT(this.zzpj.context) + "\") to get test ads on this device.");
            }
            this.zzph = zza(zza, this.zzpe);
            return this.zzph;
        }
        if (this.zzpk != null) {
            zzin.zzaK("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzin.zzaK("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzpk = zza;
        return false;
    }

    /* access modifiers changed from: protected */
    public void zzc(zzif zzif) {
        if (zzif == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzin.zzaI("Pinging Impression URLs.");
        this.zzpj.zzrs.zzgS();
        if (zzif.zzBR != null && !zzif.zzLb) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif.zzBR);
            zzif.zzLb = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        ViewParent parent = this.zzpj.zzrm.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzr.zzbC().zzhq();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
            return;
        }
        zzin.zzaJ("Ad is not visible. Not refreshing ad.");
        this.zzpi.zzg(adRequestParcel);
    }

    /* access modifiers changed from: protected */
    public void zzf(int i) {
        zzin.zzaK("Failed to load ad: " + i);
        this.zzph = false;
        if (this.zzpj.zzru != null) {
            try {
                this.zzpj.zzru.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzin.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.zzpj.zzrF != null) {
            try {
                this.zzpj.zzrF.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzin.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long zzp(@NonNull String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzin.zzaK("Invalid index for Url fetch time in CSI latency info.");
        } catch (NumberFormatException e2) {
            zzin.zzaK("Cannot find valid format of Url fetch time in CSI latency info.");
        }
        return -1;
    }
}
