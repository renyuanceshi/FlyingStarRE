package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<LargeParcelTeleporter> {
    static void zza(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeParcelTeleporter.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) largeParcelTeleporter.zzIq, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzJ */
    public LargeParcelTeleporter[] newArray(int i) {
        return new LargeParcelTeleporter[i];
    }

    /* renamed from: zzl */
    public LargeParcelTeleporter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
