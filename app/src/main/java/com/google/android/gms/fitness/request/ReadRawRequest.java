package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzos;
import java.util.List;

public class ReadRawRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReadRawRequest> CREATOR = new zzt();
    private final int mVersionCode;
    private final boolean zzaAP;
    private final boolean zzaAQ;
    private final zzos zzaBe;
    private final List<DataSourceQueryParams> zzaBf;

    ReadRawRequest(int i, IBinder iBinder, List<DataSourceQueryParams> list, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.zzaBe = zzos.zza.zzbN(iBinder);
        this.zzaBf = list;
        this.zzaAP = z;
        this.zzaAQ = z2;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBe != null) {
            return this.zzaBe.asBinder();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
    }

    public boolean zzuP() {
        return this.zzaAQ;
    }

    public boolean zzuQ() {
        return this.zzaAP;
    }

    public List<DataSourceQueryParams> zzuW() {
        return this.zzaBf;
    }
}
