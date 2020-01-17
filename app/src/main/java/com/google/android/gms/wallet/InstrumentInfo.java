package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzh();
    private final int mVersionCode;
    private String zzboI;
    private String zzboJ;

    InstrumentInfo(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzboI = str;
        this.zzboJ = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzboJ;
    }

    public String getInstrumentType() {
        return this.zzboI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
