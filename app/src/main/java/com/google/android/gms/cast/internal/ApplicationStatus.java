package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ApplicationStatus implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationStatus> CREATOR = new zza();
    private final int mVersionCode;
    private String zzadp;

    public ApplicationStatus() {
        this(1, (String) null);
    }

    ApplicationStatus(int i, String str) {
        this.mVersionCode = i;
        this.zzadp = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationStatus)) {
            return false;
        }
        return zzf.zza(this.zzadp, ((ApplicationStatus) obj).zzadp);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzadp);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzoe() {
        return this.zzadp;
    }
}
