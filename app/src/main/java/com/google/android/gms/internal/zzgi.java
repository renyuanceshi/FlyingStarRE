package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgd;

@zzhb
public final class zzgi extends zzgd.zza {
    private final InAppPurchaseListener zzuO;

    public zzgi(InAppPurchaseListener inAppPurchaseListener) {
        this.zzuO = inAppPurchaseListener;
    }

    public void zza(zzgc zzgc) {
        this.zzuO.onInAppPurchaseRequested(new zzgl(zzgc));
    }
}
