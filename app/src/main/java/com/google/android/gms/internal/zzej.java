package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzhb
public class zzej implements zzei {
    private final zzeh zzBx;
    private final HashSet<AbstractMap.SimpleEntry<String, zzdf>> zzBy = new HashSet<>();

    public zzej(zzeh zzeh) {
        this.zzBx = zzeh;
    }

    public void zza(String str, zzdf zzdf) {
        this.zzBx.zza(str, zzdf);
        this.zzBy.add(new AbstractMap.SimpleEntry(str, zzdf));
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzBx.zza(str, jSONObject);
    }

    public void zzb(String str, zzdf zzdf) {
        this.zzBx.zzb(str, zzdf);
        this.zzBy.remove(new AbstractMap.SimpleEntry(str, zzdf));
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzBx.zzb(str, jSONObject);
    }

    public void zze(String str, String str2) {
        this.zzBx.zze(str, str2);
    }

    public void zzew() {
        Iterator<AbstractMap.SimpleEntry<String, zzdf>> it = this.zzBy.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            zzin.v("Unregistering eventhandler: " + ((zzdf) next.getValue()).toString());
            this.zzBx.zzb((String) next.getKey(), (zzdf) next.getValue());
        }
        this.zzBy.clear();
    }
}
