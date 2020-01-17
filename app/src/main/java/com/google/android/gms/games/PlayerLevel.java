package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevel implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();
    private final int mVersionCode;
    private final int zzaDa;
    private final long zzaDb;
    private final long zzaDc;

    PlayerLevel(int i, int i2, long j, long j2) {
        boolean z = true;
        zzx.zza(j >= 0, (Object) "Min XP must be positive!");
        zzx.zza(j2 <= j ? false : z, (Object) "Max XP must be more than min XP!");
        this.mVersionCode = i;
        this.zzaDa = i2;
        this.zzaDb = j;
        this.zzaDc = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this != obj) {
            PlayerLevel playerLevel = (PlayerLevel) obj;
            if (!zzw.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) || !zzw.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) || !zzw.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()))) {
                return false;
            }
        }
        return true;
    }

    public int getLevelNumber() {
        return this.zzaDa;
    }

    public long getMaxXp() {
        return this.zzaDc;
    }

    public long getMinXp() {
        return this.zzaDb;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaDa), Long.valueOf(this.zzaDb), Long.valueOf(this.zzaDc));
    }

    public String toString() {
        return zzw.zzy(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.zza(this, parcel, i);
    }
}
