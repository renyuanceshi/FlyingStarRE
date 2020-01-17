package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final long zzaJe;
    private final String zzaJf;
    private final String zzaJg;
    private final long zzaJh;
    private final long zzaJi;
    private final String zzaJj;
    private final Uri zzaJk;
    private final Uri zzaJl;
    private final PlayerEntity zzaJm;
    private final String zzaJn;
    private final String zzaJo;
    private final String zzaJp;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.zzaJe = leaderboardScore.getRank();
        this.zzaJf = (String) zzx.zzz(leaderboardScore.getDisplayRank());
        this.zzaJg = (String) zzx.zzz(leaderboardScore.getDisplayScore());
        this.zzaJh = leaderboardScore.getRawScore();
        this.zzaJi = leaderboardScore.getTimestampMillis();
        this.zzaJj = leaderboardScore.getScoreHolderDisplayName();
        this.zzaJk = leaderboardScore.getScoreHolderIconImageUri();
        this.zzaJl = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzaJm = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzaJn = leaderboardScore.getScoreTag();
        this.zzaJo = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzaJp = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzw.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore != obj) {
            LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
            if (!zzw.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) || !zzw.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) || !zzw.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) || !zzw.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) || !zzw.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) || !zzw.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) || !zzw.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) || !zzw.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) || !zzw.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) || !zzw.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzw.zzy(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public String getDisplayRank() {
        return this.zzaJf;
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaJf, charArrayBuffer);
    }

    public String getDisplayScore() {
        return this.zzaJg;
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaJg, charArrayBuffer);
    }

    public long getRank() {
        return this.zzaJe;
    }

    public long getRawScore() {
        return this.zzaJh;
    }

    public Player getScoreHolder() {
        return this.zzaJm;
    }

    public String getScoreHolderDisplayName() {
        return this.zzaJm == null ? this.zzaJj : this.zzaJm.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzaJm == null) {
            zzms.zzb(this.zzaJj, charArrayBuffer);
        } else {
            this.zzaJm.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzaJm == null ? this.zzaJl : this.zzaJm.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzaJm == null ? this.zzaJp : this.zzaJm.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzaJm == null ? this.zzaJk : this.zzaJm.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzaJm == null ? this.zzaJo : this.zzaJm.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzaJn;
    }

    public long getTimestampMillis() {
        return this.zzaJi;
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

    /* renamed from: zzxK */
    public LeaderboardScore freeze() {
        return this;
    }
}
