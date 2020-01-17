package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzso<zza> {
        public int level;
        public int zziq;
        public int zzir;

        public zza() {
            zzB();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zza) {
                zza zza = (zza) obj;
                if (this.level == zza.level && this.zziq == zza.zziq && this.zzir == zza.zzir) {
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
            int i = this.level;
            int i2 = this.zziq;
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((hashCode + 527) * 31) + i) * 31) + i2) * 31) + this.zzir) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.level != 1) {
                zzsn.zzA(1, this.level);
            }
            if (this.zziq != 0) {
                zzsn.zzA(2, this.zziq);
            }
            if (this.zzir != 0) {
                zzsn.zzA(3, this.zzir);
            }
            super.writeTo(zzsn);
        }

        public zza zzB() {
            this.level = 1;
            this.zziq = 0;
            this.zzir = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zza */
        public zza mergeFrom(zzsm zzsm) throws IOException {
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
                                this.level = zzJb;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zziq = zzsm.zzJb();
                        continue;
                    case 24:
                        this.zzir = zzsm.zzJb();
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
            if (this.level != 1) {
                zzz += zzsn.zzC(1, this.level);
            }
            if (this.zziq != 0) {
                zzz += zzsn.zzC(2, this.zziq);
            }
            return this.zzir != 0 ? zzz + zzsn.zzC(3, this.zzir) : zzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzis;
        public int name;
        public int[] zzit;
        public int zziu;
        public boolean zziv;
        public boolean zziw;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzis == null) {
                synchronized (zzss.zzbut) {
                    if (zzis == null) {
                        zzis = new zzb[0];
                    }
                }
            }
            return zzis;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzb) {
                zzb zzb = (zzb) obj;
                if (zzss.equals(this.zzit, zzb.zzit) && this.zziu == zzb.zziu && this.name == zzb.name && this.zziv == zzb.zziv && this.zziw == zzb.zziw) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zzb.zzbuj);
                    }
                    if (zzb.zzbuj == null || zzb.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 1237;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode(this.zzit);
            int i2 = this.zziu;
            int i3 = this.name;
            int i4 = this.zziv ? 1231 : 1237;
            if (this.zziw) {
                i = 1231;
            }
            return ((((i4 + ((((((((hashCode + 527) * 31) + hashCode2) * 31) + i2) * 31) + i3) * 31)) * 31) + i) * 31) + ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode());
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zziw) {
                zzsn.zze(1, this.zziw);
            }
            zzsn.zzA(2, this.zziu);
            if (this.zzit != null && this.zzit.length > 0) {
                for (int zzA : this.zzit) {
                    zzsn.zzA(3, zzA);
                }
            }
            if (this.name != 0) {
                zzsn.zzA(4, this.name);
            }
            if (this.zziv) {
                zzsn.zze(6, this.zziv);
            }
            super.writeTo(zzsn);
        }

        public zzb zzD() {
            this.zzit = zzsx.zzbuw;
            this.zziu = 0;
            this.name = 0;
            this.zziv = false;
            this.zziw = false;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzb */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zziw = zzsm.zzJc();
                        continue;
                    case 16:
                        this.zziu = zzsm.zzJb();
                        continue;
                    case 24:
                        int zzc = zzsx.zzc(zzsm, 24);
                        int length = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzit, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsm.zzJb();
                            zzsm.zzIX();
                            length++;
                        }
                        iArr[length] = zzsm.zzJb();
                        this.zzit = iArr;
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
                        int length2 = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzit, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsm.zzJb();
                            length2++;
                        }
                        this.zzit = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 32:
                        this.name = zzsm.zzJb();
                        continue;
                    case 48:
                        this.zziv = zzsm.zzJc();
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
            int i2 = 0;
            int zzz = super.zzz();
            if (this.zziw) {
                zzz += zzsn.zzf(1, this.zziw);
            }
            int zzC = zzsn.zzC(2, this.zziu) + zzz;
            if (this.zzit == null || this.zzit.length <= 0) {
                i = zzC;
            } else {
                int i3 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= this.zzit.length) {
                        break;
                    }
                    i3 += zzsn.zzmx(this.zzit[i4]);
                    i2 = i4 + 1;
                }
                i = i3 + zzC + (this.zzit.length * 1);
            }
            if (this.name != 0) {
                i += zzsn.zzC(4, this.name);
            }
            return this.zziv ? i + zzsn.zzf(6, this.zziv) : i;
        }
    }

    public static final class zzc extends zzso<zzc> {
        private static volatile zzc[] zzix;
        public String key;
        public boolean zziA;
        public long zziB;
        public long zziy;
        public long zziz;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzix == null) {
                synchronized (zzss.zzbut) {
                    if (zzix == null) {
                        zzix = new zzc[0];
                    }
                }
            }
            return zzix;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
            if (r7.key == null) goto L_0x0013;
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
                boolean r2 = r7 instanceof com.google.android.gms.internal.zzaf.zzc
                if (r2 == 0) goto L_0x0049
                com.google.android.gms.internal.zzaf$zzc r7 = (com.google.android.gms.internal.zzaf.zzc) r7
                java.lang.String r2 = r6.key
                if (r2 != 0) goto L_0x004b
                java.lang.String r2 = r7.key
                if (r2 != 0) goto L_0x0049
            L_0x0013:
                long r2 = r6.zziy
                long r4 = r7.zziy
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0049
                long r2 = r6.zziz
                long r4 = r7.zziz
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0049
                boolean r2 = r6.zziA
                boolean r3 = r7.zziA
                if (r2 != r3) goto L_0x0049
                long r2 = r6.zziB
                long r4 = r7.zziB
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0049
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                if (r2 == 0) goto L_0x003d
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0057
            L_0x003d:
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0049:
                r0 = r1
                goto L_0x0004
            L_0x004b:
                java.lang.String r2 = r6.key
                java.lang.String r3 = r7.key
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0013
                r0 = r1
                goto L_0x0004
            L_0x0057:
                com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaf.zzc.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.key == null ? 0 : this.key.hashCode();
            int i2 = (int) (this.zziy ^ (this.zziy >>> 32));
            int i3 = (int) (this.zziz ^ (this.zziz >>> 32));
            int i4 = this.zziA ? 1231 : 1237;
            int i5 = (int) (this.zziB ^ (this.zziB >>> 32));
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.key.equals("")) {
                zzsn.zzn(1, this.key);
            }
            if (this.zziy != 0) {
                zzsn.zzb(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                zzsn.zzb(3, this.zziz);
            }
            if (this.zziA) {
                zzsn.zze(4, this.zziA);
            }
            if (this.zziB != 0) {
                zzsn.zzb(5, this.zziB);
            }
            super.writeTo(zzsn);
        }

        public zzc zzF() {
            this.key = "";
            this.zziy = 0;
            this.zziz = 2147483647L;
            this.zziA = false;
            this.zziB = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzc */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsm.readString();
                        continue;
                    case 16:
                        this.zziy = zzsm.zzJa();
                        continue;
                    case 24:
                        this.zziz = zzsm.zzJa();
                        continue;
                    case 32:
                        this.zziA = zzsm.zzJc();
                        continue;
                    case 40:
                        this.zziB = zzsm.zzJa();
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
            if (this.zziy != 0) {
                zzz += zzsn.zzd(2, this.zziy);
            }
            if (this.zziz != 2147483647L) {
                zzz += zzsn.zzd(3, this.zziz);
            }
            if (this.zziA) {
                zzz += zzsn.zzf(4, this.zziA);
            }
            return this.zziB != 0 ? zzz + zzsn.zzd(5, this.zziB) : zzz;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public zzag.zza[] zziC;
        public zzag.zza[] zziD;
        public zzc[] zziE;

        public zzd() {
            zzG();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzd) {
                zzd zzd = (zzd) obj;
                if (zzss.equals((Object[]) this.zziC, (Object[]) zzd.zziC) && zzss.equals((Object[]) this.zziD, (Object[]) zzd.zziD) && zzss.equals((Object[]) this.zziE, (Object[]) zzd.zziE)) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zzd.zzbuj);
                    }
                    if (zzd.zzbuj == null || zzd.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode((Object[]) this.zziC);
            int hashCode3 = zzss.hashCode((Object[]) this.zziD);
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + zzss.hashCode((Object[]) this.zziE)) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zziC != null && this.zziC.length > 0) {
                for (zzag.zza zza : this.zziC) {
                    if (zza != null) {
                        zzsn.zza(1, (zzsu) zza);
                    }
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (zzag.zza zza2 : this.zziD) {
                    if (zza2 != null) {
                        zzsn.zza(2, (zzsu) zza2);
                    }
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (zzc zzc : this.zziE) {
                    if (zzc != null) {
                        zzsn.zza(3, (zzsu) zzc);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zzd zzG() {
            this.zziC = zzag.zza.zzQ();
            this.zziD = zzag.zza.zzQ();
            this.zziE = zzc.zzE();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzd */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zziC == null ? 0 : this.zziC.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziC, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zzag.zza();
                            zzsm.zza(zzaArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzaArr[length] = new zzag.zza();
                        zzsm.zza(zzaArr[length]);
                        this.zziC = zzaArr;
                        continue;
                    case 18:
                        int zzc2 = zzsx.zzc(zzsm, 18);
                        int length2 = this.zziD == null ? 0 : this.zziD.length;
                        zzag.zza[] zzaArr2 = new zzag.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziD, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zzag.zza();
                            zzsm.zza(zzaArr2[length2]);
                            zzsm.zzIX();
                            length2++;
                        }
                        zzaArr2[length2] = new zzag.zza();
                        zzsm.zza(zzaArr2[length2]);
                        this.zziD = zzaArr2;
                        continue;
                    case 26:
                        int zzc3 = zzsx.zzc(zzsm, 26);
                        int length3 = this.zziE == null ? 0 : this.zziE.length;
                        zzc[] zzcArr = new zzc[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziE, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzsm.zza(zzcArr[length3]);
                            zzsm.zzIX();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzsm.zza(zzcArr[length3]);
                        this.zziE = zzcArr;
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
            if (this.zziC != null && this.zziC.length > 0) {
                for (zzag.zza zza : this.zziC) {
                    if (zza != null) {
                        zzz += zzsn.zzc(1, (zzsu) zza);
                    }
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (zzag.zza zza2 : this.zziD) {
                    if (zza2 != null) {
                        zzz += zzsn.zzc(2, (zzsu) zza2);
                    }
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (zzc zzc : this.zziE) {
                    if (zzc != null) {
                        zzz += zzsn.zzc(3, (zzsu) zzc);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zze extends zzso<zze> {
        private static volatile zze[] zziF;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zziF == null) {
                synchronized (zzss.zzbut) {
                    if (zziF == null) {
                        zziF = new zze[0];
                    }
                }
            }
            return zziF;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zze) {
                zze zze = (zze) obj;
                if (this.key == zze.key && this.value == zze.value) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zze.zzbuj);
                    }
                    if (zze.zzbuj == null || zze.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int i = this.key;
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((hashCode + 527) * 31) + i) * 31) + this.value) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn.zzA(1, this.key);
            zzsn.zzA(2, this.value);
            super.writeTo(zzsn);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zze */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzsm.zzJb();
                        continue;
                    case 16:
                        this.value = zzsm.zzJb();
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
            return super.zzz() + zzsn.zzC(1, this.key) + zzsn.zzC(2, this.value);
        }
    }

    public static final class zzf extends zzso<zzf> {
        public String version;
        public String[] zziG;
        public String[] zziH;
        public zzag.zza[] zziI;
        public zze[] zziJ;
        public zzb[] zziK;
        public zzb[] zziL;
        public zzb[] zziM;
        public zzg[] zziN;
        public String zziO;
        public String zziP;
        public String zziQ;
        public zza zziR;
        public float zziS;
        public boolean zziT;
        public String[] zziU;
        public int zziV;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzst {
            return (zzf) zzsu.mergeFrom(new zzf(), bArr);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
            if (r5.zziO == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
            if (r5.zziP == null) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
            if (r5.zziQ == null) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
            if (r5.version == null) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0081, code lost:
            if (r5.zziR == null) goto L_0x0083;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzaf.zzf
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zzf r5 = (com.google.android.gms.internal.zzaf.zzf) r5
                java.lang.String[] r2 = r4.zziG
                java.lang.String[] r3 = r5.zziG
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                java.lang.String[] r2 = r4.zziH
                java.lang.String[] r3 = r5.zziH
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzag$zza[] r2 = r4.zziI
                com.google.android.gms.internal.zzag$zza[] r3 = r5.zziI
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zze[] r2 = r4.zziJ
                com.google.android.gms.internal.zzaf$zze[] r3 = r5.zziJ
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zzb[] r2 = r4.zziK
                com.google.android.gms.internal.zzaf$zzb[] r3 = r5.zziK
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zzb[] r2 = r4.zziL
                com.google.android.gms.internal.zzaf$zzb[] r3 = r5.zziL
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zzb[] r2 = r4.zziM
                com.google.android.gms.internal.zzaf$zzb[] r3 = r5.zziM
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                com.google.android.gms.internal.zzaf$zzg[] r2 = r4.zziN
                com.google.android.gms.internal.zzaf$zzg[] r3 = r5.zziN
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                java.lang.String r2 = r4.zziO
                if (r2 != 0) goto L_0x00c2
                java.lang.String r2 = r5.zziO
                if (r2 != 0) goto L_0x00bf
            L_0x0063:
                java.lang.String r2 = r4.zziP
                if (r2 != 0) goto L_0x00cf
                java.lang.String r2 = r5.zziP
                if (r2 != 0) goto L_0x00bf
            L_0x006b:
                java.lang.String r2 = r4.zziQ
                if (r2 != 0) goto L_0x00dc
                java.lang.String r2 = r5.zziQ
                if (r2 != 0) goto L_0x00bf
            L_0x0073:
                java.lang.String r2 = r4.version
                if (r2 != 0) goto L_0x00e9
                java.lang.String r2 = r5.version
                if (r2 != 0) goto L_0x00bf
            L_0x007b:
                com.google.android.gms.internal.zzaf$zza r2 = r4.zziR
                if (r2 != 0) goto L_0x00f6
                com.google.android.gms.internal.zzaf$zza r2 = r5.zziR
                if (r2 != 0) goto L_0x00bf
            L_0x0083:
                float r2 = r4.zziS
                int r2 = java.lang.Float.floatToIntBits(r2)
                float r3 = r5.zziS
                int r3 = java.lang.Float.floatToIntBits(r3)
                if (r2 != r3) goto L_0x00bf
                boolean r2 = r4.zziT
                boolean r3 = r5.zziT
                if (r2 != r3) goto L_0x00bf
                java.lang.String[] r2 = r4.zziU
                java.lang.String[] r3 = r5.zziU
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x00bf
                int r2 = r4.zziV
                int r3 = r5.zziV
                if (r2 != r3) goto L_0x00bf
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x00b3
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0103
            L_0x00b3:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x00bf:
                r0 = r1
                goto L_0x0004
            L_0x00c2:
                java.lang.String r2 = r4.zziO
                java.lang.String r3 = r5.zziO
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0063
                r0 = r1
                goto L_0x0004
            L_0x00cf:
                java.lang.String r2 = r4.zziP
                java.lang.String r3 = r5.zziP
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x006b
                r0 = r1
                goto L_0x0004
            L_0x00dc:
                java.lang.String r2 = r4.zziQ
                java.lang.String r3 = r5.zziQ
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0073
                r0 = r1
                goto L_0x0004
            L_0x00e9:
                java.lang.String r2 = r4.version
                java.lang.String r3 = r5.version
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x007b
                r0 = r1
                goto L_0x0004
            L_0x00f6:
                com.google.android.gms.internal.zzaf$zza r2 = r4.zziR
                com.google.android.gms.internal.zzaf$zza r3 = r5.zziR
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0083
                r0 = r1
                goto L_0x0004
            L_0x0103:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaf.zzf.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode((Object[]) this.zziG);
            int hashCode3 = zzss.hashCode((Object[]) this.zziH);
            int hashCode4 = zzss.hashCode((Object[]) this.zziI);
            int hashCode5 = zzss.hashCode((Object[]) this.zziJ);
            int hashCode6 = zzss.hashCode((Object[]) this.zziK);
            int hashCode7 = zzss.hashCode((Object[]) this.zziL);
            int hashCode8 = zzss.hashCode((Object[]) this.zziM);
            int hashCode9 = zzss.hashCode((Object[]) this.zziN);
            int hashCode10 = this.zziO == null ? 0 : this.zziO.hashCode();
            int hashCode11 = this.zziP == null ? 0 : this.zziP.hashCode();
            int hashCode12 = this.zziQ == null ? 0 : this.zziQ.hashCode();
            int hashCode13 = this.version == null ? 0 : this.version.hashCode();
            int hashCode14 = this.zziR == null ? 0 : this.zziR.hashCode();
            int floatToIntBits = Float.floatToIntBits(this.zziS);
            int i2 = this.zziT ? 1231 : 1237;
            int hashCode15 = zzss.hashCode((Object[]) this.zziU);
            int i3 = this.zziV;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((((((((((((((((hashCode10 + ((((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31)) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + floatToIntBits) * 31) + i2) * 31) + hashCode15) * 31) + i3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zziH != null && this.zziH.length > 0) {
                for (String str : this.zziH) {
                    if (str != null) {
                        zzsn.zzn(1, str);
                    }
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (zzag.zza zza : this.zziI) {
                    if (zza != null) {
                        zzsn.zza(2, (zzsu) zza);
                    }
                }
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                for (zze zze : this.zziJ) {
                    if (zze != null) {
                        zzsn.zza(3, (zzsu) zze);
                    }
                }
            }
            if (this.zziK != null && this.zziK.length > 0) {
                for (zzb zzb : this.zziK) {
                    if (zzb != null) {
                        zzsn.zza(4, (zzsu) zzb);
                    }
                }
            }
            if (this.zziL != null && this.zziL.length > 0) {
                for (zzb zzb2 : this.zziL) {
                    if (zzb2 != null) {
                        zzsn.zza(5, (zzsu) zzb2);
                    }
                }
            }
            if (this.zziM != null && this.zziM.length > 0) {
                for (zzb zzb3 : this.zziM) {
                    if (zzb3 != null) {
                        zzsn.zza(6, (zzsu) zzb3);
                    }
                }
            }
            if (this.zziN != null && this.zziN.length > 0) {
                for (zzg zzg : this.zziN) {
                    if (zzg != null) {
                        zzsn.zza(7, (zzsu) zzg);
                    }
                }
            }
            if (!this.zziO.equals("")) {
                zzsn.zzn(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                zzsn.zzn(10, this.zziP);
            }
            if (!this.zziQ.equals("0")) {
                zzsn.zzn(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                zzsn.zzn(13, this.version);
            }
            if (this.zziR != null) {
                zzsn.zza(14, (zzsu) this.zziR);
            }
            if (Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f)) {
                zzsn.zzb(15, this.zziS);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (String str2 : this.zziU) {
                    if (str2 != null) {
                        zzsn.zzn(16, str2);
                    }
                }
            }
            if (this.zziV != 0) {
                zzsn.zzA(17, this.zziV);
            }
            if (this.zziT) {
                zzsn.zze(18, this.zziT);
            }
            if (this.zziG != null && this.zziG.length > 0) {
                for (String str3 : this.zziG) {
                    if (str3 != null) {
                        zzsn.zzn(19, str3);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zzf zzJ() {
            this.zziG = zzsx.zzbuB;
            this.zziH = zzsx.zzbuB;
            this.zziI = zzag.zza.zzQ();
            this.zziJ = zze.zzH();
            this.zziK = zzb.zzC();
            this.zziL = zzb.zzC();
            this.zziM = zzb.zzC();
            this.zziN = zzg.zzK();
            this.zziO = "";
            this.zziP = "";
            this.zziQ = "0";
            this.version = "";
            this.zziR = null;
            this.zziS = 0.0f;
            this.zziT = false;
            this.zziU = zzsx.zzbuB;
            this.zziV = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzf */
        public zzf mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zziH == null ? 0 : this.zziH.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziH, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsm.readString();
                            zzsm.zzIX();
                            length++;
                        }
                        strArr[length] = zzsm.readString();
                        this.zziH = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzsx.zzc(zzsm, 18);
                        int length2 = this.zziI == null ? 0 : this.zziI.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziI, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zzag.zza();
                            zzsm.zza(zzaArr[length2]);
                            zzsm.zzIX();
                            length2++;
                        }
                        zzaArr[length2] = new zzag.zza();
                        zzsm.zza(zzaArr[length2]);
                        this.zziI = zzaArr;
                        continue;
                    case 26:
                        int zzc3 = zzsx.zzc(zzsm, 26);
                        int length3 = this.zziJ == null ? 0 : this.zziJ.length;
                        zze[] zzeArr = new zze[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziJ, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzsm.zza(zzeArr[length3]);
                            zzsm.zzIX();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzsm.zza(zzeArr[length3]);
                        this.zziJ = zzeArr;
                        continue;
                    case 34:
                        int zzc4 = zzsx.zzc(zzsm, 34);
                        int length4 = this.zziK == null ? 0 : this.zziK.length;
                        zzb[] zzbArr = new zzb[(zzc4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziK, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzsm.zza(zzbArr[length4]);
                            zzsm.zzIX();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzsm.zza(zzbArr[length4]);
                        this.zziK = zzbArr;
                        continue;
                    case 42:
                        int zzc5 = zzsx.zzc(zzsm, 42);
                        int length5 = this.zziL == null ? 0 : this.zziL.length;
                        zzb[] zzbArr2 = new zzb[(zzc5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziL, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzsm.zza(zzbArr2[length5]);
                            zzsm.zzIX();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzsm.zza(zzbArr2[length5]);
                        this.zziL = zzbArr2;
                        continue;
                    case 50:
                        int zzc6 = zzsx.zzc(zzsm, 50);
                        int length6 = this.zziM == null ? 0 : this.zziM.length;
                        zzb[] zzbArr3 = new zzb[(zzc6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziM, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzsm.zza(zzbArr3[length6]);
                            zzsm.zzIX();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzsm.zza(zzbArr3[length6]);
                        this.zziM = zzbArr3;
                        continue;
                    case 58:
                        int zzc7 = zzsx.zzc(zzsm, 58);
                        int length7 = this.zziN == null ? 0 : this.zziN.length;
                        zzg[] zzgArr = new zzg[(zzc7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziN, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzsm.zza(zzgArr[length7]);
                            zzsm.zzIX();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzsm.zza(zzgArr[length7]);
                        this.zziN = zzgArr;
                        continue;
                    case 74:
                        this.zziO = zzsm.readString();
                        continue;
                    case 82:
                        this.zziP = zzsm.readString();
                        continue;
                    case 98:
                        this.zziQ = zzsm.readString();
                        continue;
                    case 106:
                        this.version = zzsm.readString();
                        continue;
                    case 114:
                        if (this.zziR == null) {
                            this.zziR = new zza();
                        }
                        zzsm.zza(this.zziR);
                        continue;
                    case 125:
                        this.zziS = zzsm.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        int zzc8 = zzsx.zzc(zzsm, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zziU == null ? 0 : this.zziU.length;
                        String[] strArr2 = new String[(zzc8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zziU, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzsm.readString();
                            zzsm.zzIX();
                            length8++;
                        }
                        strArr2[length8] = zzsm.readString();
                        this.zziU = strArr2;
                        continue;
                    case 136:
                        this.zziV = zzsm.zzJb();
                        continue;
                    case 144:
                        this.zziT = zzsm.zzJc();
                        continue;
                    case 154:
                        int zzc9 = zzsx.zzc(zzsm, 154);
                        int length9 = this.zziG == null ? 0 : this.zziG.length;
                        String[] strArr3 = new String[(zzc9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zziG, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzsm.readString();
                            zzsm.zzIX();
                            length9++;
                        }
                        strArr3[length9] = zzsm.readString();
                        this.zziG = strArr3;
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
            int zzz = super.zzz();
            if (this.zziH == null || this.zziH.length <= 0) {
                i = zzz;
            } else {
                int i3 = 0;
                int i4 = 0;
                for (String str : this.zziH) {
                    if (str != null) {
                        i3++;
                        i4 += zzsn.zzgO(str);
                    }
                }
                i = (i3 * 1) + i4 + zzz;
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (zzag.zza zza : this.zziI) {
                    if (zza != null) {
                        i += zzsn.zzc(2, (zzsu) zza);
                    }
                }
            }
            if (this.zziJ != null && this.zziJ.length > 0) {
                int i5 = i;
                for (zze zze : this.zziJ) {
                    if (zze != null) {
                        i5 += zzsn.zzc(3, (zzsu) zze);
                    }
                }
                i = i5;
            }
            if (this.zziK != null && this.zziK.length > 0) {
                int i6 = i;
                for (zzb zzb : this.zziK) {
                    if (zzb != null) {
                        i6 += zzsn.zzc(4, (zzsu) zzb);
                    }
                }
                i = i6;
            }
            if (this.zziL != null && this.zziL.length > 0) {
                int i7 = i;
                for (zzb zzb2 : this.zziL) {
                    if (zzb2 != null) {
                        i7 += zzsn.zzc(5, (zzsu) zzb2);
                    }
                }
                i = i7;
            }
            if (this.zziM != null && this.zziM.length > 0) {
                int i8 = i;
                for (zzb zzb3 : this.zziM) {
                    if (zzb3 != null) {
                        i8 += zzsn.zzc(6, (zzsu) zzb3);
                    }
                }
                i = i8;
            }
            if (this.zziN != null && this.zziN.length > 0) {
                int i9 = i;
                for (zzg zzg : this.zziN) {
                    if (zzg != null) {
                        i9 += zzsn.zzc(7, (zzsu) zzg);
                    }
                }
                i = i9;
            }
            if (!this.zziO.equals("")) {
                i += zzsn.zzo(9, this.zziO);
            }
            if (!this.zziP.equals("")) {
                i += zzsn.zzo(10, this.zziP);
            }
            if (!this.zziQ.equals("0")) {
                i += zzsn.zzo(12, this.zziQ);
            }
            if (!this.version.equals("")) {
                i += zzsn.zzo(13, this.version);
            }
            if (this.zziR != null) {
                i += zzsn.zzc(14, (zzsu) this.zziR);
            }
            int zzc = Float.floatToIntBits(this.zziS) != Float.floatToIntBits(0.0f) ? i + zzsn.zzc(15, this.zziS) : i;
            if (this.zziU != null && this.zziU.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.zziU) {
                    if (str2 != null) {
                        i11++;
                        i10 += zzsn.zzgO(str2);
                    }
                }
                zzc = i10 + zzc + (i11 * 2);
            }
            if (this.zziV != 0) {
                zzc += zzsn.zzC(17, this.zziV);
            }
            if (this.zziT) {
                zzc += zzsn.zzf(18, this.zziT);
            }
            if (this.zziG == null || this.zziG.length <= 0) {
                return zzc;
            }
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i13 < this.zziG.length) {
                String str3 = this.zziG[i13];
                if (str3 != null) {
                    i14++;
                    i2 = zzsn.zzgO(str3) + i12;
                } else {
                    i2 = i12;
                }
                i13++;
                i12 = i2;
            }
            return i12 + zzc + (i14 * 2);
        }
    }

    public static final class zzg extends zzso<zzg> {
        private static volatile zzg[] zziW;
        public int[] zziX;
        public int[] zziY;
        public int[] zziZ;
        public int[] zzja;
        public int[] zzjb;
        public int[] zzjc;
        public int[] zzjd;
        public int[] zzje;
        public int[] zzjf;
        public int[] zzjg;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziW == null) {
                synchronized (zzss.zzbut) {
                    if (zziW == null) {
                        zziW = new zzg[0];
                    }
                }
            }
            return zziW;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzg) {
                zzg zzg = (zzg) obj;
                if (zzss.equals(this.zziX, zzg.zziX) && zzss.equals(this.zziY, zzg.zziY) && zzss.equals(this.zziZ, zzg.zziZ) && zzss.equals(this.zzja, zzg.zzja) && zzss.equals(this.zzjb, zzg.zzjb) && zzss.equals(this.zzjc, zzg.zzjc) && zzss.equals(this.zzjd, zzg.zzjd) && zzss.equals(this.zzje, zzg.zzje) && zzss.equals(this.zzjf, zzg.zzjf) && zzss.equals(this.zzjg, zzg.zzjg)) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zzg.zzbuj);
                    }
                    if (zzg.zzbuj == null || zzg.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode(this.zziX);
            int hashCode3 = zzss.hashCode(this.zziY);
            int hashCode4 = zzss.hashCode(this.zziZ);
            int hashCode5 = zzss.hashCode(this.zzja);
            int hashCode6 = zzss.hashCode(this.zzjb);
            int hashCode7 = zzss.hashCode(this.zzjc);
            int hashCode8 = zzss.hashCode(this.zzjd);
            int hashCode9 = zzss.hashCode(this.zzje);
            int hashCode10 = zzss.hashCode(this.zzjf);
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + zzss.hashCode(this.zzjg)) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zziX != null && this.zziX.length > 0) {
                for (int zzA : this.zziX) {
                    zzsn.zzA(1, zzA);
                }
            }
            if (this.zziY != null && this.zziY.length > 0) {
                for (int zzA2 : this.zziY) {
                    zzsn.zzA(2, zzA2);
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int zzA3 : this.zziZ) {
                    zzsn.zzA(3, zzA3);
                }
            }
            if (this.zzja != null && this.zzja.length > 0) {
                for (int zzA4 : this.zzja) {
                    zzsn.zzA(4, zzA4);
                }
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                for (int zzA5 : this.zzjb) {
                    zzsn.zzA(5, zzA5);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int zzA6 : this.zzjc) {
                    zzsn.zzA(6, zzA6);
                }
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                for (int zzA7 : this.zzjd) {
                    zzsn.zzA(7, zzA7);
                }
            }
            if (this.zzje != null && this.zzje.length > 0) {
                for (int zzA8 : this.zzje) {
                    zzsn.zzA(8, zzA8);
                }
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                for (int zzA9 : this.zzjf) {
                    zzsn.zzA(9, zzA9);
                }
            }
            if (this.zzjg != null && this.zzjg.length > 0) {
                for (int zzA10 : this.zzjg) {
                    zzsn.zzA(10, zzA10);
                }
            }
            super.writeTo(zzsn);
        }

        public zzg zzL() {
            this.zziX = zzsx.zzbuw;
            this.zziY = zzsx.zzbuw;
            this.zziZ = zzsx.zzbuw;
            this.zzja = zzsx.zzbuw;
            this.zzjb = zzsx.zzbuw;
            this.zzjc = zzsx.zzbuw;
            this.zzjd = zzsx.zzbuw;
            this.zzje = zzsx.zzbuw;
            this.zzjf = zzsx.zzbuw;
            this.zzjg = zzsx.zzbuw;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzg */
        public zzg mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzsx.zzc(zzsm, 8);
                        int length = this.zziX == null ? 0 : this.zziX.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziX, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsm.zzJb();
                            zzsm.zzIX();
                            length++;
                        }
                        iArr[length] = zzsm.zzJb();
                        this.zziX = iArr;
                        continue;
                    case 10:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length2 = this.zziX == null ? 0 : this.zziX.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziX, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsm.zzJb();
                            length2++;
                        }
                        this.zziX = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 16:
                        int zzc2 = zzsx.zzc(zzsm, 16);
                        int length3 = this.zziY == null ? 0 : this.zziY.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziY, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzsm.zzJb();
                            zzsm.zzIX();
                            length3++;
                        }
                        iArr3[length3] = zzsm.zzJb();
                        this.zziY = iArr3;
                        continue;
                    case 18:
                        int zzmq2 = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i2 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i2++;
                        }
                        zzsm.zzms(position2);
                        int length4 = this.zziY == null ? 0 : this.zziY.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziY, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzsm.zzJb();
                            length4++;
                        }
                        this.zziY = iArr4;
                        zzsm.zzmr(zzmq2);
                        continue;
                    case 24:
                        int zzc3 = zzsx.zzc(zzsm, 24);
                        int length5 = this.zziZ == null ? 0 : this.zziZ.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziZ, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzsm.zzJb();
                            zzsm.zzIX();
                            length5++;
                        }
                        iArr5[length5] = zzsm.zzJb();
                        this.zziZ = iArr5;
                        continue;
                    case 26:
                        int zzmq3 = zzsm.zzmq(zzsm.zzJf());
                        int position3 = zzsm.getPosition();
                        int i3 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i3++;
                        }
                        zzsm.zzms(position3);
                        int length6 = this.zziZ == null ? 0 : this.zziZ.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziZ, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzsm.zzJb();
                            length6++;
                        }
                        this.zziZ = iArr6;
                        zzsm.zzmr(zzmq3);
                        continue;
                    case 32:
                        int zzc4 = zzsx.zzc(zzsm, 32);
                        int length7 = this.zzja == null ? 0 : this.zzja.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzja, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzsm.zzJb();
                            zzsm.zzIX();
                            length7++;
                        }
                        iArr7[length7] = zzsm.zzJb();
                        this.zzja = iArr7;
                        continue;
                    case 34:
                        int zzmq4 = zzsm.zzmq(zzsm.zzJf());
                        int position4 = zzsm.getPosition();
                        int i4 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i4++;
                        }
                        zzsm.zzms(position4);
                        int length8 = this.zzja == null ? 0 : this.zzja.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzja, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzsm.zzJb();
                            length8++;
                        }
                        this.zzja = iArr8;
                        zzsm.zzmr(zzmq4);
                        continue;
                    case 40:
                        int zzc5 = zzsx.zzc(zzsm, 40);
                        int length9 = this.zzjb == null ? 0 : this.zzjb.length;
                        int[] iArr9 = new int[(zzc5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzjb, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzsm.zzJb();
                            zzsm.zzIX();
                            length9++;
                        }
                        iArr9[length9] = zzsm.zzJb();
                        this.zzjb = iArr9;
                        continue;
                    case 42:
                        int zzmq5 = zzsm.zzmq(zzsm.zzJf());
                        int position5 = zzsm.getPosition();
                        int i5 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i5++;
                        }
                        zzsm.zzms(position5);
                        int length10 = this.zzjb == null ? 0 : this.zzjb.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zzjb, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzsm.zzJb();
                            length10++;
                        }
                        this.zzjb = iArr10;
                        zzsm.zzmr(zzmq5);
                        continue;
                    case 48:
                        int zzc6 = zzsx.zzc(zzsm, 48);
                        int length11 = this.zzjc == null ? 0 : this.zzjc.length;
                        int[] iArr11 = new int[(zzc6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zzjc, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzsm.zzJb();
                            zzsm.zzIX();
                            length11++;
                        }
                        iArr11[length11] = zzsm.zzJb();
                        this.zzjc = iArr11;
                        continue;
                    case 50:
                        int zzmq6 = zzsm.zzmq(zzsm.zzJf());
                        int position6 = zzsm.getPosition();
                        int i6 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i6++;
                        }
                        zzsm.zzms(position6);
                        int length12 = this.zzjc == null ? 0 : this.zzjc.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zzjc, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzsm.zzJb();
                            length12++;
                        }
                        this.zzjc = iArr12;
                        zzsm.zzmr(zzmq6);
                        continue;
                    case 56:
                        int zzc7 = zzsx.zzc(zzsm, 56);
                        int length13 = this.zzjd == null ? 0 : this.zzjd.length;
                        int[] iArr13 = new int[(zzc7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzjd, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzsm.zzJb();
                            zzsm.zzIX();
                            length13++;
                        }
                        iArr13[length13] = zzsm.zzJb();
                        this.zzjd = iArr13;
                        continue;
                    case 58:
                        int zzmq7 = zzsm.zzmq(zzsm.zzJf());
                        int position7 = zzsm.getPosition();
                        int i7 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i7++;
                        }
                        zzsm.zzms(position7);
                        int length14 = this.zzjd == null ? 0 : this.zzjd.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzjd, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzsm.zzJb();
                            length14++;
                        }
                        this.zzjd = iArr14;
                        zzsm.zzmr(zzmq7);
                        continue;
                    case 64:
                        int zzc8 = zzsx.zzc(zzsm, 64);
                        int length15 = this.zzje == null ? 0 : this.zzje.length;
                        int[] iArr15 = new int[(zzc8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zzje, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzsm.zzJb();
                            zzsm.zzIX();
                            length15++;
                        }
                        iArr15[length15] = zzsm.zzJb();
                        this.zzje = iArr15;
                        continue;
                    case 66:
                        int zzmq8 = zzsm.zzmq(zzsm.zzJf());
                        int position8 = zzsm.getPosition();
                        int i8 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i8++;
                        }
                        zzsm.zzms(position8);
                        int length16 = this.zzje == null ? 0 : this.zzje.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zzje, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzsm.zzJb();
                            length16++;
                        }
                        this.zzje = iArr16;
                        zzsm.zzmr(zzmq8);
                        continue;
                    case 72:
                        int zzc9 = zzsx.zzc(zzsm, 72);
                        int length17 = this.zzjf == null ? 0 : this.zzjf.length;
                        int[] iArr17 = new int[(zzc9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zzjf, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzsm.zzJb();
                            zzsm.zzIX();
                            length17++;
                        }
                        iArr17[length17] = zzsm.zzJb();
                        this.zzjf = iArr17;
                        continue;
                    case 74:
                        int zzmq9 = zzsm.zzmq(zzsm.zzJf());
                        int position9 = zzsm.getPosition();
                        int i9 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i9++;
                        }
                        zzsm.zzms(position9);
                        int length18 = this.zzjf == null ? 0 : this.zzjf.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zzjf, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzsm.zzJb();
                            length18++;
                        }
                        this.zzjf = iArr18;
                        zzsm.zzmr(zzmq9);
                        continue;
                    case 80:
                        int zzc10 = zzsx.zzc(zzsm, 80);
                        int length19 = this.zzjg == null ? 0 : this.zzjg.length;
                        int[] iArr19 = new int[(zzc10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zzjg, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzsm.zzJb();
                            zzsm.zzIX();
                            length19++;
                        }
                        iArr19[length19] = zzsm.zzJb();
                        this.zzjg = iArr19;
                        continue;
                    case 82:
                        int zzmq10 = zzsm.zzmq(zzsm.zzJf());
                        int position10 = zzsm.getPosition();
                        int i10 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i10++;
                        }
                        zzsm.zzms(position10);
                        int length20 = this.zzjg == null ? 0 : this.zzjg.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zzjg, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzsm.zzJb();
                            length20++;
                        }
                        this.zzjg = iArr20;
                        zzsm.zzmr(zzmq10);
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
            if (this.zziX != null && this.zziX.length > 0) {
                int i2 = 0;
                for (int zzmx : this.zziX) {
                    i2 += zzsn.zzmx(zzmx);
                }
                zzz = i2 + zzz + (this.zziX.length * 1);
            }
            if (this.zziY == null || this.zziY.length <= 0) {
                i = zzz;
            } else {
                int i3 = 0;
                for (int zzmx2 : this.zziY) {
                    i3 += zzsn.zzmx(zzmx2);
                }
                i = i3 + zzz + (this.zziY.length * 1);
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                int i4 = 0;
                for (int zzmx3 : this.zziZ) {
                    i4 += zzsn.zzmx(zzmx3);
                }
                i = i + i4 + (this.zziZ.length * 1);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                int i5 = 0;
                for (int zzmx4 : this.zzja) {
                    i5 += zzsn.zzmx(zzmx4);
                }
                i = i + i5 + (this.zzja.length * 1);
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                int i6 = 0;
                for (int zzmx5 : this.zzjb) {
                    i6 += zzsn.zzmx(zzmx5);
                }
                i = i + i6 + (this.zzjb.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                int i7 = 0;
                for (int zzmx6 : this.zzjc) {
                    i7 += zzsn.zzmx(zzmx6);
                }
                i = i + i7 + (this.zzjc.length * 1);
            }
            if (this.zzjd != null && this.zzjd.length > 0) {
                int i8 = 0;
                for (int zzmx7 : this.zzjd) {
                    i8 += zzsn.zzmx(zzmx7);
                }
                i = i + i8 + (this.zzjd.length * 1);
            }
            if (this.zzje != null && this.zzje.length > 0) {
                int i9 = 0;
                for (int zzmx8 : this.zzje) {
                    i9 += zzsn.zzmx(zzmx8);
                }
                i = i + i9 + (this.zzje.length * 1);
            }
            if (this.zzjf != null && this.zzjf.length > 0) {
                int i10 = 0;
                for (int zzmx9 : this.zzjf) {
                    i10 += zzsn.zzmx(zzmx9);
                }
                i = i + i10 + (this.zzjf.length * 1);
            }
            if (this.zzjg == null || this.zzjg.length <= 0) {
                return i;
            }
            int i11 = 0;
            int i12 = 0;
            while (i12 < this.zzjg.length) {
                i12++;
                i11 = zzsn.zzmx(this.zzjg[i12]) + i11;
            }
            return i + i11 + (this.zzjg.length * 1);
        }
    }

    public static final class zzh extends zzso<zzh> {
        public static final zzsp<zzag.zza, zzh> zzjh = zzsp.zza(11, zzh.class, 810);
        private static final zzh[] zzji = new zzh[0];
        public int[] zzjj;
        public int[] zzjk;
        public int[] zzjl;
        public int zzjm;
        public int[] zzjn;
        public int zzjo;
        public int zzjp;

        public zzh() {
            zzM();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zzh) {
                zzh zzh = (zzh) obj;
                if (zzss.equals(this.zzjj, zzh.zzjj) && zzss.equals(this.zzjk, zzh.zzjk) && zzss.equals(this.zzjl, zzh.zzjl) && this.zzjm == zzh.zzjm && zzss.equals(this.zzjn, zzh.zzjn) && this.zzjo == zzh.zzjo && this.zzjp == zzh.zzjp) {
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        return this.zzbuj.equals(zzh.zzbuj);
                    }
                    if (zzh.zzbuj == null || zzh.zzbuj.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode(this.zzjj);
            int hashCode3 = zzss.hashCode(this.zzjk);
            int hashCode4 = zzss.hashCode(this.zzjl);
            int i = this.zzjm;
            int hashCode5 = zzss.hashCode(this.zzjn);
            int i2 = this.zzjo;
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + hashCode5) * 31) + i2) * 31) + this.zzjp) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzjj != null && this.zzjj.length > 0) {
                for (int zzA : this.zzjj) {
                    zzsn.zzA(1, zzA);
                }
            }
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (int zzA2 : this.zzjk) {
                    zzsn.zzA(2, zzA2);
                }
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                for (int zzA3 : this.zzjl) {
                    zzsn.zzA(3, zzA3);
                }
            }
            if (this.zzjm != 0) {
                zzsn.zzA(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                for (int zzA4 : this.zzjn) {
                    zzsn.zzA(5, zzA4);
                }
            }
            if (this.zzjo != 0) {
                zzsn.zzA(6, this.zzjo);
            }
            if (this.zzjp != 0) {
                zzsn.zzA(7, this.zzjp);
            }
            super.writeTo(zzsn);
        }

        public zzh zzM() {
            this.zzjj = zzsx.zzbuw;
            this.zzjk = zzsx.zzbuw;
            this.zzjl = zzsx.zzbuw;
            this.zzjm = 0;
            this.zzjn = zzsx.zzbuw;
            this.zzjo = 0;
            this.zzjp = 0;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzh */
        public zzh mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzsx.zzc(zzsm, 8);
                        int length = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjj, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzsm.zzJb();
                            zzsm.zzIX();
                            length++;
                        }
                        iArr[length] = zzsm.zzJb();
                        this.zzjj = iArr;
                        continue;
                    case 10:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length2 = this.zzjj == null ? 0 : this.zzjj.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzjj, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzsm.zzJb();
                            length2++;
                        }
                        this.zzjj = iArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 16:
                        int zzc2 = zzsx.zzc(zzsm, 16);
                        int length3 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr3 = new int[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzsm.zzJb();
                            zzsm.zzIX();
                            length3++;
                        }
                        iArr3[length3] = zzsm.zzJb();
                        this.zzjk = iArr3;
                        continue;
                    case 18:
                        int zzmq2 = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i2 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i2++;
                        }
                        zzsm.zzms(position2);
                        int length4 = this.zzjk == null ? 0 : this.zzjk.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzjk, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzsm.zzJb();
                            length4++;
                        }
                        this.zzjk = iArr4;
                        zzsm.zzmr(zzmq2);
                        continue;
                    case 24:
                        int zzc3 = zzsx.zzc(zzsm, 24);
                        int length5 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr5 = new int[(zzc3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzsm.zzJb();
                            zzsm.zzIX();
                            length5++;
                        }
                        iArr5[length5] = zzsm.zzJb();
                        this.zzjl = iArr5;
                        continue;
                    case 26:
                        int zzmq3 = zzsm.zzmq(zzsm.zzJf());
                        int position3 = zzsm.getPosition();
                        int i3 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i3++;
                        }
                        zzsm.zzms(position3);
                        int length6 = this.zzjl == null ? 0 : this.zzjl.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzjl, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzsm.zzJb();
                            length6++;
                        }
                        this.zzjl = iArr6;
                        zzsm.zzmr(zzmq3);
                        continue;
                    case 32:
                        this.zzjm = zzsm.zzJb();
                        continue;
                    case 40:
                        int zzc4 = zzsx.zzc(zzsm, 40);
                        int length7 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr7 = new int[(zzc4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzsm.zzJb();
                            zzsm.zzIX();
                            length7++;
                        }
                        iArr7[length7] = zzsm.zzJb();
                        this.zzjn = iArr7;
                        continue;
                    case 42:
                        int zzmq4 = zzsm.zzmq(zzsm.zzJf());
                        int position4 = zzsm.getPosition();
                        int i4 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzJb();
                            i4++;
                        }
                        zzsm.zzms(position4);
                        int length8 = this.zzjn == null ? 0 : this.zzjn.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzjn, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzsm.zzJb();
                            length8++;
                        }
                        this.zzjn = iArr8;
                        zzsm.zzmr(zzmq4);
                        continue;
                    case 48:
                        this.zzjo = zzsm.zzJb();
                        continue;
                    case 56:
                        this.zzjp = zzsm.zzJb();
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
            if (this.zzjj != null && this.zzjj.length > 0) {
                int i2 = 0;
                for (int zzmx : this.zzjj) {
                    i2 += zzsn.zzmx(zzmx);
                }
                zzz = i2 + zzz + (this.zzjj.length * 1);
            }
            if (this.zzjk == null || this.zzjk.length <= 0) {
                i = zzz;
            } else {
                int i3 = 0;
                for (int zzmx2 : this.zzjk) {
                    i3 += zzsn.zzmx(zzmx2);
                }
                i = i3 + zzz + (this.zzjk.length * 1);
            }
            if (this.zzjl != null && this.zzjl.length > 0) {
                int i4 = 0;
                for (int zzmx3 : this.zzjl) {
                    i4 += zzsn.zzmx(zzmx3);
                }
                i = i + i4 + (this.zzjl.length * 1);
            }
            if (this.zzjm != 0) {
                i += zzsn.zzC(4, this.zzjm);
            }
            if (this.zzjn != null && this.zzjn.length > 0) {
                int i5 = 0;
                int i6 = 0;
                while (i6 < this.zzjn.length) {
                    i6++;
                    i5 = zzsn.zzmx(this.zzjn[i6]) + i5;
                }
                i = i + i5 + (this.zzjn.length * 1);
            }
            if (this.zzjo != 0) {
                i += zzsn.zzC(6, this.zzjo);
            }
            return this.zzjp != 0 ? i + zzsn.zzC(7, this.zzjp) : i;
        }
    }

    public static final class zzi extends zzso<zzi> {
        private static volatile zzi[] zzjq;
        public String name;
        public zzag.zza zzjr;
        public zzd zzjs;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zzjq == null) {
                synchronized (zzss.zzbut) {
                    if (zzjq == null) {
                        zzjq = new zzi[0];
                    }
                }
            }
            return zzjq;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r5.zzjr == null) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
            if (r5.zzjs == null) goto L_0x0023;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzaf.zzi
                if (r2 == 0) goto L_0x003b
                com.google.android.gms.internal.zzaf$zzi r5 = (com.google.android.gms.internal.zzaf.zzi) r5
                java.lang.String r2 = r4.name
                if (r2 != 0) goto L_0x003d
                java.lang.String r2 = r5.name
                if (r2 != 0) goto L_0x003b
            L_0x0013:
                com.google.android.gms.internal.zzag$zza r2 = r4.zzjr
                if (r2 != 0) goto L_0x0049
                com.google.android.gms.internal.zzag$zza r2 = r5.zzjr
                if (r2 != 0) goto L_0x003b
            L_0x001b:
                com.google.android.gms.internal.zzaf$zzd r2 = r4.zzjs
                if (r2 != 0) goto L_0x0055
                com.google.android.gms.internal.zzaf$zzd r2 = r5.zzjs
                if (r2 != 0) goto L_0x003b
            L_0x0023:
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x002f
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0061
            L_0x002f:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x003b:
                r0 = r1
                goto L_0x0004
            L_0x003d:
                java.lang.String r2 = r4.name
                java.lang.String r3 = r5.name
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0013
                r0 = r1
                goto L_0x0004
            L_0x0049:
                com.google.android.gms.internal.zzag$zza r2 = r4.zzjr
                com.google.android.gms.internal.zzag$zza r3 = r5.zzjr
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x001b
                r0 = r1
                goto L_0x0004
            L_0x0055:
                com.google.android.gms.internal.zzaf$zzd r2 = r4.zzjs
                com.google.android.gms.internal.zzaf$zzd r3 = r5.zzjs
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0023
                r0 = r1
                goto L_0x0004
            L_0x0061:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaf.zzi.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.name == null ? 0 : this.name.hashCode();
            int hashCode3 = this.zzjr == null ? 0 : this.zzjr.hashCode();
            int hashCode4 = this.zzjs == null ? 0 : this.zzjs.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.name.equals("")) {
                zzsn.zzn(1, this.name);
            }
            if (this.zzjr != null) {
                zzsn.zza(2, (zzsu) this.zzjr);
            }
            if (this.zzjs != null) {
                zzsn.zza(3, (zzsu) this.zzjs);
            }
            super.writeTo(zzsn);
        }

        public zzi zzO() {
            this.name = "";
            this.zzjr = null;
            this.zzjs = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzi */
        public zzi mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsm.readString();
                        continue;
                    case 18:
                        if (this.zzjr == null) {
                            this.zzjr = new zzag.zza();
                        }
                        zzsm.zza(this.zzjr);
                        continue;
                    case 26:
                        if (this.zzjs == null) {
                            this.zzjs = new zzd();
                        }
                        zzsm.zza(this.zzjs);
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
            if (!this.name.equals("")) {
                zzz += zzsn.zzo(1, this.name);
            }
            if (this.zzjr != null) {
                zzz += zzsn.zzc(2, (zzsu) this.zzjr);
            }
            return this.zzjs != null ? zzz + zzsn.zzc(3, (zzsu) this.zzjs) : zzz;
        }
    }

    public static final class zzj extends zzso<zzj> {
        public zzi[] zzjt;
        public zzf zzju;
        public String zzjv;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzst {
            return (zzj) zzsu.mergeFrom(new zzj(), bArr);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
            if (r5.zzjv == null) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            if (r5.zzju == null) goto L_0x001d;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzaf.zzj
                if (r2 == 0) goto L_0x003d
                com.google.android.gms.internal.zzaf$zzj r5 = (com.google.android.gms.internal.zzaf.zzj) r5
                com.google.android.gms.internal.zzaf$zzi[] r2 = r4.zzjt
                com.google.android.gms.internal.zzaf$zzi[] r3 = r5.zzjt
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x003d
                com.google.android.gms.internal.zzaf$zzf r2 = r4.zzju
                if (r2 != 0) goto L_0x003f
                com.google.android.gms.internal.zzaf$zzf r2 = r5.zzju
                if (r2 != 0) goto L_0x003d
            L_0x001d:
                java.lang.String r2 = r4.zzjv
                if (r2 != 0) goto L_0x004b
                java.lang.String r2 = r5.zzjv
                if (r2 != 0) goto L_0x003d
            L_0x0025:
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x0031
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0057
            L_0x0031:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x003d:
                r0 = r1
                goto L_0x0004
            L_0x003f:
                com.google.android.gms.internal.zzaf$zzf r2 = r4.zzju
                com.google.android.gms.internal.zzaf$zzf r3 = r5.zzju
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x001d
                r0 = r1
                goto L_0x0004
            L_0x004b:
                java.lang.String r2 = r4.zzjv
                java.lang.String r3 = r5.zzjv
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0025
                r0 = r1
                goto L_0x0004
            L_0x0057:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaf.zzj.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode((Object[]) this.zzjt);
            int hashCode3 = this.zzju == null ? 0 : this.zzju.hashCode();
            int hashCode4 = this.zzjv == null ? 0 : this.zzjv.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode3 + ((((hashCode + 527) * 31) + hashCode2) * 31)) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (zzi zzi : this.zzjt) {
                    if (zzi != null) {
                        zzsn.zza(1, (zzsu) zzi);
                    }
                }
            }
            if (this.zzju != null) {
                zzsn.zza(2, (zzsu) this.zzju);
            }
            if (!this.zzjv.equals("")) {
                zzsn.zzn(3, this.zzjv);
            }
            super.writeTo(zzsn);
        }

        public zzj zzP() {
            this.zzjt = zzi.zzN();
            this.zzju = null;
            this.zzjv = "";
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzj */
        public zzj mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzjt == null ? 0 : this.zzjt.length;
                        zzi[] zziArr = new zzi[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzjt, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzsm.zza(zziArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzsm.zza(zziArr[length]);
                        this.zzjt = zziArr;
                        continue;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzf();
                        }
                        zzsm.zza(this.zzju);
                        continue;
                    case 26:
                        this.zzjv = zzsm.readString();
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
            if (this.zzjt != null && this.zzjt.length > 0) {
                for (zzi zzi : this.zzjt) {
                    if (zzi != null) {
                        zzz += zzsn.zzc(1, (zzsu) zzi);
                    }
                }
            }
            if (this.zzju != null) {
                zzz += zzsn.zzc(2, (zzsu) this.zzju);
            }
            return !this.zzjv.equals("") ? zzz + zzsn.zzo(3, this.zzjv) : zzz;
        }
    }
}
