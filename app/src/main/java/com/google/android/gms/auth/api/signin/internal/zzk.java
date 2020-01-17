package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzk {
    private final Map<zzd, zzlf> zzXD;

    public zzk(Activity activity, List<zzd> list, Map<zzd, List<String>> map) {
        zzx.zzz(activity);
        zzx.zzz(list);
        zzx.zzz(map);
        HashMap hashMap = new HashMap();
        for (zzd next : list) {
            List list2 = map.get(next);
            zzlf zza = zza(next, activity, list2 == null ? Collections.emptyList() : list2);
            if (zza != null) {
                hashMap.put(next, zza);
            }
        }
        this.zzXD = Collections.unmodifiableMap(hashMap);
    }

    private zzlf zza(zzd zzd, Activity activity, List<String> list) {
        if (zzd.FACEBOOK.equals(zzd)) {
            return new zzlh(activity, list);
        }
        return null;
    }

    public zzlf zza(zzd zzd) {
        zzx.zzz(zzd);
        return this.zzXD.get(zzd);
    }

    public Collection<zzlf> zznh() {
        return this.zzXD.values();
    }
}
