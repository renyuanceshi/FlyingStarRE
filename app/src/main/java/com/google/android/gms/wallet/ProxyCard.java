package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new zzr();
    private final int mVersionCode;
    String zzbpF;
    String zzbpG;
    int zzbpH;
    int zzbpI;

    ProxyCard(int i, String str, String str2, int i2, int i3) {
        this.mVersionCode = i;
        this.zzbpF = str;
        this.zzbpG = str2;
        this.zzbpH = i2;
        this.zzbpI = i3;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzbpG;
    }

    public int getExpirationMonth() {
        return this.zzbpH;
    }

    public int getExpirationYear() {
        return this.zzbpI;
    }

    public String getPan() {
        return this.zzbpF;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
