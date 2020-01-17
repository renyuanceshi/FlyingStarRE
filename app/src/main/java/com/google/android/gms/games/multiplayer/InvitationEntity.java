package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzUO;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final int zzaJG;
    private final ParticipantEntity zzaJH;
    private final ArrayList<ParticipantEntity> zzaJI;
    private final int zzaJJ;
    private final int zzaJK;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        /* renamed from: zzer */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.zzd(InvitationEntity.zzqB()) || InvitationEntity.zzcF(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity createFromParcel2 = ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, createFromParcel, readString, readLong, readInt, createFromParcel2, arrayList, -1, 0);
        }
    }

    InvitationEntity(int i, GameEntity gameEntity, String str, long j, int i2, ParticipantEntity participantEntity, ArrayList<ParticipantEntity> arrayList, int i3, int i4) {
        this.mVersionCode = i;
        this.zzaJE = gameEntity;
        this.zzUO = str;
        this.zzaJF = j;
        this.zzaJG = i2;
        this.zzaJH = participantEntity;
        this.zzaJI = arrayList;
        this.zzaJJ = i3;
        this.zzaJK = i4;
    }

    InvitationEntity(Invitation invitation) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(invitation.getGame());
        this.zzUO = invitation.getInvitationId();
        this.zzaJF = invitation.getCreationTimestamp();
        this.zzaJG = invitation.getInvitationType();
        this.zzaJJ = invitation.getVariant();
        this.zzaJK = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList<Participant> participants = invitation.getParticipants();
        int size = participants.size();
        this.zzaJI = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.zzaJI.add((ParticipantEntity) participant2.freeze());
        }
        zzx.zzb(participant, (Object) "Must have a valid inviter!");
        this.zzaJH = (ParticipantEntity) participant.freeze();
    }

    static int zza(Invitation invitation) {
        return zzw.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation != obj) {
            Invitation invitation2 = (Invitation) obj;
            if (!zzw.equal(invitation2.getGame(), invitation.getGame()) || !zzw.equal(invitation2.getInvitationId(), invitation.getInvitationId()) || !zzw.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) || !zzw.equal(invitation2.getInviter(), invitation.getInviter()) || !zzw.equal(invitation2.getParticipants(), invitation.getParticipants()) || !zzw.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) || !zzw.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()))) {
                return false;
            }
        }
        return true;
    }

    static String zzb(Invitation invitation) {
        return zzw.zzy(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzaJK;
    }

    public long getCreationTimestamp() {
        return this.zzaJF;
    }

    public Game getGame() {
        return this.zzaJE;
    }

    public String getInvitationId() {
        return this.zzUO;
    }

    public int getInvitationType() {
        return this.zzaJG;
    }

    public Participant getInviter() {
        return this.zzaJH;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzaJI);
    }

    public int getVariant() {
        return this.zzaJJ;
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
        if (!zzqC()) {
            InvitationEntityCreator.zza(this, parcel, i);
            return;
        }
        this.zzaJE.writeToParcel(parcel, i);
        parcel.writeString(this.zzUO);
        parcel.writeLong(this.zzaJF);
        parcel.writeInt(this.zzaJG);
        this.zzaJH.writeToParcel(parcel, i);
        int size = this.zzaJI.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.zzaJI.get(i2).writeToParcel(parcel, i);
        }
    }
}
