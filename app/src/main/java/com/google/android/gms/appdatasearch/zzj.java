package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) usageInfo.zzUs, i, false);
        zzb.zzc(parcel, 1000, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzUt);
        zzb.zzc(parcel, 3, usageInfo.zzUu);
        zzb.zza(parcel, 4, usageInfo.zzvp, false);
        zzb.zza(parcel, 5, (Parcelable) usageInfo.zzUv, i, false);
        zzb.zza(parcel, 6, usageInfo.zzUw);
        zzb.zzc(parcel, 7, usageInfo.zzUx);
        zzb.zzc(parcel, 8, usageInfo.zzUy);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzat */
    public UsageInfo[] newArray(int i) {
        return new UsageInfo[i];
    }

    /* renamed from: zzy */
    public UsageInfo createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        int i = -1;
        int i2 = 0;
        DocumentId documentId = null;
        int i3 = 0;
        String str = null;
        boolean z = false;
        int i4 = 0;
        DocumentContents documentContents = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzat, DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzat, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UsageInfo(i2, documentId, j, i3, str, documentContents, z, i, i4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
