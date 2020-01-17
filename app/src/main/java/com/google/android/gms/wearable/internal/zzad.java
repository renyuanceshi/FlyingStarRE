package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzad implements DataItem {
    private Uri mUri;
    private byte[] zzaKm;
    private Map<String, DataItemAsset> zzbsy;

    public zzad(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzaKm = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : dataItem.getAssets().entrySet()) {
            if (next.getKey() != null) {
                hashMap.put(next.getKey(), ((DataItemAsset) next.getValue()).freeze());
            }
        }
        this.zzbsy = Collections.unmodifiableMap(hashMap);
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzbsy;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=" + this.mUri);
        sb.append(", dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbsy.size());
        if (z && !this.zzbsy.isEmpty()) {
            sb.append(", assets=[");
            Iterator<Map.Entry<String, DataItemAsset>> it = this.zzbsy.entrySet().iterator();
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
        return this;
    }
}
