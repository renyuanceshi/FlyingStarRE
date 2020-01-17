package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Parcelable.Creator<Operator> CREATOR = new zzn();
    public static final Operator zzauA = new Operator(">");
    public static final Operator zzauB = new Operator(">=");
    public static final Operator zzauC = new Operator("and");
    public static final Operator zzauD = new Operator("or");
    public static final Operator zzauE = new Operator("not");
    public static final Operator zzauF = new Operator("contains");
    public static final Operator zzaux = new Operator("=");
    public static final Operator zzauy = new Operator("<");
    public static final Operator zzauz = new Operator("<=");
    final String mTag;
    final int mVersionCode;

    Operator(int i, String str) {
        this.mVersionCode = i;
        this.mTag = str;
    }

    private Operator(String str) {
        this(1, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Operator operator = (Operator) obj;
            if (this.mTag == null) {
                if (operator.mTag != null) {
                    return false;
                }
            } else if (!this.mTag.equals(operator.mTag)) {
                return false;
            }
        }
        return true;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
