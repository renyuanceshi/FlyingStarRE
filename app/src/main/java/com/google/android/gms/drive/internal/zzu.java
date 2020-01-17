package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzu extends zzj<zzam> {
    private final String zzUW;
    final GoogleApiClient.ConnectionCallbacks zzalF;
    private final Bundle zzaqK;
    private final boolean zzaqL;
    private volatile DriveId zzaqM;
    private volatile DriveId zzaqN;
    private volatile boolean zzaqO = false;
    final Map<DriveId, Map<ChangeListener, zzae>> zzaqP = new HashMap();
    final Map<zzc, zzae> zzaqQ = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzaqR = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzaqS = new HashMap();

    public zzu(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzUW = zzf.zzqv();
        this.zzalF = connectionCallbacks;
        this.zzaqK = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaqL = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.zzaqL = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzx.zzac(zzg.zza(i, driveId));
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new RemoveEventListenerRequest(driveId, i), (zzao) null, (String) null, (zzan) new zzbu(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final AddEventListenerRequest addEventListenerRequest) {
        zzx.zzac(zzg.zza(addEventListenerRequest.getEventType(), addEventListenerRequest.getDriveId()));
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzaqL) {
            return googleApiClient.zzb(new zzt.zza(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzu zzu) throws RemoteException {
                    zzu.zzte().zza(addEventListenerRequest, (zzao) null, (String) null, (zzan) new zzbu(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final AddEventListenerRequest addEventListenerRequest, final zzae zzae) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(addEventListenerRequest, (zzao) zzae, (String) null, (zzan) new zzbu(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final RemoveEventListenerRequest removeEventListenerRequest, final zzae zzae) {
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(removeEventListenerRequest, (zzao) zzae, (String) null, (zzan) new zzbu(this));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, final List<String> list) {
        boolean z = true;
        zzx.zzac(list != null);
        if (list.isEmpty()) {
            z = false;
        }
        zzx.zzac(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zzt.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzu zzu) throws RemoteException {
                zzu.zzte().zza(new CancelPendingActionsRequest(list), (zzan) new zzbu(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzam) zzqJ()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaqP) {
            this.zzaqP.clear();
        }
        synchronized (this.zzaqQ) {
            this.zzaqQ.clear();
        }
        synchronized (this.zzaqR) {
            this.zzaqR.clear();
        }
        synchronized (this.zzaqS) {
            this.zzaqS.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, new AddEventListenerRequest(1, driveId));
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        HashMap hashMap;
        PendingResult<Status> zzj;
        zzx.zzac(zzg.zza(1, driveId));
        zzx.zzb(changeListener, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzaqP) {
            Map map = this.zzaqP.get(driveId);
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.zzaqP.put(driveId, hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            zzae zzae = (zzae) hashMap.get(changeListener);
            if (zzae == null) {
                zzae = new zzae(getLooper(), getContext(), 1, changeListener);
                hashMap.put(changeListener, zzae);
            } else if (zzae.zzdh(1)) {
                zzj = new zzs.zzj(googleApiClient, Status.zzagC);
            }
            zzae.zzdg(1);
            zzj = zza(googleApiClient, new AddEventListenerRequest(1, driveId), zzae);
        }
        return zzj;
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaqM = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaqN = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzaqO = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaZ */
    public zzam zzW(IBinder iBinder) {
        return zzam.zza.zzba(iBinder);
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> zza;
        zzx.zzac(zzg.zza(1, driveId));
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb(changeListener, (Object) "listener");
        synchronized (this.zzaqP) {
            Map map = this.zzaqP.get(driveId);
            if (map == null) {
                zza = new zzs.zzj(googleApiClient, Status.zzagC);
            } else {
                zzae zzae = (zzae) map.remove(changeListener);
                if (zzae == null) {
                    zza = new zzs.zzj(googleApiClient, Status.zzagC);
                } else {
                    if (map.isEmpty()) {
                        this.zzaqP.remove(driveId);
                    }
                    zza = zza(googleApiClient, new RemoveEventListenerRequest(driveId, 1), zzae);
                }
            }
        }
        return zza;
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public boolean zzmE() {
        return !getContext().getPackageName().equals(this.zzUW) || !zztd();
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        String packageName = getContext().getPackageName();
        zzx.zzz(packageName);
        zzx.zzab(!zzqH().zzqt().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzUW)) {
            bundle.putString("proxy_package_name", this.zzUW);
        }
        bundle.putAll(this.zzaqK);
        return bundle;
    }

    public boolean zzqK() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zztd() {
        return GooglePlayServicesUtil.zzf(getContext(), Process.myUid());
    }

    public zzam zzte() throws DeadObjectException {
        return (zzam) zzqJ();
    }

    public DriveId zztf() {
        return this.zzaqM;
    }

    public DriveId zztg() {
        return this.zzaqN;
    }

    public boolean zzth() {
        return this.zzaqO;
    }

    public boolean zzti() {
        return this.zzaqL;
    }
}
