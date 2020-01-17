package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzif;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzhb
public class zzhz extends zzim implements zzhy {
    private final Context mContext;
    private final zzif.zza zzGd;
    private final ArrayList<Future> zzKL = new ArrayList<>();
    private final ArrayList<String> zzKM = new ArrayList<>();
    private final HashSet<String> zzKN = new HashSet<>();
    /* access modifiers changed from: private */
    public final zzht zzKO;
    private final Object zzpV = new Object();
    private final String zzrG;

    public zzhz(Context context, String str, zzif.zza zza, zzht zzht) {
        this.mContext = context;
        this.zzrG = str;
        this.zzGd = zza;
        this.zzKO = zzht;
    }

    private zzif zza(int i, @Nullable String str, @Nullable zzen zzen) {
        return new zzif(this.zzGd.zzLd.zzHt, (zzjp) null, this.zzGd.zzLe.zzBQ, i, this.zzGd.zzLe.zzBR, this.zzGd.zzLe.zzHV, this.zzGd.zzLe.orientation, this.zzGd.zzLe.zzBU, this.zzGd.zzLd.zzHw, this.zzGd.zzLe.zzHT, zzen, (zzey) null, str, this.zzGd.zzKV, (zzeq) null, this.zzGd.zzLe.zzHU, this.zzGd.zzrp, this.zzGd.zzLe.zzHS, this.zzGd.zzKY, this.zzGd.zzLe.zzHX, this.zzGd.zzLe.zzHY, this.zzGd.zzKT, (zzh.zza) null, this.zzGd.zzLe.zzIj, this.zzGd.zzLe.zzIk, this.zzGd.zzLe.zzIl, this.zzGd.zzLe.zzIm);
    }

    private zzif zza(String str, zzen zzen) {
        return zza(-2, str, zzen);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzd(java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r10 = this;
            java.lang.Object r9 = r10.zzpV
            monitor-enter(r9)
            com.google.android.gms.internal.zzht r0 = r10.zzKO     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.zzia r7 = r0.zzaw(r11)     // Catch:{ all -> 0x0038 }
            if (r7 == 0) goto L_0x0017
            com.google.android.gms.internal.zzhx r0 = r7.zzgQ()     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.zzey r0 = r7.zzgP()     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0019
        L_0x0017:
            monitor-exit(r9)     // Catch:{ all -> 0x0038 }
        L_0x0018:
            return
        L_0x0019:
            com.google.android.gms.internal.zzhu r0 = new com.google.android.gms.internal.zzhu     // Catch:{ all -> 0x0038 }
            android.content.Context r1 = r10.mContext     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r10.zzrG     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.zzif$zza r6 = r10.zzGd     // Catch:{ all -> 0x0038 }
            r2 = r11
            r4 = r12
            r5 = r13
            r8 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0038 }
            java.util.ArrayList<java.util.concurrent.Future> r1 = r10.zzKL     // Catch:{ all -> 0x0038 }
            java.util.concurrent.Future r0 = r0.zzgd()     // Catch:{ all -> 0x0038 }
            r1.add(r0)     // Catch:{ all -> 0x0038 }
            java.util.ArrayList<java.lang.String> r0 = r10.zzKM     // Catch:{ all -> 0x0038 }
            r0.add(r11)     // Catch:{ all -> 0x0038 }
            monitor-exit(r9)     // Catch:{ all -> 0x0038 }
            goto L_0x0018
        L_0x0038:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0038 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhz.zzd(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private zzif zzgO() {
        return zza(3, (String) null, (zzen) null);
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
    }

    public void zzax(String str) {
        synchronized (this.zzpV) {
            this.zzKN.add(str);
        }
    }

    public void zzbr() {
        for (zzen next : this.zzGd.zzKV.zzBO) {
            String str = next.zzBG;
            for (String zzd : next.zzBB) {
                zzd(zzd, str, next.zzBz);
            }
        }
        int i = 0;
        while (i < this.zzKL.size()) {
            try {
                this.zzKL.get(i).get();
                synchronized (this.zzpV) {
                    if (this.zzKN.contains(this.zzKM.get(i))) {
                        final zzif zza = zza(this.zzKM.get(i), this.zzGd.zzKV.zzBO.get(i));
                        zza.zzMS.post(new Runnable() {
                            public void run() {
                                zzhz.this.zzKO.zzb(zza);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        final zzif zzgO = zzgO();
        zza.zzMS.post(new Runnable() {
            public void run() {
                zzhz.this.zzKO.zzb(zzgO);
            }
        });
        return;
        i++;
    }
}
