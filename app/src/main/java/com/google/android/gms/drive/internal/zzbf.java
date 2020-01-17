package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbf implements Parcelable.Creator<OnPinnedDownloadPreferencesResponse> {
    static void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onPinnedDownloadPreferencesResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onPinnedDownloadPreferencesResponse.zzasu, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbI */
    public OnPinnedDownloadPreferencesResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelableTransferPreferences = (ParcelableTransferPreferences) zza.zza(parcel, zzat, ParcelableTransferPreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnPinnedDownloadPreferencesResponse(i, parcelableTransferPreferences);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdD */
    public OnPinnedDownloadPreferencesResponse[] newArray(int i) {
        return new OnPinnedDownloadPreferencesResponse[i];
    }
}
