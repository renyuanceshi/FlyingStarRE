package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzaEw;
    private final long zzaJF;
    private final ArrayList<ParticipantEntity> zzaJI;
    private final int zzaJJ;
    private final Bundle zzaJZ;
    private final String zzaKb;
    private final int zzaKc;
    private final int zzaKd;
    private final String zzaxl;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        /* renamed from: zzev */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.zzd(RoomEntity.zzqB()) || RoomEntity.zzcF(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    RoomEntity(int i, String str, String str2, long j, int i2, String str3, int i3, Bundle bundle, ArrayList<ParticipantEntity> arrayList, int i4) {
        this.mVersionCode = i;
        this.zzaEw = str;
        this.zzaKb = str2;
        this.zzaJF = j;
        this.zzaKc = i2;
        this.zzaxl = str3;
        this.zzaJJ = i3;
        this.zzaJZ = bundle;
        this.zzaJI = arrayList;
        this.zzaKd = i4;
    }

    public RoomEntity(Room room) {
        this.mVersionCode = 2;
        this.zzaEw = room.getRoomId();
        this.zzaKb = room.getCreatorId();
        this.zzaJF = room.getCreationTimestamp();
        this.zzaKc = room.getStatus();
        this.zzaxl = room.getDescription();
        this.zzaJJ = room.getVariant();
        this.zzaJZ = room.getAutoMatchCriteria();
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        this.zzaJI = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zzaJI.add((ParticipantEntity) participants.get(i).freeze());
        }
        this.zzaKd = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room) {
        return zzw.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int zza(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room != obj) {
            Room room2 = (Room) obj;
            if (!zzw.equal(room2.getRoomId(), room.getRoomId()) || !zzw.equal(room2.getCreatorId(), room.getCreatorId()) || !zzw.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) || !zzw.equal(room2.getDescription(), room.getDescription()) || !zzw.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) || !zzw.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) || !zzw.equal(room2.getParticipants(), room.getParticipants()) || !zzw.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()))) {
                return false;
            }
        }
        return true;
    }

    static String zzb(Room room) {
        return zzw.zzy(room).zzg("RoomId", room.getRoomId()).zzg("CreatorId", room.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(room.getStatus())).zzg("Description", room.getDescription()).zzg("Variant", Integer.valueOf(room.getVariant())).zzg("AutoMatchCriteria", room.getAutoMatchCriteria()).zzg("Participants", room.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(Room room, String str) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList<Participant> participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(participants.get(i).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.zzaKd;
    }

    public long getCreationTimestamp() {
        return this.zzaJF;
    }

    public String getCreatorId() {
        return this.zzaKb;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public void getDescription(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaxl, charArrayBuffer);
    }

    public Participant getParticipant(String str) {
        return zzc(this, str);
    }

    public String getParticipantId(String str) {
        return zzb(this, str);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc((Room) this);
    }

    public int getParticipantStatus(String str) {
        return zza((Room) this, str);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.zzaJI);
    }

    public String getRoomId() {
        return this.zzaEw;
    }

    public int getStatus() {
        return this.zzaKc;
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
            RoomEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzaEw);
        parcel.writeString(this.zzaKb);
        parcel.writeLong(this.zzaJF);
        parcel.writeInt(this.zzaKc);
        parcel.writeString(this.zzaxl);
        parcel.writeInt(this.zzaJJ);
        parcel.writeBundle(this.zzaJZ);
        int size = this.zzaJI.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.zzaJI.get(i2).writeToParcel(parcel, i);
        }
    }
}
