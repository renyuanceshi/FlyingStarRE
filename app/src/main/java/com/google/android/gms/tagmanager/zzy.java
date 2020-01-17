package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy implements zzbh {
    private int zzRB = 5;

    public void e(String str) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int i) {
        this.zzRB = i;
    }

    public void v(String str) {
        if (this.zzRB <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void zzaI(String str) {
        if (this.zzRB <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzaJ(String str) {
        if (this.zzRB <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzaK(String str) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
