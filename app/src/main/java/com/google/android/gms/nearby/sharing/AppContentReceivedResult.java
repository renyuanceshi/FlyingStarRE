package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class AppContentReceivedResult implements SafeParcelable {
    public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();
    private int statusCode;
    private final int versionCode;
    private Uri zzbde;

    private AppContentReceivedResult() {
        this.versionCode = 1;
    }

    AppContentReceivedResult(int i, Uri uri, int i2) {
        this.versionCode = i;
        this.zzbde = uri;
        this.statusCode = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof AppContentReceivedResult)) {
                return false;
            }
            AppContentReceivedResult appContentReceivedResult = (AppContentReceivedResult) obj;
            if (!zzw.equal(this.zzbde, appContentReceivedResult.zzbde) || !zzw.equal(Integer.valueOf(this.statusCode), Integer.valueOf(appContentReceivedResult.statusCode))) {
                return false;
            }
        }
        return true;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbde, Integer.valueOf(this.statusCode));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzEJ() {
        return this.zzbde;
    }
}
