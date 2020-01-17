package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.io.IOException;

public interface zzrq {

    public static final class zza extends zzso<zza> {
        public long zzbmd;
        public zzaf.zzj zzbme;
        public zzaf.zzf zzju;

        public zza() {
            zzHG();
        }

        public static zza zzy(byte[] bArr) throws zzst {
            return (zza) zzsu.mergeFrom(new zza(), bArr);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.zzbme == null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (r7.zzju == null) goto L_0x001b;
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
                boolean r2 = r7 instanceof com.google.android.gms.internal.zzrq.zza
                if (r2 == 0) goto L_0x003b
                com.google.android.gms.internal.zzrq$zza r7 = (com.google.android.gms.internal.zzrq.zza) r7
                long r2 = r6.zzbmd
                long r4 = r7.zzbmd
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x003b
                com.google.android.gms.internal.zzaf$zzf r2 = r6.zzju
                if (r2 != 0) goto L_0x003d
                com.google.android.gms.internal.zzaf$zzf r2 = r7.zzju
                if (r2 != 0) goto L_0x003b
            L_0x001b:
                com.google.android.gms.internal.zzaf$zzj r2 = r6.zzbme
                if (r2 != 0) goto L_0x0049
                com.google.android.gms.internal.zzaf$zzj r2 = r7.zzbme
                if (r2 != 0) goto L_0x003b
            L_0x0023:
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                if (r2 == 0) goto L_0x002f
                com.google.android.gms.internal.zzsq r2 = r6.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x0055
            L_0x002f:
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                if (r2 == 0) goto L_0x0004
                com.google.android.gms.internal.zzsq r2 = r7.zzbuj
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x0004
            L_0x003b:
                r0 = r1
                goto L_0x0004
            L_0x003d:
                com.google.android.gms.internal.zzaf$zzf r2 = r6.zzju
                com.google.android.gms.internal.zzaf$zzf r3 = r7.zzju
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x001b
                r0 = r1
                goto L_0x0004
            L_0x0049:
                com.google.android.gms.internal.zzaf$zzj r2 = r6.zzbme
                com.google.android.gms.internal.zzaf$zzj r3 = r7.zzbme
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x0023
                r0 = r1
                goto L_0x0004
            L_0x0055:
                com.google.android.gms.internal.zzsq r0 = r6.zzbuj
                com.google.android.gms.internal.zzsq r1 = r7.zzbuj
                boolean r0 = r0.equals(r1)
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrq.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = getClass().getName().hashCode();
            int i2 = (int) (this.zzbmd ^ (this.zzbmd >>> 32));
            int hashCode2 = this.zzju == null ? 0 : this.zzju.hashCode();
            int hashCode3 = this.zzbme == null ? 0 : this.zzbme.hashCode();
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                i = this.zzbuj.hashCode();
            }
            return ((((hashCode2 + ((((hashCode + 527) * 31) + i2) * 31)) * 31) + hashCode3) * 31) + i;
        }

        public void writeTo(zzsn zzsn) throws IOException {
            zzsn.zzb(1, this.zzbmd);
            if (this.zzju != null) {
                zzsn.zza(2, (zzsu) this.zzju);
            }
            if (this.zzbme != null) {
                zzsn.zza(3, (zzsu) this.zzbme);
            }
            super.writeTo(zzsn);
        }

        public zza zzHG() {
            this.zzbmd = 0;
            this.zzju = null;
            this.zzbme = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* renamed from: zzJ */
        public zza mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbmd = zzsm.zzJa();
                        continue;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzaf.zzf();
                        }
                        zzsm.zza(this.zzju);
                        continue;
                    case 26:
                        if (this.zzbme == null) {
                            this.zzbme = new zzaf.zzj();
                        }
                        zzsm.zza(this.zzbme);
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
            int zzz = super.zzz() + zzsn.zzd(1, this.zzbmd);
            if (this.zzju != null) {
                zzz += zzsn.zzc(2, (zzsu) this.zzju);
            }
            return this.zzbme != null ? zzz + zzsn.zzc(3, (zzsu) this.zzbme) : zzz;
        }
    }
}
