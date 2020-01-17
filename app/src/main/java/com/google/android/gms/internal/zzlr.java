package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;

public class zzlr extends zzj<zzlt> implements IBinder.DeathRecipient {
    /* access modifiers changed from: private */
    public static final zzl zzaaf = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzZO;
    /* access modifiers changed from: private */
    public CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzaeL;

    public zzlr(Context context, Looper looper, zzf zzf, CastDevice castDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, zzf, connectionCallbacks, onConnectionFailedListener);
        zzaaf.zzb("instance created", new Object[0]);
        this.zzaeL = castRemoteDisplaySessionCallbacks;
        this.zzZO = castDevice;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzaaf.zzb("disconnect", new Object[0]);
        this.zzaeL = null;
        this.zzZO = null;
        try {
            ((zzlt) zzqJ()).disconnect();
        } catch (RemoteException | IllegalStateException e) {
        } finally {
            super.disconnect();
        }
    }

    public void zza(zzls zzls) throws RemoteException {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        ((zzlt) zzqJ()).zza(zzls);
    }

    public void zza(zzls zzls, int i) throws RemoteException {
        ((zzlt) zzqJ()).zza(zzls, i);
    }

    public void zza(zzls zzls, final zzlu zzlu, String str) throws RemoteException {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        ((zzlt) zzqJ()).zza(zzls, new zzlu.zza() {
            public void zzbp(int i) throws RemoteException {
                zzlr.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzlu != null) {
                    zzlu.zzbp(i);
                }
                if (zzlr.this.zzaeL != null) {
                    zzlr.this.zzaeL.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzZO.getDeviceId(), str);
    }

    /* renamed from: zzaG */
    public zzlt zzW(IBinder iBinder) {
        return zzlt.zza.zzaI(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
