package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;

public class PeriodicTask extends Task {
    public static final Parcelable.Creator<PeriodicTask> CREATOR = new Parcelable.Creator<PeriodicTask>() {
        /* renamed from: zzeK */
        public PeriodicTask createFromParcel(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        /* renamed from: zzhh */
        public PeriodicTask[] newArray(int i) {
            return new PeriodicTask[i];
        }
    };
    protected long mFlexInSeconds;
    protected long mIntervalInSeconds;

    public static class Builder extends Task.Builder {
        /* access modifiers changed from: private */
        public long zzaMa = -1;
        /* access modifiers changed from: private */
        public long zzaMb = -1;

        public Builder() {
            this.isPersisted = true;
        }

        public PeriodicTask build() {
            checkConditions();
            return new PeriodicTask(this);
        }

        /* access modifiers changed from: protected */
        public void checkConditions() {
            super.checkConditions();
            if (this.zzaMa == -1) {
                throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
            } else if (this.zzaMa <= 0) {
                throw new IllegalArgumentException("Period set cannot be less or equal to 0: " + this.zzaMa);
            } else if (this.zzaMb == -1) {
                this.zzaMb = (long) (((float) this.zzaMa) * 0.1f);
            } else if (this.zzaMb > this.zzaMa) {
                this.zzaMb = this.zzaMa;
            }
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFlex(long j) {
            this.zzaMb = j;
            return this;
        }

        public Builder setPeriod(long j) {
            this.zzaMa = j;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.gcmTaskService = cls.getName();
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = parcel.readLong();
        this.mFlexInSeconds = Math.min(parcel.readLong(), this.mIntervalInSeconds);
    }

    private PeriodicTask(Builder builder) {
        super((Task.Builder) builder);
        this.mIntervalInSeconds = -1;
        this.mFlexInSeconds = -1;
        this.mIntervalInSeconds = builder.zzaMa;
        this.mFlexInSeconds = Math.min(builder.zzaMb, this.mIntervalInSeconds);
    }

    public long getFlex() {
        return this.mFlexInSeconds;
    }

    public long getPeriod() {
        return this.mIntervalInSeconds;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("period", this.mIntervalInSeconds);
        bundle.putLong("period_flex", this.mFlexInSeconds);
    }

    public String toString() {
        return super.toString() + " " + "period=" + getPeriod() + " " + "flex=" + getFlex();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.mIntervalInSeconds);
        parcel.writeLong(this.mFlexInSeconds);
    }
}
