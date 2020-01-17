package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzaJq;

    LeaderboardScoreRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaJq = new PlayerRef(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        zza("display_rank", charArrayBuffer);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        zza("display_score", charArrayBuffer);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (zzcB("external_player_id")) {
            return null;
        }
        return this.zzaJq;
    }

    public String getScoreHolderDisplayName() {
        return zzcB("external_player_id") ? getString("default_display_name") : this.zzaJq.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        if (zzcB("external_player_id")) {
            zza("default_display_name", charArrayBuffer);
        } else {
            this.zzaJq.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        if (zzcB("external_player_id")) {
            return null;
        }
        return this.zzaJq.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        if (zzcB("external_player_id")) {
            return null;
        }
        return this.zzaJq.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzcB("external_player_id") ? zzcA("default_display_image_uri") : this.zzaJq.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzcB("external_player_id") ? getString("default_display_image_url") : this.zzaJq.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    /* renamed from: zzxK */
    public LeaderboardScore freeze() {
        return new LeaderboardScoreEntity(this);
    }
}
