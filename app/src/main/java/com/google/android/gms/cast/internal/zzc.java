package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected final long zzadq;
    protected final Runnable zzadr;
    protected boolean zzads;

    private class zza implements Runnable {
        private zza() {
        }

        public void run() {
            zzc.this.zzads = false;
            zzc.this.zzW(zzc.this.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzadr = new zza();
        this.zzadq = j;
        zzW(false);
    }

    /* access modifiers changed from: protected */
    public final void zzW(boolean z) {
        if (this.zzads != z) {
            this.zzads = z;
            if (z) {
                this.mHandler.postDelayed(this.zzadr, this.zzadq);
            } else {
                this.mHandler.removeCallbacks(this.zzadr);
            }
        }
    }

    public void zzof() {
        zzW(false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzz(long j);
}
