package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;
import java.util.Set;

@zzhb
public class zzfn extends zzfs {
    static final Set<String> zzDa = zzmr.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private AdSizeParcel zzCh;
    private String zzDb = "top-right";
    private boolean zzDc = true;
    private int zzDd = 0;
    private int zzDe = 0;
    private int zzDf = 0;
    private int zzDg = 0;
    private final Activity zzDh;
    private ImageView zzDi;
    private LinearLayout zzDj;
    private zzft zzDk;
    private PopupWindow zzDl;
    private RelativeLayout zzDm;
    private ViewGroup zzDn;
    private int zzoG = -1;
    private int zzoH = -1;
    private final zzjp zzpD;
    private final Object zzpV = new Object();

    public zzfn(zzjp zzjp, zzft zzft) {
        super(zzjp, "resize");
        this.zzpD = zzjp;
        this.zzDh = zzjp.zzhP();
        this.zzDk = zzft;
    }

    private int[] zzeM() {
        if (!zzeO()) {
            return null;
        }
        if (this.zzDc) {
            return new int[]{this.zzDd + this.zzDf, this.zzDe + this.zzDg};
        }
        int[] zzf = zzr.zzbC().zzf(this.zzDh);
        int[] zzh = zzr.zzbC().zzh(this.zzDh);
        int i = zzf[0];
        int i2 = this.zzDd + this.zzDf;
        int i3 = this.zzDe + this.zzDg;
        int i4 = i2 < 0 ? 0 : this.zzoG + i2 > i ? i - this.zzoG : i2;
        if (i3 < zzh[0]) {
            i3 = zzh[0];
        } else if (this.zzoH + i3 > zzh[1]) {
            i3 = zzh[1] - this.zzoH;
        }
        return new int[]{i4, i3};
    }

    private void zzh(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zzoG = zzr.zzbC().zzaD(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zzoH = zzr.zzbC().zzaD(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzDf = zzr.zzbC().zzaD(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzDg = zzr.zzbC().zzaD(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzDc = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzDb = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpV) {
            this.zzDd = i;
            this.zzDe = i2;
            if (this.zzDl != null && z) {
                int[] zzeM = zzeM();
                if (zzeM != null) {
                    this.zzDl.update(zzn.zzcS().zzb((Context) this.zzDh, zzeM[0]), zzn.zzcS().zzb((Context) this.zzDh, zzeM[1]), this.zzDl.getWidth(), this.zzDl.getHeight());
                    zzd(zzeM[0], zzeM[1]);
                } else {
                    zzp(true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzc(int i, int i2) {
        if (this.zzDk != null) {
            this.zzDk.zza(i, i2, this.zzoG, this.zzoH);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzd(int i, int i2) {
        zzb(i, i2 - zzr.zzbC().zzh(this.zzDh)[0], this.zzoG, this.zzoH);
    }

    public void zze(int i, int i2) {
        this.zzDd = i;
        this.zzDe = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean zzeL() {
        return this.zzoG > -1 && this.zzoH > -1;
    }

    public boolean zzeN() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzDl != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean zzeO() {
        int i;
        int i2;
        int[] zzf = zzr.zzbC().zzf(this.zzDh);
        int[] zzh = zzr.zzbC().zzh(this.zzDh);
        int i3 = zzf[0];
        int i4 = zzf[1];
        if (this.zzoG < 50 || this.zzoG > i3) {
            zzin.zzaK("Width is too small or too large.");
            return false;
        } else if (this.zzoH < 50 || this.zzoH > i4) {
            zzin.zzaK("Height is too small or too large.");
            return false;
        } else if (this.zzoH == i4 && this.zzoG == i3) {
            zzin.zzaK("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzDc) {
                String str = this.zzDb;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i = this.zzDd + this.zzDf;
                        i2 = this.zzDe + this.zzDg;
                        break;
                    case 1:
                        i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                        i2 = this.zzDe + this.zzDg;
                        break;
                    case 2:
                        i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                        i2 = ((this.zzDe + this.zzDg) + (this.zzoH / 2)) - 25;
                        break;
                    case 3:
                        i = this.zzDd + this.zzDf;
                        i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                        break;
                    case 4:
                        i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                        i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                        break;
                    case 5:
                        i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                        i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                        break;
                    default:
                        i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                        i2 = this.zzDe + this.zzDg;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzh[0] || i2 + 50 > zzh[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzi(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r12 = this;
            r3 = -1
            r5 = 1
            r4 = 0
            java.lang.Object r6 = r12.zzpV
            monitor-enter(r6)
            android.app.Activity r1 = r12.zzDh     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0011
            java.lang.String r1 = "Not an activity context. Cannot resize."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "Webview is not yet available, size is not set."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            throw r1
        L_0x0023:
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzui     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "Is interstitial. Cannot resize an interstitial."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0034:
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzhY()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0043
            java.lang.String r1 = "Cannot resize an expanded banner."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0043:
            r12.zzh(r13)     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.zzeL()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "Invalid width and height options. Cannot resize."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0053:
            android.app.Activity r1 = r12.zzDh     // Catch:{ all -> 0x0020 }
            android.view.Window r7 = r1.getWindow()     // Catch:{ all -> 0x0020 }
            if (r7 == 0) goto L_0x0061
            android.view.View r1 = r7.getDecorView()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0068
        L_0x0061:
            java.lang.String r1 = "Activity context is not ready, cannot get window or decor view."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0068:
            int[] r8 = r12.zzeM()     // Catch:{ all -> 0x0020 }
            if (r8 != 0) goto L_0x0075
            java.lang.String r1 = "Resize location out of screen or close button is not visible."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0075:
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzDh     // Catch:{ all -> 0x0020 }
            int r9 = r12.zzoG     // Catch:{ all -> 0x0020 }
            int r9 = r1.zzb((android.content.Context) r2, (int) r9)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzDh     // Catch:{ all -> 0x0020 }
            int r10 = r12.zzoH     // Catch:{ all -> 0x0020 }
            int r10 = r1.zzb((android.content.Context) r2, (int) r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r1 = r1.getView()     // Catch:{ all -> 0x0020 }
            android.view.ViewParent r2 = r1.getParent()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x01d5
            boolean r1 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x01d5
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0020 }
            r1 = r0
            com.google.android.gms.internal.zzjp r11 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r11 = r11.getView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r11)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzDl     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01ce
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0020 }
            r12.zzDn = r2     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzir r1 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r2 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            android.graphics.Bitmap r1 = r1.zzk(r2)     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = new android.widget.ImageView     // Catch:{ all -> 0x0020 }
            android.app.Activity r11 = r12.zzDh     // Catch:{ all -> 0x0020 }
            r2.<init>(r11)     // Catch:{ all -> 0x0020 }
            r12.zzDi = r2     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzDi     // Catch:{ all -> 0x0020 }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            r12.zzCh = r1     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzDn     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzDi     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
        L_0x00dd:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzDh     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.zzDm = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzDm     // Catch:{ all -> 0x0020 }
            r2 = 0
            r1.setBackgroundColor(r2)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzDm     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0020 }
            r2.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            r1.setLayoutParams(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzir r1 = com.google.android.gms.ads.internal.zzr.zzbC()     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r2 = r12.zzDm     // Catch:{ all -> 0x0020 }
            r11 = 0
            android.widget.PopupWindow r1 = r1.zza((android.view.View) r2, (int) r9, (int) r10, (boolean) r11)     // Catch:{ all -> 0x0020 }
            r12.zzDl = r1     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzDl     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setOutsideTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzDl     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r2 = r12.zzDl     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.zzDc     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01dd
            r1 = r5
        L_0x0116:
            r2.setClippingEnabled(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzDm     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r2 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r9 = -1
            r10 = -1
            r1.addView(r2, r9, r10)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzDh     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.zzDj = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x0020 }
            android.app.Activity r9 = r12.zzDh     // Catch:{ all -> 0x0020 }
            r10 = 50
            int r1 = r1.zzb((android.content.Context) r9, (int) r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r9 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ all -> 0x0020 }
            android.app.Activity r10 = r12.zzDh     // Catch:{ all -> 0x0020 }
            r11 = 50
            int r9 = r9.zzb((android.content.Context) r10, (int) r11)     // Catch:{ all -> 0x0020 }
            r2.<init>(r1, r9)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r12.zzDb     // Catch:{ all -> 0x0020 }
            int r9 = r1.hashCode()     // Catch:{ all -> 0x0020 }
            switch(r9) {
                case -1364013995: goto L_0x01f6;
                case -1012429441: goto L_0x01e0;
                case -655373719: goto L_0x0201;
                case 1163912186: goto L_0x0217;
                case 1288627767: goto L_0x020c;
                case 1755462605: goto L_0x01eb;
                default: goto L_0x0155;
            }     // Catch:{ all -> 0x0020 }
        L_0x0155:
            r1 = r3
        L_0x0156:
            switch(r1) {
                case 0: goto L_0x0222;
                case 1: goto L_0x022e;
                case 2: goto L_0x023a;
                case 3: goto L_0x0241;
                case 4: goto L_0x024d;
                case 5: goto L_0x0259;
                default: goto L_0x0159;
            }     // Catch:{ all -> 0x0020 }
        L_0x0159:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
        L_0x0163:
            android.widget.LinearLayout r1 = r12.zzDj     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzfn$1 r3 = new com.google.android.gms.internal.zzfn$1     // Catch:{ all -> 0x0020 }
            r3.<init>()     // Catch:{ all -> 0x0020 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = r12.zzDj     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "Close button"
            r1.setContentDescription(r3)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzDm     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r3 = r12.zzDj     // Catch:{ all -> 0x0020 }
            r1.addView(r3, r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzDl     // Catch:{ RuntimeException -> 0x0265 }
            android.view.View r2 = r7.getDecorView()     // Catch:{ RuntimeException -> 0x0265 }
            r3 = 0
            com.google.android.gms.ads.internal.util.client.zza r4 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r5 = r12.zzDh     // Catch:{ RuntimeException -> 0x0265 }
            r7 = 0
            r7 = r8[r7]     // Catch:{ RuntimeException -> 0x0265 }
            int r4 = r4.zzb((android.content.Context) r5, (int) r7)     // Catch:{ RuntimeException -> 0x0265 }
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzn.zzcS()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r7 = r12.zzDh     // Catch:{ RuntimeException -> 0x0265 }
            r9 = 1
            r9 = r8[r9]     // Catch:{ RuntimeException -> 0x0265 }
            int r5 = r5.zzb((android.content.Context) r7, (int) r9)     // Catch:{ RuntimeException -> 0x0265 }
            r1.showAtLocation(r2, r3, r4, r5)     // Catch:{ RuntimeException -> 0x0265 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.zzc(r1, r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel     // Catch:{ all -> 0x0020 }
            android.app.Activity r3 = r12.zzDh     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.AdSize r4 = new com.google.android.gms.ads.AdSize     // Catch:{ all -> 0x0020 }
            int r5 = r12.zzoG     // Catch:{ all -> 0x0020 }
            int r7 = r12.zzoH     // Catch:{ all -> 0x0020 }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x0020 }
            r2.<init>((android.content.Context) r3, (com.google.android.gms.ads.AdSize) r4)     // Catch:{ all -> 0x0020 }
            r1.zza(r2)     // Catch:{ all -> 0x0020 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.zzd(r1, r2)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "resized"
            r12.zzao(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01ce:
            android.widget.PopupWindow r1 = r12.zzDl     // Catch:{ all -> 0x0020 }
            r1.dismiss()     // Catch:{ all -> 0x0020 }
            goto L_0x00dd
        L_0x01d5:
            java.lang.String r1 = "Webview is detached, probably in the middle of a resize or expand."
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01dd:
            r1 = r4
            goto L_0x0116
        L_0x01e0:
            java.lang.String r5 = "top-left"
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r4
            goto L_0x0156
        L_0x01eb:
            java.lang.String r4 = "top-center"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r5
            goto L_0x0156
        L_0x01f6:
            java.lang.String r4 = "center"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 2
            goto L_0x0156
        L_0x0201:
            java.lang.String r4 = "bottom-left"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 3
            goto L_0x0156
        L_0x020c:
            java.lang.String r4 = "bottom-center"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 4
            goto L_0x0156
        L_0x0217:
            java.lang.String r4 = "bottom-right"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 5
            goto L_0x0156
        L_0x0222:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x022e:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x023a:
            r1 = 13
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0241:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x024d:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0259:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0265:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r2.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0020 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0020 }
            r12.zzam(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzDm     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r2 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzDn     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x02a8
            android.view.ViewGroup r1 = r12.zzDn     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzDi     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzDn     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r2 = r12.zzpD     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzjp r1 = r12.zzpD     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r12.zzCh     // Catch:{ all -> 0x0020 }
            r1.zza(r2)     // Catch:{ all -> 0x0020 }
        L_0x02a8:
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfn.zzi(java.util.Map):void");
    }

    public void zzp(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzDl != null) {
                this.zzDl.dismiss();
                this.zzDm.removeView(this.zzpD.getView());
                if (this.zzDn != null) {
                    this.zzDn.removeView(this.zzDi);
                    this.zzDn.addView(this.zzpD.getView());
                    this.zzpD.zza(this.zzCh);
                }
                if (z) {
                    zzao("default");
                    if (this.zzDk != null) {
                        this.zzDk.zzbf();
                    }
                }
                this.zzDl = null;
                this.zzDm = null;
                this.zzDn = null;
                this.zzDj = null;
            }
        }
    }
}
