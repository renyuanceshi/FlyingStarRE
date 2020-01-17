package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TimeInterval implements SafeParcelable {
    public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();
    private final int mVersionCode;
    long zzbqP;
    long zzbqQ;

    TimeInterval() {
        this.mVersionCode = 1;
    }

    TimeInterval(int i, long j, long j2) {
        this.mVersionCode = i;
        this.zzbqP = j;
        this.zzbqQ = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
