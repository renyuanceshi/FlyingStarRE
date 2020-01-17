package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.sharing.internal.zzc;

public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzbdo;
    public String zzbdq;
    public byte[] zzbdr;

    TrustedDevicesRequest(int i, String str, byte[] bArr, IBinder iBinder) {
        this.versionCode = i;
        this.zzbdq = (String) zzx.zzz(str);
        this.zzbdr = (byte[]) zzx.zzz(bArr);
        this.zzbdo = zzc.zza.zzdH(iBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbdo.asBinder();
    }
}
