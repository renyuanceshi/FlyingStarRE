package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PutDataResponse implements SafeParcelable {
    public static final Parcelable.Creator<PutDataResponse> CREATOR = new zzbf();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbsJ;

    PutDataResponse(int i, int i2, DataItemParcelable dataItemParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsJ = dataItemParcelable;
    }

    public PutDataResponse(int i, DataItemParcelable dataItemParcelable) {
        this(1, i, dataItemParcelable);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbf.zza(this, parcel, i);
    }
}
