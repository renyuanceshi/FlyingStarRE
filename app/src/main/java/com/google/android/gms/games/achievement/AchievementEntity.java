package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzaDl;
    private final Uri zzaDm;
    private final String zzaDn;
    private final int zzaDo;
    private final String zzaDp;
    private final PlayerEntity zzaDq;
    private final int zzaDr;
    private final String zzaDs;
    private final long zzaDt;
    private final long zzaDu;
    private final int zzabB;
    private final String zzaxl;

    AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.mVersionCode = i;
        this.zzaDj = str;
        this.zzabB = i2;
        this.mName = str2;
        this.zzaxl = str3;
        this.zzaDk = uri;
        this.zzaDl = str4;
        this.zzaDm = uri2;
        this.zzaDn = str5;
        this.zzaDo = i3;
        this.zzaDp = str6;
        this.zzaDq = playerEntity;
        this.mState = i4;
        this.zzaDr = i5;
        this.zzaDs = str7;
        this.zzaDt = j;
        this.zzaDu = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaDj = achievement.getAchievementId();
        this.zzabB = achievement.getType();
        this.mName = achievement.getName();
        this.zzaxl = achievement.getDescription();
        this.zzaDk = achievement.getUnlockedImageUri();
        this.zzaDl = achievement.getUnlockedImageUrl();
        this.zzaDm = achievement.getRevealedImageUri();
        this.zzaDn = achievement.getRevealedImageUrl();
        this.zzaDq = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaDt = achievement.getLastUpdatedTimestamp();
        this.zzaDu = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaDo = achievement.getTotalSteps();
            this.zzaDp = achievement.getFormattedTotalSteps();
            this.zzaDr = achievement.getCurrentSteps();
            this.zzaDs = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaDo = 0;
            this.zzaDp = null;
            this.zzaDr = 0;
            this.zzaDs = null;
        }
        zzb.zzv(this.zzaDj);
        zzb.zzv(this.zzaxl);
    }

    static int zza(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i2 = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else {
            i = 0;
            i2 = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(i2), Integer.valueOf(i));
    }

    static boolean zza(Achievement achievement, Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement != obj) {
            Achievement achievement2 = (Achievement) obj;
            if (achievement.getType() == 1) {
                z2 = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
                z = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
            } else {
                z = true;
                z2 = true;
            }
            if (!zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) || !zzw.equal(achievement2.getName(), achievement.getName()) || !zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) || !zzw.equal(achievement2.getDescription(), achievement.getDescription()) || !zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) || !zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) || !zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) || !zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) || !z2 || !z) {
                return false;
            }
        }
        return true;
    }

    static String zzb(Achievement achievement) {
        zzw.zza zzg = zzw.zzy(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzaDj;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvM();
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaxl, charArrayBuffer);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvN();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        zzms.zzb(this.zzaDs, charArrayBuffer);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvL();
    }

    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        zzms.zzb(this.zzaDp, charArrayBuffer);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.mName, charArrayBuffer);
    }

    public Player getPlayer() {
        return this.zzaDq;
    }

    public Uri getRevealedImageUri() {
        return this.zzaDm;
    }

    public String getRevealedImageUrl() {
        return this.zzaDn;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzab(z);
        return zzvK();
    }

    public int getType() {
        return this.zzabB;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaDk;
    }

    public String getUnlockedImageUrl() {
        return this.zzaDl;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzaDu;
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
        AchievementEntityCreator.zza(this, parcel, i);
    }

    public int zzvK() {
        return this.zzaDo;
    }

    public String zzvL() {
        return this.zzaDp;
    }

    public int zzvM() {
        return this.zzaDr;
    }

    public String zzvN() {
        return this.zzaDs;
    }
}
