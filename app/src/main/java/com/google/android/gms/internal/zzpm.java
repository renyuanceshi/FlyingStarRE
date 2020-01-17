package com.google.android.gms.internal;

import java.io.IOException;

public interface zzpm {

    public static final class zza extends zzso<zza> {
        public C0133zza[] zzaMo;

        /* renamed from: com.google.android.gms.internal.zzpm$zza$zza  reason: collision with other inner class name */
        public static final class C0133zza extends zzso<C0133zza> {
            private static volatile C0133zza[] zzaMp;
            public int viewId;
            public String zzaMq;
            public String zzaMr;

            public C0133zza() {
                zzyr();
            }

            public static C0133zza[] zzyq() {
                if (zzaMp == null) {
                    synchronized (zzss.zzbut) {
                        if (zzaMp == null) {
                            zzaMp = new C0133zza[0];
                        }
                    }
                }
                return zzaMp;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
                if (r5.zzaMr == null) goto L_0x001b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
                if (r5.zzaMq == null) goto L_0x0013;
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
                    boolean r2 = r5 instanceof com.google.android.gms.internal.zzpm.zza.C0133zza
                    if (r2 == 0) goto L_0x0039
                    com.google.android.gms.internal.zzpm$zza$zza r5 = (com.google.android.gms.internal.zzpm.zza.C0133zza) r5
                    java.lang.String r2 = r4.zzaMq
                    if (r2 != 0) goto L_0x003b
                    java.lang.String r2 = r5.zzaMq
                    if (r2 != 0) goto L_0x0039
                L_0x0013:
                    java.lang.String r2 = r4.zzaMr
                    if (r2 != 0) goto L_0x0047
                    java.lang.String r2 = r5.zzaMr
                    if (r2 != 0) goto L_0x0039
                L_0x001b:
                    int r2 = r4.viewId
                    int r3 = r5.viewId
                    if (r2 != r3) goto L_0x0039
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
                    java.lang.String r2 = r4.zzaMq
                    java.lang.String r3 = r5.zzaMq
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x0013
                    r0 = r1
                    goto L_0x0004
                L_0x0047:
                    java.lang.String r2 = r4.zzaMr
                    java.lang.String r3 = r5.zzaMr
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L_0x001b
                    r0 = r1
                    goto L_0x0004
                L_0x0053:
                    com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                    com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                    boolean r0 = r0.equals(r1)
                    goto L_0x0004
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpm.zza.C0133zza.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                int i = 0;
                int hashCode = getClass().getName().hashCode();
                int hashCode2 = this.zzaMq == null ? 0 : this.zzaMq.hashCode();
                int hashCode3 = this.zzaMr == null ? 0 : this.zzaMr.hashCode();
                int i2 = this.viewId;
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    i = this.zzbuj.hashCode();
                }
                return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i2) * 31) + i;
            }

            public void writeTo(zzsn zzsn) throws IOException {
                if (!this.zzaMq.equals("")) {
                    zzsn.zzn(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    zzsn.zzn(2, this.zzaMr);
                }
                if (this.viewId != 0) {
                    zzsn.zzA(3, this.viewId);
                }
                super.writeTo(zzsn);
            }

            /* renamed from: zzp */
            public C0133zza mergeFrom(zzsm zzsm) throws IOException {
                while (true) {
                    int zzIX = zzsm.zzIX();
                    switch (zzIX) {
                        case 0:
                            break;
                        case 10:
                            this.zzaMq = zzsm.readString();
                            continue;
                        case 18:
                            this.zzaMr = zzsm.readString();
                            continue;
                        case 24:
                            this.viewId = zzsm.zzJb();
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

            public C0133zza zzyr() {
                this.zzaMq = "";
                this.zzaMr = "";
                this.viewId = 0;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            /* access modifiers changed from: protected */
            public int zzz() {
                int zzz = super.zzz();
                if (!this.zzaMq.equals("")) {
                    zzz += zzsn.zzo(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    zzz += zzsn.zzo(2, this.zzaMr);
                }
                return this.viewId != 0 ? zzz + zzsn.zzC(3, this.viewId) : zzz;
            }
        }

        public zza() {
            zzyp();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof zza) {
                zza zza = (zza) obj;
                if (zzss.equals((Object[]) this.zzaMo, (Object[]) zza.zzaMo)) {
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
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((hashCode + 527) * 31) + zzss.hashCode((Object[]) this.zzaMo)) * 31);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (C0133zza zza : this.zzaMo) {
                    if (zza != null) {
                        zzsn.zza(1, (zzsu) zza);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzo */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzaMo == null ? 0 : this.zzaMo.length;
                        C0133zza[] zzaArr = new C0133zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaMo, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C0133zza();
                            zzsm.zza(zzaArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzaArr[length] = new C0133zza();
                        zzsm.zza(zzaArr[length]);
                        this.zzaMo = zzaArr;
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

        public zza zzyp() {
            this.zzaMo = C0133zza.zzyq();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (C0133zza zza : this.zzaMo) {
                    if (zza != null) {
                        zzz += zzsn.zzc(1, (zzsu) zza);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzb extends zzso<zzb> {
        private static volatile zzb[] zzaMs;
        public String name;
        public zzd zzaMt;

        public zzb() {
            zzyt();
        }

        public static zzb[] zzys() {
            if (zzaMs == null) {
                synchronized (zzss.zzbut) {
                    if (zzaMs == null) {
                        zzaMs = new zzb[0];
                    }
                }
            }
            return zzaMs;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r5.zzaMt == null) goto L_0x001b;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzpm.zzb
                if (r2 == 0) goto L_0x0033
                com.google.android.gms.internal.zzpm$zzb r5 = (com.google.android.gms.internal.zzpm.zzb) r5
                java.lang.String r2 = r4.name
                if (r2 != 0) goto L_0x0035
                java.lang.String r2 = r5.name
                if (r2 != 0) goto L_0x0033
            L_0x0013:
                com.google.android.gms.internal.zzpm$zzd r2 = r4.zzaMt
                if (r2 != 0) goto L_0x0041
                com.google.android.gms.internal.zzpm$zzd r2 = r5.zzaMt
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
                com.google.android.gms.internal.zzpm$zzd r2 = r4.zzaMt
                com.google.android.gms.internal.zzpm$zzd r3 = r5.zzaMt
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpm.zzb.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.name == null ? 0 : this.name.hashCode();
            int hashCode3 = this.zzaMt == null ? 0 : this.zzaMt.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.name.equals("")) {
                zzsn.zzn(1, this.name);
            }
            if (this.zzaMt != null) {
                zzsn.zza(2, (zzsu) this.zzaMt);
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzq */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsm.readString();
                        continue;
                    case 18:
                        if (this.zzaMt == null) {
                            this.zzaMt = new zzd();
                        }
                        zzsm.zza(this.zzaMt);
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

        public zzb zzyt() {
            this.name = "";
            this.zzaMt = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.name.equals("")) {
                zzz += zzsn.zzo(1, this.name);
            }
            return this.zzaMt != null ? zzz + zzsn.zzc(2, (zzsu) this.zzaMt) : zzz;
        }
    }

    public static final class zzc extends zzso<zzc> {
        public String type;
        public zzb[] zzaMu;

        public zzc() {
            zzyu();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
            if (r5.type == null) goto L_0x0013;
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
                boolean r2 = r5 instanceof com.google.android.gms.internal.zzpm.zzc
                if (r2 == 0) goto L_0x0035
                com.google.android.gms.internal.zzpm$zzc r5 = (com.google.android.gms.internal.zzpm.zzc) r5
                java.lang.String r2 = r4.type
                if (r2 != 0) goto L_0x0037
                java.lang.String r2 = r5.type
                if (r2 != 0) goto L_0x0035
            L_0x0013:
                com.google.android.gms.internal.zzpm$zzb[] r2 = r4.zzaMu
                com.google.android.gms.internal.zzpm$zzb[] r3 = r5.zzaMu
                boolean r2 = com.google.android.gms.internal.zzss.equals((java.lang.Object[]) r2, (java.lang.Object[]) r3)
                if (r2 == 0) goto L_0x0035
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                if (r2 == 0) goto L_0x0029
                com.google.android.gms.internal.zzsq r2 = r4.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0043
            L_0x0029:
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r5.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0035:
                r0 = r1
                goto L_0x0004
            L_0x0037:
                java.lang.String r2 = r4.type
                java.lang.String r3 = r5.type
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0013
                r0 = r1
                goto L_0x0004
            L_0x0043:
                com.google.android.gms.internal.zzsq r0 = r4.zzbuj
                com.google.android.gms.internal.zzsq r1 = r5.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpm.zzc.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.type == null ? 0 : this.type.hashCode();
            int hashCode3 = zzss.hashCode((Object[]) this.zzaMu);
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.type.equals("")) {
                zzsn.zzn(1, this.type);
            }
            if (this.zzaMu != null && this.zzaMu.length > 0) {
                for (zzb zzb : this.zzaMu) {
                    if (zzb != null) {
                        zzsn.zza(2, (zzsu) zzb);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzr */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzsm.readString();
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzaMu == null ? 0 : this.zzaMu.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaMu, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzsm.zza(zzbArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzsm.zza(zzbArr[length]);
                        this.zzaMu = zzbArr;
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

        public zzc zzyu() {
            this.type = "";
            this.zzaMu = zzb.zzys();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (!this.type.equals("")) {
                zzz += zzsn.zzo(1, this.type);
            }
            if (this.zzaMu == null || this.zzaMu.length <= 0) {
                return zzz;
            }
            int i = zzz;
            for (zzb zzb : this.zzaMu) {
                if (zzb != null) {
                    i += zzsn.zzc(2, (zzsu) zzb);
                }
            }
            return i;
        }
    }

    public static final class zzd extends zzso<zzd> {
        public boolean zzaMv;
        public long zzaMw;
        public double zzaMx;
        public zzc zzaMy;
        public String zzamJ;

        public zzd() {
            zzyv();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
            if (r7.zzaMy == null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r7.zzamJ == null) goto L_0x0019;
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
                boolean r2 = r7 instanceof com.google.android.gms.internal.zzpm.zzd
                if (r2 == 0) goto L_0x0051
                com.google.android.gms.internal.zzpm$zzd r7 = (com.google.android.gms.internal.zzpm.zzd) r7
                boolean r2 = r6.zzaMv
                boolean r3 = r7.zzaMv
                if (r2 != r3) goto L_0x0051
                java.lang.String r2 = r6.zzamJ
                if (r2 != 0) goto L_0x0053
                java.lang.String r2 = r7.zzamJ
                if (r2 != 0) goto L_0x0051
            L_0x0019:
                long r2 = r6.zzaMw
                long r4 = r7.zzaMw
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0051
                double r2 = r6.zzaMx
                long r2 = java.lang.Double.doubleToLongBits(r2)
                double r4 = r7.zzaMx
                long r4 = java.lang.Double.doubleToLongBits(r4)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x0051
                com.google.android.gms.internal.zzpm$zzc r2 = r6.zzaMy
                if (r2 != 0) goto L_0x005f
                com.google.android.gms.internal.zzpm$zzc r2 = r7.zzaMy
                if (r2 != 0) goto L_0x0051
            L_0x0039:
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                if (r2 == 0) goto L_0x0045
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x006b
            L_0x0045:
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x0051:
                r0 = r1
                goto L_0x0004
            L_0x0053:
                java.lang.String r2 = r6.zzamJ
                java.lang.String r3 = r7.zzamJ
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0019
                r0 = r1
                goto L_0x0004
            L_0x005f:
                com.google.android.gms.internal.zzpm$zzc r2 = r6.zzaMy
                com.google.android.gms.internal.zzpm$zzc r3 = r7.zzaMy
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0039
                r0 = r1
                goto L_0x0004
            L_0x006b:
                com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpm.zzd.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int i2 = this.zzaMv ? 1231 : 1237;
            int hashCode2 = this.zzamJ == null ? 0 : this.zzamJ.hashCode();
            int i3 = (int) (this.zzaMw ^ (this.zzaMw >>> 32));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaMx);
            int i4 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
            int hashCode3 = this.zzaMy == null ? 0 : this.zzaMy.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((((((((i2 + ((hashCode + 527) * 31)) * 31) + hashCode2) * 31) + i3) * 31) + i4) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaMv) {
                zzsn.zze(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                zzsn.zzn(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                zzsn.zzb(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                zzsn.zza(4, this.zzaMx);
            }
            if (this.zzaMy != null) {
                zzsn.zza(5, (zzsu) this.zzaMy);
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzs */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaMv = zzsm.zzJc();
                        continue;
                    case 18:
                        this.zzamJ = zzsm.readString();
                        continue;
                    case 24:
                        this.zzaMw = zzsm.zzJa();
                        continue;
                    case 33:
                        this.zzaMx = zzsm.readDouble();
                        continue;
                    case 42:
                        if (this.zzaMy == null) {
                            this.zzaMy = new zzc();
                        }
                        zzsm.zza(this.zzaMy);
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

        public zzd zzyv() {
            this.zzaMv = false;
            this.zzamJ = "";
            this.zzaMw = 0;
            this.zzaMx = 0.0d;
            this.zzaMy = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzaMv) {
                zzz += zzsn.zzf(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                zzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                zzz += zzsn.zzd(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                zzz += zzsn.zzb(4, this.zzaMx);
            }
            return this.zzaMy != null ? zzz + zzsn.zzc(5, (zzsu) this.zzaMy) : zzz;
        }
    }
}
