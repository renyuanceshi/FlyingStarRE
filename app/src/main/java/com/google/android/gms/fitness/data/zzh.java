package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<DataUpdateNotification> {
    static void zza(DataUpdateNotification dataUpdateNotification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateNotification.zzup());
        zzb.zzc(parcel, 1000, dataUpdateNotification.mVersionCode);
        zzb.zza(parcel, 2, dataUpdateNotification.zzuq());
        zzb.zzc(parcel, 3, dataUpdateNotification.getOperationType());
        zzb.zza(parcel, 4, (Parcelable) dataUpdateNotification.getDataSource(), i, false);
        zzb.zza(parcel, 5, (Parcelable) dataUpdateNotification.getDataType(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcU */
    public DataUpdateNotification createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        DataType dataType = null;
        long j2 = 0;
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
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 5:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
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
            return new DataUpdateNotification(i, j, j2, i2, dataSource, dataType);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeT */
    public DataUpdateNotification[] newArray(int i) {
        return new DataUpdateNotification[i];
    }
}
