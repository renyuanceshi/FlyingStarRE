package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.List;

public class zzre implements SafetyNetApi {

    static class zza implements SafetyNetApi.AttestationResult {
        private final Status zzUX;
        private final AttestationData zzbgB;

        public zza(Status status, AttestationData attestationData) {
            this.zzUX = status;
            this.zzbgB = attestationData;
        }

        public String getJwsResult() {
            if (this.zzbgB == null) {
                return null;
            }
            return this.zzbgB.getJwsResult();
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzb extends zzrb<SafetyNetApi.AttestationResult> {
        protected zzrc zzbgC = new zzra() {
            public void zza(Status status, AttestationData attestationData) {
                zzb.this.zza(new zza(status, attestationData));
            }
        };

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbh */
        public SafetyNetApi.AttestationResult zzc(Status status) {
            return new zza(status, (AttestationData) null);
        }
    }

    static abstract class zzc extends zzrb<SafetyNetApi.SafeBrowsingResult> {
        protected zzrc zzbgC = new zzra() {
            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                zzc.this.zza(new zzd(status, safeBrowsingData));
            }
        };

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbi */
        public SafetyNetApi.SafeBrowsingResult zzc(Status status) {
            return new zzd(status, (SafeBrowsingData) null);
        }
    }

    static class zzd implements SafetyNetApi.SafeBrowsingResult {
        private Status zzUX;
        private final SafeBrowsingData zzbgF;
        private String zzbgv = null;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzUX = status;
            this.zzbgF = safeBrowsingData;
            if (this.zzbgF != null) {
                this.zzbgv = this.zzbgF.getMetadata();
            } else if (this.zzUX.isSuccess()) {
                this.zzUX = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzbgv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] bArr) {
        return googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrf zzrf) throws RemoteException {
                zzrf.zza(this.zzbgC, bArr);
            }
        });
    }

    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, final List<Integer> list, final String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(str)) {
            return googleApiClient.zza(new zzc(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzrf zzrf) throws RemoteException {
                    zzrf.zza(this.zzbgC, list, 1, str);
                }
            });
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
