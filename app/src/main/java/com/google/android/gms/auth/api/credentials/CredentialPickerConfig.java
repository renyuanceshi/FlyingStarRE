package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzWb;
    private final boolean zzWc;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mShowCancelButton = true;
        /* access modifiers changed from: private */
        public boolean zzWb = false;
        /* access modifiers changed from: private */
        public boolean zzWc = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setForNewAccount(boolean z) {
            this.zzWc = z;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzWb = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzWb = z;
        this.mShowCancelButton = z2;
        this.zzWc = z3;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzWb, builder.mShowCancelButton, builder.zzWc);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isForNewAccount() {
        return this.zzWc;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzWb;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
