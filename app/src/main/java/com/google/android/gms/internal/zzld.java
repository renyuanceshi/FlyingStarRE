package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzld implements ProxyApi {
    public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, final ProxyRequest proxyRequest) {
        zzx.zzz(googleApiClient);
        zzx.zzz(proxyRequest);
        return googleApiClient.zzb(new zzlc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzlb zzlb) throws RemoteException {
                zzlb.zza((zzla) new zzky() {
                    public void zza(ProxyResponse proxyResponse) {
                        AnonymousClass1.this.zza(new zzle(proxyResponse));
                    }
                }, proxyRequest);
            }
        });
    }
}
