package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Parcelable.Creator<PersonEntity.AgeRangeEntity> {
    static void zza(PersonEntity.AgeRangeEntity ageRangeEntity, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set<Integer> set = ageRangeEntity.zzbeN;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, ageRangeEntity.mVersionCode);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, ageRangeEntity.zzbge);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, ageRangeEntity.zzbgf);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgF */
    public PersonEntity.AgeRangeEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 2:
                    int zzg = zza.zzg(parcel, zzat);
                    hashSet.add(2);
                    i2 = zzg;
                    break;
                case 3:
                    int zzg2 = zza.zzg(parcel, zzat);
                    hashSet.add(3);
                    i3 = zzg2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.AgeRangeEntity(hashSet, i, i2, i3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjM */
    public PersonEntity.AgeRangeEntity[] newArray(int i) {
        return new PersonEntity.AgeRangeEntity[i];
    }
}
