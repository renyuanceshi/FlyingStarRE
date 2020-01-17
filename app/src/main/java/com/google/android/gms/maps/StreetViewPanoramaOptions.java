package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private Boolean zzaRQ;
    private Boolean zzaRW;
    private StreetViewPanoramaCamera zzaSD;
    private String zzaSE;
    private LatLng zzaSF;
    private Integer zzaSG;
    private Boolean zzaSH;
    private Boolean zzaSI;
    private Boolean zzaSJ;

    public StreetViewPanoramaOptions() {
        this.zzaSH = true;
        this.zzaRW = true;
        this.zzaSI = true;
        this.zzaSJ = true;
        this.mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.zzaSH = true;
        this.zzaRW = true;
        this.zzaSI = true;
        this.zzaSJ = true;
        this.mVersionCode = i;
        this.zzaSD = streetViewPanoramaCamera;
        this.zzaSF = latLng;
        this.zzaSG = num;
        this.zzaSE = str;
        this.zzaSH = zza.zza(b);
        this.zzaRW = zza.zza(b2);
        this.zzaSI = zza.zza(b3);
        this.zzaSJ = zza.zza(b4);
        this.zzaRQ = zza.zza(b5);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaSI;
    }

    public String getPanoramaId() {
        return this.zzaSE;
    }

    public LatLng getPosition() {
        return this.zzaSF;
    }

    public Integer getRadius() {
        return this.zzaSG;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaSJ;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaSD;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaRQ;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaSH;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaRW;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzaSI = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzaSD = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.zzaSE = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzaSF = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzaSF = latLng;
        this.zzaSG = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzaSJ = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzaRQ = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzaSH = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzaRW = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public byte zzAa() {
        return zza.zze(this.zzaSH);
    }

    /* access modifiers changed from: package-private */
    public byte zzAb() {
        return zza.zze(this.zzaSI);
    }

    /* access modifiers changed from: package-private */
    public byte zzAc() {
        return zza.zze(this.zzaSJ);
    }

    /* access modifiers changed from: package-private */
    public byte zzzL() {
        return zza.zze(this.zzaRQ);
    }

    /* access modifiers changed from: package-private */
    public byte zzzP() {
        return zza.zze(this.zzaRW);
    }
}
