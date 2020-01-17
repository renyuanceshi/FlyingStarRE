package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzhb
public class zzcb {
    private final Object zzpV = new Object();
    private final Map<String, String> zzxA = new LinkedHashMap();
    private String zzxB;
    private zzbz zzxC;
    private zzcb zzxD;
    boolean zzxi;
    private final List<zzbz> zzxz = new LinkedList();

    public zzcb(boolean z, String str, String str2) {
        this.zzxi = z;
        this.zzxA.put("action", str);
        this.zzxA.put("ad_format", str2);
    }

    public void zzN(String str) {
        if (this.zzxi) {
            synchronized (this.zzpV) {
                this.zzxB = str;
            }
        }
    }

    public boolean zza(zzbz zzbz, long j, String... strArr) {
        synchronized (this.zzpV) {
            for (String zzbz2 : strArr) {
                this.zzxz.add(new zzbz(j, zzbz2, zzbz));
            }
        }
        return true;
    }

    public boolean zza(zzbz zzbz, String... strArr) {
        if (!this.zzxi || zzbz == null) {
            return false;
        }
        return zza(zzbz, zzr.zzbG().elapsedRealtime(), strArr);
    }

    public zzbz zzb(long j) {
        if (!this.zzxi) {
            return null;
        }
        return new zzbz(j, (String) null, (zzbz) null);
    }

    public void zzc(zzcb zzcb) {
        synchronized (this.zzpV) {
            this.zzxD = zzcb;
        }
    }

    public void zzc(String str, String str2) {
        zzbv zzhb;
        if (this.zzxi && !TextUtils.isEmpty(str2) && (zzhb = zzr.zzbF().zzhb()) != null) {
            synchronized (this.zzpV) {
                zzhb.zzL(str).zza(this.zzxA, str, str2);
            }
        }
    }

    public zzbz zzdB() {
        return zzb(zzr.zzbG().elapsedRealtime());
    }

    public void zzdC() {
        synchronized (this.zzpV) {
            this.zzxC = zzdB();
        }
    }

    public String zzdD() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.zzpV) {
            for (zzbz next : this.zzxz) {
                long time = next.getTime();
                String zzdy = next.zzdy();
                zzbz zzdz = next.zzdz();
                if (zzdz != null && time > 0) {
                    sb2.append(zzdy).append('.').append(time - zzdz.getTime()).append(',');
                }
            }
            this.zzxz.clear();
            if (!TextUtils.isEmpty(this.zzxB)) {
                sb2.append(this.zzxB);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public zzbz zzdE() {
        zzbz zzbz;
        synchronized (this.zzpV) {
            zzbz = this.zzxC;
        }
        return zzbz;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzn() {
        Map<String, String> zza;
        synchronized (this.zzpV) {
            zzbv zzhb = zzr.zzbF().zzhb();
            zza = (zzhb == null || this.zzxD == null) ? this.zzxA : zzhb.zza(this.zzxA, this.zzxD.zzn());
        }
        return zza;
    }
}
