package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.nearby.bootstrap.zza;

public class zzqd implements zza {
    public static final Api.zzc<zzqc> zzUI = new Api.zzc<>();
    public static final Api.zza<zzqc, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzqc, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzo */
        public zzqc zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqc(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };
}
