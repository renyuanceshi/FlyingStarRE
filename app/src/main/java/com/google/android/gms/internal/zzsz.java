package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;

public interface zzsz {

    public static final class zza extends zzso<zza> {
        public String[] zzbuI;
        public String[] zzbuJ;
        public int[] zzbuK;
        public long[] zzbuL;

        public zza() {
            zzJC();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zza) {
                zza zza = (zza) obj;
                if (zzss.equals((Object[]) this.zzbuI, (Object[]) zza.zzbuI) && zzss.equals((Object[]) this.zzbuJ, (Object[]) zza.zzbuJ) && zzss.equals(this.zzbuK, zza.zzbuK) && zzss.equals(this.zzbuL, zza.zzbuL)) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zza.zzbuj);
                    }
                    if (zza.zzbuj == null || zza.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode((Object[]) this.zzbuI);
            int hashCode3 = zzss.hashCode((Object[]) this.zzbuJ);
            int hashCode4 = zzss.hashCode(this.zzbuK);
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + zzss.hashCode(this.zzbuL)) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbuI != null && this.zzbuI.length > 0) {
                for (String str : this.zzbuI) {
                    if (str != null) {
                        zzsn.zzn(1, str);
                    }
                }
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                for (String str2 : this.zzbuJ) {
                    if (str2 != null) {
                        zzsn.zzn(2, str2);
                    }
                }
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                for (int zzA : this.zzbuK) {
                    zzsn.zzA(3, zzA);
                }
            }
            if (this.zzbuL != null && this.zzbuL.length > 0) {
                for (long zzb : this.zzbuL) {
                    zzsn.zzb(4, zzb);
                }
            }
            super.writeTo(zzsn);
        }

        public zza zzJC() {
            this.zzbuI = zzsx.zzbuB;
            this.zzbuJ = zzsx.zzbuB;
            this.zzbuK = zzsx.zzbuw;
            this.zzbuL = zzsx.zzbux;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzS */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzbuI == null ? 0 : this.zzbuI.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuI, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsm.readString();
                            zzsm.zzIX();
                            length++;
                        }
                        strArr[length] = zzsm.readString();
                        this.zzbuI = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzsx.zzc(zzsm, 18);
                        int length2 = this.zzbuJ == null ? 0 : this.zzbuJ.length;
                        String[] strArr2 = new String[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbuJ, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzsm.readString();
                            zzsm.zzIX();
                            length2++;
                        }
                        strArr2[length2] = zzsm.readString();
                        this.zzbuJ = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzsx.zzc(zzsm, 24);
                        int length3 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr = new int[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzsm.zzJb();
                            zzsm.zzIX();
                            length3++;
                        }
                        iArr[length3] = zzsm.zzJb();
                        this.zzbuK = iArr;
                        continue;
                    case 26:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length4 = this.zzbuK == null ? 0 : this.zzbuK.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbuK, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzsm.zzJb();
                            length4++;
                        }
                        this.zzbuK = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        int zzc4 = zzsx.zzc(zzsm, 32);
                        int length5 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr = new long[(zzc4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzsm.zzJa();
                            zzsm.zzIX();
                            length5++;
                        }
                        jArr[length5] = zzsm.zzJa();
                        this.zzbuL = jArr;
                        continue;
                    case 34:
                        int zzmq2 = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i2 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJa();
                            i2++;
                        }
                        zzsm.zzms(position2);
                        int length6 = this.zzbuL == null ? 0 : this.zzbuL.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbuL, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzsm.zzJa();
                            length6++;
                        }
                        this.zzbuL = jArr2;
                        zzsm.zzmr(zzmq2);
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
            int zzz = super.zzz();
            if (this.zzbuI != null && this.zzbuI.length > 0) {
                int i = 0;
                int i2 = 0;
                for (String str : this.zzbuI) {
                    if (str != null) {
                        i++;
                        i2 += zzsn.zzgO(str);
                    }
                }
                zzz = (i * 1) + i2 + zzz;
            }
            if (this.zzbuJ != null && this.zzbuJ.length > 0) {
                int i3 = 0;
                int i4 = 0;
                for (String str2 : this.zzbuJ) {
                    if (str2 != null) {
                        i3++;
                        i4 += zzsn.zzgO(str2);
                    }
                }
                zzz = zzz + i4 + (i3 * 1);
            }
            if (this.zzbuK != null && this.zzbuK.length > 0) {
                int i5 = 0;
                for (int zzmx : this.zzbuK) {
                    i5 += zzsn.zzmx(zzmx);
                }
                zzz = zzz + i5 + (this.zzbuK.length * 1);
            }
            if (this.zzbuL == null || this.zzbuL.length <= 0) {
                return zzz;
            }
            int i6 = 0;
            for (long zzas : this.zzbuL) {
                i6 += zzsn.zzas(zzas);
            }
            return zzz + i6 + (this.zzbuL.length * 1);
        }
    }

    public static final class zzb extends zzso<zzb> {
        public String version;
        public int zzbuM;
        public String zzbuN;

        public zzb() {
            zzJD();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r5.version == null) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5.zzbuN == null) goto L_0x0019;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                if (r5 != r4) goto L_0x0005
            L_0x0004:
                return r0
            L_0x0005:
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzsz.zzb
                if (r2 == 0) goto L_0x0039
                com.google.android.gms.internal.zzsz$zzb r5 = (com.google.android.gms.internal.zzsz.zzb) r5
                int r2 = r4.zzbuM
                int r3 = r5.zzbuM
                if (r2 != r3) goto L_0x0039
                java.lang.String r2 = r4.zzbuN
                if (r2 != 0) goto L_0x003b
                java.lang.String r2 = r5.zzbuN
                if (r2 != 0) goto L_0x0039
            L_0x0019:
                java.lang.String r2 = r4.version
                if (r2 != 0) goto L_0x0047
                java.lang.String r2 = r5.version
                if (r2 != 0) goto L_0x0039
            L_0x0021:
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x002d
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0053
            L_0x002d:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0039:
                r0 = r1
                goto L_0x0004
            L_0x003b:
                java.lang.String r2 = r4.zzbuN
                java.lang.String r3 = r5.zzbuN
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0019
                r0 = r1
                goto L_0x0004
            L_0x0047:
                java.lang.String r2 = r4.version
                java.lang.String r3 = r5.version
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0021
                r0 = r1
                goto L_0x0004
            L_0x0053:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zzb.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int i2 = this.zzbuM;
            int hashCode2 = this.zzbuN == null ? 0 : this.zzbuN.hashCode();
            int hashCode3 = this.version == null ? 0 : this.version.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((((hashCode + 527) * 31) + i2) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbuM != 0) {
                zzsn.zzA(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                zzsn.zzn(2, this.zzbuN);
            }
            if (!this.version.equals("")) {
                zzsn.zzn(3, this.version);
            }
            super.writeTo(zzsn);
        }

        public zzb zzJD() {
            this.zzbuM = 0;
            this.zzbuN = "";
            this.version = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzT */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbuM = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbuN = zzsm.readString();
                        continue;
                    case 26:
                        this.version = zzsm.readString();
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
            int zzz = super.zzz();
            if (this.zzbuM != 0) {
                zzz += zzsn.zzC(1, this.zzbuM);
            }
            if (!this.zzbuN.equals("")) {
                zzz += zzsn.zzo(2, this.zzbuN);
            }
            return !this.version.equals("") ? zzz + zzsn.zzo(3, this.version) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public byte[] zzbuO;
        public byte[][] zzbuP;
        public boolean zzbuQ;

        public zzc() {
            zzJE();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzc) {
                zzc zzc = (zzc) obj;
                if (Arrays.equals(this.zzbuO, zzc.zzbuO) && zzss.zza(this.zzbuP, zzc.zzbuP) && this.zzbuQ == zzc.zzbuQ) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zzc.zzbuj);
                    }
                    if (zzc.zzbuj == null || zzc.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = Arrays.hashCode(this.zzbuO);
            int zza = zzss.zza(this.zzbuP);
            return (((this.zzbuQ ? 1231 : 1237) + ((((((hashCode + 527) * 31) + hashCode2) * 31) + zza) * 31)) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzsn.zza(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                for (byte[] bArr : this.zzbuP) {
                    if (bArr != null) {
                        zzsn.zza(2, bArr);
                    }
                }
            }
            if (this.zzbuQ) {
                zzsn.zze(3, this.zzbuQ);
            }
            super.writeTo(zzsn);
        }

        public zzc zzJE() {
            this.zzbuO = zzsx.zzbuD;
            this.zzbuP = zzsx.zzbuC;
            this.zzbuQ = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzU */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.zzbuO = zzsm.readBytes();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzbuP == null ? 0 : this.zzbuP.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzbuP, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzsm.readBytes();
                            zzsm.zzIX();
                            length++;
                        }
                        bArr[length] = zzsm.readBytes();
                        this.zzbuP = bArr;
                        continue;
                    case 24:
                        this.zzbuQ = zzsm.zzJc();
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
            int zzz = super.zzz();
            if (!Arrays.equals(this.zzbuO, zzsx.zzbuD)) {
                zzz += zzsn.zzb(1, this.zzbuO);
            }
            if (this.zzbuP != null && this.zzbuP.length > 0) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i4 < this.zzbuP.length) {
                    byte[] bArr = this.zzbuP[i4];
                    if (bArr != null) {
                        i2++;
                        i = zzsn.zzG(bArr) + i3;
                    } else {
                        i = i3;
                    }
                    i4++;
                    i3 = i;
                }
                zzz = zzz + i3 + (i2 * 1);
            }
            return this.zzbuQ ? zzz + zzsn.zzf(3, this.zzbuQ) : zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public String tag;
        public long zzbuR;
        public long zzbuS;
        public long zzbuT;
        public int zzbuU;
        public boolean zzbuV;
        public zze[] zzbuW;
        public zzb zzbuX;
        public byte[] zzbuY;
        public byte[] zzbuZ;
        public byte[] zzbva;
        public zza zzbvb;
        public String zzbvc;
        public long zzbvd;
        public zzc zzbve;
        public byte[] zzbvf;
        public int zzbvg;
        public int[] zzbvh;
        public long zzbvi;
        public int zzob;

        public zzd() {
            zzJF();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (r7.tag == null) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
            if (r7.zzbuX == null) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0073, code lost:
            if (r7.zzbvb == null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
            if (r7.zzbvc == null) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008b, code lost:
            if (r7.zzbve == null) goto L_0x008d;
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
                boolean r2 = r7 instanceof com.google.android.gms.internal.zzsz.zzd
                if (r2 == 0) goto L_0x00c7
                com.google.android.gms.internal.zzsz$zzd r7 = (com.google.android.gms.internal.zzsz.zzd) r7
                long r2 = r6.zzbuR
                long r4 = r7.zzbuR
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00c7
                long r2 = r6.zzbuS
                long r4 = r7.zzbuS
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00c7
                long r2 = r6.zzbuT
                long r4 = r7.zzbuT
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00c7
                java.lang.String r2 = r6.tag
                if (r2 != 0) goto L_0x00ca
                java.lang.String r2 = r7.tag
                if (r2 != 0) goto L_0x00c7
            L_0x002b:
                int r2 = r6.zzbuU
                int r3 = r7.zzbuU
                if (r2 != r3) goto L_0x00c7
                int r2 = r6.zzob
                int r3 = r7.zzob
                if (r2 != r3) goto L_0x00c7
                boolean r2 = r6.zzbuV
                boolean r3 = r7.zzbuV
                if (r2 != r3) goto L_0x00c7
                com.google.android.gms.internal.zzsz$zze[] r2 = r6.zzbuW
                com.google.android.gms.internal.zzsz$zze[] r3 = r7.zzbuW
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00c7
                com.google.android.gms.internal.zzsz$zzb r2 = r6.zzbuX
                if (r2 != 0) goto L_0x00d7
                com.google.android.gms.internal.zzsz$zzb r2 = r7.zzbuX
                if (r2 != 0) goto L_0x00c7
            L_0x004f:
                byte[] r2 = r6.zzbuY
                byte[] r3 = r7.zzbuY
                boolean r2 = java.util.Arrays.equals(r2, r3)
                if (r2 == 0) goto L_0x00c7
                byte[] r2 = r6.zzbuZ
                byte[] r3 = r7.zzbuZ
                boolean r2 = java.util.Arrays.equals(r2, r3)
                if (r2 == 0) goto L_0x00c7
                byte[] r2 = r6.zzbva
                byte[] r3 = r7.zzbva
                boolean r2 = java.util.Arrays.equals(r2, r3)
                if (r2 == 0) goto L_0x00c7
                com.google.android.gms.internal.zzsz$zza r2 = r6.zzbvb
                if (r2 != 0) goto L_0x00e4
                com.google.android.gms.internal.zzsz$zza r2 = r7.zzbvb
                if (r2 != 0) goto L_0x00c7
            L_0x0075:
                java.lang.String r2 = r6.zzbvc
                if (r2 != 0) goto L_0x00f1
                java.lang.String r2 = r7.zzbvc
                if (r2 != 0) goto L_0x00c7
            L_0x007d:
                long r2 = r6.zzbvd
                long r4 = r7.zzbvd
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00c7
                com.google.android.gms.internal.zzsz$zzc r2 = r6.zzbve
                if (r2 != 0) goto L_0x00fe
                com.google.android.gms.internal.zzsz$zzc r2 = r7.zzbve
                if (r2 != 0) goto L_0x00c7
            L_0x008d:
                byte[] r2 = r6.zzbvf
                byte[] r3 = r7.zzbvf
                boolean r2 = java.util.Arrays.equals(r2, r3)
                if (r2 == 0) goto L_0x00c7
                int r2 = r6.zzbvg
                int r3 = r7.zzbvg
                if (r2 != r3) goto L_0x00c7
                int[] r2 = r6.zzbvh
                int[] r3 = r7.zzbvh
                boolean r2 = com.google.android.gms.internal.zzss.equals((int[]) r2, (int[]) r3)
                if (r2 == 0) goto L_0x00c7
                long r2 = r6.zzbvi
                long r4 = r7.zzbvi
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00c7
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                if (r2 == 0) goto L_0x00bb
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x010b
            L_0x00bb:
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x00c7:
                r0 = r1
                goto L_0x0004
            L_0x00ca:
                java.lang.String r2 = r6.tag
                java.lang.String r3 = r7.tag
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x002b
                r0 = r1
                goto L_0x0004
            L_0x00d7:
                com.google.android.gms.internal.zzsz$zzb r2 = r6.zzbuX
                com.google.android.gms.internal.zzsz$zzb r3 = r7.zzbuX
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x004f
                r0 = r1
                goto L_0x0004
            L_0x00e4:
                com.google.android.gms.internal.zzsz$zza r2 = r6.zzbvb
                com.google.android.gms.internal.zzsz$zza r3 = r7.zzbvb
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0075
                r0 = r1
                goto L_0x0004
            L_0x00f1:
                java.lang.String r2 = r6.zzbvc
                java.lang.String r3 = r7.zzbvc
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x007d
                r0 = r1
                goto L_0x0004
            L_0x00fe:
                com.google.android.gms.internal.zzsz$zzc r2 = r6.zzbve
                com.google.android.gms.internal.zzsz$zzc r3 = r7.zzbve
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x008d
                r0 = r1
                goto L_0x0004
            L_0x010b:
                com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zzd.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int i2 = (int) (this.zzbuR ^ (this.zzbuR >>> 32));
            int i3 = (int) (this.zzbuS ^ (this.zzbuS >>> 32));
            int i4 = (int) (this.zzbuT ^ (this.zzbuT >>> 32));
            int hashCode2 = this.tag == null ? 0 : this.tag.hashCode();
            int i5 = this.zzbuU;
            int i6 = this.zzob;
            int i7 = this.zzbuV ? 1231 : 1237;
            int hashCode3 = zzss.hashCode((Object[]) this.zzbuW);
            int hashCode4 = this.zzbuX == null ? 0 : this.zzbuX.hashCode();
            int hashCode5 = Arrays.hashCode(this.zzbuY);
            int hashCode6 = Arrays.hashCode(this.zzbuZ);
            int hashCode7 = Arrays.hashCode(this.zzbva);
            int hashCode8 = this.zzbvb == null ? 0 : this.zzbvb.hashCode();
            int hashCode9 = this.zzbvc == null ? 0 : this.zzbvc.hashCode();
            int i8 = (int) (this.zzbvd ^ (this.zzbvd >>> 32));
            int hashCode10 = this.zzbve == null ? 0 : this.zzbve.hashCode();
            int hashCode11 = Arrays.hashCode(this.zzbvf);
            int i9 = this.zzbvg;
            int hashCode12 = zzss.hashCode(this.zzbvh);
            int i10 = (int) (this.zzbvi ^ (this.zzbvi >>> 32));
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((((((((((((((((((((((((((((((((hashCode2 + ((((((((hashCode + 527) * 31) + i2) * 31) + i3) * 31) + i4) * 31)) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i8) * 31) + hashCode10) * 31) + hashCode11) * 31) + i9) * 31) + hashCode12) * 31) + i10) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbuR != 0) {
                zzsn.zzb(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                zzsn.zzn(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                for (zze zze : this.zzbuW) {
                    if (zze != null) {
                        zzsn.zza(3, (zzsu) zze);
                    }
                }
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzsn.zza(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                zzsn.zza(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzsn.zza(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                zzsn.zza(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                zzsn.zze(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                zzsn.zzA(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                zzsn.zzA(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzsn.zza(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                zzsn.zzn(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                zzsn.zzc(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                zzsn.zza(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                zzsn.zzb(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzsn.zza(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                zzsn.zzA(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                for (int zzA : this.zzbvh) {
                    zzsn.zzA(20, zzA);
                }
            }
            if (this.zzbuT != 0) {
                zzsn.zzb(21, this.zzbuT);
            }
            if (this.zzbvi != 0) {
                zzsn.zzb(22, this.zzbvi);
            }
            super.writeTo(zzsn);
        }

        public zzd zzJF() {
            this.zzbuR = 0;
            this.zzbuS = 0;
            this.zzbuT = 0;
            this.tag = "";
            this.zzbuU = 0;
            this.zzob = 0;
            this.zzbuV = false;
            this.zzbuW = zze.zzJG();
            this.zzbuX = null;
            this.zzbuY = zzsx.zzbuD;
            this.zzbuZ = zzsx.zzbuD;
            this.zzbva = zzsx.zzbuD;
            this.zzbvb = null;
            this.zzbvc = "";
            this.zzbvd = 180000;
            this.zzbve = null;
            this.zzbvf = zzsx.zzbuD;
            this.zzbvg = 0;
            this.zzbvh = zzsx.zzbuw;
            this.zzbvi = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzV */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbuR = zzsm.zzJa();
                        continue;
                    case 18:
                        this.tag = zzsm.readString();
                        continue;
                    case 26:
                        int zzc = zzsx.zzc(zzsm, 26);
                        int length = this.zzbuW == null ? 0 : this.zzbuW.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuW, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzsm.zza(zzeArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzsm.zza(zzeArr[length]);
                        this.zzbuW = zzeArr;
                        continue;
                    case 50:
                        this.zzbuY = zzsm.readBytes();
                        continue;
                    case 58:
                        if (this.zzbvb == null) {
                            this.zzbvb = new zza();
                        }
                        zzsm.zza(this.zzbvb);
                        continue;
                    case 66:
                        this.zzbuZ = zzsm.readBytes();
                        continue;
                    case 74:
                        if (this.zzbuX == null) {
                            this.zzbuX = new zzb();
                        }
                        zzsm.zza(this.zzbuX);
                        continue;
                    case 80:
                        this.zzbuV = zzsm.zzJc();
                        continue;
                    case 88:
                        this.zzbuU = zzsm.zzJb();
                        continue;
                    case 96:
                        this.zzob = zzsm.zzJb();
                        continue;
                    case 106:
                        this.zzbva = zzsm.readBytes();
                        continue;
                    case 114:
                        this.zzbvc = zzsm.readString();
                        continue;
                    case 120:
                        this.zzbvd = zzsm.zzJe();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        if (this.zzbve == null) {
                            this.zzbve = new zzc();
                        }
                        zzsm.zza(this.zzbve);
                        continue;
                    case 136:
                        this.zzbuS = zzsm.zzJa();
                        continue;
                    case 146:
                        this.zzbvf = zzsm.readBytes();
                        continue;
                    case 152:
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbvg = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzsx.zzc(zzsm, 160);
                        int length2 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzsm.zzJb();
                            zzsm.zzIX();
                            length2++;
                        }
                        iArr[length2] = zzsm.zzJb();
                        this.zzbvh = iArr;
                        continue;
                    case 162:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length3 = this.zzbvh == null ? 0 : this.zzbvh.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbvh, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzsm.zzJb();
                            length3++;
                        }
                        this.zzbvh = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 168:
                        this.zzbuT = zzsm.zzJa();
                        continue;
                    case 176:
                        this.zzbvi = zzsm.zzJa();
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
            int zzz = super.zzz();
            if (this.zzbuR != 0) {
                zzz += zzsn.zzd(1, this.zzbuR);
            }
            if (!this.tag.equals("")) {
                zzz += zzsn.zzo(2, this.tag);
            }
            if (this.zzbuW != null && this.zzbuW.length > 0) {
                int i = zzz;
                for (zze zze : this.zzbuW) {
                    if (zze != null) {
                        i += zzsn.zzc(3, (zzsu) zze);
                    }
                }
                zzz = i;
            }
            if (!Arrays.equals(this.zzbuY, zzsx.zzbuD)) {
                zzz += zzsn.zzb(6, this.zzbuY);
            }
            if (this.zzbvb != null) {
                zzz += zzsn.zzc(7, (zzsu) this.zzbvb);
            }
            if (!Arrays.equals(this.zzbuZ, zzsx.zzbuD)) {
                zzz += zzsn.zzb(8, this.zzbuZ);
            }
            if (this.zzbuX != null) {
                zzz += zzsn.zzc(9, (zzsu) this.zzbuX);
            }
            if (this.zzbuV) {
                zzz += zzsn.zzf(10, this.zzbuV);
            }
            if (this.zzbuU != 0) {
                zzz += zzsn.zzC(11, this.zzbuU);
            }
            if (this.zzob != 0) {
                zzz += zzsn.zzC(12, this.zzob);
            }
            if (!Arrays.equals(this.zzbva, zzsx.zzbuD)) {
                zzz += zzsn.zzb(13, this.zzbva);
            }
            if (!this.zzbvc.equals("")) {
                zzz += zzsn.zzo(14, this.zzbvc);
            }
            if (this.zzbvd != 180000) {
                zzz += zzsn.zze(15, this.zzbvd);
            }
            if (this.zzbve != null) {
                zzz += zzsn.zzc(16, (zzsu) this.zzbve);
            }
            if (this.zzbuS != 0) {
                zzz += zzsn.zzd(17, this.zzbuS);
            }
            if (!Arrays.equals(this.zzbvf, zzsx.zzbuD)) {
                zzz += zzsn.zzb(18, this.zzbvf);
            }
            if (this.zzbvg != 0) {
                zzz += zzsn.zzC(19, this.zzbvg);
            }
            if (this.zzbvh != null && this.zzbvh.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < this.zzbvh.length) {
                    i3++;
                    i2 = zzsn.zzmx(this.zzbvh[i3]) + i2;
                }
                zzz = zzz + i2 + (this.zzbvh.length * 2);
            }
            if (this.zzbuT != 0) {
                zzz += zzsn.zzd(21, this.zzbuT);
            }
            return this.zzbvi != 0 ? zzz + zzsn.zzd(22, this.zzbvi) : zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zzbvj;
        public String key;
        public String value;

        public zze() {
            zzJH();
        }

        public static zze[] zzJG() {
            if (zzbvj == null) {
                synchronized (zzss.zzbut) {
                    if (zzbvj == null) {
                        zzbvj = new zze[0];
                    }
                }
            }
            return zzbvj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r5.value == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
            if (r5.key == null) goto L_0x0013;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                if (r5 != r4) goto L_0x0005
            L_0x0004:
                return r0
            L_0x0005:
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzsz.zze
                if (r2 == 0) goto L_0x0033
                com.google.android.gms.internal.zzsz$zze r5 = (com.google.android.gms.internal.zzsz.zze) r5
                java.lang.String r2 = r4.key
                if (r2 != 0) goto L_0x0035
                java.lang.String r2 = r5.key
                if (r2 != 0) goto L_0x0033
            L_0x0013:
                java.lang.String r2 = r4.value
                if (r2 != 0) goto L_0x0041
                java.lang.String r2 = r5.value
                if (r2 != 0) goto L_0x0033
            L_0x001b:
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x0027
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x004d
            L_0x0027:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0033:
                r0 = r1
                goto L_0x0004
            L_0x0035:
                java.lang.String r2 = r4.key
                java.lang.String r3 = r5.key
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0013
                r0 = r1
                goto L_0x0004
            L_0x0041:
                java.lang.String r2 = r4.value
                java.lang.String r3 = r5.value
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x001b
                r0 = r1
                goto L_0x0004
            L_0x004d:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zze.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.key == null ? 0 : this.key.hashCode();
            int hashCode3 = this.value == null ? 0 : this.value.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.key.equals("")) {
                zzsn.zzn(1, this.key);
            }
            if (!this.value.equals("")) {
                zzsn.zzn(2, this.value);
            }
            super.writeTo(zzsn);
        }

        public zze zzJH() {
            this.key = "";
            this.value = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzW */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsm.readString();
                        continue;
                    case 18:
                        this.value = zzsm.readString();
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
            int zzz = super.zzz();
            if (!this.key.equals("")) {
                zzz += zzsn.zzo(1, this.key);
            }
            return !this.value.equals("") ? zzz + zzsn.zzo(2, this.value) : zzz;
        }
    }
}
