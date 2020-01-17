package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@zzhb
public class zzbf extends Thread {
    private boolean mStarted = false;
    private boolean zzam = false;
    private final Object zzpV;
    private final int zzsK;
    private final int zzsM;
    private boolean zzsY = false;
    private final zzbe zzsZ;
    private final zzbd zzta;
    private final zzha zztb;
    private final int zztc;
    private final int zztd;
    private final int zzte;

    @zzhb
    class zza {
        final int zztm;
        final int zztn;

        zza(int i, int i2) {
            this.zztm = i;
            this.zztn = i2;
        }
    }

    public zzbf(zzbe zzbe, zzbd zzbd, zzha zzha) {
        this.zzsZ = zzbe;
        this.zzta = zzbd;
        this.zztb = zzha;
        this.zzpV = new Object();
        this.zzsK = zzbt.zzwk.get().intValue();
        this.zztd = zzbt.zzwl.get().intValue();
        this.zzsM = zzbt.zzwm.get().intValue();
        this.zzte = zzbt.zzwn.get().intValue();
        this.zztc = zzbt.zzwo.get().intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (!this.zzam) {
            try {
                if (zzcH()) {
                    Activity activity = this.zzsZ.getActivity();
                    if (activity == null) {
                        zzin.zzaI("ContentFetchThread: no activity");
                    } else {
                        zza(activity);
                    }
                } else {
                    zzin.zzaI("ContentFetchTask: sleeping");
                    zzcJ();
                }
                Thread.sleep((long) (this.zztc * 1000));
            } catch (Throwable th) {
                zzin.zzb("Error in ContentFetchTask", th);
                this.zztb.zza(th, true);
            }
            synchronized (this.zzpV) {
                while (this.zzsY) {
                    try {
                        zzin.zzaI("ContentFetchTask: waiting");
                        this.zzpV.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpV) {
            this.zzsY = false;
            this.zzpV.notifyAll();
            zzin.zzaI("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    public zza zza(View view, zzbc zzbc) {
        if (view == null) {
            return new zza(0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzbc.zzd(text.toString(), globalVisibleRect);
            return new zza(1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzjp)) {
            zzbc.zzcC();
            return zza((WebView) view, zzbc, globalVisibleRect) ? new zza(0, 1) : new zza(0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i3 < viewGroup.getChildCount()) {
                zza zza2 = zza(viewGroup.getChildAt(i3), zzbc);
                i3++;
                i = zza2.zztm + i;
                i2 += zza2.zztn;
            }
            return new zza(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                zze(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzbc zzbc, WebView webView, String str, boolean z) {
        zzbc.zzcB();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!TextUtils.isEmpty(webView.getTitle())) {
                    zzbc.zzc(webView.getTitle() + "\n" + optString, z);
                } else {
                    zzbc.zzc(optString, z);
                }
            }
            if (zzbc.zzcx()) {
                this.zzta.zzb(zzbc);
            }
        } catch (JSONException e) {
            zzin.zzaI("Json string may be malformed.");
        } catch (Throwable th) {
            zzin.zza("Failed to get webview content.", th);
            this.zztb.zza(th, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(19)
    public boolean zza(final WebView webView, final zzbc zzbc, final boolean z) {
        if (!zzne.zzsk()) {
            return false;
        }
        zzbc.zzcC();
        webView.post(new Runnable() {
            ValueCallback<String> zzth = new ValueCallback<String>() {
                /* renamed from: zzt */
                public void onReceiveValue(String str) {
                    zzbf.this.zza(zzbc, webView, str, z);
                }
            };

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzth);
                    } catch (Throwable th) {
                        this.zzth.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcG() {
        synchronized (this.zzpV) {
            if (this.mStarted) {
                zzin.zzaI("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzcH() {
        try {
            Context context = this.zzsZ.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (zza(next) && !keyguardManager.inKeyguardRestrictedInputMode() && zzs(context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbc zzcI() {
        return this.zzta.zzcF();
    }

    public void zzcJ() {
        synchronized (this.zzpV) {
            this.zzsY = true;
            zzin.zzaI("ContentFetchThread: paused, mPause = " + this.zzsY);
        }
    }

    public boolean zzcK() {
        return this.zzsY;
    }

    /* access modifiers changed from: package-private */
    public boolean zze(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() {
            public void run() {
                zzbf.this.zzf(view);
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public void zzf(View view) {
        try {
            zzbc zzbc = new zzbc(this.zzsK, this.zztd, this.zzsM, this.zzte);
            zza zza2 = zza(view, zzbc);
            zzbc.zzcD();
            if (zza2.zztm != 0 || zza2.zztn != 0) {
                if (zza2.zztn != 0 || zzbc.zzcE() != 0) {
                    if (zza2.zztn != 0 || !this.zzta.zza(zzbc)) {
                        this.zzta.zzc(zzbc);
                    }
                }
            }
        } catch (Exception e) {
            zzin.zzb("Exception in fetchContentOnUIThread", e);
            this.zztb.zza(e, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
