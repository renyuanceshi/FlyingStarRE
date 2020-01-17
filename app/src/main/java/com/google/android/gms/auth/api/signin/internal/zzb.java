package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzu;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzu {
    private Semaphore zzXp = new Semaphore(0);
    private Set<GoogleApiClient> zzXq;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzXq = set;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        this.zzXp.drainPermits();
        forceLoad();
    }

    /* renamed from: zzmZ */
    public Void loadInBackground() {
        Iterator<GoogleApiClient> it = this.zzXq.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().zza((zzu) this) ? i2 + 1 : i2;
            } else {
                try {
                    this.zzXp.tryAcquire(i2, 5, TimeUnit.SECONDS);
                    return null;
                } catch (InterruptedException e) {
                    Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
        }
    }

    public void zzna() {
        this.zzXp.release();
    }
}
