package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<BleDevice> zzaBE;

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.mVersionCode = i;
        this.zzaBE = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.mVersionCode = 3;
        this.zzaBE = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public static BleDevicesResult zzQ(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzUX.equals(bleDevicesResult.zzUX) && zzw.equal(this.zzaBE, bleDevicesResult.zzaBE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && zzb((BleDevicesResult) obj));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzaBE;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice next : this.zzaBE) {
            if (next.getDataTypes().contains(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzUX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaBE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("bleDevices", this.zzaBE).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
