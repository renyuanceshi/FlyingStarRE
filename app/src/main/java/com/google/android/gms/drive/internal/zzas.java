package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

public final class zzas extends zzso<zzas> {
    public int versionCode;
    public long zzarV;
    public long zzarW;
    public long zzarX;

    public zzas() {
        zztk();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzas) {
            zzas zzas = (zzas) obj;
            if (this.versionCode == zzas.versionCode && this.zzarV == zzas.zzarV && this.zzarW == zzas.zzarW && this.zzarX == zzas.zzarX) {
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    return this.zzbuj.equals(zzas.zzbuj);
                }
                if (zzas.zzbuj == null || zzas.zzbuj.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getClass().getName().hashCode();
        int i = this.versionCode;
        int i2 = (int) (this.zzarV ^ (this.zzarV >>> 32));
        int i3 = (int) (this.zzarW ^ (this.zzarW >>> 32));
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((hashCode + 527) * 31) + i) * 31) + i2) * 31) + i3) * 31) + ((int) (this.zzarX ^ (this.zzarX >>> 32)))) * 31);
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzA(1, this.versionCode);
        zzsn.zzc(2, this.zzarV);
        zzsn.zzc(3, this.zzarW);
        zzsn.zzc(4, this.zzarX);
        super.writeTo(zzsn);
    }

    /* renamed from: zzl */
    public zzas mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsm.zzJb();
                    continue;
                case 16:
                    this.zzarV = zzsm.zzJe();
                    continue;
                case 24:
                    this.zzarW = zzsm.zzJe();
                    continue;
                case 32:
                    this.zzarX = zzsm.zzJe();
                    continue;
                default:
                    if (!zza(zzsm, zzIX)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public zzas zztk() {
        this.versionCode = 1;
        this.zzarV = -1;
        this.zzarW = -1;
        this.zzarX = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        return super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zze(2, this.zzarV) + zzsn.zze(3, this.zzarW) + zzsn.zze(4, this.zzarX);
    }
}
