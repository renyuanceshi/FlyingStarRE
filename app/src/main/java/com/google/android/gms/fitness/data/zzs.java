package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs implements Parcelable.Creator<Subscription> {
    static void zza(Subscription subscription, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) subscription.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, subscription.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) subscription.getDataType(), i, false);
        zzb.zza(parcel, 3, subscription.zzux());
        zzb.zzc(parcel, 4, subscription.getAccuracyMode());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdd */
    public Subscription createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        int i = 0;
        DataSource dataSource = null;
        int i2 = 0;
        DataType dataType = null;
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
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
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
            return new Subscription(i, dataSource, dataType, j, i2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfd */
    public Subscription[] newArray(int i) {
        return new Subscription[i];
    }
}
