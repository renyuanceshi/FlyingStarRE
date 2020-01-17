package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.ArrayList;

public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, autocompletePredictionEntity.zzaQd, false);
        zzb.zzc(parcel, 1000, autocompletePredictionEntity.mVersionCode);
        zzb.zza(parcel, 2, autocompletePredictionEntity.zzaPH, false);
        zzb.zza(parcel, 3, autocompletePredictionEntity.zzaPd, false);
        zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaQe, false);
        zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaQf);
        zzb.zza(parcel, 6, autocompletePredictionEntity.zzaQg, false);
        zzb.zzc(parcel, 7, autocompletePredictionEntity.zzaQh, false);
        zzb.zza(parcel, 8, autocompletePredictionEntity.zzaQi, false);
        zzb.zzc(parcel, 9, autocompletePredictionEntity.zzaQj, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfk */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        ArrayList<AutocompletePredictionEntity.SubstringEntity> arrayList2 = null;
        String str3 = null;
        ArrayList<AutocompletePredictionEntity.SubstringEntity> arrayList3 = null;
        String str4 = null;
        ArrayList<AutocompletePredictionEntity.SubstringEntity> arrayList4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzat);
                    break;
                case 4:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 5:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 9:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AutocompletePredictionEntity(i, str, arrayList, i2, str2, arrayList2, str3, arrayList3, str4, arrayList4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhW */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
