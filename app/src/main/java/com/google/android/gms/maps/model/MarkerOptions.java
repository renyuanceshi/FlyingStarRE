package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private float mAlpha;
    private final int mVersionCode;
    private LatLng zzaSF;
    private BitmapDescriptor zzaTA;
    private boolean zzaTB;
    private boolean zzaTC;
    private float zzaTD;
    private float zzaTE;
    private float zzaTF;
    private boolean zzaTi;
    private float zzaTp;
    private float zzaTq;
    private String zzaTz;
    private String zzapg;

    public MarkerOptions() {
        this.zzaTp = 0.5f;
        this.zzaTq = 1.0f;
        this.zzaTi = true;
        this.zzaTC = false;
        this.zzaTD = 0.0f;
        this.zzaTE = 0.5f;
        this.zzaTF = 0.0f;
        this.mAlpha = 1.0f;
        this.mVersionCode = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.zzaTp = 0.5f;
        this.zzaTq = 1.0f;
        this.zzaTi = true;
        this.zzaTC = false;
        this.zzaTD = 0.0f;
        this.zzaTE = 0.5f;
        this.zzaTF = 0.0f;
        this.mAlpha = 1.0f;
        this.mVersionCode = i;
        this.zzaSF = latLng;
        this.zzapg = str;
        this.zzaTz = str2;
        this.zzaTA = iBinder == null ? null : new BitmapDescriptor(zzd.zza.zzbs(iBinder));
        this.zzaTp = f;
        this.zzaTq = f2;
        this.zzaTB = z;
        this.zzaTi = z2;
        this.zzaTC = z3;
        this.zzaTD = f3;
        this.zzaTE = f4;
        this.zzaTF = f5;
        this.mAlpha = f6;
    }

    public MarkerOptions alpha(float f) {
        this.mAlpha = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.zzaTp = f;
        this.zzaTq = f2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.zzaTB = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.zzaTC = z;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzaTp;
    }

    public float getAnchorV() {
        return this.zzaTq;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaTA;
    }

    public float getInfoWindowAnchorU() {
        return this.zzaTE;
    }

    public float getInfoWindowAnchorV() {
        return this.zzaTF;
    }

    public LatLng getPosition() {
        return this.zzaSF;
    }

    public float getRotation() {
        return this.zzaTD;
    }

    public String getSnippet() {
        return this.zzaTz;
    }

    public String getTitle() {
        return this.zzapg;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzaTA = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.zzaTE = f;
        this.zzaTF = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.zzaTB;
    }

    public boolean isFlat() {
        return this.zzaTC;
    }

    public boolean isVisible() {
        return this.zzaTi;
    }

    public MarkerOptions position(LatLng latLng) {
        this.zzaSF = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.zzaTD = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.zzaTz = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.zzapg = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.zzaTi = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzAk() {
        if (this.zzaTA == null) {
            return null;
        }
        return this.zzaTA.zzzH().asBinder();
    }
}
