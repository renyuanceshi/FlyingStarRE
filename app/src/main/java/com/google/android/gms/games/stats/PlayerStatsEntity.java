package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
    private final int mVersionCode;
    private final float zzaLd;
    private final float zzaLe;
    private final int zzaLf;
    private final int zzaLg;
    private final int zzaLh;
    private final float zzaLi;
    private final float zzaLj;
    private final Bundle zzaLk;
    private final float zzaLl;

    PlayerStatsEntity(int i, float f, float f2, int i2, int i3, int i4, float f3, float f4, Bundle bundle, float f5) {
        this.mVersionCode = i;
        this.zzaLd = f;
        this.zzaLe = f2;
        this.zzaLf = i2;
        this.zzaLg = i3;
        this.zzaLh = i4;
        this.zzaLi = f3;
        this.zzaLj = f4;
        this.zzaLk = bundle;
        this.zzaLl = f5;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.mVersionCode = 3;
        this.zzaLd = playerStats.getAverageSessionLength();
        this.zzaLe = playerStats.getChurnProbability();
        this.zzaLf = playerStats.getDaysSinceLastPlayed();
        this.zzaLg = playerStats.getNumberOfPurchases();
        this.zzaLh = playerStats.getNumberOfSessions();
        this.zzaLi = playerStats.getSessionPercentile();
        this.zzaLj = playerStats.getSpendPercentile();
        this.zzaLl = playerStats.getSpendProbability();
        this.zzaLk = playerStats.zzxV();
    }

    static int zza(PlayerStats playerStats) {
        return zzw.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()));
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats != obj) {
            PlayerStats playerStats2 = (PlayerStats) obj;
            if (!zzw.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) || !zzw.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) || !zzw.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) || !zzw.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) || !zzw.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) || !zzw.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) || !zzw.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) || !zzw.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability()))) {
                return false;
            }
        }
        return true;
    }

    static String zzb(PlayerStats playerStats) {
        return zzw.zzy(playerStats).zzg("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).zzg("SpendProbability", Float.valueOf(playerStats.getSpendProbability())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public float getAverageSessionLength() {
        return this.zzaLd;
    }

    public float getChurnProbability() {
        return this.zzaLe;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzaLf;
    }

    public int getNumberOfPurchases() {
        return this.zzaLg;
    }

    public int getNumberOfSessions() {
        return this.zzaLh;
    }

    public float getSessionPercentile() {
        return this.zzaLi;
    }

    public float getSpendPercentile() {
        return this.zzaLj;
    }

    public float getSpendProbability() {
        return this.zzaLl;
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
        PlayerStatsEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzxV() {
        return this.zzaLk;
    }

    /* renamed from: zzxW */
    public PlayerStats freeze() {
        return this;
    }
}
