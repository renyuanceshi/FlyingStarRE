package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
    private final int mVersionCode;
    private final Status zzUX;
    private final DataSet zzaxn;

    DailyTotalResult(int i, Status status, DataSet dataSet) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaxn = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.mVersionCode = 1;
        this.zzUX = status;
        this.zzaxn = dataSet;
    }

    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).build()), status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzUX.equals(dailyTotalResult.zzUX) && zzw.equal(this.zzaxn, dailyTotalResult.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DailyTotalResult) && zzb((DailyTotalResult) obj));
    }

    public Status getStatus() {
        return this.zzUX;
    }

    @Nullable
    public DataSet getTotal() {
        return this.zzaxn;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataPoint", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
