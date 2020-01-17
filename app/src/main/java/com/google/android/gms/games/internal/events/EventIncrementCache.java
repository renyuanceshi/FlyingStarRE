package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzaId = new Object();
    private Handler zzaIe;
    private boolean zzaIf;
    private HashMap<String, AtomicInteger> zzaIg;
    private int zzaIh;

    public EventIncrementCache(Looper looper, int i) {
        this.zzaIe = new Handler(looper);
        this.zzaIg = new HashMap<>();
        this.zzaIh = i;
    }

    /* access modifiers changed from: private */
    public void zzxl() {
        synchronized (this.zzaId) {
            this.zzaIf = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzaId) {
            for (Map.Entry next : this.zzaIg.entrySet()) {
                zzs((String) next.getKey(), ((AtomicInteger) next.getValue()).get());
            }
            this.zzaIg.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzaId) {
            if (!this.zzaIf) {
                this.zzaIf = true;
                this.zzaIe.postDelayed(new Runnable() {
                    public void run() {
                        EventIncrementCache.this.zzxl();
                    }
                }, (long) this.zzaIh);
            }
            AtomicInteger atomicInteger = this.zzaIg.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzaIg.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
