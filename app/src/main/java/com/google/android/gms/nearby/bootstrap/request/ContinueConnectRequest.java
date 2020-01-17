package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzqg zzbaV;
    private final String zzbaW;

    ContinueConnectRequest(int i, String str, IBinder iBinder) {
        this.versionCode = i;
        this.zzbaW = (String) zzx.zzz(str);
        this.zzbaV = zzqg.zza.zzds(iBinder);
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public String getToken() {
        return this.zzbaW;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }
}
