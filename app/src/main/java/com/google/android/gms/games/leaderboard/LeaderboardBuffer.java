package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer extends zzf<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Leaderboard zzk(int i, int i2) {
        return new LeaderboardRef(this.zzahi, i, i2);
    }

    /* access modifiers changed from: protected */
    public String zzqg() {
        return "external_leaderboard_id";
    }
}
