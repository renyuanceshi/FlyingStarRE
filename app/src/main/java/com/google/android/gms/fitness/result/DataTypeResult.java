package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzUX;
    private final DataType zzavT;

    DataTypeResult(int i, Status status, DataType dataType) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzavT = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.mVersionCode = 2;
        this.zzUX = status;
        this.zzavT = dataType;
    }

    public static DataTypeResult zzS(Status status) {
        return new DataTypeResult(status, (DataType) null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzUX.equals(dataTypeResult.zzUX) && zzw.equal(this.zzavT, dataTypeResult.zzavT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && zzb((DataTypeResult) obj));
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzavT);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataType", this.zzavT).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
