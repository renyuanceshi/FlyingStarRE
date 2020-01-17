package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

final class zzbq<T> extends zzaw.zza {
    private zzq<MessageApi.MessageListener> zzbbb;
    private final IntentFilter[] zzbsT;
    private zzq<zza.C0249zza> zzbtp;
    private zzq<zzc.zza> zzbtq;
    private zzq<DataApi.DataListener> zzbtr;
    private zzq<NodeApi.NodeListener> zzbts;
    private zzq<NodeApi.zza> zzbtt;
    private zzq<ChannelApi.ChannelListener> zzbtu;
    private zzq<CapabilityApi.CapabilityListener> zzbtv;
    private final String zzbtw;

    private zzbq(IntentFilter[] intentFilterArr, String str) {
        this.zzbsT = (IntentFilter[]) zzx.zzz(intentFilterArr);
        this.zzbtw = str;
    }

    private static zzq.zzb<NodeApi.zza> zzI(final List<NodeParcelable> list) {
        return new zzq.zzb<NodeApi.zza>() {
            /* renamed from: zza */
            public void zzt(NodeApi.zza zza) {
                zza.onConnectedNodes(list);
            }

            public void zzpr() {
            }
        };
    }

    public static zzbq<ChannelApi.ChannelListener> zza(zzq<ChannelApi.ChannelListener> zzq, String str, IntentFilter[] intentFilterArr) {
        zzbq<ChannelApi.ChannelListener> zzbq = new zzbq<>(intentFilterArr, (String) zzx.zzz(str));
        zzbq.zzbtu = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    public static zzbq<DataApi.DataListener> zza(zzq<DataApi.DataListener> zzq, IntentFilter[] intentFilterArr) {
        zzbq<DataApi.DataListener> zzbq = new zzbq<>(intentFilterArr, (String) null);
        zzbq.zzbtr = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    private static zzq.zzb<DataApi.DataListener> zzai(final DataHolder dataHolder) {
        return new zzq.zzb<DataApi.DataListener>() {
            /* renamed from: zza */
            public void zzt(DataApi.DataListener dataListener) {
                try {
                    dataListener.onDataChanged(new DataEventBuffer(dataHolder));
                } finally {
                    dataHolder.close();
                }
            }

            public void zzpr() {
                dataHolder.close();
            }
        };
    }

    private static zzq.zzb<zza.C0249zza> zzb(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new zzq.zzb<zza.C0249zza>() {
            /* renamed from: zza */
            public void zzt(zza.C0249zza zza) {
                zza.zza(amsEntityUpdateParcelable);
            }

            public void zzpr() {
            }
        };
    }

    private static zzq.zzb<zzc.zza> zzb(final AncsNotificationParcelable ancsNotificationParcelable) {
        return new zzq.zzb<zzc.zza>() {
            /* renamed from: zza */
            public void zzt(zzc.zza zza) {
                zza.zza(ancsNotificationParcelable);
            }

            public void zzpr() {
            }
        };
    }

    private static zzq.zzb<CapabilityApi.CapabilityListener> zzb(final CapabilityInfoParcelable capabilityInfoParcelable) {
        return new zzq.zzb<CapabilityApi.CapabilityListener>() {
            /* renamed from: zza */
            public void zzt(CapabilityApi.CapabilityListener capabilityListener) {
                capabilityListener.onCapabilityChanged(capabilityInfoParcelable);
            }

            public void zzpr() {
            }
        };
    }

    private static zzq.zzb<ChannelApi.ChannelListener> zzb(final ChannelEventParcelable channelEventParcelable) {
        return new zzq.zzb<ChannelApi.ChannelListener>() {
            /* renamed from: zzb */
            public void zzt(ChannelApi.ChannelListener channelListener) {
                channelEventParcelable.zza(channelListener);
            }

            public void zzpr() {
            }
        };
    }

    private static zzq.zzb<MessageApi.MessageListener> zzb(final MessageEventParcelable messageEventParcelable) {
        return new zzq.zzb<MessageApi.MessageListener>() {
            /* renamed from: zza */
            public void zzt(MessageApi.MessageListener messageListener) {
                messageListener.onMessageReceived(messageEventParcelable);
            }

            public void zzpr() {
            }
        };
    }

    public static zzbq<MessageApi.MessageListener> zzb(zzq<MessageApi.MessageListener> zzq, IntentFilter[] intentFilterArr) {
        zzbq<MessageApi.MessageListener> zzbq = new zzbq<>(intentFilterArr, (String) null);
        zzbq.zzbbb = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    private static zzq.zzb<NodeApi.NodeListener> zzc(final NodeParcelable nodeParcelable) {
        return new zzq.zzb<NodeApi.NodeListener>() {
            /* renamed from: zza */
            public void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerConnected(nodeParcelable);
            }

            public void zzpr() {
            }
        };
    }

    public static zzbq<NodeApi.NodeListener> zzc(zzq<NodeApi.NodeListener> zzq, IntentFilter[] intentFilterArr) {
        zzbq<NodeApi.NodeListener> zzbq = new zzbq<>(intentFilterArr, (String) null);
        zzbq.zzbts = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    private static zzq.zzb<NodeApi.NodeListener> zzd(final NodeParcelable nodeParcelable) {
        return new zzq.zzb<NodeApi.NodeListener>() {
            /* renamed from: zza */
            public void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerDisconnected(nodeParcelable);
            }

            public void zzpr() {
            }
        };
    }

    public static zzbq<ChannelApi.ChannelListener> zzd(zzq<ChannelApi.ChannelListener> zzq, IntentFilter[] intentFilterArr) {
        zzbq<ChannelApi.ChannelListener> zzbq = new zzbq<>(intentFilterArr, (String) null);
        zzbq.zzbtu = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    public static zzbq<CapabilityApi.CapabilityListener> zze(zzq<CapabilityApi.CapabilityListener> zzq, IntentFilter[] intentFilterArr) {
        zzbq<CapabilityApi.CapabilityListener> zzbq = new zzbq<>(intentFilterArr, (String) null);
        zzbq.zzbtv = (zzq) zzx.zzz(zzq);
        return zzbq;
    }

    private static void zzh(zzq<?> zzq) {
        if (zzq != null) {
            zzq.clear();
        }
    }

    public void clear() {
        zzh(this.zzbtp);
        this.zzbtp = null;
        zzh(this.zzbtq);
        this.zzbtq = null;
        zzh(this.zzbtr);
        this.zzbtr = null;
        zzh(this.zzbbb);
        this.zzbbb = null;
        zzh(this.zzbts);
        this.zzbts = null;
        zzh(this.zzbtt);
        this.zzbtt = null;
        zzh(this.zzbtu);
        this.zzbtu = null;
        zzh(this.zzbtv);
        this.zzbtv = null;
    }

    public void onConnectedNodes(List<NodeParcelable> list) {
        if (this.zzbtt != null) {
            this.zzbtt.zza(zzI(list));
        }
    }

    public IntentFilter[] zzIO() {
        return this.zzbsT;
    }

    public String zzIP() {
        return this.zzbtw;
    }

    public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzbtp != null) {
            this.zzbtp.zza(zzb(amsEntityUpdateParcelable));
        }
    }

    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzbtq != null) {
            this.zzbtq.zza(zzb(ancsNotificationParcelable));
        }
    }

    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbtv != null) {
            this.zzbtv.zza(zzb(capabilityInfoParcelable));
        }
    }

    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbtu != null) {
            this.zzbtu.zza(zzb(channelEventParcelable));
        }
    }

    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzbbb != null) {
            this.zzbbb.zza(zzb(messageEventParcelable));
        }
    }

    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzc(nodeParcelable));
        }
    }

    public void zzag(DataHolder dataHolder) {
        if (this.zzbtr != null) {
            this.zzbtr.zza(zzai(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzd(nodeParcelable));
        }
    }
}
