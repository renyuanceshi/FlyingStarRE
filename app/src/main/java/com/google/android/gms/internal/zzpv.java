package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

public final class zzpv extends zze<zzpv> {
    public boolean zzaUP;
    public String zzaxl;

    public String getDescription() {
        return this.zzaxl;
    }

    public void setDescription(String str) {
        this.zzaxl = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaxl);
        hashMap.put("fatal", Boolean.valueOf(this.zzaUP));
        return zzF(hashMap);
    }

    public boolean zzBa() {
        return this.zzaUP;
    }

    public void zza(zzpv zzpv) {
        if (!TextUtils.isEmpty(this.zzaxl)) {
            zzpv.setDescription(this.zzaxl);
        }
        if (this.zzaUP) {
            zzpv.zzao(this.zzaUP);
        }
    }

    public void zzao(boolean z) {
        this.zzaUP = z;
    }
}
