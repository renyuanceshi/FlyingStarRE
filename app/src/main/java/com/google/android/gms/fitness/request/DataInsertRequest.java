package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzow;

public class DataInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final boolean zzaAJ;
    private final DataSet zzaxn;

    DataInsertRequest(int i, DataSet dataSet, IBinder iBinder, boolean z) {
        this.mVersionCode = i;
        this.zzaxn = dataSet;
        this.zzaAD = zzow.zza.zzbR(iBinder);
        this.zzaAJ = z;
    }

    public DataInsertRequest(DataSet dataSet, zzow zzow, boolean z) {
        this.mVersionCode = 4;
        this.zzaxn = dataSet;
        this.zzaAD = zzow;
        this.zzaAJ = z;
    }

    private boolean zzc(DataInsertRequest dataInsertRequest) {
        return zzw.equal(this.zzaxn, dataInsertRequest.zzaxn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataInsertRequest) && zzc((DataInsertRequest) obj));
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

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSet", this.zzaxn).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public boolean zzuO() {
        return this.zzaAJ;
    }
}
