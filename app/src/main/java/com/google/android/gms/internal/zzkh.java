package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzkg;

public abstract class zzkh<T> extends zzkg.zza {
    protected zza.zzb<T> zzUz;

    public zzkh(zza.zzb<T> zzb) {
        this.zzUz = zzb;
    }

    public void zza(GetRecentContextCall.Response response) {
    }

    public void zza(Status status) {
    }

    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void zza(Status status, boolean z) {
    }
}
