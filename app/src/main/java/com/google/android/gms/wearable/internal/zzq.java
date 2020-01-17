package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzq extends OutputStream {
    private volatile zzm zzbsk;
    private final OutputStream zzbsm;

    public zzq(OutputStream outputStream) {
        this.zzbsm = (OutputStream) zzx.zzz(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzm zzm = this.zzbsk;
        if (zzm == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzm.zzbsa, zzm.zzbsb);
    }

    public void close() throws IOException {
        try {
            this.zzbsm.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbsm.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbsm.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.zzbsm.write(bArr);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzbsm.write(bArr, i, i2);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    /* access modifiers changed from: package-private */
    public zzu zzIJ() {
        return new zzu() {
            public void zzb(zzm zzm) {
                zzq.this.zzc(zzm);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzm zzm) {
        this.zzbsk = zzm;
    }
}
