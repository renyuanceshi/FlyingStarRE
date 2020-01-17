package com.google.android.gms.fitness.service;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.internal.service.zzc;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzaBP;

    private static class zza extends zzc.zza {
        private final FitnessSensorService zzaBQ;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzaBQ = fitnessSensorService;
        }

        public void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzoi zzoi) throws RemoteException {
            this.zzaBQ.zzvr();
            zzoi.zza(new DataSourcesResult(this.zzaBQ.onFindDataSources(fitnessDataSourcesRequest.getDataTypes()), Status.zzagC));
        }

        public void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzow zzow) throws RemoteException {
            this.zzaBQ.zzvr();
            if (this.zzaBQ.onUnregister(fitnessUnregistrationRequest.getDataSource())) {
                zzow.zzp(Status.zzagC);
            } else {
                zzow.zzp(new Status(13));
            }
        }

        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzow zzow) throws RemoteException {
            this.zzaBQ.zzvr();
            if (this.zzaBQ.onRegister(fitnessSensorServiceRequest)) {
                zzow.zzp(Status.zzagC);
            } else {
                zzow.zzp(new Status(13));
            }
        }
    }

    @CallSuper
    public IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.zzaBP.asBinder();
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.zzaBP = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    /* access modifiers changed from: protected */
    @TargetApi(19)
    public void zzvr() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (zzne.zzsk()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals("com.google.android.gms")) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
