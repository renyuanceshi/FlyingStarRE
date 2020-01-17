package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SaveRequest implements SafeParcelable {
    public static final Parcelable.Creator<SaveRequest> CREATOR = new zzk();
    final int mVersionCode;
    private final Credential zzWu;

    SaveRequest(int i, Credential credential) {
        this.mVersionCode = i;
        this.zzWu = credential;
    }

    public SaveRequest(Credential credential) {
        this(1, credential);
    }

    public int describeContents() {
        return 0;
    }

    public Credential getCredential() {
        return this.zzWu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
