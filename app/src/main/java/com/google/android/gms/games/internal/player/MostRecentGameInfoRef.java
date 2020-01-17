package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzaDh;

    public MostRecentGameInfoRef(DataHolder dataHolder, int i, PlayerColumnNames playerColumnNames) {
        super(dataHolder, i);
        this.zzaDh = playerColumnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) freeze()).writeToParcel(parcel, i);
    }

    public long zzxA() {
        return getLong(this.zzaDh.zzaIM);
    }

    public Uri zzxB() {
        return zzcA(this.zzaDh.zzaIN);
    }

    public Uri zzxC() {
        return zzcA(this.zzaDh.zzaIO);
    }

    public Uri zzxD() {
        return zzcA(this.zzaDh.zzaIP);
    }

    /* renamed from: zzxE */
    public MostRecentGameInfo freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    public String zzxy() {
        return getString(this.zzaDh.zzaIK);
    }

    public String zzxz() {
        return getString(this.zzaDh.zzaIL);
    }
}
