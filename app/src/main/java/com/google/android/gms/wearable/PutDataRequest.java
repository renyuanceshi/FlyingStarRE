package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest implements SafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
    public static final String WEAR_URI_SCHEME = "wear";
    private static final long zzbrf = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzbrg = new SecureRandom();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Bundle zzbrh;
    private long zzbri;

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), (byte[]) null, zzbrf);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.zzbrh = bundle;
        this.zzbrh.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzaKm = bArr;
        this.zzbri = j;
    }

    public static PutDataRequest create(String str) {
        return zzr(zzgL(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest zzr = zzr(dataItem.getUri());
        for (Map.Entry next : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) next.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) next.getKey()));
            }
            zzr.putAsset((String) next.getKey(), Asset.createFromRef(((DataItemAsset) next.getValue()).getId()));
        }
        zzr.setData(dataItem.getData());
        return zzr;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN").append(zzbrg.nextLong());
        return new PutDataRequest(2, zzgL(sb.toString()));
    }

    private static Uri zzgL(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzr(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzbrh.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        HashMap hashMap = new HashMap();
        for (String str : this.zzbrh.keySet()) {
            hashMap.put(str, (Asset) this.zzbrh.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzbrh.containsKey(str);
    }

    public boolean isUrgent() {
        return this.zzbri == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzx.zzz(str);
        zzx.zzz(asset);
        this.zzbrh.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzbrh.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzaKm = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbri = 0;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbrh.size());
        sb.append(", uri=" + this.mUri);
        sb.append(", syncDeadline=" + this.zzbri);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbrh.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbrh.getParcelable(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public Bundle zzIv() {
        return this.zzbrh;
    }

    public long zzIw() {
        return this.zzbri;
    }
}
