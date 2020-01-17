package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
    final int mVersionCode;
    String pin;
    CommonWalletObject zzboB;
    String zzboC;
    String zzboD;
    long zzboE;
    String zzboF;
    long zzboG;
    String zzboH;

    GiftCardWalletObject() {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = 1;
    }

    GiftCardWalletObject(int i, CommonWalletObject commonWalletObject, String str, String str2, String str3, long j, String str4, long j2, String str5) {
        this.zzboB = CommonWalletObject.zzIr().zzIs();
        this.mVersionCode = i;
        this.zzboB = commonWalletObject;
        this.zzboC = str;
        this.pin = str2;
        this.zzboE = j;
        this.zzboF = str4;
        this.zzboG = j2;
        this.zzboH = str5;
        this.zzboD = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzboB.getId();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
