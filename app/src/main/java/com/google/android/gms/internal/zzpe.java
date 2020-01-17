package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzor;

public class zzpe implements RecordingApi {

    private static class zza extends zzor.zza {
        private final zza.zzb<ListSubscriptionsResult> zzamC;

        private zza(zza.zzb<ListSubscriptionsResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzamC.zzs(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzod.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzod zzod) throws RemoteException {
                ((zzoo) zzod.zzqJ()).zza(new SubscribeRequest(subscription, false, new zzph(this)));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzod.zza<ListSubscriptionsResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzM */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzod zzod) throws RemoteException {
                ((zzoo) zzod.zzqJ()).zza(new ListSubscriptionsRequest((DataType) null, new zza(this)));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza(new zzod.zza<ListSubscriptionsResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzM */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzod zzod) throws RemoteException {
                ((zzoo) zzod.zzqJ()).zza(new ListSubscriptionsRequest(dataType, new zza(this)));
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataSource).zzuz());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataType).zzuz());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataSource dataSource) {
        return googleApiClient.zzb(new zzod.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzod zzod) throws RemoteException {
                ((zzoo) zzod.zzqJ()).zza(new UnsubscribeRequest((DataType) null, dataSource, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zzb(new zzod.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzod zzod) throws RemoteException {
                ((zzoo) zzod.zzqJ()).zza(new UnsubscribeRequest(dataType, (DataSource) null, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}
