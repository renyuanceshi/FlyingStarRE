package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final zzgc zzFw;
    public final Context zzFx;
    public final zzj zzFy;
    public final zzk zzrI;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzrI = (zzk) zze.zzp(zzd.zza.zzbs(iBinder));
        this.zzFw = (zzgc) zze.zzp(zzd.zza.zzbs(iBinder2));
        this.zzFx = (Context) zze.zzp(zzd.zza.zzbs(iBinder3));
        this.zzFy = (zzj) zze.zzp(zzd.zza.zzbs(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzk, zzgc zzgc, zzj zzj) {
        this.versionCode = 2;
        this.zzFx = context;
        this.zzrI = zzk;
        this.zzFw = zzgc;
        this.zzFy = zzj;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzfS() {
        return zze.zzC(this.zzFy).asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzfT() {
        return zze.zzC(this.zzrI).asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzfU() {
        return zze.zzC(this.zzFw).asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzfV() {
        return zze.zzC(this.zzFx).asBinder();
    }
}
