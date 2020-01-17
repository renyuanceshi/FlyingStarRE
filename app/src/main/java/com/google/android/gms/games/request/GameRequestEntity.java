package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Parcelable.Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzEY;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final PlayerEntity zzaKG;
    private final ArrayList<PlayerEntity> zzaKH;
    private final long zzaKI;
    private final Bundle zzaKJ;
    private final byte[] zzaKm;
    private final int zzabB;

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList<PlayerEntity> arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.mVersionCode = i;
        this.zzaJE = gameEntity;
        this.zzaKG = playerEntity;
        this.zzaKm = bArr;
        this.zzEY = str;
        this.zzaKH = arrayList;
        this.zzabB = i2;
        this.zzaJF = j;
        this.zzaKI = j2;
        this.zzaKJ = bundle;
        this.zzBc = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(gameRequest.getGame());
        this.zzaKG = new PlayerEntity(gameRequest.getSender());
        this.zzEY = gameRequest.getRequestId();
        this.zzabB = gameRequest.getType();
        this.zzaJF = gameRequest.getCreationTimestamp();
        this.zzaKI = gameRequest.getExpirationTimestamp();
        this.zzBc = gameRequest.getStatus();
        byte[] data = gameRequest.getData();
        if (data == null) {
            this.zzaKm = null;
        } else {
            this.zzaKm = new byte[data.length];
            System.arraycopy(data, 0, this.zzaKm, 0, data.length);
        }
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzaKH = new ArrayList<>(size);
        this.zzaKJ = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) recipients.get(i).freeze();
            String playerId = player.getPlayerId();
            this.zzaKH.add((PlayerEntity) player);
            this.zzaKJ.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest != obj) {
            GameRequest gameRequest2 = (GameRequest) obj;
            if (!zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) || !zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) || !zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) || !zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) || !Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) || !zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) || !zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) || !zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()))) {
                return false;
            }
        }
        return true;
    }

    private static int[] zzb(GameRequest gameRequest) {
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(recipients.get(i).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzy(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzaJF;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public long getExpirationTimestamp() {
        return this.zzaKI;
    }

    public Game getGame() {
        return this.zzaJE;
    }

    public int getRecipientStatus(String str) {
        return this.zzaKJ.getInt(str, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzaKH);
    }

    public String getRequestId() {
        return this.zzEY;
    }

    public Player getSender() {
        return this.zzaKG;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public int getType() {
        return this.zzabB;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public Bundle zzxT() {
        return this.zzaKJ;
    }
}
