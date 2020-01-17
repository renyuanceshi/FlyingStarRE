package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzd extends zzg<zzt> {
    private static final zzd zztB = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzs zza(Context context, String str, zzew zzew) {
        zzs zzb;
        if (zzn.zzcS().zzU(context) && (zzb = zztB.zzb(context, str, zzew)) != null) {
            return zzb;
        }
        zzb.zzaI("Using AdLoader from the client jar.");
        return zzn.zzcU().createAdLoaderBuilder(context, str, zzew, new VersionInfoParcel(8487000, 8487000, true));
    }

    private zzs zzb(Context context, String str, zzew zzew) {
        try {
            return zzs.zza.zzi(((zzt) zzaB(context)).zza(zze.zzC(context), str, zzew, 8487000));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzc */
    public zzt zzd(IBinder iBinder) {
        return zzt.zza.zzj(iBinder);
    }
}
