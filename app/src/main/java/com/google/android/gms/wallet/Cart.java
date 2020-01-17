package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new zzb();
    private final int mVersionCode;
    String zzboh;
    String zzboi;
    ArrayList<LineItem> zzboj;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.zzboj.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String str) {
            Cart.this.zzboi = str;
            return this;
        }

        public Builder setLineItems(List<LineItem> list) {
            Cart.this.zzboj.clear();
            Cart.this.zzboj.addAll(list);
            return this;
        }

        public Builder setTotalPrice(String str) {
            Cart.this.zzboh = str;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzboj = new ArrayList<>();
    }

    Cart(int i, String str, String str2, ArrayList<LineItem> arrayList) {
        this.mVersionCode = i;
        this.zzboh = str;
        this.zzboi = str2;
        this.zzboj = arrayList;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzboi;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzboj;
    }

    public String getTotalPrice() {
        return this.zzboh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
