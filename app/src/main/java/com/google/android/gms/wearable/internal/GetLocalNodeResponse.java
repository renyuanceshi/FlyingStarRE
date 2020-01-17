package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetLocalNodeResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetLocalNodeResponse> CREATOR = new zzat();
    public final int statusCode;
    public final int versionCode;
    public final NodeParcelable zzbsL;

    GetLocalNodeResponse(int i, int i2, NodeParcelable nodeParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsL = nodeParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzat.zza(this, parcel, i);
    }
}
