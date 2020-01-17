package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new zze();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    ProxyCard zzboq;
    String zzbor;
    Address zzbos;
    Address zzbot;
    String[] zzbou;
    UserAddress zzbov;
    UserAddress zzbow;
    InstrumentInfo[] zzbox;
    PaymentMethodToken zzboy;

    private FullWallet() {
        this.mVersionCode = 1;
    }

    FullWallet(int i, String str, String str2, ProxyCard proxyCard, String str3, Address address, Address address2, String[] strArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr, PaymentMethodToken paymentMethodToken) {
        this.mVersionCode = i;
        this.zzboo = str;
        this.zzbop = str2;
        this.zzboq = proxyCard;
        this.zzbor = str3;
        this.zzbos = address;
        this.zzbot = address2;
        this.zzbou = strArr;
        this.zzbov = userAddress;
        this.zzbow = userAddress2;
        this.zzbox = instrumentInfoArr;
        this.zzboy = paymentMethodToken;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzbos;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzbov;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzbow;
    }

    public String getEmail() {
        return this.zzbor;
    }

    public String getGoogleTransactionId() {
        return this.zzboo;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzbox;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public String[] getPaymentDescriptions() {
        return this.zzbou;
    }

    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzboy;
    }

    public ProxyCard getProxyCard() {
        return this.zzboq;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbot;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
