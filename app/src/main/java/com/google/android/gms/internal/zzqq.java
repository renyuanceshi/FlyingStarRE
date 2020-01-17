package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

public class zzqq implements PanoramaApi {

    private static abstract class zza extends zzc<PanoramaApi.PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbd */
        public PanoramaApi.PanoramaResult zzc(Status status) {
            return new zzqs(status, (Intent) null);
        }
    }

    private static final class zzb extends zzqo.zza {
        private final zza.zzb<PanoramaApi.PanoramaResult> zzamC;

        public zzb(zza.zzb<PanoramaApi.PanoramaResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzamC.zzs(new zzqs(new Status(i, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends zza.C0030zza<R, zzqr> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzUI, googleApiClient);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(Context context, zzqp zzqp) throws RemoteException;

        /* access modifiers changed from: protected */
        public final void zza(zzqr zzqr) throws RemoteException {
            zza(zzqr.getContext(), (zzqp) zzqr.zzqJ());
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* access modifiers changed from: private */
    public static void zza(final Context context, zzqp zzqp, final zzqo zzqo, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzqp.zza(new zzqo.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzqq.zza(context, uri);
                    zzqo.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzqp zzqp) throws RemoteException {
                zzqp.zza(new zzb(this), uri, (Bundle) null, false);
            }
        });
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzqp zzqp) throws RemoteException {
                zzqq.zza(context, zzqp, new zzb(this), uri, (Bundle) null);
            }
        });
    }
}
