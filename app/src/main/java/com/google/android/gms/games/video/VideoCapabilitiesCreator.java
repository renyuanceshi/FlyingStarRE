package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class VideoCapabilitiesCreator implements Parcelable.Creator<VideoCapabilities> {
    static void zza(VideoCapabilities videoCapabilities, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, videoCapabilities.zzxZ());
        zzb.zzc(parcel, 1000, videoCapabilities.getVersionCode());
        zzb.zza(parcel, 2, videoCapabilities.zzxY());
        zzb.zza(parcel, 3, videoCapabilities.zzya());
        zzb.zza(parcel, 4, videoCapabilities.zzyb(), false);
        zzb.zza(parcel, 5, videoCapabilities.zzyc(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzeF */
    public VideoCapabilities createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean[] zArr = null;
        boolean z3 = false;
        boolean[] zArr2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    zArr = zza.zzu(parcel, zzat);
                    break;
                case 5:
                    zArr2 = zza.zzu(parcel, zzat);
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
            return new VideoCapabilities(i, z, z2, z3, zArr, zArr2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzgY */
    public VideoCapabilities[] newArray(int i) {
        return new VideoCapabilities[i];
    }
}
