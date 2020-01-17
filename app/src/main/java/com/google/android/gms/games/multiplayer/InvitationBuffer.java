package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzq */
    public Invitation zzk(int i, int i2) {
        return new InvitationRef(this.zzahi, i, i2);
    }

    /* access modifiers changed from: protected */
    public String zzqg() {
        return "external_invitation_id";
    }
}
