package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzaf extends zzc implements DataItem {
    private final int zzaDQ;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    public Map<String, DataItemAsset> getAssets() {
        HashMap hashMap = new HashMap(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            zzac zzac = new zzac(this.zzahi, this.zzaje + i);
            if (zzac.getDataItemKey() != null) {
                hashMap.put(zzac.getDataItemKey(), zzac);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        byte[] data = getData();
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + getUri());
        sb.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        sb.append(", numAssets=" + assets.size());
        if (z && !assets.isEmpty()) {
            sb.append(", assets=[");
            Iterator<Map.Entry<String, DataItemAsset>> it = assets.entrySet().iterator();
            String str = "";
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                sb.append(str2 + ((String) next.getKey()) + ": " + ((DataItemAsset) next.getValue()).getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    /* renamed from: zzIM */
    public DataItem freeze() {
        return new zzad(this);
    }
}
