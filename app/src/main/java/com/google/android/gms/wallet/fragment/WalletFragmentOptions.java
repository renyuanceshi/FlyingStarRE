package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();
    /* access modifiers changed from: private */
    public int mTheme;
    final int mVersionCode;
    /* access modifiers changed from: private */
    public int zzaoy;
    /* access modifiers changed from: private */
    public int zzbpM;
    /* access modifiers changed from: private */
    public WalletFragmentStyle zzbqs;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int i) {
            int unused = WalletFragmentOptions.this.zzbpM = i;
            return this;
        }

        public Builder setFragmentStyle(int i) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.zzbqs = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.zzbqs = walletFragmentStyle;
            return this;
        }

        public Builder setMode(int i) {
            int unused = WalletFragmentOptions.this.zzaoy = i;
            return this;
        }

        public Builder setTheme(int i) {
            int unused = WalletFragmentOptions.this.mTheme = i;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
        this.zzbpM = 3;
        this.zzbqs = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.mVersionCode = i;
        this.zzbpM = i2;
        this.mTheme = i3;
        this.zzbqs = walletFragmentStyle;
        this.zzaoy = i4;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zzb(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbpM = i2;
        walletFragmentOptions.zzbqs = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzbqs.zzbc(context);
        walletFragmentOptions.zzaoy = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzbpM;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzbqs;
    }

    public int getMode() {
        return this.zzaoy;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public void zzbc(Context context) {
        if (this.zzbqs != null) {
            this.zzbqs.zzbc(context);
        }
    }
}
