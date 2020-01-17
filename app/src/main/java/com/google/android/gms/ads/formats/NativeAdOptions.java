package com.google.android.gms.ads.formats;

public final class NativeAdOptions {
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzoN;
    private final int zzoO;
    private final boolean zzoP;

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzoN = false;
        /* access modifiers changed from: private */
        public int zzoO = 0;
        /* access modifiers changed from: private */
        public boolean zzoP = false;

        public NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public Builder setImageOrientation(int i) {
            this.zzoO = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.zzoP = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzoN = z;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzoN = builder.zzoN;
        this.zzoO = builder.zzoO;
        this.zzoP = builder.zzoP;
    }

    public int getImageOrientation() {
        return this.zzoO;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzoP;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zzoN;
    }
}
