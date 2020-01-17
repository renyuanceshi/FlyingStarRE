package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzha implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    private VersionInfoParcel zzEZ;
    private Thread.UncaughtExceptionHandler zzHe;
    private Thread.UncaughtExceptionHandler zzHf;

    public zzha(Context context, VersionInfoParcel versionInfoParcel, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.zzHe = uncaughtExceptionHandler;
        this.zzHf = uncaughtExceptionHandler2;
        this.mContext = context;
        this.zzEZ = versionInfoParcel;
    }

    private static boolean zzA(Context context) {
        return zzbt.zzvG.get().booleanValue();
    }

    public static zzha zza(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!zzA(context)) {
            return null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        zzha zzha = new zzha(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzha)) {
            return (zzha) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(zzha);
            return zzha;
        } catch (SecurityException e) {
            zzin.zzc("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private Throwable zzb(Throwable th) {
        Throwable th2;
        if (!zzbt.zzvH.get().booleanValue()) {
            LinkedList linkedList = new LinkedList();
            while (th != null) {
                linkedList.push(th);
                th = th.getCause();
            }
            th = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzat(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z = true;
                    } else if (zzau(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }
                if (z) {
                    th2 = th == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                } else {
                    th2 = th;
                }
                th = th2;
            }
        }
        return th;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (zza(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                zza(th, true);
                return;
            }
            zza(th, false);
        }
        if (this.zzHe != null) {
            this.zzHe.uncaughtException(thread, th);
        } else if (this.zzHf != null) {
            this.zzHf.uncaughtException(thread, th);
        }
    }

    /* access modifiers changed from: package-private */
    public String zza(Class cls, Throwable th, boolean z) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", zzr.zzbC().zzht()).appendQueryParameter("js", this.zzEZ.afmaVersion).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzbt.zzdr())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    public void zza(Throwable th, boolean z) {
        Throwable zzb;
        if (zzA(this.mContext) && (zzb = zzb(th)) != null) {
            Class<?> cls = th.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza((Class) cls, zzb, z));
            zzr.zzbC().zza(this.mContext, this.zzEZ.afmaVersion, (List<String>) arrayList, zzr.zzbF().zzhe());
        }
    }

    /* access modifiers changed from: protected */
    public boolean zza(Throwable th) {
        if (th == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzat(stackTraceElement.getClassName())) {
                    z = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        return z && !z2;
    }

    /* access modifiers changed from: protected */
    public boolean zzat(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzhb.class);
        } catch (Exception e) {
            zzin.zza("Fail to check class type for class " + str, e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzau(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }
}
