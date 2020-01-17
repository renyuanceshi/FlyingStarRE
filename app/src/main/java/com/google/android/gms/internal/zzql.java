package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

public final class zzql implements Connections {
    public static final Api.zzc<zzqk> zzUI = new Api.zzc<>();
    public static final Api.zza<zzqk, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzqk, Api.ApiOptions.NoOptions>() {
        /* renamed from: zzp */
        public zzqk zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqk(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private static abstract class zza<R extends Result> extends zza.C0030zza<R, zzqk> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzql.zzUI, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<Connections.StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzbc */
        public Connections.StartAdvertisingResult zzc(final Status status) {
            return new Connections.StartAdvertisingResult() {
                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public static zzqk zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzqk zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza((Api<?>) Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        } else if (hasConnectedApi) {
            return (zzqk) googleApiClient.zza(zzUI);
        } else {
            return null;
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, Connections.MessageListener messageListener) {
        final zzq zzr = googleApiClient.zzr(messageListener);
        final String str2 = str;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzqk zzqk) throws RemoteException {
                zzqk.zza((zza.zzb<Status>) this, str2, bArr2, (zzq<Connections.MessageListener>) zzr);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzfA(str);
    }

    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzEk();
    }

    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzEj();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzqk zzqk) throws RemoteException {
                zzqk.zzp(this, str);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        final zzq zzr = googleApiClient.zzr(connectionResponseCallback);
        final zzq zzr2 = googleApiClient.zzr(messageListener);
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzqk zzqk) throws RemoteException {
                zzqk.zza(this, str3, str4, bArr2, zzr, zzr2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zza(new String[]{str}, bArr);
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zza((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zzb(new String[]{str}, bArr);
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zzb((String[]) list.toArray(new String[list.size()]), bArr);
    }

    public PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, Connections.ConnectionRequestListener connectionRequestListener) {
        final zzq zzr = googleApiClient.zzr(connectionRequestListener);
        final String str2 = str;
        final AppMetadata appMetadata2 = appMetadata;
        final long j2 = j;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzqk zzqk) throws RemoteException {
                zzqk.zza(this, str2, appMetadata2, j2, zzr);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        final zzq zzr = googleApiClient.zzr(endpointDiscoveryListener);
        final String str2 = str;
        final long j2 = j;
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzqk zzqk) throws RemoteException {
                zzqk.zza((zza.zzb<Status>) this, str2, j2, (zzq<Connections.EndpointDiscoveryListener>) zzr);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzEl();
    }

    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzEm();
    }

    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzfz(str);
    }
}
