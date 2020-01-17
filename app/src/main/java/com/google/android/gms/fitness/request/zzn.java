package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Parcelable.Creator<DeleteAllUserDataRequest> {
    static void zza(DeleteAllUserDataRequest deleteAllUserDataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, deleteAllUserDataRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 1000, deleteAllUserDataRequest.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdt */
    public DeleteAllUserDataRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
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
            return new DeleteAllUserDataRequest(i, iBinder);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzft */
    public DeleteAllUserDataRequest[] newArray(int i) {
        return new DeleteAllUserDataRequest[i];
    }
}
