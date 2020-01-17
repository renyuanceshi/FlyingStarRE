package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;

@zzhb
public class zzhs extends zzb.zza {
    private final Context mContext;
    private final zzht zzKu;
    private final VersionInfoParcel zzpT;
    private final Object zzpV = new Object();

    public zzhs(Context context, zzd zzd, zzex zzex, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpT = versionInfoParcel;
        this.zzKu = new zzht(context, zzd, AdSizeParcel.zzcP(), zzex, versionInfoParcel);
    }

    public void destroy() {
        synchronized (this.zzpV) {
            this.zzKu.destroy();
        }
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzpV) {
            isLoaded = this.zzKu.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        synchronized (this.zzpV) {
            this.zzKu.pause();
        }
    }

    public void resume() {
        synchronized (this.zzpV) {
            this.zzKu.resume();
        }
    }

    public void setUserId(String str) {
        synchronized (this.zzpV) {
            this.zzKu.setUserId(str);
        }
    }

    public void show() {
        synchronized (this.zzpV) {
            this.zzKu.zzgL();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzpV) {
            this.zzKu.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        synchronized (this.zzpV) {
            this.zzKu.zza(zzd);
        }
    }
}
