package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NearbyDeviceFilter implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceFilter> CREATOR = new zzg();
    final int mVersionCode;
    final int zzbci;
    final byte[] zzbcj;
    final boolean zzbck;

    NearbyDeviceFilter(int i, int i2, byte[] bArr, boolean z) {
        this.mVersionCode = i;
        this.zzbci = i2;
        this.zzbcj = bArr;
        this.zzbck = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
