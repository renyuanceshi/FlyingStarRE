package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new zzj();
    String description;
    private final int mVersionCode;
    String zzboL;
    String zzboM;
    int zzboN;
    String zzboh;
    String zzboi;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String str) {
            LineItem.this.zzboi = str;
            return this;
        }

        public Builder setDescription(String str) {
            LineItem.this.description = str;
            return this;
        }

        public Builder setQuantity(String str) {
            LineItem.this.zzboL = str;
            return this;
        }

        public Builder setRole(int i) {
            LineItem.this.zzboN = i;
            return this;
        }

        public Builder setTotalPrice(String str) {
            LineItem.this.zzboh = str;
            return this;
        }

        public Builder setUnitPrice(String str) {
            LineItem.this.zzboM = str;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzboN = 0;
    }

    LineItem(int i, String str, String str2, String str3, String str4, int i2, String str5) {
        this.mVersionCode = i;
        this.description = str;
        this.zzboL = str2;
        this.zzboM = str3;
        this.zzboh = str4;
        this.zzboN = i2;
        this.zzboi = str5;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzboL;
    }

    public int getRole() {
        return this.zzboN;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public String getUnitPrice() {
        return this.zzboM;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
