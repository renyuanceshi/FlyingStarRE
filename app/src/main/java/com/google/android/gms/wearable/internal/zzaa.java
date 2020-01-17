package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa implements DataItemAsset {
    private final String zzvs;
    private final String zzyv;

    public zzaa(DataItemAsset dataItemAsset) {
        this.zzyv = dataItemAsset.getId();
        this.zzvs = dataItemAsset.getDataItemKey();
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
        sb.append("DataItemAssetEntity[");
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

    /* renamed from: zzIL */
    public DataItemAsset freeze() {
        return this;
    }
}
