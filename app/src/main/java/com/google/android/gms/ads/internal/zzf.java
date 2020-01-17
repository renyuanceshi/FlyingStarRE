package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzav;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;

@zzhb
public class zzf extends zzc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzpE;

    public class zza {
        public zza() {
        }

        public void onClick() {
            zzf.this.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
    }

    private AdSizeParcel zzb(zzif.zza zza2) {
        AdSize zzcQ;
        if (zza2.zzLe.zzul) {
            return this.zzpj.zzrp;
        }
        String str = zza2.zzLe.zzHW;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            zzcQ = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            zzcQ = this.zzpj.zzrp.zzcQ();
        }
        return new AdSizeParcel(this.zzpj.context, zzcQ);
    }

    private boolean zzb(zzif zzif, zzif zzif2) {
        if (zzif2.zzHT) {
            View zzf = zzm.zzf(zzif2);
            if (zzf == null) {
                zzin.zzaK("Could not get mediation view");
                return false;
            }
            View nextView = this.zzpj.zzrm.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzjp) {
                    ((zzjp) nextView).destroy();
                }
                this.zzpj.zzrm.removeView(nextView);
            }
            if (!zzm.zzg(zzif2)) {
                try {
                    zzb(zzf);
                } catch (Throwable th) {
                    zzin.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(zzif2.zzKW == null || zzif2.zzED == null)) {
            zzif2.zzED.zza(zzif2.zzKW);
            this.zzpj.zzrm.removeAllViews();
            this.zzpj.zzrm.setMinimumWidth(zzif2.zzKW.widthPixels);
            this.zzpj.zzrm.setMinimumHeight(zzif2.zzKW.heightPixels);
            zzb(zzif2.zzED.getView());
        }
        if (this.zzpj.zzrm.getChildCount() > 1) {
            this.zzpj.zzrm.showNext();
        }
        if (zzif != null) {
            View nextView2 = this.zzpj.zzrm.getNextView();
            if (nextView2 instanceof zzjp) {
                ((zzjp) nextView2).zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            } else if (nextView2 != null) {
                this.zzpj.zzrm.removeView(nextView2);
            }
            this.zzpj.zzbV();
        }
        this.zzpj.zzrm.setVisibility(0);
        return true;
    }

    private void zzd(final zzif zzif) {
        if (this.zzpj.zzbW()) {
            if (zzif.zzED != null) {
                if (zzif.zzKT != null) {
                    this.zzpl.zza(this.zzpj.zzrp, zzif);
                }
                if (zzif.zzcv()) {
                    this.zzpl.zza(this.zzpj.zzrp, zzif).zza((zzav) zzif.zzED);
                } else {
                    zzif.zzED.zzhU().zza((zzjq.zzb) new zzjq.zzb() {
                        public void zzbi() {
                            zzf.this.zzpl.zza(zzf.this.zzpj.zzrp, zzif).zza((zzav) zzif.zzED);
                        }
                    });
                }
            }
        } else if (this.zzpj.zzrK != null && zzif.zzKT != null) {
            this.zzpl.zza(this.zzpj.zzrp, zzif, this.zzpj.zzrK);
        }
    }

    public void onGlobalLayout() {
        zze(this.zzpj.zzrq);
    }

    public void onScrollChanged() {
        zze(this.zzpj.zzrq);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzx.zzcD("setManualImpressionsEnabled must be called from the main thread.");
        this.zzpE = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* access modifiers changed from: protected */
    public zzjp zza(zzif.zza zza2, zze zze) {
        if (this.zzpj.zzrp.zzul) {
            this.zzpj.zzrp = zzb(zza2);
        }
        return super.zza(zza2, zze);
    }

    /* access modifiers changed from: protected */
    public void zza(zzif zzif, boolean z) {
        super.zza(zzif, z);
        if (zzm.zzg(zzif)) {
            zzm.zza(zzif, new zza());
        }
    }

    public boolean zza(zzif zzif, zzif zzif2) {
        if (!super.zza(zzif, zzif2)) {
            return false;
        }
        if (!this.zzpj.zzbW() || zzb(zzif, zzif2)) {
            if (zzif2.zzIm) {
                zze(zzif2);
                zzjk.zza((View) this.zzpj.zzrm, (ViewTreeObserver.OnGlobalLayoutListener) this);
                zzjk.zza((View) this.zzpj.zzrm, (ViewTreeObserver.OnScrollChangedListener) this);
            } else if (!this.zzpj.zzbX() || zzbt.zzxg.get().booleanValue()) {
                zza(zzif2, false);
            }
            zzd(zzif2);
            return true;
        }
        zzf(0);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzaV() {
        boolean z = true;
        if (!zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET")) {
            zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzr.zzbC().zzI(this.zzpj.context)) {
            zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.setVisibility(0);
        }
        return z;
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    /* access modifiers changed from: package-private */
    public AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zztH == this.zzpE) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zztC, adRequestParcel.extras, adRequestParcel.zztD, adRequestParcel.zztE, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztH || this.zzpE, adRequestParcel.zztI, adRequestParcel.zztJ, adRequestParcel.zztK, adRequestParcel.zztL, adRequestParcel.zztM, adRequestParcel.zztN, adRequestParcel.zztO, adRequestParcel.zztP, adRequestParcel.zztQ, adRequestParcel.zztR);
    }

    /* access modifiers changed from: package-private */
    public void zze(zzif zzif) {
        if (zzif != null && !zzif.zzKU && this.zzpj.zzrm != null && zzr.zzbC().zza((View) this.zzpj.zzrm, this.zzpj.context) && this.zzpj.zzrm.getGlobalVisibleRect(new Rect(), (Point) null)) {
            zza(zzif, false);
            zzif.zzKU = true;
        }
    }
}
