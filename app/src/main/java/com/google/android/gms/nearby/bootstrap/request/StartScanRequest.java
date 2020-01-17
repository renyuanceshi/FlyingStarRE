package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqi;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzqg zzbaV;
    private final zzqi zzbaY;

    StartScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.versionCode = i;
        zzx.zzz(iBinder);
        this.zzbaY = zzqi.zza.zzdu(iBinder);
        zzx.zzz(iBinder2);
        this.zzbaV = zzqg.zza.zzds(iBinder2);
    }

    public int describeContents() {
        zzg zzg = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg zzg = CREATOR;
        zzg.zza(this, parcel, i);
    }

    public IBinder zzEi() {
        if (this.zzbaY == null) {
            return null;
        }
        return this.zzbaY.asBinder();
    }
}
