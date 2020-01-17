package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzp implements Parcelable.Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzaxg);
        zzb.zzc(parcel, 1000, rawDataSet.mVersionCode);
        zzb.zzc(parcel, 2, rawDataSet.zzaxi);
        zzb.zzc(parcel, 3, rawDataSet.zzaxj, false);
        zzb.zza(parcel, 4, rawDataSet.zzawi);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzda */
    public RawDataSet createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList<RawDataPoint> arrayList = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzat, RawDataPoint.CREATOR);
                    break;
                case 4:
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
            return new RawDataSet(i, i2, i3, arrayList, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeZ */
    public RawDataSet[] newArray(int i) {
        return new RawDataSet[i];
    }
}
