package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsk extends zzso<zzsk> {
    public String[] zzbtT;
    public int[] zzbtU;
    public byte[][] zzbtV;

    public zzsk() {
        zzIW();
    }

    public static zzsk zzB(byte[] bArr) throws zzst {
        return (zzsk) zzsu.mergeFrom(new zzsk(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzsk) {
            zzsk zzsk = (zzsk) obj;
            if (zzss.equals((Object[]) this.zzbtT, (Object[]) zzsk.zzbtT) && zzss.equals(this.zzbtU, zzsk.zzbtU) && zzss.zza(this.zzbtV, zzsk.zzbtV)) {
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    return this.zzbuj.equals(zzsk.zzbuj);
                }
                if (zzsk.zzbuj == null || zzsk.zzbuj.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getClass().getName().hashCode();
        int hashCode2 = zzss.hashCode((Object[]) this.zzbtT);
        int hashCode3 = zzss.hashCode(this.zzbtU);
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + zzss.zza(this.zzbtV)) * 31);
    }

    public void writeTo(zzsn zzsn) throws IOException {
        if (this.zzbtT != null && this.zzbtT.length > 0) {
            for (String str : this.zzbtT) {
                if (str != null) {
                    zzsn.zzn(1, str);
                }
            }
        }
        if (this.zzbtU != null && this.zzbtU.length > 0) {
            for (int zzA : this.zzbtU) {
                zzsn.zzA(2, zzA);
            }
        }
        if (this.zzbtV != null && this.zzbtV.length > 0) {
            for (byte[] bArr : this.zzbtV) {
                if (bArr != null) {
                    zzsn.zza(3, bArr);
                }
            }
        }
        super.writeTo(zzsn);
    }

    public zzsk zzIW() {
        this.zzbtT = zzsx.zzbuB;
        this.zzbtU = zzsx.zzbuw;
        this.zzbtV = zzsx.zzbuC;
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* renamed from: zzO */
    public zzsk mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 10:
                    int zzc = zzsx.zzc(zzsm, 10);
                    int length = this.zzbtT == null ? 0 : this.zzbtT.length;
                    String[] strArr = new String[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbtT, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzsm.readString();
                        zzsm.zzIX();
                        length++;
                    }
                    strArr[length] = zzsm.readString();
                    this.zzbtT = strArr;
                    continue;
                case 16:
                    int zzc2 = zzsx.zzc(zzsm, 16);
                    int length2 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr = new int[(zzc2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzsm.zzJb();
                        zzsm.zzIX();
                        length2++;
                    }
                    iArr[length2] = zzsm.zzJb();
                    this.zzbtU = iArr;
                    continue;
                case 18:
                    int zzmq = zzsm.zzmq(zzsm.zzJf());
                    int position = zzsm.getPosition();
                    int i = 0;
                    while (zzsm.zzJk() > 0) {
                        zzsm.zzJb();
                        i++;
                    }
                    zzsm.zzms(position);
                    int length3 = this.zzbtU == null ? 0 : this.zzbtU.length;
                    int[] iArr2 = new int[(i + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbtU, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzsm.zzJb();
                        length3++;
                    }
                    this.zzbtU = iArr2;
                    zzsm.zzmr(zzmq);
                    continue;
                case 26:
                    int zzc3 = zzsx.zzc(zzsm, 26);
                    int length4 = this.zzbtV == null ? 0 : this.zzbtV.length;
                    byte[][] bArr = new byte[(zzc3 + length4)][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbtV, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzsm.readBytes();
                        zzsm.zzIX();
                        length4++;
                    }
                    bArr[length4] = zzsm.readBytes();
                    this.zzbtV = bArr;
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

    /* access modifiers changed from: protected */
    public int zzz() {
        int i;
        int i2;
        int i3 = 0;
        int zzz = super.zzz();
        if (this.zzbtT == null || this.zzbtT.length <= 0) {
            i = zzz;
        } else {
            int i4 = 0;
            int i5 = 0;
            for (String str : this.zzbtT) {
                if (str != null) {
                    i4++;
                    i5 += zzsn.zzgO(str);
                }
            }
            i = (i4 * 1) + i5 + zzz;
        }
        if (this.zzbtU == null || this.zzbtU.length <= 0) {
            i2 = i;
        } else {
            int i6 = 0;
            for (int zzmx : this.zzbtU) {
                i6 += zzsn.zzmx(zzmx);
            }
            i2 = i + i6 + (this.zzbtU.length * 1);
        }
        if (this.zzbtV == null || this.zzbtV.length <= 0) {
            return i2;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = i3;
            if (i7 >= this.zzbtV.length) {
                return i2 + i9 + (i8 * 1);
            }
            byte[] bArr = this.zzbtV[i7];
            if (bArr != null) {
                i8++;
                i3 = zzsn.zzG(bArr) + i9;
            } else {
                i3 = i9;
            }
            i7++;
        }
    }
}
