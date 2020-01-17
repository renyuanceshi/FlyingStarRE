package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzm implements Parcelable.Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) locationRequestInternal.zzaBp, i, false);
        zzb.zzc(parcel, 1000, locationRequestInternal.getVersionCode());
        zzb.zza(parcel, 2, locationRequestInternal.zzaOP);
        zzb.zza(parcel, 3, locationRequestInternal.zzaOQ);
        zzb.zza(parcel, 4, locationRequestInternal.zzaOR);
        zzb.zzc(parcel, 5, locationRequestInternal.zzaOS, false);
        zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        zzb.zza(parcel, 7, locationRequestInternal.zzaOT);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzeX */
    public LocationRequestInternal createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        List<ClientIdentity> list = LocationRequestInternal.zzaOO;
        int i = 0;
        LocationRequest locationRequest = null;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = true;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzat, LocationRequest.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z3 = zza.zzc(parcel, zzat);
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
            return new LocationRequestInternal(i, locationRequest, z, z2, z4, list, str, z3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhD */
    public LocationRequestInternal[] newArray(int i) {
        return new LocationRequestInternal[i];
    }
}
