package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class DataStatsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataStatsResult> CREATOR = new zzf();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<DataSourceStatsResult> zzaBL;

    DataStatsResult(int i, Status status, List<DataSourceStatsResult> list) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaBL = list;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public List<DataSourceStatsResult> zzvn() {
        return this.zzaBL;
    }
}
