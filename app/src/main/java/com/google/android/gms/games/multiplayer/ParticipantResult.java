package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult implements SafeParcelable {
    public static final Parcelable.Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int mVersionCode;
    private final String zzaFa;
    private final int zzaJP;
    private final int zzaJQ;

    public ParticipantResult(int i, String str, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaFa = (String) zzx.zzz(str);
        zzx.zzab(MatchResult.isValid(i2));
        this.zzaJP = i2;
        this.zzaJQ = i3;
    }

    public ParticipantResult(String str, int i, int i2) {
        this(1, str, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.zzaFa;
    }

    public int getPlacing() {
        return this.zzaJQ;
    }

    public int getResult() {
        return this.zzaJP;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParticipantResultCreator.zza(this, parcel, i);
    }
}
