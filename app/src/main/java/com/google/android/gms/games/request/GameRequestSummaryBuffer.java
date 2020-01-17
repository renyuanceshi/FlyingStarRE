package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    /* renamed from: zzgQ */
    public GameRequestSummary get(int i) {
        return new GameRequestSummaryRef(this.zzahi, i);
    }
}
