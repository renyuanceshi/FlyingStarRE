package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzbdL);
        zzb.zzc(parcel, 4, playLoggerContext.zzbdM);
        zzb.zza(parcel, 5, playLoggerContext.zzbdN, false);
        zzb.zza(parcel, 6, playLoggerContext.zzbdO, false);
        zzb.zza(parcel, 7, playLoggerContext.zzbdP);
        zzb.zza(parcel, 8, playLoggerContext.zzbdQ, false);
        zzb.zza(parcel, 9, playLoggerContext.zzbdR);
        zzb.zzc(parcel, 10, playLoggerContext.zzbdS);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgz */
    public PlayLoggerContext createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        boolean z = true;
        int i = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        boolean z2 = false;
        int i4 = 0;
        String str4 = null;
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
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayLoggerContext(i, str, i2, i3, str2, str3, z, str4, z2, i4);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjF */
    public PlayLoggerContext[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
