package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    String mName;
    final int mVersionCode;
    String zzF;
    String zzJN;
    double zzaNF;
    double zzaNG;
    String zzaxl;
    final Set<Integer> zzbeN;
    ItemScopeEntity zzbeO;
    List<String> zzbeP;
    ItemScopeEntity zzbeQ;
    String zzbeR;
    String zzbeS;
    String zzbeT;
    List<ItemScopeEntity> zzbeU;
    int zzbeV;
    List<ItemScopeEntity> zzbeW;
    ItemScopeEntity zzbeX;
    List<ItemScopeEntity> zzbeY;
    String zzbeZ;
    String zzbfA;
    String zzbfB;
    String zzbfC;
    ItemScopeEntity zzbfD;
    String zzbfE;
    String zzbfF;
    String zzbfG;
    String zzbfH;
    String zzbfa;
    ItemScopeEntity zzbfb;
    String zzbfc;
    String zzbfd;
    List<ItemScopeEntity> zzbfe;
    String zzbff;
    String zzbfg;
    String zzbfh;
    String zzbfi;
    String zzbfj;
    String zzbfk;
    String zzbfl;
    String zzbfm;
    ItemScopeEntity zzbfn;
    String zzbfo;
    String zzbfp;
    String zzbfq;
    ItemScopeEntity zzbfr;
    ItemScopeEntity zzbfs;
    ItemScopeEntity zzbft;
    List<ItemScopeEntity> zzbfu;
    String zzbfv;
    String zzbfw;
    String zzbfx;
    String zzbfy;
    ItemScopeEntity zzbfz;
    String zztZ;
    String zzyv;

    static {
        zzbeM.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
        zzbeM.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
        zzbeM.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
        zzbeM.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
        zzbeM.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
        zzbeM.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
        zzbeM.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzbeM.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzbeM.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzbeM.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
        zzbeM.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
        zzbeM.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
        zzbeM.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
        zzbeM.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzbeM.put("caption", FastJsonResponse.Field.zzl("caption", 16));
        zzbeM.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
        zzbeM.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
        zzbeM.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzbeM.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
        zzbeM.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
        zzbeM.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzbeM.put("duration", FastJsonResponse.Field.zzl("duration", 24));
        zzbeM.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
        zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
        zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
        zzbeM.put("gender", FastJsonResponse.Field.zzl("gender", 28));
        zzbeM.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
        zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
        zzbeM.put("height", FastJsonResponse.Field.zzl("height", 31));
        zzbeM.put("id", FastJsonResponse.Field.zzl("id", 32));
        zzbeM.put("image", FastJsonResponse.Field.zzl("image", 33));
        zzbeM.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzbeM.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
        zzbeM.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
        zzbeM.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
        zzbeM.put("name", FastJsonResponse.Field.zzl("name", 39));
        zzbeM.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzbeM.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
        zzbeM.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
        zzbeM.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzbeM.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
        zzbeM.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
        zzbeM.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
        zzbeM.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
        zzbeM.put("text", FastJsonResponse.Field.zzl("text", 49));
        zzbeM.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzbeM.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzbeM.put("type", FastJsonResponse.Field.zzl("type", 53));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzbeM.put("width", FastJsonResponse.Field.zzl("width", 55));
        zzbeM.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    ItemScopeEntity(Set<Integer> set, int i, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i2, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzbeO = itemScopeEntity;
        this.zzbeP = list;
        this.zzbeQ = itemScopeEntity2;
        this.zzbeR = str;
        this.zzbeS = str2;
        this.zzbeT = str3;
        this.zzbeU = list2;
        this.zzbeV = i2;
        this.zzbeW = list3;
        this.zzbeX = itemScopeEntity3;
        this.zzbeY = list4;
        this.zzbeZ = str4;
        this.zzbfa = str5;
        this.zzbfb = itemScopeEntity4;
        this.zzbfc = str6;
        this.zzbfd = str7;
        this.zztZ = str8;
        this.zzbfe = list5;
        this.zzbff = str9;
        this.zzbfg = str10;
        this.zzbfh = str11;
        this.zzaxl = str12;
        this.zzbfi = str13;
        this.zzbfj = str14;
        this.zzbfk = str15;
        this.zzbfl = str16;
        this.zzbfm = str17;
        this.zzbfn = itemScopeEntity5;
        this.zzbfo = str18;
        this.zzbfp = str19;
        this.zzyv = str20;
        this.zzbfq = str21;
        this.zzbfr = itemScopeEntity6;
        this.zzaNF = d;
        this.zzbfs = itemScopeEntity7;
        this.zzaNG = d2;
        this.mName = str22;
        this.zzbft = itemScopeEntity8;
        this.zzbfu = list6;
        this.zzbfv = str23;
        this.zzbfw = str24;
        this.zzbfx = str25;
        this.zzbfy = str26;
        this.zzbfz = itemScopeEntity9;
        this.zzbfA = str27;
        this.zzbfB = str28;
        this.zzbfC = str29;
        this.zzbfD = itemScopeEntity10;
        this.zzbfE = str30;
        this.zzbfF = str31;
        this.zzJN = str32;
        this.zzF = str33;
        this.zzbfG = str34;
        this.zzbfH = str35;
    }

    public ItemScopeEntity(Set<Integer> set, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzbeN = set;
        this.mVersionCode = 1;
        this.zzbeO = itemScopeEntity;
        this.zzbeP = list;
        this.zzbeQ = itemScopeEntity2;
        this.zzbeR = str;
        this.zzbeS = str2;
        this.zzbeT = str3;
        this.zzbeU = list2;
        this.zzbeV = i;
        this.zzbeW = list3;
        this.zzbeX = itemScopeEntity3;
        this.zzbeY = list4;
        this.zzbeZ = str4;
        this.zzbfa = str5;
        this.zzbfb = itemScopeEntity4;
        this.zzbfc = str6;
        this.zzbfd = str7;
        this.zztZ = str8;
        this.zzbfe = list5;
        this.zzbff = str9;
        this.zzbfg = str10;
        this.zzbfh = str11;
        this.zzaxl = str12;
        this.zzbfi = str13;
        this.zzbfj = str14;
        this.zzbfk = str15;
        this.zzbfl = str16;
        this.zzbfm = str17;
        this.zzbfn = itemScopeEntity5;
        this.zzbfo = str18;
        this.zzbfp = str19;
        this.zzyv = str20;
        this.zzbfq = str21;
        this.zzbfr = itemScopeEntity6;
        this.zzaNF = d;
        this.zzbfs = itemScopeEntity7;
        this.zzaNG = d2;
        this.mName = str22;
        this.zzbft = itemScopeEntity8;
        this.zzbfu = list6;
        this.zzbfv = str23;
        this.zzbfw = str24;
        this.zzbfx = str25;
        this.zzbfy = str26;
        this.zzbfz = itemScopeEntity9;
        this.zzbfA = str27;
        this.zzbfB = str28;
        this.zzbfC = str29;
        this.zzbfD = itemScopeEntity10;
        this.zzbfE = str30;
        this.zzbfF = str31;
        this.zzJN = str32;
        this.zzF = str33;
        this.zzbfG = str34;
        this.zzbfH = str35;
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field next : zzbeM.values()) {
            if (zza(next)) {
                if (!itemScopeEntity.zza(next)) {
                    return false;
                }
                if (!zzb(next).equals(itemScopeEntity.zzb(next))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(next)) {
                return false;
            }
        }
        return true;
    }

    public ItemScope getAbout() {
        return this.zzbeO;
    }

    public List<String> getAdditionalName() {
        return this.zzbeP;
    }

    public ItemScope getAddress() {
        return this.zzbeQ;
    }

    public String getAddressCountry() {
        return this.zzbeR;
    }

    public String getAddressLocality() {
        return this.zzbeS;
    }

    public String getAddressRegion() {
        return this.zzbeT;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzbeU;
    }

    public int getAttendeeCount() {
        return this.zzbeV;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzbeW;
    }

    public ItemScope getAudio() {
        return this.zzbeX;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzbeY;
    }

    public String getBestRating() {
        return this.zzbeZ;
    }

    public String getBirthDate() {
        return this.zzbfa;
    }

    public ItemScope getByArtist() {
        return this.zzbfb;
    }

    public String getCaption() {
        return this.zzbfc;
    }

    public String getContentSize() {
        return this.zzbfd;
    }

    public String getContentUrl() {
        return this.zztZ;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzbfe;
    }

    public String getDateCreated() {
        return this.zzbff;
    }

    public String getDateModified() {
        return this.zzbfg;
    }

    public String getDatePublished() {
        return this.zzbfh;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public String getDuration() {
        return this.zzbfi;
    }

    public String getEmbedUrl() {
        return this.zzbfj;
    }

    public String getEndDate() {
        return this.zzbfk;
    }

    public String getFamilyName() {
        return this.zzbfl;
    }

    public String getGender() {
        return this.zzbfm;
    }

    public ItemScope getGeo() {
        return this.zzbfn;
    }

    public String getGivenName() {
        return this.zzbfo;
    }

    public String getHeight() {
        return this.zzbfp;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getImage() {
        return this.zzbfq;
    }

    public ItemScope getInAlbum() {
        return this.zzbfr;
    }

    public double getLatitude() {
        return this.zzaNF;
    }

    public ItemScope getLocation() {
        return this.zzbfs;
    }

    public double getLongitude() {
        return this.zzaNG;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzbft;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbfu;
    }

    public String getPlayerType() {
        return this.zzbfv;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzbfw;
    }

    public String getPostalCode() {
        return this.zzbfx;
    }

    public String getRatingValue() {
        return this.zzbfy;
    }

    public ItemScope getReviewRating() {
        return this.zzbfz;
    }

    public String getStartDate() {
        return this.zzbfA;
    }

    public String getStreetAddress() {
        return this.zzbfB;
    }

    public String getText() {
        return this.zzbfC;
    }

    public ItemScope getThumbnail() {
        return this.zzbfD;
    }

    public String getThumbnailUrl() {
        return this.zzbfE;
    }

    public String getTickerSymbol() {
        return this.zzbfF;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzbfG;
    }

    public String getWorstRating() {
        return this.zzbfH;
    }

    public boolean hasAbout() {
        return this.zzbeN.contains(2);
    }

    public boolean hasAdditionalName() {
        return this.zzbeN.contains(3);
    }

    public boolean hasAddress() {
        return this.zzbeN.contains(4);
    }

    public boolean hasAddressCountry() {
        return this.zzbeN.contains(5);
    }

    public boolean hasAddressLocality() {
        return this.zzbeN.contains(6);
    }

    public boolean hasAddressRegion() {
        return this.zzbeN.contains(7);
    }

    public boolean hasAssociated_media() {
        return this.zzbeN.contains(8);
    }

    public boolean hasAttendeeCount() {
        return this.zzbeN.contains(9);
    }

    public boolean hasAttendees() {
        return this.zzbeN.contains(10);
    }

    public boolean hasAudio() {
        return this.zzbeN.contains(11);
    }

    public boolean hasAuthor() {
        return this.zzbeN.contains(12);
    }

    public boolean hasBestRating() {
        return this.zzbeN.contains(13);
    }

    public boolean hasBirthDate() {
        return this.zzbeN.contains(14);
    }

    public boolean hasByArtist() {
        return this.zzbeN.contains(15);
    }

    public boolean hasCaption() {
        return this.zzbeN.contains(16);
    }

    public boolean hasContentSize() {
        return this.zzbeN.contains(17);
    }

    public boolean hasContentUrl() {
        return this.zzbeN.contains(18);
    }

    public boolean hasContributor() {
        return this.zzbeN.contains(19);
    }

    public boolean hasDateCreated() {
        return this.zzbeN.contains(20);
    }

    public boolean hasDateModified() {
        return this.zzbeN.contains(21);
    }

    public boolean hasDatePublished() {
        return this.zzbeN.contains(22);
    }

    public boolean hasDescription() {
        return this.zzbeN.contains(23);
    }

    public boolean hasDuration() {
        return this.zzbeN.contains(24);
    }

    public boolean hasEmbedUrl() {
        return this.zzbeN.contains(25);
    }

    public boolean hasEndDate() {
        return this.zzbeN.contains(26);
    }

    public boolean hasFamilyName() {
        return this.zzbeN.contains(27);
    }

    public boolean hasGender() {
        return this.zzbeN.contains(28);
    }

    public boolean hasGeo() {
        return this.zzbeN.contains(29);
    }

    public boolean hasGivenName() {
        return this.zzbeN.contains(30);
    }

    public boolean hasHeight() {
        return this.zzbeN.contains(31);
    }

    public boolean hasId() {
        return this.zzbeN.contains(32);
    }

    public boolean hasImage() {
        return this.zzbeN.contains(33);
    }

    public boolean hasInAlbum() {
        return this.zzbeN.contains(34);
    }

    public boolean hasLatitude() {
        return this.zzbeN.contains(36);
    }

    public boolean hasLocation() {
        return this.zzbeN.contains(37);
    }

    public boolean hasLongitude() {
        return this.zzbeN.contains(38);
    }

    public boolean hasName() {
        return this.zzbeN.contains(39);
    }

    public boolean hasPartOfTVSeries() {
        return this.zzbeN.contains(40);
    }

    public boolean hasPerformers() {
        return this.zzbeN.contains(41);
    }

    public boolean hasPlayerType() {
        return this.zzbeN.contains(42);
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzbeN.contains(43);
    }

    public boolean hasPostalCode() {
        return this.zzbeN.contains(44);
    }

    public boolean hasRatingValue() {
        return this.zzbeN.contains(45);
    }

    public boolean hasReviewRating() {
        return this.zzbeN.contains(46);
    }

    public boolean hasStartDate() {
        return this.zzbeN.contains(47);
    }

    public boolean hasStreetAddress() {
        return this.zzbeN.contains(48);
    }

    public boolean hasText() {
        return this.zzbeN.contains(49);
    }

    public boolean hasThumbnail() {
        return this.zzbeN.contains(50);
    }

    public boolean hasThumbnailUrl() {
        return this.zzbeN.contains(51);
    }

    public boolean hasTickerSymbol() {
        return this.zzbeN.contains(52);
    }

    public boolean hasType() {
        return this.zzbeN.contains(53);
    }

    public boolean hasUrl() {
        return this.zzbeN.contains(54);
    }

    public boolean hasWidth() {
        return this.zzbeN.contains(55);
    }

    public boolean hasWorstRating() {
        return this.zzbeN.contains(56);
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
        zza zza = CREATOR;
        zza.zza(this, parcel, i);
    }

    /* renamed from: zzFl */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    /* renamed from: zzFm */
    public ItemScopeEntity freeze() {
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
                return this.zzbeO;
            case 3:
                return this.zzbeP;
            case 4:
                return this.zzbeQ;
            case 5:
                return this.zzbeR;
            case 6:
                return this.zzbeS;
            case 7:
                return this.zzbeT;
            case 8:
                return this.zzbeU;
            case 9:
                return Integer.valueOf(this.zzbeV);
            case 10:
                return this.zzbeW;
            case 11:
                return this.zzbeX;
            case 12:
                return this.zzbeY;
            case 13:
                return this.zzbeZ;
            case 14:
                return this.zzbfa;
            case 15:
                return this.zzbfb;
            case 16:
                return this.zzbfc;
            case 17:
                return this.zzbfd;
            case 18:
                return this.zztZ;
            case 19:
                return this.zzbfe;
            case 20:
                return this.zzbff;
            case 21:
                return this.zzbfg;
            case 22:
                return this.zzbfh;
            case 23:
                return this.zzaxl;
            case 24:
                return this.zzbfi;
            case 25:
                return this.zzbfj;
            case 26:
                return this.zzbfk;
            case 27:
                return this.zzbfl;
            case 28:
                return this.zzbfm;
            case 29:
                return this.zzbfn;
            case 30:
                return this.zzbfo;
            case 31:
                return this.zzbfp;
            case 32:
                return this.zzyv;
            case 33:
                return this.zzbfq;
            case 34:
                return this.zzbfr;
            case 36:
                return Double.valueOf(this.zzaNF);
            case 37:
                return this.zzbfs;
            case 38:
                return Double.valueOf(this.zzaNG);
            case 39:
                return this.mName;
            case 40:
                return this.zzbft;
            case 41:
                return this.zzbfu;
            case 42:
                return this.zzbfv;
            case 43:
                return this.zzbfw;
            case 44:
                return this.zzbfx;
            case 45:
                return this.zzbfy;
            case 46:
                return this.zzbfz;
            case 47:
                return this.zzbfA;
            case 48:
                return this.zzbfB;
            case 49:
                return this.zzbfC;
            case 50:
                return this.zzbfD;
            case 51:
                return this.zzbfE;
            case 52:
                return this.zzbfF;
            case 53:
                return this.zzJN;
            case 54:
                return this.zzF;
            case 55:
                return this.zzbfG;
            case 56:
                return this.zzbfH;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
        }
    }
}
