package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzif;

@zzhb
public abstract class zzgq extends zzim {
    protected final Context mContext;
    protected final zzgr.zza zzGc;
    protected final zzif.zza zzGd;
    protected AdResponseParcel zzGe;
    protected final Object zzGg = new Object();
    protected final Object zzpV = new Object();

    protected static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            super(str);
            this.zzGu = i;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    protected zzgq(Context context, zzif.zza zza2, zzgr.zza zza3) {
        super(true);
        this.mContext = context;
        this.zzGd = zza2;
        this.zzGe = zza2.zzLe;
        this.zzGc = zza3;
    }

    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public abstract zzif zzD(int i);

    public void zzbr() {
        synchronized (this.zzpV) {
            zzin.zzaI("AdRendererBackgroundTask started.");
            int i = this.zzGd.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzin.zzaJ(e.getMessage());
                } else {
                    zzin.zzaK(e.getMessage());
                }
                if (this.zzGe == null) {
                    this.zzGe = new AdResponseParcel(errorCode);
                } else {
                    this.zzGe = new AdResponseParcel(errorCode, this.zzGe.zzBU);
                }
                zzir.zzMc.post(new Runnable() {
                    public void run() {
                        zzgq.this.onStop();
                    }
                });
                i = errorCode;
            }
            final zzif zzD = zzD(i);
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    synchronized (zzgq.this.zzpV) {
                        zzgq.this.zzm(zzD);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzh(long j) throws zza;

    /* access modifiers changed from: protected */
    public void zzm(zzif zzif) {
        this.zzGc.zzb(zzif);
    }
}
