package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomPropertyKey implements SafeParcelable {
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
    private static final Pattern zzasJ = Pattern.compile("[\\w.!@$%^&*()/-]+");
    final int mVersionCode;
    final int mVisibility;
    final String zzvs;

    CustomPropertyKey(int i, String str, int i2) {
        boolean z = true;
        zzx.zzb(str, (Object) "key");
        zzx.zzb(zzasJ.matcher(str).matches(), (Object) "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        zzx.zzb(z, (Object) "visibility must be either PUBLIC or PRIVATE");
        this.mVersionCode = i;
        this.zzvs = str;
        this.mVisibility = i2;
    }

    public CustomPropertyKey(String str, int i) {
        this(1, str, i);
    }

    public static CustomPropertyKey fromJson(JSONObject jSONObject) throws JSONException {
        return new CustomPropertyKey(jSONObject.getString("key"), jSONObject.getInt("visibility"));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CustomPropertyKey) {
                CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
                return customPropertyKey.getKey().equals(this.zzvs) && customPropertyKey.getVisibility() == this.mVisibility;
            }
        }
        return false;
    }

    public String getKey() {
        return this.zzvs;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.zzvs + this.mVisibility).hashCode();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", getKey());
        jSONObject.put("visibility", getVisibility());
        return jSONObject;
    }

    public String toString() {
        return "CustomPropertyKey(" + this.zzvs + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
