package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzd extends zzgc.zza {
    private Context mContext;
    private String zzFI;
    private ArrayList<String> zzFJ;
    private String zzsy;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzFI = str;
        this.zzFJ = arrayList;
        this.zzsy = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzFI;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            zzfX();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(i));
        hashMap.put("sku", this.zzFI);
        hashMap.put("status", String.valueOf(zzB(i)));
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzFJ.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), hashMap));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, (List<String>) linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            zzfX();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(i));
        hashMap.put("sku", this.zzFI);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzFJ.iterator();
        while (it.hasNext()) {
            linkedList.add(zza(it.next(), hashMap));
        }
        zzr.zzbC().zza(this.mContext, this.zzsy, (List<String>) linkedList);
    }

    /* access modifiers changed from: protected */
    public int zzB(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    /* access modifiers changed from: protected */
    public String zza(String str, HashMap<String, String> hashMap) {
        String str2;
        String packageName = this.mContext.getPackageName();
        try {
            str2 = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzin.zzd("Error to retrieve app version", e);
            str2 = "";
        }
        long zzhl = zzr.zzbF().zzha().zzhl();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (String next : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{next}), String.format("$1%s$2", new Object[]{hashMap.get(next)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{zzr.zzbF().getSessionId()})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{packageName})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(Build.VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.zzsy})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{str2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime - zzhl)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    /* access modifiers changed from: package-private */
    public void zzfX() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.mContext, this.zzFI, "", true});
        } catch (ClassNotFoundException e) {
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzin.zzaK("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzin.zzd("Fail to report a conversion.", e3);
        }
    }
}
