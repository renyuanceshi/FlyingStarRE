package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx {
    public static String zza(Map<String, String> map) {
        return zzb(map, "ISO-8859-1");
    }

    public static zzb.zza zzb(zzi zzi) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzi.zzA;
        long j4 = 0;
        long j5 = 0;
        String str = map.get("Date");
        if (str != null) {
            j4 = zzg(str);
        }
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(",");
            boolean z3 = false;
            j5 = 0;
            long j6 = 0;
            for (String trim : split) {
                String trim2 = trim.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.startsWith("stale-while-revalidate=")) {
                    try {
                        j5 = Long.parseLong(trim2.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    z3 = true;
                }
            }
            z = z3;
            z2 = true;
            j = j6;
        } else {
            z = false;
            z2 = false;
            j = 0;
        }
        String str3 = map.get("Expires");
        long zzg = str3 != null ? zzg(str3) : 0;
        String str4 = map.get("Last-Modified");
        long zzg2 = str4 != null ? zzg(str4) : 0;
        String str5 = map.get("ETag");
        if (z2) {
            long j7 = (1000 * j) + currentTimeMillis;
            if (z) {
                j2 = j7;
                j3 = j7;
            } else {
                j2 = (j5 * 1000) + j7;
                j3 = j7;
            }
        } else if (j4 <= 0 || zzg < j4) {
            j2 = 0;
            j3 = 0;
        } else {
            long j8 = (zzg - j4) + currentTimeMillis;
            j2 = j8;
            j3 = j8;
        }
        zzb.zza zza = new zzb.zza();
        zza.data = zzi.data;
        zza.zzb = str5;
        zza.zzf = j3;
        zza.zze = j2;
        zza.zzc = j4;
        zza.zzd = zzg2;
        zza.zzg = map;
        return zza;
    }

    public static String zzb(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 == null) {
            return str;
        }
        String[] split = str2.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return str;
    }

    public static long zzg(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }
}
