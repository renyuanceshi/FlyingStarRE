package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzd extends zzj<zzh> {
    private final GoogleSignInOptions zzXx;

    public zzd(Context context, Looper looper, zzf zzf, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzf, connectionCallbacks, onConnectionFailedListener);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.Builder().build() : googleSignInOptions;
        if (!zzf.zzqt().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
            for (Scope requestScopes : zzf.zzqt()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzXx = googleSignInOptions;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaB */
    public zzh zzW(IBinder iBinder) {
        return zzh.zza.zzaD(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public boolean zznb() {
        return true;
    }

    public Intent zznc() {
        SignInConfiguration zzmX = new zzg.zza(getContext().getPackageName()).zzi(this.zzXx).zzmY().zzmX();
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setClass(getContext(), SignInHubActivity.class);
        intent.putExtra("config", zzmX);
        return intent;
    }

    public GoogleSignInOptions zznd() {
        return this.zzXx;
    }
}
