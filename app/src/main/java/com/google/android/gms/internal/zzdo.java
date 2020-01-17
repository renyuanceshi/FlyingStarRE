package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.overlay.zzk;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzhb
public final class zzdo implements zzdf {
    private final Map<zzjp, Integer> zzzI = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return zzn.zzcS().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzin.zzaK("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        int i;
        zzk zzhM;
        String str = map.get("action");
        if (str == null) {
            zzin.zzaK("Action missing from video GMSG.");
            return;
        }
        if (zzin.zzQ(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzin.zzaI("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzin.zzaK("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzjo zzia = zzjp.zzia();
                if (zzia == null || (zzhM = zzia.zzhM()) == null) {
                    this.zzzI.put(zzjp, Integer.valueOf(parseColor));
                } else {
                    zzhM.setBackgroundColor(parseColor);
                }
            } catch (IllegalArgumentException e) {
                zzin.zzaK("Invalid color parameter in video GMSG.");
            }
        } else {
            zzjo zzia2 = zzjp.zzia();
            if (zzia2 == null) {
                zzin.zzaK("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzjp.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                try {
                    i = Integer.parseInt(map.get("player"));
                } catch (NumberFormatException e2) {
                    i = 0;
                }
                if (!equals || zzia2.zzhM() != null) {
                    zzia2.zze(zza, zza2, zza3, zza4);
                    return;
                }
                zzia2.zza(zza, zza2, zza3, zza4, i);
                if (this.zzzI.containsKey(zzjp)) {
                    int intValue = this.zzzI.get(zzjp).intValue();
                    zzk zzhM2 = zzia2.zzhM();
                    zzhM2.setBackgroundColor(intValue);
                    zzhM2.zzfE();
                    return;
                }
                return;
            }
            zzk zzhM3 = zzia2.zzhM();
            if (zzhM3 == null) {
                zzk.zzg(zzjp);
            } else if ("click".equals(str)) {
                Context context2 = zzjp.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzhM3.zzd(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str3 = map.get("time");
                if (str3 == null) {
                    zzin.zzaK("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzhM3.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e3) {
                    zzin.zzaK("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equals(str)) {
                zzhM3.setVisibility(4);
            } else if ("load".equals(str)) {
                zzhM3.zzfD();
            } else if ("mimetype".equals(str)) {
                zzhM3.setMimeType(map.get("mimetype"));
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean(map.get("muted"))) {
                    zzhM3.zzff();
                } else {
                    zzhM3.zzfg();
                }
            } else if ("pause".equals(str)) {
                zzhM3.pause();
            } else if ("play".equals(str)) {
                zzhM3.play();
            } else if ("show".equals(str)) {
                zzhM3.setVisibility(0);
            } else if ("src".equals(str)) {
                zzhM3.zzap(map.get("src"));
            } else if ("volume".equals(str)) {
                String str4 = map.get("volume");
                if (str4 == null) {
                    zzin.zzaK("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzhM3.zza(Float.parseFloat(str4));
                } catch (NumberFormatException e4) {
                    zzin.zzaK("Could not parse volume parameter from volume video GMSG: " + str4);
                }
            } else if ("watermark".equals(str)) {
                zzhM3.zzfE();
            } else {
                zzin.zzaK("Unknown video action: " + str);
            }
        }
    }
}
