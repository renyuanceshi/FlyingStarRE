package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzaDJ;
    private final String zzaDK;
    private final String zzaDL;
    private final Bundle zzaDM;

    AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaDJ = str;
        this.zzaDK = str2;
        this.zzaDL = str3;
        this.zzaDM = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.mVersionCode = 1;
        this.zzaDJ = appContentCondition.zzwf();
        this.zzaDK = appContentCondition.zzwg();
        this.zzaDL = appContentCondition.zzwh();
        this.zzaDM = appContentCondition.zzwi();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzwf(), appContentCondition.zzwg(), appContentCondition.zzwh(), appContentCondition.zzwi());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition != obj) {
            AppContentCondition appContentCondition2 = (AppContentCondition) obj;
            if (!zzw.equal(appContentCondition2.zzwf(), appContentCondition.zzwf()) || !zzw.equal(appContentCondition2.zzwg(), appContentCondition.zzwg()) || !zzw.equal(appContentCondition2.zzwh(), appContentCondition.zzwh()) || !zzw.equal(appContentCondition2.zzwi(), appContentCondition.zzwi())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzy(appContentCondition).zzg("DefaultValue", appContentCondition.zzwf()).zzg("ExpectedValue", appContentCondition.zzwg()).zzg("Predicate", appContentCondition.zzwh()).zzg("PredicateParameters", appContentCondition.zzwi()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppContentConditionEntityCreator.zza(this, parcel, i);
    }

    public String zzwf() {
        return this.zzaDJ;
    }

    public String zzwg() {
        return this.zzaDK;
    }

    public String zzwh() {
        return this.zzaDL;
    }

    public Bundle zzwi() {
        return this.zzaDM;
    }

    /* renamed from: zzwj */
    public AppContentCondition freeze() {
        return this;
    }
}
