package com.google.android.gms.location.places;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator<PlaceRequest> CREATOR = new zzk();
    static final long zzaPJ = TimeUnit.HOURS.toMillis(1);
    private final int mPriority;
    final int mVersionCode;
    private final long zzaND;
    private final long zzaNY;
    private final PlaceFilter zzaPK;

    public PlaceRequest(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.mVersionCode = i;
        this.zzaPK = placeFilter;
        this.zzaNY = j;
        this.mPriority = i2;
        this.zzaND = j2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PlaceRequest)) {
                return false;
            }
            PlaceRequest placeRequest = (PlaceRequest) obj;
            if (!(zzw.equal(this.zzaPK, placeRequest.zzaPK) && this.zzaNY == placeRequest.zzaNY && this.mPriority == placeRequest.mPriority && this.zzaND == placeRequest.zzaND)) {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime() {
        return this.zzaND;
    }

    public long getInterval() {
        return this.zzaNY;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPK, Long.valueOf(this.zzaNY), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaND));
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return zzw.zzy(this).zzg("filter", this.zzaPK).zzg("interval", Long.valueOf(this.zzaNY)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaND)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public PlaceFilter zzyZ() {
        return this.zzaPK;
    }
}
