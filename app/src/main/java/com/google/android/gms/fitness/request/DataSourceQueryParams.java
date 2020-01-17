package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceQueryParams> CREATOR = new zzg();
    final int mVersionCode;
    public final long zzUZ;
    public final int zzaAO;
    public final long zzaAT;
    public final int zzaAU;
    public final DataSource zzavU;
    public final long zzawk;

    DataSourceQueryParams(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzUZ = j;
        this.zzawk = j2;
        this.zzaAT = j3;
        this.zzaAO = i2;
        this.zzaAU = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
