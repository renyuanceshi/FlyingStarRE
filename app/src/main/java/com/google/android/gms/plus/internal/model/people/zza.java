package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Parcelable.Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = personEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, personEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, personEntity.zzbfL, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, (Parcelable) personEntity.zzbfM, i, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, personEntity.zzbfN, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, personEntity.zzbfO, true);
        }
        if (set.contains(6)) {
            zzb.zzc(parcel, 6, personEntity.zzbfP);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, (Parcelable) personEntity.zzbfQ, i, true);
        }
        if (set.contains(8)) {
            zzb.zza(parcel, 8, personEntity.zzbfR, true);
        }
        if (set.contains(9)) {
            zzb.zza(parcel, 9, personEntity.zzWQ, true);
        }
        if (set.contains(12)) {
            zzb.zzc(parcel, 12, personEntity.zztT);
        }
        if (set.contains(14)) {
            zzb.zza(parcel, 14, personEntity.zzyv, true);
        }
        if (set.contains(15)) {
            zzb.zza(parcel, 15, (Parcelable) personEntity.zzbfS, i, true);
        }
        if (set.contains(16)) {
            zzb.zza(parcel, 16, personEntity.zzbfT);
        }
        if (set.contains(19)) {
            zzb.zza(parcel, 19, (Parcelable) personEntity.zzbfU, i, true);
        }
        if (set.contains(18)) {
            zzb.zza(parcel, 18, personEntity.zzaaL, true);
        }
        if (set.contains(21)) {
            zzb.zzc(parcel, 21, personEntity.zzbfW);
        }
        if (set.contains(20)) {
            zzb.zza(parcel, 20, personEntity.zzbfV, true);
        }
        if (set.contains(23)) {
            zzb.zzc(parcel, 23, personEntity.zzbfY, true);
        }
        if (set.contains(22)) {
            zzb.zzc(parcel, 22, personEntity.zzbfX, true);
        }
        if (set.contains(25)) {
            zzb.zzc(parcel, 25, personEntity.zzbga);
        }
        if (set.contains(24)) {
            zzb.zzc(parcel, 24, personEntity.zzbfZ);
        }
        if (set.contains(27)) {
            zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(26)) {
            zzb.zza(parcel, 26, personEntity.zzbgb, true);
        }
        if (set.contains(29)) {
            zzb.zza(parcel, 29, personEntity.zzbgd);
        }
        if (set.contains(28)) {
            zzb.zzc(parcel, 28, personEntity.zzbgc, true);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgE */
    public PersonEntity createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        PersonEntity.AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        PersonEntity.CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PersonEntity.ImageEntity imageEntity = null;
        boolean z = false;
        String str7 = null;
        PersonEntity.NameEntity nameEntity = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(2);
                    break;
                case 3:
                    hashSet.add(3);
                    ageRangeEntity = (PersonEntity.AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, PersonEntity.AgeRangeEntity.CREATOR);
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(6);
                    break;
                case 7:
                    hashSet.add(7);
                    coverEntity = (PersonEntity.CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, PersonEntity.CoverEntity.CREATOR);
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(9);
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(12);
                    break;
                case 14:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    imageEntity = (PersonEntity.ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, PersonEntity.ImageEntity.CREATOR);
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    hashSet.add(16);
                    break;
                case 18:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(18);
                    break;
                case 19:
                    hashSet.add(19);
                    nameEntity = (PersonEntity.NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, PersonEntity.NameEntity.CREATOR);
                    break;
                case 20:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(21);
                    break;
                case 22:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, PersonEntity.OrganizationsEntity.CREATOR);
                    hashSet.add(22);
                    break;
                case 23:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, PersonEntity.PlacesLivedEntity.CREATOR);
                    hashSet.add(23);
                    break;
                case 24:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(24);
                    break;
                case 25:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(25);
                    break;
                case 26:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(26);
                    break;
                case 27:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(27);
                    break;
                case 28:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, PersonEntity.UrlsEntity.CREATOR);
                    hashSet.add(28);
                    break;
                case 29:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    hashSet.add(29);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PersonEntity(hashSet, i, str, ageRangeEntity, str2, str3, i2, coverEntity, str4, str5, i3, str6, imageEntity, z, str7, nameEntity, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjL */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
