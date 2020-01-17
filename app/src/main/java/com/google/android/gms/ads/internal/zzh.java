package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzam;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzhb
class zzh implements zzaj, Runnable {
    private final List<Object[]> zzpH = new Vector();
    private final AtomicReference<zzaj> zzpI = new AtomicReference<>();
    CountDownLatch zzpJ = new CountDownLatch(1);
    private zzs zzpj;

    public zzh(zzs zzs) {
        this.zzpj = zzs;
        if (zzn.zzcS().zzhJ()) {
            zziq.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzbk() {
        if (!this.zzpH.isEmpty()) {
            for (Object[] next : this.zzpH) {
                if (next.length == 1) {
                    this.zzpI.get().zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    this.zzpI.get().zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzpH.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r2.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Context zzq(android.content.Context r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.zzbp<java.lang.Boolean> r0 = com.google.android.gms.internal.zzbt.zzvM
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x000f
        L_0x000e:
            return r2
        L_0x000f:
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x000e
            r2 = r0
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzh.zzq(android.content.Context):android.content.Context");
    }

    public void run() {
        try {
            zza(zzb(this.zzpj.zzrl.afmaVersion, zzq(this.zzpj.context), !zzbt.zzvY.get().booleanValue() || this.zzpj.zzrl.zzNb));
        } finally {
            this.zzpJ.countDown();
            this.zzpj = null;
        }
    }

    public void zza(int i, int i2, int i3) {
        zzaj zzaj = this.zzpI.get();
        if (zzaj != null) {
            zzbk();
            zzaj.zza(i, i2, i3);
            return;
        }
        this.zzpH.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzaj zzaj = this.zzpI.get();
        if (zzaj != null) {
            zzbk();
            zzaj.zza(motionEvent);
            return;
        }
        this.zzpH.add(new Object[]{motionEvent});
    }

    /* access modifiers changed from: protected */
    public void zza(zzaj zzaj) {
        this.zzpI.set(zzaj);
    }

    /* access modifiers changed from: protected */
    public zzaj zzb(String str, Context context, boolean z) {
        return zzam.zza(str, context, z);
    }

    public String zzb(Context context) {
        zzaj zzaj;
        if (!zzbj() || (zzaj = this.zzpI.get()) == null) {
            return "";
        }
        zzbk();
        return zzaj.zzb(zzq(context));
    }

    public String zzb(Context context, String str) {
        zzaj zzaj;
        if (!zzbj() || (zzaj = this.zzpI.get()) == null) {
            return "";
        }
        zzbk();
        return zzaj.zzb(zzq(context), str);
    }

    /* access modifiers changed from: protected */
    public boolean zzbj() {
        try {
            this.zzpJ.await();
            return true;
        } catch (InterruptedException e) {
            zzin.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
