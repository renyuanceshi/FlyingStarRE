package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private LatLng zzaTc;
    private double zzaTd;
    private float zzaTe;
    private int zzaTf;
    private int zzaTg;
    private float zzaTh;
    private boolean zzaTi;

    public CircleOptions() {
        this.zzaTc = null;
        this.zzaTd = 0.0d;
        this.zzaTe = 10.0f;
        this.zzaTf = ViewCompat.MEASURED_STATE_MASK;
        this.zzaTg = 0;
        this.zzaTh = 0.0f;
        this.zzaTi = true;
        this.mVersionCode = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.zzaTc = null;
        this.zzaTd = 0.0d;
        this.zzaTe = 10.0f;
        this.zzaTf = ViewCompat.MEASURED_STATE_MASK;
        this.zzaTg = 0;
        this.zzaTh = 0.0f;
        this.zzaTi = true;
        this.mVersionCode = i;
        this.zzaTc = latLng;
        this.zzaTd = d;
        this.zzaTe = f;
        this.zzaTf = i2;
        this.zzaTg = i3;
        this.zzaTh = f2;
        this.zzaTi = z;
    }

    public CircleOptions center(LatLng latLng) {
        this.zzaTc = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.zzaTg = i;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaTc;
    }

    public int getFillColor() {
        return this.zzaTg;
    }

    public double getRadius() {
        return this.zzaTd;
    }

    public int getStrokeColor() {
        return this.zzaTf;
    }

    public float getStrokeWidth() {
        return this.zzaTe;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaTh;
    }

    public boolean isVisible() {
        return this.zzaTi;
    }

    public CircleOptions radius(double d) {
        this.zzaTd = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.zzaTf = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.zzaTe = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.zzaTi = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.zzaTh = f;
        return this;
    }
}
