package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzk;
import java.util.List;

class zzb implements SensorEventDispatcher {
    private final zzk zzaBh;

    zzb(zzk zzk) {
        this.zzaBh = (zzk) zzx.zzz(zzk);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzui();
        this.zzaBh.zzc(dataPoint);
    }

    public void publish(List<DataPoint> list) throws RemoteException {
        for (DataPoint publish : list) {
            publish(publish);
        }
    }
}
