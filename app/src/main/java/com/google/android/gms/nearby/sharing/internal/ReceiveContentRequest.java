package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza;
import com.google.android.gms.nearby.sharing.internal.zzc;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzbdk;
    public zzc zzbdo;
    public zza zzbdp;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int i, IBinder iBinder, IBinder iBinder2, String str, IBinder iBinder3) {
        this.versionCode = i;
        this.zzbdk = iBinder;
        this.zzbdp = zza.C0227zza.zzdF(iBinder2);
        this.packageName = str;
        this.zzbdo = zzc.zza.zzdH(iBinder3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzEQ() {
        if (this.zzbdp == null) {
            return null;
        }
        return this.zzbdp.asBinder();
    }
}
