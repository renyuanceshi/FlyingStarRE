package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Parcelable.Creator<PersonEntity.NameEntity> {
    static void zza(PersonEntity.NameEntity nameEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = nameEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, nameEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, nameEntity.zzbfl, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, nameEntity.zzbgl, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, nameEntity.zzbfo, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, nameEntity.zzbgm, true);
        }
        if (set.contains(6)) {
            zzb.zza(parcel, 6, nameEntity.zzbgn, true);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, nameEntity.zzbgo, true);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgK */
    public PersonEntity.NameEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(2);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    hashSet.add(3);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    hashSet.add(5);
                    break;
                case 6:
                    str5 = zza.zzp(parcel, zzat);
                    hashSet.add(6);
                    break;
                case 7:
                    str6 = zza.zzp(parcel, zzat);
                    hashSet.add(7);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.NameEntity(hashSet, i, str, str2, str3, str4, str5, str6);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjR */
    public PersonEntity.NameEntity[] newArray(int i) {
        return new PersonEntity.NameEntity[i];
    }
}
