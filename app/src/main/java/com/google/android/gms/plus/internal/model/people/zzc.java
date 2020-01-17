package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzc implements Parcelable.Creator<PersonEntity.CoverEntity> {
    static void zza(PersonEntity.CoverEntity coverEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = coverEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, coverEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, (Parcelable) coverEntity.zzbgg, i, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, (Parcelable) coverEntity.zzbgh, i, true);
        }
        if (set.contains(4)) {
            zzb.zzc(parcel, 4, coverEntity.zzbgi);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgG */
    public PersonEntity.CoverEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity = null;
        int i2 = 0;
        PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    coverInfoEntity = (PersonEntity.CoverEntity.CoverInfoEntity) zza.zza(parcel, zzat, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
                    break;
                case 3:
                    hashSet.add(3);
                    coverPhotoEntity = (PersonEntity.CoverEntity.CoverPhotoEntity) zza.zza(parcel, zzat, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(4);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.CoverEntity(hashSet, i, coverInfoEntity, coverPhotoEntity, i2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjN */
    public PersonEntity.CoverEntity[] newArray(int i) {
        return new PersonEntity.CoverEntity[i];
    }
}
