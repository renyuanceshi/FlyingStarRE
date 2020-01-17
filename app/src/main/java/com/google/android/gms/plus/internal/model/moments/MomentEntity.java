package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    final int mVersionCode;
    String zzJN;
    final Set<Integer> zzbeN;
    String zzbfA;
    ItemScopeEntity zzbfI;
    ItemScopeEntity zzbfJ;
    String zzyv;

    static {
        zzbeM.put("id", FastJsonResponse.Field.zzl("id", 2));
        zzbeM.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
        zzbeM.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
        zzbeM.put("type", FastJsonResponse.Field.zzl("type", 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    MomentEntity(Set<Integer> set, int i, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzyv = str;
        this.zzbfI = itemScopeEntity;
        this.zzbfA = str2;
        this.zzbfJ = itemScopeEntity2;
        this.zzJN = str3;
    }

    public MomentEntity(Set<Integer> set, String str, ItemScopeEntity itemScopeEntity, String str2, ItemScopeEntity itemScopeEntity2, String str3) {
        this.zzbeN = set;
        this.mVersionCode = 1;
        this.zzyv = str;
        this.zzbfI = itemScopeEntity;
        this.zzbfA = str2;
        this.zzbfJ = itemScopeEntity2;
        this.zzJN = str3;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field next : zzbeM.values()) {
            if (zza(next)) {
                if (!momentEntity.zza(next)) {
                    return false;
                }
                if (!zzb(next).equals(momentEntity.zzb(next))) {
                    return false;
                }
            } else if (momentEntity.zza(next)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.zzyv;
    }

    public ItemScope getResult() {
        return this.zzbfI;
    }

    public String getStartDate() {
        return this.zzbfA;
    }

    public ItemScope getTarget() {
        return this.zzbfJ;
    }

    public String getType() {
        return this.zzJN;
    }

    public boolean hasId() {
        return this.zzbeN.contains(2);
    }

    public boolean hasResult() {
        return this.zzbeN.contains(4);
    }

    public boolean hasStartDate() {
        return this.zzbeN.contains(5);
    }

    public boolean hasTarget() {
        return this.zzbeN.contains(6);
    }

    public boolean hasType() {
        return this.zzbeN.contains(7);
    }

    public int hashCode() {
        Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            FastJsonResponse.Field next = it.next();
            if (zza(next)) {
                i = zzb(next).hashCode() + i2 + next.zzrs();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }

    /* renamed from: zzFl */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    /* renamed from: zzFn */
    public MomentEntity freeze() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    /* access modifiers changed from: protected */
    public Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzyv;
            case 4:
                return this.zzbfI;
            case 5:
                return this.zzbfA;
            case 6:
                return this.zzbfJ;
            case 7:
                return this.zzJN;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }
}
