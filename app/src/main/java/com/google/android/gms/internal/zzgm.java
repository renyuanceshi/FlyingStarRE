package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzgh;

@zzhb
public final class zzgm extends zzgh.zza {
    private final PlayStorePurchaseListener zzuP;

    public zzgm(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzuP = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String str) {
        return this.zzuP.isValidPurchase(str);
    }

    public void zza(zzgg zzgg) {
        this.zzuP.onInAppPurchaseFinished(new zzgk(zzgg));
    }
}
