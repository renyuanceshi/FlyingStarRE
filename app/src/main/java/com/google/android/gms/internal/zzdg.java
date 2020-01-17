package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzdg implements zzdf {
    private final Context mContext;
    private final VersionInfoParcel zzpT;

    @zzhb
    static class zza {
        private final String mValue;
        private final String zzvs;

        public zza(String str, String str2) {
            this.zzvs = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzvs;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzhb
    static class zzb {
        private final String zzzp;
        private final URL zzzq;
        private final ArrayList<zza> zzzr;
        private final String zzzs;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzzp = str;
            this.zzzq = url;
            if (arrayList == null) {
                this.zzzr = new ArrayList<>();
            } else {
                this.zzzr = arrayList;
            }
            this.zzzs = str2;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public URL zzdV() {
            return this.zzzq;
        }

        public ArrayList<zza> zzdW() {
            return this.zzzr;
        }

        public String zzdX() {
            return this.zzzs;
        }
    }

    @zzhb
    class zzc {
        private final zzd zzzt;
        private final boolean zzzu;
        private final String zzzv;

        public zzc(boolean z, zzd zzd, String str) {
            this.zzzu = z;
            this.zzzt = zzd;
            this.zzzv = str;
        }

        public String getReason() {
            return this.zzzv;
        }

        public boolean isSuccess() {
            return this.zzzu;
        }

        public zzd zzdY() {
            return this.zzzt;
        }
    }

    @zzhb
    static class zzd {
        private final String zzxY;
        private final String zzzp;
        private final int zzzw;
        private final List<zza> zzzx;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzzp = str;
            this.zzzw = i;
            if (list == null) {
                this.zzzx = new ArrayList();
            } else {
                this.zzzx = list;
            }
            this.zzxY = str2;
        }

        public String getBody() {
            return this.zzxY;
        }

        public int getResponseCode() {
            return this.zzzw;
        }

        public String zzdU() {
            return this.zzzp;
        }

        public Iterable<zza> zzdZ() {
            return this.zzzx;
        }
    }

    public zzdg(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpT = versionInfoParcel;
    }

    public JSONObject zzQ(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                zzc zza2 = zza(zzc(jSONObject));
                if (zza2.isSuccess()) {
                    jSONObject2.put("response", zza(zza2.zzdY()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza2.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzin.e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzc zza(zzb zzb2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzb2.zzdV().openConnection();
            zzr.zzbC().zza(this.mContext, this.zzpT.afmaVersion, false, httpURLConnection);
            Iterator<zza> it = zzb2.zzdW().iterator();
            while (it.hasNext()) {
                zza next = it.next();
                httpURLConnection.addRequestProperty(next.getKey(), next.getValue());
            }
            if (!TextUtils.isEmpty(zzb2.zzdX())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzb2.zzdX().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), zza2));
                    }
                }
            }
            return new zzc(true, new zzd(zzb2.zzdU(), httpURLConnection.getResponseCode(), arrayList, zzr.zzbC().zza(new InputStreamReader(httpURLConnection.getInputStream()))), (String) null);
        } catch (Exception e) {
            return new zzc(false, (zzd) null, e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zza(zzd zzd2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd2.zzdU());
            if (zzd2.getBody() != null) {
                jSONObject.put("body", zzd2.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza next : zzd2.zzdZ()) {
                jSONArray.put(new JSONObject().put("key", next.getKey()).put("value", next.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd2.getResponseCode());
        } catch (JSONException e) {
            zzin.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzjp zzjp, final Map<String, String> map) {
        zziq.zza((Runnable) new Runnable() {
            public void run() {
                zzin.zzaI("Received Http request.");
                final JSONObject zzQ = zzdg.this.zzQ((String) map.get("http_request"));
                if (zzQ == null) {
                    zzin.e("Response should not be null.");
                } else {
                    zzir.zzMc.post(new Runnable() {
                        public void run() {
                            zzjp.zzb("fetchHttpRequestCompleted", zzQ);
                            zzin.zzaI("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public zzb zzc(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String optString3 = jSONObject.optString("post_body", (String) null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzin.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
