package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzaaf = new zzl("RequestTracker");
    public static final Object zzaeB = new Object();
    private long zzacY = -1;
    private zzo zzaeA;
    private long zzaey;
    private long zzaez = 0;

    public zzp(long j) {
        this.zzaey = j;
    }

    private void zzoz() {
        this.zzacY = -1;
        this.zzaeA = null;
        this.zzaez = 0;
    }

    public void clear() {
        synchronized (zzaeB) {
            if (this.zzacY != -1) {
                zzoz();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1 && this.zzacY == j;
        }
        return z;
    }

    public void zza(long j, zzo zzo) {
        zzo zzo2;
        long j2;
        synchronized (zzaeB) {
            zzo2 = this.zzaeA;
            j2 = this.zzacY;
            this.zzacY = j;
            this.zzaeA = zzo;
            this.zzaez = SystemClock.elapsedRealtime();
        }
        if (zzo2 != null) {
            zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, (Object) null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo zzo = null;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || this.zzacY != j) {
                z = false;
            } else {
                zzaaf.zzb("request %d completed", Long.valueOf(this.zzacY));
                zzo = this.zzaeA;
                zzoz();
            }
        }
        if (zzo != null) {
            zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzaeB) {
            if (this.zzacY == -1 || j - this.zzaez < this.zzaey) {
                zzo = null;
                z = false;
            } else {
                zzaaf.zzb("request %d timed out", Long.valueOf(this.zzacY));
                j2 = this.zzacY;
                zzo = this.zzaeA;
                zzoz();
            }
        }
        if (zzo != null) {
            zzo.zza(j2, i, (Object) null);
        }
        return z;
    }

    public boolean zzoA() {
        boolean z;
        synchronized (zzaeB) {
            z = this.zzacY != -1;
        }
        return z;
    }
}
