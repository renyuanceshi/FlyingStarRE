package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CreateWalletObjectsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
    private final int mVersionCode;
    LoyaltyWalletObject zzbol;
    OfferWalletObject zzbom;
    GiftCardWalletObject zzbon;

    CreateWalletObjectsRequest() {
        this.mVersionCode = 3;
    }

    CreateWalletObjectsRequest(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.mVersionCode = i;
        this.zzbol = loyaltyWalletObject;
        this.zzbom = offerWalletObject;
        this.zzbon = giftCardWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
