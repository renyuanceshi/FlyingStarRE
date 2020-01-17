package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzow;

public class SessionRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionRegistrationRequest> CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private final int zzaBy;

    SessionRegistrationRequest(int i, PendingIntent pendingIntent, IBinder iBinder, int i2) {
        this.mVersionCode = i;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = iBinder == null ? null : zzow.zza.zzbR(iBinder);
        this.zzaBy = i2;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zzow zzow, int i) {
        this.mVersionCode = 6;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow;
        this.zzaBy = i;
    }

    private boolean zzb(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.zzaBy == sessionRegistrationRequest.zzaBy && zzw.equal(this.mPendingIntent, sessionRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent, Integer.valueOf(this.zzaBy));
    }

    public String toString() {
        return zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaBy)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.zza(this, parcel, i);
    }

    public int zzvf() {
        return this.zzaBy;
    }
}
