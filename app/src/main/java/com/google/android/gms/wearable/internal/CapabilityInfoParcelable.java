package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzk();
    private final String mName;
    final int mVersionCode;
    private Set<Node> zzbrS;
    private final List<NodeParcelable> zzbrV;
    private final Object zzpV = new Object();

    CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzbrV = list;
        this.zzbrS = null;
        zzIH();
    }

    private void zzIH() {
        zzx.zzz(this.mName);
        zzx.zzz(this.zzbrV);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
            if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
                return false;
            }
            if (this.mName != null) {
                if (!this.mName.equals(capabilityInfoParcelable.mName)) {
                    return false;
                }
            } else if (capabilityInfoParcelable.mName != null) {
                return false;
            }
            if (this.zzbrV != null) {
                if (!this.zzbrV.equals(capabilityInfoParcelable.zzbrV)) {
                    return false;
                }
            } else if (capabilityInfoParcelable.zzbrV != null) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return this.mName;
    }

    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzpV) {
            if (this.zzbrS == null) {
                this.zzbrS = new HashSet(this.zzbrV);
            }
            set = this.zzbrS;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.mVersionCode;
        int hashCode = this.mName != null ? this.mName.hashCode() : 0;
        if (this.zzbrV != null) {
            i = this.zzbrV.hashCode();
        }
        return ((hashCode + (i2 * 31)) * 31) + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzbrV + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public List<NodeParcelable> zzII() {
        return this.zzbrV;
    }
}
