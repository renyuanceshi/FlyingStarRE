package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class Subscription implements SafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new zzs();
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    public static class zza {
        /* access modifiers changed from: private */
        public DataType zzavT;
        /* access modifiers changed from: private */
        public DataSource zzavU;
        /* access modifiers changed from: private */
        public long zzaxo = -1;
        /* access modifiers changed from: private */
        public int zzaxp = 2;

        public zza zzb(DataSource dataSource) {
            this.zzavU = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public Subscription zzuz() {
            boolean z = false;
            zzx.zza((this.zzavU == null && this.zzavT == null) ? false : true, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzavT == null || this.zzavU == null || this.zzavT.equals(this.zzavU.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaxo = j;
        this.zzaxp = i2;
    }

    private Subscription(zza zza2) {
        this.mVersionCode = 1;
        this.zzavT = zza2.zzavT;
        this.zzavU = zza2.zzavU;
        this.zzaxo = zza2.zzaxo;
        this.zzaxp = zza2.zzaxp;
    }

    private boolean zza(Subscription subscription) {
        return zzw.equal(this.zzavU, subscription.zzavU) && zzw.equal(this.zzavT, subscription.zzavT) && this.zzaxo == subscription.zzaxo && this.zzaxp == subscription.zzaxp;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && zza((Subscription) obj));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
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
        return zzw.hashCode(this.zzavU, this.zzavU, Long.valueOf(this.zzaxo), Integer.valueOf(this.zzaxp));
    }

    public String toDebugString() {
        return String.format("Subscription{%s}", new Object[]{this.zzavU == null ? this.zzavT.getName() : this.zzavU.toDebugString()});
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("samplingIntervalMicros", Long.valueOf(this.zzaxo)).zzg("accuracyMode", Integer.valueOf(this.zzaxp)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public long zzux() {
        return this.zzaxo;
    }

    public DataType zzuy() {
        return this.zzavT == null ? this.zzavU.getDataType() : this.zzavT;
    }
}
