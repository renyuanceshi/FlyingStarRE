package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkp;

public class zzkm extends zzj<zzkp> {
    private final String zzUW;

    public zzkm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 77, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzUW = zzf.zzqv();
    }

    private Bundle zzmm() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzUW);
        return bundle;
    }

    public void zza(zzko zzko) {
        try {
            ((zzkp) zzqJ()).zza(zzko);
        } catch (RemoteException e) {
        }
    }

    public void zza(zzko zzko, String str) {
        try {
            ((zzkp) zzqJ()).zza(zzko, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaj */
    public zzkp zzW(IBinder iBinder) {
        return zzkp.zza.zzal(iBinder);
    }

    public void zzb(zzko zzko, String str) {
        try {
            ((zzkp) zzqJ()).zzb(zzko, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.appinvite.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        return zzmm();
    }
}
