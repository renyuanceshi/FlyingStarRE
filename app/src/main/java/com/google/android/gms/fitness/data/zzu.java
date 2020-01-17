package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzu implements Parcelable.Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzuv());
        zzb.zza(parcel, 4, value.zzuA(), false);
        zzb.zza(parcel, 5, value.zzuB(), false);
        zzb.zza(parcel, 6, value.zzuC(), false);
        zzb.zza(parcel, 7, value.zzuD(), false);
        zzb.zza(parcel, 8, value.zzuE(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzde */
    public Value createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        String str = null;
        Bundle bundle = null;
        int[] iArr = null;
        float[] fArr = null;
        byte[] bArr = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 6:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                case 7:
                    fArr = zza.zzy(parcel, zzat);
                    break;
                case 8:
                    bArr = zza.zzs(parcel, zzat);
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
            return new Value(i, i2, z, f, str, bundle, iArr, fArr, bArr);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzfe */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}
