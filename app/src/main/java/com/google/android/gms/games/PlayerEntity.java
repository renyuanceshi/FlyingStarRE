package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzms;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private String zzWQ;
    private final long zzaCO;
    private final int zzaCP;
    private final long zzaCQ;
    private final MostRecentGameInfoEntity zzaCR;
    private final PlayerLevelInfo zzaCS;
    private final boolean zzaCT;
    private final boolean zzaCU;
    private final String zzaCV;
    private final Uri zzaCW;
    private final String zzaCX;
    private final Uri zzaCY;
    private final String zzaCZ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private String zzacX;
    private final String zzapg;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        /* renamed from: zzeb */
        public PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.zzd(PlayerEntity.zzqB()) || PlayerEntity.zzcF(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(13, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, (String) null, (String) null, (String) null, (MostRecentGameInfoEntity) null, (PlayerLevelInfo) null, true, false, parcel.readString(), parcel.readString(), (Uri) null, (String) null, (Uri) null, (String) null);
        }
    }

    PlayerEntity(int i, String str, String str2, Uri uri, Uri uri2, long j, int i2, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9) {
        this.mVersionCode = i;
        this.zzacX = str;
        this.zzWQ = str2;
        this.zzaCd = uri;
        this.zzaCo = str3;
        this.zzaCe = uri2;
        this.zzaCp = str4;
        this.zzaCO = j;
        this.zzaCP = i2;
        this.zzaCQ = j2;
        this.zzapg = str5;
        this.zzaCT = z;
        this.zzaCR = mostRecentGameInfoEntity;
        this.zzaCS = playerLevelInfo;
        this.zzaCU = z2;
        this.zzaCV = str6;
        this.mName = str7;
        this.zzaCW = uri3;
        this.zzaCX = str8;
        this.zzaCY = uri4;
        this.zzaCZ = str9;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean z) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.mVersionCode = 13;
        this.zzacX = z ? player.getPlayerId() : null;
        this.zzWQ = player.getDisplayName();
        this.zzaCd = player.getIconImageUri();
        this.zzaCo = player.getIconImageUrl();
        this.zzaCe = player.getHiResImageUri();
        this.zzaCp = player.getHiResImageUrl();
        this.zzaCO = player.getRetrievedTimestamp();
        this.zzaCP = player.zzvG();
        this.zzaCQ = player.getLastPlayedWithTimestamp();
        this.zzapg = player.getTitle();
        this.zzaCT = player.zzvH();
        MostRecentGameInfo zzvI = player.zzvI();
        this.zzaCR = zzvI != null ? new MostRecentGameInfoEntity(zzvI) : mostRecentGameInfoEntity;
        this.zzaCS = player.getLevelInfo();
        this.zzaCU = player.zzvF();
        this.zzaCV = player.zzvE();
        this.mName = player.getName();
        this.zzaCW = player.getBannerImageLandscapeUri();
        this.zzaCX = player.getBannerImageLandscapeUrl();
        this.zzaCY = player.getBannerImagePortraitUri();
        this.zzaCZ = player.getBannerImagePortraitUrl();
        if (z) {
            zzb.zzv(this.zzacX);
        }
        zzb.zzv(this.zzWQ);
        zzb.zzab(this.zzaCO > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player != obj) {
            Player player2 = (Player) obj;
            if (!zzw.equal(player2.getPlayerId(), player.getPlayerId()) || !zzw.equal(player2.getDisplayName(), player.getDisplayName()) || !zzw.equal(Boolean.valueOf(player2.zzvF()), Boolean.valueOf(player.zzvF())) || !zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) || !zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) || !zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) || !zzw.equal(player2.getTitle(), player.getTitle()) || !zzw.equal(player2.getLevelInfo(), player.getLevelInfo()) || !zzw.equal(player2.zzvE(), player.zzvE()) || !zzw.equal(player2.getName(), player.getName()) || !zzw.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) || !zzw.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri())) {
                return false;
            }
        }
        return true;
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzvF()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzvE(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri());
    }

    static String zzc(Player player) {
        return zzw.zzy(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzvF())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zzvE()).zzg("Name", player.getName()).zzg("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", player.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public Uri getBannerImageLandscapeUri() {
        return this.zzaCW;
    }

    public String getBannerImageLandscapeUrl() {
        return this.zzaCX;
    }

    public Uri getBannerImagePortraitUri() {
        return this.zzaCY;
    }

    public String getBannerImagePortraitUrl() {
        return this.zzaCZ;
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzWQ, charArrayBuffer);
    }

    public Uri getHiResImageUri() {
        return this.zzaCe;
    }

    public String getHiResImageUrl() {
        return this.zzaCp;
    }

    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    public String getIconImageUrl() {
        return this.zzaCo;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzaCQ;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    public String getName() {
        return this.mName;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public long getRetrievedTimestamp() {
        return this.zzaCO;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public void getTitle(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzapg, charArrayBuffer);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        if (!zzqC()) {
            PlayerEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzacX);
        parcel.writeString(this.zzWQ);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        if (this.zzaCe != null) {
            str = this.zzaCe.toString();
        }
        parcel.writeString(str);
        parcel.writeLong(this.zzaCO);
    }

    public String zzvE() {
        return this.zzaCV;
    }

    public boolean zzvF() {
        return this.zzaCU;
    }

    public int zzvG() {
        return this.zzaCP;
    }

    public boolean zzvH() {
        return this.zzaCT;
    }

    public MostRecentGameInfo zzvI() {
        return this.zzaCR;
    }
}
