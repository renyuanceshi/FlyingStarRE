package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zzn extends zzy.zza {
    private static final Object zzqy = new Object();
    private static zzn zzqz;
    private final Context mContext;
    private final Object zzpV = new Object();
    private boolean zzqA;
    private float zzqB = -1.0f;

    zzn(Context context) {
        this.mContext = context;
        this.zzqA = false;
    }

    public static zzn zzbs() {
        zzn zzn;
        synchronized (zzqy) {
            zzn = zzqz;
        }
        return zzn;
    }

    public static zzn zzr(Context context) {
        zzn zzn;
        synchronized (zzqy) {
            if (zzqz == null) {
                zzqz = new zzn(context.getApplicationContext());
            }
            zzn = zzqz;
        }
        return zzn;
    }

    public void setAppVolume(float f) {
        synchronized (this.zzpV) {
            this.zzqB = f;
        }
    }

    public void zza() {
        synchronized (zzqy) {
            if (this.zzqA) {
                zzin.zzaK("Mobile ads is initialized already.");
            } else {
                this.zzqA = true;
            }
        }
    }

    public float zzbt() {
        float f;
        synchronized (this.zzpV) {
            f = this.zzqB;
        }
        return f;
    }

    public boolean zzbu() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzqB >= 0.0f;
        }
        return z;
    }
}
