package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzb;
import java.util.ArrayList;
import java.util.List;

public final class zzbb implements NodeApi {

    public static class zza implements NodeApi.GetConnectedNodesResult {
        private final Status zzUX;
        private final List<Node> zzbsW;

        public zza(Status status, List<Node> list) {
            this.zzUX = status;
            this.zzbsW = list;
        }

        public List<Node> getNodes() {
            return this.zzbsW;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements NodeApi.GetLocalNodeResult {
        private final Status zzUX;
        private final Node zzbsX;

        public zzb(Status status, Node node) {
            this.zzUX = status;
            this.zzbsX = node;
        }

        public Node getNode() {
            return this.zzbsX;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static zzb.zza<NodeApi.NodeListener> zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza<NodeApi.NodeListener>() {
            public void zza(zzbp zzbp, zza.zzb<Status> zzb, NodeApi.NodeListener nodeListener, zzq<NodeApi.NodeListener> zzq) throws RemoteException {
                zzbp.zza(zzb, nodeListener, zzq, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, NodeApi.NodeListener nodeListener) {
        return zzb.zza(googleApiClient, zza(new IntentFilter[]{zzbn.zzgM("com.google.android.gms.wearable.NODE_CHANGED")}), nodeListener);
    }

    public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<NodeApi.GetConnectedNodesResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzt(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbB */
            public NodeApi.GetConnectedNodesResult zzc(Status status) {
                return new zza(status, new ArrayList());
            }
        });
    }

    public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<NodeApi.GetLocalNodeResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzs(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbA */
            public NodeApi.GetLocalNodeResult zzc(Status status) {
                return new zzb(status, (Node) null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final NodeApi.NodeListener nodeListener) {
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<Status>) this, nodeListener);
            }

            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
