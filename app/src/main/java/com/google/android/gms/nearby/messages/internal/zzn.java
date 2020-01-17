package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.List;

public class zzn implements Messages {
    public static final Api.zzc<zzm> zzUI = new Api.zzc<>();
    public static final Api.zza<zzm, MessagesOptions> zzUJ = new Api.zza<zzm, MessagesOptions>() {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzm zza(Context context, Looper looper, zzf zzf, MessagesOptions messagesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzm(context, looper, connectionCallbacks, onConnectionFailedListener, zzf, messagesOptions);
        }
    };

    static abstract class zza extends zza.C0030zza<Status, zzm> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzn.zzUI, googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Nullable
    private static Message zzA(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.MESSAGES");
    }

    @Nullable
    private static Message zzB(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.LOST_MESSAGE");
    }

    private static List<Message> zzC(Intent intent) {
        return zzj.zzd(intent, "com.google.android.gms.nearby.messages.UPDATED_MESSAGES");
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zzm(this);
            }
        });
    }

    public void handleIntent(Intent intent, MessageListener messageListener) {
        Message zzA = zzA(intent);
        if (zzA != null) {
            messageListener.onFound(zzA);
        }
        Message zzB = zzB(intent);
        if (zzB != null) {
            messageListener.onLost(zzB);
        }
        for (Message zza2 : zzC(intent)) {
            messageListener.zza(zza2);
        }
    }

    public PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient googleApiClient, final Message message, final PublishOptions publishOptions) {
        zzx.zzz(message);
        zzx.zzz(publishOptions);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, MessageWrapper.zzb(message), publishOptions);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, Strategy strategy) {
        return publish(googleApiClient, message, new PublishOptions.Builder().setStrategy(strategy).build());
    }

    public PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        zzx.zzz(statusCallback);
        final zzq<StatusCallback> zza2 = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, statusCallback);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, (zzq<StatusCallback>) zza2, statusCallback);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final SubscribeOptions subscribeOptions) {
        zzx.zzz(pendingIntent);
        zzx.zzz(subscribeOptions);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, pendingIntent, subscribeOptions);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy) {
        return subscribe(googleApiClient, messageListener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter) {
        return subscribe(googleApiClient, messageListener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(messageFilter).build());
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        zzx.zzz(messageListener);
        zzx.zzz(subscribeOptions);
        final zzq<MessageListener> zza2 = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, messageListener);
        final MessageListener messageListener2 = messageListener;
        final SubscribeOptions subscribeOptions2 = subscribeOptions;
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza(this, zza2, messageListener2, subscribeOptions2, (byte[]) null);
            }
        });
    }

    public PendingResult<Status> unpublish(GoogleApiClient googleApiClient, final Message message) {
        zzx.zzz(message);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, MessageWrapper.zzb(message));
            }
        });
    }

    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        final zzq<StatusCallback> zza2 = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, statusCallback);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zzb(this, zza2, statusCallback);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        zzx.zzz(pendingIntent);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, pendingIntent);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final MessageListener messageListener) {
        zzx.zzz(messageListener);
        final zzq<MessageListener> zza2 = ((zzm) googleApiClient.zza(zzUI)).zza(googleApiClient, messageListener);
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzm zzm) throws RemoteException {
                zzm.zza((zza.zzb<Status>) this, (zzq<MessageListener>) zza2, messageListener);
            }
        });
    }
}
