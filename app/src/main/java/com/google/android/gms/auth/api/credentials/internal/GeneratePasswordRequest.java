package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GeneratePasswordRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeneratePasswordRequest> CREATOR = new zzh();
    final int mVersionCode;
    private final PasswordSpecification zzVM;

    GeneratePasswordRequest(int i, PasswordSpecification passwordSpecification) {
        this.mVersionCode = i;
        this.zzVM = passwordSpecification;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public PasswordSpecification zzmr() {
        return this.zzVM;
    }
}
