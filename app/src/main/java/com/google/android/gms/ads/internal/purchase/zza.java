package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel> {
    static void zza(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, gInAppPurchaseManagerInfoParcel.versionCode);
        zzb.zza(parcel, 3, gInAppPurchaseManagerInfoParcel.zzfT(), false);
        zzb.zza(parcel, 4, gInAppPurchaseManagerInfoParcel.zzfU(), false);
        zzb.zza(parcel, 5, gInAppPurchaseManagerInfoParcel.zzfV(), false);
        zzb.zza(parcel, 6, gInAppPurchaseManagerInfoParcel.zzfS(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzA */
    public GInAppPurchaseManagerInfoParcel[] newArray(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    /* renamed from: zzh */
    public GInAppPurchaseManagerInfoParcel createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 3:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 5:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 6:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder, iBinder2, iBinder3, iBinder4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
