package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzq();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzRD;
    private final long zzavV;
    private final int zzawf;
    private final Application zzaws;
    private final String zzaxk;
    private final String zzaxl;
    private final Long zzaxm;

    public static class Builder {
        /* access modifiers changed from: private */
        public String mName = null;
        /* access modifiers changed from: private */
        public long zzRD = 0;
        /* access modifiers changed from: private */
        public long zzavV = 0;
        /* access modifiers changed from: private */
        public int zzawf = 4;
        /* access modifiers changed from: private */
        public Application zzaws;
        /* access modifiers changed from: private */
        public String zzaxk;
        /* access modifiers changed from: private */
        public String zzaxl;
        /* access modifiers changed from: private */
        public Long zzaxm;

        public Session build() {
            boolean z = false;
            zzx.zza(this.zzRD > 0, (Object) "Start time should be specified.");
            if (this.zzavV == 0 || this.zzavV > this.zzRD) {
                z = true;
            }
            zzx.zza(z, (Object) "End time should be later than start time.");
            if (this.zzaxk == null) {
                this.zzaxk = (this.mName == null ? "" : this.mName) + this.zzRD;
            }
            return new Session(this);
        }

        public Builder setActiveTime(long j, TimeUnit timeUnit) {
            this.zzaxm = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public Builder setActivity(String str) {
            return zzfa(FitnessActivities.zzdm(str));
        }

        public Builder setDescription(String str) {
            zzx.zzb(str.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.zzaxl = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            zzx.zza(j >= 0, (Object) "End time should be positive.");
            this.zzavV = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            zzx.zzac(str != null && TextUtils.getTrimmedLength(str) > 0);
            this.zzaxk = str;
            return this;
        }

        public Builder setName(String str) {
            zzx.zzb(str.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.mName = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            zzx.zza(j > 0, (Object) "Start time should be positive.");
            this.zzRD = timeUnit.toMillis(j);
            return this;
        }

        public Builder zzfa(int i) {
            this.zzawf = i;
            return this;
        }
    }

    Session(int i, long j, long j2, String str, String str2, String str3, int i2, Application application, Long l) {
        this.mVersionCode = i;
        this.zzRD = j;
        this.zzavV = j2;
        this.mName = str;
        this.zzaxk = str2;
        this.zzaxl = str3;
        this.zzawf = i2;
        this.zzaws = application;
        this.zzaxm = l;
    }

    public Session(long j, long j2, String str, String str2, String str3, int i, Application application, Long l) {
        this(3, j, j2, str, str2, str3, i, application, l);
    }

    private Session(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.mName, builder.zzaxk, builder.zzaxl, builder.zzawf, builder.zzaws, builder.zzaxm);
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        return MIME_TYPE_PREFIX + str;
    }

    private boolean zza(Session session) {
        return this.zzRD == session.zzRD && this.zzavV == session.zzavV && zzw.equal(this.mName, session.mName) && zzw.equal(this.zzaxk, session.zzaxk) && zzw.equal(this.zzaxl, session.zzaxl) && zzw.equal(this.zzaws, session.zzaws) && this.zzawf == session.zzawf;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Session) && zza((Session) obj));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzx.zza(this.zzaxm != null, (Object) "Active time is not set");
        return timeUnit.convert(this.zzaxm.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzawf);
    }

    public String getAppPackageName() {
        if (this.zzaws == null) {
            return null;
        }
        return this.zzaws.getPackageName();
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasActiveTime() {
        return this.zzaxm != null;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxk);
    }

    public boolean isOngoing() {
        return this.zzavV == 0;
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("name", this.mName).zzg("identifier", this.zzaxk).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaxl).zzg("activity", Integer.valueOf(this.zzawf)).zzg("application", this.zzaws).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public int zzub() {
        return this.zzawf;
    }

    public long zzud() {
        return this.zzavV;
    }

    public Application zzum() {
        return this.zzaws;
    }

    public Long zzuw() {
        return this.zzaxm;
    }
}
