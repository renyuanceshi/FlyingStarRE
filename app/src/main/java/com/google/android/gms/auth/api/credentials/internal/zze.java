package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;

abstract class zze<R extends Result> extends zza.C0030zza<R, zzf> {
    zze(GoogleApiClient googleApiClient) {
        super(Auth.zzVu, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzj zzj) throws DeadObjectException, RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(zzf zzf) throws DeadObjectException, RemoteException {
        zza(zzf.getContext(), (zzj) zzf.zzqJ());
    }
}
