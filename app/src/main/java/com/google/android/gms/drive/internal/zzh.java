package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzh implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqj, i, false);
        zzb.zza(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqk, i, false);
        zzb.zza(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaql, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzaoW);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzaoV, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzaqm);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzaqn);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzaqo);
        zzb.zza(parcel, 10, closeContentsAndUpdateMetadataRequest.zzapa);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbf */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        boolean z = true;
        int i = 0;
        DriveId driveId = null;
        MetadataBundle metadataBundle = null;
        Contents contents = null;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        boolean z3 = false;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents, z2, str, i2, i3, z3, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcV */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
