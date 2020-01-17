package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzac extends zzc implements DataItemAsset {
    public zzac(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    /* renamed from: zzIL */
    public DataItemAsset freeze() {
        return new zzaa(this);
    }
}
