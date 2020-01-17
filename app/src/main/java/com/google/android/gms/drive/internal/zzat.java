package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import java.io.IOException;

public final class zzat extends zzso<zzat> {
    public int versionCode;
    public long zzarW;
    public String zzarY;
    public long zzarZ;
    public int zzasa;

    public zzat() {
        zztl();
    }

    public static zzat zzm(byte[] bArr) throws zzst {
        return (zzat) zzsu.mergeFrom(new zzat(), bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r7.zzarY == null) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 != r6) goto L_0x0005
        L_0x0004:
            return r0
        L_0x0005:
            boolean r2 = r7 instanceof com.google.android.gms.drive.internal.zzat
            if (r2 == 0) goto L_0x0047
            com.google.android.gms.drive.internal.zzat r7 = (com.google.android.gms.drive.internal.zzat) r7
            int r2 = r6.versionCode
            int r3 = r7.versionCode
            if (r2 != r3) goto L_0x0047
            java.lang.String r2 = r6.zzarY
            if (r2 != 0) goto L_0x0049
            java.lang.String r2 = r7.zzarY
            if (r2 != 0) goto L_0x0047
        L_0x0019:
            long r2 = r6.zzarZ
            long r4 = r7.zzarZ
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0047
            long r2 = r6.zzarW
            long r4 = r7.zzarW
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0047
            int r2 = r6.zzasa
            int r3 = r7.zzasa
            if (r2 != r3) goto L_0x0047
            com.google.android.gms.internal.zzsq r2 = r6.zzbuj
            if (r2 == 0) goto L_0x003b
            com.google.android.gms.internal.zzsq r2 = r6.zzbuj
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0055
        L_0x003b:
            com.google.android.gms.internal.zzsq r2 = r7.zzbuj
            if (r2 == 0) goto L_0x0004
            com.google.android.gms.internal.zzsq r2 = r7.zzbuj
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0004
        L_0x0047:
            r0 = r1
            goto L_0x0004
        L_0x0049:
            java.lang.String r2 = r6.zzarY
            java.lang.String r3 = r7.zzarY
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0019
            r0 = r1
            goto L_0x0004
        L_0x0055:
            com.google.android.gms.internal.zzsq r0 = r6.zzbuj
            com.google.android.gms.internal.zzsq r1 = r7.zzbuj
            boolean r0 = r0.equals(r1)
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzat.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode();
        int i2 = this.versionCode;
        int hashCode2 = this.zzarY == null ? 0 : this.zzarY.hashCode();
        int i3 = (int) (this.zzarZ ^ (this.zzarZ >>> 32));
        int i4 = (int) (this.zzarW ^ (this.zzarW >>> 32));
        int i5 = this.zzasa;
        if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
            i = this.zzbuj.hashCode();
        }
        return ((((((((hashCode2 + ((((hashCode + 527) * 31) + i2) * 31)) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i;
    }

    public void writeTo(zzsn zzsn) throws IOException {
        zzsn.zzA(1, this.versionCode);
        zzsn.zzn(2, this.zzarY);
        zzsn.zzc(3, this.zzarZ);
        zzsn.zzc(4, this.zzarW);
        if (this.zzasa != -1) {
            zzsn.zzA(5, this.zzasa);
        }
        super.writeTo(zzsn);
    }

    /* renamed from: zzm */
    public zzat mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzsm.zzJb();
                    continue;
                case 18:
                    this.zzarY = zzsm.readString();
                    continue;
                case 24:
                    this.zzarZ = zzsm.zzJe();
                    continue;
                case 32:
                    this.zzarW = zzsm.zzJe();
                    continue;
                case 40:
                    this.zzasa = zzsm.zzJb();
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

    public zzat zztl() {
        this.versionCode = 1;
        this.zzarY = "";
        this.zzarZ = -1;
        this.zzarW = -1;
        this.zzasa = -1;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    public int zzz() {
        int zzz = super.zzz() + zzsn.zzC(1, this.versionCode) + zzsn.zzo(2, this.zzarY) + zzsn.zze(3, this.zzarZ) + zzsn.zze(4, this.zzarW);
        return this.zzasa != -1 ? zzz + zzsn.zzC(5, this.zzasa) : zzz;
    }
}
