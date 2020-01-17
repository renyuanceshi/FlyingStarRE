package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(19)
public abstract class CastRemoteDisplayLocalService extends Service {
    /* access modifiers changed from: private */
    public static final zzl zzaaf = new zzl("CastRemoteDisplayLocalService");
    private static final int zzaag = R.id.cast_notification_id;
    /* access modifiers changed from: private */
    public static final Object zzaah = new Object();
    /* access modifiers changed from: private */
    public static AtomicBoolean zzaai = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static CastRemoteDisplayLocalService zzaax;
    private Handler mHandler;
    private Notification mNotification;
    private String zzZC;
    private GoogleApiClient zzaaj;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzaak;
    private Callbacks zzaal;
    private zzb zzaam;
    private NotificationSettings zzaan;
    private boolean zzaao;
    private PendingIntent zzaap;
    /* access modifiers changed from: private */
    public CastDevice zzaaq;
    /* access modifiers changed from: private */
    public Display zzaar;
    /* access modifiers changed from: private */
    public Context zzaas;
    /* access modifiers changed from: private */
    public ServiceConnection zzaat;
    private MediaRouter zzaau;
    /* access modifiers changed from: private */
    public boolean zzaav = false;
    private final MediaRouter.Callback zzaaw = new MediaRouter.Callback() {
        public void onRouteUnselected(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
            CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected");
            if (CastRemoteDisplayLocalService.this.zzaaq == null) {
                CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected, no device was selected");
            } else if (!CastDevice.getFromBundle(routeInfo.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.this.zzaaq.getDeviceId())) {
                CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected, device does not match");
            } else {
                CastRemoteDisplayLocalService.stopService();
            }
        }
    };
    private final IBinder zzaay = new zza();

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        /* access modifiers changed from: private */
        public Notification mNotification;
        /* access modifiers changed from: private */
        public PendingIntent zzaaF;
        /* access modifiers changed from: private */
        public String zzaaG;
        /* access modifiers changed from: private */
        public String zzaaH;

        public static final class Builder {
            private NotificationSettings zzaaI = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzaaI.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzaaI.zzaaG)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzaaI.zzaaH)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzaaI.zzaaF != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzaaI.zzaaG) && TextUtils.isEmpty(this.zzaaI.zzaaH) && this.zzaaI.zzaaF == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzaaI;
            }

            public Builder setNotification(Notification notification) {
                Notification unused = this.zzaaI.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent) {
                PendingIntent unused = this.zzaaI.zzaaF = pendingIntent;
                return this;
            }

            public Builder setNotificationText(String str) {
                String unused = this.zzaaI.zzaaH = str;
                return this;
            }

            public Builder setNotificationTitle(String str) {
                String unused = this.zzaaI.zzaaG = str;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings notificationSettings) {
            this.mNotification = notificationSettings.mNotification;
            this.zzaaF = notificationSettings.zzaaF;
            this.zzaaG = notificationSettings.zzaaG;
            this.zzaaH = notificationSettings.zzaaH;
        }
    }

    private class zza extends Binder {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public CastRemoteDisplayLocalService zznM() {
            return CastRemoteDisplayLocalService.this;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzaaf.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzaah) {
            castRemoteDisplayLocalService = zzaax;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzaaf.zzY(true);
    }

    public static void startService(Context context, Class<? extends CastRemoteDisplayLocalService> cls, String str, CastDevice castDevice, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzaaf.zzb("Starting Service", new Object[0]);
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzS(true);
            }
        }
        zzb(context, (Class) cls);
        zzx.zzb(context, (Object) "activityContext is required.");
        zzx.zzb(cls, (Object) "serviceClass is required.");
        zzx.zzb(str, (Object) "applicationId is required.");
        zzx.zzb(castDevice, (Object) "device is required.");
        zzx.zzb(notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzaaF == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzaai.getAndSet(true)) {
            zzaaf.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(context, cls);
            context.startService(intent);
            final String str2 = str;
            final CastDevice castDevice2 = castDevice;
            final NotificationSettings notificationSettings2 = notificationSettings;
            final Context context2 = context;
            final Callbacks callbacks2 = callbacks;
            context.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    CastRemoteDisplayLocalService zznM = ((zza) iBinder).zznM();
                    if (zznM != null) {
                        if (zznM.zza(str2, castDevice2, notificationSettings2, context2, this, callbacks2)) {
                            return;
                        }
                    }
                    CastRemoteDisplayLocalService.zzaaf.zzc("Connected but unable to get the service instance", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                    CastRemoteDisplayLocalService.zzaai.set(false);
                    try {
                        context2.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    CastRemoteDisplayLocalService.zzaaf.zzb("onServiceDisconnected", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzaai.set(false);
                    try {
                        context2.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzS(false);
    }

    private void zzQ(final boolean z) {
        if (this.mHandler == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    CastRemoteDisplayLocalService.this.zzR(z);
                }
            });
        } else {
            zzR(z);
        }
    }

    /* access modifiers changed from: private */
    public void zzR(boolean z) {
        zzbe("Stopping Service");
        zzx.zzcD("stopServiceInstanceInternal must be called on the main thread");
        if (!z && this.zzaau != null) {
            zzbe("Setting default route");
            this.zzaau.selectRoute(this.zzaau.getDefaultRoute());
        }
        if (this.zzaam != null) {
            zzbe("Unregistering notification receiver");
            unregisterReceiver(this.zzaam);
        }
        zznF();
        zznG();
        zznB();
        if (this.zzaaj != null) {
            this.zzaaj.disconnect();
            this.zzaaj = null;
        }
        if (!(this.zzaas == null || this.zzaat == null)) {
            try {
                this.zzaas.unbindService(this.zzaat);
            } catch (IllegalArgumentException e) {
                zzbe("No need to unbind service, already unbound");
            }
            this.zzaat = null;
            this.zzaas = null;
        }
        this.zzZC = null;
        this.zzaaj = null;
        this.mNotification = null;
        this.zzaar = null;
    }

    /* access modifiers changed from: private */
    public static void zzS(boolean z) {
        zzaaf.zzb("Stopping Service", new Object[0]);
        zzaai.set(false);
        synchronized (zzaah) {
            if (zzaax == null) {
                zzaaf.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzaax;
            zzaax = null;
            castRemoteDisplayLocalService.zzQ(z);
        }
    }

    private Notification zzT(boolean z) {
        int i;
        int i2;
        String str;
        zzbe("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        String zzc = this.zzaan.zzaaG;
        String zzd = this.zzaan.zzaaH;
        if (z) {
            i = R.string.cast_notification_connected_message;
            i2 = R.drawable.cast_ic_notification_on;
        } else {
            i = R.string.cast_notification_connecting_message;
            i2 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzc)) {
            zzc = getString(i3);
        }
        if (TextUtils.isEmpty(zzd)) {
            str = getString(i, new Object[]{this.zzaaq.getFriendlyName()});
        } else {
            str = zzd;
        }
        return new NotificationCompat.Builder(this).setContentTitle(zzc).setContentText(str).setContentIntent(this.zzaan.zzaaF).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(R.string.cast_notification_disconnect), zznH()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new GoogleApiClient.ConnectionCallbacks() {
            public void onConnected(Bundle bundle) {
                CastRemoteDisplayLocalService.this.zzbe("onConnected");
                CastRemoteDisplayLocalService.this.zznC();
            }

            public void onConnectionSuspended(int i) {
                CastRemoteDisplayLocalService.zzaaf.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(i)}), new Object[0]);
            }
        }, new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult connectionResult) {
                CastRemoteDisplayLocalService.this.zzbh("Connection failed: " + connectionResult);
                CastRemoteDisplayLocalService.this.zznE();
            }
        }).addApi(CastRemoteDisplay.API, new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(castDevice, this.zzaak).build()).build();
    }

    /* access modifiers changed from: private */
    public void zza(Display display) {
        this.zzaar = display;
        if (this.zzaao) {
            this.mNotification = zzT(true);
            startForeground(zzaag, this.mNotification);
        }
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionStarted(this);
            this.zzaal = null;
        }
        onCreatePresentation(this.zzaar);
    }

    /* access modifiers changed from: private */
    public void zza(NotificationSettings notificationSettings) {
        zzx.zzcD("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzaan == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzaao) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            Notification unused = this.zzaan.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzaaF != null) {
                PendingIntent unused2 = this.zzaan.zzaaF = notificationSettings.zzaaF;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaG)) {
                String unused3 = this.zzaan.zzaaG = notificationSettings.zzaaG;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaH)) {
                String unused4 = this.zzaan.zzaaH = notificationSettings.zzaaH;
            }
            this.mNotification = zzT(true);
        }
        startForeground(zzaag, this.mNotification);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0084, code lost:
        if (com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zzb(r7.zzaan) != null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0086, code lost:
        r7.zzaao = true;
        r7.mNotification = zzT(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008e, code lost:
        startForeground(zzaag, r7.mNotification);
        r7.zzaaj = zza(r9);
        r7.zzaaj.connect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00a2, code lost:
        if (r7.zzaal == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a4, code lost:
        r7.zzaal.onServiceCreated(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00af, code lost:
        r7.zzaao = false;
        r7.mNotification = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zzb(r7.zzaan);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r7.zzaal = r13;
        r7.zzZC = r8;
        r7.zzaaq = r9;
        r7.zzaas = r11;
        r7.zzaat = r12;
        r7.zzaau = android.support.v7.media.MediaRouter.getInstance(getApplicationContext());
        r2 = new android.support.v7.media.MediaRouteSelector.Builder().addControlCategory(com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r7.zzZC)).build();
        zzbe("addMediaRouterCallback");
        r7.zzaau.addCallback(r2, r7.zzaaw, 4);
        r7.zzaak = new com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass7(r7);
        r7.mNotification = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zzb(r10);
        r7.zzaam = new com.google.android.gms.cast.CastRemoteDisplayLocalService.zzb((com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass1) null);
        registerReceiver(r7.zzaam, new android.content.IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        r7.zzaan = new com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings(r10, (com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass1) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zza(java.lang.String r8, com.google.android.gms.cast.CastDevice r9, com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings r10, android.content.Context r11, android.content.ServiceConnection r12, com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks r13) {
        /*
            r7 = this;
            r6 = 0
            r1 = 1
            r0 = 0
            java.lang.String r2 = "startRemoteDisplaySession"
            r7.zzbe(r2)
            java.lang.String r2 = "Starting the Cast Remote Display must be done on the main thread"
            com.google.android.gms.common.internal.zzx.zzcD(r2)
            java.lang.Object r2 = zzaah
            monitor-enter(r2)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r3 = zzaax     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.cast.internal.zzl r1 = zzaaf     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = "An existing service had not been stopped before starting one"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ac }
            r1.zzf(r3, r4)     // Catch:{ all -> 0x00ac }
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
        L_0x001f:
            return r0
        L_0x0020:
            zzaax = r7     // Catch:{ all -> 0x00ac }
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
            r7.zzaal = r13
            r7.zzZC = r8
            r7.zzaaq = r9
            r7.zzaas = r11
            r7.zzaat = r12
            android.content.Context r2 = r7.getApplicationContext()
            android.support.v7.media.MediaRouter r2 = android.support.v7.media.MediaRouter.getInstance(r2)
            r7.zzaau = r2
            android.support.v7.media.MediaRouteSelector$Builder r2 = new android.support.v7.media.MediaRouteSelector$Builder
            r2.<init>()
            java.lang.String r3 = r7.zzZC
            java.lang.String r3 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast((java.lang.String) r3)
            android.support.v7.media.MediaRouteSelector$Builder r2 = r2.addControlCategory(r3)
            android.support.v7.media.MediaRouteSelector r2 = r2.build()
            java.lang.String r3 = "addMediaRouterCallback"
            r7.zzbe(r3)
            android.support.v7.media.MediaRouter r3 = r7.zzaau
            android.support.v7.media.MediaRouter$Callback r4 = r7.zzaaw
            r5 = 4
            r3.addCallback(r2, r4, r5)
            com.google.android.gms.cast.CastRemoteDisplayLocalService$7 r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$7
            r2.<init>()
            r7.zzaak = r2
            android.app.Notification r2 = r10.mNotification
            r7.mNotification = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb
            r2.<init>()
            r7.zzaam = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb r2 = r7.zzaam
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"
            r3.<init>(r4)
            r7.registerReceiver(r2, r3)
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings
            r2.<init>(r10)
            r7.zzaan = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = r7.zzaan
            android.app.Notification r2 = r2.mNotification
            if (r2 != 0) goto L_0x00af
            r7.zzaao = r1
            android.app.Notification r0 = r7.zzT(r0)
            r7.mNotification = r0
        L_0x008e:
            int r0 = zzaag
            android.app.Notification r2 = r7.mNotification
            r7.startForeground(r0, r2)
            com.google.android.gms.common.api.GoogleApiClient r0 = r7.zza((com.google.android.gms.cast.CastDevice) r9)
            r7.zzaaj = r0
            com.google.android.gms.common.api.GoogleApiClient r0 = r7.zzaaj
            r0.connect()
            com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks r0 = r7.zzaal
            if (r0 == 0) goto L_0x00a9
            com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks r0 = r7.zzaal
            r0.onServiceCreated(r7)
        L_0x00a9:
            r0 = r1
            goto L_0x001f
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ac }
            throw r0
        L_0x00af:
            r7.zzaao = r0
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r0 = r7.zzaan
            android.app.Notification r0 = r0.mNotification
            r7.mNotification = r0
            goto L_0x008e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(java.lang.String, com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings, android.content.Context, android.content.ServiceConnection, com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks):boolean");
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    /* access modifiers changed from: private */
    public void zzbe(String str) {
        zzaaf.zzb("[Instance: %s] %s", this, str);
    }

    /* access modifiers changed from: private */
    public void zzbh(String str) {
        zzaaf.zzc("[Instance: %s] %s", this, str);
    }

    private void zznB() {
        if (this.zzaau != null) {
            zzx.zzcD("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbe("removeMediaRouterCallback");
            this.zzaau.removeCallback(this.zzaaw);
        }
    }

    /* access modifiers changed from: private */
    public void zznC() {
        zzbe("startRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzaaj, this.zzZC).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() {
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
                    r0 = r6.getPresentationDisplay();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
                    if (r0 == null) goto L_0x0086;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(r5.zzaaz, r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zznJ().set(false);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                    if (com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd(r5.zzaaz) == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
                    if (com.google.android.gms.cast.CastRemoteDisplayLocalService.zze(r5.zzaaz) == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd(r5.zzaaz).unbindService(com.google.android.gms.cast.CastRemoteDisplayLocalService.zze(r5.zzaaz));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zznI().zzc("Cast Remote Display session created without display", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zznI().zzb("No need to unbind service, already unbound", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
                    return;
                 */
                /* renamed from: zza */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResult(com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult r6) {
                    /*
                        r5 = this;
                        r4 = 0
                        r3 = 0
                        com.google.android.gms.common.api.Status r0 = r6.getStatus()
                        boolean r0 = r0.isSuccess()
                        if (r0 != 0) goto L_0x001d
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf
                        java.lang.String r1 = "Connection was not successful"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzc(r1, r2)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r0.zznE()
                    L_0x001c:
                        return
                    L_0x001d:
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf
                        java.lang.String r1 = "startRemoteDisplay successful"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzb(r1, r2)
                        java.lang.Object r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaah
                        monitor-enter(r1)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaax     // Catch:{ all -> 0x0046 }
                        if (r0 != 0) goto L_0x0049
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf     // Catch:{ all -> 0x0046 }
                        java.lang.String r2 = "Remote Display started but session already cancelled"
                        r3 = 0
                        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0046 }
                        r0.zzb(r2, r3)     // Catch:{ all -> 0x0046 }
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ all -> 0x0046 }
                        r0.zznE()     // Catch:{ all -> 0x0046 }
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        goto L_0x001c
                    L_0x0046:
                        r0 = move-exception
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        throw r0
                    L_0x0049:
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        android.view.Display r0 = r6.getPresentationDisplay()
                        if (r0 == 0) goto L_0x0086
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r1.zza((android.view.Display) r0)
                    L_0x0055:
                        java.util.concurrent.atomic.AtomicBoolean r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaai
                        r0.set(r3)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.Context r0 = r0.zzaas
                        if (r0 == 0) goto L_0x001c
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.ServiceConnection r0 = r0.zzaat
                        if (r0 == 0) goto L_0x001c
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ IllegalArgumentException -> 0x0092 }
                        android.content.Context r0 = r0.zzaas     // Catch:{ IllegalArgumentException -> 0x0092 }
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ IllegalArgumentException -> 0x0092 }
                        android.content.ServiceConnection r1 = r1.zzaat     // Catch:{ IllegalArgumentException -> 0x0092 }
                        r0.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x0092 }
                    L_0x007b:
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.ServiceConnection unused = r0.zzaat = r4
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.Context unused = r0.zzaas = r4
                        goto L_0x001c
                    L_0x0086:
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf
                        java.lang.String r1 = "Cast Remote Display session created without display"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzc(r1, r2)
                        goto L_0x0055
                    L_0x0092:
                        r0 = move-exception
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzaaf
                        java.lang.String r1 = "No need to unbind service, already unbound"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzb(r1, r2)
                        goto L_0x007b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.AnonymousClass8.onResult(com.google.android.gms.cast.CastRemoteDisplay$CastRemoteDisplaySessionResult):void");
                }
            });
        }
    }

    private void zznD() {
        zzbe("stopRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzaaj).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() {
                /* renamed from: zza */
                public void onResult(CastRemoteDisplay.CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (!castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.this.zzbe("Unable to stop the remote display, result unsuccessful");
                    } else {
                        CastRemoteDisplayLocalService.this.zzbe("remote display stopped");
                    }
                    Display unused = CastRemoteDisplayLocalService.this.zzaar = null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void zznE() {
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzaal = null;
        }
        stopService();
    }

    private void zznF() {
        zzbe("stopRemoteDisplaySession");
        zznD();
        onDismissPresentation();
    }

    private void zznG() {
        zzbe("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zznH() {
        if (this.zzaap == null) {
            this.zzaap = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzaap;
    }

    /* access modifiers changed from: protected */
    public Display getDisplay() {
        return this.zzaar;
    }

    public IBinder onBind(Intent intent) {
        zzbe("onBind");
        return this.zzaay;
    }

    public void onCreate() {
        zzbe("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                CastRemoteDisplayLocalService.this.zzbe("onCreate after delay. The local service been started: " + CastRemoteDisplayLocalService.this.zzaav);
                if (!CastRemoteDisplayLocalService.this.zzaav) {
                    CastRemoteDisplayLocalService.this.zzbh("The local service has not been been started, stopping it");
                    CastRemoteDisplayLocalService.this.stopSelf();
                }
            }
        }, 100);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int i, int i2) {
        zzbe("onStartCommand");
        this.zzaav = true;
        return 2;
    }

    public void updateNotificationSettings(final NotificationSettings notificationSettings) {
        zzx.zzb(notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(this.mHandler, (Object) "Service is not ready yet.");
        this.mHandler.post(new Runnable() {
            public void run() {
                CastRemoteDisplayLocalService.this.zza(notificationSettings);
            }
        });
    }
}
