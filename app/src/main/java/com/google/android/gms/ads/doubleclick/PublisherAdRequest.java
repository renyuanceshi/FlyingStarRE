package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzaa.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzaa zzoE;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzaa.zza zzoF = new zzaa.zza();

        public Builder addCategoryExclusion(String str) {
            this.zzoF.zzG(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzoF.zzb(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zzoF.zza(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzoF.zza(str, zzv.zzcL(",").zza(list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.zzoF.zzA(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzoF.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzoF.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzoF.zzB(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.zzoF.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzx.zzb(str, (Object) "Content URL must be non-null.");
            zzx.zzh(str, "Content URL must be non-empty.");
            zzx.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzoF.zzD(str);
            return this;
        }

        public Builder setGender(int i) {
            this.zzoF.zzn(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.zzoF.zzl(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzoF.zzb(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean z) {
            this.zzoF.setManualImpressionsEnabled(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zzoF.zzE(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zzoF.zzF(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zzoF.zzk(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzoE = new zzaa(builder.zzoF);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.zzoE.getBirthday();
    }

    public String getContentUrl() {
        return this.zzoE.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzoE.getCustomEventExtrasBundle(cls);
    }

    public Bundle getCustomTargeting() {
        return this.zzoE.getCustomTargeting();
    }

    public int getGender() {
        return this.zzoE.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzoE.getKeywords();
    }

    public Location getLocation() {
        return this.zzoE.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzoE.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzoE.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzoE.getNetworkExtrasBundle(cls);
    }

    public String getPublisherProvidedId() {
        return this.zzoE.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.zzoE.isTestDevice(context);
    }

    public zzaa zzaE() {
        return this.zzoE;
    }
}
