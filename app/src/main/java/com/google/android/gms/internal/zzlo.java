package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzlo {
    private final int zzabo;
    private final String zzacX;
    private final JSONObject zzadn;

    public zzlo(String str, int i, JSONObject jSONObject) {
        this.zzacX = str;
        this.zzabo = i;
        this.zzadn = jSONObject;
    }

    public zzlo(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzlo = (zzlo) obj;
        return this.zzabo == zzlo.getPlayerState() && zzf.zza(this.zzacX, zzlo.getPlayerId()) && zznb.zze(this.zzadn, zzlo.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzadn;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public int getPlayerState() {
        return this.zzabo;
    }
}
