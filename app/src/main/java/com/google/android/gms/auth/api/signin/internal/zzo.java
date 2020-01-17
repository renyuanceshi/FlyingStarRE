package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzo extends zzj<zzh> {
    private final zzg zzXK;

    public zzo(Context context, Looper looper, zzf zzf, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzXK = (zzg) zzx.zzz(zzg);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaB */
    public zzh zzW(IBinder iBinder) {
        return zzh.zza.zzaD(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
