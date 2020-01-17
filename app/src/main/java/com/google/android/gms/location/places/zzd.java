package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzb(parcel, 1, nearbyAlertFilter.zzaPj, false);
        zzb.zzc(parcel, 1000, nearbyAlertFilter.mVersionCode);
        zzb.zza(parcel, 2, nearbyAlertFilter.zzaPk, false);
        zzb.zzc(parcel, 3, nearbyAlertFilter.zzaPl, false);
        zzb.zza(parcel, 4, nearbyAlertFilter.zzaPm, false);
        zzb.zza(parcel, 5, nearbyAlertFilter.zzaPn);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfc */
    public NearbyAlertFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        ArrayList<Integer> arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 2:
                    arrayList2 = zza.zzC(parcel, zzat);
                    break;
                case 3:
                    arrayList3 = zza.zzc(parcel, zzat, UserDataType.CREATOR);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
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
            return new NearbyAlertFilter(i, arrayList, arrayList2, arrayList3, str, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzhM */
    public NearbyAlertFilter[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}
