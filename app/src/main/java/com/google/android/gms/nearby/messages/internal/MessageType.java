package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class MessageType implements SafeParcelable {
    public static final Parcelable.Creator<MessageType> CREATOR = new zzk();
    final int mVersionCode;
    public final String type;
    public final String zzamD;

    MessageType(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzamD = str;
        this.type = str2;
    }

    public MessageType(String str, String str2) {
        this(1, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof MessageType)) {
                return false;
            }
            MessageType messageType = (MessageType) obj;
            if (!zzw.equal(this.zzamD, messageType.zzamD) || !zzw.equal(this.type, messageType.type)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamD, this.type);
    }

    public String toString() {
        return "namespace=" + this.zzamD + ", type=" + this.type;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
