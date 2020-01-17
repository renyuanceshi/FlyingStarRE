package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Bucket> zzaBF;
    private int zzaBG;
    private final List<DataType> zzaBH;
    private final List<DataSet> zzawg;
    private final List<DataSource> zzawq;

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaBG = i2;
        this.zzawq = list3;
        this.zzaBH = list4;
        this.zzawg = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            this.zzawg.add(new DataSet(dataSet, list3));
        }
        this.zzaBF = new ArrayList(list2.size());
        for (RawBucket bucket : list2) {
            this.zzaBF.add(new Bucket(bucket, list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.mVersionCode = 5;
        this.zzawg = list;
        this.zzUX = status;
        this.zzaBF = list2;
        this.zzaBG = 1;
        this.zzawq = new ArrayList();
        this.zzaBH = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket next : list) {
            if (next.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, next.getDataSets());
                }
                return;
            }
        }
        this.zzaBF.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet next : list) {
            if (next.getDataSource().equals(dataSet.getDataSource())) {
                next.zzb((Iterable<DataPoint>) dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzUX.equals(dataReadResult.zzUX) && zzw.equal(this.zzawg, dataReadResult.zzawg) && zzw.equal(this.zzaBF, dataReadResult.zzaBF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && zzc((DataReadResult) obj));
    }

    public List<Bucket> getBuckets() {
        return this.zzaBF;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet next : this.zzawg) {
            if (dataSource.equals(next.getDataSource())) {
                return next;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.zzawg) {
            if (dataType.equals(next.getDataType())) {
                return next;
            }
        }
        return DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).build());
    }

    public List<DataSet> getDataSets() {
        return this.zzawg;
    }

    public Status getStatus() {
        return this.zzUX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzawg, this.zzaBF);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataSets", this.zzawg.size() > 5 ? this.zzawg.size() + " data sets" : this.zzawg).zzg("buckets", this.zzaBF.size() > 5 ? this.zzaBF.size() + " buckets" : this.zzaBF).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzawg);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzaBF);
        }
    }

    /* access modifiers changed from: package-private */
    public List<DataSource> zzul() {
        return this.zzawq;
    }

    public int zzvj() {
        return this.zzaBG;
    }

    /* access modifiers changed from: package-private */
    public List<RawBucket> zzvk() {
        ArrayList arrayList = new ArrayList(this.zzaBF.size());
        for (Bucket rawBucket : this.zzaBF) {
            arrayList.add(new RawBucket(rawBucket, this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<RawDataSet> zzvl() {
        ArrayList arrayList = new ArrayList(this.zzawg.size());
        for (DataSet rawDataSet : this.zzawg) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<DataType> zzvm() {
        return this.zzaBH;
    }
}
