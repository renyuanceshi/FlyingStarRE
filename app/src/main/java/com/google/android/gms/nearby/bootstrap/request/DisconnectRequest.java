package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzbaS;
    private final zzqg zzbaV;

    DisconnectRequest(int i, Device device, IBinder iBinder) {
        this.versionCode = i;
        this.zzbaS = (Device) zzx.zzz(device);
        zzx.zzz(iBinder);
        this.zzbaV = zzqg.zza.zzds(iBinder);
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzbaV.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd zzd = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public Device zzEd() {
        return this.zzbaS;
    }
}
