package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<NearbyDeviceFilter> {
    static void zza(NearbyDeviceFilter nearbyDeviceFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyDeviceFilter.zzbci);
        zzb.zzc(parcel, 1000, nearbyDeviceFilter.mVersionCode);
        zzb.zza(parcel, 2, nearbyDeviceFilter.zzbcj, false);
        zzb.zza(parcel, 3, nearbyDeviceFilter.zzbck);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzge */
    public NearbyDeviceFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 3:
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
            return new NearbyDeviceFilter(i, i2, bArr, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjj */
    public NearbyDeviceFilter[] newArray(int i) {
        return new NearbyDeviceFilter[i];
    }
}
