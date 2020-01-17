package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbsE;
    public final boolean zzbsF;

    GetCloudSyncOptInStatusResponse(int i, int i2, boolean z, boolean z2) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsE = z;
        this.zzbsF = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzam.zza(this, parcel, i);
    }
}
