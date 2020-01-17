package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzmy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class Value implements SafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzu();
    private final int mVersionCode;
    private final int zzawZ;
    private float zzaxe;
    private boolean zzaxq;
    private String zzaxr;
    private Map<String, MapValue> zzaxs;
    private int[] zzaxt;
    private float[] zzaxu;
    private byte[] zzaxv;

    public Value(int i) {
        this(3, i, false, 0.0f, (String) null, (Bundle) null, (int[]) null, (float[]) null, (byte[]) null);
    }

    Value(int i, int i2, boolean z, float f, String str, Bundle bundle, int[] iArr, float[] fArr, byte[] bArr) {
        this.mVersionCode = i;
        this.zzawZ = i2;
        this.zzaxq = z;
        this.zzaxe = f;
        this.zzaxr = str;
        this.zzaxs = zzv(bundle);
        this.zzaxt = iArr;
        this.zzaxu = fArr;
        this.zzaxv = bArr;
    }

    private boolean zza(Value value) {
        if (this.zzawZ != value.zzawZ || this.zzaxq != value.zzaxq) {
            return false;
        }
        switch (this.zzawZ) {
            case 1:
                if (asInt() != value.asInt()) {
                    return false;
                }
                break;
            case 2:
                if (this.zzaxe != value.zzaxe) {
                    return false;
                }
                break;
            case 3:
                return zzw.equal(this.zzaxr, value.zzaxr);
            case 4:
                return zzw.equal(this.zzaxs, value.zzaxs);
            case 5:
                return Arrays.equals(this.zzaxt, value.zzaxt);
            case 6:
                return Arrays.equals(this.zzaxu, value.zzaxu);
            case 7:
                return Arrays.equals(this.zzaxv, value.zzaxv);
            default:
                if (this.zzaxe != value.zzaxe) {
                    return false;
                }
                break;
        }
        return true;
    }

    private static Map<String, MapValue> zzv(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        ArrayMap arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzx.zza(this.zzawZ == 2, (Object) "Value is not in float format");
        return this.zzaxe;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzawZ != 1) {
            z = false;
        }
        zzx.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzaxe);
    }

    public String asString() {
        zzx.zza(this.zzawZ == 3, (Object) "Value is not in string format");
        return this.zzaxr;
    }

    public void clearKey(String str) {
        zzx.zza(this.zzawZ == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzaxs != null) {
            this.zzaxs.remove(str);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Value) && zza((Value) obj));
    }

    public int getFormat() {
        return this.zzawZ;
    }

    @Nullable
    public Float getKeyValue(String str) {
        zzx.zza(this.zzawZ == 4, (Object) "Value is not in float map format");
        if (this.zzaxs == null || !this.zzaxs.containsKey(str)) {
            return null;
        }
        return Float.valueOf(this.zzaxs.get(str).asFloat());
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaxe), this.zzaxr, this.zzaxs, this.zzaxt, this.zzaxu, this.zzaxv);
    }

    public boolean isSet() {
        return this.zzaxq;
    }

    public void setActivity(String str) {
        setInt(FitnessActivities.zzdm(str));
    }

    public void setFloat(float f) {
        zzx.zza(this.zzawZ == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = f;
    }

    public void setInt(int i) {
        zzx.zza(this.zzawZ == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxe = Float.intBitsToFloat(i);
    }

    public void setKeyValue(String str, float f) {
        zzx.zza(this.zzawZ == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        if (this.zzaxs == null) {
            this.zzaxs = new HashMap();
        }
        this.zzaxs.put(str, MapValue.zzc(f));
    }

    public void setString(String str) {
        zzx.zza(this.zzawZ == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzaxq = true;
        this.zzaxr = str;
    }

    public String toString() {
        if (!this.zzaxq) {
            return "unset";
        }
        switch (this.zzawZ) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.zzaxe);
            case 3:
                return this.zzaxr;
            case 4:
                return new TreeMap(this.zzaxs).toString();
            case 5:
                return Arrays.toString(this.zzaxt);
            case 6:
                return Arrays.toString(this.zzaxu);
            case 7:
                return zzmy.zza(this.zzaxv, 0, this.zzaxv.length, false);
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public String zzuA() {
        return this.zzaxr;
    }

    /* access modifiers changed from: package-private */
    public Bundle zzuB() {
        if (this.zzaxs == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzaxs.size());
        for (Map.Entry next : this.zzaxs.entrySet()) {
            bundle.putParcelable((String) next.getKey(), (Parcelable) next.getValue());
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public int[] zzuC() {
        return this.zzaxt;
    }

    /* access modifiers changed from: package-private */
    public float[] zzuD() {
        return this.zzaxu;
    }

    /* access modifiers changed from: package-private */
    public byte[] zzuE() {
        return this.zzaxv;
    }

    /* access modifiers changed from: package-private */
    public float zzuv() {
        return this.zzaxe;
    }
}
