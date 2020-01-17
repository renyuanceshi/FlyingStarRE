package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzm();
    private final int mVersionCode;
    String zzboi;
    String zzbop;
    Cart zzboz;
    boolean zzbpl;
    boolean zzbpm;
    boolean zzbpn;
    String zzbpo;
    String zzbpp;
    boolean zzbpq;
    boolean zzbpr;
    CountrySpecification[] zzbps;
    boolean zzbpt;
    boolean zzbpu;
    ArrayList<CountrySpecification> zzbpv;
    PaymentMethodTokenizationParameters zzbpw;
    ArrayList<Integer> zzbpx;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCardNetwork(int i) {
            if (MaskedWalletRequest.this.zzbpx == null) {
                MaskedWalletRequest.this.zzbpx = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbpx.add(Integer.valueOf(i));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbpx == null) {
                    MaskedWalletRequest.this.zzbpx = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbpx.addAll(collection);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzbpv == null) {
                MaskedWalletRequest.this.zzbpv = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzbpv.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> collection) {
            if (collection != null) {
                if (MaskedWalletRequest.this.zzbpv == null) {
                    MaskedWalletRequest.this.zzbpv = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzbpv.addAll(collection);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean z) {
            MaskedWalletRequest.this.zzbpu = z;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean z) {
            MaskedWalletRequest.this.zzbpt = z;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzboz = cart;
            return this;
        }

        public Builder setCurrencyCode(String str) {
            MaskedWalletRequest.this.zzboi = str;
            return this;
        }

        public Builder setEstimatedTotalPrice(String str) {
            MaskedWalletRequest.this.zzbpo = str;
            return this;
        }

        @Deprecated
        public Builder setIsBillingAgreement(boolean z) {
            MaskedWalletRequest.this.zzbpr = z;
            return this;
        }

        public Builder setMerchantName(String str) {
            MaskedWalletRequest.this.zzbpp = str;
            return this;
        }

        public Builder setMerchantTransactionId(String str) {
            MaskedWalletRequest.this.zzbop = str;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzbpw = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean z) {
            MaskedWalletRequest.this.zzbpl = z;
            return this;
        }

        public Builder setShippingAddressRequired(boolean z) {
            MaskedWalletRequest.this.zzbpm = z;
            return this;
        }

        @Deprecated
        public Builder setUseMinimalBillingAddress(boolean z) {
            MaskedWalletRequest.this.zzbpn = z;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbpt = true;
        this.zzbpu = true;
    }

    MaskedWalletRequest(int i, String str, boolean z, boolean z2, boolean z3, String str2, String str3, String str4, Cart cart, boolean z4, boolean z5, CountrySpecification[] countrySpecificationArr, boolean z6, boolean z7, ArrayList<CountrySpecification> arrayList, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> arrayList2) {
        this.mVersionCode = i;
        this.zzbop = str;
        this.zzbpl = z;
        this.zzbpm = z2;
        this.zzbpn = z3;
        this.zzbpo = str2;
        this.zzboi = str3;
        this.zzbpp = str4;
        this.zzboz = cart;
        this.zzbpq = z4;
        this.zzbpr = z5;
        this.zzbps = countrySpecificationArr;
        this.zzbpt = z6;
        this.zzbpu = z7;
        this.zzbpv = arrayList;
        this.zzbpw = paymentMethodTokenizationParameters;
        this.zzbpx = arrayList2;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzbpu;
    }

    public boolean allowPrepaidCard() {
        return this.zzbpt;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbpx;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbpv;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbps;
    }

    public Cart getCart() {
        return this.zzboz;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getEstimatedTotalPrice() {
        return this.zzbpo;
    }

    public String getMerchantName() {
        return this.zzbpp;
    }

    public String getMerchantTransactionId() {
        return this.zzbop;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbpw;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public boolean isBillingAgreement() {
        return this.zzbpr;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzbpl;
    }

    public boolean isShippingAddressRequired() {
        return this.zzbpm;
    }

    @Deprecated
    public boolean useMinimalBillingAddress() {
        return this.zzbpn;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
