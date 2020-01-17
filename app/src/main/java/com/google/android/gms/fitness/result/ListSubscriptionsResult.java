package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new zzh();
    private final int mVersionCode;
    private final Status zzUX;
    private final List<Subscription> zzaBM;

    ListSubscriptionsResult(int i, List<Subscription> list, Status status) {
        this.mVersionCode = i;
        this.zzaBM = list;
        this.zzUX = status;
    }

    public ListSubscriptionsResult(List<Subscription> list, Status status) {
        this.mVersionCode = 3;
        this.zzaBM = Collections.unmodifiableList(list);
        this.zzUX = (Status) zzx.zzb(status, (Object) "status");
    }

    public static ListSubscriptionsResult zzT(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzUX.equals(listSubscriptionsResult.zzUX) && zzw.equal(this.zzaBM, listSubscriptionsResult.zzaBM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) obj));
    }

    public Status getStatus() {
        return this.zzUX;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzaBM;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (Subscription next : this.zzaBM) {
            if (dataType.equals(next.zzuy())) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaBM);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("subscriptions", this.zzaBM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
