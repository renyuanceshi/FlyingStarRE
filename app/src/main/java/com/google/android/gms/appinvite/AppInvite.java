package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

public final class AppInvite {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("AppInvite.API", zzUJ, zzUI);
    public static final AppInviteApi AppInviteApi = new zzkl();
    public static final Api.zzc<zzkm> zzUI = new Api.zzc<>();
    private static final Api.zza<zzkm, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzkm, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzb */
        public zzkm zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkm(context, looper, connectionCallbacks, onConnectionFailedListener, zzf);
        }
    };

    private AppInvite() {
    }
}
