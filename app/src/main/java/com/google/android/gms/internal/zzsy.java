package com.google.android.gms.internal;

import java.io.IOException;

public interface zzsy {

    public static final class zza extends zzsu {
        public String name;
        public zzb[] zzbuE;

        public zza() {
            zzJz();
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza zza = (zza) obj;
                if (this.name == null) {
                    if (zza.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(zza.name)) {
                    return false;
                }
                if (!zzss.equals((Object[]) this.zzbuE, (Object[]) zza.zzbuE)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode((Object[]) this.zzbuE);
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.name != null) {
                zzsn.zzn(1, this.name);
            }
            if (this.zzbuE != null && this.zzbuE.length > 0) {
                for (zzb zzb : this.zzbuE) {
                    if (zzb != null) {
                        zzsn.zza(2, (zzsu) zzb);
                    }
                }
            }
            super.writeTo(zzsn);
        }

        public zza zzJz() {
            this.name = null;
            this.zzbuE = zzb.zzJA();
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzQ */
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
                        int zzc = zzsx.zzc(zzsm, 18);
                        int length = this.zzbuE == null ? 0 : this.zzbuE.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbuE, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzsm.zza(zzbArr[length]);
                            zzsm.zzIX();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzsm.zza(zzbArr[length]);
                        this.zzbuE = zzbArr;
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
            if (this.zzbuE != null && this.zzbuE.length > 0) {
                for (zzb zzb : this.zzbuE) {
                    if (zzb != null) {
                        zzz += zzsn.zzc(2, (zzsu) zzb);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzb extends zzsu {
        private static volatile zzb[] zzbuF;
        public String name;
        public Integer zzbuG;
        public Boolean zzbuH;

        public zzb() {
            zzJB();
        }

        public static zzb[] zzJA() {
            if (zzbuF == null) {
                synchronized (zzss.zzbut) {
                    if (zzbuF == null) {
                        zzbuF = new zzb[0];
                    }
                }
            }
            return zzbuF;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof zzb)) {
                    return false;
                }
                zzb zzb = (zzb) obj;
                if (this.name == null) {
                    if (zzb.name != null) {
                        return false;
                    }
                } else if (!this.name.equals(zzb.name)) {
                    return false;
                }
                if (this.zzbuG == null) {
                    if (zzb.zzbuG != null) {
                        return false;
                    }
                } else if (!this.zzbuG.equals(zzb.zzbuG)) {
                    return false;
                }
                if (this.zzbuH == null) {
                    if (zzb.zzbuH != null) {
                        return false;
                    }
                } else if (!this.zzbuH.equals(zzb.zzbuH)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int hashCode2 = this.name == null ? 0 : this.name.hashCode();
            int intValue = this.zzbuG == null ? 0 : this.zzbuG.intValue();
            if (this.zzbuH != null) {
                i = this.zzbuH.hashCode();
            }
            return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + intValue) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            if (this.name != null) {
                zzsn.zzn(1, this.name);
            }
            if (this.zzbuG != null) {
                zzsn.zzA(3, this.zzbuG.intValue());
            }
            if (this.zzbuH != null) {
                zzsn.zze(4, this.zzbuH.booleanValue());
            }
            super.writeTo(zzsn);
        }

        public zzb zzJB() {
            this.name = null;
            this.zzbuG = null;
            this.zzbuH = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzR */
        public zzb mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsm.readString();
                        continue;
                    case 24:
                        int zzJb = zzsm.zzJb();
                        switch (zzJb) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.zzbuG = Integer.valueOf(zzJb);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.zzbuH = Boolean.valueOf(zzsm.zzJc());
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
            if (this.zzbuG != null) {
                zzz += zzsn.zzC(3, this.zzbuG.intValue());
            }
            return this.zzbuH != null ? zzz + zzsn.zzf(4, this.zzbuH.booleanValue()) : zzz;
        }
    }
}
