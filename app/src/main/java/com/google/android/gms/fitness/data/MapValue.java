package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue implements SafeParcelable {
    public static final Parcelable.Creator<MapValue> CREATOR = new zzm();
    private final int mVersionCode;
    private final int zzawZ;
    private final float zzaxe;

    public MapValue(int i, float f) {
        this(1, i, f);
    }

    MapValue(int i, int i2, float f) {
        this.mVersionCode = i;
        this.zzawZ = i2;
        this.zzaxe = f;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzawZ != mapValue.zzawZ) {
            return false;
        }
        switch (this.zzawZ) {
            case 2:
                if (asFloat() != mapValue.asFloat()) {
                    return false;
                }
                break;
            default:
                if (this.zzaxe != mapValue.zzaxe) {
                    return false;
                }
                break;
        }
        return true;
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzx.zza(this.zzawZ == 2, (Object) "Value is not in float format");
        return this.zzaxe;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof MapValue) && zza((MapValue) obj));
    }

    /* access modifiers changed from: package-private */
    public int getFormat() {
        return this.zzawZ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzaxe;
    }

    public String toString() {
        switch (this.zzawZ) {
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public float zzuv() {
        return this.zzaxe;
    }
}
