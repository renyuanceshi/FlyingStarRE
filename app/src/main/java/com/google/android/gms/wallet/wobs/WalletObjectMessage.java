package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletObjectMessage implements SafeParcelable {
    public static final Parcelable.Creator<WalletObjectMessage> CREATOR = new zzi();
    String body;
    private final int mVersionCode;
    String zzbqO;
    TimeInterval zzbqR;
    UriData zzbqS;
    UriData zzbqT;

    WalletObjectMessage() {
        this.mVersionCode = 1;
    }

    WalletObjectMessage(int i, String str, String str2, TimeInterval timeInterval, UriData uriData, UriData uriData2) {
        this.mVersionCode = i;
        this.zzbqO = str;
        this.body = str2;
        this.zzbqR = timeInterval;
        this.zzbqS = uriData;
        this.zzbqT = uriData2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
