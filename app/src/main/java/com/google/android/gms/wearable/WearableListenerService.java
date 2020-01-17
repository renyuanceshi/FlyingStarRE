package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzaw;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener, NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    /* access modifiers changed from: private */
    public boolean zzQl;
    /* access modifiers changed from: private */
    public String zzTJ;
    private IBinder zzakD;
    /* access modifiers changed from: private */
    public Handler zzbro;
    /* access modifiers changed from: private */
    public final Object zzbrp = new Object();

    private final class zza extends zzaw.zza {
        private volatile int zzakz;

        private zza() {
            this.zzakz = -1;
        }

        private void zzIx() throws SecurityException {
            int callingUid = Binder.getCallingUid();
            if (callingUid != this.zzakz) {
                if (GooglePlayServicesUtil.zzf(WearableListenerService.this, callingUid)) {
                    this.zzakz = callingUid;
                    return;
                }
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }

        private boolean zza(Runnable runnable, String str, Object obj) {
            if (!(WearableListenerService.this instanceof zzj)) {
                return false;
            }
            return zzb(runnable, str, obj);
        }

        private boolean zzb(Runnable runnable, String str, Object obj) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", String.format("%s: %s %s", new Object[]{str, WearableListenerService.this.zzTJ, obj}));
            }
            zzIx();
            synchronized (WearableListenerService.this.zzbrp) {
                if (WearableListenerService.this.zzQl) {
                    return false;
                }
                WearableListenerService.this.zzbro.post(runnable);
                return true;
            }
        }

        public void onConnectedNodes(final List<NodeParcelable> list) {
            zzb(new Runnable() {
                public void run() {
                    WearableListenerService.this.onConnectedNodes(list);
                }
            }, "onConnectedNodes", list);
        }

        public void zza(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            zza(new Runnable() {
                public void run() {
                    ((zzj) WearableListenerService.this).zza((zzb) amsEntityUpdateParcelable);
                }
            }, "onEntityUpdate", amsEntityUpdateParcelable);
        }

        public void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            zza(new Runnable() {
                public void run() {
                    ((zzj) WearableListenerService.this).zza((zzd) ancsNotificationParcelable);
                }
            }, "onNotificationReceived", ancsNotificationParcelable);
        }

        public void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            zzb(new Runnable() {
                public void run() {
                    WearableListenerService.this.onCapabilityChanged(capabilityInfoParcelable);
                }
            }, "onConnectedCapabilityChanged", capabilityInfoParcelable);
        }

        public void zza(final ChannelEventParcelable channelEventParcelable) {
            zzb(new Runnable() {
                public void run() {
                    channelEventParcelable.zza(WearableListenerService.this);
                }
            }, "onChannelEvent", channelEventParcelable);
        }

        public void zza(final MessageEventParcelable messageEventParcelable) {
            zzb(new Runnable() {
                public void run() {
                    WearableListenerService.this.onMessageReceived(messageEventParcelable);
                }
            }, "onMessageReceived", messageEventParcelable);
        }

        public void zza(final NodeParcelable nodeParcelable) {
            zzb(new Runnable() {
                public void run() {
                    WearableListenerService.this.onPeerConnected(nodeParcelable);
                }
            }, "onPeerConnected", nodeParcelable);
        }

        public void zzag(final DataHolder dataHolder) {
            try {
                if (zzb(new Runnable() {
                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            WearableListenerService.this.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                }, "onDataItemChanged", dataHolder)) {
                }
            } finally {
                dataHolder.close();
            }
        }

        public void zzb(final NodeParcelable nodeParcelable) {
            zzb(new Runnable() {
                public void run() {
                    WearableListenerService.this.onPeerDisconnected(nodeParcelable);
                }
            }, "onPeerDisconnected", nodeParcelable);
        }
    }

    public final IBinder onBind(Intent intent) {
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            return this.zzakD;
        }
        return null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        this.zzTJ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzbro = new Handler(handlerThread.getLooper());
        this.zzakD = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onDestroy: " + new ComponentName(getPackageName(), getClass().getName()).flattenToShortString());
        }
        synchronized (this.zzbrp) {
            this.zzQl = true;
            if (this.zzbro == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzbro.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int i, int i2) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
