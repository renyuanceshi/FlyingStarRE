package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.ChannelImpl;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbo {

    static final class zza extends zzb<CapabilityApi.AddLocalCapabilityResult> {
        public zza(zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzX(new zzj.zza(zzbk.zzgc(addLocalCapabilityResponse.statusCode)));
        }
    }

    static abstract class zzb<T> extends zza {
        private zza.zzb<T> zzUz;

        public zzb(zza.zzb<T> zzb) {
            this.zzUz = zzb;
        }

        public void zzX(T t) {
            zza.zzb<T> zzb = this.zzUz;
            if (zzb != null) {
                zzb.zzs(t);
                this.zzUz = null;
            }
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(zza.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(zza.zzb<Status> zzb) {
            super(zzb);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DataApi.DeleteDataItemsResult> {
        public zze(zza.zzb<DataApi.DeleteDataItemsResult> zzb) {
            super(zzb);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzX(new zzx.zzb(zzbk.zzgc(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbsz));
        }
    }

    static final class zzf extends zzb<CapabilityApi.GetAllCapabilitiesResult> {
        public zzf(zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzb) {
            super(zzb);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzX(new zzj.zzd(zzbk.zzgc(getAllCapabilitiesResponse.statusCode), zzbo.zzG(getAllCapabilitiesResponse.zzbsA)));
        }
    }

    static final class zzg extends zzb<CapabilityApi.GetCapabilityResult> {
        public zzg(zza.zzb<CapabilityApi.GetCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzX(new zzj.zze(zzbk.zzgc(getCapabilityResponse.statusCode), new zzj.zzc(getCapabilityResponse.zzbsB)));
        }
    }

    static final class zzh extends zzb<Channel.GetInputStreamResult> {
        private final zzt zzbtd;

        public zzh(zza.zzb<Channel.GetInputStreamResult> zzb, zzt zzt) {
            super(zzb);
            this.zzbtd = (zzt) com.google.android.gms.common.internal.zzx.zzz(zzt);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            zzp zzp = null;
            if (getChannelInputStreamResponse.zzbsC != null) {
                zzp = new zzp(new ParcelFileDescriptor.AutoCloseInputStream(getChannelInputStreamResponse.zzbsC));
                this.zzbtd.zza(zzp.zzIJ());
            }
            zzX(new ChannelImpl.zza(new Status(getChannelInputStreamResponse.statusCode), zzp));
        }
    }

    static final class zzi extends zzb<Channel.GetOutputStreamResult> {
        private final zzt zzbtd;

        public zzi(zza.zzb<Channel.GetOutputStreamResult> zzb, zzt zzt) {
            super(zzb);
            this.zzbtd = (zzt) com.google.android.gms.common.internal.zzx.zzz(zzt);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            zzq zzq = null;
            if (getChannelOutputStreamResponse.zzbsC != null) {
                zzq = new zzq(new ParcelFileDescriptor.AutoCloseOutputStream(getChannelOutputStreamResponse.zzbsC));
                this.zzbtd.zza(zzq.zzIJ());
            }
            zzX(new ChannelImpl.zzb(new Status(getChannelOutputStreamResponse.statusCode), zzq));
        }
    }

    static final class zzj extends zzb<NodeApi.GetConnectedNodesResult> {
        public zzj(zza.zzb<NodeApi.GetConnectedNodesResult> zzb) {
            super(zzb);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbsI);
            zzX(new zzbb.zza(zzbk.zzgc(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataApi.DataItemResult> {
        public zzk(zza.zzb<DataApi.DataItemResult> zzb) {
            super(zzb);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzX(new zzx.zza(zzbk.zzgc(getDataItemResponse.statusCode), getDataItemResponse.zzbsJ));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(zza.zzb<DataItemBuffer> zzb) {
            super(zzb);
        }

        public void zzah(DataHolder dataHolder) {
            zzX(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<DataApi.GetFdForAssetResult> {
        public zzm(zza.zzb<DataApi.GetFdForAssetResult> zzb) {
            super(zzb);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzX(new zzx.zzc(zzbk.zzgc(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbsK));
        }
    }

    static final class zzn extends zzb<NodeApi.GetLocalNodeResult> {
        public zzn(zza.zzb<NodeApi.GetLocalNodeResult> zzb) {
            super(zzb);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzX(new zzbb.zzb(zzbk.zzgc(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbsL));
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zza(Status status) {
        }
    }

    static final class zzp extends zzb<ChannelApi.OpenChannelResult> {
        public zzp(zza.zzb<ChannelApi.OpenChannelResult> zzb) {
            super(zzb);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzX(new zzl.zza(zzbk.zzgc(openChannelResponse.statusCode), openChannelResponse.zzbsc));
        }
    }

    static final class zzq extends zzb<DataApi.DataItemResult> {
        private final List<FutureTask<Boolean>> zzzM;

        zzq(zza.zzb<DataApi.DataItemResult> zzb, List<FutureTask<Boolean>> list) {
            super(zzb);
            this.zzzM = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzX(new zzx.zza(zzbk.zzgc(putDataResponse.statusCode), putDataResponse.zzbsJ));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask<Boolean> cancel : this.zzzM) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(zza.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzX(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<CapabilityApi.RemoveLocalCapabilityResult> {
        public zzs(zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzX(new zzj.zza(zzbk.zzgc(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<MessageApi.SendMessageResult> {
        public zzt(zza.zzb<MessageApi.SendMessageResult> zzb) {
            super(zzb);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzX(new zzaz.zzb(zzbk.zzgc(sendMessageResponse.statusCode), sendMessageResponse.zzaNj));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(zza.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzX(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, CapabilityInfo> zzG(List<CapabilityInfoParcelable> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable next : list) {
            hashMap.put(next.getName(), new zzj.zzc(next));
        }
        return hashMap;
    }
}
