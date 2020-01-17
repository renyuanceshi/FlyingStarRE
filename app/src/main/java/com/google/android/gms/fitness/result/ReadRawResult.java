package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ReadRawResult> CREATOR = new zzi();
    private final int mVersionCode;
    private final List<DataHolder> zzaBN;
    private final DataHolder zzahi;

    ReadRawResult(int i, DataHolder dataHolder, List<DataHolder> list) {
        this.mVersionCode = i;
        this.zzahi = dataHolder;
        this.zzaBN = list == null ? Collections.singletonList(dataHolder) : list;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzahi.getStatusCode());
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public DataHolder zzsX() {
        return this.zzahi;
    }

    public List<DataHolder> zzvo() {
        return this.zzaBN;
    }
}
