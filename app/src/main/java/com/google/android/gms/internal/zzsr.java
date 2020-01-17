package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzsr implements Cloneable {
    private zzsp<?, ?> zzbuq;
    private Object zzbur;
    private List<zzsw> zzbus = new ArrayList();

    zzsr() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzz()];
        writeTo(zzsn.zzE(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsr)) {
            return false;
        }
        zzsr zzsr = (zzsr) obj;
        if (this.zzbur == null || zzsr.zzbur == null) {
            if (this.zzbus != null && zzsr.zzbus != null) {
                return this.zzbus.equals(zzsr.zzbus);
            }
            try {
                return Arrays.equals(toByteArray(), zzsr.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzbuq == zzsr.zzbuq) {
            return !this.zzbuq.zzbuk.isArray() ? this.zzbur.equals(zzsr.zzbur) : this.zzbur instanceof byte[] ? Arrays.equals((byte[]) this.zzbur, (byte[]) zzsr.zzbur) : this.zzbur instanceof int[] ? Arrays.equals((int[]) this.zzbur, (int[]) zzsr.zzbur) : this.zzbur instanceof long[] ? Arrays.equals((long[]) this.zzbur, (long[]) zzsr.zzbur) : this.zzbur instanceof float[] ? Arrays.equals((float[]) this.zzbur, (float[]) zzsr.zzbur) : this.zzbur instanceof double[] ? Arrays.equals((double[]) this.zzbur, (double[]) zzsr.zzbur) : this.zzbur instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbur, (boolean[]) zzsr.zzbur) : Arrays.deepEquals((Object[]) this.zzbur, (Object[]) zzsr.zzbur);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeTo(zzsn zzsn) throws IOException {
        if (this.zzbur != null) {
            this.zzbuq.zza(this.zzbur, zzsn);
            return;
        }
        for (zzsw writeTo : this.zzbus) {
            writeTo.writeTo(zzsn);
        }
    }

    /* renamed from: zzJr */
    public final zzsr clone() {
        zzsr zzsr = new zzsr();
        try {
            zzsr.zzbuq = this.zzbuq;
            if (this.zzbus == null) {
                zzsr.zzbus = null;
            } else {
                zzsr.zzbus.addAll(this.zzbus);
            }
            if (this.zzbur != null) {
                if (this.zzbur instanceof zzsu) {
                    zzsr.zzbur = ((zzsu) this.zzbur).clone();
                } else if (this.zzbur instanceof byte[]) {
                    zzsr.zzbur = ((byte[]) this.zzbur).clone();
                } else if (this.zzbur instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbur;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzsr.zzbur = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.zzbur instanceof boolean[]) {
                    zzsr.zzbur = ((boolean[]) this.zzbur).clone();
                } else if (this.zzbur instanceof int[]) {
                    zzsr.zzbur = ((int[]) this.zzbur).clone();
                } else if (this.zzbur instanceof long[]) {
                    zzsr.zzbur = ((long[]) this.zzbur).clone();
                } else if (this.zzbur instanceof float[]) {
                    zzsr.zzbur = ((float[]) this.zzbur).clone();
                } else if (this.zzbur instanceof double[]) {
                    zzsr.zzbur = ((double[]) this.zzbur).clone();
                } else if (this.zzbur instanceof zzsu[]) {
                    zzsu[] zzsuArr = (zzsu[]) this.zzbur;
                    zzsu[] zzsuArr2 = new zzsu[zzsuArr.length];
                    zzsr.zzbur = zzsuArr2;
                    for (int i2 = 0; i2 < zzsuArr.length; i2++) {
                        zzsuArr2[i2] = zzsuArr[i2].clone();
                    }
                }
            }
            return zzsr;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzsw zzsw) {
        this.zzbus.add(zzsw);
    }

    /* access modifiers changed from: package-private */
    public <T> T zzb(zzsp<?, T> zzsp) {
        if (this.zzbur == null) {
            this.zzbuq = zzsp;
            this.zzbur = zzsp.zzJ(this.zzbus);
            this.zzbus = null;
        } else if (this.zzbuq != zzsp) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.zzbur;
    }

    /* access modifiers changed from: package-private */
    public int zzz() {
        if (this.zzbur != null) {
            return this.zzbuq.zzY(this.zzbur);
        }
        int i = 0;
        for (zzsw zzz : this.zzbus) {
            i += zzz.zzz();
        }
        return i;
    }
}
