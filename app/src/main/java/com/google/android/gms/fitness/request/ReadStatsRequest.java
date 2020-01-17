package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.zzot;
import java.util.List;

public class ReadStatsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadStatsRequest> CREATOR = new zzu();
    private final int mVersionCode;
    private final List<DataSource> zzaAF;
    private final zzot zzaBg;

    ReadStatsRequest(int i, IBinder iBinder, List<DataSource> list) {
        this.mVersionCode = i;
        this.zzaBg = zzot.zza.zzbO(iBinder);
        this.zzaAF = list;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBg.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }
}
