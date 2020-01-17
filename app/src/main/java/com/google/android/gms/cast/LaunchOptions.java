package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzd();
    private final int mVersionCode;
    private boolean zzaaK;
    private String zzaaL;

    public static final class Builder {
        private LaunchOptions zzaaM = new LaunchOptions();

        public LaunchOptions build() {
            return this.zzaaM;
        }

        public Builder setLocale(Locale locale) {
            this.zzaaM.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean z) {
            this.zzaaM.setRelaunchIfRunning(z);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean z, String str) {
        this.mVersionCode = i;
        this.zzaaK = z;
        this.zzaaL = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof LaunchOptions)) {
                return false;
            }
            LaunchOptions launchOptions = (LaunchOptions) obj;
            if (this.zzaaK != launchOptions.zzaaK || !zzf.zza(this.zzaaL, launchOptions.zzaaL)) {
                return false;
            }
        }
        return true;
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzaaK;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaaK), this.zzaaL);
    }

    public void setLanguage(String str) {
        this.zzaaL = str;
    }

    public void setRelaunchIfRunning(boolean z) {
        this.zzaaK = z;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzaaK), this.zzaaL});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
