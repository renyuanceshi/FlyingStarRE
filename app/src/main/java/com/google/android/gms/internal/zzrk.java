package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;

public class zzrk implements SearchAuthApi {

    static abstract class zza extends zzrh.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbj(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends zza.C0030zza<Status, zzrj> {
        private final String zzXI;
        private final String zzbgJ;
        /* access modifiers changed from: private */
        public final boolean zzbgK = Log.isLoggable("SearchAuth", 3);

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzXI = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        /* access modifiers changed from: protected */
        public void zza(zzrj zzrj) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            ((zzri) zzrj.zzqJ()).zzb(new zza() {
                public void zzbj(Status status) {
                    if (zzb.this.zzbgK) {
                        Log.d("SearchAuth", "ClearTokenImpl success");
                    }
                    zzb.this.zza(status);
                }
            }, this.zzbgJ, this.zzXI);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status zzc(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }
    }

    static class zzc extends zza.C0030zza<SearchAuthApi.GoogleNowAuthResult, zzrj> {
        private final String zzbgJ;
        /* access modifiers changed from: private */
        public final boolean zzbgK = Log.isLoggable("SearchAuth", 3);
        private final String zzbgM;

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzbgM = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        /* access modifiers changed from: protected */
        public void zza(zzrj zzrj) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            ((zzri) zzrj.zzqJ()).zza(new zza() {
                public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                    if (zzc.this.zzbgK) {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    zzc.this.zza(new zzd(status, googleNowAuthState));
                }
            }, this.zzbgJ, this.zzbgM);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbk */
        public SearchAuthApi.GoogleNowAuthResult zzc(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, (GoogleNowAuthState) null);
        }
    }

    static class zzd implements SearchAuthApi.GoogleNowAuthResult {
        private final Status zzUX;
        private final GoogleNowAuthState zzbgO;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzUX = status;
            this.zzbgO = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzbgO;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzb(googleApiClient, str));
    }

    public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new zzc(googleApiClient, str));
    }
}
