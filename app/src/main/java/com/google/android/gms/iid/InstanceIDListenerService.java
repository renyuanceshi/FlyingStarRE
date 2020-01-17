package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String zzaLH = "gcm.googleapis.com/refresh";
    private static String zzaMY = "google.com/iid";
    private static String zzaMZ = "CMD";
    MessengerCompat zzaMW = new MessengerCompat((Handler) new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            InstanceIDListenerService.this.zza(message, MessengerCompat.zzc(message));
        }
    });
    BroadcastReceiver zzaMX = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            InstanceIDListenerService.this.zzp(intent);
            InstanceIDListenerService.this.stop();
        }
    };
    int zzaNa;
    int zzaNb;

    static void zza(Context context, zzd zzd) {
        zzd.zzyG();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzaMZ, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* access modifiers changed from: private */
    public void zza(Message message, int i) {
        zzc.zzaN(this);
        getPackageManager();
        if (i == zzc.zzaNi || i == zzc.zzaNh) {
            zzp((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaNh + " appid=" + zzc.zzaNi);
        }
    }

    static void zzaM(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaMZ, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.zzaMW.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzaMX, intentFilter, "com.google.android.c2dm.permission.RECEIVE", (Handler) null);
    }

    public void onDestroy() {
        unregisterReceiver(this.zzaMX);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2;
        zzhl(i2);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (Build.VERSION.SDK_INT > 18 || (intent2 = (Intent) intent.getParcelableExtra("GSF")) == null) {
                    zzp(intent);
                } else {
                    startService(intent2);
                    return 1;
                }
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        synchronized (this) {
            this.zzaNa--;
            if (this.zzaNa == 0) {
                stopSelf(this.zzaNb);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzaNa + " " + this.zzaNb);
            }
        }
    }

    public void zzal(boolean z) {
        onTokenRefresh();
    }

    /* access modifiers changed from: package-private */
    public void zzhl(int i) {
        synchronized (this) {
            this.zzaNa++;
            if (i > this.zzaNb) {
                this.zzaNb = i;
            }
        }
    }

    public void zzp(Intent intent) {
        InstanceID zza;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            zza = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            zza = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzaMZ);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzyB = zza.zzyB();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                zzyB.zzef(stringExtra);
                zza.zzyC().zzw(intent);
            } else if (zzaLH.equals(intent.getStringExtra("from"))) {
                zza.zzyB().zzef(stringExtra);
                zzal(false);
            } else if ("RST".equals(stringExtra2)) {
                zza.zzyA();
                zzal(true);
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!zza.zzyB().isEmpty()) {
                    zza.zzyB().zzyG();
                    zzal(true);
                }
            } else if ("SYNC".equals(stringExtra2)) {
                zza.zzyB().zzef(stringExtra);
                zzal(false);
            } else if ("PING".equals(stringExtra2)) {
                try {
                    GoogleCloudMessaging.getInstance(this).send(zzaMY, zzc.zzyF(), 0, intent.getExtras());
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                }
            }
        } else {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Register result in service " + stringExtra);
            }
            zza.zzyC().zzw(intent);
        }
    }
}
