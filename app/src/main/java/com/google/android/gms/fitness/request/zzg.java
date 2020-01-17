package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzg implements Parcelable.Creator<DataSourceQueryParams> {
    static void zza(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSourceQueryParams.zzavU, i, false);
        zzb.zzc(parcel, 1000, dataSourceQueryParams.mVersionCode);
        zzb.zza(parcel, 2, dataSourceQueryParams.zzUZ);
        zzb.zza(parcel, 3, dataSourceQueryParams.zzawk);
        zzb.zza(parcel, 4, dataSourceQueryParams.zzaAT);
        zzb.zzc(parcel, 5, dataSourceQueryParams.zzaAO);
        zzb.zzc(parcel, 6, dataSourceQueryParams.zzaAU);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdm */
    public DataSourceQueryParams createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        int i = 0;
        long j = 0;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i3 = zza.zzg(parcel, zzat);
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
            return new DataSourceQueryParams(i, dataSource, j, j2, j3, i2, i3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfm */
    public DataSourceQueryParams[] newArray(int i) {
        return new DataSourceQueryParams[i];
    }
}
