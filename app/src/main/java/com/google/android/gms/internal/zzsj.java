package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzsj extends zzso<zzsj> {
    public zza[] zzbtA;

    public static final class zza extends zzso<zza> {
        private static volatile zza[] zzbtB;
        public String name;
        public C0156zza zzbtC;

        /* renamed from: com.google.android.gms.internal.zzsj$zza$zza  reason: collision with other inner class name */
        public static final class C0156zza extends zzso<C0156zza> {
            private static volatile C0156zza[] zzbtD;
            public int type;
            public C0157zza zzbtE;

            /* renamed from: com.google.android.gms.internal.zzsj$zza$zza$zza  reason: collision with other inner class name */
            public static final class C0157zza extends zzso<C0157zza> {
                public byte[] zzbtF;
                public String zzbtG;
                public double zzbtH;
                public float zzbtI;
                public long zzbtJ;
                public int zzbtK;
                public int zzbtL;
                public boolean zzbtM;
                public zza[] zzbtN;
                public C0156zza[] zzbtO;
                public String[] zzbtP;
                public long[] zzbtQ;
                public float[] zzbtR;
                public long zzbtS;

                public C0157zza() {
                    zzIV();
                }

                /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
                    if (r7.zzbtG == null) goto L_0x001d;
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
                        boolean r2 = r7 instanceof com.google.android.gms.internal.zzsj.zza.C0156zza.C0157zza
                        if (r2 == 0) goto L_0x00a7
                        com.google.android.gms.internal.zzsj$zza$zza$zza r7 = (com.google.android.gms.internal.zzsj.zza.C0156zza.C0157zza) r7
                        byte[] r2 = r6.zzbtF
                        byte[] r3 = r7.zzbtF
                        boolean r2 = java.util.Arrays.equals(r2, r3)
                        if (r2 == 0) goto L_0x00a7
                        java.lang.String r2 = r6.zzbtG
                        if (r2 != 0) goto L_0x00aa
                        java.lang.String r2 = r7.zzbtG
                        if (r2 != 0) goto L_0x00a7
                    L_0x001d:
                        double r2 = r6.zzbtH
                        long r2 = java.lang.Double.doubleToLongBits(r2)
                        double r4 = r7.zzbtH
                        long r4 = java.lang.Double.doubleToLongBits(r4)
                        int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r2 != 0) goto L_0x00a7
                        float r2 = r6.zzbtI
                        int r2 = java.lang.Float.floatToIntBits(r2)
                        float r3 = r7.zzbtI
                        int r3 = java.lang.Float.floatToIntBits(r3)
                        if (r2 != r3) goto L_0x00a7
                        long r2 = r6.zzbtJ
                        long r4 = r7.zzbtJ
                        int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r2 != 0) goto L_0x00a7
                        int r2 = r6.zzbtK
                        int r3 = r7.zzbtK
                        if (r2 != r3) goto L_0x00a7
                        int r2 = r6.zzbtL
                        int r3 = r7.zzbtL
                        if (r2 != r3) goto L_0x00a7
                        boolean r2 = r6.zzbtM
                        boolean r3 = r7.zzbtM
                        if (r2 != r3) goto L_0x00a7
                        com.google.android.gms.internal.zzsj$zza[] r2 = r6.zzbtN
                        com.google.android.gms.internal.zzsj$zza[] r3 = r7.zzbtN
                        boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                        if (r2 == 0) goto L_0x00a7
                        com.google.android.gms.internal.zzsj$zza$zza[] r2 = r6.zzbtO
                        com.google.android.gms.internal.zzsj$zza$zza[] r3 = r7.zzbtO
                        boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                        if (r2 == 0) goto L_0x00a7
                        java.lang.String[] r2 = r6.zzbtP
                        java.lang.String[] r3 = r7.zzbtP
                        boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                        if (r2 == 0) goto L_0x00a7
                        long[] r2 = r6.zzbtQ
                        long[] r3 = r7.zzbtQ
                        boolean r2 = com.google.android.gms.internal.zzss.equals((long[]) r2, (long[]) r3)
                        if (r2 == 0) goto L_0x00a7
                        float[] r2 = r6.zzbtR
                        float[] r3 = r7.zzbtR
                        boolean r2 = com.google.android.gms.internal.zzss.equals((float[]) r2, (float[]) r3)
                        if (r2 == 0) goto L_0x00a7
                        long r2 = r6.zzbtS
                        long r4 = r7.zzbtS
                        int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r2 != 0) goto L_0x00a7
                        com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                        if (r2 == 0) goto L_0x009b
                        com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                        boolean r2 = r2.isEmpty()
                        if (r2 == 0) goto L_0x00b7
                    L_0x009b:
                        com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                        if (r2 == 0) goto L_0x0004
                        com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                        boolean r2 = r2.isEmpty()
                        if (r2 != 0) goto L_0x0004
                    L_0x00a7:
                        r0 = r1
                        goto L_0x0004
                    L_0x00aa:
                        java.lang.String r2 = r6.zzbtG
                        java.lang.String r3 = r7.zzbtG
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L_0x001d
                        r0 = r1
                        goto L_0x0004
                    L_0x00b7:
                        com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                        com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                        boolean r0 = r0.equals(r1)
                        goto L_0x0004
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsj.zza.C0156zza.C0157zza.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int i = 0;
                    int hashCode = getClass().getName().hashCode();
                    int hashCode2 = Arrays.hashCode(this.zzbtF);
                    int hashCode3 = this.zzbtG == null ? 0 : this.zzbtG.hashCode();
                    long doubleToLongBits = Double.doubleToLongBits(this.zzbtH);
                    int i2 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                    int floatToIntBits = Float.floatToIntBits(this.zzbtI);
                    int i3 = (int) (this.zzbtJ ^ (this.zzbtJ >>> 32));
                    int i4 = this.zzbtK;
                    int i5 = this.zzbtL;
                    int i6 = this.zzbtM ? 1231 : 1237;
                    int hashCode4 = zzss.hashCode((Object[]) this.zzbtN);
                    int hashCode5 = zzss.hashCode((Object[]) this.zzbtO);
                    int hashCode6 = zzss.hashCode((Object[]) this.zzbtP);
                    int hashCode7 = zzss.hashCode(this.zzbtQ);
                    int hashCode8 = zzss.hashCode(this.zzbtR);
                    int i7 = (int) (this.zzbtS ^ (this.zzbtS >>> 32));
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        i = this.zzbuj.hashCode();
                    }
                    return ((((((((((((((((((((((((((hashCode3 + ((((hashCode + 527) * 31) + hashCode2) * 31)) * 31) + i2) * 31) + floatToIntBits) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i7) * 31) + i;
                }

                public void writeTo(zzsn zzsn) throws IOException {
                    if (!Arrays.equals(this.zzbtF, zzsx.zzbuD)) {
                        zzsn.zza(1, this.zzbtF);
                    }
                    if (!this.zzbtG.equals("")) {
                        zzsn.zzn(2, this.zzbtG);
                    }
                    if (Double.doubleToLongBits(this.zzbtH) != Double.doubleToLongBits(0.0d)) {
                        zzsn.zza(3, this.zzbtH);
                    }
                    if (Float.floatToIntBits(this.zzbtI) != Float.floatToIntBits(0.0f)) {
                        zzsn.zzb(4, this.zzbtI);
                    }
                    if (this.zzbtJ != 0) {
                        zzsn.zzb(5, this.zzbtJ);
                    }
                    if (this.zzbtK != 0) {
                        zzsn.zzA(6, this.zzbtK);
                    }
                    if (this.zzbtL != 0) {
                        zzsn.zzB(7, this.zzbtL);
                    }
                    if (this.zzbtM) {
                        zzsn.zze(8, this.zzbtM);
                    }
                    if (this.zzbtN != null && this.zzbtN.length > 0) {
                        for (zza zza : this.zzbtN) {
                            if (zza != null) {
                                zzsn.zza(9, (zzsu) zza);
                            }
                        }
                    }
                    if (this.zzbtO != null && this.zzbtO.length > 0) {
                        for (C0156zza zza2 : this.zzbtO) {
                            if (zza2 != null) {
                                zzsn.zza(10, (zzsu) zza2);
                            }
                        }
                    }
                    if (this.zzbtP != null && this.zzbtP.length > 0) {
                        for (String str : this.zzbtP) {
                            if (str != null) {
                                zzsn.zzn(11, str);
                            }
                        }
                    }
                    if (this.zzbtQ != null && this.zzbtQ.length > 0) {
                        for (long zzb : this.zzbtQ) {
                            zzsn.zzb(12, zzb);
                        }
                    }
                    if (this.zzbtS != 0) {
                        zzsn.zzb(13, this.zzbtS);
                    }
                    if (this.zzbtR != null && this.zzbtR.length > 0) {
                        for (float zzb2 : this.zzbtR) {
                            zzsn.zzb(14, zzb2);
                        }
                    }
                    super.writeTo(zzsn);
                }

                public C0157zza zzIV() {
                    this.zzbtF = zzsx.zzbuD;
                    this.zzbtG = "";
                    this.zzbtH = 0.0d;
                    this.zzbtI = 0.0f;
                    this.zzbtJ = 0;
                    this.zzbtK = 0;
                    this.zzbtL = 0;
                    this.zzbtM = false;
                    this.zzbtN = zza.zzIR();
                    this.zzbtO = C0156zza.zzIT();
                    this.zzbtP = zzsx.zzbuB;
                    this.zzbtQ = zzsx.zzbux;
                    this.zzbtR = zzsx.zzbuy;
                    this.zzbtS = 0;
                    this.zzbuj = null;
                    this.zzbuu = -1;
                    return this;
                }

                /* renamed from: zzN */
                public C0157zza mergeFrom(zzsm zzsm) throws IOException {
                    while (true) {
                        int zzIX = zzsm.zzIX();
                        switch (zzIX) {
                            case 0:
                                break;
                            case 10:
                                this.zzbtF = zzsm.readBytes();
                                continue;
                            case 18:
                                this.zzbtG = zzsm.readString();
                                continue;
                            case 25:
                                this.zzbtH = zzsm.readDouble();
                                continue;
                            case 37:
                                this.zzbtI = zzsm.readFloat();
                                continue;
                            case 40:
                                this.zzbtJ = zzsm.zzJa();
                                continue;
                            case 48:
                                this.zzbtK = zzsm.zzJb();
                                continue;
                            case 56:
                                this.zzbtL = zzsm.zzJd();
                                continue;
                            case 64:
                                this.zzbtM = zzsm.zzJc();
                                continue;
                            case 74:
                                int zzc = zzsx.zzc(zzsm, 74);
                                int length = this.zzbtN == null ? 0 : this.zzbtN.length;
                                zza[] zzaArr = new zza[(zzc + length)];
                                if (length != 0) {
                                    System.arraycopy(this.zzbtN, 0, zzaArr, 0, length);
                                }
                                while (length < zzaArr.length - 1) {
                                    zzaArr[length] = new zza();
                                    zzsm.zza(zzaArr[length]);
                                    zzsm.zzIX();
                                    length++;
                                }
                                zzaArr[length] = new zza();
                                zzsm.zza(zzaArr[length]);
                                this.zzbtN = zzaArr;
                                continue;
                            case 82:
                                int zzc2 = zzsx.zzc(zzsm, 82);
                                int length2 = this.zzbtO == null ? 0 : this.zzbtO.length;
                                C0156zza[] zzaArr2 = new C0156zza[(zzc2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzbtO, 0, zzaArr2, 0, length2);
                                }
                                while (length2 < zzaArr2.length - 1) {
                                    zzaArr2[length2] = new C0156zza();
                                    zzsm.zza(zzaArr2[length2]);
                                    zzsm.zzIX();
                                    length2++;
                                }
                                zzaArr2[length2] = new C0156zza();
                                zzsm.zza(zzaArr2[length2]);
                                this.zzbtO = zzaArr2;
                                continue;
                            case 90:
                                int zzc3 = zzsx.zzc(zzsm, 90);
                                int length3 = this.zzbtP == null ? 0 : this.zzbtP.length;
                                String[] strArr = new String[(zzc3 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzbtP, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = zzsm.readString();
                                    zzsm.zzIX();
                                    length3++;
                                }
                                strArr[length3] = zzsm.readString();
                                this.zzbtP = strArr;
                                continue;
                            case 96:
                                int zzc4 = zzsx.zzc(zzsm, 96);
                                int length4 = this.zzbtQ == null ? 0 : this.zzbtQ.length;
                                long[] jArr = new long[(zzc4 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzbtQ, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = zzsm.zzJa();
                                    zzsm.zzIX();
                                    length4++;
                                }
                                jArr[length4] = zzsm.zzJa();
                                this.zzbtQ = jArr;
                                continue;
                            case 98:
                                int zzmq = zzsm.zzmq(zzsm.zzJf());
                                int position = zzsm.getPosition();
                                int i = 0;
                                while (zzsm.zzJk() > 0) {
                                    zzsm.zzJa();
                                    i++;
                                }
                                zzsm.zzms(position);
                                int length5 = this.zzbtQ == null ? 0 : this.zzbtQ.length;
                                long[] jArr2 = new long[(i + length5)];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzbtQ, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = zzsm.zzJa();
                                    length5++;
                                }
                                this.zzbtQ = jArr2;
                                zzsm.zzmr(zzmq);
                                continue;
                            case 104:
                                this.zzbtS = zzsm.zzJa();
                                continue;
                            case 114:
                                int zzJf = zzsm.zzJf();
                                int zzmq2 = zzsm.zzmq(zzJf);
                                int i2 = zzJf / 4;
                                int length6 = this.zzbtR == null ? 0 : this.zzbtR.length;
                                float[] fArr = new float[(i2 + length6)];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzbtR, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = zzsm.readFloat();
                                    length6++;
                                }
                                this.zzbtR = fArr;
                                zzsm.zzmr(zzmq2);
                                continue;
                            case 117:
                                int zzc5 = zzsx.zzc(zzsm, 117);
                                int length7 = this.zzbtR == null ? 0 : this.zzbtR.length;
                                float[] fArr2 = new float[(zzc5 + length7)];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzbtR, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = zzsm.readFloat();
                                    zzsm.zzIX();
                                    length7++;
                                }
                                fArr2[length7] = zzsm.readFloat();
                                this.zzbtR = fArr2;
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
                    if (!Arrays.equals(this.zzbtF, zzsx.zzbuD)) {
                        zzz += zzsn.zzb(1, this.zzbtF);
                    }
                    if (!this.zzbtG.equals("")) {
                        zzz += zzsn.zzo(2, this.zzbtG);
                    }
                    if (Double.doubleToLongBits(this.zzbtH) != Double.doubleToLongBits(0.0d)) {
                        zzz += zzsn.zzb(3, this.zzbtH);
                    }
                    if (Float.floatToIntBits(this.zzbtI) != Float.floatToIntBits(0.0f)) {
                        zzz += zzsn.zzc(4, this.zzbtI);
                    }
                    if (this.zzbtJ != 0) {
                        zzz += zzsn.zzd(5, this.zzbtJ);
                    }
                    if (this.zzbtK != 0) {
                        zzz += zzsn.zzC(6, this.zzbtK);
                    }
                    if (this.zzbtL != 0) {
                        zzz += zzsn.zzD(7, this.zzbtL);
                    }
                    if (this.zzbtM) {
                        zzz += zzsn.zzf(8, this.zzbtM);
                    }
                    if (this.zzbtN != null && this.zzbtN.length > 0) {
                        int i = zzz;
                        for (zza zza : this.zzbtN) {
                            if (zza != null) {
                                i += zzsn.zzc(9, (zzsu) zza);
                            }
                        }
                        zzz = i;
                    }
                    if (this.zzbtO != null && this.zzbtO.length > 0) {
                        int i2 = zzz;
                        for (C0156zza zza2 : this.zzbtO) {
                            if (zza2 != null) {
                                i2 += zzsn.zzc(10, (zzsu) zza2);
                            }
                        }
                        zzz = i2;
                    }
                    if (this.zzbtP != null && this.zzbtP.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.zzbtP) {
                            if (str != null) {
                                i4++;
                                i3 += zzsn.zzgO(str);
                            }
                        }
                        zzz = zzz + i3 + (i4 * 1);
                    }
                    if (this.zzbtQ != null && this.zzbtQ.length > 0) {
                        int i5 = 0;
                        int i6 = 0;
                        while (i6 < this.zzbtQ.length) {
                            i6++;
                            i5 = zzsn.zzas(this.zzbtQ[i6]) + i5;
                        }
                        zzz = zzz + i5 + (this.zzbtQ.length * 1);
                    }
                    if (this.zzbtS != 0) {
                        zzz += zzsn.zzd(13, this.zzbtS);
                    }
                    return (this.zzbtR == null || this.zzbtR.length <= 0) ? zzz : zzz + (this.zzbtR.length * 4) + (this.zzbtR.length * 1);
                }
            }

            public C0156zza() {
                zzIU();
            }

            public static C0156zza[] zzIT() {
                if (zzbtD == null) {
                    synchronized (zzss.zzbut) {
                        if (zzbtD == null) {
                            zzbtD = new C0156zza[0];
                        }
                    }
                }
                return zzbtD;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
                if (r5.zzbtE == null) goto L_0x0019;
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
                    boolean r2 = r5 instanceof com.google.android.gms.internal.zzsj.zza.C0156zza
                    if (r2 == 0) goto L_0x0031
                    com.google.android.gms.internal.zzsj$zza$zza r5 = (com.google.android.gms.internal.zzsj.zza.C0156zza) r5
                    int r2 = r4.type
                    int r3 = r5.type
                    if (r2 != r3) goto L_0x0031
                    com.google.android.gms.internal.zzsj$zza$zza$zza r2 = r4.zzbtE
                    if (r2 != 0) goto L_0x0033
                    com.google.android.gms.internal.zzsj$zza$zza$zza r2 = r5.zzbtE
                    if (r2 != 0) goto L_0x0031
                L_0x0019:
                    com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                    if (r2 == 0) goto L_0x0025
                    com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                    boolean r2 = r2.isEmpty()
                    if (r2 == 0) goto L_0x003f
                L_0x0025:
                    com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                    if (r2 == 0) goto L_0x0004
                    com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                    boolean r2 = r2.isEmpty()
                    if (r2 != 0) goto L_0x0004
                L_0x0031:
                    r0 = r1
                    goto L_0x0004
                L_0x0033:
                    com.google.android.gms.internal.zzsj$zza$zza$zza r2 = r4.zzbtE
                    com.google.android.gms.internal.zzsj$zza$zza$zza r3 = r5.zzbtE
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x0019
                    r0 = r1
                    goto L_0x0004
                L_0x003f:
                    com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                    com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                    boolean r0 = r0.equals(r1)
                    goto L_0x0004
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsj.zza.C0156zza.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                int i = 0;
                int hashCode = getClass().getName().hashCode();
                int i2 = this.type;
                int hashCode2 = this.zzbtE == null ? 0 : this.zzbtE.hashCode();
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    i = this.zzbuj.hashCode();
                }
                return ((hashCode2 + ((((hashCode + 527) * 31) + i2) * 31)) * 31) + i;
            }

            public void writeTo(zzsn zzsn) throws IOException {
                zzsn.zzA(1, this.type);
                if (this.zzbtE != null) {
                    zzsn.zza(2, (zzsu) this.zzbtE);
                }
                super.writeTo(zzsn);
            }

            public C0156zza zzIU() {
                this.type = 1;
                this.zzbtE = null;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            /* renamed from: zzM */
            public C0156zza mergeFrom(zzsm zzsm) throws IOException {
                while (true) {
                    int zzIX = zzsm.zzIX();
                    switch (zzIX) {
                        case 0:
                            break;
                        case 8:
                            int zzJb = zzsm.zzJb();
                            switch (zzJb) {
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
                                    this.type = zzJb;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.zzbtE == null) {
                                this.zzbtE = new C0157zza();
                            }
                            zzsm.zza(this.zzbtE);
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
                int zzz = super.zzz() + zzsn.zzC(1, this.type);
                return this.zzbtE != null ? zzz + zzsn.zzc(2, (zzsu) this.zzbtE) : zzz;
            }
        }

        public zza() {
            zzIS();
        }

        public static zza[] zzIR() {
            if (zzbtB == null) {
                synchronized (zzss.zzbut) {
                    if (zzbtB == null) {
                        zzbtB = new zza[0];
                    }
                }
            }
            return zzbtB;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r5.zzbtC == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
            if (r5.name == null) goto L_0x0013;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzsj.zza
                if (r2 == 0) goto L_0x0033
                com.google.android.gms.internal.zzsj$zza r5 = (com.google.android.gms.internal.zzsj.zza) r5
                java.lang.String r2 = r4.name
                if (r2 != 0) goto L_0x0035
                java.lang.String r2 = r5.name
                if (r2 != 0) goto L_0x0033
            L_0x0013:
                com.google.android.gms.internal.zzsj$zza$zza r2 = r4.zzbtC
                if (r2 != 0) goto L_0x0041
                com.google.android.gms.internal.zzsj$zza$zza r2 = r5.zzbtC
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
                java.lang.String r2 = r4.name
                java.lang.String r3 = r5.name
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0013
                r0 = r1
                goto L_0x0004
            L_0x0041:
                com.google.android.gms.internal.zzsj$zza$zza r2 = r4.zzbtC
                com.google.android.gms.internal.zzsj$zza$zza r3 = r5.zzbtC
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsj.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.name == null ? 0 : this.name.hashCode();
            int hashCode3 = this.zzbtC == null ? 0 : this.zzbtC.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn.zzn(1, this.name);
            if (this.zzbtC != null) {
                zzsn.zza(2, (zzsu) this.zzbtC);
            }
            super.writeTo(zzsn);
        }

        public zza zzIS() {
            this.name = "";
            this.zzbtC = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzL */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsm.readString();
                        continue;
                    case 18:
                        if (this.zzbtC == null) {
                            this.zzbtC = new C0156zza();
                        }
                        zzsm.zza(this.zzbtC);
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
            int zzz = super.zzz() + zzsn.zzo(1, this.name);
            return this.zzbtC != null ? zzz + zzsn.zzc(2, (zzsu) this.zzbtC) : zzz;
        }
    }

    public zzsj() {
        zzIQ();
    }

    public static zzsj zzA(byte[] bArr) throws zzst {
        return (zzsj) zzsu.mergeFrom(new zzsj(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzsj) {
            zzsj zzsj = (zzsj) obj;
            if (zzss.equals((Object[]) this.zzbtA, (Object[]) zzsj.zzbtA)) {
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    return this.zzbuj.equals(zzsj.zzbuj);
                }
                if (zzsj.zzbuj == null || zzsj.zzbuj.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getClass().getName().hashCode();
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((hashCode + 527) * 31) + zzss.hashCode((Object[]) this.zzbtA)) * 31);
    }

    public void writeTo(zzsn zzsn) throws IOException {
        if (this.zzbtA != null && this.zzbtA.length > 0) {
            for (zza zza2 : this.zzbtA) {
                if (zza2 != null) {
                    zzsn.zza(1, (zzsu) zza2);
                }
            }
        }
        super.writeTo(zzsn);
    }

    public zzsj zzIQ() {
        this.zzbtA = zza.zzIR();
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    /* renamed from: zzK */
    public zzsj mergeFrom(zzsm zzsm) throws IOException {
        while (true) {
            int zzIX = zzsm.zzIX();
            switch (zzIX) {
                case 0:
                    break;
                case 10:
                    int zzc = zzsx.zzc(zzsm, 10);
                    int length = this.zzbtA == null ? 0 : this.zzbtA.length;
                    zza[] zzaArr = new zza[(zzc + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbtA, 0, zzaArr, 0, length);
                    }
                    while (length < zzaArr.length - 1) {
                        zzaArr[length] = new zza();
                        zzsm.zza(zzaArr[length]);
                        zzsm.zzIX();
                        length++;
                    }
                    zzaArr[length] = new zza();
                    zzsm.zza(zzaArr[length]);
                    this.zzbtA = zzaArr;
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
        if (this.zzbtA != null && this.zzbtA.length > 0) {
            for (zza zza2 : this.zzbtA) {
                if (zza2 != null) {
                    zzz += zzsn.zzc(1, (zzsu) zza2);
                }
            }
        }
        return zzz;
    }
}
