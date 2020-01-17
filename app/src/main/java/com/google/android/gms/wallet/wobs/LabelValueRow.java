package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
    public static final Parcelable.Creator<LabelValueRow> CREATOR = new zzc();
    private final int mVersionCode;
    String zzbqF;
    String zzbqG;
    ArrayList<LabelValue> zzbqH;

    LabelValueRow() {
        this.mVersionCode = 1;
        this.zzbqH = zzmn.zzsa();
    }

    LabelValueRow(int i, String str, String str2, ArrayList<LabelValue> arrayList) {
        this.mVersionCode = i;
        this.zzbqF = str;
        this.zzbqG = str2;
        this.zzbqH = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
