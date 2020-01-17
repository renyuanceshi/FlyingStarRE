package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<HandleClientLifecycleEventRequest> {
    static void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, handleClientLifecycleEventRequest.versionCode);
        zzb.zza(parcel, 2, (Parcelable) handleClientLifecycleEventRequest.zzbcs, i, false);
        zzb.zzc(parcel, 3, handleClientLifecycleEventRequest.zzbct);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgi */
    public HandleClientLifecycleEventRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ClientAppContext clientAppContext = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new HandleClientLifecycleEventRequest(i, clientAppContext, i2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjn */
    public HandleClientLifecycleEventRequest[] newArray(int i) {
        return new HandleClientLifecycleEventRequest[i];
    }
}
