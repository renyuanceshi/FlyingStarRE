package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzl();
    private final int mVersionCode;
    String zzboo;
    String zzbop;
    String zzbor;
    Address zzbos;
    Address zzbot;
    String[] zzbou;
    UserAddress zzbov;
    UserAddress zzbow;
    InstrumentInfo[] zzbox;
    LoyaltyWalletObject[] zzbpi;
    OfferWalletObject[] zzbpj;

    public final class Builder {
        private Builder() {
        }

        public MaskedWallet build() {
            return MaskedWallet.this;
        }

        public Builder setBillingAddress(Address address) {
            MaskedWallet.this.zzbos = address;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzbov = userAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress userAddress) {
            MaskedWallet.this.zzbow = userAddress;
            return this;
        }

        public Builder setEmail(String str) {
            MaskedWallet.this.zzbor = str;
            return this;
        }

        public Builder setGoogleTransactionId(String str) {
            MaskedWallet.this.zzboo = str;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfoArr) {
            MaskedWallet.this.zzbox = instrumentInfoArr;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            MaskedWallet.this.zzbop = str;
            return this;
        }

        public Builder setPaymentDescriptions(String[] strArr) {
            MaskedWallet.this.zzbou = strArr;
            return this;
        }

        public Builder setShippingAddress(Address address) {
            MaskedWallet.this.zzbot = address;
            return this;
        }

        @Deprecated
        public Builder zza(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            MaskedWallet.this.zzbpi = loyaltyWalletObjectArr;
            return this;
        }

        @Deprecated
        public Builder zza(OfferWalletObject[] offerWalletObjectArr) {
            MaskedWallet.this.zzbpj = offerWalletObjectArr;
            return this;
        }
    }

    private MaskedWallet() {
        this.mVersionCode = 2;
    }

    MaskedWallet(int i, String str, String str2, String[] strArr, String str3, Address address, Address address2, LoyaltyWalletObject[] loyaltyWalletObjectArr, OfferWalletObject[] offerWalletObjectArr, UserAddress userAddress, UserAddress userAddress2, InstrumentInfo[] instrumentInfoArr) {
        this.mVersionCode = i;
        this.zzboo = str;
        this.zzbop = str2;
        this.zzbou = strArr;
        this.zzbor = str3;
        this.zzbos = address;
        this.zzbot = address2;
        this.zzbpi = loyaltyWalletObjectArr;
        this.zzbpj = offerWalletObjectArr;
        this.zzbov = userAddress;
        this.zzbow = userAddress2;
        this.zzbox = instrumentInfoArr;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzz(maskedWallet);
        return zzIl().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).zza(maskedWallet.zzIm()).zza(maskedWallet.zzIn()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzIl() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
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

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbot;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    @Deprecated
    public LoyaltyWalletObject[] zzIm() {
        return this.zzbpi;
    }

    @Deprecated
    public OfferWalletObject[] zzIn() {
        return this.zzbpj;
    }
}
