package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Parcelable.Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzb.zzc(parcel, 1000, roomEntity.getVersionCode());
        zzb.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzb.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, roomEntity.getStatus());
        zzb.zza(parcel, 5, roomEntity.getDescription(), false);
        zzb.zzc(parcel, 6, roomEntity.getVariant());
        zzb.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzb.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzev */
    public RoomEntity createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        int i = 0;
        String str = null;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        Bundle bundle = null;
        ArrayList<ParticipantEntity> arrayList = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 8:
                    arrayList = zza.zzc(parcel, zzat, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i4 = zza.zzg(parcel, zzat);
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
            return new RoomEntity(i, str, str2, j, i2, str3, i3, bundle, arrayList, i4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzgL */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
