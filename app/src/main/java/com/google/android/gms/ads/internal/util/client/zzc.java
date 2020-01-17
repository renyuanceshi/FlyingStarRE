package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<VersionInfoParcel> {
    static void zza(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, versionInfoParcel.versionCode);
        zzb.zza(parcel, 2, versionInfoParcel.afmaVersion, false);
        zzb.zzc(parcel, 3, versionInfoParcel.zzMZ);
        zzb.zzc(parcel, 4, versionInfoParcel.zzNa);
        zzb.zza(parcel, 5, versionInfoParcel.zzNb);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzR */
    public VersionInfoParcel[] newArray(int i) {
        return new VersionInfoParcel[i];
    }

    /* renamed from: zzp */
    public VersionInfoParcel createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new VersionInfoParcel(i, str, i2, i3, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
