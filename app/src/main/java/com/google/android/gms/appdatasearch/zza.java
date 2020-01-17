package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;

public final class zza {
    public static final Api<Api.ApiOptions.NoOptions> zzTA = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzTz, zzTy);
    public static final zzk zzTB = new zzkk();
    public static final Api.zzc<zzki> zzTy = new Api.zzc<>();
    private static final Api.zza<zzki, Api.ApiOptions.NoOptions> zzTz = new Api.zza<zzki, Api.ApiOptions.NoOptions>() {
        public zzki zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzki(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
}
