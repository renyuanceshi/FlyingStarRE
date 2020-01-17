package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int mVersionCode;
    private final String zzaDA;
    private final String zzaDB;
    private final int zzaDC;
    private final int zzaDD;
    private final Bundle zzaDE;
    private final Uri zzaDz;
    private final String zzapg;
    private final String zzaxl;
    private final String zzyv;

    AppContentAnnotationEntity(int i, String str, Uri uri, String str2, String str3, String str4, String str5, int i2, int i3, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaxl = str;
        this.zzyv = str3;
        this.zzaDB = str5;
        this.zzaDC = i2;
        this.zzaDz = uri;
        this.zzaDD = i3;
        this.zzaDA = str4;
        this.zzaDE = bundle;
        this.zzapg = str2;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appContentAnnotation) {
        this.mVersionCode = 4;
        this.zzaxl = appContentAnnotation.getDescription();
        this.zzyv = appContentAnnotation.getId();
        this.zzaDB = appContentAnnotation.zzvT();
        this.zzaDC = appContentAnnotation.zzvU();
        this.zzaDz = appContentAnnotation.zzvV();
        this.zzaDD = appContentAnnotation.zzvX();
        this.zzaDA = appContentAnnotation.zzvY();
        this.zzaDE = appContentAnnotation.zzvW();
        this.zzapg = appContentAnnotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzvT(), Integer.valueOf(appContentAnnotation.zzvU()), appContentAnnotation.zzvV(), Integer.valueOf(appContentAnnotation.zzvX()), appContentAnnotation.zzvY(), appContentAnnotation.zzvW(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation != obj) {
            AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
            if (!zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) || !zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) || !zzw.equal(appContentAnnotation2.zzvT(), appContentAnnotation.zzvT()) || !zzw.equal(Integer.valueOf(appContentAnnotation2.zzvU()), Integer.valueOf(appContentAnnotation.zzvU())) || !zzw.equal(appContentAnnotation2.zzvV(), appContentAnnotation.zzvV()) || !zzw.equal(Integer.valueOf(appContentAnnotation2.zzvX()), Integer.valueOf(appContentAnnotation.zzvX())) || !zzw.equal(appContentAnnotation2.zzvY(), appContentAnnotation.zzvY()) || !zzw.equal(appContentAnnotation2.zzvW(), appContentAnnotation.zzvW()) || !zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzy(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzvT()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zzvU())).zzg("ImageUri", appContentAnnotation.zzvV()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzvX())).zzg("LayoutSlot", appContentAnnotation.zzvY()).zzg("Modifiers", appContentAnnotation.zzvW()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getTitle() {
        return this.zzapg;
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
        AppContentAnnotationEntityCreator.zza(this, parcel, i);
    }

    public String zzvT() {
        return this.zzaDB;
    }

    public int zzvU() {
        return this.zzaDC;
    }

    public Uri zzvV() {
        return this.zzaDz;
    }

    public Bundle zzvW() {
        return this.zzaDE;
    }

    public int zzvX() {
        return this.zzaDD;
    }

    public String zzvY() {
        return this.zzaDA;
    }

    /* renamed from: zzvZ */
    public AppContentAnnotation freeze() {
        return this;
    }
}
