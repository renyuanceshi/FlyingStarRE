package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();
    private final int mVersionCode;
    private final List<AppIdentifier> zzbaZ;

    AppMetadata(int i, List<AppIdentifier> list) {
        this.mVersionCode = i;
        this.zzbaZ = (List) zzx.zzb(list, (Object) "Must specify application identifiers");
        zzx.zza(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> list) {
        this(1, list);
    }

    public int describeContents() {
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzbaZ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
