package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzt implements Parcelable.Creator<ReadRawRequest> {
    static void zza(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, readRawRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 1000, readRawRequest.getVersionCode());
        zzb.zzc(parcel, 3, readRawRequest.zzuW(), false);
        zzb.zza(parcel, 4, readRawRequest.zzuQ());
        zzb.zza(parcel, 5, readRawRequest.zzuP());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdy */
    public ReadRawRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        ArrayList<DataSourceQueryParams> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzat, DataSourceQueryParams.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
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
            return new ReadRawRequest(i, iBinder, arrayList, z, z2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfy */
    public ReadRawRequest[] newArray(int i) {
        return new ReadRawRequest[i];
    }
}
