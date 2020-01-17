package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<ChangeResourceParentsRequest> {
    static void zza(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) changeResourceParentsRequest.zzaqf, i, false);
        zzb.zzc(parcel, 3, changeResourceParentsRequest.zzaqg, false);
        zzb.zzc(parcel, 4, changeResourceParentsRequest.zzaqh, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbd */
    public ChangeResourceParentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        ArrayList<DriveId> arrayList = null;
        ArrayList<DriveId> arrayList2 = null;
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
                    arrayList = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    break;
                case 4:
                    arrayList2 = zza.zzc(parcel, zzat, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeResourceParentsRequest(i, driveId, arrayList, arrayList2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcT */
    public ChangeResourceParentsRequest[] newArray(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
