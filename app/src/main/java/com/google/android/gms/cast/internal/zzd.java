package com.google.android.gms.cast.internal;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.IOException;

public abstract class zzd {
    protected final zzl zzadu;
    private final String zzadv;
    private zzn zzadw;

    protected zzd(String str, String str2, String str3) {
        zzf.zzch(str);
        this.zzadv = str;
        this.zzadu = new zzl(str2);
        setSessionLabel(str3);
    }

    public final String getNamespace() {
        return this.zzadv;
    }

    public void setSessionLabel(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zzadu.zzcn(str);
        }
    }

    public final void zza(zzn zzn) {
        this.zzadw = zzn;
        if (this.zzadw == null) {
            zzof();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, long j, String str2) throws IOException {
        this.zzadu.zza("Sending text message: %s to: %s", str, str2);
        this.zzadw.zza(this.zzadv, str, j, str2);
    }

    public void zzb(long j, int i) {
    }

    public void zzcf(@NonNull String str) {
    }

    public void zzof() {
    }

    /* access modifiers changed from: protected */
    public final long zzog() {
        return this.zzadw.zznQ();
    }
}
