package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzr;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzhb
public class zzbv {
    final Context mContext;
    final String zzsy;
    String zzxj;
    BlockingQueue<zzcb> zzxl;
    ExecutorService zzxm;
    LinkedHashMap<String, String> zzxn = new LinkedHashMap<>();
    Map<String, zzby> zzxo = new HashMap();
    private AtomicBoolean zzxp;
    private File zzxq;

    public zzbv(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzsy = str;
        this.zzxj = str2;
        this.zzxp = new AtomicBoolean(false);
        this.zzxp.set(zzbt.zzwi.get().booleanValue());
        if (this.zzxp.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzxq = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzxn.put(next.getKey(), next.getValue());
        }
        this.zzxl = new ArrayBlockingQueue(30);
        this.zzxm = Executors.newSingleThreadExecutor();
        this.zzxm.execute(new Runnable() {
            public void run() {
                zzbv.this.zzdx();
            }
        });
        this.zzxo.put("action", zzby.zzxt);
        this.zzxo.put("ad_format", zzby.zzxt);
        this.zzxo.put("e", zzby.zzxu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[SYNTHETIC, Splitter:B:17:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.io.File r4, java.lang.String r5) {
        /*
            r3 = this;
            r2 = 0
            if (r4 == 0) goto L_0x0045
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x004d }
            r0 = 1
            r1.<init>(r4, r0)     // Catch:{ IOException -> 0x0022, all -> 0x004d }
            byte[] r0 = r5.getBytes()     // Catch:{ IOException -> 0x004b }
            r1.write(r0)     // Catch:{ IOException -> 0x004b }
            r0 = 10
            r1.write(r0)     // Catch:{ IOException -> 0x004b }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001a:
            return
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r1, r0)
            goto L_0x001a
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r2, r0)     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x001a
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r1, r0)
            goto L_0x001a
        L_0x0036:
            r0 = move-exception
            r2 = r1
        L_0x0038:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x003e }
        L_0x003d:
            throw r0
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzin.zzd(r2, r1)
            goto L_0x003d
        L_0x0045:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzin.zzaK(r0)
            goto L_0x001a
        L_0x004b:
            r0 = move-exception
            goto L_0x0024
        L_0x004d:
            r0 = move-exception
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbv.zza(java.io.File, java.lang.String):void");
    }

    private void zzc(Map<String, String> map, String str) {
        String zza = zza(this.zzxj, map, str);
        if (this.zzxp.get()) {
            zza(this.zzxq, zza);
        } else {
            zzr.zzbC().zzc(this.mContext, this.zzsy, zza);
        }
    }

    /* access modifiers changed from: private */
    public void zzdx() {
        while (true) {
            try {
                zzcb take = this.zzxl.take();
                String zzdD = take.zzdD();
                if (!TextUtils.isEmpty(zzdD)) {
                    zzc(zza((Map<String, String>) this.zzxn, take.zzn()), zzdD);
                }
            } catch (InterruptedException e) {
                zzin.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzby zzL(String str) {
        zzby zzby = this.zzxo.get(str);
        return zzby != null ? zzby : zzby.zzxs;
    }

    /* access modifiers changed from: package-private */
    public String zza(String str, Map<String, String> map, @NonNull String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        StringBuilder sb = new StringBuilder(buildUpon.build().toString());
        sb.append("&").append("it").append("=").append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 != null) {
            for (Map.Entry next : map2.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) linkedHashMap.get(str);
                linkedHashMap.put(str, zzL(str).zzb(str2, (String) next.getValue()));
            }
        }
        return linkedHashMap;
    }

    public boolean zza(zzcb zzcb) {
        return this.zzxl.offer(zzcb);
    }

    public void zzb(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzxn.put("e", TextUtils.join(",", list));
        }
    }
}
