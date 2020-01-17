package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzaaN;
    private int zzaaO;
    private String zzaaP;
    private MediaMetadata zzaaQ;
    private long zzaaR;
    private List<MediaTrack> zzaaS;
    private TextTrackStyle zzaaT;
    private JSONObject zzaaU;

    public static class Builder {
        private final MediaInfo zzaaV;

        public Builder(String str) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzaaV = new MediaInfo(str);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzaaV.zznN();
            return this.zzaaV;
        }

        public Builder setContentType(String str) throws IllegalArgumentException {
            this.zzaaV.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzaaV.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzaaV.zzu(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzaaV.zza(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) throws IllegalArgumentException {
            this.zzaaV.zzx(j);
            return this;
        }

        public Builder setStreamType(int i) throws IllegalArgumentException {
            this.zzaaV.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzaaV.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzaaN = str;
        this.zzaaO = -1;
        this.zzaaR = -1;
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        this.zzaaN = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzaaO = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzaaO = 1;
        } else if ("LIVE".equals(string)) {
            this.zzaaO = 2;
        } else {
            this.zzaaO = -1;
        }
        this.zzaaP = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzaaQ = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzaaQ.zzg(jSONObject2);
        }
        this.zzaaR = -1;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                this.zzaaR = zzf.zzg(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzaaS = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.zzaaS.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzaaS = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzg(jSONObject3);
            this.zzaaT = textTrackStyle;
        } else {
            this.zzaaT = null;
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaInfo) {
            MediaInfo mediaInfo = (MediaInfo) obj;
            if ((this.zzaaU == null) == (mediaInfo.zzaaU == null) && (this.zzaaU == null || mediaInfo.zzaaU == null || zznb.zze(this.zzaaU, mediaInfo.zzaaU))) {
                return zzf.zza(this.zzaaN, mediaInfo.zzaaN) && this.zzaaO == mediaInfo.zzaaO && zzf.zza(this.zzaaP, mediaInfo.zzaaP) && zzf.zza(this.zzaaQ, mediaInfo.zzaaQ) && this.zzaaR == mediaInfo.zzaaR;
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

    public List<MediaTrack> getMediaTracks() {
        return this.zzaaS;
    }

    public MediaMetadata getMetadata() {
        return this.zzaaQ;
    }

    public long getStreamDuration() {
        return this.zzaaR;
    }

    public int getStreamType() {
        return this.zzaaO;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzaaT;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaaN, Integer.valueOf(this.zzaaO), this.zzaaP, this.zzaaQ, Long.valueOf(this.zzaaR), String.valueOf(this.zzaaU));
    }

    /* access modifiers changed from: package-private */
    public void setContentType(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzaaP = str;
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(JSONObject jSONObject) {
        this.zzaaU = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void setStreamType(int i) throws IllegalArgumentException {
        if (i < -1 || i > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzaaO = i;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzaaT = textTrackStyle;
    }

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzaaN);
            switch (this.zzaaO) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.zzaaP != null) {
                jSONObject.put("contentType", this.zzaaP);
            }
            if (this.zzaaQ != null) {
                jSONObject.put("metadata", this.zzaaQ.toJson());
            }
            if (this.zzaaR <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzaaR));
            }
            if (this.zzaaS != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack json : this.zzaaS) {
                    jSONArray.put(json.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzaaT != null) {
                jSONObject.put("textTrackStyle", this.zzaaT.toJson());
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void zza(MediaMetadata mediaMetadata) {
        this.zzaaQ = mediaMetadata;
    }

    /* access modifiers changed from: package-private */
    public void zznN() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzaaN)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzaaP)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzaaO == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    /* access modifiers changed from: package-private */
    public void zzu(List<MediaTrack> list) {
        this.zzaaS = list;
    }

    /* access modifiers changed from: package-private */
    public void zzx(long j) throws IllegalArgumentException {
        if (j >= 0 || j == -1) {
            this.zzaaR = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
