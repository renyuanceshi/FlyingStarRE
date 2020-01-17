package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<NearbyDeviceId> {
    static void zza(NearbyDeviceId nearbyDeviceId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyDeviceId.getType());
        zzb.zzc(parcel, 1000, nearbyDeviceId.mVersionCode);
        zzb.zza(parcel, 2, nearbyDeviceId.zzbbY, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgf */
    public NearbyDeviceId createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
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
            return new NearbyDeviceId(i, i2, bArr);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjk */
    public NearbyDeviceId[] newArray(int i) {
        return new NearbyDeviceId[i];
    }
}
