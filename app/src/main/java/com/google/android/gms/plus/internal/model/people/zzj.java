package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzj implements Parcelable.Creator<PersonEntity.UrlsEntity> {
    static void zza(PersonEntity.UrlsEntity urlsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = urlsEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, urlsEntity.mVersionCode);
        }
        if (set.contains(3)) {
            zzb.zzc(parcel, 3, urlsEntity.zzFy());
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, urlsEntity.mValue, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, urlsEntity.zzaUO, true);
        }
        if (set.contains(6)) {
            zzb.zzc(parcel, 6, urlsEntity.zzabB);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgN */
    public PersonEntity.UrlsEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    hashSet.add(3);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    hashSet.add(4);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(6);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.UrlsEntity(hashSet, i, str, i2, str2, i3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjU */
    public PersonEntity.UrlsEntity[] newArray(int i) {
        return new PersonEntity.UrlsEntity[i];
    }
}
