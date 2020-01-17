package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzn implements Parcelable.Creator<RawBucket> {
    static void zza(RawBucket rawBucket, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, rawBucket.zzRD);
        zzb.zzc(parcel, 1000, rawBucket.mVersionCode);
        zzb.zza(parcel, 2, rawBucket.zzavV);
        zzb.zza(parcel, 3, (Parcelable) rawBucket.zzavX, i, false);
        zzb.zzc(parcel, 4, rawBucket.zzaxf);
        zzb.zzc(parcel, 5, rawBucket.zzawg, false);
        zzb.zzc(parcel, 6, rawBucket.zzawh);
        zzb.zza(parcel, 7, rawBucket.zzawi);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcY */
    public RawBucket createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList<RawDataSet> arrayList = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    session = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    arrayList = zza.zzc(parcel, zzat, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RawBucket(i3, j2, j, session, i2, arrayList, i, z);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeX */
    public RawBucket[] newArray(int i) {
        return new RawBucket[i];
    }
}
