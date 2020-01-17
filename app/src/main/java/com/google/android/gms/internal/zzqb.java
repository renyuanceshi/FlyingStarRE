package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public interface zzqb {

    public static final class zza extends zzsu {
        private static volatile zza[] zzaZZ;
        public Integer zzaZr;
        public zzf zzbaa;
        public zzf zzbab;
        public Boolean zzbac;

        public zza() {
            zzDQ();
        }

        public static zza[] zzDP() {
            if (zzaZZ == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZZ == null) {
                        zzaZZ = new zza[0];
                    }
                }
            }
            return zzaZZ;
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
                if (this.zzbaa == null) {
                    if (zza.zzbaa != null) {
                        return false;
                    }
                } else if (!this.zzbaa.equals(zza.zzbaa)) {
                    return false;
                }
                if (this.zzbab == null) {
                    if (zza.zzbab != null) {
                        return false;
                    }
                } else if (!this.zzbab.equals(zza.zzbab)) {
                    return false;
                }
                if (this.zzbac == null) {
                    if (zza.zzbac != null) {
                        return false;
                    }
                } else if (!this.zzbac.equals(zza.zzbac)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzaZr == null ? 0 : this.zzaZr.hashCode();
            int hashCode3 = this.zzbaa == null ? 0 : this.zzbaa.hashCode();
            int hashCode4 = this.zzbab == null ? 0 : this.zzbab.hashCode();
            if (this.zzbac != null) {
                i = this.zzbac.hashCode();
            }
            return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzaZr != null) {
                zzsn.zzA(1, this.zzaZr.intValue());
            }
            if (this.zzbaa != null) {
                zzsn.zza(2, (zzsu) this.zzbaa);
            }
            if (this.zzbab != null) {
                zzsn.zza(3, (zzsu) this.zzbab);
            }
            if (this.zzbac != null) {
                zzsn.zze(4, this.zzbac.booleanValue());
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzC */
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
                        if (this.zzbaa == null) {
                            this.zzbaa = new zzf();
                        }
                        zzsm.zza(this.zzbaa);
                        continue;
                    case 26:
                        if (this.zzbab == null) {
                            this.zzbab = new zzf();
                        }
                        zzsm.zza(this.zzbab);
                        continue;
                    case 32:
                        this.zzbac = Boolean.valueOf(zzsm.zzJc());
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

        public zza zzDQ() {
            this.zzaZr = null;
            this.zzbaa = null;
            this.zzbab = null;
            this.zzbac = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzaZr != null) {
                zzz += zzsn.zzC(1, this.zzaZr.intValue());
            }
            if (this.zzbaa != null) {
                zzz += zzsn.zzc(2, (zzsu) this.zzbaa);
            }
            if (this.zzbab != null) {
                zzz += zzsn.zzc(3, (zzsu) this.zzbab);
            }
            return this.zzbac != null ? zzz + zzsn.zzf(4, this.zzbac.booleanValue()) : zzz;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzbad;
        public Integer count;
        public String name;
        public zzc[] zzbae;
        public Long zzbaf;
        public Long zzbag;

        public zzb() {
            zzDS();
        }

        public static zzb[] zzDR() {
            if (zzbad == null) {
                synchronized (zzss.zzbut) {
                    if (zzbad == null) {
                        zzbad = new zzb[0];
                    }
                }
            }
            return zzbad;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                zzb zzb = (zzb) obj;
                if (!zzss.equals((Object[]) this.zzbae, (Object[]) zzb.zzbae)) {
                    return false;
                }
                if (this.name == null) {
                    if (zzb.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(zzb.name)) {
                    return false;
                }
                if (this.zzbaf == null) {
                    if (zzb.zzbaf != null) {
                        return false;
                    }
                } else if (!this.zzbaf.equals(zzb.zzbaf)) {
                    return false;
                }
                if (this.zzbag == null) {
                    if (zzb.zzbag != null) {
                        return false;
                    }
                } else if (!this.zzbag.equals(zzb.zzbag)) {
                    return false;
                }
                if (this.count == null) {
                    if (zzb.count != null) {
                        return false;
                    }
                } else if (!this.count.equals(zzb.count)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = zzss.hashCode((Object[]) this.zzbae);
            int hashCode3 = this.name == null ? 0 : this.name.hashCode();
            int hashCode4 = this.zzbaf == null ? 0 : this.zzbaf.hashCode();
            int hashCode5 = this.zzbag == null ? 0 : this.zzbag.hashCode();
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return ((((((hashCode3 + ((((hashCode + 527) * 31) + hashCode2) * 31)) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbae != null && this.zzbae.length > 0) {
                for (zzc zzc : this.zzbae) {
                    if (zzc != null) {
                        zzsn.zza(1, (zzsu) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzsn.zzn(2, this.name);
            }
            if (this.zzbaf != null) {
                zzsn.zzb(3, this.zzbaf.longValue());
            }
            if (this.zzbag != null) {
                zzsn.zzb(4, this.zzbag.longValue());
            }
            if (this.count != null) {
                zzsn.zzA(5, this.count.intValue());
            }
            super.writeTo(zzsn);
        }

        /* renamed from: zzD */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzbae == null ? 0 : this.zzbae.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbae, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzsm.zza(zzcArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzsm.zza(zzcArr[length]);
                        this.zzbae = zzcArr;
                        continue;
                    case 18:
                        this.name = zzsm.readString();
                        continue;
                    case 24:
                        this.zzbaf = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 32:
                        this.zzbag = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 40:
                        this.count = Integer.valueOf(zzsm.zzJb());
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

        public zzb zzDS() {
            this.zzbae = zzc.zzDT();
            this.name = null;
            this.zzbaf = null;
            this.zzbag = null;
            this.count = null;
            this.zzbuu = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            if (this.zzbae != null && this.zzbae.length > 0) {
                for (zzc zzc : this.zzbae) {
                    if (zzc != null) {
                        zzz += zzsn.zzc(1, (zzsu) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzz += zzsn.zzo(2, this.name);
            }
            if (this.zzbaf != null) {
                zzz += zzsn.zzd(3, this.zzbaf.longValue());
            }
            if (this.zzbag != null) {
                zzz += zzsn.zzd(4, this.zzbag.longValue());
            }
            return this.count != null ? zzz + zzsn.zzC(5, this.count.intValue()) : zzz;
        }
    }

    public static final class zzc extends zzsu {
        private static volatile zzc[] zzbah;
        public String name;
        public Float zzaZo;
        public String zzamJ;
        public Long zzbai;

        public zzc() {
            zzDU();
        }

        public static zzc[] zzDT() {
            if (zzbah == null) {
                synchronized (zzss.zzbut) {
                    if (zzbah == null) {
                        zzbah = new zzc[0];
                    }
                }
            }
            return zzbah;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzc)) {
                    return false;
                }
                zzc zzc = (zzc) obj;
                if (this.name == null) {
                    if (zzc.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(zzc.name)) {
                    return false;
                }
                if (this.zzamJ == null) {
                    if (zzc.zzamJ != null) {
                        return false;
                    }
                } else if (!this.zzamJ.equals(zzc.zzamJ)) {
                    return false;
                }
                if (this.zzbai == null) {
                    if (zzc.zzbai != null) {
                        return false;
                    }
                } else if (!this.zzbai.equals(zzc.zzbai)) {
                    return false;
                }
                if (this.zzaZo == null) {
                    if (zzc.zzaZo != null) {
                        return false;
                    }
                } else if (!this.zzaZo.equals(zzc.zzaZo)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.name == null ? 0 : this.name.hashCode();
            int hashCode3 = this.zzamJ == null ? 0 : this.zzamJ.hashCode();
            int hashCode4 = this.zzbai == null ? 0 : this.zzbai.hashCode();
            if (this.zzaZo != null) {
                i = this.zzaZo.hashCode();
            }
            return ((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.name != null) {
                zzsn.zzn(1, this.name);
            }
            if (this.zzamJ != null) {
                zzsn.zzn(2, this.zzamJ);
            }
            if (this.zzbai != null) {
                zzsn.zzb(3, this.zzbai.longValue());
            }
            if (this.zzaZo != null) {
                zzsn.zzb(4, this.zzaZo.floatValue());
            }
            super.writeTo(zzsn);
        }

        public zzc zzDU() {
            this.name = null;
            this.zzamJ = null;
            this.zzbai = null;
            this.zzaZo = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzE */
        public zzc mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsm.readString();
                        continue;
                    case 18:
                        this.zzamJ = zzsm.readString();
                        continue;
                    case 24:
                        this.zzbai = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 37:
                        this.zzaZo = Float.valueOf(zzsm.readFloat());
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
            if (this.name != null) {
                zzz += zzsn.zzo(1, this.name);
            }
            if (this.zzamJ != null) {
                zzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzbai != null) {
                zzz += zzsn.zzd(3, this.zzbai.longValue());
            }
            return this.zzaZo != null ? zzz + zzsn.zzc(4, this.zzaZo.floatValue()) : zzz;
        }
    }

    public static final class zzd extends zzsu {
        public zze[] zzbaj;

        public zzd() {
            zzDV();
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof zzd) && zzss.equals((Object[]) this.zzbaj, (Object[]) ((zzd) obj).zzbaj));
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode((Object[]) this.zzbaj);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbaj != null && this.zzbaj.length > 0) {
                for (zze zze : this.zzbaj) {
                    if (zze != null) {
                        zzsn.zza(1, (zzsu) zze);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zzd zzDV() {
            this.zzbaj = zze.zzDW();
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzF */
        public zzd mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsx.zzc(zzsm, 10);
                        int length = this.zzbaj == null ? 0 : this.zzbaj.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbaj, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzsm.zza(zzeArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzsm.zza(zzeArr[length]);
                        this.zzbaj = zzeArr;
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
            if (this.zzbaj != null && this.zzbaj.length > 0) {
                for (zze zze : this.zzbaj) {
                    if (zze != null) {
                        zzz += zzsn.zzc(1, (zzsu) zze);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zze extends zzsu {
        private static volatile zze[] zzbak;
        public String appId;
        public String osVersion;
        public String zzaMV;
        public String zzaVt;
        public String zzaVu;
        public String zzaVx;
        public Boolean zzbaA;
        public String zzbaB;
        public Long zzbaC;
        public Integer zzbaD;
        public Boolean zzbaE;
        public zza[] zzbaF;
        public Integer zzbal;
        public zzb[] zzbam;
        public zzg[] zzban;
        public Long zzbao;
        public Long zzbap;
        public Long zzbaq;
        public Long zzbar;
        public Long zzbas;
        public String zzbat;
        public String zzbau;
        public String zzbav;
        public Integer zzbaw;
        public Long zzbax;
        public Long zzbay;
        public String zzbaz;

        public zze() {
            zzDX();
        }

        public static zze[] zzDW() {
            if (zzbak == null) {
                synchronized (zzss.zzbut) {
                    if (zzbak == null) {
                        zzbak = new zze[0];
                    }
                }
            }
            return zzbak;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zze)) {
                    return false;
                }
                zze zze = (zze) obj;
                if (this.zzbal == null) {
                    if (zze.zzbal != null) {
                        return false;
                    }
                } else if (!this.zzbal.equals(zze.zzbal)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzbam, (Object[]) zze.zzbam) || !zzss.equals((Object[]) this.zzban, (Object[]) zze.zzban)) {
                    return false;
                }
                if (this.zzbao == null) {
                    if (zze.zzbao != null) {
                        return false;
                    }
                } else if (!this.zzbao.equals(zze.zzbao)) {
                    return false;
                }
                if (this.zzbap == null) {
                    if (zze.zzbap != null) {
                        return false;
                    }
                } else if (!this.zzbap.equals(zze.zzbap)) {
                    return false;
                }
                if (this.zzbaq == null) {
                    if (zze.zzbaq != null) {
                        return false;
                    }
                } else if (!this.zzbaq.equals(zze.zzbaq)) {
                    return false;
                }
                if (this.zzbar == null) {
                    if (zze.zzbar != null) {
                        return false;
                    }
                } else if (!this.zzbar.equals(zze.zzbar)) {
                    return false;
                }
                if (this.zzbas == null) {
                    if (zze.zzbas != null) {
                        return false;
                    }
                } else if (!this.zzbas.equals(zze.zzbas)) {
                    return false;
                }
                if (this.zzbat == null) {
                    if (zze.zzbat != null) {
                        return false;
                    }
                } else if (!this.zzbat.equals(zze.zzbat)) {
                    return false;
                }
                if (this.osVersion == null) {
                    if (zze.osVersion != null) {
                        return false;
                    }
                } else if (!this.osVersion.equals(zze.osVersion)) {
                    return false;
                }
                if (this.zzbau == null) {
                    if (zze.zzbau != null) {
                        return false;
                    }
                } else if (!this.zzbau.equals(zze.zzbau)) {
                    return false;
                }
                if (this.zzbav == null) {
                    if (zze.zzbav != null) {
                        return false;
                    }
                } else if (!this.zzbav.equals(zze.zzbav)) {
                    return false;
                }
                if (this.zzbaw == null) {
                    if (zze.zzbaw != null) {
                        return false;
                    }
                } else if (!this.zzbaw.equals(zze.zzbaw)) {
                    return false;
                }
                if (this.zzaVu == null) {
                    if (zze.zzaVu != null) {
                        return false;
                    }
                } else if (!this.zzaVu.equals(zze.zzaVu)) {
                    return false;
                }
                if (this.appId == null) {
                    if (zze.appId != null) {
                        return false;
                    }
                } else if (!this.appId.equals(zze.appId)) {
                    return false;
                }
                if (this.zzaMV == null) {
                    if (zze.zzaMV != null) {
                        return false;
                    }
                } else if (!this.zzaMV.equals(zze.zzaMV)) {
                    return false;
                }
                if (this.zzbax == null) {
                    if (zze.zzbax != null) {
                        return false;
                    }
                } else if (!this.zzbax.equals(zze.zzbax)) {
                    return false;
                }
                if (this.zzbay == null) {
                    if (zze.zzbay != null) {
                        return false;
                    }
                } else if (!this.zzbay.equals(zze.zzbay)) {
                    return false;
                }
                if (this.zzbaz == null) {
                    if (zze.zzbaz != null) {
                        return false;
                    }
                } else if (!this.zzbaz.equals(zze.zzbaz)) {
                    return false;
                }
                if (this.zzbaA == null) {
                    if (zze.zzbaA != null) {
                        return false;
                    }
                } else if (!this.zzbaA.equals(zze.zzbaA)) {
                    return false;
                }
                if (this.zzbaB == null) {
                    if (zze.zzbaB != null) {
                        return false;
                    }
                } else if (!this.zzbaB.equals(zze.zzbaB)) {
                    return false;
                }
                if (this.zzbaC == null) {
                    if (zze.zzbaC != null) {
                        return false;
                    }
                } else if (!this.zzbaC.equals(zze.zzbaC)) {
                    return false;
                }
                if (this.zzbaD == null) {
                    if (zze.zzbaD != null) {
                        return false;
                    }
                } else if (!this.zzbaD.equals(zze.zzbaD)) {
                    return false;
                }
                if (this.zzaVx == null) {
                    if (zze.zzaVx != null) {
                        return false;
                    }
                } else if (!this.zzaVx.equals(zze.zzaVx)) {
                    return false;
                }
                if (this.zzaVt == null) {
                    if (zze.zzaVt != null) {
                        return false;
                    }
                } else if (!this.zzaVt.equals(zze.zzaVt)) {
                    return false;
                }
                if (this.zzbaE == null) {
                    if (zze.zzbaE != null) {
                        return false;
                    }
                } else if (!this.zzbaE.equals(zze.zzbaE)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzbaF, (Object[]) zze.zzbaF)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzbal == null ? 0 : this.zzbal.hashCode();
            int hashCode3 = zzss.hashCode((Object[]) this.zzbam);
            int hashCode4 = zzss.hashCode((Object[]) this.zzban);
            int hashCode5 = this.zzbao == null ? 0 : this.zzbao.hashCode();
            int hashCode6 = this.zzbap == null ? 0 : this.zzbap.hashCode();
            int hashCode7 = this.zzbaq == null ? 0 : this.zzbaq.hashCode();
            int hashCode8 = this.zzbar == null ? 0 : this.zzbar.hashCode();
            int hashCode9 = this.zzbas == null ? 0 : this.zzbas.hashCode();
            int hashCode10 = this.zzbat == null ? 0 : this.zzbat.hashCode();
            int hashCode11 = this.osVersion == null ? 0 : this.osVersion.hashCode();
            int hashCode12 = this.zzbau == null ? 0 : this.zzbau.hashCode();
            int hashCode13 = this.zzbav == null ? 0 : this.zzbav.hashCode();
            int hashCode14 = this.zzbaw == null ? 0 : this.zzbaw.hashCode();
            int hashCode15 = this.zzaVu == null ? 0 : this.zzaVu.hashCode();
            int hashCode16 = this.appId == null ? 0 : this.appId.hashCode();
            int hashCode17 = this.zzaMV == null ? 0 : this.zzaMV.hashCode();
            int hashCode18 = this.zzbax == null ? 0 : this.zzbax.hashCode();
            int hashCode19 = this.zzbay == null ? 0 : this.zzbay.hashCode();
            int hashCode20 = this.zzbaz == null ? 0 : this.zzbaz.hashCode();
            int hashCode21 = this.zzbaA == null ? 0 : this.zzbaA.hashCode();
            int hashCode22 = this.zzbaB == null ? 0 : this.zzbaB.hashCode();
            int hashCode23 = this.zzbaC == null ? 0 : this.zzbaC.hashCode();
            int hashCode24 = this.zzbaD == null ? 0 : this.zzbaD.hashCode();
            int hashCode25 = this.zzaVx == null ? 0 : this.zzaVx.hashCode();
            int hashCode26 = this.zzaVt == null ? 0 : this.zzaVt.hashCode();
            if (this.zzbaE != null) {
                i = this.zzbaE.hashCode();
            }
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + i) * 31) + zzss.hashCode((Object[]) this.zzbaF);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbal != null) {
                zzsn.zzA(1, this.zzbal.intValue());
            }
            if (this.zzbam != null && this.zzbam.length > 0) {
                for (zzb zzb : this.zzbam) {
                    if (zzb != null) {
                        zzsn.zza(2, (zzsu) zzb);
                    }
                }
            }
            if (this.zzban != null && this.zzban.length > 0) {
                for (zzg zzg : this.zzban) {
                    if (zzg != null) {
                        zzsn.zza(3, (zzsu) zzg);
                    }
                }
            }
            if (this.zzbao != null) {
                zzsn.zzb(4, this.zzbao.longValue());
            }
            if (this.zzbap != null) {
                zzsn.zzb(5, this.zzbap.longValue());
            }
            if (this.zzbaq != null) {
                zzsn.zzb(6, this.zzbaq.longValue());
            }
            if (this.zzbas != null) {
                zzsn.zzb(7, this.zzbas.longValue());
            }
            if (this.zzbat != null) {
                zzsn.zzn(8, this.zzbat);
            }
            if (this.osVersion != null) {
                zzsn.zzn(9, this.osVersion);
            }
            if (this.zzbau != null) {
                zzsn.zzn(10, this.zzbau);
            }
            if (this.zzbav != null) {
                zzsn.zzn(11, this.zzbav);
            }
            if (this.zzbaw != null) {
                zzsn.zzA(12, this.zzbaw.intValue());
            }
            if (this.zzaVu != null) {
                zzsn.zzn(13, this.zzaVu);
            }
            if (this.appId != null) {
                zzsn.zzn(14, this.appId);
            }
            if (this.zzaMV != null) {
                zzsn.zzn(16, this.zzaMV);
            }
            if (this.zzbax != null) {
                zzsn.zzb(17, this.zzbax.longValue());
            }
            if (this.zzbay != null) {
                zzsn.zzb(18, this.zzbay.longValue());
            }
            if (this.zzbaz != null) {
                zzsn.zzn(19, this.zzbaz);
            }
            if (this.zzbaA != null) {
                zzsn.zze(20, this.zzbaA.booleanValue());
            }
            if (this.zzbaB != null) {
                zzsn.zzn(21, this.zzbaB);
            }
            if (this.zzbaC != null) {
                zzsn.zzb(22, this.zzbaC.longValue());
            }
            if (this.zzbaD != null) {
                zzsn.zzA(23, this.zzbaD.intValue());
            }
            if (this.zzaVx != null) {
                zzsn.zzn(24, this.zzaVx);
            }
            if (this.zzaVt != null) {
                zzsn.zzn(25, this.zzaVt);
            }
            if (this.zzbar != null) {
                zzsn.zzb(26, this.zzbar.longValue());
            }
            if (this.zzbaE != null) {
                zzsn.zze(28, this.zzbaE.booleanValue());
            }
            if (this.zzbaF != null && this.zzbaF.length > 0) {
                for (zza zza : this.zzbaF) {
                    if (zza != null) {
                        zzsn.zza(29, (zzsu) zza);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zze zzDX() {
            this.zzbal = null;
            this.zzbam = zzb.zzDR();
            this.zzban = zzg.zzDZ();
            this.zzbao = null;
            this.zzbap = null;
            this.zzbaq = null;
            this.zzbar = null;
            this.zzbas = null;
            this.zzbat = null;
            this.osVersion = null;
            this.zzbau = null;
            this.zzbav = null;
            this.zzbaw = null;
            this.zzaVu = null;
            this.appId = null;
            this.zzaMV = null;
            this.zzbax = null;
            this.zzbay = null;
            this.zzbaz = null;
            this.zzbaA = null;
            this.zzbaB = null;
            this.zzbaC = null;
            this.zzbaD = null;
            this.zzaVx = null;
            this.zzaVt = null;
            this.zzbaE = null;
            this.zzbaF = zza.zzDP();
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzG */
        public zze mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbal = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 18:
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzbam == null ? 0 : this.zzbam.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbam, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzsm.zza(zzbArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzsm.zza(zzbArr[length]);
                        this.zzbam = zzbArr;
                        continue;
                    case 26:
                        int zzc2 = zzsx.zzc(zzsm, 26);
                        int length2 = this.zzban == null ? 0 : this.zzban.length;
                        zzg[] zzgArr = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzban, 0, zzgArr, 0, length2);
                        }
                        while (length2 < zzgArr.length - 1) {
                            zzgArr[length2] = new zzg();
                            zzsm.zza(zzgArr[length2]);
                            zzsm.zzIX();
                            length2++;
                        }
                        zzgArr[length2] = new zzg();
                        zzsm.zza(zzgArr[length2]);
                        this.zzban = zzgArr;
                        continue;
                    case 32:
                        this.zzbao = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 40:
                        this.zzbap = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 48:
                        this.zzbaq = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 56:
                        this.zzbas = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 66:
                        this.zzbat = zzsm.readString();
                        continue;
                    case 74:
                        this.osVersion = zzsm.readString();
                        continue;
                    case 82:
                        this.zzbau = zzsm.readString();
                        continue;
                    case 90:
                        this.zzbav = zzsm.readString();
                        continue;
                    case 96:
                        this.zzbaw = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 106:
                        this.zzaVu = zzsm.readString();
                        continue;
                    case 114:
                        this.appId = zzsm.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        this.zzaMV = zzsm.readString();
                        continue;
                    case 136:
                        this.zzbax = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 144:
                        this.zzbay = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 154:
                        this.zzbaz = zzsm.readString();
                        continue;
                    case 160:
                        this.zzbaA = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 170:
                        this.zzbaB = zzsm.readString();
                        continue;
                    case 176:
                        this.zzbaC = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 184:
                        this.zzbaD = Integer.valueOf(zzsm.zzJb());
                        continue;
                    case 194:
                        this.zzaVx = zzsm.readString();
                        continue;
                    case 202:
                        this.zzaVt = zzsm.readString();
                        continue;
                    case 208:
                        this.zzbar = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 224:
                        this.zzbaE = Boolean.valueOf(zzsm.zzJc());
                        continue;
                    case 234:
                        int zzc3 = zzsx.zzc(zzsm, 234);
                        int length3 = this.zzbaF == null ? 0 : this.zzbaF.length;
                        zza[] zzaArr = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbaF, 0, zzaArr, 0, length3);
                        }
                        while (length3 < zzaArr.length - 1) {
                            zzaArr[length3] = new zza();
                            zzsm.zza(zzaArr[length3]);
                            zzsm.zzIX();
                            length3++;
                        }
                        zzaArr[length3] = new zza();
                        zzsm.zza(zzaArr[length3]);
                        this.zzbaF = zzaArr;
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
            if (this.zzbal != null) {
                zzz += zzsn.zzC(1, this.zzbal.intValue());
            }
            if (this.zzbam != null && this.zzbam.length > 0) {
                int i = zzz;
                for (zzb zzb : this.zzbam) {
                    if (zzb != null) {
                        i += zzsn.zzc(2, (zzsu) zzb);
                    }
                }
                zzz = i;
            }
            if (this.zzban != null && this.zzban.length > 0) {
                int i2 = zzz;
                for (zzg zzg : this.zzban) {
                    if (zzg != null) {
                        i2 += zzsn.zzc(3, (zzsu) zzg);
                    }
                }
                zzz = i2;
            }
            if (this.zzbao != null) {
                zzz += zzsn.zzd(4, this.zzbao.longValue());
            }
            if (this.zzbap != null) {
                zzz += zzsn.zzd(5, this.zzbap.longValue());
            }
            if (this.zzbaq != null) {
                zzz += zzsn.zzd(6, this.zzbaq.longValue());
            }
            if (this.zzbas != null) {
                zzz += zzsn.zzd(7, this.zzbas.longValue());
            }
            if (this.zzbat != null) {
                zzz += zzsn.zzo(8, this.zzbat);
            }
            if (this.osVersion != null) {
                zzz += zzsn.zzo(9, this.osVersion);
            }
            if (this.zzbau != null) {
                zzz += zzsn.zzo(10, this.zzbau);
            }
            if (this.zzbav != null) {
                zzz += zzsn.zzo(11, this.zzbav);
            }
            if (this.zzbaw != null) {
                zzz += zzsn.zzC(12, this.zzbaw.intValue());
            }
            if (this.zzaVu != null) {
                zzz += zzsn.zzo(13, this.zzaVu);
            }
            if (this.appId != null) {
                zzz += zzsn.zzo(14, this.appId);
            }
            if (this.zzaMV != null) {
                zzz += zzsn.zzo(16, this.zzaMV);
            }
            if (this.zzbax != null) {
                zzz += zzsn.zzd(17, this.zzbax.longValue());
            }
            if (this.zzbay != null) {
                zzz += zzsn.zzd(18, this.zzbay.longValue());
            }
            if (this.zzbaz != null) {
                zzz += zzsn.zzo(19, this.zzbaz);
            }
            if (this.zzbaA != null) {
                zzz += zzsn.zzf(20, this.zzbaA.booleanValue());
            }
            if (this.zzbaB != null) {
                zzz += zzsn.zzo(21, this.zzbaB);
            }
            if (this.zzbaC != null) {
                zzz += zzsn.zzd(22, this.zzbaC.longValue());
            }
            if (this.zzbaD != null) {
                zzz += zzsn.zzC(23, this.zzbaD.intValue());
            }
            if (this.zzaVx != null) {
                zzz += zzsn.zzo(24, this.zzaVx);
            }
            if (this.zzaVt != null) {
                zzz += zzsn.zzo(25, this.zzaVt);
            }
            if (this.zzbar != null) {
                zzz += zzsn.zzd(26, this.zzbar.longValue());
            }
            if (this.zzbaE != null) {
                zzz += zzsn.zzf(28, this.zzbaE.booleanValue());
            }
            if (this.zzbaF != null && this.zzbaF.length > 0) {
                for (zza zza : this.zzbaF) {
                    if (zza != null) {
                        zzz += zzsn.zzc(29, (zzsu) zza);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzf extends zzsu {
        public long[] zzbaG;
        public long[] zzbaH;

        public zzf() {
            zzDY();
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzf)) {
                    return false;
                }
                zzf zzf = (zzf) obj;
                if (!zzss.equals(this.zzbaG, zzf.zzbaG) || !zzss.equals(this.zzbaH, zzf.zzbaH)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbaG)) * 31) + zzss.hashCode(this.zzbaH);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbaG != null && this.zzbaG.length > 0) {
                for (long zza : this.zzbaG) {
                    zzsn.zza(1, zza);
                }
            }
            if (this.zzbaH != null && this.zzbaH.length > 0) {
                for (long zza2 : this.zzbaH) {
                    zzsn.zza(2, zza2);
                }
            }
            super.writeTo(zzsn);
        }

        public zzf zzDY() {
            this.zzbaG = zzsx.zzbux;
            this.zzbaH = zzsx.zzbux;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzH */
        public zzf mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzsx.zzc(zzsm, 8);
                        int length = this.zzbaG == null ? 0 : this.zzbaG.length;
                        long[] jArr = new long[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbaG, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzsm.zzIZ();
                            zzsm.zzIX();
                            length++;
                        }
                        jArr[length] = zzsm.zzIZ();
                        this.zzbaG = jArr;
                        continue;
                    case 10:
                        int zzmq = zzsm.zzmq(zzsm.zzJf());
                        int position = zzsm.getPosition();
                        int i = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzIZ();
                            i++;
                        }
                        zzsm.zzms(position);
                        int length2 = this.zzbaG == null ? 0 : this.zzbaG.length;
                        long[] jArr2 = new long[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbaG, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzsm.zzIZ();
                            length2++;
                        }
                        this.zzbaG = jArr2;
                        zzsm.zzmr(zzmq);
                        continue;
                    case 16:
                        int zzc2 = zzsx.zzc(zzsm, 16);
                        int length3 = this.zzbaH == null ? 0 : this.zzbaH.length;
                        long[] jArr3 = new long[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbaH, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzsm.zzIZ();
                            zzsm.zzIX();
                            length3++;
                        }
                        jArr3[length3] = zzsm.zzIZ();
                        this.zzbaH = jArr3;
                        continue;
                    case 18:
                        int zzmq2 = zzsm.zzmq(zzsm.zzJf());
                        int position2 = zzsm.getPosition();
                        int i2 = 0;
                        while (zzsm.zzJk() > 0) {
                            zzsm.zzIZ();
                            i2++;
                        }
                        zzsm.zzms(position2);
                        int length4 = this.zzbaH == null ? 0 : this.zzbaH.length;
                        long[] jArr4 = new long[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbaH, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzsm.zzIZ();
                            length4++;
                        }
                        this.zzbaH = jArr4;
                        zzsm.zzmr(zzmq2);
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
            if (this.zzbaG != null && this.zzbaG.length > 0) {
                int i = 0;
                for (long zzar : this.zzbaG) {
                    i += zzsn.zzar(zzar);
                }
                zzz = i + zzz + (this.zzbaG.length * 1);
            }
            if (this.zzbaH == null || this.zzbaH.length <= 0) {
                return zzz;
            }
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.zzbaH.length) {
                i3++;
                i2 = zzsn.zzar(this.zzbaH[i3]) + i2;
            }
            return i2 + zzz + (this.zzbaH.length * 1);
        }
    }

    public static final class zzg extends zzsu {
        private static volatile zzg[] zzbaI;
        public String name;
        public Float zzaZo;
        public String zzamJ;
        public Long zzbaJ;
        public Long zzbai;

        public zzg() {
            zzEa();
        }

        public static zzg[] zzDZ() {
            if (zzbaI == null) {
                synchronized (zzss.zzbut) {
                    if (zzbaI == null) {
                        zzbaI = new zzg[0];
                    }
                }
            }
            return zzbaI;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzg)) {
                    return false;
                }
                zzg zzg = (zzg) obj;
                if (this.zzbaJ == null) {
                    if (zzg.zzbaJ != null) {
                        return false;
                    }
                } else if (!this.zzbaJ.equals(zzg.zzbaJ)) {
                    return false;
                }
                if (this.name == null) {
                    if (zzg.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(zzg.name)) {
                    return false;
                }
                if (this.zzamJ == null) {
                    if (zzg.zzamJ != null) {
                        return false;
                    }
                } else if (!this.zzamJ.equals(zzg.zzamJ)) {
                    return false;
                }
                if (this.zzbai == null) {
                    if (zzg.zzbai != null) {
                        return false;
                    }
                } else if (!this.zzbai.equals(zzg.zzbai)) {
                    return false;
                }
                if (this.zzaZo == null) {
                    if (zzg.zzaZo != null) {
                        return false;
                    }
                } else if (!this.zzaZo.equals(zzg.zzaZo)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.zzbaJ == null ? 0 : this.zzbaJ.hashCode();
            int hashCode3 = this.name == null ? 0 : this.name.hashCode();
            int hashCode4 = this.zzamJ == null ? 0 : this.zzamJ.hashCode();
            int hashCode5 = this.zzbai == null ? 0 : this.zzbai.hashCode();
            if (this.zzaZo != null) {
                i = this.zzaZo.hashCode();
            }
            return ((((((((hashCode2 + ((hashCode + 527) * 31)) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.zzbaJ != null) {
                zzsn.zzb(1, this.zzbaJ.longValue());
            }
            if (this.name != null) {
                zzsn.zzn(2, this.name);
            }
            if (this.zzamJ != null) {
                zzsn.zzn(3, this.zzamJ);
            }
            if (this.zzbai != null) {
                zzsn.zzb(4, this.zzbai.longValue());
            }
            if (this.zzaZo != null) {
                zzsn.zzb(5, this.zzaZo.floatValue());
            }
            super.writeTo(zzsn);
        }

        public zzg zzEa() {
            this.zzbaJ = null;
            this.name = null;
            this.zzamJ = null;
            this.zzbai = null;
            this.zzaZo = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzI */
        public zzg mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbaJ = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 18:
                        this.name = zzsm.readString();
                        continue;
                    case 26:
                        this.zzamJ = zzsm.readString();
                        continue;
                    case 32:
                        this.zzbai = Long.valueOf(zzsm.zzJa());
                        continue;
                    case 45:
                        this.zzaZo = Float.valueOf(zzsm.readFloat());
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
            if (this.zzbaJ != null) {
                zzz += zzsn.zzd(1, this.zzbaJ.longValue());
            }
            if (this.name != null) {
                zzz += zzsn.zzo(2, this.name);
            }
            if (this.zzamJ != null) {
                zzz += zzsn.zzo(3, this.zzamJ);
            }
            if (this.zzbai != null) {
                zzz += zzsn.zzd(4, this.zzbai.longValue());
            }
            return this.zzaZo != null ? zzz + zzsn.zzc(5, this.zzaZo.floatValue()) : zzz;
        }
    }
}
