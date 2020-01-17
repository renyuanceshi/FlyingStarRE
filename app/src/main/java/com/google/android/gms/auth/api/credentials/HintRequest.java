package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class HintRequest implements SafeParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
    final int mVersionCode;
    private final String[] zzWe;
    private final CredentialPickerConfig zzWh;
    private final boolean zzWi;
    private final boolean zzWj;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String[] zzWe;
        /* access modifiers changed from: private */
        public CredentialPickerConfig zzWh = new CredentialPickerConfig.Builder().build();
        /* access modifiers changed from: private */
        public boolean zzWi;
        /* access modifiers changed from: private */
        public boolean zzWj;

        public HintRequest build() {
            if (this.zzWe == null) {
                this.zzWe = new String[0];
            }
            if (this.zzWi || this.zzWj || this.zzWe.length != 0) {
                return new HintRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzWe = strArr;
            return this;
        }

        public Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzWi = z;
            return this;
        }

        public Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzWh = (CredentialPickerConfig) zzx.zzz(credentialPickerConfig);
            return this;
        }
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr) {
        this.mVersionCode = i;
        this.zzWh = (CredentialPickerConfig) zzx.zzz(credentialPickerConfig);
        this.zzWi = z;
        this.zzWj = z2;
        this.zzWe = (String[]) zzx.zzz(strArr);
    }

    private HintRequest(Builder builder) {
        this(1, builder.zzWh, builder.zzWi, builder.zzWj, builder.zzWe);
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String[] getAccountTypes() {
        return this.zzWe;
    }

    @NonNull
    public CredentialPickerConfig getHintPickerConfig() {
        return this.zzWh;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zzWi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public boolean zzmy() {
        return this.zzWj;
    }
}
