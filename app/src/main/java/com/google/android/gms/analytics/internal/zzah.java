package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.zzx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

class zzah extends zzd {
    /* access modifiers changed from: private */
    public static final byte[] zzTd = "\n".getBytes();
    private final zzaj zzTc;
    private final String zzzN = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);

    private class zza {
        private int zzTe;
        private ByteArrayOutputStream zzTf = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzTf.toByteArray();
        }

        public boolean zzj(zzab zzab) {
            zzx.zzz(zzab);
            if (this.zzTe + 1 > zzah.this.zzjn().zzkD()) {
                return false;
            }
            String zza = zzah.this.zza(zzab, false);
            if (zza == null) {
                zzah.this.zzjm().zza(zzab, "Error formatting hit");
                return true;
            }
            byte[] bytes = zza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzjn().zzkv()) {
                zzah.this.zzjm().zza(zzab, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzTf.size() > 0) {
                length++;
            }
            if (length + this.zzTf.size() > zzah.this.zzjn().zzkx()) {
                return false;
            }
            try {
                if (this.zzTf.size() > 0) {
                    this.zzTf.write(zzah.zzTd);
                }
                this.zzTf.write(bytes);
                this.zzTe++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzlE() {
            return this.zzTe;
        }
    }

    zzah(zzf zzf) {
        super(zzf);
        this.zzTc = new zzaj(zzf.zzjl());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[SYNTHETIC, Splitter:B:28:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[SYNTHETIC, Splitter:B:37:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zza(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            r0 = 0
            com.google.android.gms.common.internal.zzx.zzz(r6)
            com.google.android.gms.common.internal.zzx.zzz(r7)
            java.lang.String r1 = "POST bytes, url"
            int r2 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5.zzb(r1, r2, r6)
            boolean r1 = r5.zzhp()
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = "Post payload\n"
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            r5.zza(r1, r2)
        L_0x0021:
            java.net.HttpURLConnection r2 = r5.zzc(r6)     // Catch:{ IOException -> 0x0064, all -> 0x007f }
            r1 = 1
            r2.setDoOutput(r1)     // Catch:{ IOException -> 0x0094, all -> 0x009a }
            int r1 = r7.length     // Catch:{ IOException -> 0x0094, all -> 0x009a }
            r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0094, all -> 0x009a }
            r2.connect()     // Catch:{ IOException -> 0x0094, all -> 0x009a }
            java.io.OutputStream r1 = r2.getOutputStream()     // Catch:{ IOException -> 0x0094, all -> 0x009a }
            r1.write(r7)     // Catch:{ IOException -> 0x0097 }
            r5.zzb((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0097 }
            int r0 = r2.getResponseCode()     // Catch:{ IOException -> 0x0097 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x0049
            com.google.android.gms.analytics.internal.zzb r3 = r5.zziH()     // Catch:{ IOException -> 0x0097 }
            r3.zzjh()     // Catch:{ IOException -> 0x0097 }
        L_0x0049:
            java.lang.String r3 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x0097 }
            r5.zzb(r3, r4)     // Catch:{ IOException -> 0x0097 }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x005d }
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
        L_0x005c:
            return r0
        L_0x005d:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L_0x0057
        L_0x0064:
            r3 = move-exception
            r1 = r0
            r2 = r0
        L_0x0067:
            java.lang.String r0 = "Network POST connection error"
            r5.zzd(r0, r3)     // Catch:{ all -> 0x009e }
            r0 = 0
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0072:
            if (r2 == 0) goto L_0x005c
            r2.disconnect()
            goto L_0x005c
        L_0x0078:
            r1 = move-exception
            java.lang.String r3 = "Error closing http post connection output stream"
            r5.zze(r3, r1)
            goto L_0x0072
        L_0x007f:
            r3 = move-exception
            r2 = r0
            r4 = r0
        L_0x0082:
            if (r4 == 0) goto L_0x0087
            r4.close()     // Catch:{ IOException -> 0x008d }
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            r2.disconnect()
        L_0x008c:
            throw r3
        L_0x008d:
            r0 = move-exception
            java.lang.String r1 = "Error closing http post connection output stream"
            r5.zze(r1, r0)
            goto L_0x0087
        L_0x0094:
            r3 = move-exception
        L_0x0095:
            r1 = r0
            goto L_0x0067
        L_0x0097:
            r3 = move-exception
            r0 = r1
            goto L_0x0095
        L_0x009a:
            r1 = move-exception
            r3 = r1
            r4 = r0
            goto L_0x0082
        L_0x009e:
            r0 = move-exception
            r3 = r0
            r4 = r1
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zza(java.net.URL, byte[]):int");
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int i;
        HttpURLConnection httpURLConnection = null;
        zzx.zzz(url);
        zzb("GET request", url);
        try {
            HttpURLConnection zzc = zzc(url);
            zzc.connect();
            zzb(zzc);
            i = zzc.getResponseCode();
            if (i == 200) {
                zziH().zzjh();
            }
            zzb("GET status", Integer.valueOf(i));
            if (zzc != null) {
                zzc.disconnect();
            }
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            i = 0;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3 A[SYNTHETIC, Splitter:B:29:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8 A[SYNTHETIC, Splitter:B:38:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int zzb(java.net.URL r9, byte[] r10) {
        /*
            r8 = this;
            r2 = 0
            com.google.android.gms.common.internal.zzx.zzz(r9)
            com.google.android.gms.common.internal.zzx.zzz(r10)
            byte[] r0 = zzg((byte[]) r10)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.String r1 = "POST compressed size, ratio %, url"
            int r3 = r0.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r4 = 100
            int r6 = r0.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            long r4 = r4 * r6
            int r6 = r10.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r8.zza(r1, r3, r4, r9)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            int r1 = r0.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            int r3 = r10.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            if (r1 <= r3) goto L_0x0034
            java.lang.String r1 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r3 = r0.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            int r4 = r10.length     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r8.zzc(r1, r3, r4)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
        L_0x0034:
            boolean r1 = r8.zzhp()     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            if (r1 == 0) goto L_0x0057
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r1.<init>()     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.String r3 = "\n"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r3.<init>(r10)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.String r4 = "Post payload"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r8.zza(r4, r1)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
        L_0x0057:
            java.net.HttpURLConnection r3 = r8.zzc(r9)     // Catch:{ IOException -> 0x0098, all -> 0x00b3 }
            r1 = 1
            r3.setDoOutput(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r1, r4)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r1 = r0.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r3.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r3.connect()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.io.OutputStream r1 = r3.getOutputStream()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r1.write(r0)     // Catch:{ IOException -> 0x00ce, all -> 0x00d2 }
            r1.close()     // Catch:{ IOException -> 0x00ce, all -> 0x00d2 }
            r8.zzb((java.net.HttpURLConnection) r3)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x0089
            com.google.android.gms.analytics.internal.zzb r1 = r8.zziH()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r1.zzjh()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
        L_0x0089:
            java.lang.String r1 = "POST status"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r8.zzb(r1, r4)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            if (r3 == 0) goto L_0x0097
            r3.disconnect()
        L_0x0097:
            return r0
        L_0x0098:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x009b:
            java.lang.String r2 = "Network compressed POST connection error"
            r8.zzd(r2, r0)     // Catch:{ all -> 0x00d0 }
            r0 = 0
            if (r1 == 0) goto L_0x00a6
            r1.close()     // Catch:{ IOException -> 0x00ac }
        L_0x00a6:
            if (r3 == 0) goto L_0x0097
            r3.disconnect()
            goto L_0x0097
        L_0x00ac:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.zze(r2, r1)
            goto L_0x00a6
        L_0x00b3:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ IOException -> 0x00c1 }
        L_0x00bb:
            if (r3 == 0) goto L_0x00c0
            r3.disconnect()
        L_0x00c0:
            throw r0
        L_0x00c1:
            r1 = move-exception
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            r8.zze(r2, r1)
            goto L_0x00bb
        L_0x00c8:
            r0 = move-exception
            r1 = r2
            goto L_0x00b6
        L_0x00cb:
            r0 = move-exception
            r1 = r2
            goto L_0x009b
        L_0x00ce:
            r0 = move-exception
            goto L_0x009b
        L_0x00d0:
            r0 = move-exception
            goto L_0x00b6
        L_0x00d2:
            r0 = move-exception
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.zzb(java.net.URL, byte[]):int");
    }

    private URL zzb(zzab zzab, String str) {
        try {
            return new URL(zzab.zzlt() ? zzjn().zzkF() + zzjn().zzkH() + "?" + str : zzjn().zzkG() + zzjn().zzkH() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean zzg(zzab zzab) {
        zzx.zzz(zzab);
        String zza2 = zza(zzab, !zzab.zzlt());
        if (zza2 == null) {
            zzjm().zza(zzab, "Error formatting hit for upload");
            return true;
        } else if (zza2.length() <= zzjn().zzku()) {
            URL zzb = zzb(zzab, zza2);
            if (zzb != null) {
                return zzb(zzb) == 200;
            }
            zzbh("Failed to build collect GET endpoint url");
            return false;
        } else {
            String zza3 = zza(zzab, false);
            if (zza3 == null) {
                zzjm().zza(zzab, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = zza3.getBytes();
            if (bytes.length > zzjn().zzkw()) {
                zzjm().zza(zzab, "Hit payload exceeds size limit");
                return true;
            }
            URL zzh = zzh(zzab);
            if (zzh != null) {
                return zza(zzh, bytes) == 200;
            }
            zzbh("Failed to build collect POST endpoint url");
            return false;
        }
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzab) {
        try {
            return new URL(zzab.zzlt() ? zzjn().zzkF() + zzjn().zzkH() : zzjn().zzkG() + zzjn().zzkH());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzab) {
        return String.valueOf(zzab.zzlq());
    }

    private URL zzlC() {
        try {
            return new URL(zzjn().zzkF() + zzjn().zzkI());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String zza(zzab zzab, boolean z) {
        zzx.zzz(zzab);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : zzab.zzn().entrySet()) {
                String str = (String) next.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zza(sb, str, (String) next.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzab.zzlr()));
            zza(sb, "qt", String.valueOf(zzjl().currentTimeMillis() - zzab.zzlr()));
            if (zzjn().zzkr()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzlu = zzab.zzlu();
                zza(sb, "z", zzlu != 0 ? String.valueOf(zzlu) : zzi(zzab));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public List<Long> zza(List<zzab> list, boolean z) {
        zzx.zzac(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zza2 = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab next : list) {
            if (!zza2.zzj(next)) {
                break;
            }
            arrayList.add(Long.valueOf(next.zzlq()));
        }
        if (zza2.zzlE() == 0) {
            return arrayList;
        }
        URL zzlC = zzlC();
        if (zzlC == null) {
            zzbh("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int zzb = z ? zzb(zzlC, zza2.getPayload()) : zza(zzlC, zza2.getPayload());
        if (200 == zzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zza2.zzlE()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(zzb));
        if (zzjn().zzkL().contains(Integer.valueOf(zzb))) {
            zzbg("Server instructed the client to stop batching");
            this.zzTc.start();
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzjn().zzkU());
        httpURLConnection.setReadTimeout(zzjn().zzkV());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzzN);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public void zziJ() {
        zza("Network initialized. User agent", this.zzzN);
    }

    public boolean zzlB() {
        NetworkInfo networkInfo;
        zzjk();
        zzjv();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzbd("No network connectivity");
        return false;
    }

    public List<Long> zzq(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzjk();
        zzjv();
        zzx.zzz(list);
        if (zzjn().zzkL().isEmpty() || !this.zzTc.zzv(zzjn().zzkE() * 1000)) {
            z = false;
            z2 = false;
        } else {
            z = zzjn().zzkJ() != zzm.zzRk;
            if (zzjn().zzkK() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza(list, z2) : zzr(list);
    }

    /* access modifiers changed from: package-private */
    public List<Long> zzr(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab next : list) {
            if (zzg(next)) {
                arrayList.add(Long.valueOf(next.zzlq()));
                if (arrayList.size() >= zzjn().zzkC()) {
                    break;
                }
            } else {
                break;
            }
        }
        return arrayList;
    }
}
