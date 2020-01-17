package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class PersonEntity extends FastSafeParcelableJsonResponse implements Person {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    final int mVersionCode;
    String zzF;
    String zzWQ;
    String zzaaL;
    final Set<Integer> zzbeN;
    String zzbfL;
    AgeRangeEntity zzbfM;
    String zzbfN;
    String zzbfO;
    int zzbfP;
    CoverEntity zzbfQ;
    String zzbfR;
    ImageEntity zzbfS;
    boolean zzbfT;
    NameEntity zzbfU;
    String zzbfV;
    int zzbfW;
    List<OrganizationsEntity> zzbfX;
    List<PlacesLivedEntity> zzbfY;
    int zzbfZ;
    int zzbga;
    String zzbgb;
    List<UrlsEntity> zzbgc;
    boolean zzbgd;
    int zztT;
    String zzyv;

    public static final class AgeRangeEntity extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final zzb CREATOR = new zzb();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        int zzbge;
        int zzbgf;

        static {
            zzbeM.put("max", FastJsonResponse.Field.zzi("max", 2));
            zzbeM.put("min", FastJsonResponse.Field.zzi("min", 3));
        }

        public AgeRangeEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        AgeRangeEntity(Set<Integer> set, int i, int i2, int i3) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbge = i2;
            this.zzbgf = i3;
        }

        public int describeContents() {
            zzb zzb = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AgeRangeEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            AgeRangeEntity ageRangeEntity = (AgeRangeEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!ageRangeEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(ageRangeEntity.zzb(next))) {
                        return false;
                    }
                } else if (ageRangeEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public int getMax() {
            return this.zzbge;
        }

        public int getMin() {
            return this.zzbgf;
        }

        public boolean hasMax() {
            return this.zzbeN.contains(2);
        }

        public boolean hasMin() {
            return this.zzbeN.contains(3);
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

        /* renamed from: zzFq */
        public AgeRangeEntity freeze() {
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
                    return Integer.valueOf(this.zzbge);
                case 3:
                    return Integer.valueOf(this.zzbgf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class CoverEntity extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final zzc CREATOR = new zzc();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        CoverInfoEntity zzbgg;
        CoverPhotoEntity zzbgh;
        int zzbgi;

        public static final class CoverInfoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final zzd CREATOR = new zzd();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
            final int mVersionCode;
            final Set<Integer> zzbeN;
            int zzbgj;
            int zzbgk;

            static {
                zzbeM.put("leftImageOffset", FastJsonResponse.Field.zzi("leftImageOffset", 2));
                zzbeM.put("topImageOffset", FastJsonResponse.Field.zzi("topImageOffset", 3));
            }

            public CoverInfoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverInfoEntity(Set<Integer> set, int i, int i2, int i3) {
                this.zzbeN = set;
                this.mVersionCode = i;
                this.zzbgj = i2;
                this.zzbgk = i3;
            }

            public int describeContents() {
                zzd zzd = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverInfoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverInfoEntity coverInfoEntity = (CoverInfoEntity) obj;
                for (FastJsonResponse.Field next : zzbeM.values()) {
                    if (zza(next)) {
                        if (!coverInfoEntity.zza(next)) {
                            return false;
                        }
                        if (!zzb(next).equals(coverInfoEntity.zzb(next))) {
                            return false;
                        }
                    } else if (coverInfoEntity.zza(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getLeftImageOffset() {
                return this.zzbgj;
            }

            public int getTopImageOffset() {
                return this.zzbgk;
            }

            public boolean hasLeftImageOffset() {
                return this.zzbeN.contains(2);
            }

            public boolean hasTopImageOffset() {
                return this.zzbeN.contains(3);
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
                zzd zzd = CREATOR;
                zzd.zza(this, parcel, i);
            }

            /* renamed from: zzFl */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
                return zzbeM;
            }

            /* renamed from: zzFs */
            public CoverInfoEntity freeze() {
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
                        return Integer.valueOf(this.zzbgj);
                    case 3:
                        return Integer.valueOf(this.zzbgk);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        public static final class CoverPhotoEntity extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final zze CREATOR = new zze();
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
            final int mVersionCode;
            String zzF;
            final Set<Integer> zzbeN;
            int zzoG;
            int zzoH;

            static {
                zzbeM.put("height", FastJsonResponse.Field.zzi("height", 2));
                zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                zzbeM.put("width", FastJsonResponse.Field.zzi("width", 4));
            }

            public CoverPhotoEntity() {
                this.mVersionCode = 1;
                this.zzbeN = new HashSet();
            }

            CoverPhotoEntity(Set<Integer> set, int i, int i2, String str, int i3) {
                this.zzbeN = set;
                this.mVersionCode = i;
                this.zzoH = i2;
                this.zzF = str;
                this.zzoG = i3;
            }

            public int describeContents() {
                zze zze = CREATOR;
                return 0;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof CoverPhotoEntity)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                CoverPhotoEntity coverPhotoEntity = (CoverPhotoEntity) obj;
                for (FastJsonResponse.Field next : zzbeM.values()) {
                    if (zza(next)) {
                        if (!coverPhotoEntity.zza(next)) {
                            return false;
                        }
                        if (!zzb(next).equals(coverPhotoEntity.zzb(next))) {
                            return false;
                        }
                    } else if (coverPhotoEntity.zza(next)) {
                        return false;
                    }
                }
                return true;
            }

            public int getHeight() {
                return this.zzoH;
            }

            public String getUrl() {
                return this.zzF;
            }

            public int getWidth() {
                return this.zzoG;
            }

            public boolean hasHeight() {
                return this.zzbeN.contains(2);
            }

            public boolean hasUrl() {
                return this.zzbeN.contains(3);
            }

            public boolean hasWidth() {
                return this.zzbeN.contains(4);
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
                zze zze = CREATOR;
                zze.zza(this, parcel, i);
            }

            /* renamed from: zzFl */
            public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
                return zzbeM;
            }

            /* renamed from: zzFt */
            public CoverPhotoEntity freeze() {
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
                        return Integer.valueOf(this.zzoH);
                    case 3:
                        return this.zzF;
                    case 4:
                        return Integer.valueOf(this.zzoG);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
                }
            }
        }

        static {
            zzbeM.put("coverInfo", FastJsonResponse.Field.zza("coverInfo", 2, CoverInfoEntity.class));
            zzbeM.put("coverPhoto", FastJsonResponse.Field.zza("coverPhoto", 3, CoverPhotoEntity.class));
            zzbeM.put("layout", FastJsonResponse.Field.zza("layout", 4, new StringToIntConverter().zzh("banner", 0), false));
        }

        public CoverEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        CoverEntity(Set<Integer> set, int i, CoverInfoEntity coverInfoEntity, CoverPhotoEntity coverPhotoEntity, int i2) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgg = coverInfoEntity;
            this.zzbgh = coverPhotoEntity;
            this.zzbgi = i2;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CoverEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            CoverEntity coverEntity = (CoverEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!coverEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(coverEntity.zzb(next))) {
                        return false;
                    }
                } else if (coverEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public Person.Cover.CoverInfo getCoverInfo() {
            return this.zzbgg;
        }

        public Person.Cover.CoverPhoto getCoverPhoto() {
            return this.zzbgh;
        }

        public int getLayout() {
            return this.zzbgi;
        }

        public boolean hasCoverInfo() {
            return this.zzbeN.contains(2);
        }

        public boolean hasCoverPhoto() {
            return this.zzbeN.contains(3);
        }

        public boolean hasLayout() {
            return this.zzbeN.contains(4);
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
            zzc zzc = CREATOR;
            zzc.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        /* renamed from: zzFr */
        public CoverEntity freeze() {
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
                    return this.zzbgg;
                case 3:
                    return this.zzbgh;
                case 4:
                    return Integer.valueOf(this.zzbgi);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class ImageEntity extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final zzf CREATOR = new zzf();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        String zzF;
        final Set<Integer> zzbeN;

        static {
            zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public ImageEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        public ImageEntity(String str) {
            this.zzbeN = new HashSet();
            this.mVersionCode = 1;
            this.zzF = str;
            this.zzbeN.add(2);
        }

        ImageEntity(Set<Integer> set, int i, String str) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzF = str;
        }

        public int describeContents() {
            zzf zzf = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImageEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageEntity imageEntity = (ImageEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!imageEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(imageEntity.zzb(next))) {
                        return false;
                    }
                } else if (imageEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getUrl() {
            return this.zzF;
        }

        public boolean hasUrl() {
            return this.zzbeN.contains(2);
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
            zzf zzf = CREATOR;
            zzf.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        /* renamed from: zzFu */
        public ImageEntity freeze() {
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
                    return this.zzF;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class NameEntity extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final zzg CREATOR = new zzg();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        final int mVersionCode;
        final Set<Integer> zzbeN;
        String zzbfl;
        String zzbfo;
        String zzbgl;
        String zzbgm;
        String zzbgn;
        String zzbgo;

        static {
            zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 2));
            zzbeM.put("formatted", FastJsonResponse.Field.zzl("formatted", 3));
            zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 4));
            zzbeM.put("honorificPrefix", FastJsonResponse.Field.zzl("honorificPrefix", 5));
            zzbeM.put("honorificSuffix", FastJsonResponse.Field.zzl("honorificSuffix", 6));
            zzbeM.put("middleName", FastJsonResponse.Field.zzl("middleName", 7));
        }

        public NameEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        NameEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbfl = str;
            this.zzbgl = str2;
            this.zzbfo = str3;
            this.zzbgm = str4;
            this.zzbgn = str5;
            this.zzbgo = str6;
        }

        public int describeContents() {
            zzg zzg = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NameEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            NameEntity nameEntity = (NameEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!nameEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(nameEntity.zzb(next))) {
                        return false;
                    }
                } else if (nameEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getFamilyName() {
            return this.zzbfl;
        }

        public String getFormatted() {
            return this.zzbgl;
        }

        public String getGivenName() {
            return this.zzbfo;
        }

        public String getHonorificPrefix() {
            return this.zzbgm;
        }

        public String getHonorificSuffix() {
            return this.zzbgn;
        }

        public String getMiddleName() {
            return this.zzbgo;
        }

        public boolean hasFamilyName() {
            return this.zzbeN.contains(2);
        }

        public boolean hasFormatted() {
            return this.zzbeN.contains(3);
        }

        public boolean hasGivenName() {
            return this.zzbeN.contains(4);
        }

        public boolean hasHonorificPrefix() {
            return this.zzbeN.contains(5);
        }

        public boolean hasHonorificSuffix() {
            return this.zzbeN.contains(6);
        }

        public boolean hasMiddleName() {
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
            zzg zzg = CREATOR;
            zzg.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        /* renamed from: zzFv */
        public NameEntity freeze() {
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
                    return this.zzbfl;
                case 3:
                    return this.zzbgl;
                case 4:
                    return this.zzbfo;
                case 5:
                    return this.zzbgm;
                case 6:
                    return this.zzbgn;
                case 7:
                    return this.zzbgo;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class OrganizationsEntity extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final zzh CREATOR = new zzh();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mName;
        final int mVersionCode;
        int zzabB;
        String zzapg;
        String zzaxl;
        final Set<Integer> zzbeN;
        String zzbfA;
        String zzbfk;
        String zzbgp;
        String zzbgq;
        boolean zzbgr;

        static {
            zzbeM.put("department", FastJsonResponse.Field.zzl("department", 2));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 4));
            zzbeM.put("location", FastJsonResponse.Field.zzl("location", 5));
            zzbeM.put("name", FastJsonResponse.Field.zzl("name", 6));
            zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 7));
            zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 8));
            zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            zzbeM.put("type", FastJsonResponse.Field.zza("type", 10, new StringToIntConverter().zzh("work", 0).zzh("school", 1), false));
        }

        public OrganizationsEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        OrganizationsEntity(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgp = str;
            this.zzaxl = str2;
            this.zzbfk = str3;
            this.zzbgq = str4;
            this.mName = str5;
            this.zzbgr = z;
            this.zzbfA = str6;
            this.zzapg = str7;
            this.zzabB = i2;
        }

        public int describeContents() {
            zzh zzh = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OrganizationsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            OrganizationsEntity organizationsEntity = (OrganizationsEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!organizationsEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(organizationsEntity.zzb(next))) {
                        return false;
                    }
                } else if (organizationsEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getDepartment() {
            return this.zzbgp;
        }

        public String getDescription() {
            return this.zzaxl;
        }

        public String getEndDate() {
            return this.zzbfk;
        }

        public String getLocation() {
            return this.zzbgq;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.zzbfA;
        }

        public String getTitle() {
            return this.zzapg;
        }

        public int getType() {
            return this.zzabB;
        }

        public boolean hasDepartment() {
            return this.zzbeN.contains(2);
        }

        public boolean hasDescription() {
            return this.zzbeN.contains(3);
        }

        public boolean hasEndDate() {
            return this.zzbeN.contains(4);
        }

        public boolean hasLocation() {
            return this.zzbeN.contains(5);
        }

        public boolean hasName() {
            return this.zzbeN.contains(6);
        }

        public boolean hasPrimary() {
            return this.zzbeN.contains(7);
        }

        public boolean hasStartDate() {
            return this.zzbeN.contains(8);
        }

        public boolean hasTitle() {
            return this.zzbeN.contains(9);
        }

        public boolean hasType() {
            return this.zzbeN.contains(10);
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

        public boolean isPrimary() {
            return this.zzbgr;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzh zzh = CREATOR;
            zzh.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        /* renamed from: zzFw */
        public OrganizationsEntity freeze() {
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
                    return this.zzbgp;
                case 3:
                    return this.zzaxl;
                case 4:
                    return this.zzbfk;
                case 5:
                    return this.zzbgq;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.zzbgr);
                case 8:
                    return this.zzbfA;
                case 9:
                    return this.zzapg;
                case 10:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class PlacesLivedEntity extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final zzi CREATOR = new zzi();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mValue;
        final int mVersionCode;
        final Set<Integer> zzbeN;
        boolean zzbgr;

        static {
            zzbeM.put("primary", FastJsonResponse.Field.zzk("primary", 2));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 3));
        }

        public PlacesLivedEntity() {
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        PlacesLivedEntity(Set<Integer> set, int i, boolean z, String str) {
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzbgr = z;
            this.mValue = str;
        }

        public int describeContents() {
            zzi zzi = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlacesLivedEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PlacesLivedEntity placesLivedEntity = (PlacesLivedEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!placesLivedEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(placesLivedEntity.zzb(next))) {
                        return false;
                    }
                } else if (placesLivedEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasPrimary() {
            return this.zzbeN.contains(2);
        }

        public boolean hasValue() {
            return this.zzbeN.contains(3);
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

        public boolean isPrimary() {
            return this.zzbgr;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzi zzi = CREATOR;
            zzi.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        /* renamed from: zzFx */
        public PlacesLivedEntity freeze() {
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
                    return Boolean.valueOf(this.zzbgr);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static final class UrlsEntity extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final zzj CREATOR = new zzj();
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
        String mValue;
        final int mVersionCode;
        String zzaUO;
        int zzabB;
        final Set<Integer> zzbeN;
        private final int zzbgs;

        static {
            zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            zzbeM.put("type", FastJsonResponse.Field.zza("type", 6, new StringToIntConverter().zzh("home", 0).zzh("work", 1).zzh("blog", 2).zzh(Scopes.PROFILE, 3).zzh(FitnessActivities.OTHER, 4).zzh("otherProfile", 5).zzh("contributor", 6).zzh("website", 7), false));
            zzbeM.put("value", FastJsonResponse.Field.zzl("value", 4));
        }

        public UrlsEntity() {
            this.zzbgs = 4;
            this.mVersionCode = 1;
            this.zzbeN = new HashSet();
        }

        UrlsEntity(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.zzbgs = 4;
            this.zzbeN = set;
            this.mVersionCode = i;
            this.zzaUO = str;
            this.zzabB = i2;
            this.mValue = str2;
        }

        public int describeContents() {
            zzj zzj = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UrlsEntity)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            UrlsEntity urlsEntity = (UrlsEntity) obj;
            for (FastJsonResponse.Field next : zzbeM.values()) {
                if (zza(next)) {
                    if (!urlsEntity.zza(next)) {
                        return false;
                    }
                    if (!zzb(next).equals(urlsEntity.zzb(next))) {
                        return false;
                    }
                } else if (urlsEntity.zza(next)) {
                    return false;
                }
            }
            return true;
        }

        public String getLabel() {
            return this.zzaUO;
        }

        public int getType() {
            return this.zzabB;
        }

        public String getValue() {
            return this.mValue;
        }

        public boolean hasLabel() {
            return this.zzbeN.contains(5);
        }

        public boolean hasType() {
            return this.zzbeN.contains(6);
        }

        public boolean hasValue() {
            return this.zzbeN.contains(4);
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
            zzj zzj = CREATOR;
            zzj.zza(this, parcel, i);
        }

        /* renamed from: zzFl */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
            return zzbeM;
        }

        @Deprecated
        public int zzFy() {
            return 4;
        }

        /* renamed from: zzFz */
        public UrlsEntity freeze() {
            return this;
        }

        /* access modifiers changed from: protected */
        public boolean zza(FastJsonResponse.Field field) {
            return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
        }

        /* access modifiers changed from: protected */
        public Object zzb(FastJsonResponse.Field field) {
            switch (field.zzrs()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.zzaUO;
                case 6:
                    return Integer.valueOf(this.zzabB);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            }
        }
    }

    public static class zza {
        public static int zzfH(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    static {
        zzbeM.put("aboutMe", FastJsonResponse.Field.zzl("aboutMe", 2));
        zzbeM.put("ageRange", FastJsonResponse.Field.zza("ageRange", 3, AgeRangeEntity.class));
        zzbeM.put("birthday", FastJsonResponse.Field.zzl("birthday", 4));
        zzbeM.put("braggingRights", FastJsonResponse.Field.zzl("braggingRights", 5));
        zzbeM.put("circledByCount", FastJsonResponse.Field.zzi("circledByCount", 6));
        zzbeM.put("cover", FastJsonResponse.Field.zza("cover", 7, CoverEntity.class));
        zzbeM.put("currentLocation", FastJsonResponse.Field.zzl("currentLocation", 8));
        zzbeM.put("displayName", FastJsonResponse.Field.zzl("displayName", 9));
        zzbeM.put("gender", FastJsonResponse.Field.zza("gender", 12, new StringToIntConverter().zzh("male", 0).zzh("female", 1).zzh(FitnessActivities.OTHER, 2), false));
        zzbeM.put("id", FastJsonResponse.Field.zzl("id", 14));
        zzbeM.put("image", FastJsonResponse.Field.zza("image", 15, ImageEntity.class));
        zzbeM.put("isPlusUser", FastJsonResponse.Field.zzk("isPlusUser", 16));
        zzbeM.put("language", FastJsonResponse.Field.zzl("language", 18));
        zzbeM.put("name", FastJsonResponse.Field.zza("name", 19, NameEntity.class));
        zzbeM.put("nickname", FastJsonResponse.Field.zzl("nickname", 20));
        zzbeM.put("objectType", FastJsonResponse.Field.zza("objectType", 21, new StringToIntConverter().zzh("person", 0).zzh("page", 1), false));
        zzbeM.put("organizations", FastJsonResponse.Field.zzb("organizations", 22, OrganizationsEntity.class));
        zzbeM.put("placesLived", FastJsonResponse.Field.zzb("placesLived", 23, PlacesLivedEntity.class));
        zzbeM.put("plusOneCount", FastJsonResponse.Field.zzi("plusOneCount", 24));
        zzbeM.put("relationshipStatus", FastJsonResponse.Field.zza("relationshipStatus", 25, new StringToIntConverter().zzh("single", 0).zzh("in_a_relationship", 1).zzh("engaged", 2).zzh("married", 3).zzh("its_complicated", 4).zzh("open_relationship", 5).zzh("widowed", 6).zzh("in_domestic_partnership", 7).zzh("in_civil_union", 8), false));
        zzbeM.put("tagline", FastJsonResponse.Field.zzl("tagline", 26));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        zzbeM.put("urls", FastJsonResponse.Field.zzb("urls", 28, UrlsEntity.class));
        zzbeM.put("verified", FastJsonResponse.Field.zzk("verified", 29));
    }

    public PersonEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    public PersonEntity(String str, String str2, ImageEntity imageEntity, int i, String str3) {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
        this.zzWQ = str;
        this.zzbeN.add(9);
        this.zzyv = str2;
        this.zzbeN.add(14);
        this.zzbfS = imageEntity;
        this.zzbeN.add(15);
        this.zzbfW = i;
        this.zzbeN.add(21);
        this.zzF = str3;
        this.zzbeN.add(27);
    }

    PersonEntity(Set<Integer> set, int i, String str, AgeRangeEntity ageRangeEntity, String str2, String str3, int i2, CoverEntity coverEntity, String str4, String str5, int i3, String str6, ImageEntity imageEntity, boolean z, String str7, NameEntity nameEntity, String str8, int i4, List<OrganizationsEntity> list, List<PlacesLivedEntity> list2, int i5, int i6, String str9, String str10, List<UrlsEntity> list3, boolean z2) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzbfL = str;
        this.zzbfM = ageRangeEntity;
        this.zzbfN = str2;
        this.zzbfO = str3;
        this.zzbfP = i2;
        this.zzbfQ = coverEntity;
        this.zzbfR = str4;
        this.zzWQ = str5;
        this.zztT = i3;
        this.zzyv = str6;
        this.zzbfS = imageEntity;
        this.zzbfT = z;
        this.zzaaL = str7;
        this.zzbfU = nameEntity;
        this.zzbfV = str8;
        this.zzbfW = i4;
        this.zzbfX = list;
        this.zzbfY = list2;
        this.zzbfZ = i5;
        this.zzbga = i6;
        this.zzbgb = str9;
        this.zzF = str10;
        this.zzbgc = list3;
        this.zzbgd = z2;
    }

    public static PersonEntity zzv(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        PersonEntity zzgE = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return zzgE;
    }

    public int describeContents() {
        zza zza2 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PersonEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PersonEntity personEntity = (PersonEntity) obj;
        for (FastJsonResponse.Field next : zzbeM.values()) {
            if (zza(next)) {
                if (!personEntity.zza(next)) {
                    return false;
                }
                if (!zzb(next).equals(personEntity.zzb(next))) {
                    return false;
                }
            } else if (personEntity.zza(next)) {
                return false;
            }
        }
        return true;
    }

    public String getAboutMe() {
        return this.zzbfL;
    }

    public Person.AgeRange getAgeRange() {
        return this.zzbfM;
    }

    public String getBirthday() {
        return this.zzbfN;
    }

    public String getBraggingRights() {
        return this.zzbfO;
    }

    public int getCircledByCount() {
        return this.zzbfP;
    }

    public Person.Cover getCover() {
        return this.zzbfQ;
    }

    public String getCurrentLocation() {
        return this.zzbfR;
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public int getGender() {
        return this.zztT;
    }

    public String getId() {
        return this.zzyv;
    }

    public Person.Image getImage() {
        return this.zzbfS;
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public Person.Name getName() {
        return this.zzbfU;
    }

    public String getNickname() {
        return this.zzbfV;
    }

    public int getObjectType() {
        return this.zzbfW;
    }

    public List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.zzbfX;
    }

    public List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.zzbfY;
    }

    public int getPlusOneCount() {
        return this.zzbfZ;
    }

    public int getRelationshipStatus() {
        return this.zzbga;
    }

    public String getTagline() {
        return this.zzbgb;
    }

    public String getUrl() {
        return this.zzF;
    }

    public List<Person.Urls> getUrls() {
        return (ArrayList) this.zzbgc;
    }

    public boolean hasAboutMe() {
        return this.zzbeN.contains(2);
    }

    public boolean hasAgeRange() {
        return this.zzbeN.contains(3);
    }

    public boolean hasBirthday() {
        return this.zzbeN.contains(4);
    }

    public boolean hasBraggingRights() {
        return this.zzbeN.contains(5);
    }

    public boolean hasCircledByCount() {
        return this.zzbeN.contains(6);
    }

    public boolean hasCover() {
        return this.zzbeN.contains(7);
    }

    public boolean hasCurrentLocation() {
        return this.zzbeN.contains(8);
    }

    public boolean hasDisplayName() {
        return this.zzbeN.contains(9);
    }

    public boolean hasGender() {
        return this.zzbeN.contains(12);
    }

    public boolean hasId() {
        return this.zzbeN.contains(14);
    }

    public boolean hasImage() {
        return this.zzbeN.contains(15);
    }

    public boolean hasIsPlusUser() {
        return this.zzbeN.contains(16);
    }

    public boolean hasLanguage() {
        return this.zzbeN.contains(18);
    }

    public boolean hasName() {
        return this.zzbeN.contains(19);
    }

    public boolean hasNickname() {
        return this.zzbeN.contains(20);
    }

    public boolean hasObjectType() {
        return this.zzbeN.contains(21);
    }

    public boolean hasOrganizations() {
        return this.zzbeN.contains(22);
    }

    public boolean hasPlacesLived() {
        return this.zzbeN.contains(23);
    }

    public boolean hasPlusOneCount() {
        return this.zzbeN.contains(24);
    }

    public boolean hasRelationshipStatus() {
        return this.zzbeN.contains(25);
    }

    public boolean hasTagline() {
        return this.zzbeN.contains(26);
    }

    public boolean hasUrl() {
        return this.zzbeN.contains(27);
    }

    public boolean hasUrls() {
        return this.zzbeN.contains(28);
    }

    public boolean hasVerified() {
        return this.zzbeN.contains(29);
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

    public boolean isPlusUser() {
        return this.zzbfT;
    }

    public boolean isVerified() {
        return this.zzbgd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza zza2 = CREATOR;
        zza.zza(this, parcel, i);
    }

    /* renamed from: zzFl */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    /* renamed from: zzFp */
    public PersonEntity freeze() {
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
                return this.zzbfL;
            case 3:
                return this.zzbfM;
            case 4:
                return this.zzbfN;
            case 5:
                return this.zzbfO;
            case 6:
                return Integer.valueOf(this.zzbfP);
            case 7:
                return this.zzbfQ;
            case 8:
                return this.zzbfR;
            case 9:
                return this.zzWQ;
            case 12:
                return Integer.valueOf(this.zztT);
            case 14:
                return this.zzyv;
            case 15:
                return this.zzbfS;
            case 16:
                return Boolean.valueOf(this.zzbfT);
            case 18:
                return this.zzaaL;
            case 19:
                return this.zzbfU;
            case 20:
                return this.zzbfV;
            case 21:
                return Integer.valueOf(this.zzbfW);
            case 22:
                return this.zzbfX;
            case 23:
                return this.zzbfY;
            case 24:
                return Integer.valueOf(this.zzbfZ);
            case 25:
                return Integer.valueOf(this.zzbga);
            case 26:
                return this.zzbgb;
            case 27:
                return this.zzF;
            case 28:
                return this.zzbgc;
            case 29:
                return Boolean.valueOf(this.zzbgd);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }
}
