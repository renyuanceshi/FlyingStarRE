package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Parcelable.Creator<PersonEntity.ImageEntity> {
    static void zza(PersonEntity.ImageEntity imageEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = imageEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, imageEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgJ */
    public PersonEntity.ImageEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.ImageEntity(hashSet, i, str);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjQ */
    public PersonEntity.ImageEntity[] newArray(int i) {
        return new PersonEntity.ImageEntity[i];
    }
}
