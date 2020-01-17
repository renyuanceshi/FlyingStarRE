package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zze implements Parcelable.Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataInsertRequest.getDataSet(), i, false);
        zzb.zzc(parcel, 1000, dataInsertRequest.getVersionCode());
        zzb.zza(parcel, 2, dataInsertRequest.getCallbackBinder(), false);
        zzb.zza(parcel, 4, dataInsertRequest.zzuO());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdk */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSet dataSet = null;
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSet = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
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
            return new DataInsertRequest(i, dataSet, iBinder, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfk */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
