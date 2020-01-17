package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzad {
    private static final Object zzqy = new Object();
    private static zzad zzuV;
    private zzy zzuW;
    private RewardedVideoAd zzuX;

    private zzad() {
    }

    public static zzad zzdi() {
        zzad zzad;
        synchronized (zzqy) {
            if (zzuV == null) {
                zzuV = new zzad();
            }
            zzad = zzuV;
        }
        return zzad;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzqy) {
            if (this.zzuX != null) {
                rewardedVideoAd = this.zzuX;
            } else {
                this.zzuX = new zzi(context, zzn.zzcX().zza(context, new zzew()));
                rewardedVideoAd = this.zzuX;
            }
        }
        return rewardedVideoAd;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.Object r1 = zzqy
            monitor-enter(r1)
            com.google.android.gms.ads.internal.client.zzy r0 = r3.zzuW     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
        L_0x0008:
            return
        L_0x0009:
            if (r4 != 0) goto L_0x0016
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "Context cannot be null."
            r0.<init>(r2)     // Catch:{ all -> 0x0013 }
            throw r0     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r0
        L_0x0016:
            com.google.android.gms.ads.internal.client.zzaf r0 = com.google.android.gms.ads.internal.client.zzn.zzcV()     // Catch:{ RemoteException -> 0x0027 }
            com.google.android.gms.ads.internal.client.zzy r0 = r0.zzu(r4)     // Catch:{ RemoteException -> 0x0027 }
            r3.zzuW = r0     // Catch:{ RemoteException -> 0x0027 }
            com.google.android.gms.ads.internal.client.zzy r0 = r3.zzuW     // Catch:{ RemoteException -> 0x0027 }
            r0.zza()     // Catch:{ RemoteException -> 0x0027 }
        L_0x0025:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0008
        L_0x0027:
            r0 = move-exception
            java.lang.String r0 = "Fail to initialize mobile ads setting manager"
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzad.initialize(android.content.Context):void");
    }

    public void setAppVolume(float f) {
        boolean z = true;
        zzx.zzb(0.0f <= f && f <= 1.0f, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzuW == null) {
            z = false;
        }
        zzx.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzuW.setAppVolume(f);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app volume.", e);
        }
    }

    public void zza(Context context, String str, zzae zzae) {
        initialize(context);
    }
}
