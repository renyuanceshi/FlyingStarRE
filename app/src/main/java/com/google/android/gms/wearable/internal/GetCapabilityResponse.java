package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new zzai();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzbsB;

    GetCapabilityResponse(int i, int i2, CapabilityInfoParcelable capabilityInfoParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsB = capabilityInfoParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzai.zza(this, parcel, i);
    }
}
