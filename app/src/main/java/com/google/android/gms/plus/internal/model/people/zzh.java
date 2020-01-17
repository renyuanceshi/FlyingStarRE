package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzh implements Parcelable.Creator<PersonEntity.OrganizationsEntity> {
    static void zza(PersonEntity.OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = organizationsEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, organizationsEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, organizationsEntity.zzbgp, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, organizationsEntity.zzaxl, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, organizationsEntity.zzbfk, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, organizationsEntity.zzbgq, true);
        }
        if (set.contains(6)) {
            zzb.zza(parcel, 6, organizationsEntity.mName, true);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, organizationsEntity.zzbgr);
        }
        if (set.contains(8)) {
            zzb.zza(parcel, 8, organizationsEntity.zzbfA, true);
        }
        if (set.contains(9)) {
            zzb.zza(parcel, 9, organizationsEntity.zzapg, true);
        }
        if (set.contains(10)) {
            zzb.zzc(parcel, 10, organizationsEntity.zzabB);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgL */
    public PersonEntity.OrganizationsEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
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
                    z = zza.zzc(parcel, zzat);
                    hashSet.add(7);
                    break;
                case 8:
                    str6 = zza.zzp(parcel, zzat);
                    hashSet.add(8);
                    break;
                case 9:
                    str7 = zza.zzp(parcel, zzat);
                    hashSet.add(9);
                    break;
                case 10:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(10);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity.OrganizationsEntity(hashSet, i, str, str2, str3, str4, str5, z, str6, str7, i2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjS */
    public PersonEntity.OrganizationsEntity[] newArray(int i) {
        return new PersonEntity.OrganizationsEntity[i];
    }
}
