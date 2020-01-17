package com.google.android.gms.internal;

public class zzsl {
    private final byte[] zzbtW = new byte[256];
    private int zzbtX;
    private int zzbtY;

    public zzsl(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzbtW[i] = (byte) ((byte) i);
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.zzbtW[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.zzbtW[i2];
            this.zzbtW[i2] = (byte) this.zzbtW[b];
            this.zzbtW[b] = (byte) b2;
        }
        this.zzbtX = 0;
        this.zzbtY = 0;
    }

    public void zzC(byte[] bArr) {
        int i = this.zzbtX;
        int i2 = this.zzbtY;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.zzbtW[i]) & 255;
            byte b = this.zzbtW[i];
            this.zzbtW[i] = (byte) this.zzbtW[i2];
            this.zzbtW[i2] = (byte) b;
            bArr[i3] = (byte) ((byte) (bArr[i3] ^ this.zzbtW[(this.zzbtW[i] + this.zzbtW[i2]) & 255]));
        }
        this.zzbtX = i;
        this.zzbtY = i2;
    }
}
