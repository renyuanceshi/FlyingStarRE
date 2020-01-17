package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<PasswordSpecification> {
    static void zza(PasswordSpecification passwordSpecification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, passwordSpecification.zzWn, false);
        zzb.zzc(parcel, 1000, passwordSpecification.mVersionCode);
        zzb.zzb(parcel, 2, passwordSpecification.zzWo, false);
        zzb.zza(parcel, 3, passwordSpecification.zzWp, false);
        zzb.zzc(parcel, 4, passwordSpecification.zzWq);
        zzb.zzc(parcel, 5, passwordSpecification.zzWr);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzJ */
    public PasswordSpecification createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        int i3 = 0;
        ArrayList<Integer> arrayList2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 3:
                    arrayList2 = zza.zzC(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzat);
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
            return new PasswordSpecification(i, str, arrayList, arrayList2, i2, i3);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaE */
    public PasswordSpecification[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
