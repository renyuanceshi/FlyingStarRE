package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzWQ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private final String zzaDX;
    private final PlayerEntity zzaDq;
    private final String zzaFa;
    private final boolean zzaJM;
    private final ParticipantResult zzaJN;
    private final int zzaab;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        /* renamed from: zzes */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            boolean z = false;
            if (ParticipantEntity.zzd(ParticipantEntity.zzqB()) || ParticipantEntity.zzcF(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() > 0) {
                z = true;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z2, z ? PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, (ParticipantResult) null, (String) null, (String) null);
        }
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.mVersionCode = i;
        this.zzaFa = str;
        this.zzWQ = str2;
        this.zzaCd = uri;
        this.zzaCe = uri2;
        this.zzBc = i2;
        this.zzaDX = str3;
        this.zzaJM = z;
        this.zzaDq = playerEntity;
        this.zzaab = i3;
        this.zzaJN = participantResult;
        this.zzaCo = str4;
        this.zzaCp = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzaFa = participant.getParticipantId();
        this.zzWQ = participant.getDisplayName();
        this.zzaCd = participant.getIconImageUri();
        this.zzaCe = participant.getHiResImageUri();
        this.zzBc = participant.getStatus();
        this.zzaDX = participant.zzwt();
        this.zzaJM = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaDq = player == null ? null : new PlayerEntity(player);
        this.zzaab = participant.getCapabilities();
        this.zzaJN = participant.getResult();
        this.zzaCo = participant.getIconImageUrl();
        this.zzaCp = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzwt(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant != obj) {
            Participant participant2 = (Participant) obj;
            if (!zzw.equal(participant2.getPlayer(), participant.getPlayer()) || !zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) || !zzw.equal(participant2.zzwt(), participant.zzwt()) || !zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) || !zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) || !zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) || !zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) || !zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) || !zzw.equal(participant2.getResult(), participant.getResult()) || !zzw.equal(participant2.getParticipantId(), participant.getParticipantId())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(Participant participant) {
        return zzw.zzy(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzwt()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzaab;
    }

    public String getDisplayName() {
        return this.zzaDq == null ? this.zzWQ : this.zzaDq.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzaDq == null) {
            zzms.zzb(this.zzWQ, charArrayBuffer);
        } else {
            this.zzaDq.getDisplayName(charArrayBuffer);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzaDq == null ? this.zzaCe : this.zzaDq.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzaDq == null ? this.zzaCp : this.zzaDq.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzaDq == null ? this.zzaCd : this.zzaDq.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzaDq == null ? this.zzaCo : this.zzaDq.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzaFa;
    }

    public Player getPlayer() {
        return this.zzaDq;
    }

    public ParticipantResult getResult() {
        return this.zzaJN;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzaJM;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        int i2 = 0;
        if (!zzqC()) {
            ParticipantEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzaFa);
        parcel.writeString(this.zzWQ);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        if (this.zzaCe != null) {
            str = this.zzaCe.toString();
        }
        parcel.writeString(str);
        parcel.writeInt(this.zzBc);
        parcel.writeString(this.zzaDX);
        parcel.writeInt(this.zzaJM ? 1 : 0);
        if (this.zzaDq != null) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.zzaDq != null) {
            this.zzaDq.writeToParcel(parcel, i);
        }
    }

    public String zzwt() {
        return this.zzaDX;
    }
}
