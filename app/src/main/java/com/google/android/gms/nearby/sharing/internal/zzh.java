package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.sharing.zzd;

public final class zzh implements zzd {
    public static final Api.zzc<zze> zzUI = new Api.zzc<>();
    public static final Api.zza<zze, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zze, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzq */
        public zze zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };
}
