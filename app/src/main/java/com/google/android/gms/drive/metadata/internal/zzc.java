package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Parcelable.Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, customProperty.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) customProperty.zzasN, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcf */
    public CustomProperty createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    customPropertyKey = (CustomPropertyKey) zza.zza(parcel, zzat, CustomPropertyKey.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzea */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
