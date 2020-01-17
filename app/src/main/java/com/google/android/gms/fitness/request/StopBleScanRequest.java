package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.internal.zzow;

public class StopBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopBleScanRequest> CREATOR = new zzae();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzq zzaBA;

    StopBleScanRequest(int i, IBinder iBinder, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzaBA = zzq.zza.zzbU(iBinder);
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzow zzow) {
        this((zzq) zza.C0062zza.zzuJ().zzb(bleScanCallback), zzow);
    }

    public StopBleScanRequest(zzq zzq, zzow zzow) {
        this.mVersionCode = 3;
        this.zzaBA = zzq;
        this.zzaAD = zzow;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public IBinder zzvg() {
        return this.zzaBA.asBinder();
    }
}
