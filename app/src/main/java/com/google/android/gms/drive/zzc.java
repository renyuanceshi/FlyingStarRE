package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<DriveFileRange> {
    static void zza(DriveFileRange driveFileRange, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveFileRange.mVersionCode);
        zzb.zza(parcel, 2, driveFileRange.zzaoJ);
        zzb.zza(parcel, 3, driveFileRange.zzaoK);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaJ */
    public DriveFileRange createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveFileRange(i, j, j2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcs */
    public DriveFileRange[] newArray(int i) {
        return new DriveFileRange[i];
    }
}
