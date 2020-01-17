package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 4, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    public int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentConditionEntity) freeze()).writeToParcel(parcel, i);
    }

    public String zzwf() {
        return getString("condition_default_value");
    }

    public String zzwg() {
        return getString("condition_expected_value");
    }

    public String zzwh() {
        return getString("condition_predicate");
    }

    public Bundle zzwi() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "condition_predicate_parameters", this.zzaje);
    }

    /* renamed from: zzwj */
    public AppContentCondition freeze() {
        return new AppContentConditionEntity(this);
    }
}
