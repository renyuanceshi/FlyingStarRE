package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzow;

public class zzph extends zzow.zza {
    private final zza.zzb<Status> zzamC;

    public zzph(zza.zzb<Status> zzb) {
        this.zzamC = zzb;
    }

    public void zzp(Status status) {
        this.zzamC.zzs(status);
    }
}
