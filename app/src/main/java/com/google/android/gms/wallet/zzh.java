package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<InstrumentInfo> {
    static void zza(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, instrumentInfo.getVersionCode());
        zzb.zza(parcel, 2, instrumentInfo.getInstrumentType(), false);
        zzb.zza(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhv */
    public InstrumentInfo createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new InstrumentInfo(i, str, str2);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkT */
    public InstrumentInfo[] newArray(int i) {
        return new InstrumentInfo[i];
    }
}