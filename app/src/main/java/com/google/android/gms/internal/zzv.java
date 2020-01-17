package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzv implements zzb {
    private final int zzaA;
    private final Map<String, zza> zzax;
    private long zzay;
    private final File zzaz;

    static class zza {
        public String key;
        public long zzaB;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map<String, String> zzg;

        private zza() {
        }

        public zza(String str, zzb.zza zza) {
            this.key = str;
            this.zzaB = (long) zza.data.length;
            this.zzb = zza.zzb;
            this.zzc = zza.zzc;
            this.zzd = zza.zzd;
            this.zze = zza.zze;
            this.zzf = zza.zzf;
            this.zzg = zza.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zza.key = zzv.zzd(inputStream);
            zza.zzb = zzv.zzd(inputStream);
            if (zza.zzb.equals("")) {
                zza.zzb = null;
            }
            zza.zzc = zzv.zzc(inputStream);
            zza.zzd = zzv.zzc(inputStream);
            zza.zze = zzv.zzc(inputStream);
            zza.zzf = zzv.zzc(inputStream);
            zza.zzg = zzv.zze(inputStream);
            return zza;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.key);
                zzv.zza(outputStream, this.zzb == null ? "" : this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(outputStream, this.zzf);
                zzv.zza(this.zzg, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zza = new zzb.zza();
            zza.data = bArr;
            zza.zzb = this.zzb;
            zza.zzc = this.zzc;
            zza.zzd = this.zzd;
            zza.zze = this.zze;
            zza.zzf = this.zzf;
            zza.zzg = this.zzg;
            return zza;
        }
    }

    private static class zzb extends FilterInputStream {
        /* access modifiers changed from: private */
        public int zzaC;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaC = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaC++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaC += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String str) {
        zza zza2 = this.zzax.get(str);
        if (zza2 != null) {
            this.zzay -= zza2.zzaB;
            this.zzax.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        if (!this.zzax.containsKey(str)) {
            this.zzay += zza2.zzaB;
        } else {
            this.zzay = (zza2.zzaB - this.zzax.get(str).zzaB) + this.zzay;
        }
        this.zzax.put(str, zza2);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                zza(outputStream, (String) next.getKey());
                zza(outputStream, (String) next.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | ((((long) zza(inputStream)) & 255) << 0) | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzay + ((long) i) >= ((long) this.zzaA)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzay;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, zza>> it = this.zzax.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                zza zza2 = (zza) it.next().getValue();
                if (zzf(zza2.key).delete()) {
                    this.zzay -= zza2.zzaB;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza2.key, zze(zza2.key));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.zzay + ((long) i))) < ((float) this.zzaA) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    public void remove(String str) {
        synchronized (this) {
            boolean delete = zzf(str).delete();
            removeEntry(str);
            if (!delete) {
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067 A[SYNTHETIC, Splitter:B:33:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzb.zza zza(java.lang.String r11) {
        /*
            r10 = this;
            r1 = 0
            monitor-enter(r10)
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r10.zzax     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x000f
            r0 = r1
        L_0x000d:
            monitor-exit(r10)
            return r0
        L_0x000f:
            java.io.File r4 = r10.zzf(r11)     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.zzv$zzb r2 = new com.google.android.gms.internal.zzv$zzb     // Catch:{ IOException -> 0x003d, all -> 0x0063 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0063 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x003d, all -> 0x0063 }
            r5 = 0
            r2.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x0063 }
            com.google.android.gms.internal.zzv.zza.zzf(r2)     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            long r6 = r4.length()     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            int r3 = r2.zzaC     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            long r8 = (long) r3     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            long r6 = r6 - r8
            int r3 = (int) r6     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            byte[] r3 = zza((java.io.InputStream) r2, (int) r3)     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            com.google.android.gms.internal.zzb$zza r0 = r0.zzb(r3)     // Catch:{ IOException -> 0x0076, all -> 0x0071 }
            if (r2 == 0) goto L_0x000d
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x000d
        L_0x003a:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x003d:
            r2 = move-exception
            r0 = r1
            r3 = r2
        L_0x0040:
            java.lang.String r2 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0079 }
            r6 = 0
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x0079 }
            r5[r6] = r4     // Catch:{ all -> 0x0079 }
            r4 = 1
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0079 }
            r5[r4] = r3     // Catch:{ all -> 0x0079 }
            com.google.android.gms.internal.zzs.zzb(r2, r5)     // Catch:{ all -> 0x0079 }
            r10.remove(r11)     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x005e
            r0.close()     // Catch:{ IOException -> 0x0060 }
        L_0x005e:
            r0 = r1
            goto L_0x000d
        L_0x0060:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0063:
            r0 = move-exception
            r4 = r1
        L_0x0065:
            if (r4 == 0) goto L_0x006a
            r4.close()     // Catch:{ IOException -> 0x006e }
        L_0x006a:
            throw r0     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x006e:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0071:
            r0 = move-exception
            r3 = r0
            r4 = r2
        L_0x0074:
            r0 = r3
            goto L_0x0065
        L_0x0076:
            r3 = move-exception
            r0 = r2
            goto L_0x0040
        L_0x0079:
            r2 = move-exception
            r3 = r2
            r4 = r0
            goto L_0x0074
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[SYNTHETIC, Splitter:B:30:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067 A[SYNTHETIC, Splitter:B:36:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza() {
        /*
            r10 = this;
            r2 = 0
            r0 = 0
            monitor-enter(r10)
            java.io.File r1 = r10.zzaz     // Catch:{ all -> 0x006b }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x006b }
            if (r1 != 0) goto L_0x0026
            java.io.File r0 = r10.zzaz     // Catch:{ all -> 0x006b }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0024
            java.lang.String r0 = "Unable to create cache dir %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006b }
            r2 = 0
            java.io.File r3 = r10.zzaz     // Catch:{ all -> 0x006b }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006b }
            r1[r2] = r3     // Catch:{ all -> 0x006b }
            com.google.android.gms.internal.zzs.zzc(r0, r1)     // Catch:{ all -> 0x006b }
        L_0x0024:
            monitor-exit(r10)
            return
        L_0x0026:
            java.io.File r1 = r10.zzaz     // Catch:{ all -> 0x006b }
            java.io.File[] r3 = r1.listFiles()     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x0024
            int r4 = r3.length     // Catch:{ all -> 0x006b }
        L_0x002f:
            if (r0 >= r4) goto L_0x0024
            r5 = r3[r0]
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0054, all -> 0x0074 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0054, all -> 0x0074 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0074 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x0054, all -> 0x0074 }
            com.google.android.gms.internal.zzv$zza r6 = com.google.android.gms.internal.zzv.zza.zzf(r1)     // Catch:{ IOException -> 0x0072 }
            long r8 = r5.length()     // Catch:{ IOException -> 0x0072 }
            r6.zzaB = r8     // Catch:{ IOException -> 0x0072 }
            java.lang.String r7 = r6.key     // Catch:{ IOException -> 0x0072 }
            r10.zza((java.lang.String) r7, (com.google.android.gms.internal.zzv.zza) r6)     // Catch:{ IOException -> 0x0072 }
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x006e }
        L_0x0051:
            int r0 = r0 + 1
            goto L_0x002f
        L_0x0054:
            r1 = move-exception
            r1 = r2
        L_0x0056:
            if (r5 == 0) goto L_0x005b
            r5.delete()     // Catch:{ all -> 0x0063 }
        L_0x005b:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0051
        L_0x0061:
            r1 = move-exception
            goto L_0x0051
        L_0x0063:
            r0 = move-exception
            r2 = r1
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.close()     // Catch:{ IOException -> 0x0070 }
        L_0x006a:
            throw r0     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x006e:
            r1 = move-exception
            goto L_0x0051
        L_0x0070:
            r1 = move-exception
            goto L_0x006a
        L_0x0072:
            r6 = move-exception
            goto L_0x0056
        L_0x0074:
            r0 = move-exception
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza():void");
    }

    public void zza(String str, zzb.zza zza2) {
        synchronized (this) {
            zzc(zza2.data.length);
            File zzf = zzf(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(zzf);
                zza zza3 = new zza(str, zza2);
                if (!zza3.zza(fileOutputStream)) {
                    fileOutputStream.close();
                    zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                    throw new IOException();
                }
                fileOutputStream.write(zza2.data);
                fileOutputStream.close();
                zza(str, zza3);
            } catch (IOException e) {
                if (!zzf.delete()) {
                    zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
                }
            }
        }
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
