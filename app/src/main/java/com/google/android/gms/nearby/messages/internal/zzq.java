package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Strategy;

public class zzq implements Parcelable.Creator<PublishRequest> {
    static void zza(PublishRequest publishRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, publishRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) publishRequest.zzbcT, i, false);
        zzb.zza(parcel, 3, (Parcelable) publishRequest.zzbcU, i, false);
        zzb.zza(parcel, 4, publishRequest.zzED(), false);
        zzb.zza(parcel, 5, publishRequest.zzbbF, false);
        zzb.zza(parcel, 6, publishRequest.zzbco, false);
        zzb.zza(parcel, 7, publishRequest.zzbbG);
        zzb.zza(parcel, 8, publishRequest.zzEF(), false);
        zzb.zza(parcel, 9, publishRequest.zzbbH);
        zzb.zza(parcel, 10, (Parcelable) publishRequest.zzbcs, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgl */
    public PublishRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MessageWrapper messageWrapper = null;
        Strategy strategy = null;
        IBinder iBinder = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        IBinder iBinder2 = null;
        ClientAppContext clientAppContext = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzat, MessageWrapper.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzat, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) zza.zza(parcel, zzat, ClientAppContext.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PublishRequest(i, messageWrapper, strategy, iBinder, str, str2, z, iBinder2, z2, clientAppContext);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjr */
    public PublishRequest[] newArray(int i) {
        return new PublishRequest[i];
    }
}
