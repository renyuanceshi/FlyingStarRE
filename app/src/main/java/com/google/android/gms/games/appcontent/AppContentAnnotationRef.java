package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> arrayList, int i) {
        super(arrayList, 2, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    public String getDescription() {
        return getString("annotation_description");
    }

    public String getId() {
        return getString("annotation_id");
    }

    public String getTitle() {
        return getString("annotation_title");
    }

    public int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((AppContentAnnotationEntity) freeze()).writeToParcel(parcel, i);
    }

    public String zzvT() {
        return getString("annotation_image_default_id");
    }

    public int zzvU() {
        return getInteger("annotation_image_height");
    }

    public Uri zzvV() {
        return zzcA("annotation_image_uri");
    }

    public Bundle zzvW() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "annotation_modifiers", this.zzaje);
    }

    public int zzvX() {
        return getInteger("annotation_image_width");
    }

    public String zzvY() {
        return getString("annotation_layout_slot");
    }

    /* renamed from: zzvZ */
    public AppContentAnnotation freeze() {
        return new AppContentAnnotationEntity(this);
    }
}
