package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    boolean zzaBr;
    long zzaND;
    long zzaNY;
    long zzaNZ;
    int zzaOa;
    float zzaOb;
    long zzaOc;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.zzaNY = 3600000;
        this.zzaNZ = 600000;
        this.zzaBr = false;
        this.zzaND = Long.MAX_VALUE;
        this.zzaOa = Integer.MAX_VALUE;
        this.zzaOb = 0.0f;
        this.zzaOc = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.mVersionCode = i;
        this.mPriority = i2;
        this.zzaNY = j;
        this.zzaNZ = j2;
        this.zzaBr = z;
        this.zzaND = j3;
        this.zzaOa = i3;
        this.zzaOb = f;
        this.zzaOc = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzL(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzhs(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzht(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof LocationRequest)) {
                return false;
            }
            LocationRequest locationRequest = (LocationRequest) obj;
            if (!(this.mPriority == locationRequest.mPriority && this.zzaNY == locationRequest.zzaNY && this.zzaNZ == locationRequest.zzaNZ && this.zzaBr == locationRequest.zzaBr && this.zzaND == locationRequest.zzaND && this.zzaOa == locationRequest.zzaOa && this.zzaOb == locationRequest.zzaOb)) {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime() {
        return this.zzaND;
    }

    public long getFastestInterval() {
        return this.zzaNZ;
    }

    public long getInterval() {
        return this.zzaNY;
    }

    public long getMaxWaitTime() {
        long j = this.zzaOc;
        return j < this.zzaNY ? this.zzaNY : j;
    }

    public int getNumUpdates() {
        return this.zzaOa;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaOb;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaNY), Long.valueOf(this.zzaNZ), Boolean.valueOf(this.zzaBr), Long.valueOf(this.zzaND), Integer.valueOf(this.zzaOa), Float.valueOf(this.zzaOb));
    }

    public LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaND = Long.MAX_VALUE;
        } else {
            this.zzaND = elapsedRealtime + j;
        }
        if (this.zzaND < 0) {
            this.zzaND = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long j) {
        this.zzaND = j;
        if (this.zzaND < 0) {
            this.zzaND = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        zzL(j);
        this.zzaBr = true;
        this.zzaNZ = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zzL(j);
        this.zzaNY = j;
        if (!this.zzaBr) {
            this.zzaNZ = (long) (((double) this.zzaNY) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long j) {
        zzL(j);
        this.zzaOc = j;
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zzaOa = i;
        return this;
    }

    public LocationRequest setPriority(int i) {
        zzhs(i);
        this.mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        zzd(f);
        this.zzaOb = f;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzht(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaNY).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaNZ).append("ms");
        if (this.zzaOc > this.zzaNY) {
            sb.append(" maxWait=");
            sb.append(this.zzaOc).append("ms");
        }
        if (this.zzaND != Long.MAX_VALUE) {
            long j = this.zzaND;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j - elapsedRealtime).append("ms");
        }
        if (this.zzaOa != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaOa);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
