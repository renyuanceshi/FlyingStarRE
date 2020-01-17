package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
    private final int mVersionCode;
    private final List<LocationRequest> zzaBm;
    private final boolean zzaOf;
    private final boolean zzaOg;

    public static final class Builder {
        private boolean zzaOf = false;
        private boolean zzaOg = false;
        private final ArrayList<LocationRequest> zzaOh = new ArrayList<>();

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.zzaOh.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzaOh.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest((List) this.zzaOh, this.zzaOf, this.zzaOg);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzaOf = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzaOg = z;
            return this;
        }
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzaBm = list;
        this.zzaOf = z;
        this.zzaOg = z2;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this(3, list, z, z2);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public List<LocationRequest> zzuZ() {
        return Collections.unmodifiableList(this.zzaBm);
    }

    public boolean zzyK() {
        return this.zzaOf;
    }

    public boolean zzyL() {
        return this.zzaOg;
    }
}
