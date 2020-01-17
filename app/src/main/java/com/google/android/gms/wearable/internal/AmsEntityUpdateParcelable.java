package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AmsEntityUpdateParcelable implements SafeParcelable, zzb {
    public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
    private final String mValue;
    final int mVersionCode;
    private byte zzbrF;
    private final byte zzbrG;

    AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.zzbrF = (byte) b;
        this.mVersionCode = i;
        this.zzbrG = (byte) b2;
        this.mValue = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
            if (!(this.zzbrF == amsEntityUpdateParcelable.zzbrF && this.mVersionCode == amsEntityUpdateParcelable.mVersionCode && this.zzbrG == amsEntityUpdateParcelable.zzbrG && this.mValue.equals(amsEntityUpdateParcelable.mValue))) {
                return false;
            }
        }
        return true;
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.zzbrF) * 31) + this.zzbrG) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.zzbrF + ", mAttributeId=" + this.zzbrG + ", mValue='" + this.mValue + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public byte zzIA() {
        return this.zzbrG;
    }

    public byte zzIz() {
        return this.zzbrF;
    }
}
