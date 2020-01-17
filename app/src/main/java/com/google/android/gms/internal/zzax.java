package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzau;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@zzhb
public class zzax implements zzay {
    private final VersionInfoParcel zzpT;
    private final Object zzpV = new Object();
    private final WeakHashMap<zzif, zzau> zzsB = new WeakHashMap<>();
    private final ArrayList<zzau> zzsC = new ArrayList<>();
    private final zzeg zzsD;
    private final Context zzsa;

    public zzax(Context context, VersionInfoParcel versionInfoParcel, zzeg zzeg) {
        this.zzsa = context.getApplicationContext();
        this.zzpT = versionInfoParcel;
        this.zzsD = zzeg;
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif) {
        return zza(adSizeParcel, zzif, zzif.zzED.getView());
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, View view) {
        return zza(adSizeParcel, zzif, (zzbb) new zzau.zzd(view, zzif), (zzeh) null);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, View view, zzeh zzeh) {
        return zza(adSizeParcel, zzif, (zzbb) new zzau.zzd(view, zzif), zzeh);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, zzh zzh) {
        return zza(adSizeParcel, zzif, (zzbb) new zzau.zza(zzh), (zzeh) null);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzif, zzbb zzbb, zzeh zzeh) {
        zzau zzba;
        synchronized (this.zzpV) {
            if (zzh(zzif)) {
                zzba = this.zzsB.get(zzif);
            } else {
                if (zzeh != null) {
                    zzba = new zzaz(this.zzsa, adSizeParcel, zzif, this.zzpT, zzbb, zzeh);
                } else {
                    zzba = new zzba(this.zzsa, adSizeParcel, zzif, this.zzpT, zzbb, this.zzsD);
                }
                zzba.zza((zzay) this);
                this.zzsB.put(zzif, zzba);
                this.zzsC.add(zzba);
            }
        }
        return zzba;
    }

    public void zza(zzau zzau) {
        synchronized (this.zzpV) {
            if (!zzau.zzch()) {
                this.zzsC.remove(zzau);
                Iterator<Map.Entry<zzif, zzau>> it = this.zzsB.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzau) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzh(zzif zzif) {
        boolean z;
        synchronized (this.zzpV) {
            zzau zzau = this.zzsB.get(zzif);
            z = zzau != null && zzau.zzch();
        }
        return z;
    }

    public void zzi(zzif zzif) {
        synchronized (this.zzpV) {
            zzau zzau = this.zzsB.get(zzif);
            if (zzau != null) {
                zzau.zzcf();
            }
        }
    }

    public void zzj(zzif zzif) {
        synchronized (this.zzpV) {
            zzau zzau = this.zzsB.get(zzif);
            if (zzau != null) {
                zzau.stop();
            }
        }
    }

    public void zzk(zzif zzif) {
        synchronized (this.zzpV) {
            zzau zzau = this.zzsB.get(zzif);
            if (zzau != null) {
                zzau.pause();
            }
        }
    }

    public void zzl(zzif zzif) {
        synchronized (this.zzpV) {
            zzau zzau = this.zzsB.get(zzif);
            if (zzau != null) {
                zzau.resume();
            }
        }
    }
}
