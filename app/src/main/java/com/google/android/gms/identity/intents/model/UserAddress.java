package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants;

public final class UserAddress implements SafeParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzJU;
    String zzaMD;
    String zzaME;
    String zzaMF;
    String zzaMG;
    String zzaMH;
    String zzaMI;
    String zzaMJ;
    String zzaMK;
    String zzaML;
    boolean zzaMM;
    String zzaMN;
    String zzaMO;

    UserAddress() {
        this.mVersionCode = 1;
    }

    UserAddress(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.mVersionCode = i;
        this.name = str;
        this.zzaMD = str2;
        this.zzaME = str3;
        this.zzaMF = str4;
        this.zzaMG = str5;
        this.zzaMH = str6;
        this.zzaMI = str7;
        this.zzaMJ = str8;
        this.zzJU = str9;
        this.zzaMK = str10;
        this.zzaML = str11;
        this.phoneNumber = str12;
        this.zzaMM = z;
        this.zzaMN = str13;
        this.zzaMO = str14;
    }

    public static UserAddress fromIntent(Intent intent) {
        if (intent == null || !intent.hasExtra(AddressConstants.Extras.EXTRA_ADDRESS)) {
            return null;
        }
        return (UserAddress) intent.getParcelableExtra(AddressConstants.Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzaMG;
    }

    public String getAddress5() {
        return this.zzaMH;
    }

    public String getAdministrativeArea() {
        return this.zzaMI;
    }

    public String getCompanyName() {
        return this.zzaMN;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public String getEmailAddress() {
        return this.zzaMO;
    }

    public String getLocality() {
        return this.zzaMJ;
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

    public String getSortingCode() {
        return this.zzaML;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaMM;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
