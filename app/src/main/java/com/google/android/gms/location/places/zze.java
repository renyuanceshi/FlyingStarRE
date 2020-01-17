package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzyV());
        zzb.zzc(parcel, 1000, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzyY());
        zzb.zza(parcel, 3, (Parcelable) nearbyAlertRequest.zzyZ(), i, false);
        zzb.zza(parcel, 4, (Parcelable) nearbyAlertRequest.zzza(), i, false);
        zzb.zza(parcel, 5, nearbyAlertRequest.zzzb());
        zzb.zzc(parcel, 6, nearbyAlertRequest.zzzc());
        zzb.zzc(parcel, 7, nearbyAlertRequest.getPriority());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfd */
    public NearbyAlertRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        PlaceFilter placeFilter = null;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        NearbyAlertFilter nearbyAlertFilter = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzat, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzat, NearbyAlertFilter.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    i5 = zza.zzg(parcel, zzat);
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
            return new NearbyAlertRequest(i2, i3, i, placeFilter, nearbyAlertFilter, z, i4, i5);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhN */
    public NearbyAlertRequest[] newArray(int i) {
        return new NearbyAlertRequest[i];
    }
}
