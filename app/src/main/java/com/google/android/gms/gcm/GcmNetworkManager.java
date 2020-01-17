package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.List;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zzaLB;
    private Context mContext;
    private final PendingIntent mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(), 0);

    private GcmNetworkManager(Context context) {
        this.mContext = context;
    }

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        synchronized (GcmNetworkManager.class) {
            try {
                if (zzaLB == null) {
                    zzaLB = new GcmNetworkManager(context.getApplicationContext());
                }
                gcmNetworkManager = zzaLB;
            } catch (Throwable th) {
                Class<GcmNetworkManager> cls = GcmNetworkManager.class;
                throw th;
            }
        }
        return gcmNetworkManager;
    }

    static void zzdT(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void zzdU(String str) {
        boolean z = true;
        zzx.zzb(str, (Object) "GcmTaskService must not be null.");
        Intent intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK);
        intent.setPackage(this.mContext.getPackageName());
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        zzx.zzb((queryIntentServices == null || queryIntentServices.size() == 0) ? false : true, (Object) "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().serviceInfo.name.equals(str)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        zzx.zzb(z, (Object) "The GcmTaskService class you provided " + str + " does not seem to support receiving" + " com.google.android.gms.gcm.ACTION_TASK_READY.");
    }

    private Intent zzyi() {
        int zzaK = GoogleCloudMessaging.zzaK(this.mContext);
        if (zzaK < GoogleCloudMessaging.zzaLM) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + zzaK);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(GoogleCloudMessaging.zzaJ(this.mContext));
        intent.putExtra("app", this.mPendingIntent);
        return intent;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> cls) {
        zzc(cls);
    }

    public void cancelTask(String str, Class<? extends GcmTaskService> cls) {
        zza(str, cls);
    }

    public void schedule(Task task) {
        zzdU(task.getServiceName());
        Intent zzyi = zzyi();
        if (zzyi != null) {
            Bundle extras = zzyi.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.toBundle(extras);
            zzyi.putExtras(extras);
            this.mContext.sendBroadcast(zzyi);
        }
    }

    public void zza(String str, Class<? extends Service> cls) {
        zzdT(str);
        zzdU(cls.getName());
        Intent zzyi = zzyi();
        if (zzyi != null) {
            zzyi.putExtra("scheduler_action", "CANCEL_TASK");
            zzyi.putExtra("tag", str);
            zzyi.putExtra("component", new ComponentName(this.mContext, cls));
            this.mContext.sendBroadcast(zzyi);
        }
    }

    public void zzc(Class<? extends Service> cls) {
        zzdU(cls.getName());
        Intent zzyi = zzyi();
        if (zzyi != null) {
            zzyi.putExtra("scheduler_action", "CANCEL_ALL");
            zzyi.putExtra("component", new ComponentName(this.mContext, cls));
            this.mContext.sendBroadcast(zzyi);
        }
    }
}
