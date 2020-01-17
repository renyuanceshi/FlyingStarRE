package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzasF;
    final boolean zzauj;

    FieldWithSortOrder(int i, String str, boolean z) {
        this.mVersionCode = i;
        this.zzasF = str;
        this.zzauj = z;
    }

    public FieldWithSortOrder(String str, boolean z) {
        this(1, str, z);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "FieldWithSortOrder[%s %s]", new Object[]{this.zzasF, this.zzauj ? "ASC" : "DESC"});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
