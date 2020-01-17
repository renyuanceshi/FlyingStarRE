package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaOU;
    LocationRequestInternal zzaOV;
    zzd zzaOW;
    zzc zzaOX;
    zzg zzaOY;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzg zzg = null;
        this.mVersionCode = i;
        this.zzaOU = i2;
        this.zzaOV = locationRequestInternal;
        this.zzaOW = iBinder == null ? null : zzd.zza.zzcf(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaOX = iBinder2 == null ? null : zzc.zza.zzce(iBinder2);
        this.zzaOY = iBinder3 != null ? zzg.zza.zzch(iBinder3) : zzg;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, (IBinder) null, pendingIntent, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc zzc, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, (IBinder) null, (PendingIntent) null, zzc.asBinder(), zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzd zzd, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzd.asBinder(), (PendingIntent) null, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzc zzc, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, (IBinder) null, (PendingIntent) null, zzc.asBinder(), zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzd zzd, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, zzd.asBinder(), (PendingIntent) null, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, @Nullable zzg zzg) {
        return new LocationRequestUpdateData(1, 2, (LocationRequestInternal) null, (IBinder) null, pendingIntent, (IBinder) null, zzg != null ? zzg.asBinder() : null);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyQ() {
        if (this.zzaOW == null) {
            return null;
        }
        return this.zzaOW.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyR() {
        if (this.zzaOX == null) {
            return null;
        }
        return this.zzaOX.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzyS() {
        if (this.zzaOY == null) {
            return null;
        }
        return this.zzaOY.asBinder();
    }
}
