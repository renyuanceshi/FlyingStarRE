package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzoh;

public class zzpc implements HistoryApi {

    private static class zza extends zzoh.zza {
        private int zzaAc;
        private DataReadResult zzaAd;
        private final zza.zzb<DataReadResult> zzamC;

        private zza(zza.zzb<DataReadResult> zzb) {
            this.zzaAc = 0;
            this.zzaAd = null;
            this.zzamC = zzb;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaAc);
                }
                if (this.zzaAd == null) {
                    this.zzaAd = dataReadResult;
                } else {
                    this.zzaAd.zzb(dataReadResult);
                }
                this.zzaAc++;
                if (this.zzaAc == this.zzaAd.zzvj()) {
                    this.zzamC.zzs(this.zzaAd);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb(dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzum(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzob.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzob zzob) throws RemoteException {
                ((zzom) zzob.zzqJ()).zza(new DataInsertRequest(dataSet, new zzph(this), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient googleApiClient, final DataDeleteRequest dataDeleteRequest) {
        return googleApiClient.zza(new zzob.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzob zzob) throws RemoteException {
                ((zzom) zzob.zzqJ()).zza(new DataDeleteRequest(dataDeleteRequest, (zzow) new zzph(this)));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet) {
        return zza(googleApiClient, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza(new zzob.zza<DailyTotalResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzL */
            public DailyTotalResult zzc(Status status) {
                return DailyTotalResult.zza(status, dataType);
            }

            /* access modifiers changed from: protected */
            public void zza(zzob zzob) throws RemoteException {
                ((zzom) zzob.zzqJ()).zza(new DailyTotalRequest(new zzog.zza() {
                    public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                        AnonymousClass5.this.zza(dailyTotalResult);
                    }
                }, dataType));
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, final DataReadRequest dataReadRequest) {
        return googleApiClient.zza(new zzob.zza<DataReadResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzK */
            public DataReadResult zzc(Status status) {
                return DataReadResult.zza(status, dataReadRequest);
            }

            /* access modifiers changed from: protected */
            public void zza(zzob zzob) throws RemoteException {
                ((zzom) zzob.zzqJ()).zza(new DataReadRequest(dataReadRequest, (zzoh) new zza(this)));
            }
        });
    }

    public PendingResult<Status> updateData(GoogleApiClient googleApiClient, final DataUpdateRequest dataUpdateRequest) {
        zzx.zzb(dataUpdateRequest.getDataSet(), (Object) "Must set the data set");
        zzx.zza(dataUpdateRequest.zzlO(), (Object) "Must set a non-zero value for startTimeMillis/startTime");
        zzx.zza(dataUpdateRequest.zzud(), (Object) "Must set a non-zero value for endTimeMillis/endTime");
        return googleApiClient.zza(new zzob.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzob zzob) throws RemoteException {
                ((zzom) zzob.zzqJ()).zza(new DataUpdateRequest(dataUpdateRequest, (IBinder) new zzph(this)));
            }
        });
    }
}
