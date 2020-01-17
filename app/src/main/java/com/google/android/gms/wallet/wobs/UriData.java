package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzh();
    String description;
    private final int mVersionCode;
    String zzbdg;

    UriData() {
        this.mVersionCode = 1;
    }

    UriData(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzbdg = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
