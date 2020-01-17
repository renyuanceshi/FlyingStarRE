package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzor;

public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsRequest> CREATOR = new zzs();
    private final int mVersionCode;
    private final zzor zzaBd;
    private final DataType zzavT;

    ListSubscriptionsRequest(int i, DataType dataType, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavT = dataType;
        this.zzaBd = zzor.zza.zzbM(iBinder);
    }

    public ListSubscriptionsRequest(DataType dataType, zzor zzor) {
        this.mVersionCode = 3;
        this.zzavT = dataType;
        this.zzaBd = zzor;
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBd == null) {
            return null;
        }
        return this.zzaBd.asBinder();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }
}
