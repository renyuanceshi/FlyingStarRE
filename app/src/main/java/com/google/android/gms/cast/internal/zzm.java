package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm extends zzc {
    private static final String NAMESPACE = zzf.zzci("com.google.cast.media");
    private final List<zzp> zzacA = new ArrayList();
    private long zzaei;
    private MediaStatus zzaej;
    private final zzp zzaek = new zzp(86400000);
    private final zzp zzael = new zzp(86400000);
    private final zzp zzaem = new zzp(86400000);
    private final zzp zzaen = new zzp(86400000);
    private final zzp zzaeo = new zzp(86400000);
    private final zzp zzaep = new zzp(86400000);
    private final zzp zzaeq = new zzp(86400000);
    private final zzp zzaer = new zzp(86400000);
    private final zzp zzaes = new zzp(86400000);
    private final zzp zzaet = new zzp(86400000);
    private final zzp zzaeu = new zzp(86400000);
    private final zzp zzaev = new zzp(86400000);
    private final zzp zzaew = new zzp(86400000);
    private final zzp zzaex = new zzp(86400000);

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000);
        this.zzacA.add(this.zzaek);
        this.zzacA.add(this.zzael);
        this.zzacA.add(this.zzaem);
        this.zzacA.add(this.zzaen);
        this.zzacA.add(this.zzaeo);
        this.zzacA.add(this.zzaep);
        this.zzacA.add(this.zzaeq);
        this.zzacA.add(this.zzaer);
        this.zzacA.add(this.zzaes);
        this.zzacA.add(this.zzaet);
        this.zzacA.add(this.zzaeu);
        this.zzacA.add(this.zzaev);
        this.zzacA.add(this.zzaew);
        this.zzacA.add(this.zzaex);
        zzoy();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean z = true;
        boolean zzB = this.zzaek.zzB(j);
        boolean z2 = this.zzaeo.zzoA() && !this.zzaeo.zzB(j);
        if ((!this.zzaep.zzoA() || this.zzaep.zzB(j)) && (!this.zzaeq.zzoA() || this.zzaeq.zzB(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (zzB || this.zzaej == null) {
            this.zzaej = new MediaStatus(jSONObject);
            this.zzaei = SystemClock.elapsedRealtime();
            i = 31;
        } else {
            i = this.zzaej.zza(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.zzaei = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.zzaei = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i & 16) != 0) {
            onPreloadStatusUpdated();
        }
        for (zzp zzc : this.zzacA) {
            zzc.zzc(j, 0);
        }
    }

    private void zzoy() {
        this.zzaei = 0;
        this.zzaej = null;
        for (zzp clear : this.zzacA) {
            clear.clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzaei == 0) {
            return 0;
        }
        double playbackRate = this.zzaej.getPlaybackRate();
        long streamPosition = this.zzaej.getStreamPosition();
        int playerState = this.zzaej.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzaei;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j2 = streamPosition + ((long) (((double) j) * playbackRate));
        if (streamDuration > 0 && j2 > streamDuration) {
            return streamDuration;
        }
        if (j2 < 0) {
            return 0;
        }
        return j2;
    }

    public MediaInfo getMediaInfo() {
        if (this.zzaej == null) {
            return null;
        }
        return this.zzaej.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzaej;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMetadataUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onPreloadStatusUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onQueueStatusUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onStatusUpdated() {
    }

    public long zza(zzo zzo) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzog = zzog();
        this.zzaer.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zzog);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzaej != null) {
                jSONObject.put("mediaSessionId", this.zzaej.zznO());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaep.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznO());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, int i, long j, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IOException, IllegalStateException {
        if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzog = zzog();
            this.zzaev.zza(zzog, zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zzog);
                jSONObject2.put("type", "QUEUE_UPDATE");
                jSONObject2.put("mediaSessionId", zznO());
                if (i != 0) {
                    jSONObject2.put("currentItemId", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("jump", i2);
                }
                if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                        jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                    }
                    jSONObject2.put("items", jSONArray);
                }
                if (num != null) {
                    switch (num.intValue()) {
                        case 0:
                            jSONObject2.put("repeatMode", "REPEAT_OFF");
                            break;
                        case 1:
                            jSONObject2.put("repeatMode", "REPEAT_ALL");
                            break;
                        case 2:
                            jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                            break;
                        case 3:
                            jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                            break;
                    }
                }
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zzog, (String) null);
            return zzog;
        }
        throw new IllegalArgumentException("playPosition cannot be negative: " + j);
    }

    public long zza(zzo zzo, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaeo.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zznO());
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaek.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzog = zzog();
        this.zzaet.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zzog);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zznO());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzael.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaeq.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznO());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, int[] iArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaex.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, int[] iArr, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaew.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzog = zzog();
        this.zzaes.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject.put("requestId", zzog);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzog, (String) null);
        return zzog;
    }

    public long zza(zzo zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, int i3, long j, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalStateException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        } else if (i2 != 0 && i3 != -1) {
            throw new IllegalArgumentException("can not set both currentItemId and currentItemIndexInItemsToInsert");
        } else if (i3 != -1 && (i3 < 0 || i3 >= mediaQueueItemArr.length)) {
            throw new IllegalArgumentException(String.format("currentItemIndexInItemsToInsert %d out of range [0, %d).", new Object[]{Integer.valueOf(i3), Integer.valueOf(mediaQueueItemArr.length)}));
        } else if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzog = zzog();
            this.zzaeu.zza(zzog, zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zzog);
                jSONObject2.put("type", "QUEUE_INSERT");
                jSONObject2.put("mediaSessionId", zznO());
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < mediaQueueItemArr.length; i4++) {
                    jSONArray.put(i4, mediaQueueItemArr[i4].toJson());
                }
                jSONObject2.put("items", jSONArray);
                if (i != 0) {
                    jSONObject2.put("insertBefore", i);
                }
                if (i2 != 0) {
                    jSONObject2.put("currentItemId", i2);
                }
                if (i3 != -1) {
                    jSONObject2.put("currentItemIndex", i3);
                }
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zzog, (String) null);
            return zzog;
        } else {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
    }

    public long zza(zzo zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        } else if (j == -1 || j >= 0) {
            JSONObject jSONObject2 = new JSONObject();
            long zzog = zzog();
            this.zzaek.zza(zzog, zzo);
            zzW(true);
            try {
                jSONObject2.put("requestId", zzog);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
                switch (i2) {
                    case 0:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case 1:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case 2:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case 3:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid repeat mode: " + i2);
                }
                jSONObject2.put("startIndex", i);
                if (j != -1) {
                    jSONObject2.put("currentTime", zzf.zzA(j));
                }
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zzog, (String) null);
            return zzog;
        } else {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
    }

    public long zzb(zzo zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaen.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public void zzb(long j, int i) {
        for (zzp zzc : this.zzacA) {
            zzc.zzc(j, i);
        }
    }

    public long zzc(zzo zzo, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzog = zzog();
        this.zzaem.zza(zzog, zzo);
        zzW(true);
        try {
            jSONObject2.put("requestId", zzog);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzog, (String) null);
        return zzog;
    }

    public final void zzcf(String str) {
        this.zzadu.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzaej = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzaer.zzc(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzadu.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                for (zzp zzc : this.zzacA) {
                    zzc.zzc(optLong, 2100, optJSONObject);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.zzaek.zzc(optLong, 2100, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zzaek.zzc(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzadu.zzf("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                for (zzp zzc2 : this.zzacA) {
                    zzc2.zzc(optLong, 2100, optJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.zzadu.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zznO() throws IllegalStateException {
        if (this.zzaej != null) {
            return this.zzaej.zznO();
        }
        throw new IllegalStateException("No current media session");
    }

    public void zzof() {
        super.zzof();
        zzoy();
    }

    /* access modifiers changed from: protected */
    public boolean zzz(long j) {
        boolean z;
        for (zzp zzd : this.zzacA) {
            zzd.zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzaeB) {
            Iterator<zzp> it = this.zzacA.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().zzoA()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }
}
