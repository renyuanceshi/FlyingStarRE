package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Parcelable.Creator<RegisterStatusCallbackRequest> {
    static void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, registerStatusCallbackRequest.versionCode);
        zzb.zza(parcel, 2, registerStatusCallbackRequest.zzED(), false);
        zzb.zza(parcel, 3, registerStatusCallbackRequest.zzEG(), false);
        zzb.zza(parcel, 4, registerStatusCallbackRequest.zzbcX);
        zzb.zza(parcel, 5, registerStatusCallbackRequest.zzbbF, false);
        zzb.zza(parcel, 6, (Parcelable) registerStatusCallbackRequest.zzbcs, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgm */
    public RegisterStatusCallbackRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        ClientAppContext clientAppContext = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RegisterStatusCallbackRequest(i, iBinder, iBinder2, z, str, clientAppContext);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjs */
    public RegisterStatusCallbackRequest[] newArray(int i) {
        return new RegisterStatusCallbackRequest[i];
    }
}
