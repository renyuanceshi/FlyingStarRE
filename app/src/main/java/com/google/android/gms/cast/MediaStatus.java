package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private JSONObject zzaaU;
    /* access modifiers changed from: private */
    public MediaInfo zzaaV;
    private long[] zzabj;
    /* access modifiers changed from: private */
    public int zzabl = 0;
    private long zzabm;
    private double zzabn;
    private int zzabo;
    private int zzabp;
    private long zzabq;
    private long zzabr;
    private double zzabs;
    private boolean zzabt;
    private int zzabu = 0;
    private int zzabv = 0;
    private final zza zzabw = new zza();

    private class zza {
        private int zzabx = 0;
        private List<MediaQueueItem> zzaby = new ArrayList();
        private SparseArray<Integer> zzabz = new SparseArray<>();

        zza() {
        }

        /* access modifiers changed from: private */
        public void clear() {
            this.zzabx = 0;
            this.zzaby.clear();
            this.zzabz.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzaby.clear();
            this.zzabz.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzaby.add(mediaQueueItem);
                this.zzabz.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzbd(int i) {
            return this.zzabz.get(i);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean zzh(org.json.JSONObject r11) throws org.json.JSONException {
            /*
                r10 = this;
                r3 = 3
                r4 = 2
                r1 = 0
                r2 = 1
                java.lang.String r0 = "repeatMode"
                boolean r0 = r11.has(r0)
                if (r0 == 0) goto L_0x00f4
                int r0 = r10.zzabx
                java.lang.String r5 = "repeatMode"
                java.lang.String r6 = r11.getString(r5)
                r5 = -1
                int r7 = r6.hashCode()
                switch(r7) {
                    case -1118317585: goto L_0x0072;
                    case -962896020: goto L_0x0068;
                    case 1645938909: goto L_0x005e;
                    case 1645952171: goto L_0x0054;
                    default: goto L_0x001c;
                }
            L_0x001c:
                switch(r5) {
                    case 0: goto L_0x007c;
                    case 1: goto L_0x007e;
                    case 2: goto L_0x00f7;
                    case 3: goto L_0x0080;
                    default: goto L_0x001f;
                }
            L_0x001f:
                int r3 = r10.zzabx
                if (r3 == r0) goto L_0x00f4
                r10.zzabx = r0
                r0 = r2
            L_0x0026:
                java.lang.String r3 = "items"
                boolean r3 = r11.has(r3)
                if (r3 == 0) goto L_0x00f2
                java.lang.String r3 = "items"
                org.json.JSONArray r4 = r11.getJSONArray(r3)
                int r5 = r4.length()
                android.util.SparseArray r6 = new android.util.SparseArray
                r6.<init>()
                r3 = r1
            L_0x003e:
                if (r3 >= r5) goto L_0x0082
                org.json.JSONObject r7 = r4.getJSONObject(r3)
                java.lang.String r8 = "itemId"
                int r7 = r7.getInt(r8)
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r6.put(r3, r7)
                int r3 = r3 + 1
                goto L_0x003e
            L_0x0054:
                java.lang.String r7 = "REPEAT_OFF"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r1
                goto L_0x001c
            L_0x005e:
                java.lang.String r7 = "REPEAT_ALL"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r2
                goto L_0x001c
            L_0x0068:
                java.lang.String r7 = "REPEAT_SINGLE"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r4
                goto L_0x001c
            L_0x0072:
                java.lang.String r7 = "REPEAT_ALL_AND_SHUFFLE"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r3
                goto L_0x001c
            L_0x007c:
                r0 = r1
                goto L_0x001f
            L_0x007e:
                r0 = r2
                goto L_0x001f
            L_0x0080:
                r0 = r3
                goto L_0x001f
            L_0x0082:
                com.google.android.gms.cast.MediaQueueItem[] r7 = new com.google.android.gms.cast.MediaQueueItem[r5]
                r3 = r0
            L_0x0085:
                if (r1 >= r5) goto L_0x00e1
                java.lang.Object r0 = r6.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                org.json.JSONObject r8 = r4.getJSONObject(r1)
                int r9 = r0.intValue()
                com.google.android.gms.cast.MediaQueueItem r9 = r10.zzbb(r9)
                if (r9 == 0) goto L_0x00b4
                boolean r8 = r9.zzh(r8)
                r7[r1] = r9
                int r0 = r0.intValue()
                java.lang.Integer r0 = r10.zzbd(r0)
                int r0 = r0.intValue()
                if (r1 == r0) goto L_0x00ef
                r0 = r2
            L_0x00b0:
                int r1 = r1 + 1
                r3 = r0
                goto L_0x0085
            L_0x00b4:
                int r0 = r0.intValue()
                com.google.android.gms.cast.MediaStatus r3 = com.google.android.gms.cast.MediaStatus.this
                int r3 = r3.zzabl
                if (r0 != r3) goto L_0x00d8
                com.google.android.gms.cast.MediaQueueItem$Builder r0 = new com.google.android.gms.cast.MediaQueueItem$Builder
                com.google.android.gms.cast.MediaStatus r3 = com.google.android.gms.cast.MediaStatus.this
                com.google.android.gms.cast.MediaInfo r3 = r3.zzaaV
                r0.<init>((com.google.android.gms.cast.MediaInfo) r3)
                com.google.android.gms.cast.MediaQueueItem r0 = r0.build()
                r7[r1] = r0
                r0 = r7[r1]
                r0.zzh(r8)
                r0 = r2
                goto L_0x00b0
            L_0x00d8:
                com.google.android.gms.cast.MediaQueueItem r0 = new com.google.android.gms.cast.MediaQueueItem
                r0.<init>((org.json.JSONObject) r8)
                r7[r1] = r0
                r0 = r2
                goto L_0x00b0
            L_0x00e1:
                java.util.List<com.google.android.gms.cast.MediaQueueItem> r0 = r10.zzaby
                int r0 = r0.size()
                if (r0 == r5) goto L_0x00ed
            L_0x00e9:
                r10.zza((com.google.android.gms.cast.MediaQueueItem[]) r7)
            L_0x00ec:
                return r2
            L_0x00ed:
                r2 = r3
                goto L_0x00e9
            L_0x00ef:
                r0 = r3 | r8
                goto L_0x00b0
            L_0x00f2:
                r2 = r0
                goto L_0x00ec
            L_0x00f4:
                r0 = r1
                goto L_0x0026
            L_0x00f7:
                r0 = r4
                goto L_0x001f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzh(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzaby.size();
        }

        public int getRepeatMode() {
            return this.zzabx;
        }

        public MediaQueueItem zzbb(int i) {
            Integer num = this.zzabz.get(i);
            if (num == null) {
                return null;
            }
            return this.zzaby.get(num.intValue());
        }

        public MediaQueueItem zzbc(int i) {
            if (i < 0 || i >= this.zzaby.size()) {
                return null;
            }
            return this.zzaby.get(i);
        }

        public List<MediaQueueItem> zznP() {
            return Collections.unmodifiableList(this.zzaby);
        }
    }

    public MediaStatus(JSONObject jSONObject) throws JSONException {
        zza(jSONObject, 0);
    }

    private boolean zzi(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public int getCurrentItemId() {
        return this.zzabl;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getIdleReason() {
        return this.zzabp;
    }

    public int getLoadingItemId() {
        return this.zzabu;
    }

    public MediaInfo getMediaInfo() {
        return this.zzaaV;
    }

    public double getPlaybackRate() {
        return this.zzabn;
    }

    public int getPlayerState() {
        return this.zzabo;
    }

    public int getPreloadedItemId() {
        return this.zzabv;
    }

    public MediaQueueItem getQueueItem(int i) {
        return this.zzabw.zzbc(i);
    }

    public MediaQueueItem getQueueItemById(int i) {
        return this.zzabw.zzbb(i);
    }

    public int getQueueItemCount() {
        return this.zzabw.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzabw.zznP();
    }

    public int getQueueRepeatMode() {
        return this.zzabw.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzabq;
    }

    public double getStreamVolume() {
        return this.zzabs;
    }

    public boolean isMediaCommandSupported(long j) {
        return (this.zzabr & j) != 0;
    }

    public boolean isMute() {
        return this.zzabt;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        boolean z;
        int i3;
        int i4 = 2;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzabm) {
            this.zzabm = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i5 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i5 != this.zzabo) {
                this.zzabo = i5;
                i2 |= 2;
            }
            if (i5 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (!string2.equals("CANCELLED")) {
                    i4 = string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                }
                if (i4 != this.zzabp) {
                    this.zzabp = i4;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.zzabn != d) {
                this.zzabn = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long zzg = zzf.zzg(jSONObject.getDouble("currentTime"));
            if (zzg != this.zzabq) {
                this.zzabq = zzg;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.zzabr) {
                this.zzabr = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.zzabs) {
                this.zzabs = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.zzabt) {
                this.zzabt = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            jArr = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr[i6] = jSONArray.getLong(i6);
            }
            if (this.zzabj != null && this.zzabj.length == length) {
                int i7 = 0;
                while (true) {
                    if (i7 < length) {
                        if (this.zzabj[i7] != jArr[i7]) {
                            break;
                        }
                        i7++;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.zzabj = jArr;
            }
            z = z2;
        } else if (this.zzabj != null) {
            jArr = null;
            z = true;
        } else {
            jArr = null;
            z = false;
        }
        if (z) {
            this.zzabj = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzaaU = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzaaV = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.zzabl != (i3 = jSONObject.getInt("currentItemId"))) {
            this.zzabl = i3;
            i2 |= 2;
        }
        int optInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzabv != optInt) {
            this.zzabv = optInt;
            i2 |= 16;
        }
        int optInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzabu != optInt2) {
            this.zzabu = optInt2;
            i2 |= 2;
        }
        if (!zzi(this.zzabo, this.zzabu)) {
            return this.zzabw.zzh(jSONObject) ? i2 | 8 : i2;
        }
        this.zzabl = 0;
        this.zzabu = 0;
        this.zzabv = 0;
        if (this.zzabw.getItemCount() <= 0) {
            return i2;
        }
        this.zzabw.clear();
        return i2 | 8;
    }

    public long zznO() {
        return this.zzabm;
    }
}
