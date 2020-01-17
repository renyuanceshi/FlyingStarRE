package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceStatsResult> CREATOR = new zzd();
    final int mVersionCode;
    public final long zzUZ;
    public final boolean zzaBI;
    public final long zzaBJ;
    public final long zzaBK;
    public final DataSource zzavU;

    DataSourceStatsResult(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzUZ = j;
        this.zzaBI = z;
        this.zzaBJ = j2;
        this.zzaBK = j3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
