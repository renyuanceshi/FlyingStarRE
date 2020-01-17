package com.google.android.gms.internal;

import java.util.Map;

@zzhb
public final class zzda implements zzdf {
    private final zzdb zzyW;

    public zzda(zzdb zzdb) {
        this.zzyW = zzdb;
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzin.zzaK("App event with no name parameter.");
        } else {
            this.zzyW.onAppEvent(str, map.get("info"));
        }
    }
}
