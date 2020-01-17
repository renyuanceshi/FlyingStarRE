package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs implements Logger {
    private boolean zzPk;
    private int zzRB = 2;

    zzs() {
    }

    public void error(Exception exc) {
    }

    public void error(String str) {
    }

    public int getLogLevel() {
        return this.zzRB;
    }

    public void info(String str) {
    }

    public void setLogLevel(int i) {
        this.zzRB = i;
        if (!this.zzPk) {
            Log.i(zzy.zzRL.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.zzRL.get() + " DEBUG");
            this.zzPk = true;
        }
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
