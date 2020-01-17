package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.nearby.messages.internal.zze;

final class zzp extends zze.zza {
    private final zza.zzb<Status> zzbcS;

    private zzp(zza.zzb<Status> zzb) {
        this.zzbcS = zzb;
    }

    static zzp zzn(zza.zzb<Status> zzb) {
        return new zzp(zzb);
    }

    public void zzbb(Status status) throws RemoteException {
        this.zzbcS.zzs(status);
    }
}
