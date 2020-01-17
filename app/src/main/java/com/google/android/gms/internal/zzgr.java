package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzif;

@zzhb
public class zzgr {

    public interface zza {
        void zzb(zzif zzif);
    }

    public zzit zza(Context context, com.google.android.gms.ads.internal.zza zza2, zzif.zza zza3, zzan zzan, zzjp zzjp, zzex zzex, zza zza4, zzcb zzcb) {
        zzit zzgp;
        AdResponseParcel adResponseParcel = zza3.zzLe;
        if (adResponseParcel.zzHT) {
            zzgp = new zzgu(context, zza3, zzex, zza4, zzcb, zzjp);
        } else if (!adResponseParcel.zzuk) {
            zzgp = adResponseParcel.zzHZ ? new zzgp(context, zza3, zzjp, zza4) : (!zzbt.zzwu.get().booleanValue() || !zzne.zzsk() || zzne.isAtLeastL() || !zzjp.zzaN().zzui) ? new zzgs(context, zza3, zzjp, zza4) : new zzgt(context, zza3, zzjp, zza4);
        } else if (zza2 instanceof zzp) {
            zzgp = new zzgv(context, (zzp) zza2, new zzee(), zza3, zzan, zza4);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zza2 != null ? zza2.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        zzin.zzaI("AdRenderer: " + zzgp.getClass().getName());
        zzgp.zzgd();
        return zzgp;
    }

    public zzit zza(Context context, String str, zzif.zza zza2, zzht zzht) {
        zzhz zzhz = new zzhz(context, str, zza2, zzht);
        zzin.zzaI("AdRenderer: " + zzhz.getClass().getName());
        zzhz.zzgd();
        return zzhz;
    }
}
