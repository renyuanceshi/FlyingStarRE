package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private final zzb zzKA;
    private RewardedVideoAdListener zzaX;
    private final Object zzpV = new Object();
    private String zzrG;

    public zzi(Context context, zzb zzb) {
        this.zzKA = zzb;
        this.mContext = context;
    }

    public void destroy() {
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    this.zzKA.destroy();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzpV) {
            rewardedVideoAdListener = this.zzaX;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        String str;
        synchronized (this.zzpV) {
            str = this.zzrG;
        }
        return str;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    z = this.zzKA.isLoaded();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    this.zzKA.zza(zzh.zzcO().zza(this.mContext, adRequest.zzaE(), str));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void pause() {
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    this.zzKA.pause();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward pause to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void resume() {
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    this.zzKA.resume();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward resume to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.zzpV) {
            this.zzaX = rewardedVideoAdListener;
            if (this.zzKA != null) {
                try {
                    this.zzKA.zza((zzd) new zzg(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserId(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzpV
            monitor-enter(r1)
            java.lang.String r0 = r3.zzrG     // Catch:{ all -> 0x001f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = "A user id has already been set, ignoring."
            com.google.android.gms.ads.internal.util.client.zzb.zzaK(r0)     // Catch:{ all -> 0x001f }
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
        L_0x0011:
            return
        L_0x0012:
            r3.zzrG = r4     // Catch:{ all -> 0x001f }
            com.google.android.gms.ads.internal.reward.client.zzb r0 = r3.zzKA     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.ads.internal.reward.client.zzb r0 = r3.zzKA     // Catch:{ RemoteException -> 0x0022 }
            r0.setUserId(r4)     // Catch:{ RemoteException -> 0x0022 }
        L_0x001d:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            goto L_0x0011
        L_0x001f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r0
        L_0x0022:
            r0 = move-exception
            java.lang.String r2 = "Could not forward setUserId to RewardedVideoAd"
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)     // Catch:{ all -> 0x001f }
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.reward.client.zzi.setUserId(java.lang.String):void");
    }

    public void show() {
        synchronized (this.zzpV) {
            if (this.zzKA != null) {
                try {
                    this.zzKA.show();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward show to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }
}
