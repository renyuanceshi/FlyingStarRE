package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzl;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;

public class zzpf implements SensorsApi {

    private interface zza {
        void zzuI();
    }

    private static class zzb extends zzoi.zza {
        private final zza.zzb<DataSourcesResult> zzamC;

        private zzb(zza.zzb<DataSourcesResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzamC.zzs(dataSourcesResult);
        }
    }

    private static class zzc extends zzow.zza {
        private final zza zzaAq;
        private final zza.zzb<Status> zzamC;

        private zzc(zza.zzb<Status> zzb, zza zza) {
            this.zzamC = zzb;
            this.zzaAq = zza;
        }

        public void zzp(Status status) {
            if (this.zzaAq != null && status.isSuccess()) {
                this.zzaAq.zzuI();
            }
            this.zzamC.zzs(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzk zzk, PendingIntent pendingIntent, zza zza2) {
        final zza zza3 = zza2;
        final zzk zzk2 = zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzoe.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzoe zzoe) throws RemoteException {
                ((zzop) zzoe.zzqJ()).zza(new SensorUnregistrationRequest(zzk2, pendingIntent2, new zzc(this, zza3)));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzk zzk, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzk zzk2 = zzk;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzoe.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzoe zzoe) throws RemoteException {
                ((zzop) zzoe.zzqJ()).zza(new SensorRegistrationRequest(sensorRequest2, zzk2, pendingIntent2, new zzph(this)));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, (zzk) null, pendingIntent);
    }

    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, (zzk) zzl.zza.zzuu().zza(onDataPointListener), (PendingIntent) null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, final DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza(new zzoe.zza<DataSourcesResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzN */
            public DataSourcesResult zzc(Status status) {
                return DataSourcesResult.zzR(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzoe zzoe) throws RemoteException {
                ((zzop) zzoe.zzqJ()).zza(new DataSourcesRequest(dataSourcesRequest, (zzoi) new zzb(this)));
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, (zzk) null, pendingIntent, (zza) null);
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final OnDataPointListener onDataPointListener) {
        zzl zzb2 = zzl.zza.zzuu().zzb(onDataPointListener);
        return zzb2 == null ? PendingResults.zza(Status.zzagC, googleApiClient) : zza(googleApiClient, (zzk) zzb2, (PendingIntent) null, (zza) new zza() {
            public void zzuI() {
                zzl.zza.zzuu().zzc(onDataPointListener);
            }
        });
    }
}
