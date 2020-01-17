package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzre;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;

public final class SafetyNet {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("SafetyNet.API", zzUJ, zzUI);
    public static final SafetyNetApi SafetyNetApi = new zzre();
    public static final Api.zzc<zzrf> zzUI = new Api.zzc<>();
    public static final Api.zza<zzrf, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzrf, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzs */
        public zzrf zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrf(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzc zzbgw = new zzrg();

    private SafetyNet() {
    }
}
