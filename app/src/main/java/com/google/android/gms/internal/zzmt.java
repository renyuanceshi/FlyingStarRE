package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzmt implements zzmq {
    private static zzmt zzaoa;

    public static zzmq zzsc() {
        zzmt zzmt;
        synchronized (zzmt.class) {
            try {
                if (zzaoa == null) {
                    zzaoa = new zzmt();
                }
                zzmt = zzaoa;
            } catch (Throwable th) {
                Class<zzmt> cls = zzmt.class;
                throw th;
            }
        }
        return zzmt;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
