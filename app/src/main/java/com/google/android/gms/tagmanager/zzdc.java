package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdc {
    private Context mContext;
    private Tracker zzPb;
    private GoogleAnalytics zzPd;

    static class zza implements Logger {
        zza() {
        }

        private static int zzkn(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exc) {
            zzbg.zzb("", exc);
        }

        public void error(String str) {
            zzbg.e(str);
        }

        public int getLogLevel() {
            return zzkn(zzbg.getLogLevel());
        }

        public void info(String str) {
            zzbg.zzaJ(str);
        }

        public void setLogLevel(int i) {
            zzbg.zzaK("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzbg.v(str);
        }

        public void warn(String str) {
            zzbg.zzaK(str);
        }
    }

    public zzdc(Context context) {
        this.mContext = context;
    }

    private void zzgr(String str) {
        synchronized (this) {
            if (this.zzPd == null) {
                this.zzPd = GoogleAnalytics.getInstance(this.mContext);
                this.zzPd.setLogger(new zza());
                this.zzPb = this.zzPd.newTracker(str);
            }
        }
    }

    public Tracker zzgq(String str) {
        zzgr(str);
        return this.zzPb;
    }
}
