package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken implements SafeParcelable {
    public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzp();
    private final int mVersionCode;
    String zzbaW;
    int zzbpC;

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int i, int i2, String str) {
        this.mVersionCode = i;
        this.zzbpC = i2;
        this.zzbaW = str;
    }

    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbpC;
    }

    public String getToken() {
        return this.zzbaW;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
