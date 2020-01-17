package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzed;
import java.util.concurrent.Future;

@zzhb
public class zzee {

    private static class zza<JavascriptEngine> extends zzjd<JavascriptEngine> {
        JavascriptEngine zzAR;

        private zza() {
        }
    }

    /* access modifiers changed from: private */
    public zzed zza(Context context, VersionInfoParcel versionInfoParcel, final zza<zzed> zza2, zzan zzan) {
        JavascriptEngine zzef = new zzef(context, versionInfoParcel, zzan);
        zza2.zzAR = zzef;
        zzef.zza(new zzed.zza() {
            public void zzeo() {
                zza2.zzg(zza2.zzAR);
            }
        });
        return zzef;
    }

    public Future<zzed> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzan zzan) {
        final zza zza2 = new zza();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final zzan zzan2 = zzan;
        final String str2 = str;
        zzir.zzMc.post(new Runnable() {
            public void run() {
                zzee.this.zza(context2, versionInfoParcel2, (zza<zzed>) zza2, zzan2).zzaa(str2);
            }
        });
        return zza2;
    }
}
