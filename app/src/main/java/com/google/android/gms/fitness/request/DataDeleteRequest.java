package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzd();
    private final int mVersionCode;
    private final long zzRD;
    private final zzow zzaAD;
    private final List<DataSource> zzaAF;
    private final List<Session> zzaAG;
    private final boolean zzaAH;
    private final boolean zzaAI;
    private final long zzavV;
    private final List<DataType> zzawe;

    public static class Builder {
        /* access modifiers changed from: private */
        public long zzRD;
        /* access modifiers changed from: private */
        public List<DataSource> zzaAF = new ArrayList();
        /* access modifiers changed from: private */
        public List<Session> zzaAG = new ArrayList();
        /* access modifiers changed from: private */
        public boolean zzaAH = false;
        /* access modifiers changed from: private */
        public boolean zzaAI = false;
        /* access modifiers changed from: private */
        public long zzavV;
        /* access modifiers changed from: private */
        public List<DataType> zzawe = new ArrayList();

        private void zzuN() {
            if (!this.zzaAG.isEmpty()) {
                for (Session next : this.zzaAG) {
                    zzx.zza(next.getStartTime(TimeUnit.MILLISECONDS) >= this.zzRD && next.getEndTime(TimeUnit.MILLISECONDS) <= this.zzavV, "Session %s is outside the time interval [%d, %d]", next, Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzx.zzb(!this.zzaAH, (Object) "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzx.zzb(!this.zzaAH, (Object) "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzx.zzb(!this.zzaAI, (Object) "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            zzx.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzx.zzb(z, (Object) "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzaAG.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            zzx.zza(this.zzRD > 0 && this.zzavV > this.zzRD, (Object) "Must specify a valid time interval");
            boolean z2 = this.zzaAH || !this.zzaAF.isEmpty() || !this.zzawe.isEmpty();
            boolean z3 = this.zzaAI || !this.zzaAG.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzx.zza(z, (Object) "No data or session marked for deletion");
            zzuN();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData() {
            zzx.zzb(this.zzawe.isEmpty(), (Object) "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzx.zzb(this.zzaAF.isEmpty(), (Object) "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzaAH = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzx.zzb(this.zzaAG.isEmpty(), (Object) "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzaAI = true;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            zzx.zzb(j > 0, "Invalid start time :%d", Long.valueOf(j));
            zzx.zzb(j2 > j, "Invalid end time :%d", Long.valueOf(j2));
            this.zzRD = timeUnit.toMillis(j);
            this.zzavV = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataDeleteRequest(int i, long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaAF = Collections.unmodifiableList(list);
        this.zzawe = Collections.unmodifiableList(list2);
        this.zzaAG = list3;
        this.zzaAH = z;
        this.zzaAI = z2;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public DataDeleteRequest(long j, long j2, List<DataSource> list, List<DataType> list2, List<Session> list3, boolean z, boolean z2, zzow zzow) {
        this.mVersionCode = 3;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzaAF = Collections.unmodifiableList(list);
        this.zzawe = Collections.unmodifiableList(list2);
        this.zzaAG = list3;
        this.zzaAH = z;
        this.zzaAI = z2;
        this.zzaAD = zzow;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.zzaAF, builder.zzawe, builder.zzaAG, builder.zzaAH, builder.zzaAI, (zzow) null);
    }

    public DataDeleteRequest(DataDeleteRequest dataDeleteRequest, zzow zzow) {
        this(dataDeleteRequest.zzRD, dataDeleteRequest.zzavV, dataDeleteRequest.zzaAF, dataDeleteRequest.zzawe, dataDeleteRequest.zzaAG, dataDeleteRequest.zzaAH, dataDeleteRequest.zzaAI, zzow);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzRD == dataDeleteRequest.zzRD && this.zzavV == dataDeleteRequest.zzavV && zzw.equal(this.zzaAF, dataDeleteRequest.zzaAF) && zzw.equal(this.zzawe, dataDeleteRequest.zzawe) && zzw.equal(this.zzaAG, dataDeleteRequest.zzaAG) && this.zzaAH == dataDeleteRequest.zzaAH && this.zzaAI == dataDeleteRequest.zzaAI;
    }

    public boolean deleteAllData() {
        return this.zzaAH;
    }

    public boolean deleteAllSessions() {
        return this.zzaAI;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataDeleteRequest) && zzb((DataDeleteRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public List<DataSource> getDataSources() {
        return this.zzaAF;
    }

    public List<DataType> getDataTypes() {
        return this.zzawe;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public List<Session> getSessions() {
        return this.zzaAG;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataSources", this.zzaAF).zzg("dateTypes", this.zzawe).zzg("sessions", this.zzaAG).zzg("deleteAllData", Boolean.valueOf(this.zzaAH)).zzg("deleteAllSessions", Boolean.valueOf(this.zzaAI)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuL() {
        return this.zzaAH;
    }

    public boolean zzuM() {
        return this.zzaAI;
    }

    public long zzud() {
        return this.zzavV;
    }
}
