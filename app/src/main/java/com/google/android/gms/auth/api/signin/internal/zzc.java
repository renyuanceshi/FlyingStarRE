package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends zza.C0030zza<R, zzd> {
        public zza(GoogleApiClient googleApiClient) {
            super(Auth.zzVx, googleApiClient);
        }
    }

    private OptionalPendingResult<GoogleSignInResult> zza(GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzr(googleApiClient.zza(new zza<GoogleSignInResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                final zzq zzaf = zzq.zzaf(zzd.getContext());
                ((zzh) zzd.zzqJ()).zza((zzg) new zza() {
                    public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                        if (googleSignInAccount != null) {
                            zzaf.zzb(googleSignInAccount, googleSignInOptions);
                        }
                        AnonymousClass1.this.zza(new GoogleSignInResult(googleSignInAccount, status));
                    }
                }, googleSignInOptions);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzn */
            public GoogleSignInResult zzc(Status status) {
                return new GoogleSignInResult((GoogleSignInAccount) null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    private GoogleSignInOptions zzb(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznd();
    }

    public Intent getSignInIntent(GoogleApiClient googleApiClient) {
        zzx.zzz(googleApiClient);
        return ((zzd) googleApiClient.zza(Auth.zzVx)).zznc();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent == null || (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzagC;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        zzq.zzaf(googleApiClient.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return googleApiClient.zzb(new zza<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                ((zzh) zzd.zzqJ()).zzc(new zza() {
                    public void zzm(Status status) throws RemoteException {
                        AnonymousClass3.this.zza(status);
                    }
                }, zzd.zznd());
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        zzq.zzaf(googleApiClient.getContext()).zznr();
        for (GoogleApiClient zzoW : GoogleApiClient.zzoV()) {
            zzoW.zzoW();
        }
        return googleApiClient.zzb(new zza<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                ((zzh) zzd.zzqJ()).zzb((zzg) new zza() {
                    public void zzl(Status status) throws RemoteException {
                        AnonymousClass2.this.zza(status);
                    }
                }, zzd.zznd());
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        GoogleSignInOptions zzb = zzb(googleApiClient);
        GoogleSignInResult zza2 = zza(googleApiClient.getContext(), zzb);
        return zza2 != null ? PendingResults.zzb(zza2, googleApiClient) : zza(googleApiClient, zzb);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        GoogleSignInAccount zzno;
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzz(googleSignInOptions);
        zzq zzaf = zzq.zzaf(context);
        GoogleSignInOptions zznp = zzaf.zznp();
        if (zznp == null || !zza(zznp.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmP()) {
            return null;
        }
        if ((!googleSignInOptions.zzmO() || (zznp.zzmO() && googleSignInOptions.zzmR().equals(zznp.zzmR()))) && new HashSet(zznp.zzmN()).containsAll(new HashSet(googleSignInOptions.zzmN())) && (zzno = zzaf.zzno()) != null && !zzno.zzb()) {
            return new GoogleSignInResult(zzno, Status.zzagC);
        }
        return null;
    }
}
