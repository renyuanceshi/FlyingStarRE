package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zze();
    final int mVersionCode;
    private final String zzVY;
    private final String zzWk;

    IdToken(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzVY = str;
        this.zzWk = str2;
    }

    public IdToken(String str, String str2) {
        this(1, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.zzVY;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
