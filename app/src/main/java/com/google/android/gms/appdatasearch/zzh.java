package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] zzUb = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> zzUc = new HashMap(zzUb.length);

    static {
        for (int i = 0; i < zzUb.length; i++) {
            zzUc.put(zzUb[i], Integer.valueOf(i));
        }
    }

    public static String zzao(int i) {
        if (i < 0 || i >= zzUb.length) {
            return null;
        }
        return zzUb[i];
    }

    public static int zzbA(String str) {
        Integer num = zzUc.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
    }

    public static int zzmg() {
        return zzUb.length;
    }
}
