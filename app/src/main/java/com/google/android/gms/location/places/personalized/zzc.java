package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<PlaceAliasResult> {
    static void zza(PlaceAliasResult placeAliasResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) placeAliasResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placeAliasResult.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) placeAliasResult.zzzC(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfr */
    public PlaceAliasResult createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        PlaceUserData placeUserData = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 2:
                    placeUserData = (PlaceUserData) zza.zza(parcel, zzat, PlaceUserData.CREATOR);
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
            return new PlaceAliasResult(i, status, placeUserData);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzie */
    public PlaceAliasResult[] newArray(int i) {
        return new PlaceAliasResult[i];
    }
}
