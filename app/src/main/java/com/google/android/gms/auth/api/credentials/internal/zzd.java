package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;

public final class zzd implements CredentialsApi {

    private static class zza extends zza {
        private zza.zzb<Status> zzWz;

        zza(zza.zzb<Status> zzb) {
            this.zzWz = zzb;
        }

        public void zzg(Status status) {
            this.zzWz.zzs(status);
        }
    }

    private PasswordSpecification zza(GoogleApiClient googleApiClient) {
        Auth.AuthCredentialsOptions zzmD = ((zzf) googleApiClient.zza(Auth.zzVu)).zzmD();
        return (zzmD == null || zzmD.zzmr() == null) ? PasswordSpecification.zzWl : zzmD.zzmr();
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzj zzj) throws RemoteException {
                zzj.zza((zzi) new zza(this), new DeleteRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzj zzj) throws RemoteException {
                zzj.zza(new zza(this));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzx.zzb(googleApiClient, (Object) "client must not be null");
        zzx.zzb(hintRequest, (Object) "request must not be null");
        zzx.zzb(googleApiClient.zza((Api<?>) Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return PendingIntent.getActivity(googleApiClient.getContext(), 2000, zzb.zza(googleApiClient.getContext(), hintRequest, zza(googleApiClient)), DriveFile.MODE_READ_ONLY);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, final CredentialRequest credentialRequest) {
        return googleApiClient.zza(new zze<CredentialRequestResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzj zzj) throws RemoteException {
                zzj.zza((zzi) new zza() {
                    public void zza(Status status, Credential credential) {
                        AnonymousClass1.this.zza(new zzc(status, credential));
                    }

                    public void zzg(Status status) {
                        AnonymousClass1.this.zza(zzc.zzh(status));
                    }
                }, credentialRequest);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzi */
            public CredentialRequestResult zzc(Status status) {
                return zzc.zzh(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zze<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzj zzj) throws RemoteException {
                zzj.zza((zzi) new zza(this), new SaveRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
