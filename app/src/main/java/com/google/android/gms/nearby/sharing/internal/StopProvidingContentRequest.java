package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;

public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzbdn;
    public zzc zzbdo;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int i, long j, IBinder iBinder) {
        this.versionCode = i;
        this.zzbdn = j;
        this.zzbdo = zzc.zza.zzdH(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbdo.asBinder();
    }
}
