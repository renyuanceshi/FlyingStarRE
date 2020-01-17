package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class JoinOptions implements SafeParcelable {
    public static final Parcelable.Creator<JoinOptions> CREATOR = new zzc();
    private final int mVersionCode;
    private int zzaaJ;

    public JoinOptions() {
        this(1, 0);
    }

    JoinOptions(int i, int i2) {
        this.mVersionCode = i;
        this.zzaaJ = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JoinOptions) && this.zzaaJ == ((JoinOptions) obj).zzaaJ);
    }

    public int getConnectionType() {
        return this.zzaaJ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaaJ));
    }

    public String toString() {
        String str;
        switch (this.zzaaJ) {
            case 0:
                str = "STRONG";
                break;
            case 2:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", new Object[]{str});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
