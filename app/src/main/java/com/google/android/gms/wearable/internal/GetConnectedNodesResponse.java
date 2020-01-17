package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new zzaq();
    public final int statusCode;
    public final int versionCode;
    public final List<NodeParcelable> zzbsI;

    GetConnectedNodesResponse(int i, int i2, List<NodeParcelable> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsI = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }
}
