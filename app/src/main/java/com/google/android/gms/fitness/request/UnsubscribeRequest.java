package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;

public class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzah();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final DataType zzavT;
    private final DataSource zzavU;

    UnsubscribeRequest(int i, DataType dataType, DataSource dataSource, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzow zzow) {
        this.mVersionCode = 3;
        this.zzavT = dataType;
        this.zzavU = dataSource;
        this.zzaAD = zzow;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return zzw.equal(this.zzavU, unsubscribeRequest.zzavU) && zzw.equal(this.zzavT, unsubscribeRequest.zzavT);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavT);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }
}
