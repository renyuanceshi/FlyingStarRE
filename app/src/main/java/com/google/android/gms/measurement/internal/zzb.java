package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<AppMetadata> {
    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appMetadata.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, appMetadata.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, appMetadata.zzaVt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, appMetadata.zzaMV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, appMetadata.zzaVu, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, appMetadata.zzaVv);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, appMetadata.zzaVw);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, appMetadata.zzaVx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, appMetadata.zzaVy);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, appMetadata.zzaVz);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzfL */
    public AppMetadata createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zziH */
    public AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}