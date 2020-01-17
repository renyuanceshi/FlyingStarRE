package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbn implements Parcelable.Creator<ParcelableTransferPreferences> {
    static void zza(ParcelableTransferPreferences parcelableTransferPreferences, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableTransferPreferences.mVersionCode);
        zzb.zzc(parcel, 2, parcelableTransferPreferences.zzarG);
        zzb.zzc(parcel, 3, parcelableTransferPreferences.zzarH);
        zzb.zza(parcel, 4, parcelableTransferPreferences.zzasA);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbP */
    public ParcelableTransferPreferences createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
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
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableTransferPreferences(i, i2, i3, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdK */
    public ParcelableTransferPreferences[] newArray(int i) {
        return new ParcelableTransferPreferences[i];
    }
}
