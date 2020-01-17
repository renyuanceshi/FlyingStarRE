package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private Boolean zzaRP;
    private Boolean zzaRQ;
    private int zzaRR;
    private CameraPosition zzaRS;
    private Boolean zzaRT;
    private Boolean zzaRU;
    private Boolean zzaRV;
    private Boolean zzaRW;
    private Boolean zzaRX;
    private Boolean zzaRY;
    private Boolean zzaRZ;
    private Boolean zzaSa;
    private Boolean zzaSb;

    public GoogleMapOptions() {
        this.zzaRR = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.zzaRR = -1;
        this.mVersionCode = i;
        this.zzaRP = zza.zza(b);
        this.zzaRQ = zza.zza(b2);
        this.zzaRR = i2;
        this.zzaRS = cameraPosition;
        this.zzaRT = zza.zza(b3);
        this.zzaRU = zza.zza(b4);
        this.zzaRV = zza.zza(b5);
        this.zzaRW = zza.zza(b6);
        this.zzaRX = zza.zza(b7);
        this.zzaRY = zza.zza(b8);
        this.zzaRZ = zza.zza(b9);
        this.zzaSa = zza.zza(b10);
        this.zzaSb = zza.zza(b11);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.zzaSb = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzaRS = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.zzaRU = Boolean.valueOf(z);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getAmbientEnabled() {
        return this.zzaSb;
    }

    public CameraPosition getCamera() {
        return this.zzaRS;
    }

    public Boolean getCompassEnabled() {
        return this.zzaRU;
    }

    public Boolean getLiteMode() {
        return this.zzaRZ;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzaSa;
    }

    public int getMapType() {
        return this.zzaRR;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzaRY;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzaRV;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzaRX;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaRQ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZOrderOnTop() {
        return this.zzaRP;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzaRT;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaRW;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.zzaRZ = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzaSa = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.zzaRR = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzaRY = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzaRV = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaRX = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzaRQ = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaRP = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzaRT = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzaRW = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public byte zzzK() {
        return zza.zze(this.zzaRP);
    }

    /* access modifiers changed from: package-private */
    public byte zzzL() {
        return zza.zze(this.zzaRQ);
    }

    /* access modifiers changed from: package-private */
    public byte zzzM() {
        return zza.zze(this.zzaRT);
    }

    /* access modifiers changed from: package-private */
    public byte zzzN() {
        return zza.zze(this.zzaRU);
    }

    /* access modifiers changed from: package-private */
    public byte zzzO() {
        return zza.zze(this.zzaRV);
    }

    /* access modifiers changed from: package-private */
    public byte zzzP() {
        return zza.zze(this.zzaRW);
    }

    /* access modifiers changed from: package-private */
    public byte zzzQ() {
        return zza.zze(this.zzaRX);
    }

    /* access modifiers changed from: package-private */
    public byte zzzR() {
        return zza.zze(this.zzaRY);
    }

    /* access modifiers changed from: package-private */
    public byte zzzS() {
        return zza.zze(this.zzaRZ);
    }

    /* access modifiers changed from: package-private */
    public byte zzzT() {
        return zza.zze(this.zzaSa);
    }

    /* access modifiers changed from: package-private */
    public byte zzzU() {
        return zza.zze(this.zzaSb);
    }
}
