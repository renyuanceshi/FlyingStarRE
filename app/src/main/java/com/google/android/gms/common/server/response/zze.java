package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        zzb.zza(parcel, 2, safeParcelResponse.zzrD(), false);
        zzb.zza(parcel, 3, (Parcelable) safeParcelResponse.zzrE(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaE */
    public SafeParcelResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Parcel parcel2 = null;
        FieldMappingDictionary fieldMappingDictionary = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcel2 = zza.zzE(parcel, zzat);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzat, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzck */
    public SafeParcelResponse[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
