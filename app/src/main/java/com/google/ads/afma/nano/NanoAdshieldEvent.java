package com.google.ads.afma.nano;

import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzss;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsx;
import java.io.IOException;

public interface NanoAdshieldEvent {

    public static final class AdShieldEvent extends zzsu {
        private static volatile AdShieldEvent[] zzaK;
        public String appId;

        public AdShieldEvent() {
            clear();
        }

        public static AdShieldEvent[] emptyArray() {
            if (zzaK == null) {
                synchronized (zzss.zzbut) {
                    if (zzaK == null) {
                        zzaK = new AdShieldEvent[0];
                    }
                }
            }
            return zzaK;
        }

        public static AdShieldEvent parseFrom(zzsm zzsm) throws IOException {
            return new AdShieldEvent().mergeFrom(zzsm);
        }

        public static AdShieldEvent parseFrom(byte[] bArr) throws zzst {
            return (AdShieldEvent) zzsu.mergeFrom(new AdShieldEvent(), bArr);
        }

        public AdShieldEvent clear() {
            this.appId = "";
            this.zzbuu = -1;
            return this;
        }

        public AdShieldEvent mergeFrom(zzsm zzsm) throws IOException {
            while (true) {
                int zzIX = zzsm.zzIX();
                switch (zzIX) {
                    case 0:
                        break;
                    case 10:
                        this.appId = zzsm.readString();
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

        public void writeTo(zzsn zzsn) throws IOException {
            if (!this.appId.equals("")) {
                zzsn.zzn(1, this.appId);
            }
            super.writeTo(zzsn);
        }

        /* access modifiers changed from: protected */
        public int zzz() {
            int zzz = super.zzz();
            return !this.appId.equals("") ? zzz + zzsn.zzo(1, this.appId) : zzz;
        }
    }
}
