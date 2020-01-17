package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzlp;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzaaW = {null, "String", "int", "double", "ISO-8601 date String"};
    private static final zza zzaaX = new zza().zzc(KEY_CREATION_DATE, "creationDateTime", 4).zzc(KEY_RELEASE_DATE, "releaseDate", 4).zzc(KEY_BROADCAST_DATE, "originalAirdate", 4).zzc(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).zzc(KEY_SUBTITLE, "subtitle", 1).zzc(KEY_ARTIST, "artist", 1).zzc(KEY_ALBUM_ARTIST, "albumArtist", 1).zzc(KEY_ALBUM_TITLE, "albumName", 1).zzc(KEY_COMPOSER, "composer", 1).zzc(KEY_DISC_NUMBER, "discNumber", 2).zzc(KEY_TRACK_NUMBER, "trackNumber", 2).zzc(KEY_SEASON_NUMBER, "season", 2).zzc(KEY_EPISODE_NUMBER, "episode", 2).zzc(KEY_SERIES_TITLE, "seriesTitle", 1).zzc(KEY_STUDIO, "studio", 1).zzc(KEY_WIDTH, "width", 2).zzc(KEY_HEIGHT, "height", 2).zzc(KEY_LOCATION_NAME, "location", 1).zzc(KEY_LOCATION_LATITUDE, "latitude", 3).zzc(KEY_LOCATION_LONGITUDE, "longitude", 3);
    private final Bundle zzaaY;
    private int zzaaZ;
    private final List<WebImage> zzxX;

    private static class zza {
        private final Map<String, String> zzaba = new HashMap();
        private final Map<String, String> zzabb = new HashMap();
        private final Map<String, Integer> zzabc = new HashMap();

        public zza zzc(String str, String str2, int i) {
            this.zzaba.put(str, str2);
            this.zzabb.put(str2, str);
            this.zzabc.put(str, Integer.valueOf(i));
            return this;
        }

        public String zzca(String str) {
            return this.zzaba.get(str);
        }

        public String zzcb(String str) {
            return this.zzabb.get(str);
        }

        public int zzcc(String str) {
            Integer num = this.zzabc.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int i) {
        this.zzxX = new ArrayList();
        this.zzaaY = new Bundle();
        this.zzaaZ = i;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.zzaaY.containsKey(str)) {
                    switch (zzaaX.zzcc(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(zzaaX.zzca(str), this.zzaaY.getString(str));
                            break;
                        case 2:
                            jSONObject.put(zzaaX.zzca(str), this.zzaaY.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(zzaaX.zzca(str), this.zzaaY.getDouble(str));
                            break;
                    }
                }
            }
            for (String str2 : this.zzaaY.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzaaY.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"metadataType".equals(next)) {
                    String zzcb = zzaaX.zzcb(next);
                    if (zzcb == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            this.zzaaY.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzaaY.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzaaY.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzcb)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                switch (zzaaX.zzcc(zzcb)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        } else {
                                            this.zzaaY.putString(zzcb, (String) obj2);
                                            break;
                                        }
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        } else {
                                            this.zzaaY.putInt(zzcb, ((Integer) obj2).intValue());
                                            break;
                                        }
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        } else {
                                            this.zzaaY.putDouble(zzcb, ((Double) obj2).doubleValue());
                                            break;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && zzlp.zzco((String) obj2) != null) {
                                            this.zzaaY.putString(zzcb, (String) obj2);
                                            break;
                                        }
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzb((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzf(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzcc = zzaaX.zzcc(str);
        if (zzcc != i && zzcc != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + zzaaW[i]);
        }
    }

    public void addImage(WebImage webImage) {
        this.zzxX.add(webImage);
    }

    public void clear() {
        this.zzaaY.clear();
        this.zzxX.clear();
    }

    public void clearImages() {
        this.zzxX.clear();
    }

    public boolean containsKey(String str) {
        return this.zzaaY.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof MediaMetadata)) {
                return false;
            }
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            if (!zzb(this.zzaaY, mediaMetadata.zzaaY) || !this.zzxX.equals(mediaMetadata.zzxX)) {
                return false;
            }
        }
        return true;
    }

    public Calendar getDate(String str) {
        zzf(str, 4);
        String string = this.zzaaY.getString(str);
        if (string != null) {
            return zzlp.zzco(string);
        }
        return null;
    }

    public String getDateAsString(String str) {
        zzf(str, 4);
        return this.zzaaY.getString(str);
    }

    public double getDouble(String str) {
        zzf(str, 3);
        return this.zzaaY.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzxX;
    }

    public int getInt(String str) {
        zzf(str, 2);
        return this.zzaaY.getInt(str);
    }

    public int getMediaType() {
        return this.zzaaZ;
    }

    public String getString(String str) {
        zzf(str, 1);
        return this.zzaaY.getString(str);
    }

    public boolean hasImages() {
        return this.zzxX != null && !this.zzxX.isEmpty();
    }

    public int hashCode() {
        Iterator it = this.zzaaY.keySet().iterator();
        int i = 17;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (i2 * 31) + this.zzxX.hashCode();
            }
            i = this.zzaaY.get((String) it.next()).hashCode() + (i2 * 31);
        }
    }

    public Set<String> keySet() {
        return this.zzaaY.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        zzf(str, 4);
        this.zzaaY.putString(str, zzlp.zza(calendar));
    }

    public void putDouble(String str, double d) {
        zzf(str, 3);
        this.zzaaY.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        zzf(str, 2);
        this.zzaaY.putInt(str, i);
    }

    public void putString(String str, String str2) {
        zzf(str, 1);
        this.zzaaY.putString(str, str2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzaaZ);
        } catch (JSONException e) {
        }
        zzlp.zza(jSONObject, this.zzxX);
        switch (this.zzaaZ) {
            case 0:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                zza(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zza(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public void zzg(JSONObject jSONObject) {
        clear();
        this.zzaaZ = 0;
        try {
            this.zzaaZ = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzlp.zza(this.zzxX, jSONObject);
        switch (this.zzaaZ) {
            case 0:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                zzb(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                zzb(jSONObject, new String[0]);
                return;
        }
    }
}
