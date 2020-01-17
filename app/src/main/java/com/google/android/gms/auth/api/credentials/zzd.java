package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<HintRequest> {
    static void zza(HintRequest hintRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) hintRequest.getHintPickerConfig(), i, false);
        zzb.zzc(parcel, 1000, hintRequest.mVersionCode);
        zzb.zza(parcel, 2, hintRequest.isEmailAddressIdentifierSupported());
        zzb.zza(parcel, 3, hintRequest.zzmy());
        zzb.zza(parcel, 4, hintRequest.getAccountTypes(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzH */
    public HintRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        CredentialPickerConfig credentialPickerConfig = null;
        boolean z = false;
        boolean z2 = false;
        String[] strArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    credentialPickerConfig = (CredentialPickerConfig) zza.zza(parcel, zzat, CredentialPickerConfig.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    strArr = zza.zzB(parcel, zzat);
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
            return new HintRequest(i, credentialPickerConfig, z, z2, strArr);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaC */
    public HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
