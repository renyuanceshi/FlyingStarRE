package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzns;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzd();
    private final int mVersionCode;
    private final DataSource zzavU;
    private long zzawj;
    private long zzawk;
    private final Value[] zzawl;
    private DataSource zzawm;
    private long zzawn;
    private long zzawo;

    DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzawm = dataSource2;
        this.zzawj = j;
        this.zzawk = j2;
        this.zzawl = valueArr;
        this.zzawn = j3;
        this.zzawo = j4;
    }

    private DataPoint(DataSource dataSource) {
        this.mVersionCode = 4;
        this.zzavU = (DataSource) zzx.zzb(dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzawl = new Value[fields.size()];
        Iterator<Field> it = fields.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                this.zzawl[i2] = new Value(it.next().getFormat());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzawj), 0), zza(Long.valueOf(rawDataPoint.zzawk), 0), rawDataPoint.zzawl, dataSource2, zza(Long.valueOf(rawDataPoint.zzawn), 0), zza(Long.valueOf(rawDataPoint.zzawo), 0));
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(zza(list, rawDataPoint.zzaxg), zza(list, rawDataPoint.zzaxh), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zza(List<DataSource> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    private boolean zza(DataPoint dataPoint) {
        return zzw.equal(this.zzavU, dataPoint.zzavU) && this.zzawj == dataPoint.zzawj && this.zzawk == dataPoint.zzawk && Arrays.equals(this.zzawl, dataPoint.zzawl) && zzw.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource());
    }

    private void zzeO(int i) {
        List<Field> fields = getDataType().getFields();
        int size = fields.size();
        zzx.zzb(i == size, "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(size), fields);
    }

    private boolean zzue() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataPoint) && zza((DataPoint) obj));
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavU.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawj, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzawm != null ? this.zzawm : this.zzavU;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawk, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzawj, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzawj;
    }

    public Value getValue(Field field) {
        return this.zzawl[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, Long.valueOf(this.zzawj), Long.valueOf(this.zzawk));
    }

    public DataPoint setFloatValues(float... fArr) {
        zzeO(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.zzawl[i].setFloat(fArr[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... iArr) {
        zzeO(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.zzawl[i].setInt(iArr[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.zzawk = timeUnit.toNanos(j);
        this.zzawj = timeUnit.toNanos(j2);
        return this;
    }

    public DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.zzawj = timeUnit.toNanos(j);
        if (zzue() && zzns.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzawj = zzns.zza(this.zzawj, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[]{Arrays.toString(this.zzawl), Long.valueOf(this.zzawk), Long.valueOf(this.zzawj), Long.valueOf(this.zzawn), Long.valueOf(this.zzawo), this.zzavU.toDebugString(), this.zzawm != null ? this.zzawm.toDebugString() : "N/A"});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public Value[] zzuf() {
        return this.zzawl;
    }

    public long zzug() {
        return this.zzawn;
    }

    public long zzuh() {
        return this.zzawo;
    }

    public void zzui() {
        zzx.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzx.zzb(this.zzawj > 0, "Data point does not have the timestamp set: %s", this);
        zzx.zzb(this.zzawk <= this.zzawj, "Data point with start time greater than end time found: %s", this);
    }

    public long zzuj() {
        return this.zzawk;
    }
}
