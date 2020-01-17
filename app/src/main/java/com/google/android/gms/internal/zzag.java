package com.google.android.gms.internal;

import java.io.IOException;

public interface zzag {

    public static final class zza extends zzso<zza> {
        private static volatile zza[] zzjw;
        public int type;
        public zza[] zzjA;
        public String zzjB;
        public String zzjC;
        public long zzjD;
        public boolean zzjE;
        public zza[] zzjF;
        public int[] zzjG;
        public boolean zzjH;
        public String zzjx;
        public zza[] zzjy;
        public zza[] zzjz;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zzjw == null) {
                synchronized (zzss.zzbut) {
                    if (zzjw == null) {
                        zzjw = new zza[0];
                    }
                }
            }
            return zzjw;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            if (r7.zzjB == null) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r7.zzjC == null) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r7.zzjx == null) goto L_0x0019;
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
                boolean r2 = r7 instanceof com.google.android.gms.internal.zzag.zza
                if (r2 == 0) goto L_0x0087
                com.google.android.gms.internal.zzag$zza r7 = (com.google.android.gms.internal.zzag.zza) r7
                int r2 = r6.type
                int r3 = r7.type
                if (r2 != r3) goto L_0x0087
                java.lang.String r2 = r6.zzjx
                if (r2 != 0) goto L_0x008a
                java.lang.String r2 = r7.zzjx
                if (r2 != 0) goto L_0x0087
            L_0x0019:
                com.google.android.gms.internal.zzag$zza[] r2 = r6.zzjy
                com.google.android.gms.internal.zzag$zza[] r3 = r7.zzjy
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x0087
                com.google.android.gms.internal.zzag$zza[] r2 = r6.zzjz
                com.google.android.gms.internal.zzag$zza[] r3 = r7.zzjz
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x0087
                com.google.android.gms.internal.zzag$zza[] r2 = r6.zzjA
                com.google.android.gms.internal.zzag$zza[] r3 = r7.zzjA
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x0087
                java.lang.String r2 = r6.zzjB
                if (r2 != 0) goto L_0x0097
                java.lang.String r2 = r7.zzjB
                if (r2 != 0) goto L_0x0087
            L_0x003f:
                java.lang.String r2 = r6.zzjC
                if (r2 != 0) goto L_0x00a4
                java.lang.String r2 = r7.zzjC
                if (r2 != 0) goto L_0x0087
            L_0x0047:
                long r2 = r6.zzjD
                long r4 = r7.zzjD
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0087
                boolean r2 = r6.zzjE
                boolean r3 = r7.zzjE
                if (r2 != r3) goto L_0x0087
                com.google.android.gms.internal.zzag$zza[] r2 = r6.zzjF
                com.google.android.gms.internal.zzag$zza[] r3 = r7.zzjF
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x0087
                int[] r2 = r6.zzjG
                int[] r3 = r7.zzjG
                boolean r2 = com.google.android.gms.internal.zzss.equals((int[]) r2, (int[]) r3)
                if (r2 == 0) goto L_0x0087
                boolean r2 = r6.zzjH
                boolean r3 = r7.zzjH
                if (r2 != r3) goto L_0x0087
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                if (r2 == 0) goto L_0x007b
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x00b1
            L_0x007b:
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0087:
                r0 = r1
                goto L_0x0004
            L_0x008a:
                java.lang.String r2 = r6.zzjx
                java.lang.String r3 = r7.zzjx
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0019
                r0 = r1
                goto L_0x0004
            L_0x0097:
                java.lang.String r2 = r6.zzjB
                java.lang.String r3 = r7.zzjB
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x003f
                r0 = r1
                goto L_0x0004
            L_0x00a4:
                java.lang.String r2 = r6.zzjC
                java.lang.String r3 = r7.zzjC
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0047
                r0 = r1
                goto L_0x0004
            L_0x00b1:
                com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzag.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = getClass().getName().hashCode();
            int i3 = this.type;
            int hashCode2 = this.zzjx == null ? 0 : this.zzjx.hashCode();
            int hashCode3 = zzss.hashCode((Object[]) this.zzjy);
            int hashCode4 = zzss.hashCode((Object[]) this.zzjz);
            int hashCode5 = zzss.hashCode((Object[]) this.zzjA);
            int hashCode6 = this.zzjB == null ? 0 : this.zzjB.hashCode();
            int hashCode7 = this.zzjC == null ? 0 : this.zzjC.hashCode();
            int i4 = (int) (this.zzjD ^ (this.zzjD >>> 32));
            int i5 = this.zzjE ? 1231 : 1237;
            int hashCode8 = zzss.hashCode((Object[]) this.zzjF);
            int hashCode9 = zzss.hashCode(this.zzjG);
            if (!this.zzjH) {
                i = 1237;
            }
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i2 = this.zzbuj.hashCode();
            }
            return ((((((((((((((((((((((hashCode2 + ((((hashCode + 527) * 31) + i3) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i4) * 31) + i5) * 31) + hashCode8) * 31) + hashCode9) * 31) + i) * 31) + i2;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn.zzA(1, this.type);
            if (!this.zzjx.equals("")) {
                zzsn.zzn(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                for (zza zza : this.zzjy) {
                    if (zza != null) {
                        zzsn.zza(3, (zzsu) zza);
                    }
                }
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                for (zza zza2 : this.zzjz) {
                    if (zza2 != null) {
                        zzsn.zza(4, (zzsu) zza2);
                    }
                }
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                for (zza zza3 : this.zzjA) {
                    if (zza3 != null) {
                        zzsn.zza(5, (zzsu) zza3);
                    }
                }
            }
            if (!this.zzjB.equals("")) {
                zzsn.zzn(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                zzsn.zzn(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                zzsn.zzb(8, this.zzjD);
            }
            if (this.zzjH) {
                zzsn.zze(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                for (int zzA : this.zzjG) {
                    zzsn.zzA(10, zzA);
                }
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (zza zza4 : this.zzjF) {
                    if (zza4 != null) {
                        zzsn.zza(11, (zzsu) zza4);
                    }
                }
            }
            if (this.zzjE) {
                zzsn.zze(12, this.zzjE);
            }
            super.writeTo(zzsn);
        }

        public zza zzR() {
            this.type = 1;
            this.zzjx = "";
            this.zzjy = zzQ();
            this.zzjz = zzQ();
            this.zzjA = zzQ();
            this.zzjB = "";
            this.zzjC = "";
            this.zzjD = 0;
            this.zzjE = false;
            this.zzjF = zzQ();
            this.zzjG = zzsx.zzbuw;
            this.zzjH = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzk */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            int i;
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
                                this.type = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzjx = zzsm.readString();
                        continue;
                    case 26:
                        int zzc = zzsx.zzc(zzsm, 26);
                        int length = this.zzjy == null ? 0 : this.zzjy.length;
                        zza[] zzaArr = new zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjy, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzsm.zza(zzaArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzsm.zza(zzaArr[length]);
                        this.zzjy = zzaArr;
                        continue;
                    case 34:
                        int zzc2 = zzsx.zzc(zzsm, 34);
                        int length2 = this.zzjz == null ? 0 : this.zzjz.length;
                        zza[] zzaArr2 = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjz, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzsm.zza(zzaArr2[length2]);
                            zzsm.zzIX();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzsm.zza(zzaArr2[length2]);
                        this.zzjz = zzaArr2;
                        continue;
                    case 42:
                        int zzc3 = zzsx.zzc(zzsm, 42);
                        int length3 = this.zzjA == null ? 0 : this.zzjA.length;
                        zza[] zzaArr3 = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjA, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzsm.zza(zzaArr3[length3]);
                            zzsm.zzIX();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzsm.zza(zzaArr3[length3]);
                        this.zzjA = zzaArr3;
                        continue;
                    case 50:
                        this.zzjB = zzsm.readString();
                        continue;
                    case 58:
                        this.zzjC = zzsm.readString();
                        continue;
                    case 64:
                        this.zzjD = zzsm.zzJa();
                        continue;
                    case 72:
                        this.zzjH = zzsm.zzJc();
                        continue;
                    case 80:
                        int zzc4 = zzsx.zzc(zzsm, 80);
                        int[] iArr = new int[zzc4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzc4) {
                            if (i2 != 0) {
                                zzsm.zzIX();
                            }
                            int zzJb2 = zzsm.zzJb();
                            switch (zzJb2) {
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
                                    i = i3 + 1;
                                    iArr[i3] = zzJb2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzjG == null ? 0 : this.zzjG.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzjG, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzjG = iArr2;
                                break;
                            } else {
                                this.zzjG = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 82:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i4 = 0;
                        while (zzsm.zzJk() > 0) {
                            switch (zzsm.zzJb()) {
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
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzsm.zzms(position);
                            int length5 = this.zzjG == null ? 0 : this.zzjG.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzjG, 0, iArr3, 0, length5);
                            }
                            while (zzsm.zzJk() > 0) {
                                int zzJb3 = zzsm.zzJb();
                                switch (zzJb3) {
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
                                        iArr3[length5] = zzJb3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzjG = iArr3;
                        }
                        zzsm.zzmr(zzmq);
                        continue;
                    case 90:
                        int zzc5 = zzsx.zzc(zzsm, 90);
                        int length6 = this.zzjF == null ? 0 : this.zzjF.length;
                        zza[] zzaArr4 = new zza[(zzc5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjF, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzsm.zza(zzaArr4[length6]);
                            zzsm.zzIX();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzsm.zza(zzaArr4[length6]);
                        this.zzjF = zzaArr4;
                        continue;
                    case 96:
                        this.zzjE = zzsm.zzJc();
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
            if (!this.zzjx.equals("")) {
                zzz += zzsn.zzo(2, this.zzjx);
            }
            if (this.zzjy != null && this.zzjy.length > 0) {
                int i = zzz;
                for (zza zza : this.zzjy) {
                    if (zza != null) {
                        i += zzsn.zzc(3, (zzsu) zza);
                    }
                }
                zzz = i;
            }
            if (this.zzjz != null && this.zzjz.length > 0) {
                for (zza zza2 : this.zzjz) {
                    if (zza2 != null) {
                        zzz += zzsn.zzc(4, (zzsu) zza2);
                    }
                }
            }
            if (this.zzjA != null && this.zzjA.length > 0) {
                for (zza zza3 : this.zzjA) {
                    if (zza3 != null) {
                        zzz += zzsn.zzc(5, (zzsu) zza3);
                    }
                }
            }
            if (!this.zzjB.equals("")) {
                zzz += zzsn.zzo(6, this.zzjB);
            }
            if (!this.zzjC.equals("")) {
                zzz += zzsn.zzo(7, this.zzjC);
            }
            if (this.zzjD != 0) {
                zzz += zzsn.zzd(8, this.zzjD);
            }
            if (this.zzjH) {
                zzz += zzsn.zzf(9, this.zzjH);
            }
            if (this.zzjG != null && this.zzjG.length > 0) {
                int i2 = 0;
                for (int zzmx : this.zzjG) {
                    i2 += zzsn.zzmx(zzmx);
                }
                zzz = zzz + i2 + (this.zzjG.length * 1);
            }
            if (this.zzjF != null && this.zzjF.length > 0) {
                for (zza zza4 : this.zzjF) {
                    if (zza4 != null) {
                        zzz += zzsn.zzc(11, (zzsu) zza4);
                    }
                }
            }
            return this.zzjE ? zzz + zzsn.zzf(12, this.zzjE) : zzz;
        }
    }
}
