package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<DeleteResourceRequest> CREATOR = new zzq();
    final int mVersionCode;
    final DriveId zzaqj;

    DeleteResourceRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public DeleteResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
