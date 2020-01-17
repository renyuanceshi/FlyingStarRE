package com.google.android.gms.internal;

import java.io.IOException;

public interface zzpz {

    public static final class zza extends zzsu {
        private static volatile zza[] zzaZq;
        public Integer zzaZr;
        public zze[] zzaZs;
        public zzb[] zzaZt;

        public zza() {
            zzDB();
        }

        public static zza[] zzDA() {
            if (zzaZq == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZq == null) {
                        zzaZq = new zza[0];
                    }
                }
            }
            return zzaZq;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza zza = (zza) obj;
                if (this.zzaZr == null) {
                    if (zza.zzaZr != null) {
                        return false;
                    }
                } else if (!this.zzaZr.equals(zza.zzaZr)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzaZs, (Object[]) zza.zzaZs) || !zzss.equals((Object[]) this.zzaZt, (Object[]) zza.zzaZt)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return (((((this.zzaZr == null ? 0 : this.zzaZr.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode((Object[]) this.zzaZs)) * 31) + zzss.hashCode((Object[]) this.zzaZt);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZr != null) {
                zzsn.zzA(1, this.zzaZr.intValue());
            }
            if (this.zzaZs != null && this.zzaZs.length > 0) {
                for (zze zze : this.zzaZs) {
                    if (zze != null) {
                        zzsn.zza(2, (zzsu) zze);
                    }
                }
            }
            if (this.zzaZt != null && this.zzaZt.length > 0) {
                for (zzb zzb : this.zzaZt) {
                    if (zzb != null) {
                        zzsn.zza(3, (zzsu) zzb);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zza zzDB() {
            this.zzaZr = null;
            this.zzaZs = zze.zzDH();
            this.zzaZt = zzb.zzDC();
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzt */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZr = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzaZs == null ? 0 : this.zzaZs.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaZs, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzsm.zza(zzeArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzsm.zza(zzeArr[length]);
                        this.zzaZs = zzeArr;
                        continue;
                    case 26:
                        int zzc2 = zzsx.zzc(zzsm, 26);
                        int length2 = this.zzaZt == null ? 0 : this.zzaZt.length;
                        zzb[] zzbArr = new zzb[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaZt, 0, zzbArr, 0, length2);
                        }
                        while (length2 < zzbArr.length - 1) {
                            zzbArr[length2] = new zzb();
                            zzsm.zza(zzbArr[length2]);
                            zzsm.zzIX();
                            length2++;
                        }
                        zzbArr[length2] = new zzb();
                        zzsm.zza(zzbArr[length2]);
                        this.zzaZt = zzbArr;
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZr != null) {
                zzz += zzsn.zzC(1, this.zzaZr.intValue());
            }
            if (this.zzaZs != null && this.zzaZs.length > 0) {
                int i = zzz;
                for (zze zze : this.zzaZs) {
                    if (zze != null) {
                        i += zzsn.zzc(2, (zzsu) zze);
                    }
                }
                zzz = i;
            }
            if (this.zzaZt != null && this.zzaZt.length > 0) {
                for (zzb zzb : this.zzaZt) {
                    if (zzb != null) {
                        zzz += zzsn.zzc(3, (zzsu) zzb);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzaZu;
        public Integer zzaZv;
        public String zzaZw;
        public zzc[] zzaZx;
        public Boolean zzaZy;
        public zzd zzaZz;

        public zzb() {
            zzDD();
        }

        public static zzb[] zzDC() {
            if (zzaZu == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZu == null) {
                        zzaZu = new zzb[0];
                    }
                }
            }
            return zzaZu;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                zzb zzb = (zzb) obj;
                if (this.zzaZv == null) {
                    if (zzb.zzaZv != null) {
                        return false;
                    }
                } else if (!this.zzaZv.equals(zzb.zzaZv)) {
                    return false;
                }
                if (this.zzaZw == null) {
                    if (zzb.zzaZw != null) {
                        return false;
                    }
                } else if (!this.zzaZw.equals(zzb.zzaZw)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzaZx, (Object[]) zzb.zzaZx)) {
                    return false;
                }
                if (this.zzaZy == null) {
                    if (zzb.zzaZy != null) {
                        return false;
                    }
                } else if (!this.zzaZy.equals(zzb.zzaZy)) {
                    return false;
                }
                if (this.zzaZz == null) {
                    if (zzb.zzaZz != null) {
                        return false;
                    }
                } else if (!this.zzaZz.equals(zzb.zzaZz)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzaZv == null ? 0 : this.zzaZv.hashCode();
            int hashCode3 = this.zzaZw == null ? 0 : this.zzaZw.hashCode();
            int hashCode4 = zzss.hashCode((Object[]) this.zzaZx);
            int hashCode5 = this.zzaZy == null ? 0 : this.zzaZy.hashCode();
            if (this.zzaZz != null) {
                i = this.zzaZz.hashCode();
            }
            return ((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZv != null) {
                zzsn.zzA(1, this.zzaZv.intValue());
            }
            if (this.zzaZw != null) {
                zzsn.zzn(2, this.zzaZw);
            }
            if (this.zzaZx != null && this.zzaZx.length > 0) {
                for (zzc zzc : this.zzaZx) {
                    if (zzc != null) {
                        zzsn.zza(3, (zzsu) zzc);
                    }
                }
            }
            if (this.zzaZy != null) {
                zzsn.zze(4, this.zzaZy.booleanValue());
            }
            if (this.zzaZz != null) {
                zzsn.zza(5, (zzsu) this.zzaZz);
            }
            super.writeTo(zzsn);
        }

        public zzb zzDD() {
            this.zzaZv = null;
            this.zzaZw = null;
            this.zzaZx = zzc.zzDE();
            this.zzaZy = null;
            this.zzaZz = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzu */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZv = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 18:
                        this.zzaZw = zzsm.readString();
                        continue;
                    case 26:
                        int zzc = zzsx.zzc(zzsm, 26);
                        int length = this.zzaZx == null ? 0 : this.zzaZx.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaZx, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzsm.zza(zzcArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzsm.zza(zzcArr[length]);
                        this.zzaZx = zzcArr;
                        continue;
                    case 32:
                        this.zzaZy = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 42:
                        if (this.zzaZz == null) {
                            this.zzaZz = new zzd();
                        }
                        zzsm.zza(this.zzaZz);
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZv != null) {
                zzz += zzsn.zzC(1, this.zzaZv.intValue());
            }
            if (this.zzaZw != null) {
                zzz += zzsn.zzo(2, this.zzaZw);
            }
            if (this.zzaZx != null && this.zzaZx.length > 0) {
                int i = zzz;
                for (zzc zzc : this.zzaZx) {
                    if (zzc != null) {
                        i += zzsn.zzc(3, (zzsu) zzc);
                    }
                }
                zzz = i;
            }
            if (this.zzaZy != null) {
                zzz += zzsn.zzf(4, this.zzaZy.booleanValue());
            }
            return this.zzaZz != null ? zzz + zzsn.zzc(5, (zzsu) this.zzaZz) : zzz;
        }
    }

    public static final class zzc extends zzsu {
        private static volatile zzc[] zzaZA;
        public zzf zzaZB;
        public zzd zzaZC;
        public Boolean zzaZD;
        public String zzaZE;

        public zzc() {
            zzDF();
        }

        public static zzc[] zzDE() {
            if (zzaZA == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZA == null) {
                        zzaZA = new zzc[0];
                    }
                }
            }
            return zzaZA;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzc)) {
                    return false;
                }
                zzc zzc = (zzc) obj;
                if (this.zzaZB == null) {
                    if (zzc.zzaZB != null) {
                        return false;
                    }
                } else if (!this.zzaZB.equals(zzc.zzaZB)) {
                    return false;
                }
                if (this.zzaZC == null) {
                    if (zzc.zzaZC != null) {
                        return false;
                    }
                } else if (!this.zzaZC.equals(zzc.zzaZC)) {
                    return false;
                }
                if (this.zzaZD == null) {
                    if (zzc.zzaZD != null) {
                        return false;
                    }
                } else if (!this.zzaZD.equals(zzc.zzaZD)) {
                    return false;
                }
                if (this.zzaZE == null) {
                    if (zzc.zzaZE != null) {
                        return false;
                    }
                } else if (!this.zzaZE.equals(zzc.zzaZE)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzaZB == null ? 0 : this.zzaZB.hashCode();
            int hashCode3 = this.zzaZC == null ? 0 : this.zzaZC.hashCode();
            int hashCode4 = this.zzaZD == null ? 0 : this.zzaZD.hashCode();
            if (this.zzaZE != null) {
                i = this.zzaZE.hashCode();
            }
            return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZB != null) {
                zzsn.zza(1, (zzsu) this.zzaZB);
            }
            if (this.zzaZC != null) {
                zzsn.zza(2, (zzsu) this.zzaZC);
            }
            if (this.zzaZD != null) {
                zzsn.zze(3, this.zzaZD.booleanValue());
            }
            if (this.zzaZE != null) {
                zzsn.zzn(4, this.zzaZE);
            }
            super.writeTo(zzsn);
        }

        public zzc zzDF() {
            this.zzaZB = null;
            this.zzaZC = null;
            this.zzaZD = null;
            this.zzaZE = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzv */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        if (this.zzaZB == null) {
                            this.zzaZB = new zzf();
                        }
                        zzsm.zza(this.zzaZB);
                        continue;
                    case 18:
                        if (this.zzaZC == null) {
                            this.zzaZC = new zzd();
                        }
                        zzsm.zza(this.zzaZC);
                        continue;
                    case 24:
                        this.zzaZD = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 34:
                        this.zzaZE = zzsm.readString();
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZB != null) {
                zzz += zzsn.zzc(1, (zzsu) this.zzaZB);
            }
            if (this.zzaZC != null) {
                zzz += zzsn.zzc(2, (zzsu) this.zzaZC);
            }
            if (this.zzaZD != null) {
                zzz += zzsn.zzf(3, this.zzaZD.booleanValue());
            }
            return this.zzaZE != null ? zzz + zzsn.zzo(4, this.zzaZE) : zzz;
        }
    }

    public static final class zzd extends zzsu {
        public Integer zzaZF;
        public Boolean zzaZG;
        public String zzaZH;
        public String zzaZI;
        public String zzaZJ;

        public zzd() {
            zzDG();
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzd)) {
                    return false;
                }
                zzd zzd = (zzd) obj;
                if (this.zzaZF == null) {
                    if (zzd.zzaZF != null) {
                        return false;
                    }
                } else if (!this.zzaZF.equals(zzd.zzaZF)) {
                    return false;
                }
                if (this.zzaZG == null) {
                    if (zzd.zzaZG != null) {
                        return false;
                    }
                } else if (!this.zzaZG.equals(zzd.zzaZG)) {
                    return false;
                }
                if (this.zzaZH == null) {
                    if (zzd.zzaZH != null) {
                        return false;
                    }
                } else if (!this.zzaZH.equals(zzd.zzaZH)) {
                    return false;
                }
                if (this.zzaZI == null) {
                    if (zzd.zzaZI != null) {
                        return false;
                    }
                } else if (!this.zzaZI.equals(zzd.zzaZI)) {
                    return false;
                }
                if (this.zzaZJ == null) {
                    if (zzd.zzaZJ != null) {
                        return false;
                    }
                } else if (!this.zzaZJ.equals(zzd.zzaZJ)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int intValue = this.zzaZF == null ? 0 : this.zzaZF.intValue();
            int hashCode2 = this.zzaZG == null ? 0 : this.zzaZG.hashCode();
            int hashCode3 = this.zzaZH == null ? 0 : this.zzaZH.hashCode();
            int hashCode4 = this.zzaZI == null ? 0 : this.zzaZI.hashCode();
            if (this.zzaZJ != null) {
                i = this.zzaZJ.hashCode();
            }
            return ((((((((intValue + ((hashCode + 527) * 31)) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZF != null) {
                zzsn.zzA(1, this.zzaZF.intValue());
            }
            if (this.zzaZG != null) {
                zzsn.zze(2, this.zzaZG.booleanValue());
            }
            if (this.zzaZH != null) {
                zzsn.zzn(3, this.zzaZH);
            }
            if (this.zzaZI != null) {
                zzsn.zzn(4, this.zzaZI);
            }
            if (this.zzaZJ != null) {
                zzsn.zzn(5, this.zzaZJ);
            }
            super.writeTo(zzsn);
        }

        public zzd zzDG() {
            this.zzaZF = null;
            this.zzaZG = null;
            this.zzaZH = null;
            this.zzaZI = null;
            this.zzaZJ = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzw */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
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
                                this.zzaZF = Integer.valueOf(zzJb);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzaZG = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 26:
                        this.zzaZH = zzsm.readString();
                        continue;
                    case 34:
                        this.zzaZI = zzsm.readString();
                        continue;
                    case 42:
                        this.zzaZJ = zzsm.readString();
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZF != null) {
                zzz += zzsn.zzC(1, this.zzaZF.intValue());
            }
            if (this.zzaZG != null) {
                zzz += zzsn.zzf(2, this.zzaZG.booleanValue());
            }
            if (this.zzaZH != null) {
                zzz += zzsn.zzo(3, this.zzaZH);
            }
            if (this.zzaZI != null) {
                zzz += zzsn.zzo(4, this.zzaZI);
            }
            return this.zzaZJ != null ? zzz + zzsn.zzo(5, this.zzaZJ) : zzz;
        }
    }

    public static final class zze extends zzsu {
        private static volatile zze[] zzaZK;
        public String zzaZL;
        public zzc zzaZM;
        public Integer zzaZv;

        public zze() {
            zzDI();
        }

        public static zze[] zzDH() {
            if (zzaZK == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZK == null) {
                        zzaZK = new zze[0];
                    }
                }
            }
            return zzaZK;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zze)) {
                    return false;
                }
                zze zze = (zze) obj;
                if (this.zzaZv == null) {
                    if (zze.zzaZv != null) {
                        return false;
                    }
                } else if (!this.zzaZv.equals(zze.zzaZv)) {
                    return false;
                }
                if (this.zzaZL == null) {
                    if (zze.zzaZL != null) {
                        return false;
                    }
                } else if (!this.zzaZL.equals(zze.zzaZL)) {
                    return false;
                }
                if (this.zzaZM == null) {
                    if (zze.zzaZM != null) {
                        return false;
                    }
                } else if (!this.zzaZM.equals(zze.zzaZM)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzaZv == null ? 0 : this.zzaZv.hashCode();
            int hashCode3 = this.zzaZL == null ? 0 : this.zzaZL.hashCode();
            if (this.zzaZM != null) {
                i = this.zzaZM.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZv != null) {
                zzsn.zzA(1, this.zzaZv.intValue());
            }
            if (this.zzaZL != null) {
                zzsn.zzn(2, this.zzaZL);
            }
            if (this.zzaZM != null) {
                zzsn.zza(3, (zzsu) this.zzaZM);
            }
            super.writeTo(zzsn);
        }

        public zze zzDI() {
            this.zzaZv = null;
            this.zzaZL = null;
            this.zzaZM = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzx */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZv = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 18:
                        this.zzaZL = zzsm.readString();
                        continue;
                    case 26:
                        if (this.zzaZM == null) {
                            this.zzaZM = new zzc();
                        }
                        zzsm.zza(this.zzaZM);
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZv != null) {
                zzz += zzsn.zzC(1, this.zzaZv.intValue());
            }
            if (this.zzaZL != null) {
                zzz += zzsn.zzo(2, this.zzaZL);
            }
            return this.zzaZM != null ? zzz + zzsn.zzc(3, (zzsu) this.zzaZM) : zzz;
        }
    }

    public static final class zzf extends zzsu {
        public Integer zzaZN;
        public String zzaZO;
        public Boolean zzaZP;
        public String[] zzaZQ;

        public zzf() {
            zzDJ();
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzf)) {
                    return false;
                }
                zzf zzf = (zzf) obj;
                if (this.zzaZN == null) {
                    if (zzf.zzaZN != null) {
                        return false;
                    }
                } else if (!this.zzaZN.equals(zzf.zzaZN)) {
                    return false;
                }
                if (this.zzaZO == null) {
                    if (zzf.zzaZO != null) {
                        return false;
                    }
                } else if (!this.zzaZO.equals(zzf.zzaZO)) {
                    return false;
                }
                if (this.zzaZP == null) {
                    if (zzf.zzaZP != null) {
                        return false;
                    }
                } else if (!this.zzaZP.equals(zzf.zzaZP)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzaZQ, (Object[]) zzf.zzaZQ)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int intValue = this.zzaZN == null ? 0 : this.zzaZN.intValue();
            int hashCode2 = this.zzaZO == null ? 0 : this.zzaZO.hashCode();
            if (this.zzaZP != null) {
                i = this.zzaZP.hashCode();
            }
            return ((((((intValue + ((hashCode + 527) * 31)) * 31) + hashCode2) * 31) + i) * 31) + zzss.hashCode((Object[]) this.zzaZQ);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZN != null) {
                zzsn.zzA(1, this.zzaZN.intValue());
            }
            if (this.zzaZO != null) {
                zzsn.zzn(2, this.zzaZO);
            }
            if (this.zzaZP != null) {
                zzsn.zze(3, this.zzaZP.booleanValue());
            }
            if (this.zzaZQ != null && this.zzaZQ.length > 0) {
                for (String str : this.zzaZQ) {
                    if (str != null) {
                        zzsn.zzn(4, str);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zzf zzDJ() {
            this.zzaZN = null;
            this.zzaZO = null;
            this.zzaZP = null;
            this.zzaZQ = zzsx.zzbuB;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzy */
        public zzf mergeFrom(zzsm zzsm) throws IOException {
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
                                this.zzaZN = Integer.valueOf(zzJb);
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzaZO = zzsm.readString();
                        continue;
                    case 24:
                        this.zzaZP = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 34:
                        int zzc = zzsx.zzc(zzsm, 34);
                        int length = this.zzaZQ == null ? 0 : this.zzaZQ.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaZQ, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsm.readString();
                            zzsm.zzIX();
                            length++;
                        }
                        strArr[length] = zzsm.readString();
                        this.zzaZQ = strArr;
                        continue;
                    default:
                        if (!zzsx.zzb(zzsm, zzIX)) {
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
            if (this.zzaZN != null) {
                zzz += zzsn.zzC(1, this.zzaZN.intValue());
            }
            if (this.zzaZO != null) {
                zzz += zzsn.zzo(2, this.zzaZO);
            }
            if (this.zzaZP != null) {
                zzz += zzsn.zzf(3, this.zzaZP.booleanValue());
            }
            if (this.zzaZQ == null || this.zzaZQ.length <= 0) {
                return zzz;
            }
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < this.zzaZQ.length) {
                String str = this.zzaZQ[i4];
                if (str != null) {
                    i = i3 + 1;
                    i2 += zzsn.zzgO(str);
                } else {
                    i = i3;
                }
                i4++;
                i3 = i;
            }
            return zzz + i2 + (i3 * 1);
        }
    }
}
