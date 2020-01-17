package com.google.android.gms.cast.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;

public abstract class zzb<R extends Result> extends zza.C0030zza<R, zze> {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.zzUI, googleApiClient);
    }

    public void zzbj(int i) {
        zza(zzc(new Status(i)));
    }

    public void zze(int i, String str) {
        zza(zzc(new Status(i, str, (PendingIntent) null)));
    }
}
