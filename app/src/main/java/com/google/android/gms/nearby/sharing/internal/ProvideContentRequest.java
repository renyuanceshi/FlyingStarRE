package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzbdk;
    public zzb zzbdl;
    @Deprecated
    public List<SharedContent> zzbdm;
    public long zzbdn;
    public zzc zzbdo;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int i, IBinder iBinder, IBinder iBinder2, List<SharedContent> list, long j, IBinder iBinder3) {
        this.versionCode = i;
        this.zzbdk = iBinder;
        this.zzbdl = zzb.zza.zzdG(iBinder2);
        this.zzbdm = list;
        this.zzbdn = j;
        this.zzbdo = zzc.zza.zzdH(iBinder3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzEP() {
        if (this.zzbdl == null) {
            return null;
        }
        return this.zzbdl.asBinder();
    }
}
