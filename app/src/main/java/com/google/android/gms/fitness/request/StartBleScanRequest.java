package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzad();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzq zzaBA;
    private final int zzaBB;
    private final List<DataType> zzawe;

    public static class Builder {
        /* access modifiers changed from: private */
        public DataType[] zzaAY = new DataType[0];
        /* access modifiers changed from: private */
        public zzq zzaBA;
        /* access modifiers changed from: private */
        public int zzaBB = 10;

        public StartBleScanRequest build() {
            zzx.zza(this.zzaBA != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza((zzq) zza.C0062zza.zzuJ().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaAY = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            boolean z = true;
            zzx.zzb(i > 0, (Object) "Stop time must be greater than zero");
            if (i > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzaBB = i;
            return this;
        }

        public Builder zza(zzq zzq) {
            this.zzaBA = zzq;
            return this;
        }
    }

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzawe = list;
        this.zzaBA = zzq.zza.zzbU(iBinder);
        this.zzaBB = i2;
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    private StartBleScanRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), builder.zzaBA, builder.zzaBB, (zzow) null);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zzow zzow) {
        this(startBleScanRequest.zzawe, startBleScanRequest.zzaBA, startBleScanRequest.zzaBB, zzow);
    }

    public StartBleScanRequest(List<DataType> list, zzq zzq, int i, zzow zzow) {
        this.mVersionCode = 4;
        this.zzawe = list;
        this.zzaBA = zzq;
        this.zzaBB = i;
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

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzawe);
    }

    public int getTimeoutSecs() {
        return this.zzaBB;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("timeoutSecs", Integer.valueOf(this.zzaBB)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public IBinder zzvg() {
        return this.zzaBA.asBinder();
    }
}
