package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzUZ;
    private String zzaaL;
    private String zzaaN;
    private String zzaaP;
    private JSONObject zzaaU;
    private int zzabB;
    private int zzabC;

    public static class Builder {
        private final MediaTrack zzabD;

        public Builder(long j, int i) throws IllegalArgumentException {
            this.zzabD = new MediaTrack(j, i);
        }

        public MediaTrack build() {
            return this.zzabD;
        }

        public Builder setContentId(String str) {
            this.zzabD.setContentId(str);
            return this;
        }

        public Builder setContentType(String str) {
            this.zzabD.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzabD.setCustomData(jSONObject);
            return this;
        }

        public Builder setLanguage(String str) {
            this.zzabD.setLanguage(str);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzabD.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String str) {
            this.zzabD.setName(str);
            return this;
        }

        public Builder setSubtype(int i) throws IllegalArgumentException {
            this.zzabD.zzbe(i);
            return this;
        }
    }

    MediaTrack(long j, int i) throws IllegalArgumentException {
        clear();
        this.zzUZ = j;
        if (i <= 0 || i > 3) {
            throw new IllegalArgumentException("invalid type " + i);
        }
        this.zzabB = i;
    }

    MediaTrack(JSONObject jSONObject) throws JSONException {
        zzg(jSONObject);
    }

    private void clear() {
        this.zzUZ = 0;
        this.zzabB = 0;
        this.zzaaN = null;
        this.mName = null;
        this.zzaaL = null;
        this.zzabC = -1;
        this.zzaaU = null;
    }

    private void zzg(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzUZ = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzabB = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzabB = 2;
        } else if ("VIDEO".equals(string)) {
            this.zzabB = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzaaN = jSONObject.optString("trackContentId", (String) null);
        this.zzaaP = jSONObject.optString("trackContentType", (String) null);
        this.mName = jSONObject.optString("name", (String) null);
        this.zzaaL = jSONObject.optString("language", (String) null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzabC = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzabC = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzabC = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.zzabC = 4;
            } else if ("METADATA".equals(string2)) {
                this.zzabC = 5;
            } else {
                throw new JSONException("invalid subtype: " + string2);
            }
        } else {
            this.zzabC = 0;
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaTrack) {
            MediaTrack mediaTrack = (MediaTrack) obj;
            if ((this.zzaaU == null) == (mediaTrack.zzaaU == null) && (this.zzaaU == null || mediaTrack.zzaaU == null || zznb.zze(this.zzaaU, mediaTrack.zzaaU))) {
                return this.zzUZ == mediaTrack.zzUZ && this.zzabB == mediaTrack.zzabB && zzf.zza(this.zzaaN, mediaTrack.zzaaN) && zzf.zza(this.zzaaP, mediaTrack.zzaaP) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzaaL, mediaTrack.zzaaL) && this.zzabC == mediaTrack.zzabC;
            }
        }
        return false;
    }

    public String getContentId() {
        return this.zzaaN;
    }

    public String getContentType() {
        return this.zzaaP;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public long getId() {
        return this.zzUZ;
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzabC;
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzUZ), Integer.valueOf(this.zzabB), this.zzaaN, this.zzaaP, this.mName, this.zzaaL, Integer.valueOf(this.zzabC), this.zzaaU);
    }

    public void setContentId(String str) {
        this.zzaaN = str;
    }

    public void setContentType(String str) {
        this.zzaaP = str;
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(JSONObject jSONObject) {
        this.zzaaU = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void setLanguage(String str) {
        this.zzaaL = str;
    }

    /* access modifiers changed from: package-private */
    public void setName(String str) {
        this.mName = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzUZ);
            switch (this.zzabB) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzaaN != null) {
                jSONObject.put("trackContentId", this.zzaaN);
            }
            if (this.zzaaP != null) {
                jSONObject.put("trackContentType", this.zzaaP);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzaaL)) {
                jSONObject.put("language", this.zzaaL);
            }
            switch (this.zzabC) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void zzbe(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzabB == 1) {
            this.zzabC = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
