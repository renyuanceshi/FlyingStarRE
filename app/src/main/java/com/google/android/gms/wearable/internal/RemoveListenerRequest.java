package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbg();
    final int mVersionCode;
    public final zzaw zzbrB;

    RemoveListenerRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.zzbrB = zzaw.zza.zzet(iBinder);
        } else {
            this.zzbrB = null;
        }
    }

    public RemoveListenerRequest(zzaw zzaw) {
        this.mVersionCode = 1;
        this.zzbrB = zzaw;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbg.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzIy() {
        if (this.zzbrB == null) {
            return null;
        }
        return this.zzbrB.asBinder();
    }
}
