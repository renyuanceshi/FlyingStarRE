package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private static boolean zznY = false;

    private MapsInitializer() {
    }

    public static int initialize(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            try {
                zzx.zzb(context, (Object) "Context is null");
                if (!zznY) {
                    zza(zzad.zzaO(context));
                    zznY = true;
                }
            } catch (GooglePlayServicesNotAvailableException e) {
                i = e.errorCode;
            } catch (Throwable th) {
                Class<MapsInitializer> cls = MapsInitializer.class;
                throw th;
            }
        }
        return i;
    }

    public static void zza(zzc zzc) {
        try {
            CameraUpdateFactory.zza(zzc.zzAe());
            BitmapDescriptorFactory.zza(zzc.zzAf());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
