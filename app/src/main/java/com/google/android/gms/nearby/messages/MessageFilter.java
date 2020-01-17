package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int mVersionCode;
    private final List<MessageType> zzbbB;
    private final List<NearbyDeviceFilter> zzbbC;
    private final boolean zzbbD;

    public static final class Builder {
        private final List<NearbyDeviceFilter> zzbbC = new ArrayList();
        private boolean zzbbD;
        private final List<MessageType> zzbbE = new ArrayList();

        private Builder zzS(String str, String str2) {
            this.zzbbE.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            zzx.zza(this.zzbbD || !this.zzbbE.isEmpty(), (Object) "At least one of the include methods must be called.");
            return new MessageFilter((List) this.zzbbE, (List) this.zzbbC, this.zzbbD);
        }

        public Builder includeAllMyTypes() {
            this.zzbbD = true;
            return this;
        }

        public Builder includeFilter(MessageFilter messageFilter) {
            this.zzbbE.addAll(messageFilter.zzEo());
            this.zzbbC.addAll(messageFilter.zzEq());
            this.zzbbD |= messageFilter.zzEp();
            return this;
        }

        public Builder includeNamespacedType(String str, String str2) {
            zzx.zzb(str != null && !str.isEmpty() && !str.contains("*"), "namespace(%s) cannot be null, empty or contain (*).", str);
            zzx.zzb(str2 != null && !str2.contains("*"), "type(%s) cannot be null or contain (*).", str2);
            return zzS(str, str2);
        }
    }

    MessageFilter(int i, List<MessageType> list, List<NearbyDeviceFilter> list2, boolean z) {
        this.mVersionCode = i;
        this.zzbbB = Collections.unmodifiableList((List) zzx.zzz(list));
        this.zzbbD = z;
        this.zzbbC = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
    }

    private MessageFilter(List<MessageType> list, List<NearbyDeviceFilter> list2, boolean z) {
        this(1, list, list2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof MessageFilter)) {
                return false;
            }
            MessageFilter messageFilter = (MessageFilter) obj;
            if (this.zzbbD != messageFilter.zzbbD || !zzw.equal(this.zzbbB, messageFilter.zzbbB) || !zzw.equal(this.zzbbC, messageFilter.zzbbC)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbB, this.zzbbC, Boolean.valueOf(this.zzbbD));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzbbD + ", messageTypes=" + this.zzbbB + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public List<MessageType> zzEo() {
        return this.zzbbB;
    }

    /* access modifiers changed from: package-private */
    public boolean zzEp() {
        return this.zzbbD;
    }

    /* access modifiers changed from: package-private */
    public List<NearbyDeviceFilter> zzEq() {
        return this.zzbbC;
    }
}
