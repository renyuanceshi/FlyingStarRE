package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

@TargetApi(14)
@zzhb
public class zzbe implements Application.ActivityLifecycleCallbacks {
    private Activity mActivity;
    private Context mContext;
    private final Object zzpV = new Object();

    public zzbe(Application application, Activity activity) {
        application.registerActivityLifecycleCallbacks(this);
        setActivity(activity);
        this.mContext = application.getApplicationContext();
    }

    private void setActivity(Activity activity) {
        synchronized (this.zzpV) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.mActivity = activity;
            }
        }
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r3) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzpV
            monitor-enter(r1)
            android.app.Activity r0 = r2.mActivity     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
        L_0x0008:
            return
        L_0x0009:
            android.app.Activity r0 = r2.mActivity     // Catch:{ all -> 0x0016 }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            r2.mActivity = r0     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0008
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbe.onActivityDestroyed(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        setActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setActivity(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
