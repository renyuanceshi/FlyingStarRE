package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public static final class Settings {
        private final zzae zzoM = new zzae();

        @Deprecated
        public String getTrackingId() {
            return this.zzoM.getTrackingId();
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return this.zzoM.isGoogleAnalyticsEnabled();
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            this.zzoM.zzm(z);
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            this.zzoM.zzJ(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public zzae zzaG() {
            return this.zzoM;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzad.zzdi().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context) {
        zzad.zzdi().initialize(context);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzad.zzdi().zza(context, str, settings == null ? null : settings.zzaG());
    }

    public static void setAppVolume(float f) {
        zzad.zzdi().setAppVolume(f);
    }
}
