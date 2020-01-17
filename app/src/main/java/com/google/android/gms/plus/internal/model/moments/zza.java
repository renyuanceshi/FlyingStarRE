package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class zza implements Parcelable.Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set<Integer> set = itemScopeEntity.zzbeN;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, itemScopeEntity.mVersionCode);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, (Parcelable) itemScopeEntity.zzbeO, i, true);
        }
        if (set.contains(3)) {
            zzb.zzb(parcel, 3, itemScopeEntity.zzbeP, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, (Parcelable) itemScopeEntity.zzbeQ, i, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, itemScopeEntity.zzbeR, true);
        }
        if (set.contains(6)) {
            zzb.zza(parcel, 6, itemScopeEntity.zzbeS, true);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, itemScopeEntity.zzbeT, true);
        }
        if (set.contains(8)) {
            zzb.zzc(parcel, 8, itemScopeEntity.zzbeU, true);
        }
        if (set.contains(9)) {
            zzb.zzc(parcel, 9, itemScopeEntity.zzbeV);
        }
        if (set.contains(10)) {
            zzb.zzc(parcel, 10, itemScopeEntity.zzbeW, true);
        }
        if (set.contains(11)) {
            zzb.zza(parcel, 11, (Parcelable) itemScopeEntity.zzbeX, i, true);
        }
        if (set.contains(12)) {
            zzb.zzc(parcel, 12, itemScopeEntity.zzbeY, true);
        }
        if (set.contains(13)) {
            zzb.zza(parcel, 13, itemScopeEntity.zzbeZ, true);
        }
        if (set.contains(14)) {
            zzb.zza(parcel, 14, itemScopeEntity.zzbfa, true);
        }
        if (set.contains(15)) {
            zzb.zza(parcel, 15, (Parcelable) itemScopeEntity.zzbfb, i, true);
        }
        if (set.contains(17)) {
            zzb.zza(parcel, 17, itemScopeEntity.zzbfd, true);
        }
        if (set.contains(16)) {
            zzb.zza(parcel, 16, itemScopeEntity.zzbfc, true);
        }
        if (set.contains(19)) {
            zzb.zzc(parcel, 19, itemScopeEntity.zzbfe, true);
        }
        if (set.contains(18)) {
            zzb.zza(parcel, 18, itemScopeEntity.zztZ, true);
        }
        if (set.contains(21)) {
            zzb.zza(parcel, 21, itemScopeEntity.zzbfg, true);
        }
        if (set.contains(20)) {
            zzb.zza(parcel, 20, itemScopeEntity.zzbff, true);
        }
        if (set.contains(23)) {
            zzb.zza(parcel, 23, itemScopeEntity.zzaxl, true);
        }
        if (set.contains(22)) {
            zzb.zza(parcel, 22, itemScopeEntity.zzbfh, true);
        }
        if (set.contains(25)) {
            zzb.zza(parcel, 25, itemScopeEntity.zzbfj, true);
        }
        if (set.contains(24)) {
            zzb.zza(parcel, 24, itemScopeEntity.zzbfi, true);
        }
        if (set.contains(27)) {
            zzb.zza(parcel, 27, itemScopeEntity.zzbfl, true);
        }
        if (set.contains(26)) {
            zzb.zza(parcel, 26, itemScopeEntity.zzbfk, true);
        }
        if (set.contains(29)) {
            zzb.zza(parcel, 29, (Parcelable) itemScopeEntity.zzbfn, i, true);
        }
        if (set.contains(28)) {
            zzb.zza(parcel, 28, itemScopeEntity.zzbfm, true);
        }
        if (set.contains(31)) {
            zzb.zza(parcel, 31, itemScopeEntity.zzbfp, true);
        }
        if (set.contains(30)) {
            zzb.zza(parcel, 30, itemScopeEntity.zzbfo, true);
        }
        if (set.contains(34)) {
            zzb.zza(parcel, 34, (Parcelable) itemScopeEntity.zzbfr, i, true);
        }
        if (set.contains(32)) {
            zzb.zza(parcel, 32, itemScopeEntity.zzyv, true);
        }
        if (set.contains(33)) {
            zzb.zza(parcel, 33, itemScopeEntity.zzbfq, true);
        }
        if (set.contains(38)) {
            zzb.zza(parcel, 38, itemScopeEntity.zzaNG);
        }
        if (set.contains(39)) {
            zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(36)) {
            zzb.zza(parcel, 36, itemScopeEntity.zzaNF);
        }
        if (set.contains(37)) {
            zzb.zza(parcel, 37, (Parcelable) itemScopeEntity.zzbfs, i, true);
        }
        if (set.contains(42)) {
            zzb.zza(parcel, 42, itemScopeEntity.zzbfv, true);
        }
        if (set.contains(43)) {
            zzb.zza(parcel, 43, itemScopeEntity.zzbfw, true);
        }
        if (set.contains(40)) {
            zzb.zza(parcel, 40, (Parcelable) itemScopeEntity.zzbft, i, true);
        }
        if (set.contains(41)) {
            zzb.zzc(parcel, 41, itemScopeEntity.zzbfu, true);
        }
        if (set.contains(46)) {
            zzb.zza(parcel, 46, (Parcelable) itemScopeEntity.zzbfz, i, true);
        }
        if (set.contains(47)) {
            zzb.zza(parcel, 47, itemScopeEntity.zzbfA, true);
        }
        if (set.contains(44)) {
            zzb.zza(parcel, 44, itemScopeEntity.zzbfx, true);
        }
        if (set.contains(45)) {
            zzb.zza(parcel, 45, itemScopeEntity.zzbfy, true);
        }
        if (set.contains(51)) {
            zzb.zza(parcel, 51, itemScopeEntity.zzbfE, true);
        }
        if (set.contains(50)) {
            zzb.zza(parcel, 50, (Parcelable) itemScopeEntity.zzbfD, i, true);
        }
        if (set.contains(49)) {
            zzb.zza(parcel, 49, itemScopeEntity.zzbfC, true);
        }
        if (set.contains(48)) {
            zzb.zza(parcel, 48, itemScopeEntity.zzbfB, true);
        }
        if (set.contains(55)) {
            zzb.zza(parcel, 55, itemScopeEntity.zzbfG, true);
        }
        if (set.contains(54)) {
            zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(53)) {
            zzb.zza(parcel, 53, itemScopeEntity.zzJN, true);
        }
        if (set.contains(52)) {
            zzb.zza(parcel, 52, itemScopeEntity.zzbfF, true);
        }
        if (set.contains(56)) {
            zzb.zza(parcel, 56, itemScopeEntity.zzbfH, true);
        }
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgC */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        ArrayList<String> arrayList = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double d = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    itemScopeEntity = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, zzat);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    itemScopeEntity2 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    hashSet.add(11);
                    itemScopeEntity3 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 12:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    itemScopeEntity4 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 16:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(19);
                    break;
                case 20:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(21);
                    break;
                case 22:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(22);
                    break;
                case 23:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(23);
                    break;
                case 24:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(24);
                    break;
                case 25:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(25);
                    break;
                case 26:
                    str15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(26);
                    break;
                case 27:
                    str16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(27);
                    break;
                case 28:
                    str17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(28);
                    break;
                case 29:
                    hashSet.add(29);
                    itemScopeEntity5 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 30:
                    str18 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(32);
                    break;
                case 33:
                    str21 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(33);
                    break;
                case 34:
                    hashSet.add(34);
                    itemScopeEntity6 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 36:
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, zzat);
                    hashSet.add(36);
                    break;
                case 37:
                    hashSet.add(37);
                    itemScopeEntity7 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 38:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, zzat);
                    hashSet.add(38);
                    break;
                case 39:
                    str22 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(39);
                    break;
                case 40:
                    hashSet.add(40);
                    itemScopeEntity8 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 41:
                    arrayList6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, ItemScopeEntity.CREATOR);
                    hashSet.add(41);
                    break;
                case 42:
                    str23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(42);
                    break;
                case 43:
                    str24 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(43);
                    break;
                case 44:
                    str25 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(44);
                    break;
                case 45:
                    str26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(45);
                    break;
                case 46:
                    hashSet.add(46);
                    itemScopeEntity9 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 47:
                    str27 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(47);
                    break;
                case 48:
                    str28 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(48);
                    break;
                case 49:
                    str29 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(49);
                    break;
                case 50:
                    hashSet.add(50);
                    itemScopeEntity10 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ItemScopeEntity.CREATOR);
                    break;
                case 51:
                    str30 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(51);
                    break;
                case 52:
                    str31 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(52);
                    break;
                case 53:
                    str32 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(53);
                    break;
                case 54:
                    str33 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(54);
                    break;
                case 55:
                    str34 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(55);
                    break;
                case 56:
                    str35 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    hashSet.add(56);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ItemScopeEntity(hashSet, i, itemScopeEntity, arrayList, itemScopeEntity2, str, str2, str3, arrayList2, i2, arrayList3, itemScopeEntity3, arrayList4, str4, str5, itemScopeEntity4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity5, str18, str19, str20, str21, itemScopeEntity6, d, itemScopeEntity7, d2, str22, itemScopeEntity8, arrayList6, str23, str24, str25, str26, itemScopeEntity9, str27, str28, str29, itemScopeEntity10, str30, str31, str32, str33, str34, str35);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjJ */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
