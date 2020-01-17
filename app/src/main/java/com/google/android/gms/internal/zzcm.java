package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzch;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzcm extends NativeAppInstallAd {
    private final zzcl zzyM;
    private final List<NativeAd.Image> zzyN = new ArrayList();
    private final zzci zzyO;

    public zzcm(zzcl zzcl) {
        zzci zzci;
        this.zzyM = zzcl;
        try {
            List<Object> images = this.zzyM.getImages();
            if (images != null) {
                for (Object zzc : images) {
                    zzch zzc2 = zzc(zzc);
                    if (zzc2 != null) {
                        this.zzyN.add(new zzci(zzc2));
                    }
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzch zzdK = this.zzyM.zzdK();
            if (zzdK != null) {
                zzci = new zzci(zzdK);
                this.zzyO = zzci;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzci = null;
        this.zzyO = zzci;
    }

    public void destroy() {
        try {
            this.zzyM.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzyM.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzyM.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzyM.getExtras();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzyM.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public NativeAd.Image getIcon() {
        return this.zzyO;
    }

    public List<NativeAd.Image> getImages() {
        return this.zzyN;
    }

    public CharSequence getPrice() {
        try {
            return this.zzyM.getPrice();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        try {
            double starRating = this.zzyM.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    public CharSequence getStore() {
        try {
            return this.zzyM.getStore();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public zzch zzc(Object obj) {
        if (obj instanceof IBinder) {
            return zzch.zza.zzt((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdL */
    public zzd zzaH() {
        try {
            return this.zzyM.zzdL();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
