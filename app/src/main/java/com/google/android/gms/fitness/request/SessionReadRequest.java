package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzou;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzy();
    private final int mVersionCode;
    private final String zzLq;
    private final long zzRD;
    private final List<DataSource> zzaAF;
    private final boolean zzaAQ;
    private final String zzaBu;
    private boolean zzaBv;
    private final List<String> zzaBw;
    private final zzou zzaBx;
    private final long zzavV;
    private final List<DataType> zzawe;

    public static class Builder {
        /* access modifiers changed from: private */
        public String zzLq;
        /* access modifiers changed from: private */
        public long zzRD = 0;
        /* access modifiers changed from: private */
        public List<DataSource> zzaAF = new ArrayList();
        /* access modifiers changed from: private */
        public boolean zzaAQ = false;
        /* access modifiers changed from: private */
        public String zzaBu;
        /* access modifiers changed from: private */
        public boolean zzaBv = false;
        /* access modifiers changed from: private */
        public List<String> zzaBw = new ArrayList();
        /* access modifiers changed from: private */
        public long zzavV = 0;
        /* access modifiers changed from: private */
        public List<DataType> zzawe = new ArrayList();

        public SessionReadRequest build() {
            zzx.zzb(this.zzRD > 0, "Invalid start time: %s", Long.valueOf(this.zzRD));
            zzx.zzb(this.zzavV > 0 && this.zzavV > this.zzRD, "Invalid end time: %s", Long.valueOf(this.zzavV));
            return new SessionReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzaAQ = true;
            return this;
        }

        public Builder excludePackage(String str) {
            zzx.zzb(str, (Object) "Attempting to use a null package name");
            if (!this.zzaBw.contains(str)) {
                this.zzaBw.add(str);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb(dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzaAF.contains(dataSource)) {
                this.zzaAF.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb(dataType, (Object) "Attempting to use a null data type");
            if (!this.zzawe.contains(dataType)) {
                this.zzawe.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzaBv = true;
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzLq = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.zzaBu = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzRD = timeUnit.toMillis(j);
            this.zzavV = timeUnit.toMillis(j2);
            return this;
        }
    }

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaBu = str;
        this.zzLq = str2;
        this.zzRD = j;
        this.zzavV = j2;
        this.zzawe = list;
        this.zzaAF = list2;
        this.zzaBv = z;
        this.zzaAQ = z2;
        this.zzaBw = list3;
        this.zzaBx = zzou.zza.zzbP(iBinder);
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzaBu, builder.zzLq, builder.zzRD, builder.zzavV, builder.zzawe, builder.zzaAF, builder.zzaBv, builder.zzaAQ, builder.zzaBw, (zzou) null);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzou zzou) {
        this(sessionReadRequest.zzaBu, sessionReadRequest.zzLq, sessionReadRequest.zzRD, sessionReadRequest.zzavV, sessionReadRequest.zzawe, sessionReadRequest.zzaAF, sessionReadRequest.zzaBv, sessionReadRequest.zzaAQ, sessionReadRequest.zzaBw, zzou);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zzou zzou) {
        this(5, str, str2, j, j2, list, list2, z, z2, list3, zzou == null ? null : zzou.asBinder());
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzw.equal(this.zzaBu, sessionReadRequest.zzaBu) && this.zzLq.equals(sessionReadRequest.zzLq) && this.zzRD == sessionReadRequest.zzRD && this.zzavV == sessionReadRequest.zzavV && zzw.equal(this.zzawe, sessionReadRequest.zzawe) && zzw.equal(this.zzaAF, sessionReadRequest.zzaAF) && this.zzaBv == sessionReadRequest.zzaBv && this.zzaBw.equals(sessionReadRequest.zzaBw) && this.zzaAQ == sessionReadRequest.zzaAQ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && zzb((SessionReadRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBx == null) {
            return null;
        }
        return this.zzaBx.asBinder();
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

    public List<String> getExcludedPackages() {
        return this.zzaBw;
    }

    public String getSessionId() {
        return this.zzLq;
    }

    public String getSessionName() {
        return this.zzaBu;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaBu, this.zzLq, Long.valueOf(this.zzRD), Long.valueOf(this.zzavV));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzaBv;
    }

    public String toString() {
        return zzw.zzy(this).zzg("sessionName", this.zzaBu).zzg("sessionId", this.zzLq).zzg("startTimeMillis", Long.valueOf(this.zzRD)).zzg("endTimeMillis", Long.valueOf(this.zzavV)).zzg("dataTypes", this.zzawe).zzg("dataSources", this.zzaAF).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzaBv)).zzg("excludedPackages", this.zzaBw).zzg("useServer", Boolean.valueOf(this.zzaAQ)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public long zzud() {
        return this.zzavV;
    }

    public boolean zzve() {
        return this.zzaBv;
    }
}
