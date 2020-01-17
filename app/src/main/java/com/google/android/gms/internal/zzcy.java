package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzct;

@zzhb
public class zzcy extends zzct.zza {
    private final NativeCustomTemplateAd.OnCustomClickListener zzyU;

    public zzcy(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzyU = onCustomClickListener;
    }

    public void zza(zzcp zzcp, String str) {
        this.zzyU.onCustomClick(new zzcq(zzcp), str);
    }
}
