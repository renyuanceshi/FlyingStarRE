package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AttestationData implements SafeParcelable {
    public static final Parcelable.Creator<AttestationData> CREATOR = new zza();
    public final int mVersionCode;
    private String zzbgu;

    AttestationData(int i, String str) {
        this.mVersionCode = i;
        this.zzbgu = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getJwsResult() {
        return this.zzbgu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
