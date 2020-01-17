package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzab();
    final int mVersionCode;
    private final String zzvs;
    private final String zzyv;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzyv = str;
        this.zzvs = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.mVersionCode = 1;
        this.zzyv = (String) zzx.zzz(dataItemAsset.getId());
        this.zzvs = (String) zzx.zzz(dataItemAsset.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public String getDataItemKey() {
        return this.zzvs;
    }

    public String getId() {
        return this.zzyv;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzyv == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zzyv);
        }
        sb.append(", key=");
        sb.append(this.zzvs);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }

    /* renamed from: zzIL */
    public DataItemAsset freeze() {
        return this;
    }
}
