package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;

@zzhb
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza  reason: collision with other inner class name */
    public interface C0012zza {
        void zza(zzif.zza zza);
    }

    public zzim zza(Context context, AdRequestInfoParcel.zza zza, zzan zzan, C0012zza zza2) {
        zzim zzm = zza.zzHt.extras.getBundle("sdk_less_server_data") != null ? new zzm(context, zza, zza2) : new zzb(context, zza, zzan, zza2);
        zzm.zzgd();
        return zzm;
    }
}
