package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzhb
public final class zzdm implements zzdf {
    private final zze zzzA;
    private final zzfn zzzB;
    private final zzdh zzzD;

    public static class zza extends zzim {
        private final String zzF;
        private final zzjp zzpD;
        private final String zzzE = "play.google.com";
        private final String zzzF = "market";
        private final int zzzG = 10;

        public zza(zzjp zzjp, String str) {
            this.zzpD = zzjp;
            this.zzF = str;
        }

        public void onStop() {
        }

        public Intent zzT(String str) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(parse);
            return intent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
            com.google.android.gms.internal.zzin.zzaK("Arrived at landing page, this ideally should not happen. Will open it in browser.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00be A[SYNTHETIC, Splitter:B:38:0x00be] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0089 A[EDGE_INSN: B:56:0x0089->B:27:0x0089 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzbr() {
            /*
                r7 = this;
                r0 = 0
                java.lang.String r2 = r7.zzF
                r3 = r0
            L_0x0004:
                r0 = 10
                if (r3 >= r0) goto L_0x0019
                java.net.URL r0 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                java.lang.String r1 = "play.google.com"
                java.lang.String r4 = r0.getHost()     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                if (r1 == 0) goto L_0x002b
            L_0x0019:
                android.content.Intent r0 = r7.zzT(r2)
                com.google.android.gms.internal.zzir r1 = com.google.android.gms.ads.internal.zzr.zzbC()
                com.google.android.gms.internal.zzjp r2 = r7.zzpD
                android.content.Context r2 = r2.getContext()
                r1.zzb((android.content.Context) r2, (android.content.Intent) r0)
                return
            L_0x002b:
                java.lang.String r1 = "market"
                java.lang.String r4 = r0.getProtocol()     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                if (r1 != 0) goto L_0x0019
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                com.google.android.gms.internal.zzir r1 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x00c7 }
                com.google.android.gms.internal.zzjp r4 = r7.zzpD     // Catch:{ all -> 0x00c7 }
                android.content.Context r4 = r4.getContext()     // Catch:{ all -> 0x00c7 }
                com.google.android.gms.internal.zzjp r5 = r7.zzpD     // Catch:{ all -> 0x00c7 }
                com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r5.zzhX()     // Catch:{ all -> 0x00c7 }
                java.lang.String r5 = r5.afmaVersion     // Catch:{ all -> 0x00c7 }
                r6 = 0
                r1.zza((android.content.Context) r4, (java.lang.String) r5, (boolean) r6, (java.net.HttpURLConnection) r0)     // Catch:{ all -> 0x00c7 }
                int r1 = r0.getResponseCode()     // Catch:{ all -> 0x00c7 }
                java.util.Map r4 = r0.getHeaderFields()     // Catch:{ all -> 0x00c7 }
                r5 = 300(0x12c, float:4.2E-43)
                if (r1 < r5) goto L_0x0102
                r5 = 399(0x18f, float:5.59E-43)
                if (r1 > r5) goto L_0x0102
                r1 = 0
                java.lang.String r5 = "Location"
                boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x00c7 }
                if (r5 == 0) goto L_0x00ad
                java.lang.String r1 = "Location"
                java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x00c7 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00c7 }
            L_0x0074:
                if (r1 == 0) goto L_0x0102
                int r4 = r1.size()     // Catch:{ all -> 0x00c7 }
                if (r4 <= 0) goto L_0x0102
                r4 = 0
                java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x00c7 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00c7 }
            L_0x0083:
                boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00c7 }
                if (r4 == 0) goto L_0x00be
                java.lang.String r1 = "Arrived at landing page, this ideally should not happen. Will open it in browser."
                com.google.android.gms.internal.zzin.zzaK(r1)     // Catch:{ all -> 0x00c7 }
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                goto L_0x0019
            L_0x0092:
                r0 = move-exception
                r1 = r2
            L_0x0094:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while parsing ping URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.internal.zzin.zzd(r2, r0)
                r2 = r1
                goto L_0x0019
            L_0x00ad:
                java.lang.String r5 = "location"
                boolean r5 = r4.containsKey(r5)     // Catch:{ all -> 0x00c7 }
                if (r5 == 0) goto L_0x0074
                java.lang.String r1 = "location"
                java.lang.Object r1 = r4.get(r1)     // Catch:{ all -> 0x00c7 }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00c7 }
                goto L_0x0074
            L_0x00be:
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0106, IOException -> 0x0108, RuntimeException -> 0x010a }
                int r0 = r3 + 1
                r2 = r1
                r3 = r0
                goto L_0x0004
            L_0x00c7:
                r1 = move-exception
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
                throw r1     // Catch:{ IndexOutOfBoundsException -> 0x0092, IOException -> 0x00cc, RuntimeException -> 0x00e7 }
            L_0x00cc:
                r0 = move-exception
                r1 = r2
            L_0x00ce:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while pinging URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.internal.zzin.zzd(r2, r0)
                r2 = r1
                goto L_0x0019
            L_0x00e7:
                r0 = move-exception
                r1 = r2
            L_0x00e9:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while pinging URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.internal.zzin.zzd(r2, r0)
                r2 = r1
                goto L_0x0019
            L_0x0102:
                java.lang.String r1 = ""
                goto L_0x0083
            L_0x0106:
                r0 = move-exception
                goto L_0x0094
            L_0x0108:
                r0 = move-exception
                goto L_0x00ce
            L_0x010a:
                r0 = move-exception
                goto L_0x00e9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zza.zzbr():void");
        }
    }

    public static class zzb {
        private final zzjp zzpD;

        public zzb(zzjp zzjp) {
            this.zzpD = zzjp;
        }

        public Intent zza(Context context, Map<String, String> map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo zza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.zzpD != null) {
                str = zzr.zzbC().zza(this.zzpD, str);
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean(map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean(map.get("use_running_process"));
            Uri build = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zzd = zzd(parse);
            Intent zzd2 = zzd(build);
            ResolveInfo zza2 = zza(context, zzd, arrayList);
            if (zza2 != null) {
                return zza(zzd, zza2);
            }
            if (!(zzd2 == null || (zza = zza(context, zzd2)) == null)) {
                Intent zza3 = zza(zzd, zza);
                if (zza(context, zza3) != null) {
                    return zza3;
                }
            }
            if (arrayList.size() == 0) {
                return zzd;
            }
            if (!(!parseBoolean2 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it.next();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                return zza(zzd, resolveInfo);
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzd, (ResolveInfo) arrayList.get(0)) : zzd;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzdm(zzdh zzdh, zze zze, zzfn zzfn) {
        this.zzzD = zzdh;
        this.zzzA = zze;
        this.zzzB = zzfn;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhw();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhv();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzr.zzbE().zzhx();
            }
        }
        return -1;
    }

    private static void zze(zzjp zzjp, Map<String, String> map) {
        String str = map.get("u");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("Destination url cannot be empty.");
        } else {
            new zza(zzjp, str).zzgd();
        }
    }

    private static void zzf(zzjp zzjp, Map<String, String> map) {
        Context context = zzjp.getContext();
        if (TextUtils.isEmpty(map.get("u"))) {
            zzin.zzaK("Destination url cannot be empty.");
            return;
        }
        try {
            zzjp.zzhU().zza(new AdLauncherIntentInfoParcel(new zzb(zzjp).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
        }
    }

    private void zzo(boolean z) {
        if (this.zzzB != null) {
            this.zzzB.zzp(z);
        }
    }

    public void zza(zzjp zzjp, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            zzin.zzaK("Action missing from an open GMSG.");
        } else if (this.zzzA == null || this.zzzA.zzbh()) {
            zzjq zzhU = zzjp.zzhU();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzjp.zzhY()) {
                    zzin.zzaK("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzo(false);
                zzhU.zza(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = map.get("u");
                zzo(false);
                if (str2 != null) {
                    zzhU.zza(zzc(map), zzd(map), str2);
                } else {
                    zzhU.zza(zzc(map), zzd(map), map.get("html"), map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = map.get("product_id");
                String str4 = map.get("report_urls");
                if (this.zzzD == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    this.zzzD.zza(str3, new ArrayList());
                } else {
                    this.zzzD.zza(str3, new ArrayList(Arrays.asList(str4.split(" "))));
                }
            } else if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase(map.get("play_store"))) {
                zze(zzjp, map);
            } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase(map.get("system_browser"))) {
                zzo(true);
                String str5 = map.get("u");
                zzhU.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str5) ? zzr.zzbC().zza(zzjp, str5) : str5, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            } else {
                zzo(true);
                zzf(zzjp, map);
            }
        } else {
            this.zzzA.zzq(map.get("u"));
        }
    }
}
