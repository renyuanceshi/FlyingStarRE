package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzao;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc, zzq {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzakz;
    /* access modifiers changed from: private */
    public CountDownLatch zzapL;
    zza zzapM;
    boolean zzapN;

    final class zza extends Handler {
        zza() {
        }

        /* access modifiers changed from: private */
        public Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        /* access modifiers changed from: private */
        public Message zzsW() {
            return obtainMessage(2);
        }

        public void handleMessage(Message message) {
            zzz.zzy("DriveEventService", "handleMessage message type:" + message.what);
            switch (message.what) {
                case 1:
                    DriveEventService.this.zza((OnEventResponse) message.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzz.zzz("DriveEventService", "Unexpected message type:" + message.what);
                    return;
            }
        }
    }

    final class zzb extends zzao.zza {
        zzb() {
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (DriveEventService.this) {
                zzz.zzy("DriveEventService", "onEvent: " + onEventResponse);
                DriveEventService.this.zzsV();
                if (DriveEventService.this.zzapM != null) {
                    DriveEventService.this.zzapM.sendMessage(DriveEventService.this.zzapM.zzb(onEventResponse));
                } else {
                    zzz.zzA("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String str) {
        this.zzapN = false;
        this.zzakz = -1;
        this.mName = str;
    }

    /* access modifiers changed from: private */
    public void zza(OnEventResponse onEventResponse) {
        DriveEvent zzts = onEventResponse.zzts();
        zzz.zzy("DriveEventService", "handleEventMessage: " + zzts);
        try {
            switch (zzts.getType()) {
                case 1:
                    onChange((ChangeEvent) zzts);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzts);
                    return;
                case 4:
                    zza((ChangesAvailableEvent) zzts);
                    return;
                case 7:
                    zza((TransferStateEvent) zzts);
                    return;
                default:
                    zzz.zzz(this.mName, "Unhandled event: " + zzts);
                    return;
            }
        } catch (Exception e) {
            zzz.zza(this.mName, e, "Error handling event: " + zzts);
        }
        zzz.zza(this.mName, e, "Error handling event: " + zzts);
    }

    /* access modifiers changed from: private */
    public void zzsV() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzakz) {
            if (GooglePlayServicesUtil.zzf(this, callingUid)) {
                this.zzakz = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    /* access modifiers changed from: protected */
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final IBinder onBind(Intent intent) {
        IBinder iBinder;
        synchronized (this) {
            if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
                if (this.zzapM == null && !this.zzapN) {
                    this.zzapN = true;
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.zzapL = new CountDownLatch(1);
                    new Thread() {
                        public void run() {
                            try {
                                Looper.prepare();
                                DriveEventService.this.zzapM = new zza();
                                DriveEventService.this.zzapN = false;
                                countDownLatch.countDown();
                                zzz.zzy("DriveEventService", "Bound and starting loop");
                                Looper.loop();
                                zzz.zzy("DriveEventService", "Finished loop");
                            } finally {
                                if (DriveEventService.this.zzapL != null) {
                                    DriveEventService.this.zzapL.countDown();
                                }
                            }
                        }
                    }.start();
                    try {
                        if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                            zzz.zzA("DriveEventService", "Failed to synchronously initialize event handler.");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Unable to start event handler", e);
                    }
                }
                iBinder = new zzb().asBinder();
            } else {
                iBinder = null;
            }
        }
        return iBinder;
    }

    public void onChange(ChangeEvent changeEvent) {
        zzz.zzz(this.mName, "Unhandled change event: " + changeEvent);
    }

    public void onCompletion(CompletionEvent completionEvent) {
        zzz.zzz(this.mName, "Unhandled completion event: " + completionEvent);
    }

    public void onDestroy() {
        synchronized (this) {
            zzz.zzy("DriveEventService", "onDestroy");
            if (this.zzapM != null) {
                this.zzapM.sendMessage(this.zzapM.zzsW());
                this.zzapM = null;
                try {
                    if (!this.zzapL.await(5000, TimeUnit.MILLISECONDS)) {
                        zzz.zzz("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                    }
                } catch (InterruptedException e) {
                }
                this.zzapL = null;
            }
            super.onDestroy();
        }
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzz.zzz(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }

    public void zza(TransferStateEvent transferStateEvent) {
        zzz.zzz(this.mName, "Unhandled transfer state event: " + transferStateEvent);
    }
}
