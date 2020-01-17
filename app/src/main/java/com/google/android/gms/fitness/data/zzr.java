package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Parcelable.Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionDataSet.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) sessionDataSet.getDataSet(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdc */
    public SessionDataSet createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Session session = null;
        DataSet dataSet = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    session = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    break;
                case 2:
                    dataSet = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
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
            return new SessionDataSet(i, session, dataSet);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfc */
    public SessionDataSet[] newArray(int i) {
        return new SessionDataSet[i];
    }
}
