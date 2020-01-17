package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new zza();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzJU;
    String zzaMD;
    String zzaME;
    String zzaMF;
    String zzaMK;
    boolean zzaMM;
    String zzaMN;
    String zzbof;
    String zzbog;

    Address() {
        this.mVersionCode = 1;
    }

    Address(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.mVersionCode = i;
        this.name = str;
        this.zzaMD = str2;
        this.zzaME = str3;
        this.zzaMF = str4;
        this.zzJU = str5;
        this.zzbof = str6;
        this.zzbog = str7;
        this.zzaMK = str8;
        this.phoneNumber = str9;
        this.zzaMM = z;
        this.zzaMN = str10;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzaMD;
    }

    public String getAddress2() {
        return this.zzaME;
    }

    public String getAddress3() {
        return this.zzaMF;
    }

    public String getCity() {
        return this.zzbof;
    }

    public String getCompanyName() {
        return this.zzaMN;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.zzaMK;
    }

    public String getState() {
        return this.zzbog;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaMM;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
