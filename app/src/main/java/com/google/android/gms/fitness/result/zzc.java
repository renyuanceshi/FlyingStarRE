package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Parcelable.Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzvl(), false);
        zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzvk(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzvj());
        zzb.zzc(parcel, 6, dataReadResult.zzul(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzvm(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdP */
    public DataReadResult createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        Status status = null;
        ArrayList<DataSource> arrayList3 = null;
        ArrayList<DataType> arrayList4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    zza.zza(parcel, zzat, (List) arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzat, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    arrayList3 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 7:
                    arrayList4 = zza.zzc(parcel, zzat, DataType.CREATOR);
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
            return new DataReadResult(i, arrayList, status, arrayList2, i2, arrayList3, arrayList4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfQ */
    public DataReadResult[] newArray(int i) {
        return new DataReadResult[i];
    }
}
