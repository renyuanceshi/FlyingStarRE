package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedHashMap;
import java.util.Map;

@zzhb
public class zzbu {
    private Context mContext = null;
    private String zzsy = null;
    private boolean zzxi;
    private String zzxj;
    private Map<String, String> zzxk;

    public zzbu(Context context, String str) {
        this.mContext = context;
        this.zzsy = str;
        this.zzxi = zzbt.zzwg.get().booleanValue();
        this.zzxj = zzbt.zzwh.get();
        this.zzxk = new LinkedHashMap();
        this.zzxk.put("s", "gmob_sdk");
        this.zzxk.put("v", "3");
        this.zzxk.put("os", Build.VERSION.RELEASE);
        this.zzxk.put("sdk", Build.VERSION.SDK);
        this.zzxk.put("device", zzr.zzbC().zzht());
        this.zzxk.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        zzhj zzE = zzr.zzbI().zzE(this.mContext);
        this.zzxk.put("network_coarse", Integer.toString(zzE.zzKc));
        this.zzxk.put("network_fine", Integer.toString(zzE.zzKd));
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public String zzcs() {
        return this.zzsy;
    }

    /* access modifiers changed from: package-private */
    public boolean zzdu() {
        return this.zzxi;
    }

    /* access modifiers changed from: package-private */
    public String zzdv() {
        return this.zzxj;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzdw() {
        return this.zzxk;
    }
}
