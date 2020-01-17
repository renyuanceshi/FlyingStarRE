package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<PlusSession> {
    static void zza(PlusSession plusSession, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, plusSession.getAccountName(), false);
        zzb.zzc(parcel, 1000, plusSession.getVersionCode());
        zzb.zza(parcel, 2, plusSession.zzFd(), false);
        zzb.zza(parcel, 3, plusSession.zzFe(), false);
        zzb.zza(parcel, 4, plusSession.zzFf(), false);
        zzb.zza(parcel, 5, plusSession.zzFg(), false);
        zzb.zza(parcel, 6, plusSession.zzFh(), false);
        zzb.zza(parcel, 7, plusSession.zznX(), false);
        zzb.zza(parcel, 8, plusSession.zzFi(), false);
        zzb.zza(parcel, 9, (Parcelable) plusSession.zzFj(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgB */
    public PlusSession createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        PlusCommonExtras plusCommonExtras = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 3:
                    strArr2 = zza.zzB(parcel, zzat);
                    break;
                case 4:
                    strArr3 = zza.zzB(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) zza.zza(parcel, zzat, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlusSession(i, str, strArr, strArr2, strArr3, str2, str3, str4, str5, plusCommonExtras);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjI */
    public PlusSession[] newArray(int i) {
        return new PlusSession[i];
    }
}
