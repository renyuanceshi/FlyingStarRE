package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.internal.zzj;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzj;

public final class zzf extends zzj<zzj> {
    @Nullable
    private final Auth.AuthCredentialsOptions zzWA;

    public zzf(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzWA = authCredentialsOptions;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzav */
    public zzj zzW(IBinder iBinder) {
        return zzj.zza.zzax(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: package-private */
    public Auth.AuthCredentialsOptions zzmD() {
        return this.zzWA;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        return this.zzWA == null ? new Bundle() : this.zzWA.zzml();
    }
}
