package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcp;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzhb
public class zzf extends zzcp.zza implements zzh.zza {
    private final Object zzpV = new Object();
    private final zza zzye;
    private zzh zzyf;
    private final String zzyi;
    private final SimpleArrayMap<String, zzc> zzyj;
    private final SimpleArrayMap<String, String> zzyk;

    public zzf(String str, SimpleArrayMap<String, zzc> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zza zza) {
        this.zzyi = str;
        this.zzyj = simpleArrayMap;
        this.zzyk = simpleArrayMap2;
        this.zzye = zza;
    }

    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.zzyj.size() + this.zzyk.size())];
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.zzyj.size()) {
            strArr[i2] = this.zzyj.keyAt(i3);
            i3++;
            i2++;
        }
        while (i < this.zzyk.size()) {
            strArr[i2] = this.zzyk.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.zzyi;
    }

    public void performClick(String str) {
        synchronized (this.zzpV) {
            if (this.zzyf == null) {
                zzin.e("Attempt to call performClick before ad initialized.");
            } else {
                this.zzyf.zza(str, (JSONObject) null, (JSONObject) null, (JSONObject) null);
            }
        }
    }

    public void recordImpression() {
        synchronized (this.zzpV) {
            if (this.zzyf == null) {
                zzin.e("Attempt to perform recordImpression before ad initialized.");
            } else {
                this.zzyf.recordImpression();
            }
        }
    }

    public String zzO(String str) {
        return this.zzyk.get(str);
    }

    public zzch zzP(String str) {
        return this.zzyj.get(str);
    }

    public void zzb(zzh zzh) {
        synchronized (this.zzpV) {
            this.zzyf = zzh;
        }
    }

    public String zzdM() {
        return "3";
    }

    public zza zzdN() {
        return this.zzye;
    }
}
