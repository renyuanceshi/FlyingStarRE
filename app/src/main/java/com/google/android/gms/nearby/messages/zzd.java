package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, strategy.zzbbL);
        zzb.zzc(parcel, 1000, strategy.mVersionCode);
        zzb.zzc(parcel, 2, strategy.zzbbM);
        zzb.zzc(parcel, 3, strategy.zzbbN);
        zzb.zza(parcel, 4, strategy.zzbbO);
        zzb.zzc(parcel, 5, strategy.zzEr());
        zzb.zzc(parcel, 6, strategy.zzEs());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgc */
    public Strategy createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i6 = zza.zzg(parcel, zzat);
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
            return new Strategy(i, i2, i3, i4, z, i5, i6);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjh */
    public Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
