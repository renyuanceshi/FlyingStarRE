package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzaIm;
    private final String zzaIn;
    private final long zzaIo;
    private final Uri zzaIp;
    private final Uri zzaIq;
    private final Uri zzaIr;

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.mVersionCode = i;
        this.zzaIm = str;
        this.zzaIn = str2;
        this.zzaIo = j;
        this.zzaIp = uri;
        this.zzaIq = uri2;
        this.zzaIr = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.mVersionCode = 2;
        this.zzaIm = mostRecentGameInfo.zzxy();
        this.zzaIn = mostRecentGameInfo.zzxz();
        this.zzaIo = mostRecentGameInfo.zzxA();
        this.zzaIp = mostRecentGameInfo.zzxB();
        this.zzaIq = mostRecentGameInfo.zzxC();
        this.zzaIr = mostRecentGameInfo.zzxD();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzxy(), mostRecentGameInfo.zzxz(), Long.valueOf(mostRecentGameInfo.zzxA()), mostRecentGameInfo.zzxB(), mostRecentGameInfo.zzxC(), mostRecentGameInfo.zzxD());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo != obj) {
            MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
            if (!zzw.equal(mostRecentGameInfo2.zzxy(), mostRecentGameInfo.zzxy()) || !zzw.equal(mostRecentGameInfo2.zzxz(), mostRecentGameInfo.zzxz()) || !zzw.equal(Long.valueOf(mostRecentGameInfo2.zzxA()), Long.valueOf(mostRecentGameInfo.zzxA())) || !zzw.equal(mostRecentGameInfo2.zzxB(), mostRecentGameInfo.zzxB()) || !zzw.equal(mostRecentGameInfo2.zzxC(), mostRecentGameInfo.zzxC()) || !zzw.equal(mostRecentGameInfo2.zzxD(), mostRecentGameInfo.zzxD())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzy(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzxy()).zzg("GameName", mostRecentGameInfo.zzxz()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzxA())).zzg("GameIconUri", mostRecentGameInfo.zzxB()).zzg("GameHiResUri", mostRecentGameInfo.zzxC()).zzg("GameFeaturedUri", mostRecentGameInfo.zzxD()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public int getVersionCode() {
        return this.mVersionCode;
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

    public void writeToParcel(Parcel parcel, int i) {
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    public long zzxA() {
        return this.zzaIo;
    }

    public Uri zzxB() {
        return this.zzaIp;
    }

    public Uri zzxC() {
        return this.zzaIq;
    }

    public Uri zzxD() {
        return this.zzaIr;
    }

    /* renamed from: zzxE */
    public MostRecentGameInfo freeze() {
        return this;
    }

    public String zzxy() {
        return this.zzaIm;
    }

    public String zzxz() {
        return this.zzaIn;
    }
}
