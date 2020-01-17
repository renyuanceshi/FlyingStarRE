package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlq;
import com.google.android.gms.internal.zzlr;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API = new Api<>("CastRemoteDisplay.API", zzUJ, zzUI);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzlq(zzUI);
    private static final Api.zzc<zzlr> zzUI = new Api.zzc<>();
    private static final Api.zza<zzlr, CastRemoteDisplayOptions> zzUJ = new Api.zza<zzlr, CastRemoteDisplayOptions>() {
        public zzlr zza(Context context, Looper looper, zzf zzf, CastRemoteDisplayOptions castRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlr(context, looper, zzf, castRemoteDisplayOptions.zzZL, castRemoteDisplayOptions.zzaad, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public static final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzZL;
        final CastRemoteDisplaySessionCallbacks zzaad;

        public static final class Builder {
            CastDevice zzZO;
            CastRemoteDisplaySessionCallbacks zzaae;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks) {
                zzx.zzb(castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzZO = castDevice;
                this.zzaae = castRemoteDisplaySessionCallbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this);
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzaad = builder.zzaae;
        }
    }

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    private CastRemoteDisplay() {
    }
}
