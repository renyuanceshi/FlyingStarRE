package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zze implements Parcelable.Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataSet.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzuk(), false);
        zzb.zzc(parcel, 4, dataSet.zzul(), false);
        zzb.zza(parcel, 5, dataSet.zzuc());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcR */
    public DataSet createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        ArrayList<DataSource> arrayList2 = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzat, (List) arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    arrayList2 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 5:
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
            return new DataSet(i, dataSource, dataType, arrayList, arrayList2, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeQ */
    public DataSet[] newArray(int i) {
        return new DataSet[i];
    }
}
