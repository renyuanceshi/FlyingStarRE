package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlb;

public final class zzkz extends zzj<zzlb> {
    private final Bundle zzVN;

    public zzkz(Context context, Looper looper, zzf zzf, Auth.zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzVN = zza == null ? new Bundle() : zza.zzms();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzay */
    public zzlb zzW(IBinder iBinder) {
        return zzlb.zza.zzaA(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.auth.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public boolean zzmE() {
        zzf zzqH = zzqH();
        return !TextUtils.isEmpty(zzqH.getAccountName()) && !zzqH.zzb(Auth.PROXY_API).isEmpty();
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        return this.zzVN;
    }
}
