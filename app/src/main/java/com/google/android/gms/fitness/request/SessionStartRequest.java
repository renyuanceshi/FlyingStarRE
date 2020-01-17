package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzow;
import java.util.concurrent.TimeUnit;

public class SessionStartRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzaa();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final Session zzavX;

    SessionStartRequest(int i, Session session, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavX = session;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public SessionStartRequest(Session session, zzow zzow) {
        zzx.zzb(session.getStartTime(TimeUnit.MILLISECONDS) < System.currentTimeMillis(), (Object) "Cannot start a session in the future");
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.mVersionCode = 3;
        this.zzavX = session;
        this.zzaAD = zzow;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return zzw.equal(this.zzavX, sessionStartRequest.zzavX);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStartRequest) && zzb((SessionStartRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public Session getSession() {
        return this.zzavX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavX);
    }

    public String toString() {
        return zzw.zzy(this).zzg("session", this.zzavX).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }
}
