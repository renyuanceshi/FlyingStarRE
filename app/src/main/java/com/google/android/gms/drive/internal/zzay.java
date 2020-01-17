package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;

public class zzay implements Parcelable.Creator<OnDownloadProgressResponse> {
    static void zza(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onDownloadProgressResponse.mVersionCode);
        zzb.zza(parcel, 2, onDownloadProgressResponse.zzasi);
        zzb.zza(parcel, 3, onDownloadProgressResponse.zzasj);
        zzb.zzc(parcel, 4, onDownloadProgressResponse.zzBc);
        zzb.zzc(parcel, 5, onDownloadProgressResponse.zzask, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbB */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList<DriveFileRange> arrayList = null;
        int i = 0;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzat, DriveFileRange.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnDownloadProgressResponse(i, j, j2, i2, arrayList);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdw */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
