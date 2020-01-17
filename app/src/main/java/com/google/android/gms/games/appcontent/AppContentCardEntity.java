package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList<AppContentAnnotationEntity> zzaDF;
    private final int zzaDG;
    private final String zzaDH;
    private final int zzaDI;
    private final ArrayList<AppContentConditionEntity> zzaDv;
    private final String zzaDw;
    private final String zzapg;
    private final String zzaxl;
    private final String zzyv;

    AppContentCardEntity(int i, ArrayList<AppContentActionEntity> arrayList, ArrayList<AppContentAnnotationEntity> arrayList2, ArrayList<AppContentConditionEntity> arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.mVersionCode = i;
        this.mActions = arrayList;
        this.zzaDF = arrayList2;
        this.zzaDv = arrayList3;
        this.zzaDw = str;
        this.zzaDG = i2;
        this.zzaxl = str2;
        this.mExtras = bundle;
        this.zzyv = str6;
        this.zzaDH = str3;
        this.zzapg = str4;
        this.zzaDI = i3;
        this.zzJN = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        this.mVersionCode = 4;
        this.zzaDw = appContentCard.zzvQ();
        this.zzaDG = appContentCard.zzwb();
        this.zzaxl = appContentCard.getDescription();
        this.mExtras = appContentCard.getExtras();
        this.zzyv = appContentCard.getId();
        this.zzapg = appContentCard.getTitle();
        this.zzaDH = appContentCard.zzwc();
        this.zzaDI = appContentCard.zzwd();
        this.zzJN = appContentCard.getType();
        List<AppContentAction> actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) actions.get(i).freeze());
        }
        List<AppContentAnnotation> zzwa = appContentCard.zzwa();
        int size2 = zzwa.size();
        this.zzaDF = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaDF.add((AppContentAnnotationEntity) zzwa.get(i2).freeze());
        }
        List<AppContentCondition> zzvP = appContentCard.zzvP();
        int size3 = zzvP.size();
        this.zzaDv = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaDv.add((AppContentConditionEntity) zzvP.get(i3).freeze());
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzwa(), appContentCard.zzvP(), appContentCard.zzvQ(), Integer.valueOf(appContentCard.zzwb()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzwc(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzwd()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard != obj) {
            AppContentCard appContentCard2 = (AppContentCard) obj;
            if (!zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) || !zzw.equal(appContentCard2.zzwa(), appContentCard.zzwa()) || !zzw.equal(appContentCard2.zzvP(), appContentCard.zzvP()) || !zzw.equal(appContentCard2.zzvQ(), appContentCard.zzvQ()) || !zzw.equal(Integer.valueOf(appContentCard2.zzwb()), Integer.valueOf(appContentCard.zzwb())) || !zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) || !zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) || !zzw.equal(appContentCard2.getId(), appContentCard.getId()) || !zzw.equal(appContentCard2.zzwc(), appContentCard.zzwc()) || !zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) || !zzw.equal(Integer.valueOf(appContentCard2.zzwd()), Integer.valueOf(appContentCard.zzwd())) || !zzw.equal(appContentCard2.getType(), appContentCard.getType())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzy(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzwa()).zzg("Conditions", appContentCard.zzvP()).zzg("ContentDescription", appContentCard.zzvQ()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzwb())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzwc()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzwd())).zzg("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public String getType() {
        return this.zzJN;
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    public List<AppContentCondition> zzvP() {
        return new ArrayList(this.zzaDv);
    }

    public String zzvQ() {
        return this.zzaDw;
    }

    public List<AppContentAnnotation> zzwa() {
        return new ArrayList(this.zzaDF);
    }

    public int zzwb() {
        return this.zzaDG;
    }

    public String zzwc() {
        return this.zzaDH;
    }

    public int zzwd() {
        return this.zzaDI;
    }

    /* renamed from: zzwe */
    public AppContentCard freeze() {
        return this;
    }
}
