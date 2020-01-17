package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int mVersionCode;
    /* access modifiers changed from: private */
    public String zzVa;
    /* access modifiers changed from: private */
    public MaskedWalletRequest zzbqc;
    /* access modifiers changed from: private */
    public MaskedWallet zzbqd;
    /* access modifiers changed from: private */
    public int zzbqq;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            zzx.zza((WalletFragmentInitParams.this.zzbqd != null && WalletFragmentInitParams.this.zzbqc == null) || (WalletFragmentInitParams.this.zzbqd == null && WalletFragmentInitParams.this.zzbqc != null), (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (WalletFragmentInitParams.this.zzbqq < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String str) {
            String unused = WalletFragmentInitParams.this.zzVa = str;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            MaskedWallet unused = WalletFragmentInitParams.this.zzbqd = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            MaskedWalletRequest unused = WalletFragmentInitParams.this.zzbqc = maskedWalletRequest;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int i) {
            int unused = WalletFragmentInitParams.this.zzbqq = i;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzbqq = -1;
    }

    WalletFragmentInitParams(int i, String str, MaskedWalletRequest maskedWalletRequest, int i2, MaskedWallet maskedWallet) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzbqc = maskedWalletRequest;
        this.zzbqq = i2;
        this.zzbqd = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzbqd;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzbqc;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzbqq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
