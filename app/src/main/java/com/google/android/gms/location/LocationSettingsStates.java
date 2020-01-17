package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
    private final int mVersionCode;
    private final boolean zzaOj;
    private final boolean zzaOk;
    private final boolean zzaOl;
    private final boolean zzaOm;
    private final boolean zzaOn;
    private final boolean zzaOo;

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mVersionCode = i;
        this.zzaOj = z;
        this.zzaOk = z2;
        this.zzaOl = z3;
        this.zzaOm = z4;
        this.zzaOn = z5;
        this.zzaOo = z6;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBlePresent() {
        return this.zzaOo;
    }

    public boolean isBleUsable() {
        return this.zzaOl;
    }

    public boolean isGpsPresent() {
        return this.zzaOm;
    }

    public boolean isGpsUsable() {
        return this.zzaOj;
    }

    public boolean isLocationPresent() {
        return this.zzaOm || this.zzaOn;
    }

    public boolean isLocationUsable() {
        return this.zzaOj || this.zzaOk;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzaOn;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzaOk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
