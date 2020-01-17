package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzhb
public class zzdu extends zzdr {
    private static final Set<String> zzzX = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzzY = new DecimalFormat("#,###");
    private boolean zzAa;
    private File zzzZ;

    public zzdu(zzjp zzjp) {
        super(zzjp);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzin.zzaK("Context.getCacheDir() returned null");
            return;
        }
        this.zzzZ = new File(cacheDir, "admobVideoStreams");
        if (!this.zzzZ.isDirectory() && !this.zzzZ.mkdirs()) {
            zzin.zzaK("Could not create preload cache directory at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        } else if (!this.zzzZ.setReadable(true, false) || !this.zzzZ.setExecutable(true, false)) {
            zzin.zzaK("Could not set cache file permissions at " + this.zzzZ.getAbsolutePath());
            this.zzzZ = null;
        }
    }

    private File zza(File file) {
        return new File(this.zzzZ, file.getName() + ".done");
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void abort() {
        this.zzAa = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0331, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0332, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0333, code lost:
        r3 = r8;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x033c, code lost:
        if (r0.tryAcquire() == false) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x033e, code lost:
        zza(r25, r9.getAbsolutePath(), r5, r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x034c, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x034d, code lost:
        r2 = "error";
        r3 = r8;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x035c, code lost:
        if (com.google.android.gms.internal.zzin.zzQ(3) == false) goto L_0x0387;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x035e, code lost:
        com.google.android.gms.internal.zzin.zzaI("Preloaded " + zzzY.format((long) r5) + " bytes from " + r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0387, code lost:
        r9.setReadable(true, false);
        zzb(r10);
        zza(r25, r9.getAbsolutePath(), r5);
        zzzX.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x039f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x03a2, code lost:
        com.google.android.gms.internal.zzin.zzd("Preload failed for URL \"" + r25 + "\"", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03c2, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c3, code lost:
        r5 = null;
        r2 = "error";
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x03c9, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03ca, code lost:
        r5 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03ce, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03cf, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03d2, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03d3, code lost:
        r2 = "error";
        r3 = r8;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03da, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03db, code lost:
        r3 = r8;
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03e0, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03e1, code lost:
        r5 = null;
        r2 = "error";
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03e7, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03e8, code lost:
        r5 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3 = new java.net.URL(r25).openConnection();
        r2 = com.google.android.gms.internal.zzbt.zzvT.get().intValue();
        r3.setConnectTimeout(r2);
        r3.setReadTimeout(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ff, code lost:
        if ((r3 instanceof java.net.HttpURLConnection) == false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0101, code lost:
        r6 = ((java.net.HttpURLConnection) r3).getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010b, code lost:
        if (r6 < 400) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x010d, code lost:
        r2 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r5 = "HTTP request failed. Code: " + java.lang.Integer.toString(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x014a, code lost:
        throw new java.io.IOException("HTTP status code " + r6 + " at " + r25);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014b, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014c, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014f, code lost:
        if ((r6 instanceof java.lang.RuntimeException) != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0151, code lost:
        com.google.android.gms.ads.internal.zzr.zzbF().zzb(r6, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0160, code lost:
        if (r24.zzAa == false) goto L_0x03a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0162, code lost:
        com.google.android.gms.internal.zzin.zzaJ("Preload aborted for URL \"" + r25 + "\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x018c, code lost:
        com.google.android.gms.internal.zzin.zzaK("Could not delete partial cache file at " + r9.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a6, code lost:
        zza(r25, r9.getAbsolutePath(), r2, r5);
        zzzX.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r6 = r3.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01bd, code lost:
        if (r6 >= 0) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bf, code lost:
        com.google.android.gms.internal.zzin.zzaK("Stream cache aborted, missing content-length header at " + r25);
        zza(r25, r9.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zzzX.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01ed, code lost:
        r5 = zzzY.format((long) r6);
        r12 = com.google.android.gms.internal.zzbt.zzvP.get().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0200, code lost:
        if (r6 <= r12) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0202, code lost:
        com.google.android.gms.internal.zzin.zzaK("Content length " + r5 + " exceeds limit at " + r25);
        zza(r25, r9.getAbsolutePath(), "sizeExceeded", "File too big for full file cache. Size: " + r5);
        zzzX.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x024c, code lost:
        com.google.android.gms.internal.zzin.zzaI("Caching " + r5 + " bytes from " + r25);
        r13 = java.nio.channels.Channels.newChannel(r3.getInputStream());
        r8 = new java.io.FileOutputStream(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r14 = r8.getChannel();
        r15 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzr.zzbG();
        r5 = 0;
        r18 = r16.currentTimeMillis();
        r0 = new com.google.android.gms.internal.zziz(com.google.android.gms.internal.zzbt.zzvS.get().longValue());
        r20 = com.google.android.gms.internal.zzbt.zzvR.get().longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x02ad, code lost:
        r2 = r13.read(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x02b1, code lost:
        if (r2 < 0) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x02b3, code lost:
        r5 = r5 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02b4, code lost:
        if (r5 <= r12) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02b6, code lost:
        r2 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r4 = "File too big for full file cache. Size: " + java.lang.Integer.toString(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02d6, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02d7, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02d8, code lost:
        r3 = r8;
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r15.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02e3, code lost:
        if (r14.write(r15) > 0) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02e5, code lost:
        r15.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02f4, code lost:
        if ((r16.currentTimeMillis() - r18) <= (1000 * r20)) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02f6, code lost:
        r2 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r4 = "Timeout exceeded. Limit: " + java.lang.Long.toString(r20) + " sec";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x031c, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x031d, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x031e, code lost:
        r3 = r8;
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0326, code lost:
        if (r24.zzAa == false) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0328, code lost:
        r2 = "externalAbort";
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzU(java.lang.String r25) {
        /*
            r24 = this;
            r0 = r24
            java.io.File r2 = r0.zzzZ
            if (r2 != 0) goto L_0x0013
            r2 = 0
            java.lang.String r3 = "noCacheDir"
            r4 = 0
            r0 = r24
            r1 = r25
            r0.zza(r1, r2, r3, r4)
            r2 = 0
        L_0x0012:
            return r2
        L_0x0013:
            int r3 = r24.zzea()
            com.google.android.gms.internal.zzbp<java.lang.Integer> r2 = com.google.android.gms.internal.zzbt.zzvO
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r3 <= r2) goto L_0x003d
            boolean r2 = r24.zzeb()
            if (r2 != 0) goto L_0x0013
            java.lang.String r2 = "Unable to expire stream cache"
            com.google.android.gms.internal.zzin.zzaK(r2)
            r2 = 0
            java.lang.String r3 = "expireFailed"
            r4 = 0
            r0 = r24
            r1 = r25
            r0.zza(r1, r2, r3, r4)
            r2 = 0
            goto L_0x0012
        L_0x003d:
            java.lang.String r2 = r24.zzV(r25)
            java.io.File r9 = new java.io.File
            r0 = r24
            java.io.File r3 = r0.zzzZ
            r9.<init>(r3, r2)
            r0 = r24
            java.io.File r10 = r0.zza(r9)
            boolean r2 = r9.isFile()
            if (r2 == 0) goto L_0x0086
            boolean r2 = r10.isFile()
            if (r2 == 0) goto L_0x0086
            long r2 = r9.length()
            int r2 = (int) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Stream cache hit at "
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r25
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.zzin.zzaI(r3)
            java.lang.String r3 = r9.getAbsolutePath()
            r0 = r24
            r1 = r25
            r0.zza((java.lang.String) r1, (java.lang.String) r3, (int) r2)
            r2 = 1
            goto L_0x0012
        L_0x0086:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r0 = r24
            java.io.File r3 = r0.zzzZ
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r11 = r2.toString()
            java.util.Set<java.lang.String> r3 = zzzX
            monitor-enter(r3)
            java.util.Set<java.lang.String> r2 = zzzX     // Catch:{ all -> 0x00d6 }
            boolean r2 = r2.contains(r11)     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x00d9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r2.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r4 = "Stream cache already in progress at "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x00d6 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d6 }
            com.google.android.gms.internal.zzin.zzaK(r2)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ all -> 0x00d6 }
            java.lang.String r4 = "inProgress"
            r5 = 0
            r0 = r24
            r1 = r25
            r0.zza(r1, r2, r4, r5)     // Catch:{ all -> 0x00d6 }
            r2 = 0
            monitor-exit(r3)     // Catch:{ all -> 0x00d6 }
            goto L_0x0012
        L_0x00d6:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d6 }
            throw r2
        L_0x00d9:
            java.util.Set<java.lang.String> r2 = zzzX     // Catch:{ all -> 0x00d6 }
            r2.add(r11)     // Catch:{ all -> 0x00d6 }
            monitor-exit(r3)     // Catch:{ all -> 0x00d6 }
            r4 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r0 = r25
            r2.<init>(r0)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            com.google.android.gms.internal.zzbp<java.lang.Integer> r2 = com.google.android.gms.internal.zzbt.zzvT     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            int r2 = r2.intValue()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r3.setConnectTimeout(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            boolean r2 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            if (r2 == 0) goto L_0x01b9
            r0 = r3
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2 = r0
            int r6 = r2.getResponseCode()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2 = 400(0x190, float:5.6E-43)
            if (r6 < r2) goto L_0x01b9
            java.lang.String r2 = "badUrl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            r3.<init>()     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            java.lang.String r5 = "HTTP request failed. Code: "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            java.lang.String r5 = java.lang.Integer.toString(r6)     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            java.lang.String r5 = r3.toString()     // Catch:{ IOException -> 0x03e7, RuntimeException -> 0x03c9 }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            r7.<init>()     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            java.lang.String r8 = "HTTP status code "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            java.lang.StringBuilder r6 = r7.append(r6)     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            java.lang.String r7 = " at "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            r0 = r25
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            r3.<init>(r6)     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
            throw r3     // Catch:{ IOException -> 0x014b, RuntimeException -> 0x03ce }
        L_0x014b:
            r6 = move-exception
            r3 = r4
        L_0x014d:
            boolean r4 = r6 instanceof java.lang.RuntimeException
            if (r4 == 0) goto L_0x0159
            com.google.android.gms.internal.zzih r4 = com.google.android.gms.ads.internal.zzr.zzbF()
            r7 = 1
            r4.zzb((java.lang.Throwable) r6, (boolean) r7)
        L_0x0159:
            r3.close()     // Catch:{ IOException -> 0x03ec, NullPointerException -> 0x03ef }
        L_0x015c:
            r0 = r24
            boolean r3 = r0.zzAa
            if (r3 == 0) goto L_0x03a2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Preload aborted for URL \""
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r25
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.zzin.zzaJ(r3)
        L_0x0180:
            boolean r3 = r9.exists()
            if (r3 == 0) goto L_0x01a6
            boolean r3 = r9.delete()
            if (r3 != 0) goto L_0x01a6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not delete partial cache file at "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r9.getAbsolutePath()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.zzin.zzaK(r3)
        L_0x01a6:
            java.lang.String r3 = r9.getAbsolutePath()
            r0 = r24
            r1 = r25
            r0.zza(r1, r3, r2, r5)
            java.util.Set<java.lang.String> r2 = zzzX
            r2.remove(r11)
            r2 = 0
            goto L_0x0012
        L_0x01b9:
            int r6 = r3.getContentLength()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            if (r6 >= 0) goto L_0x01ed
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.<init>()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = "Stream cache aborted, missing content-length header at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            com.google.android.gms.internal.zzin.zzaK(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = "contentLengthMissing"
            r5 = 0
            r0 = r24
            r1 = r25
            r0.zza(r1, r2, r3, r5)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.util.Set<java.lang.String> r2 = zzzX     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.remove(r11)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2 = 0
            goto L_0x0012
        L_0x01ed:
            java.text.DecimalFormat r2 = zzzY     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            long r12 = (long) r6     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r5 = r2.format(r12)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            com.google.android.gms.internal.zzbp<java.lang.Integer> r2 = com.google.android.gms.internal.zzbt.zzvP     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            int r12 = r2.intValue()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            if (r6 <= r12) goto L_0x024c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.<init>()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = "Content length "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = " exceeds limit at "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            com.google.android.gms.internal.zzin.zzaK(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.<init>()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = "File too big for full file cache. Size: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r3 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r5 = "sizeExceeded"
            r0 = r24
            r1 = r25
            r0.zza(r1, r3, r5, r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.util.Set<java.lang.String> r2 = zzzX     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.remove(r11)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2 = 0
            goto L_0x0012
        L_0x024c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r2.<init>()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r7 = "Caching "
            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r5 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            com.google.android.gms.internal.zzin.zzaI(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.nio.channels.ReadableByteChannel r13 = java.nio.channels.Channels.newChannel(r2)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x03e0, RuntimeException -> 0x03c2 }
            java.nio.channels.FileChannel r14 = r8.getChannel()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            com.google.android.gms.internal.zzmq r16 = com.google.android.gms.ads.internal.zzr.zzbG()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r5 = 0
            long r18 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            com.google.android.gms.internal.zzbp<java.lang.Long> r2 = com.google.android.gms.internal.zzbt.zzvS     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            com.google.android.gms.internal.zziz r17 = new com.google.android.gms.internal.zziz     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r0 = r17
            r0.<init>(r2)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            com.google.android.gms.internal.zzbp<java.lang.Long> r2 = com.google.android.gms.internal.zzbt.zzvR     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            long r20 = r2.longValue()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
        L_0x02ad:
            int r2 = r13.read(r15)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            if (r2 < 0) goto L_0x0354
            int r5 = r5 + r2
            if (r5 <= r12) goto L_0x02dc
            java.lang.String r2 = "sizeExceeded"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            r3.<init>()     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = "File too big for full file cache. Size: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = java.lang.Integer.toString(r5)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = r3.toString()     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
            java.lang.String r5 = "stream cache file size limit exceeded"
            r3.<init>(r5)     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
            throw r3     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
        L_0x02d7:
            r6 = move-exception
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x02dc:
            r15.flip()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
        L_0x02df:
            int r2 = r14.write(r15)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            if (r2 > 0) goto L_0x02df
            r15.clear()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            long r2 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            long r2 = r2 - r18
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r20
            int r2 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x0322
            java.lang.String r2 = "downloadTimeout"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            r3.<init>()     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = "Timeout exceeded. Limit: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = java.lang.Long.toString(r20)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = " sec"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = r3.toString()     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
            java.lang.String r5 = "stream cache time limit exceeded"
            r3.<init>(r5)     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
            throw r3     // Catch:{ IOException -> 0x02d7, RuntimeException -> 0x031d }
        L_0x031d:
            r6 = move-exception
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x0322:
            r0 = r24
            boolean r2 = r0.zzAa     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            if (r2 == 0) goto L_0x0338
            java.lang.String r2 = "externalAbort"
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            java.lang.String r4 = "abort requested"
            r3.<init>(r4)     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
            throw r3     // Catch:{ IOException -> 0x0332, RuntimeException -> 0x03da }
        L_0x0332:
            r6 = move-exception
            r4 = 0
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x0338:
            boolean r2 = r17.tryAcquire()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            if (r2 == 0) goto L_0x02ad
            java.lang.String r4 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r7 = 0
            r2 = r24
            r3 = r25
            r2.zza(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            goto L_0x02ad
        L_0x034c:
            r6 = move-exception
            r4 = 0
            java.lang.String r2 = "error"
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x0354:
            r8.close()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r2 = 3
            boolean r2 = com.google.android.gms.internal.zzin.zzQ(r2)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            if (r2 == 0) goto L_0x0387
            java.text.DecimalFormat r2 = zzzY     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            long r6 = (long) r5     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.String r2 = r2.format(r6)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r3.<init>()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.String r4 = "Preloaded "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.String r3 = " bytes from "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r0 = r25
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            com.google.android.gms.internal.zzin.zzaI(r2)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
        L_0x0387:
            r2 = 1
            r3 = 0
            r9.setReadable(r2, r3)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            zzb(r10)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.lang.String r2 = r9.getAbsolutePath()     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r0 = r24
            r1 = r25
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r5)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            java.util.Set<java.lang.String> r2 = zzzX     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r2.remove(r11)     // Catch:{ IOException -> 0x034c, RuntimeException -> 0x03d2 }
            r2 = 1
            goto L_0x0012
        L_0x03a2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Preload failed for URL \""
            java.lang.StringBuilder r3 = r3.append(r4)
            r0 = r25
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r4 = "\""
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.zzin.zzd(r3, r6)
            goto L_0x0180
        L_0x03c2:
            r6 = move-exception
            r5 = 0
            java.lang.String r2 = "error"
            r3 = r4
            goto L_0x014d
        L_0x03c9:
            r6 = move-exception
            r5 = 0
            r3 = r4
            goto L_0x014d
        L_0x03ce:
            r6 = move-exception
            r3 = r4
            goto L_0x014d
        L_0x03d2:
            r6 = move-exception
            r4 = 0
            java.lang.String r2 = "error"
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x03da:
            r6 = move-exception
            r4 = 0
            r3 = r8
            r5 = r4
            goto L_0x014d
        L_0x03e0:
            r6 = move-exception
            r5 = 0
            java.lang.String r2 = "error"
            r3 = r4
            goto L_0x014d
        L_0x03e7:
            r6 = move-exception
            r5 = 0
            r3 = r4
            goto L_0x014d
        L_0x03ec:
            r3 = move-exception
            goto L_0x015c
        L_0x03ef:
            r3 = move-exception
            goto L_0x015c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdu.zzU(java.lang.String):boolean");
    }

    public int zzea() {
        if (this.zzzZ == null) {
            return 0;
        }
        int i = 0;
        for (File name : this.zzzZ.listFiles()) {
            if (!name.getName().endsWith(".done")) {
                i++;
            }
        }
        return i;
    }

    public boolean zzeb() {
        long j;
        if (this.zzzZ == null) {
            return false;
        }
        File file = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.zzzZ.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (!file2.getName().endsWith(".done")) {
                j = file2.lastModified();
                if (j < j2) {
                    i++;
                    j2 = j;
                    file = file2;
                }
            }
            j = j2;
            file2 = file;
            i++;
            j2 = j;
            file = file2;
        }
        if (file == null) {
            return false;
        }
        boolean delete = file.delete();
        File zza = zza(file);
        return zza.isFile() ? delete & zza.delete() : delete;
    }
}
