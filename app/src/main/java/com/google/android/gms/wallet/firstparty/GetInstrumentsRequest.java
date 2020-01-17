package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetInstrumentsRequest> CREATOR = new zzd();
    private final int mVersionCode;
    int[] zzbpS;

    GetInstrumentsRequest() {
        this(1, (int[]) null);
    }

    GetInstrumentsRequest(int i, int[] iArr) {
        this.mVersionCode = i;
        this.zzbpS = iArr;
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
