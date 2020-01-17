package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzp extends InputStream {
    private final InputStream zzbsj;
    private volatile zzm zzbsk;

    public zzp(InputStream inputStream) {
        this.zzbsj = (InputStream) zzx.zzz(inputStream);
    }

    private int zzlK(int i) throws ChannelIOException {
        zzm zzm;
        if (i != -1 || (zzm = this.zzbsk) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzm.zzbsa, zzm.zzbsb);
    }

    public int available() throws IOException {
        return this.zzbsj.available();
    }

    public void close() throws IOException {
        this.zzbsj.close();
    }

    public void mark(int i) {
        this.zzbsj.mark(i);
    }

    public boolean markSupported() {
        return this.zzbsj.markSupported();
    }

    public int read() throws IOException {
        return zzlK(this.zzbsj.read());
    }

    public int read(byte[] bArr) throws IOException {
        return zzlK(this.zzbsj.read(bArr));
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return zzlK(this.zzbsj.read(bArr, i, i2));
    }

    public void reset() throws IOException {
        this.zzbsj.reset();
    }

    public long skip(long j) throws IOException {
        return this.zzbsj.skip(j);
    }

    /* access modifiers changed from: package-private */
    public zzu zzIJ() {
        return new zzu() {
            public void zzb(zzm zzm) {
                zzp.this.zza(zzm);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void zza(zzm zzm) {
        this.zzbsk = (zzm) zzx.zzz(zzm);
    }
}
