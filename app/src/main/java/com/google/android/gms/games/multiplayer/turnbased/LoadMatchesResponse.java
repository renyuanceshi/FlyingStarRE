package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzaKe;
    private final TurnBasedMatchBuffer zzaKf;
    private final TurnBasedMatchBuffer zzaKg;
    private final TurnBasedMatchBuffer zzaKh;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder zza = zza(bundle, 0);
        if (zza != null) {
            this.zzaKe = new InvitationBuffer(zza);
        } else {
            this.zzaKe = null;
        }
        DataHolder zza2 = zza(bundle, 1);
        if (zza2 != null) {
            this.zzaKf = new TurnBasedMatchBuffer(zza2);
        } else {
            this.zzaKf = null;
        }
        DataHolder zza3 = zza(bundle, 2);
        if (zza3 != null) {
            this.zzaKg = new TurnBasedMatchBuffer(zza3);
        } else {
            this.zzaKg = null;
        }
        DataHolder zza4 = zza(bundle, 3);
        if (zza4 != null) {
            this.zzaKh = new TurnBasedMatchBuffer(zza4);
        } else {
            this.zzaKh = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzgw = TurnBasedMatchTurnStatus.zzgw(i);
        if (!bundle.containsKey(zzgw)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(zzgw);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzaKh;
    }

    public InvitationBuffer getInvitations() {
        return this.zzaKe;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzaKf;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzaKg;
    }

    public boolean hasData() {
        if (this.zzaKe != null && this.zzaKe.getCount() > 0) {
            return true;
        }
        if (this.zzaKf != null && this.zzaKf.getCount() > 0) {
            return true;
        }
        if (this.zzaKg == null || this.zzaKg.getCount() <= 0) {
            return this.zzaKh != null && this.zzaKh.getCount() > 0;
        }
        return true;
    }

    public void release() {
        if (this.zzaKe != null) {
            this.zzaKe.release();
        }
        if (this.zzaKf != null) {
            this.zzaKf.release();
        }
        if (this.zzaKg != null) {
            this.zzaKg.release();
        }
        if (this.zzaKh != null) {
            this.zzaKh.release();
        }
    }
}
