package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.util.ArrayList;
import java.util.UUID;

@zzhb
public abstract class zzb extends zza implements zzg, zzj, zzdh, zzep {
    private final Messenger mMessenger;
    protected final zzex zzpn;
    protected transient boolean zzpo;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this(new zzs(context, adSizeParcel, str, versionInfoParcel), zzex, (zzq) null, zzd);
    }

    zzb(zzs zzs, zzex zzex, zzq zzq, zzd zzd) {
        super(zzs, zzq, zzd);
        this.zzpn = zzex;
        this.mMessenger = new Messenger(new zzga(this.zzpj.context));
        this.zzpo = false;
    }

    private AdRequestInfoParcel.zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzpj.context.getApplicationInfo();
        try {
            packageInfo = this.zzpj.context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzpj.context.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzpj.zzrm == null || this.zzpj.zzrm.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzpj.zzrm.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzpj.zzrm.getWidth();
            int height = this.zzpj.zzrm.getHeight();
            int i3 = 0;
            if (this.zzpj.zzrm.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzgZ = zzr.zzbF().zzgZ();
        this.zzpj.zzrs = new zzig(zzgZ, this.zzpj.zzrj);
        this.zzpj.zzrs.zzk(adRequestParcel);
        String zza = zzr.zzbC().zza(this.zzpj.context, (View) this.zzpj.zzrm, this.zzpj.zzrp);
        long j = 0;
        if (this.zzpj.zzrw != null) {
            try {
                j = this.zzpj.zzrw.getValue();
            } catch (RemoteException e2) {
                zzin.zzaK("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzr.zzbF().zza(this.zzpj.context, this, zzgZ);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.zzpj.zzrC.size(); i4++) {
            arrayList.add(this.zzpj.zzrC.keyAt(i4));
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.zzpj.zzrp, this.zzpj.zzrj, applicationInfo, packageInfo, zzgZ, zzr.zzbF().getSessionId(), this.zzpj.zzrl, zza2, this.zzpj.zzrH, arrayList, bundle, zzr.zzbF().zzhd(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzbt.zzdr(), this.zzpj.zzri, this.zzpj.zzrD, new CapabilityParcel(this.zzpj.zzrx != null, this.zzpj.zzry != null && zzr.zzbF().zzhj(), this.zzpm.zzpy.zzfM()), this.zzpj.zzca(), zzr.zzbC().zzbt(), zzr.zzbC().zzR(this.zzpj.context), zzr.zzbC().zzl(this.zzpj.zzrm));
    }

    public String getMediationAdapterClassName() {
        if (this.zzpj.zzrq == null) {
            return null;
        }
        return this.zzpj.zzrq.zzCr;
    }

    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzpj.zzrq.zzKV == null || this.zzpj.zzrq.zzKV.zzBQ == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzKV.zzBQ);
        }
        if (!(this.zzpj.zzrq.zzCp == null || this.zzpj.zzrq.zzCp.zzBE == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBE);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.zzpl.zzk(this.zzpj.zzrq);
    }

    public void onResume() {
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || !this.zzpj.zzbW())) {
            zzr.zzbE().zzi(this.zzpj.zzrq.zzED);
        }
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCq == null)) {
            try {
                this.zzpj.zzrq.zzCq.pause();
            } catch (RemoteException e) {
                zzin.zzaK("Could not pause mediation adapter.");
            }
        }
        this.zzpl.zzk(this.zzpj.zzrq);
        this.zzpi.pause();
    }

    public void recordImpression() {
        zza(this.zzpj.zzrq, false);
    }

    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzED == null || !this.zzpj.zzbW())) {
            zzr.zzbE().zzj(this.zzpj.zzrq.zzED);
        }
        if (!(this.zzpj.zzrq == null || this.zzpj.zzrq.zzCq == null)) {
            try {
                this.zzpj.zzrq.zzCq.resume();
            } catch (RemoteException e) {
                zzin.zzaK("Could not resume mediation adapter.");
            }
        }
        this.zzpi.resume();
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzgd zzgd) {
        zzx.zzcD("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzpj.zzrx = zzgd;
    }

    public void zza(zzgh zzgh, String str) {
        zzx.zzcD("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzpj.zzrI = new zzk(str);
        this.zzpj.zzry = zzgh;
        if (!zzr.zzbF().zzhc() && zzgh != null) {
            new zzc(this.zzpj.context, this.zzpj.zzry, this.zzpj.zzrI).zzgd();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzif zzif, boolean z) {
        if (zzif == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzif);
        if (!(zzif.zzKV == null || zzif.zzKV.zzBR == null)) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif, this.zzpj.zzrj, z, zzif.zzKV.zzBR);
        }
        if (zzif.zzCp != null && zzif.zzCp.zzBF != null) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif, this.zzpj.zzrj, z, zzif.zzCp.zzBF);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzd zzd = new zzd(str, arrayList, this.zzpj.context, this.zzpj.zzrl.afmaVersion);
        if (this.zzpj.zzrx == null) {
            zzin.zzaK("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzn.zzcS().zzU(this.zzpj.context)) {
                zzin.zzaK("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if (this.zzpj.zzry == null) {
                zzin.zzaK("PlayStorePurchaseListener is not set.");
            } else if (this.zzpj.zzrI == null) {
                zzin.zzaK("PlayStorePurchaseVerifier is not initialized.");
            } else if (this.zzpj.zzrM) {
                zzin.zzaK("An in-app purchase request is already in progress, abort");
            } else {
                this.zzpj.zzrM = true;
                try {
                    if (!this.zzpj.zzry.isValidPurchase(str)) {
                        this.zzpj.zzrM = false;
                    } else {
                        zzr.zzbM().zza(this.zzpj.context, this.zzpj.zzrl.zzNb, new GInAppPurchaseManagerInfoParcel(this.zzpj.context, this.zzpj.zzrI, zzd, this));
                    }
                } catch (RemoteException e) {
                    zzin.zzaK("Could not start In-App purchase.");
                    this.zzpj.zzrM = false;
                }
            }
        } else {
            try {
                this.zzpj.zzrx.zza(zzd);
            } catch (RemoteException e2) {
                zzin.zzaK("Could not start In-App purchase.");
            }
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, zzf zzf) {
        try {
            if (this.zzpj.zzry != null) {
                this.zzpj.zzry.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzpj.context, str, z, i, intent, zzf));
            }
        } catch (RemoteException e) {
            zzin.zzaK("Fail to invoke PlayStorePurchaseListener.");
        }
        zzir.zzMc.postDelayed(new Runnable() {
            public void run() {
                int zzd = zzr.zzbM().zzd(intent);
                zzr.zzbM();
                if (!(zzd != 0 || zzb.this.zzpj.zzrq == null || zzb.this.zzpj.zzrq.zzED == null || zzb.this.zzpj.zzrq.zzED.zzhS() == null)) {
                    zzb.this.zzpj.zzrq.zzED.zzhS().close();
                }
                zzb.this.zzpj.zzrM = false;
            }
        }, 500);
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzcb zzcb) {
        if (!zzaV()) {
            return false;
        }
        Bundle zza = zza(zzr.zzbF().zzG(this.zzpj.context));
        this.zzpi.cancel();
        this.zzpj.zzrL = 0;
        AdRequestInfoParcel.zza zza2 = zza(adRequestParcel, zza);
        zzcb.zzc("seq_num", zza2.zzHw);
        zzcb.zzc("request_id", zza2.zzHI);
        zzcb.zzc("session_id", zza2.zzHx);
        if (zza2.zzHu != null) {
            zzcb.zzc("app_version", String.valueOf(zza2.zzHu.versionCode));
        }
        this.zzpj.zzrn = zzr.zzby().zza(this.zzpj.context, zza2, this.zzpj.zzrk, this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzif zzif, boolean z) {
        if (!z && this.zzpj.zzbW()) {
            if (zzif.zzBU > 0) {
                this.zzpi.zza(adRequestParcel, zzif.zzBU);
            } else if (zzif.zzKV != null && zzif.zzKV.zzBU > 0) {
                this.zzpi.zza(adRequestParcel, zzif.zzKV.zzBU);
            } else if (!zzif.zzHT && zzif.errorCode == 2) {
                this.zzpi.zzg(adRequestParcel);
            }
        }
        return this.zzpi.zzbw();
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzif zzif) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzpk != null) {
            adRequestParcel = this.zzpk;
            this.zzpk = null;
        } else {
            adRequestParcel = zzif.zzHt;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzif, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzif zzif, zzif zzif2) {
        int i;
        int i2;
        if (!(zzif == null || zzif.zzCs == null)) {
            zzif.zzCs.zza((zzep) null);
        }
        if (zzif2.zzCs != null) {
            zzif2.zzCs.zza((zzep) this);
        }
        if (zzif2.zzKV != null) {
            i = zzif2.zzKV.zzBZ;
            i2 = zzif2.zzKV.zzCa;
        } else {
            i = 0;
            i2 = 0;
        }
        this.zzpj.zzrJ.zzg(i, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzaV() {
        return zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET") && zzr.zzbC().zzI(this.zzpj.context);
    }

    public void zzaW() {
        this.zzpl.zzi(this.zzpj.zzrq);
        this.zzpo = false;
        zzaQ();
        this.zzpj.zzrs.zzgU();
    }

    public void zzaX() {
        this.zzpo = true;
        zzaS();
    }

    public void zzaY() {
        onAdClicked();
    }

    public void zzaZ() {
        zzaW();
    }

    public void zzb(zzif zzif) {
        super.zzb(zzif);
        if (zzif.errorCode == 3 && zzif.zzKV != null && zzif.zzKV.zzBS != null) {
            zzin.zzaI("Pinging no fill URLs.");
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzif, this.zzpj.zzrj, false, zzif.zzKV.zzBS);
        }
    }

    public void zzba() {
        zzaO();
    }

    public void zzbb() {
        zzaX();
    }

    public void zzbc() {
        if (this.zzpj.zzrq != null) {
            zzin.zzaK("Mediation adapter " + this.zzpj.zzrq.zzCr + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzpj.zzrq, true);
        zzaT();
    }

    /* access modifiers changed from: protected */
    public boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzpo;
    }
}
