package com.google.android.gms.internal;

import java.security.MessageDigest;

@zzhb
public class zzbj extends zzbg {
    private MessageDigest zztw;

    /* access modifiers changed from: package-private */
    public byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzk(zzbi.zzx(strArr[i]));
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public byte zzk(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] zzu(String str) {
        byte[] bArr;
        int i = 4;
        byte[] zza = zza(str.split(" "));
        this.zztw = zzcL();
        synchronized (this.zzpV) {
            if (this.zztw == null) {
                bArr = new byte[0];
            } else {
                this.zztw.reset();
                this.zztw.update(zza);
                byte[] digest = this.zztw.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
