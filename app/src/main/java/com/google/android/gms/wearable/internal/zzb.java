package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;

final class zzb<T> extends zzi<Status> {
    private T mListener;
    private zzq<T> zzbbi;
    private zza<T> zzbrA;

    interface zza<T> {
        void zza(zzbp zzbp, zza.zzb<Status> zzb, T t, zzq<T> zzq) throws RemoteException;
    }

    private zzb(GoogleApiClient googleApiClient, T t, zzq<T> zzq, zza<T> zza2) {
        super(googleApiClient);
        this.mListener = zzx.zzz(t);
        this.zzbbi = (zzq) zzx.zzz(zzq);
        this.zzbrA = (zza) zzx.zzz(zza2);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zza<T> zza2, T t) {
        return googleApiClient.zza(new zzb(googleApiClient, t, googleApiClient.zzr(t), zza2));
    }

    /* access modifiers changed from: protected */
    public void zza(zzbp zzbp) throws RemoteException {
        this.zzbrA.zza(zzbp, this, this.mListener, this.zzbbi);
        this.mListener = null;
        this.zzbbi = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzb */
    public Status zzc(Status status) {
        this.mListener = null;
        this.zzbbi = null;
        return status;
    }
}
