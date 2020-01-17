package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final long zzaBk;
    private final long zzaBl;
    private final LocationRequest zzaBp;
    private final long zzaBq;
    private final DataType zzavT;
    private final DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzaBk = 0;
        /* access modifiers changed from: private */
        public long zzaBl = 0;
        /* access modifiers changed from: private */
        public long zzaBq = Long.MAX_VALUE;
        private boolean zzaBr = false;
        /* access modifiers changed from: private */
        public DataType zzavT;
        /* access modifiers changed from: private */
        public DataSource zzavU;
        /* access modifiers changed from: private */
        public long zzaxo = -1;
        /* access modifiers changed from: private */
        public int zzaxp = 2;

        public SensorRequest build() {
            boolean z = false;
            zzx.zza((this.zzavU == null && this.zzavT == null) ? false : true, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzavT == null || this.zzavU == null || this.zzavT.equals(this.zzavU.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int i) {
            this.zzaxp = SensorRequest.zzfB(i);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzavU = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public Builder setFastestRate(int i, TimeUnit timeUnit) {
            zzx.zzb(i >= 0, (Object) "Cannot use a negative interval");
            this.zzaBr = true;
            this.zzaBl = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setMaxDeliveryLatency(int i, TimeUnit timeUnit) {
            zzx.zzb(i >= 0, (Object) "Cannot use a negative delivery interval");
            this.zzaBk = timeUnit.toMicros((long) i);
            return this;
        }

        public Builder setSamplingRate(long j, TimeUnit timeUnit) {
            zzx.zzb(j >= 0, (Object) "Cannot use a negative sampling interval");
            this.zzaxo = timeUnit.toMicros(j);
            if (!this.zzaBr) {
                this.zzaBl = this.zzaxo / 2;
            }
            return this;
        }

        public Builder setTimeout(long j, TimeUnit timeUnit) {
            boolean z = true;
            zzx.zzb(j > 0, "Invalid time out value specified: %d", Long.valueOf(j));
            if (timeUnit == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Invalid time unit specified");
            this.zzaBq = timeUnit.toMicros(j);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzaBp = locationRequest;
        this.zzaxo = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzaBl = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzaBk = this.zzaxo;
        this.zzavT = dataSource.getDataType();
        this.zzaxp = zza(locationRequest);
        this.zzavU = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzaBq = Long.MAX_VALUE;
        } else {
            this.zzaBq = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzavU = builder.zzavU;
        this.zzavT = builder.zzavT;
        this.zzaxo = builder.zzaxo;
        this.zzaBl = builder.zzaBl;
        this.zzaBk = builder.zzaBk;
        this.zzaxp = builder.zzaxp;
        this.zzaBp = null;
        this.zzaBq = builder.zzaBq;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case 104:
                return 1;
            default:
                return 2;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return zzw.equal(this.zzavU, sensorRequest.zzavU) && zzw.equal(this.zzavT, sensorRequest.zzavT) && this.zzaxo == sensorRequest.zzaxo && this.zzaBl == sensorRequest.zzaBl && this.zzaBk == sensorRequest.zzaBk && this.zzaxp == sensorRequest.zzaxp && zzw.equal(this.zzaBp, sensorRequest.zzaBp) && this.zzaBq == sensorRequest.zzaBq;
    }

    public static int zzfB(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            default:
                return 2;
        }
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRequest) && zza((SensorRequest) obj));
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

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBl, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaBk, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaxo, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavU, this.zzavT, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBp, Long.valueOf(this.zzaBq));
    }

    public String toString() {
        return zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("samplingRateMicros", Long.valueOf(this.zzaxo)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzaBk)).zzg("timeOutMicros", Long.valueOf(this.zzaBq)).toString();
    }

    public long zzvc() {
        return this.zzaBq;
    }
}
