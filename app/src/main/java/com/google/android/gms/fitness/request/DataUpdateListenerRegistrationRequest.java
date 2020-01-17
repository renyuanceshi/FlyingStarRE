package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;

public class DataUpdateListenerRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzk();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private DataType zzavT;
    private DataSource zzavU;

    public static class Builder {
        /* access modifiers changed from: private */
        public PendingIntent mPendingIntent;
        /* access modifiers changed from: private */
        public DataType zzavT;
        /* access modifiers changed from: private */
        public DataSource zzavU;

        public DataUpdateListenerRegistrationRequest build() {
            zzx.zza((this.zzavU == null && this.zzavT == null) ? false : true, (Object) "Set either dataSource or dataTYpe");
            zzx.zzb(this.mPendingIntent, (Object) "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest(this);
        }

        public Builder setDataSource(DataSource dataSource) throws NullPointerException {
            zzx.zzz(dataSource);
            this.zzavU = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            zzx.zzz(dataType);
            this.zzavT = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            zzx.zzz(pendingIntent);
            this.mPendingIntent = pendingIntent;
            return this;
        }
    }

    DataUpdateListenerRegistrationRequest(int i, DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public DataUpdateListenerRegistrationRequest(DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzavU, builder.zzavT, builder.mPendingIntent, (IBinder) null);
    }

    private boolean zzb(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return zzw.equal(this.zzavU, dataUpdateListenerRegistrationRequest.zzavU) && zzw.equal(this.zzavT, dataUpdateListenerRegistrationRequest.zzavT) && zzw.equal(this.mPendingIntent, dataUpdateListenerRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataUpdateListenerRegistrationRequest) && zzb((DataUpdateListenerRegistrationRequest) obj));
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

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavT, this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
