package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzaJd;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaJd = new LeaderboardScoreBufferHeader(dataHolder.zzpZ());
    }

    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.zzahi, i);
    }

    public LeaderboardScoreBufferHeader zzxJ() {
        return this.zzaJd;
    }
}
