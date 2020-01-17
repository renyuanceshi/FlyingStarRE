package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzde {
    public static final zzdf zzyX = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
        }
    };
    public static final zzdf zzyY = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            String str = map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzin.zzaK("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = zzjp.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            zzjp.zza("openableURLs", (Map<String, ?>) hashMap);
        }
    };
    public static final zzdf zzyZ = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            PackageManager packageManager = zzjp.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject(map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            String optString2 = jSONObject2.optString("u");
                            String optString3 = jSONObject2.optString("i");
                            String optString4 = jSONObject2.optString("m");
                            String optString5 = jSONObject2.optString("p");
                            String optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (JSONException e) {
                                zzin.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (JSONException e2) {
                            zzin.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    zzjp.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    zzjp.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                zzjp.zzb("openableIntents", new JSONObject());
            }
        }
    };
    public static final zzdf zzza = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            Uri uri;
            String str = map.get("u");
            if (str == null) {
                zzin.zzaK("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                zzan zzhW = zzjp.zzhW();
                if (zzhW != null && zzhW.zzb(parse)) {
                    uri = zzhW.zza(parse, zzjp.getContext());
                    new zziy(zzjp.getContext(), zzjp.zzhX().afmaVersion, uri.toString()).zzgd();
                }
            } catch (zzao e) {
                zzin.zzaK("Unable to append parameter to URL: " + str);
            }
            uri = parse;
            new zziy(zzjp.getContext(), zzjp.zzhX().afmaVersion, uri.toString()).zzgd();
        }
    };
    public static final zzdf zzzb = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            zzd zzhS = zzjp.zzhS();
            if (zzhS != null) {
                zzhS.close();
                return;
            }
            zzd zzhT = zzjp.zzhT();
            if (zzhT != null) {
                zzhT.close();
            } else {
                zzin.zzaK("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    };
    public static final zzdf zzzc = new zzdf() {
        private void zzc(zzjp zzjp) {
            zzm zzm;
            zzin.zzaJ("Received support message, responding.");
            boolean z = false;
            com.google.android.gms.ads.internal.zzd zzhR = zzjp.zzhR();
            if (!(zzhR == null || (zzm = zzhR.zzpy) == null)) {
                z = zzm.zzfM();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", "checkSupport");
                jSONObject.put("supports", z);
                zzjp.zzb("appStreaming", jSONObject);
            } catch (Throwable th) {
            }
        }

        public void zza(zzjp zzjp, Map<String, String> map) {
            if ("checkSupport".equals(map.get("action"))) {
                zzc(zzjp);
                return;
            }
            zzd zzhS = zzjp.zzhS();
            if (zzhS != null) {
                zzhS.zzg(zzjp, map);
            }
        }
    };
    public static final zzdf zzzd = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            zzjp.zzE("1".equals(map.get("custom_close")));
        }
    };
    public static final zzdf zzze = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            String str = map.get("u");
            if (str == null) {
                zzin.zzaK("URL missing from httpTrack GMSG.");
            } else {
                new zziy(zzjp.getContext(), zzjp.zzhX().afmaVersion, str).zzgd();
            }
        }
    };
    public static final zzdf zzzf = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            zzin.zzaJ("Received log message: " + map.get("string"));
        }
    };
    public static final zzdf zzzg = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            String str = map.get("tx");
            String str2 = map.get("ty");
            String str3 = map.get("td");
            try {
                int parseInt = Integer.parseInt(str);
                int parseInt2 = Integer.parseInt(str2);
                int parseInt3 = Integer.parseInt(str3);
                zzan zzhW = zzjp.zzhW();
                if (zzhW != null) {
                    zzhW.zzab().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzin.zzaK("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzdf zzzh = new zzdf() {
        public void zza(zzjp zzjp, Map<String, String> map) {
            if (zzbt.zzwT.get().booleanValue()) {
                zzjp.zzF(!Boolean.parseBoolean(map.get("disabled")));
            }
        }
    };
    public static final zzdf zzzi = new zzdo();
    public static final zzdf zzzj = new zzds();
    public static final zzdf zzzk = new zzdd();
}
