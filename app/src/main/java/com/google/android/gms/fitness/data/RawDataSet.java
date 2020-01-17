package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@KeepName
public final class RawDataSet implements SafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new zzp();
    final int mVersionCode;
    public final boolean zzawi;
    public final int zzaxg;
    public final int zzaxi;
    public final List<RawDataPoint> zzaxj;

    public RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.mVersionCode = i;
        this.zzaxg = i2;
        this.zzaxi = i3;
        this.zzaxj = list;
        this.zzawi = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.mVersionCode = 3;
        this.zzaxj = dataSet.zzv(list);
        this.zzawi = dataSet.zzuc();
        this.zzaxg = zzt.zza(dataSet.getDataSource(), list);
        this.zzaxi = zzt.zza(dataSet.getDataType(), list2);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzaxg == rawDataSet.zzaxg && this.zzawi == rawDataSet.zzawi && zzw.equal(this.zzaxj, rawDataSet.zzaxj);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && zza((RawDataSet) obj));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaxg));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzaxg), this.zzaxj});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
