package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BarcodeDetectorOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int versionCode;
    public int zzbnw;

    public BarcodeDetectorOptions() {
        this.versionCode = 1;
    }

    public BarcodeDetectorOptions(int i, int i2) {
        this.versionCode = i;
        this.zzbnw = i2;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza zza = CREATOR;
        zza.zza(this, parcel, i);
    }
}
