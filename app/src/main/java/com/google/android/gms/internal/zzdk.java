package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzdk implements zzdf {
    final HashMap<String, zzjd<JSONObject>> zzzz = new HashMap<>();

    public Future<JSONObject> zzR(String str) {
        zzjd zzjd = new zzjd();
        this.zzzz.put(str, zzjd);
        return zzjd;
    }

    public void zzS(String str) {
        zzjd zzjd = this.zzzz.get(str);
        if (zzjd == null) {
            zzin.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzjd.isDone()) {
            zzjd.cancel(true);
        }
        this.zzzz.remove(str);
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        zzd(map.get("request_id"), map.get("fetched_ad"));
    }

    public void zzd(String str, String str2) {
        zzin.zzaI("Received ad from the cache.");
        zzjd zzjd = this.zzzz.get(str);
        if (zzjd == null) {
            zzin.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzjd.zzg(new JSONObject(str2));
        } catch (JSONException e) {
            zzin.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzjd.zzg(null);
        } finally {
            this.zzzz.remove(str);
        }
    }
}
