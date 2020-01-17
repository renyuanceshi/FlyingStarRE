package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class VideoConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new VideoConfigurationCreator();
    private final int mVersionCode;
    private final int zzaLr;
    private final int zzaLs;
    private final String zzaLt;
    private final String zzaLu;

    public static final class Builder {
    }

    public VideoConfiguration(int i, int i2, int i3, String str, String str2) {
        boolean z = true;
        this.mVersionCode = i;
        zzx.zzac(zzgZ(i2));
        zzx.zzac(zzha(i3));
        this.zzaLr = i2;
        this.zzaLs = i3;
        if (i3 == 1) {
            this.zzaLu = str2;
            this.zzaLt = str;
            return;
        }
        zzx.zzb(str2 == null, (Object) "Stream key should be null when not streaming");
        zzx.zzb(str != null ? false : z, (Object) "Stream url should be null when not streaming");
        this.zzaLu = null;
        this.zzaLt = null;
    }

    public static boolean zzgZ(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzha(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getStreamUrl() {
        return this.zzaLt;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        VideoConfigurationCreator.zza(this, parcel, i);
    }

    public int zzyd() {
        return this.zzaLr;
    }

    public int zzye() {
        return this.zzaLs;
    }

    public String zzyf() {
        return this.zzaLu;
    }
}
