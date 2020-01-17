package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private JSONObject zzaaU;
    private MediaInfo zzabd;
    private int zzabe;
    private boolean zzabf;
    private double zzabg;
    private double zzabh;
    private double zzabi;
    private long[] zzabj;

    public static class Builder {
        private final MediaQueueItem zzabk;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem(mediaInfo);
        }

        public Builder(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem();
        }

        public Builder(JSONObject jSONObject) throws JSONException {
            this.zzabk = new MediaQueueItem(jSONObject);
        }

        public MediaQueueItem build() {
            this.zzabk.zznN();
            return this.zzabk;
        }

        public Builder clearItemId() {
            this.zzabk.zzba(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] jArr) {
            this.zzabk.zza(jArr);
            return this;
        }

        public Builder setAutoplay(boolean z) {
            this.zzabk.zzV(z);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzabk.setCustomData(jSONObject);
            return this;
        }

        public Builder setPlaybackDuration(double d) {
            this.zzabk.zzd(d);
            return this;
        }

        public Builder setPreloadTime(double d) throws IllegalArgumentException {
            this.zzabk.zze(d);
            return this;
        }

        public Builder setStartTime(double d) throws IllegalArgumentException {
            this.zzabk.zzc(d);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo mediaInfo) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabd = mediaInfo;
    }

    private MediaQueueItem(MediaQueueItem mediaQueueItem) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        this.zzabd = mediaQueueItem.getMedia();
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabe = mediaQueueItem.getItemId();
        this.zzabf = mediaQueueItem.getAutoplay();
        this.zzabg = mediaQueueItem.getStartTime();
        this.zzabh = mediaQueueItem.getPlaybackDuration();
        this.zzabi = mediaQueueItem.getPreloadTime();
        this.zzabj = mediaQueueItem.getActiveTrackIds();
        this.zzaaU = mediaQueueItem.getCustomData();
    }

    MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        zzh(jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaQueueItem) {
            MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
            if ((this.zzaaU == null) == (mediaQueueItem.zzaaU == null) && (this.zzaaU == null || mediaQueueItem.zzaaU == null || zznb.zze(this.zzaaU, mediaQueueItem.zzaaU))) {
                return zzf.zza(this.zzabd, mediaQueueItem.zzabd) && this.zzabe == mediaQueueItem.zzabe && this.zzabf == mediaQueueItem.zzabf && this.zzabg == mediaQueueItem.zzabg && this.zzabh == mediaQueueItem.zzabh && this.zzabi == mediaQueueItem.zzabi && zzf.zza(this.zzabj, mediaQueueItem.zzabj);
            }
        }
        return false;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public boolean getAutoplay() {
        return this.zzabf;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getItemId() {
        return this.zzabe;
    }

    public MediaInfo getMedia() {
        return this.zzabd;
    }

    public double getPlaybackDuration() {
        return this.zzabh;
    }

    public double getPreloadTime() {
        return this.zzabi;
    }

    public double getStartTime() {
        return this.zzabg;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzabd, Integer.valueOf(this.zzabe), Boolean.valueOf(this.zzabf), Double.valueOf(this.zzabg), Double.valueOf(this.zzabh), Double.valueOf(this.zzabi), this.zzabj, String.valueOf(this.zzaaU));
    }

    /* access modifiers changed from: package-private */
    public void setCustomData(JSONObject jSONObject) {
        this.zzaaU = jSONObject;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzabd.toJson());
            if (this.zzabe != 0) {
                jSONObject.put("itemId", this.zzabe);
            }
            jSONObject.put("autoplay", this.zzabf);
            jSONObject.put("startTime", this.zzabg);
            if (this.zzabh != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", this.zzabh);
            }
            jSONObject.put("preloadTime", this.zzabi);
            if (this.zzabj != null) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzabj) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void zzV(boolean z) {
        this.zzabf = z;
    }

    /* access modifiers changed from: package-private */
    public void zza(long[] jArr) {
        this.zzabj = jArr;
    }

    /* access modifiers changed from: package-private */
    public void zzba(int i) {
        this.zzabe = i;
    }

    /* access modifiers changed from: package-private */
    public void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzabg = d;
    }

    /* access modifiers changed from: package-private */
    public void zzd(double d) throws IllegalArgumentException {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        this.zzabh = d;
    }

    /* access modifiers changed from: package-private */
    public void zze(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzabi = d;
    }

    public boolean zzh(JSONObject jSONObject) throws JSONException {
        boolean z;
        long[] jArr;
        boolean z2;
        int i;
        boolean z3 = false;
        if (jSONObject.has("media")) {
            this.zzabd = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.zzabe != (i = jSONObject.getInt("itemId"))) {
            this.zzabe = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.zzabf != (z2 = jSONObject.getBoolean("autoplay"))) {
            this.zzabf = z2;
            z = true;
        }
        if (jSONObject.has("startTime")) {
            double d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzabg) > 1.0E-7d) {
                this.zzabg = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.zzabh) > 1.0E-7d) {
                this.zzabh = d2;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.zzabi) > 1.0E-7d) {
                this.zzabi = d3;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = jSONArray.getLong(i2);
            }
            if (this.zzabj == null) {
                z3 = true;
            } else if (this.zzabj.length != length) {
                z3 = true;
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (this.zzabj[i3] != jArr[i3]) {
                        z3 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        } else {
            jArr = null;
        }
        if (z3) {
            this.zzabj = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzaaU = jSONObject.getJSONObject("customData");
        return true;
    }

    /* access modifiers changed from: package-private */
    public void zznN() throws IllegalArgumentException {
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.zzabg) || this.zzabg < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzabh)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzabi) || this.zzabi < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }
}
