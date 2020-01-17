package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;

public class zza implements Parcelable.Creator<Message> {
    static void zza(Message message, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, message.getContent(), false);
        zzb.zzc(parcel, 1000, message.versionCode);
        zzb.zza(parcel, 2, message.getType(), false);
        zzb.zza(parcel, 3, message.getNamespace(), false);
        zzb.zza(parcel, 4, (T[]) message.zzEn(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzga */
    public Message createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        String str2 = null;
        NearbyDevice[] nearbyDeviceArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, zzat);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    nearbyDeviceArr = (NearbyDevice[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat, NearbyDevice.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Message(i, bArr, str, str2, nearbyDeviceArr);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjb */
    public Message[] newArray(int i) {
        return new Message[i];
    }
}
