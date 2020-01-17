package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaDQ;

    AppContentSectionRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.zzaDQ = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "section_data", this.zzaje);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) freeze()).writeToParcel(parcel, i);
    }

    public String zzvQ() {
        return getString("section_content_description");
    }

    public String zzwc() {
        return getString("section_subtitle");
    }

    public String zzwl() {
        return getString("section_card_type");
    }

    /* renamed from: zzwm */
    public AppContentSection freeze() {
        return new AppContentSectionEntity(this);
    }

    /* renamed from: zzwn */
    public ArrayList<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "section_actions", this.zzaje);
    }

    /* renamed from: zzwo */
    public ArrayList<AppContentAnnotation> zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "section_annotations", this.zzaje);
    }

    /* renamed from: zzwp */
    public ArrayList<AppContentCard> zzwk() {
        ArrayList<AppContentCard> arrayList = new ArrayList<>(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new AppContentCardRef(this.zzaDN, this.zzaje + i));
        }
        return arrayList;
    }
}
