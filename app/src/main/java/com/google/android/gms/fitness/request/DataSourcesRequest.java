package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzoi;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int mVersionCode;
    private final List<Integer> zzaAV;
    private final boolean zzaAW;
    private final zzoi zzaAX;
    private final List<DataType> zzawe;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean zzaAW = false;
        /* access modifiers changed from: private */
        public DataType[] zzaAY = new DataType[0];
        /* access modifiers changed from: private */
        public int[] zzaAZ = {0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            zzx.zza(this.zzaAY.length > 0, (Object) "Must add at least one data type");
            if (this.zzaAZ.length <= 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzaAZ = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaAY = dataTypeArr;
            return this;
        }
    }

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzawe = list;
        this.zzaAV = list2;
        this.zzaAW = z;
        this.zzaAX = zzoi.zza.zzbD(iBinder);
    }

    private DataSourcesRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), Arrays.asList(zzmn.zza(builder.zzaAZ)), builder.zzaAW, (zzoi) null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzoi zzoi) {
        this(dataSourcesRequest.zzawe, dataSourcesRequest.zzaAV, dataSourcesRequest.zzaAW, zzoi);
    }

    public DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zzoi zzoi) {
        this.mVersionCode = 4;
        this.zzawe = list;
        this.zzaAV = list2;
        this.zzaAW = z;
        this.zzaAX = zzoi;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAX == null) {
            return null;
        }
        return this.zzaAX.asBinder();
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzw.zza zzg = zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("sourceTypes", this.zzaAV);
        if (this.zzaAW) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public List<Integer> zzuT() {
        return this.zzaAV;
    }

    public boolean zzuU() {
        return this.zzaAW;
    }
}
