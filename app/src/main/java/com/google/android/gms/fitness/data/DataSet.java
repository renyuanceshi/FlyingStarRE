package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private boolean zzawi;
    private final List<DataPoint> zzawp;
    private final List<DataSource> zzawq;

    DataSet(int i, DataSource dataSource, DataType dataType, List<RawDataPoint> list, List<DataSource> list2, boolean z) {
        this.zzawi = false;
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataSource.getDataType();
        this.zzawi = z;
        this.zzawp = new ArrayList(list.size());
        this.zzawq = i < 2 ? Collections.singletonList(dataSource) : list2;
        for (RawDataPoint dataPoint : list) {
            this.zzawp.add(new DataPoint(this.zzawq, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzx.zzz(dataSource);
        this.zzavT = dataSource.getDataType();
        this.zzawp = new ArrayList();
        this.zzawq = new ArrayList();
        this.zzawq.add(this.zzavU);
    }

    public DataSet(RawDataSet rawDataSet, List<DataSource> list) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzb(list, rawDataSet.zzaxg);
        this.zzavT = this.zzavU.getDataType();
        this.zzawq = list;
        this.zzawi = rawDataSet.zzawi;
        List<RawDataPoint> list2 = rawDataSet.zzaxj;
        this.zzawp = new ArrayList(list2.size());
        for (RawDataPoint dataPoint : list2) {
            this.zzawp.add(new DataPoint(this.zzawq, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb(dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzavU, dataSet.zzavU) && zzw.equal(this.zzawp, dataSet.zzawp) && this.zzawi == dataSet.zzawi;
    }

    private static <T> T zzb(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        zzx.zzb(dataSource.getStreamIdentifier().equals(this.zzavU.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzavU);
        dataPoint.zzui();
        zznw.zze(dataPoint);
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> iterable) {
        for (DataPoint add : iterable) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzavU);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && zza((DataSet) obj));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzawp);
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavU.getDataType();
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU);
    }

    public boolean isEmpty() {
        return this.zzawp.isEmpty();
    }

    public String toString() {
        List<RawDataPoint> zzuk = zzuk();
        String debugString = this.zzavU.toDebugString();
        Object obj = zzuk;
        if (this.zzawp.size() >= 10) {
            obj = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzawp.size()), zzuk.subList(0, 5)});
        }
        return String.format("DataSet{%s %s}", new Object[]{debugString, obj});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzawp.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzawq.contains(originalDataSource)) {
            this.zzawq.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    public boolean zzuc() {
        return this.zzawi;
    }

    /* access modifiers changed from: package-private */
    public List<RawDataPoint> zzuk() {
        return zzv(this.zzawq);
    }

    /* access modifiers changed from: package-private */
    public List<DataSource> zzul() {
        return this.zzawq;
    }

    /* access modifiers changed from: package-private */
    public List<RawDataPoint> zzv(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.zzawp.size());
        for (DataPoint rawDataPoint : this.zzawp) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }
}
