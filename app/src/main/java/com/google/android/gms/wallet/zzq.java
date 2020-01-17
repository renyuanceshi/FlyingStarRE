package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Parcelable.Creator<PaymentMethodTokenizationParameters> {
    static void zza(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, paymentMethodTokenizationParameters.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodTokenizationParameters.zzbpC);
        zzb.zza(parcel, 3, paymentMethodTokenizationParameters.zzbpD, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhE */
    public PaymentMethodTokenizationParameters createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PaymentMethodTokenizationParameters(i, i2, bundle);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzlc */
    public PaymentMethodTokenizationParameters[] newArray(int i) {
        return new PaymentMethodTokenizationParameters[i];
    }
}
