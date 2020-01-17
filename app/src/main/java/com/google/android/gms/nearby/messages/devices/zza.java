package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

abstract class zza {
    private static final char[] zzbbX = "0123456789abcdef".toCharArray();
    private final byte[] zzbbY;

    protected zza(byte[] bArr) {
        this.zzbbY = bArr;
    }

    static String zzt(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(zzbbX[(b >> 4) & 15]).append(zzbbX[b & 15]);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.zzbbY, ((zza) obj).zzbbY);
    }

    /* access modifiers changed from: package-private */
    public byte[] getBytes() {
        return this.zzbbY;
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzbbY);
    }

    public String toString() {
        return zzt(this.zzbbY);
    }

    /* access modifiers changed from: package-private */
    public String zzEt() {
        return zzt(this.zzbbY);
    }
}
