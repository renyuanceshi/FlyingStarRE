package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zzi;
import com.google.android.gms.cast.internal.zzj;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    /* access modifiers changed from: private */
    public static final zzl zzaaf = new zzl("CastClientImpl");
    /* access modifiers changed from: private */
    public static final Object zzadP = new Object();
    /* access modifiers changed from: private */
    public static final Object zzadQ = new Object();
    /* access modifiers changed from: private */
    public final Cast.Listener zzZP;
    private double zzabs;
    private boolean zzabt;
    private final long zzadA;
    private zzb zzadB;
    private String zzadC;
    private boolean zzadD;
    private boolean zzadE;
    private boolean zzadF;
    private int zzadG;
    private int zzadH;
    private final AtomicLong zzadI = new AtomicLong(0);
    /* access modifiers changed from: private */
    public String zzadJ;
    /* access modifiers changed from: private */
    public String zzadK;
    private Bundle zzadL;
    /* access modifiers changed from: private */
    public final Map<Long, zza.zzb<Status>> zzadM = new HashMap();
    /* access modifiers changed from: private */
    public zza.zzb<Cast.ApplicationConnectionResult> zzadN;
    /* access modifiers changed from: private */
    public zza.zzb<Status> zzadO;
    /* access modifiers changed from: private */
    public ApplicationMetadata zzadx;
    /* access modifiers changed from: private */
    public final CastDevice zzady;
    /* access modifiers changed from: private */
    public final Map<String, Cast.MessageReceivedCallback> zzadz = new HashMap();

    private static final class zza implements Cast.ApplicationConnectionResult {
        private final String zzLq;
        private final Status zzUX;
        private final ApplicationMetadata zzadR;
        private final String zzadS;
        private final boolean zzadT;

        public zza(Status status) {
            this(status, (ApplicationMetadata) null, (String) null, (String) null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzUX = status;
            this.zzadR = applicationMetadata;
            this.zzadS = str;
            this.zzLq = str2;
            this.zzadT = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzadR;
        }

        public String getApplicationStatus() {
            return this.zzadS;
        }

        public String getSessionId() {
            return this.zzLq;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public boolean getWasLaunched() {
            return this.zzadT;
        }
    }

    private static class zzb extends zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzadU;

        public zzb(zze zze) {
            this.zzadU = new AtomicReference<>(zze);
            this.mHandler = new Handler(zze.getLooper());
        }

        private void zza(zze zze, long j, int i) {
            zza.zzb zzb;
            synchronized (zze.zzadM) {
                zzb = (zza.zzb) zze.zzadM.remove(Long.valueOf(j));
            }
            if (zzb != null) {
                zzb.zzs(new Status(i));
            }
        }

        private boolean zza(zze zze, int i) {
            synchronized (zze.zzadQ) {
                if (zze.zzadO == null) {
                    return false;
                }
                zze.zzadO.zzs(new Status(i));
                zza.zzb unused = zze.zzadO = null;
                return true;
            }
        }

        public boolean isDisposed() {
            return this.zzadU.get() == null;
        }

        public void onApplicationDisconnected(final int i) {
            final zze zze = this.zzadU.get();
            if (zze != null) {
                String unused = zze.zzadJ = null;
                String unused2 = zze.zzadK = null;
                zza(zze, i);
                if (zze.zzZP != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            zze.zzZP.onApplicationDisconnected(i);
                        }
                    });
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                ApplicationMetadata unused = zze.zzadx = applicationMetadata;
                String unused2 = zze.zzadJ = applicationMetadata.getApplicationId();
                String unused3 = zze.zzadK = str2;
                synchronized (zze.zzadP) {
                    if (zze.zzadN != null) {
                        zze.zzadN.zzs(new zza(new Status(0), applicationMetadata, str, str2, z));
                        zza.zzb unused4 = zze.zzadN = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzaaf.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                zza(zze, j, i);
            }
        }

        public void zzb(final ApplicationStatus applicationStatus) {
            final zze zze = this.zzadU.get();
            if (zze != null) {
                zze.zzaaf.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        zze.zza(applicationStatus);
                    }
                });
            }
        }

        public void zzb(final DeviceStatus deviceStatus) {
            final zze zze = this.zzadU.get();
            if (zze != null) {
                zze.zzaaf.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        zze.zza(deviceStatus);
                    }
                });
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (this.zzadU.get() != null) {
                zze.zzaaf.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzbk(int i) {
            zze zzos = zzos();
            if (zzos != null) {
                zze.zzaaf.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzos.zzbS(2);
                }
            }
        }

        public void zzbl(int i) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                synchronized (zze.zzadP) {
                    if (zze.zzadN != null) {
                        zze.zzadN.zzs(new zza(new Status(i)));
                        zza.zzb unused = zze.zzadN = null;
                    }
                }
            }
        }

        public void zzbm(int i) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                zza(zze, i);
            }
        }

        public void zzbn(int i) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                zza(zze, i);
            }
        }

        public void zzc(String str, long j) {
            zze zze = this.zzadU.get();
            if (zze != null) {
                zza(zze, j, 0);
            }
        }

        public zze zzos() {
            zze andSet = this.zzadU.getAndSet((Object) null);
            if (andSet == null) {
                return null;
            }
            andSet.zzoh();
            return andSet;
        }

        public void zzt(final String str, final String str2) {
            final zze zze = this.zzadU.get();
            if (zze != null) {
                zze.zzaaf.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        Cast.MessageReceivedCallback messageReceivedCallback;
                        synchronized (zze.zzadz) {
                            messageReceivedCallback = (Cast.MessageReceivedCallback) zze.zzadz.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(zze.zzady, str, str2);
                            return;
                        }
                        zze.zzaaf.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }
    }

    public zze(Context context, Looper looper, zzf zzf, CastDevice castDevice, long j, Cast.Listener listener, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzady = castDevice;
        this.zzZP = listener;
        this.zzadA = j;
        zzoh();
    }

    /* access modifiers changed from: private */
    public void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zzoe = applicationStatus.zzoe();
        if (!zzf.zza(zzoe, this.zzadC)) {
            this.zzadC = zzoe;
            z = true;
        } else {
            z = false;
        }
        zzaaf.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadD));
        if (this.zzZP != null && (z || this.zzadD)) {
            this.zzZP.onApplicationStatusChanged();
        }
        this.zzadD = false;
    }

    /* access modifiers changed from: private */
    public void zza(DeviceStatus deviceStatus) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzadx)) {
            this.zzadx = applicationMetadata;
            this.zzZP.onApplicationMetadataChanged(this.zzadx);
        }
        double zzok = deviceStatus.zzok();
        if (zzok == Double.NaN || Math.abs(zzok - this.zzabs) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzabs = zzok;
            z = true;
        }
        boolean zzot = deviceStatus.zzot();
        if (zzot != this.zzabt) {
            this.zzabt = zzot;
            z = true;
        }
        zzaaf.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z || this.zzadE)) {
            this.zzZP.onVolumeChanged();
        }
        int zzol = deviceStatus.zzol();
        if (zzol != this.zzadG) {
            this.zzadG = zzol;
            z2 = true;
        } else {
            z2 = false;
        }
        zzaaf.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z2 || this.zzadE)) {
            this.zzZP.onActiveInputStateChanged(this.zzadG);
        }
        int zzom = deviceStatus.zzom();
        if (zzom != this.zzadH) {
            this.zzadH = zzom;
            z3 = true;
        } else {
            z3 = false;
        }
        zzaaf.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z3 || this.zzadE)) {
            this.zzZP.onStandbyStateChanged(this.zzadH);
        }
        this.zzadE = false;
    }

    private void zza(zza.zzb<Cast.ApplicationConnectionResult> zzb2) {
        synchronized (zzadP) {
            if (this.zzadN != null) {
                this.zzadN.zzs(new zza(new Status(2002)));
            }
            this.zzadN = zzb2;
        }
    }

    private void zzc(zza.zzb<Status> zzb2) {
        synchronized (zzadQ) {
            if (this.zzadO != null) {
                zzb2.zzs(new Status(2001));
            } else {
                this.zzadO = zzb2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzoh() {
        this.zzadF = false;
        this.zzadG = -1;
        this.zzadH = -1;
        this.zzadx = null;
        this.zzadC = null;
        this.zzabs = 0.0d;
        this.zzabt = false;
    }

    private void zzon() {
        zzaaf.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzadz) {
            this.zzadz.clear();
        }
    }

    private void zzoo() throws IllegalStateException {
        if (!this.zzadF || this.zzadB == null || this.zzadB.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    public void disconnect() {
        zzaaf.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzadB, Boolean.valueOf(isConnected()));
        zzb zzb2 = this.zzadB;
        this.zzadB = null;
        if (zzb2 == null || zzb2.zzos() == null) {
            zzaaf.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzon();
        try {
            ((zzi) zzqJ()).disconnect();
        } catch (RemoteException | IllegalStateException e) {
            zzaaf.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        } finally {
            super.disconnect();
        }
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzoo();
        return this.zzadx;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzoo();
        return this.zzadC;
    }

    public boolean isMute() throws IllegalStateException {
        zzoo();
        return this.zzabt;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        zzon();
    }

    public void zzX(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zzqJ()).zza(z, this.zzabs, this.zzabt);
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzaaf.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzadF = true;
            this.zzadD = true;
            this.zzadE = true;
        } else {
            this.zzadF = false;
        }
        if (i == 1001) {
            this.zzadL = new Bundle();
            this.zzadL.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzch(str);
        zzcg(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzadz) {
                this.zzadz.put(str, messageReceivedCallback);
            }
            ((zzi) zzqJ()).zzcl(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, zza.zzb<Cast.ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        zza(zzb2);
        ((zzi) zzqJ()).zza(str, launchOptions);
    }

    public void zza(String str, zza.zzb<Status> zzb2) throws IllegalStateException, RemoteException {
        zzc(zzb2);
        ((zzi) zzqJ()).zzck(str);
    }

    public void zza(String str, String str2, JoinOptions joinOptions, zza.zzb<Cast.ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        zza(zzb2);
        if (joinOptions == null) {
            joinOptions = new JoinOptions();
        }
        ((zzi) zzqJ()).zza(str, str2, joinOptions);
    }

    public void zza(String str, String str2, zza.zzb<Status> zzb2) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzch(str);
            zzoo();
            long incrementAndGet = this.zzadI.incrementAndGet();
            try {
                this.zzadM.put(Long.valueOf(incrementAndGet), zzb2);
                ((zzi) zzqJ()).zzb(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzadM.remove(Long.valueOf(incrementAndGet));
                throw th;
            }
        }
    }

    public void zza(String str, boolean z, zza.zzb<Cast.ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        LaunchOptions launchOptions = new LaunchOptions();
        launchOptions.setRelaunchIfRunning(z);
        zza(str, launchOptions, zzb2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaE */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzaF(iBinder);
    }

    public void zzb(zza.zzb<Status> zzb2) throws IllegalStateException, RemoteException {
        zzc(zzb2);
        ((zzi) zzqJ()).zzou();
    }

    public void zzcg(String str) throws IllegalArgumentException, RemoteException {
        Cast.MessageReceivedCallback remove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzadz) {
            remove = this.zzadz.remove(str);
        }
        if (remove != null) {
            try {
                ((zzi) zzqJ()).zzcm(str);
            } catch (IllegalStateException e) {
                zzaaf.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzf(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zzqJ()).zza(d, this.zzabs, this.zzabt);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        Bundle bundle = new Bundle();
        zzaaf.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzadJ, this.zzadK);
        this.zzady.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzadA);
        this.zzadB = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzadB.asBinder()));
        if (this.zzadJ != null) {
            bundle.putString("last_application_id", this.zzadJ);
            if (this.zzadK != null) {
                bundle.putString("last_session_id", this.zzadK);
            }
        }
        return bundle;
    }

    public Bundle zzoi() {
        if (this.zzadL == null) {
            return super.zzoi();
        }
        Bundle bundle = this.zzadL;
        this.zzadL = null;
        return bundle;
    }

    public void zzoj() throws IllegalStateException, RemoteException {
        ((zzi) zzqJ()).zzoj();
    }

    public double zzok() throws IllegalStateException {
        zzoo();
        return this.zzabs;
    }

    public int zzol() throws IllegalStateException {
        zzoo();
        return this.zzadG;
    }

    public int zzom() throws IllegalStateException {
        zzoo();
        return this.zzadH;
    }
}
