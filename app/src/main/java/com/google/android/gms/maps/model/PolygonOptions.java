package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final List<LatLng> zzaTJ;
    private final List<List<LatLng>> zzaTK;
    private boolean zzaTL;
    private float zzaTe;
    private int zzaTf;
    private int zzaTg;
    private float zzaTh;
    private boolean zzaTi;
    private boolean zzaTr;

    public PolygonOptions() {
        this.zzaTe = 10.0f;
        this.zzaTf = ViewCompat.MEASURED_STATE_MASK;
        this.zzaTg = 0;
        this.zzaTh = 0.0f;
        this.zzaTi = true;
        this.zzaTL = false;
        this.zzaTr = false;
        this.mVersionCode = 1;
        this.zzaTJ = new ArrayList();
        this.zzaTK = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2, boolean z3) {
        this.zzaTe = 10.0f;
        this.zzaTf = ViewCompat.MEASURED_STATE_MASK;
        this.zzaTg = 0;
        this.zzaTh = 0.0f;
        this.zzaTi = true;
        this.zzaTL = false;
        this.zzaTr = false;
        this.mVersionCode = i;
        this.zzaTJ = list;
        this.zzaTK = list2;
        this.zzaTe = f;
        this.zzaTf = i2;
        this.zzaTg = i3;
        this.zzaTh = f2;
        this.zzaTi = z;
        this.zzaTL = z2;
        this.zzaTr = z3;
    }

    public PolygonOptions add(LatLng latLng) {
        this.zzaTJ.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.zzaTJ.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzaTJ.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.zzaTK.add(arrayList);
        return this;
    }

    public PolygonOptions clickable(boolean z) {
        this.zzaTr = z;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.zzaTg = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.zzaTL = z;
        return this;
    }

    public int getFillColor() {
        return this.zzaTg;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaTK;
    }

    public List<LatLng> getPoints() {
        return this.zzaTJ;
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

    public boolean isClickable() {
        return this.zzaTr;
    }

    public boolean isGeodesic() {
        return this.zzaTL;
    }

    public boolean isVisible() {
        return this.zzaTi;
    }

    public PolygonOptions strokeColor(int i) {
        this.zzaTf = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.zzaTe = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.zzaTi = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.zzaTh = f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public List zzAl() {
        return this.zzaTK;
    }
}
