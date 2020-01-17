package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzoh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzRD;
    private final List<DataSource> zzaAF;
    private final List<DataType> zzaAK;
    private final List<DataSource> zzaAL;
    private final long zzaAM;
    private final DataSource zzaAN;
    private final int zzaAO;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzoh zzaAR;
    private final List<Device> zzaAS;
    private final long zzavV;
    private final List<DataType> zzawe;
    private final int zzawh;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzRD;
        /* access modifiers changed from: private */
        public List<DataSource> zzaAF = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataType> zzaAK = new ArrayList();
        /* access modifiers changed from: private */
        public List<DataSource> zzaAL = new ArrayList();
        /* access modifiers changed from: private */
        public long zzaAM = 0;
        /* access modifiers changed from: private */
        public DataSource zzaAN;
        /* access modifiers changed from: private */
        public int zzaAO = 0;
        /* access modifiers changed from: private */
        public boolean zzaAP = false;
        /* access modifiers changed from: private */
        public boolean zzaAQ = false;
        /* access modifiers changed from: private */
        public List<Device> zzaAS = new ArrayList();
        /* access modifiers changed from: private */
        public long zzavV;
        /* access modifiers changed from: private */
        public List<DataType> zzawe = new ArrayList();
        /* access modifiers changed from: private */
        public int zzawh = 0;

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            zzx.zzb(dataSource, (Object) "Attempting to add a null data source");
            zzx.zza(!this.zzaAF.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType2), "Unsupported input data type specified for aggregation: %s", dataType2);
            zzx.zzb(DataType.getAggregatesForInput(dataType2).contains(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
            if (!this.zzaAL.contains(dataSource)) {
                this.zzaAL.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            zzx.zzb(dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzawe.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzx.zzb(DataType.getAggregatesForInput(dataType).contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.zzaAK.contains(dataType)) {
                this.zzaAK.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzx.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaAN = dataSource;
            this.zzawh = 4;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            zzx.zzb(dataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzaAN = dataSource;
            this.zzawh = 3;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzawh = 2;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            zzx.zzb(this.zzawh == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzawh));
            zzx.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzawh = 1;
            this.zzaAM = timeUnit.toMillis((long) i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            zzx.zza(!this.zzaAF.isEmpty() || !this.zzawe.isEmpty() || !this.zzaAL.isEmpty() || !this.zzaAK.isEmpty(), (Object) "Must add at least one data source (aggregated or detailed)");
            zzx.zza(this.zzRD > 0, "Invalid start time: %s", Long.valueOf(this.zzRD));
            zzx.zza(this.zzavV > 0 && this.zzavV > this.zzRD, "Invalid end time: %s", Long.valueOf(this.zzavV));
            boolean z2 = this.zzaAL.isEmpty() && this.zzaAK.isEmpty();
            if ((!z2 || this.zzawh != 0) && (z2 || this.zzawh == 0)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzaAQ = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb(dataSource, (Object) "Attempting to add a null data source");
            zzx.zzb(!this.zzaAL.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb(dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzaAK.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            zzx.zzb(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.zzaAO = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(j);
            this.zzavV = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, List<Device> list5) {
        this.mVersionCode = i;
        this.zzawe = list;
        this.zzaAF = list2;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaAK = list3;
        this.zzaAL = list4;
        this.zzawh = i2;
        this.zzaAM = j3;
        this.zzaAN = dataSource;
        this.zzaAO = i3;
        this.zzaAP = z;
        this.zzaAQ = z2;
        this.zzaAR = iBinder == null ? null : zzoh.zza.zzbC(iBinder);
        this.zzaAS = list5 == null ? Collections.emptyList() : list5;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzawe, builder.zzaAF, builder.zzRD, builder.zzavV, builder.zzaAK, builder.zzaAL, builder.zzawh, builder.zzaAM, builder.zzaAN, builder.zzaAO, builder.zzaAP, builder.zzaAQ, (zzoh) null, builder.zzaAS);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, zzoh zzoh) {
        this(dataReadRequest.zzawe, dataReadRequest.zzaAF, dataReadRequest.zzRD, dataReadRequest.zzavV, dataReadRequest.zzaAK, dataReadRequest.zzaAL, dataReadRequest.zzawh, dataReadRequest.zzaAM, dataReadRequest.zzaAN, dataReadRequest.zzaAO, dataReadRequest.zzaAP, dataReadRequest.zzaAQ, zzoh, dataReadRequest.zzaAS);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, zzoh zzoh, List<Device> list5) {
        this(5, list, list2, j, j2, list3, list4, i, j3, dataSource, i2, z, z2, zzoh == null ? null : zzoh.asBinder(), list5);
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzawe.equals(dataReadRequest.zzawe) && this.zzaAF.equals(dataReadRequest.zzaAF) && this.zzRD == dataReadRequest.zzRD && this.zzavV == dataReadRequest.zzavV && this.zzawh == dataReadRequest.zzawh && this.zzaAL.equals(dataReadRequest.zzaAL) && this.zzaAK.equals(dataReadRequest.zzaAK) && zzw.equal(this.zzaAN, dataReadRequest.zzaAN) && this.zzaAM == dataReadRequest.zzaAM && this.zzaAQ == dataReadRequest.zzaAQ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && zzb((DataReadRequest) obj));
    }

    public DataSource getActivityDataSource() {
        return this.zzaAN;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzaAL;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzaAK;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaAM, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzawh;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAR == null) {
            return null;
        }
        return this.zzaAR.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzaAO;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzawh), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.zzawe.isEmpty()) {
            for (DataType zzuo : this.zzawe) {
                sb.append(zzuo.zzuo()).append(" ");
            }
        }
        if (!this.zzaAF.isEmpty()) {
            for (DataSource debugString : this.zzaAF) {
                sb.append(debugString.toDebugString()).append(" ");
            }
        }
        if (this.zzawh != 0) {
            sb.append("bucket by ").append(Bucket.zzeM(this.zzawh));
            if (this.zzaAM > 0) {
                sb.append(" >").append(this.zzaAM).append("ms");
            }
            sb.append(": ");
        }
        if (!this.zzaAK.isEmpty()) {
            for (DataType zzuo2 : this.zzaAK) {
                sb.append(zzuo2.zzuo()).append(" ");
            }
        }
        if (!this.zzaAL.isEmpty()) {
            for (DataSource debugString2 : this.zzaAL) {
                sb.append(debugString2.toDebugString()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), Long.valueOf(this.zzavV)}));
        if (this.zzaAN != null) {
            sb.append("activities: ").append(this.zzaAN.toDebugString());
        }
        if (this.zzaAQ) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public long zzuR() {
        return this.zzaAM;
    }

    public List<Device> zzuS() {
        return this.zzaAS;
    }

    public long zzud() {
        return this.zzavV;
    }
}
