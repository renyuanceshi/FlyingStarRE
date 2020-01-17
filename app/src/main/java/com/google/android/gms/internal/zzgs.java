package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzjq;

@zzhb
public class zzgs extends zzgn implements zzjq.zza {
    zzgs(Context context, zzif.zza zza, zzjp zzjp, zzgr.zza zza2) {
        super(context, zza, zzjp, zza2);
    }

    /* access modifiers changed from: protected */
    public void zzgb() {
        if (this.zzGe.errorCode == -2) {
            this.zzpD.zzhU().zza((zzjq.zza) this);
            zzgi();
            zzin.zzaI("Loading HTML in WebView.");
            this.zzpD.loadDataWithBaseURL(zzr.zzbC().zzaC(this.zzGe.zzEF), this.zzGe.body, "text/html", "UTF-8", (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public void zzgi() {
    }
}
