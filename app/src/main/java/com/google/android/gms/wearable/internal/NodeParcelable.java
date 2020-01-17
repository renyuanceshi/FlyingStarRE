package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbc();
    final int mVersionCode;
    private final String zzWQ;
    private final int zzbsY;
    private final boolean zzbsZ;
    private final String zzyv;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.mVersionCode = i;
        this.zzyv = str;
        this.zzWQ = str2;
        this.zzbsY = i2;
        this.zzbsZ = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NodeParcelable)) {
            return false;
        }
        return ((NodeParcelable) obj).zzyv.equals(this.zzyv);
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public int getHopCount() {
        return this.zzbsY;
    }

    public String getId() {
        return this.zzyv;
    }

    public int hashCode() {
        return this.zzyv.hashCode();
    }

    public boolean isNearby() {
        return this.zzbsZ;
    }

    public String toString() {
        return "Node{" + this.zzWQ + ", id=" + this.zzyv + ", hops=" + this.zzbsY + ", isNearby=" + this.zzbsZ + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }
}
