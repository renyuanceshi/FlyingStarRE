package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetBuyFlowInitializationTokenRequest> CREATOR = new zzb();
    private final int mVersionCode;
    byte[] zzbpP;
    byte[] zzbpQ;

    GetBuyFlowInitializationTokenRequest() {
        this(1, (byte[]) null, (byte[]) null);
    }

    GetBuyFlowInitializationTokenRequest(int i, byte[] bArr, byte[] bArr2) {
        this.mVersionCode = i;
        this.zzbpP = bArr;
        this.zzbpQ = bArr2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
