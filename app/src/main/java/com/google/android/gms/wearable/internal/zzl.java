package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzb;

public final class zzl implements ChannelApi {

    static final class zza implements ChannelApi.OpenChannelResult {
        private final Status zzUX;
        private final Channel zzbrY;

        zza(Status status, Channel channel) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbrY = channel;
        }

        public Channel getChannel() {
            return this.zzbrY;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    static final class zzb extends zzi<Status> {
        private final String zzVo;
        private ChannelApi.ChannelListener zzbrZ;

        zzb(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzbrZ = (ChannelApi.ChannelListener) zzx.zzz(channelListener);
            this.zzVo = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbp zzbp) throws RemoteException {
            zzbp.zza((zza.zzb<Status>) this, this.zzbrZ, this.zzVo);
            this.zzbrZ = null;
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            this.zzbrZ = null;
            return status;
        }
    }

    private static zzb.zza<ChannelApi.ChannelListener> zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza<ChannelApi.ChannelListener>() {
            public void zza(zzbp zzbp, zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, zzq<ChannelApi.ChannelListener> zzq) throws RemoteException {
                zzbp.zza(zzb, channelListener, zzq, (String) null, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(channelListener, (Object) "listener is null");
        return zzb.zza(googleApiClient, zza(new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), channelListener);
    }

    public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient googleApiClient, final String str, final String str2) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(str, (Object) "nodeId is null");
        zzx.zzb(str2, (Object) "path is null");
        return googleApiClient.zza(new zzi<ChannelApi.OpenChannelResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zze(this, str, str2);
            }

            /* renamed from: zzbs */
            public ChannelApi.OpenChannelResult zzc(Status status) {
                return new zza(status, (Channel) null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(channelListener, (Object) "listener is null");
        return googleApiClient.zza(new zzb(googleApiClient, channelListener, (String) null));
    }
}
