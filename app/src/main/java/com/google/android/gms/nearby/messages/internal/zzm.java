package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zzf;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzi;

class zzm extends zzj<zzf> {
    private final boolean zzbcv;
    private final ClientAppContext zzbcw;
    private final zzg<StatusCallback, zze> zzbcx = new zzg<StatusCallback, zze>() {
        /* access modifiers changed from: protected */
        /* renamed from: zze */
        public zze zzf(zzq<StatusCallback> zzq) {
            return new zze(zzq);
        }
    };
    private final zzg<MessageListener, zzc> zzbcy = new zzg<MessageListener, zzc>() {
        /* access modifiers changed from: protected */
        /* renamed from: zzg */
        public zzc zzf(zzq<MessageListener> zzq) {
            return new zzc(zzq);
        }
    };

    private interface zza<C> {
        zzq<C> zzEE();
    }

    @TargetApi(14)
    private static class zzb implements Application.ActivityLifecycleCallbacks {
        private final Activity zzbcA;
        private final zzm zzbcB;

        private zzb(Activity activity, zzm zzm) {
            this.zzbcA = activity;
            this.zzbcB = zzm;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity == this.zzbcA) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (activity == this.zzbcA) {
                try {
                    this.zzbcB.zzjq(1);
                } catch (RemoteException e) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", new Object[]{activity.getPackageName(), e}));
                }
            }
        }
    }

    private static class zzc extends zzd.zza implements zza<MessageListener> {
        private final zzq<MessageListener> zzbbi;

        private zzc(zzq<MessageListener> zzq) {
            this.zzbbi = zzq;
        }

        public zzq<MessageListener> zzEE() {
            return this.zzbbi;
        }

        public void zza(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new zzq.zzb<MessageListener>() {
                /* renamed from: zza */
                public void zzt(MessageListener messageListener) {
                    messageListener.onFound(messageWrapper.zzbcu);
                }

                public void zzpr() {
                }
            });
        }

        public void zza(final MessageWrapper[] messageWrapperArr) throws RemoteException {
            this.zzbbi.zza(new zzq.zzb<MessageListener>() {
                /* renamed from: zza */
                public void zzt(MessageListener messageListener) {
                    for (MessageWrapper messageWrapper : messageWrapperArr) {
                        messageListener.zza(messageWrapper.zzbcu);
                    }
                }

                public void zzpr() {
                }
            });
        }

        public void zzb(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new zzq.zzb<MessageListener>() {
                /* renamed from: zza */
                public void zzt(MessageListener messageListener) {
                    messageListener.onLost(messageWrapper.zzbcu);
                }

                public void zzpr() {
                }
            });
        }
    }

    private static class zzd extends zzg.zza {
        private final PublishCallback zzbcG;

        private zzd(PublishCallback publishCallback) {
            this.zzbcG = publishCallback;
        }

        /* access modifiers changed from: private */
        @Nullable
        public static zzd zza(@Nullable PublishCallback publishCallback) {
            if (publishCallback == null) {
                return null;
            }
            return new zzd(publishCallback);
        }

        public void onExpired() {
            this.zzbcG.onExpired();
        }
    }

    private static class zze extends zzh.zza implements zza<StatusCallback> {
        private final zzq<StatusCallback> zzbcH;

        private zze(zzq<StatusCallback> zzq) {
            this.zzbcH = zzq;
        }

        public void onPermissionChanged(final boolean z) {
            this.zzbcH.zza(new zzq.zzb<StatusCallback>() {
                /* renamed from: zza */
                public void zzt(StatusCallback statusCallback) {
                    statusCallback.onPermissionChanged(z);
                }

                public void zzpr() {
                }
            });
        }

        public zzq<StatusCallback> zzEE() {
            return this.zzbcH;
        }
    }

    private static class zzf extends zzi.zza {
        private final SubscribeCallback zzbcK;

        private zzf(SubscribeCallback subscribeCallback) {
            this.zzbcK = subscribeCallback;
        }

        /* access modifiers changed from: private */
        @Nullable
        public static zzf zza(@Nullable SubscribeCallback subscribeCallback) {
            if (subscribeCallback == null) {
                return null;
            }
            return new zzf(subscribeCallback);
        }

        public void onExpired() {
            this.zzbcK.onExpired();
        }
    }

    private static abstract class zzg<C, W extends zza<C>> {
        private final SimpleArrayMap<C, W> zzanP;

        private zzg() {
            this.zzanP = new SimpleArrayMap<>(1);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public W zzG(C c) {
            return (zza) this.zzanP.get(c);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public W zzH(C c) {
            W w = (zza) this.zzanP.remove(c);
            if (w != null) {
                w.zzEE().clear();
            }
            return w;
        }

        /* access modifiers changed from: package-private */
        public W zza(zzq<C> zzq, C c) {
            W w = (zza) this.zzanP.get(c);
            if (w != null) {
                zzq.clear();
                return w;
            }
            W zzf = zzf(zzq);
            this.zzanP.put(c, zzf);
            return zzf;
        }

        /* access modifiers changed from: protected */
        public abstract W zzf(zzq<C> zzq);
    }

    @TargetApi(14)
    zzm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzf2, MessagesOptions messagesOptions) {
        super(context, looper, 62, zzf2, connectionCallbacks, onConnectionFailedListener);
        String zzqv = zzf2.zzqv();
        int zzaU = zzaU(context);
        if (messagesOptions != null) {
            this.zzbcw = new ClientAppContext(zzqv, messagesOptions.zzbbF, messagesOptions.zzbbH, zzaU);
            this.zzbcv = messagesOptions.zzbbG;
        } else {
            this.zzbcw = new ClientAppContext(zzqv, (String) null, false, zzaU);
            this.zzbcv = false;
        }
        if (zzaU == 1 && zzne.zzsg()) {
            Activity activity = (Activity) context;
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
            activity.getApplication().registerActivityLifecycleCallbacks(new zzb(activity, this));
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.nearby.messages.internal.zzm$zzg<C, ? extends com.google.android.gms.nearby.messages.internal.zzm$zza<C>>, com.google.android.gms.nearby.messages.internal.zzm$zzg] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <C> com.google.android.gms.common.api.internal.zzq<C> zza(com.google.android.gms.common.api.GoogleApiClient r1, C r2, com.google.android.gms.nearby.messages.internal.zzm.zzg<C, ? extends com.google.android.gms.nearby.messages.internal.zzm.zza<C>> r3) {
        /*
            com.google.android.gms.nearby.messages.internal.zzm$zza r0 = r3.zzG(r2)
            if (r0 == 0) goto L_0x000b
            com.google.android.gms.common.api.internal.zzq r0 = r0.zzEE()
        L_0x000a:
            return r0
        L_0x000b:
            com.google.android.gms.common.api.internal.zzq r0 = r1.zzr(r2)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzm.zza(com.google.android.gms.common.api.GoogleApiClient, java.lang.Object, com.google.android.gms.nearby.messages.internal.zzm$zzg):com.google.android.gms.common.api.internal.zzq");
    }

    private static int zzaU(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    public void disconnect() {
        try {
            zzjq(2);
        } catch (RemoteException e) {
            Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", new Object[]{e}));
        }
        super.disconnect();
    }

    /* access modifiers changed from: package-private */
    public zzq<MessageListener> zza(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, messageListener, this.zzbcy);
    }

    /* access modifiers changed from: package-private */
    public zzq<StatusCallback> zza(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        return zza(googleApiClient, statusCallback, this.zzbcx);
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, PendingIntent pendingIntent) throws RemoteException {
        ((zzf) zzqJ()).zza(new UnsubscribeRequest((IBinder) null, zzp.zzn(zzb2), pendingIntent, 0, this.zzbcw));
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) throws RemoteException {
        ((zzf) zzqJ()).zza(new SubscribeRequest((IBinder) null, subscribeOptions.getStrategy(), zzp.zzn(zzb2), subscribeOptions.getFilter(), pendingIntent, 0, (byte[]) null, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, zzq<MessageListener> zzq, MessageListener messageListener) throws RemoteException {
        if (this.zzbcy.zzG(messageListener) != null) {
            ((zzf) zzqJ()).zza(new UnsubscribeRequest(this.zzbcy.zza(zzq, messageListener), zzp.zzn(zzb2), (PendingIntent) null, 0, this.zzbcw));
            this.zzbcy.zzH(messageListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, zzq<MessageListener> zzq, MessageListener messageListener, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        ((zzf) zzqJ()).zza(new SubscribeRequest(this.zzbcy.zza(zzq, messageListener), subscribeOptions.getStrategy(), zzp.zzn(zzb2), subscribeOptions.getFilter(), (PendingIntent) null, 0, bArr, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, zzq<StatusCallback> zzq, StatusCallback statusCallback) throws RemoteException {
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzb2), this.zzbcx.zza(zzq, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = true;
        ((zzf) zzqJ()).zza(registerStatusCallbackRequest);
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, MessageWrapper messageWrapper) throws RemoteException {
        ((zzf) zzqJ()).zza(new UnpublishRequest(messageWrapper, zzp.zzn(zzb2), this.zzbcw));
    }

    /* access modifiers changed from: package-private */
    public void zza(zza.zzb<Status> zzb2, MessageWrapper messageWrapper, PublishOptions publishOptions) throws RemoteException {
        ((zzf) zzqJ()).zza(new PublishRequest(messageWrapper, publishOptions.getStrategy(), zzp.zzn(zzb2), this.zzbcv, zzd.zza(publishOptions.getCallback()), this.zzbcw));
    }

    /* access modifiers changed from: package-private */
    public void zzb(zza.zzb<Status> zzb2, zzq<StatusCallback> zzq, StatusCallback statusCallback) throws RemoteException {
        if (this.zzbcx.zzG(statusCallback) != null) {
            RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzb2), this.zzbcx.zza(zzq, statusCallback), this.zzbcw);
            registerStatusCallbackRequest.zzbcX = false;
            ((zzf) zzqJ()).zza(registerStatusCallbackRequest);
            this.zzbcx.zzH(statusCallback);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdE */
    public zzf zzW(IBinder iBinder) {
        return zzf.zza.zzdA(iBinder);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zzgu() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zzgv() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* access modifiers changed from: package-private */
    public void zzjq(int i) throws RemoteException {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", new Object[]{Integer.valueOf(i)}));
                return;
        }
        if (isConnected()) {
            HandleClientLifecycleEventRequest handleClientLifecycleEventRequest = new HandleClientLifecycleEventRequest(this.zzbcw, i);
            Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", new Object[]{str}));
            ((zzf) zzqJ()).zza(handleClientLifecycleEventRequest);
            return;
        }
        Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", new Object[]{str}));
    }

    /* access modifiers changed from: package-private */
    public void zzm(zza.zzb<Status> zzb2) throws RemoteException {
        ((zzf) zzqJ()).zza(new GetPermissionStatusRequest(zzp.zzn(zzb2), this.zzbcw));
    }
}
