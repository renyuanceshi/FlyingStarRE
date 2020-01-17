package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class TurnBasedMatchBuffer extends zzf<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    public String zzqg() {
        return "external_match_id";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzs */
    public TurnBasedMatch zzk(int i, int i2) {
        return new TurnBasedMatchRef(this.zzahi, i, i2);
    }
}
