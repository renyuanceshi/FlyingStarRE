package com.google.android.gms.internal;

import android.os.StrictMode;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Callable;

@zzhb
public class zzjb {
    public static <T> T zzb(Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return callable.call();
        } catch (Throwable th) {
            zzin.zzb("Unexpected exception.", th);
            zzr.zzbF().zzb(th, true);
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
