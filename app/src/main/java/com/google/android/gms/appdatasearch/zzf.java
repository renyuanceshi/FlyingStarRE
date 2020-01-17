package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<GetRecentContextCall.Request> {
    static void zza(GetRecentContextCall.Request request, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) request.zzTT, i, false);
        zzb.zzc(parcel, 1000, request.mVersionCode);
        zzb.zza(parcel, 2, request.zzTU);
        zzb.zza(parcel, 3, request.zzTV);
        zzb.zza(parcel, 4, request.zzTW);
        zzb.zza(parcel, 5, request.zzTX, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzam */
    public GetRecentContextCall.Request[] newArray(int i) {
        return new GetRecentContextCall.Request[i];
    }

    /* renamed from: zzv */
    public GetRecentContextCall.Request createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Account account = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
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
            return new GetRecentContextCall.Request(i, account, z, z2, z3, str);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
