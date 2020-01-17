package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<InterstitialAdParameterParcel> {
    static void zza(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, interstitialAdParameterParcel.versionCode);
        zzb.zza(parcel, 2, interstitialAdParameterParcel.zzql);
        zzb.zza(parcel, 3, interstitialAdParameterParcel.zzqm);
        zzb.zza(parcel, 4, interstitialAdParameterParcel.zzqn, false);
        zzb.zza(parcel, 5, interstitialAdParameterParcel.zzqo);
        zzb.zza(parcel, 6, interstitialAdParameterParcel.zzqp);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zza */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        float f = 0.0f;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new InterstitialAdParameterParcel(i, z, z2, str, z3, f);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzg */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
