package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Parcelable.Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzawj);
        zzb.zzc(parcel, 1000, rawDataPoint.mVersionCode);
        zzb.zza(parcel, 2, rawDataPoint.zzawk);
        zzb.zza(parcel, 3, (T[]) rawDataPoint.zzawl, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzaxg);
        zzb.zzc(parcel, 5, rawDataPoint.zzaxh);
        zzb.zza(parcel, 6, rawDataPoint.zzawn);
        zzb.zza(parcel, 7, rawDataPoint.zzawo);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcZ */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    valueArr = (Value[]) zza.zzb(parcel, zzat, Value.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    j4 = zza.zzi(parcel, zzat);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeY */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
