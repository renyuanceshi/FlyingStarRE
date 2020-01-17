package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzoj;

public class zzpb implements ConfigApi {

    private static class zza extends zzoj.zza {
        private final zza.zzb<DataTypeResult> zzamC;

        private zza(zza.zzb<DataTypeResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzamC.zzs(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient googleApiClient, final DataTypeCreateRequest dataTypeCreateRequest) {
        return googleApiClient.zzb(new zzoa.zza<DataTypeResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzJ */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzoa zzoa) throws RemoteException {
                ((zzol) zzoa.zzqJ()).zza(new DataTypeCreateRequest(dataTypeCreateRequest, (zzoj) new zza(this)));
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzoa.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzoa zzoa) throws RemoteException {
                ((zzol) zzoa.zzqJ()).zza(new DisableFitRequest(new zzph(this)));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzoa.zza<DataTypeResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzJ */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzoa zzoa) throws RemoteException {
                ((zzol) zzoa.zzqJ()).zza(new DataTypeReadRequest(str, new zza(this)));
            }
        });
    }
}
