package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
    private final int mVersionCode;
    String zzboF;
    int zzbqJ;
    String zzbqK;
    double zzbqL;
    long zzbqM;
    int zzbqN;

    LoyaltyPointsBalance() {
        this.mVersionCode = 1;
        this.zzbqN = -1;
        this.zzbqJ = -1;
        this.zzbqL = -1.0d;
    }

    LoyaltyPointsBalance(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.mVersionCode = i;
        this.zzbqJ = i2;
        this.zzbqK = str;
        this.zzbqL = d;
        this.zzboF = str2;
        this.zzbqM = j;
        this.zzbqN = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
