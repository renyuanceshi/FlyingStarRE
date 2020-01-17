package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        zzb.zza(parcel, 3, sharedContent.getUri(), false);
        zzb.zza(parcel, 8, (T[]) sharedContent.zzEL(), i, false);
        zzb.zza(parcel, 9, (T[]) sharedContent.zzEM(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgs */
    public SharedContent createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        ViewableItem[] viewableItemArr = null;
        LocalContent[] localContentArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    viewableItemArr = (ViewableItem[]) zza.zzb(parcel, zzat, ViewableItem.CREATOR);
                    break;
                case 9:
                    localContentArr = (LocalContent[]) zza.zzb(parcel, zzat, LocalContent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SharedContent(i, str, viewableItemArr, localContentArr);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjy */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
