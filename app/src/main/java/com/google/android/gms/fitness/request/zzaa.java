package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;

public class zzaa implements Parcelable.Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.getCallbackBinder(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzdF */
    public SessionStartRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Session session = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    session = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    break;
                case 2:
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
            return new SessionStartRequest(i, session, iBinder);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfG */
    public SessionStartRequest[] newArray(int i) {
        return new SessionStartRequest[i];
    }
}
