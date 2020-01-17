package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zze implements Parcelable.Creator<FullWallet> {
    static void zza(FullWallet fullWallet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fullWallet.getVersionCode());
        zzb.zza(parcel, 2, fullWallet.zzboo, false);
        zzb.zza(parcel, 3, fullWallet.zzbop, false);
        zzb.zza(parcel, 4, (Parcelable) fullWallet.zzboq, i, false);
        zzb.zza(parcel, 5, fullWallet.zzbor, false);
        zzb.zza(parcel, 6, (Parcelable) fullWallet.zzbos, i, false);
        zzb.zza(parcel, 7, (Parcelable) fullWallet.zzbot, i, false);
        zzb.zza(parcel, 8, fullWallet.zzbou, false);
        zzb.zza(parcel, 9, (Parcelable) fullWallet.zzbov, i, false);
        zzb.zza(parcel, 10, (Parcelable) fullWallet.zzbow, i, false);
        zzb.zza(parcel, 11, (T[]) fullWallet.zzbox, i, false);
        zzb.zza(parcel, 12, (Parcelable) fullWallet.zzboy, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzhs */
    public FullWallet createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ProxyCard proxyCard = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        String[] strArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        PaymentMethodToken paymentMethodToken = null;
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
                case 4:
                    proxyCard = (ProxyCard) zza.zza(parcel, zzat, ProxyCard.CREATOR);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    address = (Address) zza.zza(parcel, zzat, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) zza.zza(parcel, zzat, Address.CREATOR);
                    break;
                case 8:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 9:
                    userAddress = (UserAddress) zza.zza(parcel, zzat, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzat, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzat, InstrumentInfo.CREATOR);
                    break;
                case 12:
                    paymentMethodToken = (PaymentMethodToken) zza.zza(parcel, zzat, PaymentMethodToken.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FullWallet(i, str, str2, proxyCard, str3, address, address2, strArr, userAddress, userAddress2, instrumentInfoArr, paymentMethodToken);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkQ */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
