package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.internal.zzb;
import java.util.Map;
import java.util.Set;

public class zzj implements CapabilityApi {

    public static class zza implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
        private final Status zzUX;

        public zza(Status status) {
            this.zzUX = status;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zzb implements CapabilityApi.CapabilityListener {
        final CapabilityApi.CapabilityListener zzbrQ;
        final String zzbrR;

        zzb(CapabilityApi.CapabilityListener capabilityListener, String str) {
            this.zzbrQ = capabilityListener;
            this.zzbrR = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.zzbrQ.equals(zzb.zzbrQ)) {
                return this.zzbrR.equals(zzb.zzbrR);
            }
            return false;
        }

        public int hashCode() {
            return (this.zzbrQ.hashCode() * 31) + this.zzbrR.hashCode();
        }

        public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
            this.zzbrQ.onCapabilityChanged(capabilityInfo);
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzbrS;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzbrS = set;
        }

        public String getName() {
            return this.mName;
        }

        public Set<Node> getNodes() {
            return this.zzbrS;
        }
    }

    public static class zzd implements CapabilityApi.GetAllCapabilitiesResult {
        private final Status zzUX;
        private final Map<String, CapabilityInfo> zzbrT;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzUX = status;
            this.zzbrT = map;
        }

        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzbrT;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zze implements CapabilityApi.GetCapabilityResult {
        private final Status zzUX;
        private final CapabilityInfo zzbrU;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzUX = status;
            this.zzbrU = capabilityInfo;
        }

        public CapabilityInfo getCapability() {
            return this.zzbrU;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zzf extends zzi<Status> {
        private CapabilityApi.CapabilityListener zzbrQ;

        private zzf(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
            super(googleApiClient);
            this.zzbrQ = capabilityListener;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbp zzbp) throws RemoteException {
            zzbp.zza((zza.zzb<Status>) this, this.zzbrQ);
            this.zzbrQ = null;
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            this.zzbrQ = null;
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), capabilityListener);
    }

    private static zzb.zza<CapabilityApi.CapabilityListener> zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza<CapabilityApi.CapabilityListener>() {
            public void zza(zzbp zzbp, zza.zzb<Status> zzb, CapabilityApi.CapabilityListener capabilityListener, zzq<CapabilityApi.CapabilityListener> zzq) throws RemoteException {
                zzbp.zza(zzb, capabilityListener, zzq, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        zzx.zzb(str != null, (Object) "capability must not be null");
        zzb zzb2 = new zzb(capabilityListener, str);
        IntentFilter zzgM = zzbn.zzgM(CapabilityApi.ACTION_CAPABILITY_CHANGED);
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        zzgM.addDataPath(str, 0);
        return zza(googleApiClient, zzb2, new IntentFilter[]{zzgM});
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, Uri uri, int i) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        zzx.zzb(i == 0 || i == 1, (Object) "invalid filter type");
        return zza(googleApiClient, capabilityListener, new IntentFilter[]{zzbn.zza(CapabilityApi.ACTION_CAPABILITY_CHANGED, uri, i)});
    }

    public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzi<CapabilityApi.AddLocalCapabilityResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzr(this, str);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbq */
            public CapabilityApi.AddLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }

    public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, final int i) {
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        zzx.zzac(z);
        return googleApiClient.zza(new zzi<CapabilityApi.GetAllCapabilitiesResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzb(this, i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbp */
            public CapabilityApi.GetAllCapabilitiesResult zzc(Status status) {
                return new zzd(status, (Map<String, CapabilityInfo>) null);
            }
        });
    }

    public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, final String str, final int i) {
        boolean z = true;
        if (!(i == 0 || i == 1)) {
            z = false;
        }
        zzx.zzac(z);
        return googleApiClient.zza(new zzi<CapabilityApi.GetCapabilityResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzg(this, str, i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbo */
            public CapabilityApi.GetCapabilityResult zzc(Status status) {
                return new zze(status, (CapabilityInfo) null);
            }
        });
    }

    public PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        return googleApiClient.zza(new zzf(googleApiClient, new zzb(capabilityListener, str)));
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
        return googleApiClient.zza(new zzf(googleApiClient, capabilityListener));
    }

    public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzi<CapabilityApi.RemoveLocalCapabilityResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzs(this, str);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbr */
            public CapabilityApi.RemoveLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }
}
