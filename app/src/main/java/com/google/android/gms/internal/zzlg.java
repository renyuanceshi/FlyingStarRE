package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzlg implements zzlf {
    protected final Activity mActivity;
    private String zzWP;
    private String zzXT;
    protected final Set<String> zzXf;
    private zzlf.zza zzYe;

    protected zzlg(Activity activity, List<String> list, List<String> list2) {
        this.mActivity = (Activity) zzx.zzz(activity);
        HashSet hashSet = new HashSet((Collection) zzx.zzz(list));
        hashSet.addAll((Collection) zzx.zzz(list2));
        this.zzXf = Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: protected */
    public Intent zza(IdpTokenType idpTokenType, String str, String str2) {
        zzx.zzz(idpTokenType);
        zzx.zzcM(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        zzd zzmU = zzmU();
        if (zzmU != null) {
            intent.putExtra("idProvider", zzmU.zzmT());
        }
        return intent;
    }

    /* access modifiers changed from: protected */
    public void zzb(zzlf.zza zza) {
        this.zzYe = (zzlf.zza) zzx.zzz(zza);
    }

    /* access modifiers changed from: protected */
    public void zzb(String str, String str2, zzlf.zza zza) {
        zzbW(str);
        zzbX(str2);
        zzb(zza);
    }

    /* access modifiers changed from: protected */
    public void zzbW(String str) {
        this.zzWP = str;
    }

    /* access modifiers changed from: protected */
    public void zzbX(String str) {
        this.zzXT = str;
    }

    /* access modifiers changed from: protected */
    public Set<String> zzns() {
        return this.zzXf;
    }

    /* access modifiers changed from: protected */
    public zzlf.zza zznt() {
        return this.zzYe;
    }

    /* access modifiers changed from: protected */
    public String zznu() {
        return this.zzXT;
    }
}
