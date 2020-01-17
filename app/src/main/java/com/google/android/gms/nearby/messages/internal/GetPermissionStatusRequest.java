package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zze;

public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionStatusRequest> CREATOR = new zzb();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    GetPermissionStatusRequest(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcr = zze.zza.zzdz(iBinder);
        this.zzbbF = str;
        this.zzbcs = clientAppContext == null ? new ClientAppContext((String) null, this.zzbbF) : clientAppContext;
    }

    GetPermissionStatusRequest(IBinder iBinder, ClientAppContext clientAppContext) {
        this(1, iBinder, (String) null, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
