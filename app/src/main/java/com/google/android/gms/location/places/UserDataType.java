package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;

public final class UserDataType implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public static final UserDataType zzaPX = zzy("test_type", 1);
    public static final UserDataType zzaPY = zzy("labeled_place", 6);
    public static final UserDataType zzaPZ = zzy("here_content", 7);
    public static final Set<UserDataType> zzaQa = zzmr.zza(zzaPX, zzaPY, zzaPZ);
    final int mVersionCode;
    final String zzJN;
    final int zzaQb;

    UserDataType(int i, String str, int i2) {
        zzx.zzcM(str);
        this.mVersionCode = i;
        this.zzJN = str;
        this.zzaQb = i2;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof UserDataType)) {
                return false;
            }
            UserDataType userDataType = (UserDataType) obj;
            if (!this.zzJN.equals(userDataType.zzJN) || this.zzaQb != userDataType.zzaQb) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.zzJN.hashCode();
    }

    public String toString() {
        return this.zzJN;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
