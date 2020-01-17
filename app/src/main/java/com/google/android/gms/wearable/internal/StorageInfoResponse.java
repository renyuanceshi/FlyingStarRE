package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StorageInfoResponse implements SafeParcelable {
    public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new zzbl();
    public final int statusCode;
    public final int versionCode;
    public final long zzbta;
    public final List<PackageStorageInfo> zzbtc;

    StorageInfoResponse(int i, int i2, long j, List<PackageStorageInfo> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbta = j;
        this.zzbtc = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbl.zza(this, parcel, i);
    }
}
