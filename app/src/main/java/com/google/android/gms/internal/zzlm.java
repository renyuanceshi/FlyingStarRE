package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzlm implements GameManagerState {
    private final String zzada;
    private final int zzadb;
    private final int zzadg;
    private final int zzadh;
    private final JSONObject zzadj;
    private final String zzadk;
    private final Map<String, PlayerInfo> zzadm;

    public zzlm(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzadh = i;
        this.zzadg = i2;
        this.zzadk = str;
        this.zzadj = jSONObject;
        this.zzada = str2;
        this.zzadb = i3;
        this.zzadm = new HashMap(collection.size());
        for (PlayerInfo next : collection) {
            this.zzadm.put(next.getPlayerId(), next);
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj != null) {
            if (!(obj instanceof GameManagerState)) {
                return false;
            }
            GameManagerState gameManagerState = (GameManagerState) obj;
            if (getPlayers().size() == gameManagerState.getPlayers().size()) {
                for (PlayerInfo next : getPlayers()) {
                    boolean z2 = false;
                    for (PlayerInfo next2 : gameManagerState.getPlayers()) {
                        if (!zzf.zza(next.getPlayerId(), next2.getPlayerId())) {
                            z = z2;
                        } else if (zzf.zza(next, next2)) {
                            z = true;
                        }
                        z2 = z;
                    }
                    if (!z2) {
                        return false;
                    }
                }
                return this.zzadh == gameManagerState.getLobbyState() && this.zzadg == gameManagerState.getGameplayState() && this.zzadb == gameManagerState.getMaxPlayers() && zzf.zza(this.zzada, gameManagerState.getApplicationName()) && zzf.zza(this.zzadk, gameManagerState.getGameStatusText()) && zznb.zze(this.zzadj, gameManagerState.getGameData());
            }
        }
        return false;
    }

    public CharSequence getApplicationName() {
        return this.zzada;
    }

    public List<PlayerInfo> getConnectedControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo next : getPlayers()) {
            if (next.isConnected() && next.isControllable()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getConnectedPlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo next : getPlayers()) {
            if (next.isConnected()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo next : getPlayers()) {
            if (next.isControllable()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public JSONObject getGameData() {
        return this.zzadj;
    }

    public CharSequence getGameStatusText() {
        return this.zzadk;
    }

    public int getGameplayState() {
        return this.zzadg;
    }

    public Collection<String> getListOfChangedPlayers(GameManagerState gameManagerState) {
        HashSet hashSet = new HashSet();
        for (PlayerInfo next : getPlayers()) {
            PlayerInfo player = gameManagerState.getPlayer(next.getPlayerId());
            if (player == null || !next.equals(player)) {
                hashSet.add(next.getPlayerId());
            }
        }
        for (PlayerInfo next2 : gameManagerState.getPlayers()) {
            if (getPlayer(next2.getPlayerId()) == null) {
                hashSet.add(next2.getPlayerId());
            }
        }
        return hashSet;
    }

    public int getLobbyState() {
        return this.zzadh;
    }

    public int getMaxPlayers() {
        return this.zzadb;
    }

    public PlayerInfo getPlayer(String str) {
        if (str == null) {
            return null;
        }
        return this.zzadm.get(str);
    }

    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzadm.values());
    }

    public List<PlayerInfo> getPlayersInState(int i) {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo next : getPlayers()) {
            if (next.getPlayerState() == i) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean hasGameDataChanged(GameManagerState gameManagerState) {
        return !zznb.zze(this.zzadj, gameManagerState.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState gameManagerState) {
        return !zzf.zza(this.zzadk, gameManagerState.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState gameManagerState) {
        return this.zzadg != gameManagerState.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState gameManagerState) {
        return this.zzadh != gameManagerState.getLobbyState();
    }

    public boolean hasPlayerChanged(String str, GameManagerState gameManagerState) {
        return !zzf.zza(getPlayer(str), gameManagerState.getPlayer(str));
    }

    public boolean hasPlayerDataChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || !zznb.zze(player.getPlayerData(), player2.getPlayerData());
    }

    public boolean hasPlayerStateChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzadh), Integer.valueOf(this.zzadg), this.zzadm, this.zzadk, this.zzadj, this.zzada, Integer.valueOf(this.zzadb));
    }
}
