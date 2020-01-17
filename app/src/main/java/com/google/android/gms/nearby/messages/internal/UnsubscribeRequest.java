package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzd;
import com.google.android.gms.nearby.messages.internal.zze;

public final class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzu();
    final int mVersionCode;
    @Deprecated
    public final String zzbbF;
    @Deprecated
    public final boolean zzbbH;
    public final zzd zzbcY;
    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;
    public final PendingIntent zzbda;
    public final int zzbdb;

    UnsubscribeRequest(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        this.mVersionCode = i;
        this.zzbcY = zzd.zza.zzdy(iBinder);
        this.zzbcr = zze.zza.zzdz(iBinder2);
        this.zzbda = pendingIntent;
        this.zzbdb = i2;
        this.zzbbF = str;
        this.zzbco = str2;
        this.zzbbH = z;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    UnsubscribeRequest(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i, ClientAppContext clientAppContext) {
        this(1, iBinder, iBinder2, pendingIntent, i, (String) null, (String) null, false, clientAppContext);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzEH() {
        if (this.zzbcY == null) {
            return null;
        }
        return this.zzbcY.asBinder();
    }
}
