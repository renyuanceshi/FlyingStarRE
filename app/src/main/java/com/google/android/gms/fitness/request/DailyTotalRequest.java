package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzog;

public class DailyTotalRequest implements SafeParcelable {
    public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int mVersionCode;
    private final zzog zzaAE;
    private DataType zzavT;

    DailyTotalRequest(int i, IBinder iBinder, DataType dataType) {
        this.mVersionCode = i;
        this.zzaAE = zzog.zza.zzbB(iBinder);
        this.zzavT = dataType;
    }

    public DailyTotalRequest(zzog zzog, DataType dataType) {
        this.mVersionCode = 2;
        this.zzaAE = zzog;
        this.zzavT = dataType;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaAE.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.zzavT.zzuo()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
