package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class LocalContent implements SafeParcelable {
    public static final Parcelable.Creator<LocalContent> CREATOR = new zzb();
    private int type;
    private final int versionCode;
    private String zzbdf;

    private LocalContent() {
        this.versionCode = 1;
    }

    LocalContent(int i, int i2, String str) {
        this.versionCode = i;
        this.type = i2;
        this.zzbdf = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof LocalContent)) {
                return false;
            }
            LocalContent localContent = (LocalContent) obj;
            if (!zzw.equal(Integer.valueOf(this.type), Integer.valueOf(localContent.type)) || !zzw.equal(this.zzbdf, localContent.zzbdf)) {
                return false;
            }
        }
        return true;
    }

    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.type), this.zzbdf);
    }

    public String toString() {
        return "LocalContent[contentUri=" + this.zzbdf + ", type=" + (this.type == 1 ? "PUBLIC_CONTENT" : "APP_CONTENT") + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzEK() {
        return this.zzbdf;
    }
}
