package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ChannelSendFileResponse implements SafeParcelable {
    public static final Parcelable.Creator<ChannelSendFileResponse> CREATOR = new zzs();
    public final int statusCode;
    public final int versionCode;

    ChannelSendFileResponse(int i, int i2) {
        this.versionCode = i;
        this.statusCode = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }
}
