package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfb;
import java.util.ArrayList;
import java.util.List;

@zzhb
public class zzfg extends zzfb.zza {
    private final NativeAppInstallAdMapper zzCM;

    public zzfg(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzCM = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.zzCM.getBody();
    }

    public String getCallToAction() {
        return this.zzCM.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzCM.getExtras();
    }

    public String getHeadline() {
        return this.zzCM.getHeadline();
    }

    public List getImages() {
        List<NativeAd.Image> images = this.zzCM.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzc(next.getDrawable(), next.getUri(), next.getScale()));
        }
        return arrayList;
    }

    public boolean getOverrideClickHandling() {
        return this.zzCM.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzCM.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.zzCM.getPrice();
    }

    public double getStarRating() {
        return this.zzCM.getStarRating();
    }

    public String getStore() {
        return this.zzCM.getStore();
    }

    public void recordImpression() {
        this.zzCM.recordImpression();
    }

    public void zzc(zzd zzd) {
        this.zzCM.handleClick((View) zze.zzp(zzd));
    }

    public void zzd(zzd zzd) {
        this.zzCM.trackView((View) zze.zzp(zzd));
    }

    public zzch zzdK() {
        NativeAd.Image icon = this.zzCM.getIcon();
        if (icon != null) {
            return new zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }
}
