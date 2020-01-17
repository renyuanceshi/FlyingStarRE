package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import java.io.IOException;

public final class zzau extends zzso<zzau> {
    public long zzarW;
    public long zzarZ;

    public zzau() {
        zztm();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzau) {
            zzau zzau = (zzau) obj;
            if (this.zzarZ == zzau.zzarZ && this.zzarW == zzau.zzarW) {
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    return this.zzbuj.equals(zzau.zzbuj);
                }
                if (zzau.zzbuj == null || zzau.zzbuj.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getClass().getName().hashCode();
        int i = (int) (this.zzarZ ^ (this.zzarZ >>> 32));
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((hashCode + 527) * 31) + i) * 31) + ((int) (this.zzarW ^ (this.zzarW >>> 32)))) * 31);
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzc(1, this.zzarZ);
        zzsn.zzc(2, this.zzarW);
        super.writeTo(zzsn);
    }

    /* renamed from: zzn */
    public zzau mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.zzarZ = zzsm.zzJe();
                    continue;
                case 16:
                    this.zzarW = zzsm.zzJe();
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

    public zzau zztm() {
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        return super.zzz() + zzsn.zze(1, this.zzarZ) + zzsn.zze(2, this.zzarW);
    }
}
