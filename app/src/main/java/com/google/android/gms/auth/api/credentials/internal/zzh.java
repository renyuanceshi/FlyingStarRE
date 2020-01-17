package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<GeneratePasswordRequest> {
    static void zza(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) generatePasswordRequest.zzmr(), i, false);
        zzb.zzc(parcel, 1000, generatePasswordRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzL */
    public GeneratePasswordRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        PasswordSpecification passwordSpecification = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    passwordSpecification = (PasswordSpecification) zza.zza(parcel, zzat, PasswordSpecification.CREATOR);
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
            return new GeneratePasswordRequest(i, passwordSpecification);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaG */
    public GeneratePasswordRequest[] newArray(int i) {
        return new GeneratePasswordRequest[i];
    }
}
