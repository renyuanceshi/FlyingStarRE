package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class SensorRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzv();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private zzk zzaBh;
    int zzaBi;
    int zzaBj;
    private final long zzaBk;
    private final long zzaBl;
    private final List<LocationRequest> zzaBm;
    private final long zzaBn;
    private final List<Object> zzaBo;
    private DataType zzavT;
    private DataSource zzavU;
    private final long zzaxo;
    private final int zzaxp;

    SensorRegistrationRequest(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = iBinder == null ? null : zzk.zza.zzbt(iBinder);
        this.zzaxo = j == 0 ? (long) i2 : j;
        this.zzaBl = j3;
        this.zzaBk = j2 == 0 ? (long) i3 : j2;
        this.zzaBm = list;
        this.mPendingIntent = pendingIntent;
        this.zzaxp = i4;
        this.zzaBo = Collections.emptyList();
        this.zzaBn = j4;
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, zzk zzk, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<Object> list2, long j4, zzow zzow) {
        this.mVersionCode = 6;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.zzaBh = zzk;
        this.mPendingIntent = pendingIntent;
        this.zzaxo = j;
        this.zzaBl = j2;
        this.zzaBk = j3;
        this.zzaxp = i;
        this.zzaBm = list;
        this.zzaBo = list2;
        this.zzaBn = j4;
        this.zzaAD = zzow;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SensorRegistrationRequest(com.google.android.gms.fitness.request.SensorRequest r21, com.google.android.gms.fitness.data.zzk r22, android.app.PendingIntent r23, com.google.android.gms.internal.zzow r24) {
        /*
            r20 = this;
            com.google.android.gms.fitness.data.DataSource r4 = r21.getDataSource()
            com.google.android.gms.fitness.data.DataType r5 = r21.getDataType()
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MICROSECONDS
            r0 = r21
            long r8 = r0.getSamplingRate(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MICROSECONDS
            r0 = r21
            long r10 = r0.getFastestRate(r2)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MICROSECONDS
            r0 = r21
            long r12 = r0.getMaxDeliveryLatency(r2)
            int r14 = r21.getAccuracyMode()
            r15 = 0
            java.util.List r16 = java.util.Collections.emptyList()
            long r17 = r21.zzvc()
            r3 = r20
            r6 = r22
            r7 = r23
            r19 = r24
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.request.SensorRegistrationRequest.<init>(com.google.android.gms.fitness.request.SensorRequest, com.google.android.gms.fitness.data.zzk, android.app.PendingIntent, com.google.android.gms.internal.zzow):void");
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return zzw.equal(this.zzavU, sensorRegistrationRequest.zzavU) && zzw.equal(this.zzavT, sensorRegistrationRequest.zzavT) && this.zzaxo == sensorRegistrationRequest.zzaxo && this.zzaBl == sensorRegistrationRequest.zzaBl && this.zzaBk == sensorRegistrationRequest.zzaBk && this.zzaxp == sensorRegistrationRequest.zzaxp && zzw.equal(this.zzaBm, sensorRegistrationRequest.zzaBm);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) obj));
    }

    public int getAccuracyMode() {
        return this.zzaxp;
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
        return zzw.hashCode(this.zzavU, this.zzavT, this.zzaBh, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk), Integer.valueOf(this.zzaxp), this.zzaBm);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzavT, this.zzavU, Long.valueOf(this.zzaxo), Long.valueOf(this.zzaBl), Long.valueOf(this.zzaBk)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }

    public long zzuX() {
        return this.zzaBl;
    }

    public long zzuY() {
        return this.zzaBk;
    }

    public List<LocationRequest> zzuZ() {
        return this.zzaBm;
    }

    public long zzux() {
        return this.zzaxo;
    }

    public long zzva() {
        return this.zzaBn;
    }

    /* access modifiers changed from: package-private */
    public IBinder zzvb() {
        if (this.zzaBh == null) {
            return null;
        }
        return this.zzaBh.asBinder();
    }
}
