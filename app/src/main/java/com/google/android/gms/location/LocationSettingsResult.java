package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzUX;
    private final LocationSettingsStates zzaOi;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaOi = locationSettingsStates;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, (LocationSettingsStates) null);
    }

    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzaOi;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}