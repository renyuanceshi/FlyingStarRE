package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class zzq extends zzz {

    @WorkerThread
    interface zza {
        void zza(String str, int i, Throwable th, byte[] bArr);
    }

    @WorkerThread
    private static class zzb implements Runnable {
        private final int zzBc;
        private final String zzTJ;
        private final zza zzaWP;
        private final Throwable zzaWQ;
        private final byte[] zzaWR;

        private zzb(String str, zza zza, int i, Throwable th, byte[] bArr) {
            zzx.zzz(zza);
            this.zzaWP = zza;
            this.zzBc = i;
            this.zzaWQ = th;
            this.zzaWR = bArr;
            this.zzTJ = str;
        }

        public void run() {
            this.zzaWP.zza(this.zzTJ, this.zzBc, this.zzaWQ, this.zzaWR);
        }
    }

    @WorkerThread
    private class zzc implements Runnable {
        private final String zzTJ;
        private final byte[] zzaWS;
        private final zza zzaWT;
        private final Map<String, String> zzaWU;
        private final URL zzzq;

        public zzc(String str, URL url, byte[] bArr, Map<String, String> map, zza zza) {
            zzx.zzcM(str);
            zzx.zzz(url);
            zzx.zzz(zza);
            this.zzzq = url;
            this.zzaWS = bArr;
            this.zzaWT = zza;
            this.zzTJ = str;
            this.zzaWU = map;
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7 A[SYNTHETIC, Splitter:B:34:0x00d7] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00dc  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r12 = this;
                r3 = 0
                r4 = 0
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this
                r0.zzCd()
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this     // Catch:{ IOException -> 0x010c, all -> 0x00d1 }
                java.net.URL r1 = r12.zzzq     // Catch:{ IOException -> 0x010c, all -> 0x00d1 }
                java.net.HttpURLConnection r2 = r0.zzc((java.net.URL) r1)     // Catch:{ IOException -> 0x010c, all -> 0x00d1 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r12.zzaWU     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                if (r0 == 0) goto L_0x005c
                java.util.Map<java.lang.String, java.lang.String> r0 = r12.zzaWU     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.util.Iterator r5 = r0.iterator()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
            L_0x001d:
                boolean r0 = r5.hasNext()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                if (r0 == 0) goto L_0x005c
                java.lang.Object r0 = r5.next()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.Object r1 = r0.getKey()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.Object r0 = r0.getValue()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r2.addRequestProperty(r1, r0)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                goto L_0x001d
            L_0x0039:
                r0 = move-exception
                r1 = r4
                r9 = r0
                r8 = r3
            L_0x003d:
                if (r1 == 0) goto L_0x0042
                r1.close()     // Catch:{ IOException -> 0x00bf }
            L_0x0042:
                if (r2 == 0) goto L_0x0047
                r2.disconnect()
            L_0x0047:
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this
                com.google.android.gms.measurement.internal.zzv r0 = r0.zzCn()
                com.google.android.gms.measurement.internal.zzq$zzb r5 = new com.google.android.gms.measurement.internal.zzq$zzb
                java.lang.String r6 = r12.zzTJ
                com.google.android.gms.measurement.internal.zzq$zza r7 = r12.zzaWT
                r10 = r4
                r11 = r4
                r5.<init>(r6, r7, r8, r9, r10)
                r0.zzg(r5)
            L_0x005b:
                return
            L_0x005c:
                byte[] r0 = r12.zzaWS     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                if (r0 == 0) goto L_0x009c
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                com.google.android.gms.measurement.internal.zzaj r0 = r0.zzCk()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                byte[] r1 = r12.zzaWS     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                byte[] r0 = r0.zzg(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                com.google.android.gms.measurement.internal.zzq r1 = com.google.android.gms.measurement.internal.zzq.this     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                com.google.android.gms.measurement.internal.zzp r1 = r1.zzAo()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzCK()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.String r5 = "Uploading data. size"
                int r6 = r0.length     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r1.zzj(r5, r6)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r1 = 1
                r2.setDoOutput(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.lang.String r1 = "Content-Encoding"
                java.lang.String r5 = "gzip"
                r2.addRequestProperty(r1, r5)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                int r1 = r0.length     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r2.connect()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                r1.write(r0)     // Catch:{ IOException -> 0x0113, all -> 0x0109 }
                r1.close()     // Catch:{ IOException -> 0x0113, all -> 0x0109 }
            L_0x009c:
                int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                byte[] r5 = r0.zzc((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0039, all -> 0x0105 }
                if (r2 == 0) goto L_0x00ab
                r2.disconnect()
            L_0x00ab:
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this
                com.google.android.gms.measurement.internal.zzv r7 = r0.zzCn()
                com.google.android.gms.measurement.internal.zzq$zzb r0 = new com.google.android.gms.measurement.internal.zzq$zzb
                java.lang.String r1 = r12.zzTJ
                com.google.android.gms.measurement.internal.zzq$zza r2 = r12.zzaWT
                r6 = r4
                r0.<init>(r1, r2, r3, r4, r5)
                r7.zzg(r0)
                goto L_0x005b
            L_0x00bf:
                r0 = move-exception
                com.google.android.gms.measurement.internal.zzq r1 = com.google.android.gms.measurement.internal.zzq.this
                com.google.android.gms.measurement.internal.zzp r1 = r1.zzAo()
                com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzCE()
                java.lang.String r3 = "Error closing HTTP compressed POST connection output stream"
                r1.zzj(r3, r0)
                goto L_0x0042
            L_0x00d1:
                r0 = move-exception
                r1 = r4
                r2 = r4
                r7 = r0
            L_0x00d5:
                if (r1 == 0) goto L_0x00da
                r1.close()     // Catch:{ IOException -> 0x00f4 }
            L_0x00da:
                if (r2 == 0) goto L_0x00df
                r2.disconnect()
            L_0x00df:
                com.google.android.gms.measurement.internal.zzq r0 = com.google.android.gms.measurement.internal.zzq.this
                com.google.android.gms.measurement.internal.zzv r8 = r0.zzCn()
                com.google.android.gms.measurement.internal.zzq$zzb r0 = new com.google.android.gms.measurement.internal.zzq$zzb
                java.lang.String r1 = r12.zzTJ
                com.google.android.gms.measurement.internal.zzq$zza r2 = r12.zzaWT
                r5 = r4
                r6 = r4
                r0.<init>(r1, r2, r3, r4, r5)
                r8.zzg(r0)
                throw r7
            L_0x00f4:
                r0 = move-exception
                com.google.android.gms.measurement.internal.zzq r1 = com.google.android.gms.measurement.internal.zzq.this
                com.google.android.gms.measurement.internal.zzp r1 = r1.zzAo()
                com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzCE()
                java.lang.String r5 = "Error closing HTTP compressed POST connection output stream"
                r1.zzj(r5, r0)
                goto L_0x00da
            L_0x0105:
                r0 = move-exception
                r1 = r4
                r7 = r0
                goto L_0x00d5
            L_0x0109:
                r0 = move-exception
                r7 = r0
                goto L_0x00d5
            L_0x010c:
                r0 = move-exception
                r1 = r4
                r9 = r0
                r8 = r3
                r2 = r4
                goto L_0x003d
            L_0x0113:
                r0 = move-exception
                r9 = r0
                r8 = r3
                goto L_0x003d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzq.zzc.run():void");
        }
    }

    public zzq(zzw zzw) {
        super(zzw);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @WorkerThread
    public void zza(String str, URL url, Map<String, String> map, zza zza2) {
        zzjk();
        zzjv();
        zzx.zzz(url);
        zzx.zzz(zza2);
        zzCn().zzh(new zzc(str, url, (byte[]) null, map, zza2));
    }

    @WorkerThread
    public void zza(String str, URL url, byte[] bArr, Map<String, String> map, zza zza2) {
        zzjk();
        zzjv();
        zzx.zzz(url);
        zzx.zzz(bArr);
        zzx.zzz(zza2);
        zzCn().zzh(new zzc(str, url, bArr, map, zza2));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout((int) zzCp().zzBO());
        httpURLConnection.setReadTimeout((int) zzCp().zzBP());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public void zziJ() {
    }

    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }

    public boolean zzlB() {
        NetworkInfo networkInfo;
        zzjv();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }
}
