package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDeviceId implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceId> CREATOR = new zzh();
    public static final NearbyDeviceId zzbcl = new NearbyDeviceId();
    final int mVersionCode;
    private final int zzabB;
    final byte[] zzbbY;
    private final zzb zzbcm;
    private final zzd zzbcn;

    private NearbyDeviceId() {
        this(1, 1, (byte[]) null);
    }

    NearbyDeviceId(int i, int i2, byte[] bArr) {
        zzd zzd = null;
        this.mVersionCode = i;
        this.zzabB = i2;
        this.zzbbY = bArr;
        this.zzbcm = i2 == 2 ? new zzb(bArr) : null;
        this.zzbcn = i2 == 3 ? new zzd(bArr) : zzd;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof NearbyDeviceId)) {
                return false;
            }
            NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) obj;
            if (!zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(nearbyDeviceId.zzabB)) || !zzw.equal(this.zzbbY, nearbyDeviceId.zzbbY)) {
                return false;
            }
        }
        return true;
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabB), this.zzbbY);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NearbyDeviceId{");
        switch (this.zzabB) {
            case 1:
                append.append("UNKNOWN");
                break;
            case 2:
                append.append("eddystoneUid=").append(this.zzbcm);
                break;
            case 3:
                append.append("iBeaconId=").append(this.zzbcn);
                break;
        }
        append.append("}");
        return append.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
