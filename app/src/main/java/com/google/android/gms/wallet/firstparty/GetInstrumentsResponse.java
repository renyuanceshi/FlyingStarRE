package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsResponse> CREATOR = new zze();
    private final int mVersionCode;
    String[] zzbpT;
    byte[][] zzbpU;

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0][]);
    }

    GetInstrumentsResponse(int i, String[] strArr, byte[][] bArr) {
        this.mVersionCode = i;
        this.zzbpT = strArr;
        this.zzbpU = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
