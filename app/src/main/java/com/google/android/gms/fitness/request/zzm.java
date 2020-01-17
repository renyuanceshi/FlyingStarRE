package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zzm implements Parcelable.Creator<DataUpdateRequest> {
    static void zza(DataUpdateRequest dataUpdateRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataUpdateRequest.zzlO());
        zzb.zzc(parcel, 1000, dataUpdateRequest.getVersionCode());
        zzb.zza(parcel, 2, dataUpdateRequest.zzud());
        zzb.zza(parcel, 3, (Parcelable) dataUpdateRequest.getDataSet(), i, false);
        zzb.zza(parcel, 4, dataUpdateRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzds */
    public DataUpdateRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        DataSet dataSet = null;
        IBinder iBinder = null;
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
                    dataSet = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
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
            return new DataUpdateRequest(i, j, j2, dataSet, iBinder);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfs */
    public DataUpdateRequest[] newArray(int i) {
        return new DataUpdateRequest[i];
    }
}
