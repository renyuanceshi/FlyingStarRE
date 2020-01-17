package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzea;
import com.google.android.gms.internal.zzhj;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@zzhb
public class zzdy {
    private final Map<zzdz, zzea> zzAx = new HashMap();
    private final LinkedList<zzdz> zzAy = new LinkedList<>();
    private zzdv zzAz;

    private String[] zzY(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static void zza(String str, zzdz zzdz) {
        if (zzin.zzQ(2)) {
            zzin.v(String.format(str, new Object[]{zzdz}));
        }
    }

    private String zzef() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.zzAy.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(((zzdz) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        while (this.zzAy.size() > 0) {
            zzdz remove = this.zzAy.remove();
            zzea zzea = this.zzAx.get(remove);
            zza("Flushing interstitial queue for %s.", remove);
            while (zzea.size() > 0) {
                zzea.zzej().zzAD.zzbp();
            }
            this.zzAx.remove(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void restore() {
        if (this.zzAz != null) {
            SharedPreferences sharedPreferences = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            HashMap hashMap = new HashMap();
            for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) next.getKey()).equals("PoolKeys")) {
                        zzec zzec = new zzec((String) next.getValue());
                        zzdz zzdz = new zzdz(zzec.zzqH, zzec.zzpS, zzec.zzAC);
                        if (!this.zzAx.containsKey(zzdz)) {
                            this.zzAx.put(zzdz, new zzea(zzec.zzqH, zzec.zzpS, zzec.zzAC));
                            hashMap.put(zzdz.toString(), zzdz);
                            zza("Restored interstitial queue for %s.", zzdz);
                        }
                    }
                } catch (IOException | ClassCastException e) {
                    zzin.zzd("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            for (String str : zzY(sharedPreferences.getString("PoolKeys", ""))) {
                zzdz zzdz2 = (zzdz) hashMap.get(str);
                if (this.zzAx.containsKey(zzdz2)) {
                    this.zzAy.add(zzdz2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void save() {
        if (this.zzAz != null) {
            SharedPreferences.Editor edit = this.zzAz.zzed().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry next : this.zzAx.entrySet()) {
                zzdz zzdz = (zzdz) next.getKey();
                if (zzdz.zzeh()) {
                    edit.putString(zzdz.toString(), new zzec((zzea) next.getValue()).zzem());
                    zza("Saved interstitial queue for %s.", zzdz);
                }
            }
            edit.putString("PoolKeys", zzef());
            edit.commit();
        }
    }

    /* access modifiers changed from: package-private */
    public zzea.zza zza(AdRequestParcel adRequestParcel, String str) {
        zzea zzea;
        int i = new zzhj.zza(this.zzAz.zzed()).zzgI().zzKc;
        zzdz zzdz = new zzdz(adRequestParcel, str, i);
        zzea zzea2 = this.zzAx.get(zzdz);
        if (zzea2 == null) {
            zza("Interstitial pool created at %s.", zzdz);
            zzea zzea3 = new zzea(adRequestParcel, str, i);
            this.zzAx.put(zzdz, zzea3);
            zzea = zzea3;
        } else {
            zzea = zzea2;
        }
        this.zzAy.remove(zzdz);
        this.zzAy.add(zzdz);
        zzdz.zzeg();
        while (this.zzAy.size() > zzbt.zzwG.get().intValue()) {
            zzdz remove = this.zzAy.remove();
            zzea zzea4 = this.zzAx.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zzea4.size() > 0) {
                zzea4.zzej().zzAD.zzbp();
            }
            this.zzAx.remove(remove);
        }
        while (zzea.size() > 0) {
            zzea.zza zzej = zzea.zzej();
            if (!zzej.zzAG || zzr.zzbG().currentTimeMillis() - zzej.zzAF <= 1000 * ((long) zzbt.zzwI.get().intValue())) {
                zza("Pooled interstitial returned at %s.", zzdz);
                return zzej;
            }
            zza("Expired interstitial at %s.", zzdz);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzdv zzdv) {
        if (this.zzAz == null) {
            this.zzAz = zzdv;
            restore();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzee() {
        if (this.zzAz != null) {
            for (Map.Entry next : this.zzAx.entrySet()) {
                zzdz zzdz = (zzdz) next.getKey();
                zzea zzea = (zzea) next.getValue();
                while (zzea.size() < zzbt.zzwH.get().intValue()) {
                    zza("Pooling one interstitial for %s.", zzdz);
                    zzea.zzb(this.zzAz);
                }
            }
            save();
        }
    }
}
