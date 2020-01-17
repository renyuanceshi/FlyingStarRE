package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<TextDeletedDetails> {
    static void zza(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, textDeletedDetails.mVersionCode);
        zzb.zzc(parcel, 2, textDeletedDetails.mIndex);
        zzb.zzc(parcel, 3, textDeletedDetails.zzavn);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcH */
    public TextDeletedDetails createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TextDeletedDetails(i, i2, i3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeD */
    public TextDeletedDetails[] newArray(int i) {
        return new TextDeletedDetails[i];
    }
}
