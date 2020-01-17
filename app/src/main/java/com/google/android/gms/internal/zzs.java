package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzs {
    public static boolean DEBUG = Log.isLoggable(TAG, 2);
    public static String TAG = "Volley";

    static class zza {
        public static final boolean zzak = zzs.DEBUG;
        private final List<C0152zza> zzal = new ArrayList();
        private boolean zzam = false;

        /* renamed from: com.google.android.gms.internal.zzs$zza$zza  reason: collision with other inner class name */
        private static class C0152zza {
            public final String name;
            public final long time;
            public final long zzan;

            public C0152zza(String str, long j, long j2) {
                this.name = str;
                this.zzan = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long zzx() {
            if (this.zzal.size() == 0) {
                return 0;
            }
            return this.zzal.get(this.zzal.size() - 1).time - this.zzal.get(0).time;
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.zzam) {
                zzd("Request on the loose");
                zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public void zza(String str, long j) {
            synchronized (this) {
                if (this.zzam) {
                    throw new IllegalStateException("Marker added to finished log");
                }
                this.zzal.add(new C0152zza(str, j, SystemClock.elapsedRealtime()));
            }
        }

        public void zzd(String str) {
            synchronized (this) {
                this.zzam = true;
                long zzx = zzx();
                if (zzx > 0) {
                    long j = this.zzal.get(0).time;
                    zzs.zzb("(%-4d ms) %s", Long.valueOf(zzx), str);
                    long j2 = j;
                    for (C0152zza next : this.zzal) {
                        long j3 = next.time;
                        zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.zzan), next.name);
                        j2 = j3;
                    }
                }
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
