package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zzc(parcel, 1000, registerSectionInfo.mVersionCode);
        zzb.zza(parcel, 2, registerSectionInfo.zzUd, false);
        zzb.zza(parcel, 3, registerSectionInfo.zzUe);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.zzUf);
        zzb.zza(parcel, 6, registerSectionInfo.zzUg, false);
        zzb.zza(parcel, 7, (T[]) registerSectionInfo.zzUh, i, false);
        zzb.zza(parcel, 8, registerSectionInfo.zzUi, false);
        zzb.zza(parcel, 11, registerSectionInfo.zzUj, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaq */
    public RegisterSectionInfo[] newArray(int i) {
        return new RegisterSectionInfo[i];
    }

    /* renamed from: zzx */
    public RegisterSectionInfo createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 1;
        int i2 = 0;
        String str = null;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        Feature[] featureArr = null;
        int[] iArr = null;
        String str4 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    featureArr = (Feature[]) zza.zzb(parcel, zzat, Feature.CREATOR);
                    break;
                case 8:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                case 11:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RegisterSectionInfo(i2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
