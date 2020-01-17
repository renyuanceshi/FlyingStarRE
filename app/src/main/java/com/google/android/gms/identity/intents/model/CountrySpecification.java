package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new zza();
    private final int mVersionCode;
    String zzJU;

    CountrySpecification(int i, String str) {
        this.mVersionCode = i;
        this.zzJU = str;
    }

    public CountrySpecification(String str) {
        this.mVersionCode = 1;
        this.zzJU = str;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzJU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
