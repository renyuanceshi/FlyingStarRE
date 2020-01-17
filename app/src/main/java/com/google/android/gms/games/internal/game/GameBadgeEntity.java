package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int mVersionCode;
    private Uri zzaCd;
    private int zzabB;
    private String zzapg;
    private String zzaxl;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        /* renamed from: zzen */
        public GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GameBadgeEntity.zzd(GameBadgeEntity.zzqB()) || GameBadgeEntity.zzcF(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.mVersionCode = i;
        this.zzabB = i2;
        this.zzapg = str;
        this.zzaxl = str2;
        this.zzaCd = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.mVersionCode = 1;
        this.zzabB = gameBadge.getType();
        this.zzapg = gameBadge.getTitle();
        this.zzaxl = gameBadge.getDescription();
        this.zzaCd = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge != obj) {
            GameBadge gameBadge2 = (GameBadge) obj;
            if (!zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) || !zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzy(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
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

    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public int getType() {
        return this.zzabB;
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
        if (!zzqC()) {
            GameBadgeEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeInt(this.zzabB);
        parcel.writeString(this.zzapg);
        parcel.writeString(this.zzaxl);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
    }

    /* renamed from: zzxm */
    public GameBadge freeze() {
        return this;
    }
}
