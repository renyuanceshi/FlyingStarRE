package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TextModuleData implements SafeParcelable {
    public static final Parcelable.Creator<TextModuleData> CREATOR = new zzf();
    String body;
    private final int mVersionCode;
    String zzbqO;

    TextModuleData() {
        this.mVersionCode = 1;
    }

    TextModuleData(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzbqO = str;
        this.body = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
