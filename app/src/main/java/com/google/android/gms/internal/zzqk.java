package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;

public final class zzqk extends zzj<zzqn> {
    private final long zzaEg = ((long) hashCode());

    private static final class zza extends zzb {
        private final zza.zzb<Status> zzamC;

        public zza(zza.zzb<Status> zzb, zzq<Connections.MessageListener> zzq) {
            super(zzq);
            this.zzamC = (zza.zzb) zzx.zzz(zzb);
        }

        public void zziZ(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static class zzb extends zzqj {
        private final zzq<Connections.MessageListener> zzbbb;

        zzb(zzq<Connections.MessageListener> zzq) {
            this.zzbbb = zzq;
        }

        public void onDisconnected(final String str) throws RemoteException {
            this.zzbbb.zza(new zzq.zzb<Connections.MessageListener>() {
                /* renamed from: zza */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onDisconnected(str);
                }

                public void zzpr() {
                }
            });
        }

        public void onMessageReceived(final String str, final byte[] bArr, final boolean z) throws RemoteException {
            this.zzbbb.zza(new zzq.zzb<Connections.MessageListener>() {
                /* renamed from: zza */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onMessageReceived(str, bArr, z);
                }

                public void zzpr() {
                }
            });
        }
    }

    private static class zzc extends zzqj {
        private final zza.zzb<Status> zzbbf;

        zzc(zza.zzb<Status> zzb) {
            this.zzbbf = zzb;
        }

        public void zzja(int i) throws RemoteException {
            this.zzbbf.zzs(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final zza.zzb<Status> zzamC;
        private final zzq<Connections.ConnectionResponseCallback> zzbbg;

        public zzd(zza.zzb<Status> zzb, zzq<Connections.ConnectionResponseCallback> zzq, zzq<Connections.MessageListener> zzq2) {
            super(zzq2);
            this.zzamC = (zza.zzb) zzx.zzz(zzb);
            this.zzbbg = (zzq) zzx.zzz(zzq);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzbbg.zza(new zzq.zzb<Connections.ConnectionResponseCallback>() {
                /* renamed from: zza */
                public void zzt(Connections.ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public void zzpr() {
                }
            });
        }

        public void zziY(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static final class zze extends zzqj {
        private final zza.zzb<Connections.StartAdvertisingResult> zzamC;
        private final zzq<Connections.ConnectionRequestListener> zzbbi;

        zze(zza.zzb<Connections.StartAdvertisingResult> zzb, zzq<Connections.ConnectionRequestListener> zzq) {
            this.zzamC = (zza.zzb) zzx.zzz(zzb);
            this.zzbbi = (zzq) zzx.zzz(zzq);
        }

        public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final byte[] bArr2 = bArr;
            this.zzbbi.zza(new zzq.zzb<Connections.ConnectionRequestListener>() {
                /* renamed from: zza */
                public void zzt(Connections.ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str4, str5, str6, bArr2);
                }

                public void zzpr() {
                }
            });
        }

        public void zzm(int i, String str) throws RemoteException {
            this.zzamC.zzs(new zzf(new Status(i), str));
        }
    }

    private static final class zzf implements Connections.StartAdvertisingResult {
        private final Status zzUX;
        private final String zzbbm;

        zzf(Status status, String str) {
            this.zzUX = status;
            this.zzbbm = str;
        }

        public String getLocalEndpointName() {
            return this.zzbbm;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zzg extends zzqj {
        private final zza.zzb<Status> zzamC;
        private final zzq<Connections.EndpointDiscoveryListener> zzbbi;

        zzg(zza.zzb<Status> zzb, zzq<Connections.EndpointDiscoveryListener> zzq) {
            this.zzamC = (zza.zzb) zzx.zzz(zzb);
            this.zzbbi = (zzq) zzx.zzz(zzq);
        }

        public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            this.zzbbi.zza(new zzq.zzb<Connections.EndpointDiscoveryListener>() {
                /* renamed from: zza */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str5, str6, str7, str8);
                }

                public void zzpr() {
                }
            });
        }

        public void onEndpointLost(final String str) throws RemoteException {
            this.zzbbi.zza(new zzq.zzb<Connections.EndpointDiscoveryListener>() {
                /* renamed from: zza */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(str);
                }

                public void zzpr() {
                }
            });
        }

        public void zziW(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    public zzqk(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzf2, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzqn) zzqJ()).zzF(this.zzaEg);
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzEj() {
        try {
            return ((zzqn) zzqJ()).zzaj(this.zzaEg);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String zzEk() {
        try {
            return ((zzqn) zzqJ()).zzEk();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzEl() {
        try {
            ((zzqn) zzqJ()).zzag(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzEm() {
        try {
            ((zzqn) zzqJ()).zzai(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    public void zza(zza.zzb<Status> zzb2, String str, long j, zzq<Connections.EndpointDiscoveryListener> zzq) throws RemoteException {
        ((zzqn) zzqJ()).zza((zzqm) new zzg(zzb2, zzq), str, j, this.zzaEg);
    }

    public void zza(zza.zzb<Connections.StartAdvertisingResult> zzb2, String str, AppMetadata appMetadata, long j, zzq<Connections.ConnectionRequestListener> zzq) throws RemoteException {
        ((zzqn) zzqJ()).zza((zzqm) new zze(zzb2, zzq), str, appMetadata, j, this.zzaEg);
    }

    public void zza(zza.zzb<Status> zzb2, String str, String str2, byte[] bArr, zzq<Connections.ConnectionResponseCallback> zzq, zzq<Connections.MessageListener> zzq2) throws RemoteException {
        ((zzqn) zzqJ()).zza((zzqm) new zzd(zzb2, zzq, zzq2), str, str2, bArr, this.zzaEg);
    }

    public void zza(zza.zzb<Status> zzb2, String str, byte[] bArr, zzq<Connections.MessageListener> zzq) throws RemoteException {
        ((zzqn) zzqJ()).zza((zzqm) new zza(zzb2, zzq), str, bArr, this.zzaEg);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zza(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzqn) zzqJ()).zzb(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdv */
    public zzqn zzW(IBinder iBinder) {
        return zzqn.zza.zzdx(iBinder);
    }

    public void zzfA(String str) {
        try {
            ((zzqn) zzqJ()).zzi(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    public void zzfz(String str) {
        try {
            ((zzqn) zzqJ()).zzh(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(zza.zzb<Status> zzb2, String str) throws RemoteException {
        ((zzqn) zzqJ()).zza((zzqm) new zzc(zzb2), str, this.zzaEg);
    }
}
