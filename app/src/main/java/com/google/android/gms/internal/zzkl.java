package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzko;

public class zzkl implements AppInviteApi {

    static class zza extends zzko.zza {
        zza() {
        }

        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        public void zzd(Status status) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends zza.C0030zza<R, zzkm> {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.zzUI, googleApiClient);
        }
    }

    final class zzc extends zzb<Status> {
        private final String zzUO;

        public zzc(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzkm zzkm) throws RemoteException {
            zzkm.zzb(new zza() {
                public void zzd(Status status) throws RemoteException {
                    zzc.this.zza(status);
                }
            }, this.zzUO);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    final class zzd extends zzb<Status> {
        private final String zzUO;

        public zzd(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzkm zzkm) throws RemoteException {
            zzkm.zza(new zza() {
                public void zzd(Status status) throws RemoteException {
                    zzd.this.zza(status);
                }
            }, this.zzUO);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    final class zze extends zzb<AppInviteInvitationResult> {
        /* access modifiers changed from: private */
        public final Activity zzUS;
        /* access modifiers changed from: private */
        public final boolean zzUT;
        private final Intent zzUU;

        public zze(GoogleApiClient googleApiClient, Activity activity, boolean z) {
            super(googleApiClient);
            this.zzUS = activity;
            this.zzUT = z;
            this.zzUU = this.zzUS != null ? this.zzUS.getIntent() : null;
        }

        /* access modifiers changed from: protected */
        public void zza(zzkm zzkm) throws RemoteException {
            if (AppInviteReferral.hasReferral(this.zzUU)) {
                zza(new zzkn(Status.zzagC, this.zzUU));
            } else {
                zzkm.zza(new zza() {
                    public void zza(Status status, Intent intent) {
                        zze.this.zza(new zzkn(status, intent));
                        if (AppInviteReferral.hasReferral(intent) && zze.this.zzUT && zze.this.zzUS != null) {
                            zze.this.zzUS.startActivity(intent);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zze */
        public AppInviteInvitationResult zzc(Status status) {
            return new zzkn(status, new Intent());
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzd(googleApiClient, str));
    }

    public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient googleApiClient, Activity activity, boolean z) {
        return googleApiClient.zza(new zze(googleApiClient, activity, z));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzc(googleApiClient, str));
    }
}
