package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    public final Message zzbcu;

    MessageWrapper(int i, Message message) {
        this.mVersionCode = i;
        this.zzbcu = (Message) zzx.zzz(message);
    }

    public static final MessageWrapper zzb(Message message) {
        return new MessageWrapper(1, message);
    }

    public int describeContents() {
        zzl zzl = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageWrapper)) {
            return false;
        }
        return zzw.equal(this.zzbcu, ((MessageWrapper) obj).zzbcu);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbcu);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl zzl = CREATOR;
        zzl.zza(this, parcel, i);
    }
}
