package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

abstract class zzlc extends zza.C0030zza<ProxyApi.ProxyResult, zzkz> {
    public zzlc(GoogleApiClient googleApiClient) {
        super(Auth.zzVt, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzlb zzlb) throws RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(zzkz zzkz) throws RemoteException {
        zza(zzkz.getContext(), (zzlb) zzkz.zzqJ());
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzj */
    public ProxyApi.ProxyResult zzc(Status status) {
        return new zzle(status);
    }
}
