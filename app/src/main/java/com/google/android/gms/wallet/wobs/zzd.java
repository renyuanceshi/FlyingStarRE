package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        zzb.zzc(parcel, 2, loyaltyPointsBalance.zzbqJ);
        zzb.zza(parcel, 3, loyaltyPointsBalance.zzbqK, false);
        zzb.zza(parcel, 4, loyaltyPointsBalance.zzbqL);
        zzb.zza(parcel, 5, loyaltyPointsBalance.zzboF, false);
        zzb.zza(parcel, 6, loyaltyPointsBalance.zzbqM);
        zzb.zzc(parcel, 7, loyaltyPointsBalance.zzbqN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhR */
    public LoyaltyPointsBalance createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        double d = 0.0d;
        long j = 0;
        int i = -1;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    d = zza.zzn(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoyaltyPointsBalance(i2, i3, str, d, str2, j, i);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzls */
    public LoyaltyPointsBalance[] newArray(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
