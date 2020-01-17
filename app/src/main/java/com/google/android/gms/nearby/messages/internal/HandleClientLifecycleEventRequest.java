package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class HandleClientLifecycleEventRequest implements SafeParcelable {
    public static final Parcelable.Creator<HandleClientLifecycleEventRequest> CREATOR = new zzc();
    public final int versionCode;
    public final ClientAppContext zzbcs;
    public final int zzbct;

    HandleClientLifecycleEventRequest(int i, ClientAppContext clientAppContext, int i2) {
        this.versionCode = i;
        this.zzbcs = clientAppContext;
        this.zzbct = i2;
    }

    public HandleClientLifecycleEventRequest(ClientAppContext clientAppContext, int i) {
        this(1, clientAppContext, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
