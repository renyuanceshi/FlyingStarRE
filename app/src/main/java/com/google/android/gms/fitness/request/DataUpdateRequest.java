package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;
import java.util.concurrent.TimeUnit;

public class DataUpdateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataUpdateRequest> CREATOR = new zzm();
    private final int mVersionCode;
    private final long zzRD;
    private final zzow zzaAD;
    private final long zzavV;
    private final DataSet zzaxn;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzRD;
        /* access modifiers changed from: private */
        public long zzavV;
        /* access modifiers changed from: private */
        public DataSet zzaxn;

        private void zzuV() {
            zzx.zza(this.zzRD, (Object) "Must set a non-zero value for startTimeMillis/startTime");
            zzx.zza(this.zzavV, (Object) "Must set a non-zero value for endTimeMillis/endTime");
            zzx.zzb(this.zzaxn, (Object) "Must set the data set");
            for (DataPoint next : this.zzaxn.getDataPoints()) {
                long startTime = next.getStartTime(TimeUnit.MILLISECONDS);
                long endTime = next.getEndTime(TimeUnit.MILLISECONDS);
                zzx.zza(!((startTime > endTime ? 1 : (startTime == endTime ? 0 : -1)) > 0 || (((startTime > 0 ? 1 : (startTime == 0 ? 0 : -1)) != 0 && (startTime > this.zzRD ? 1 : (startTime == this.zzRD ? 0 : -1)) < 0) || (((startTime > 0 ? 1 : (startTime == 0 ? 0 : -1)) != 0 && (startTime > this.zzavV ? 1 : (startTime == this.zzavV ? 0 : -1)) > 0) || (endTime > this.zzavV ? 1 : (endTime == this.zzavV ? 0 : -1)) > 0 || (endTime > this.zzRD ? 1 : (endTime == this.zzRD ? 0 : -1)) < 0))), "Data Point's startTimeMillis %d, endTimeMillis %d should lie between timeRange provided in the request. StartTimeMillis %d, EndTimeMillis: %d", Long.valueOf(startTime), Long.valueOf(endTime), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
            }
        }

        public DataUpdateRequest build() {
            zzuV();
            return new DataUpdateRequest(this);
        }

        public Builder setDataSet(DataSet dataSet) {
            zzx.zzb(dataSet, (Object) "Must set the data set");
            this.zzaxn = dataSet;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            zzx.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            zzx.zzb(j2 >= j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzRD = timeUnit.toMillis(j);
            this.zzavV = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataUpdateRequest(int i, long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public DataUpdateRequest(long j, long j2, DataSet dataSet, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    private DataUpdateRequest(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.zzaxn, (IBinder) null);
    }

    public DataUpdateRequest(DataUpdateRequest dataUpdateRequest, IBinder iBinder) {
        this(dataUpdateRequest.zzlO(), dataUpdateRequest.zzud(), dataUpdateRequest.getDataSet(), iBinder);
    }

    private boolean zzb(DataUpdateRequest dataUpdateRequest) {
        return this.zzRD == dataUpdateRequest.zzRD && this.zzavV == dataUpdateRequest.zzavV && zzw.equal(this.zzaxn, dataUpdateRequest.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataUpdateRequest) && zzb((DataUpdateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSet", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public long zzud() {
        return this.zzavV;
    }
}
