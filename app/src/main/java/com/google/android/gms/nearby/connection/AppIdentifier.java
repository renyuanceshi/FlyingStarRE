package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class AppIdentifier implements SafeParcelable {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zza();
    private final int mVersionCode;
    private final String zzaxk;

    AppIdentifier(int i, String str) {
        this.mVersionCode = i;
        this.zzaxk = zzx.zzh(str, "Missing application identifier value");
    }

    public AppIdentifier(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
