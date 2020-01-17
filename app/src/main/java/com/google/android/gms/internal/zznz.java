package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.zzok;

public class zznz extends zzny<zzok> {

    static abstract class zza<R extends Result> extends zza.C0030zza<R, zznz> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzavK, googleApiClient);
        }
    }

    public static class zzb extends Api.zza<zznz, Api.ApiOptions.NoOptions> {
        /* renamed from: zzg */
        public zznz zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zznz(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            zzx.zzac(!status.isSuccess());
            return status;
        }
    }

    public zznz(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 59, connectionCallbacks, onConnectionFailedListener, zzf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbu */
    public zzok zzW(IBinder iBinder) {
        return zzok.zza.zzbF(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.fitness.BleApi";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
