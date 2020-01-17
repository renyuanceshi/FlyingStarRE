package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzjq;

@zzhb
public class zzgo implements Runnable {
    /* access modifiers changed from: private */
    public final Handler zzGj;
    /* access modifiers changed from: private */
    public final long zzGk;
    /* access modifiers changed from: private */
    public long zzGl;
    /* access modifiers changed from: private */
    public zzjq.zza zzGm;
    protected boolean zzGn;
    protected boolean zzGo;
    /* access modifiers changed from: private */
    public final int zzoG;
    /* access modifiers changed from: private */
    public final int zzoH;
    protected final zzjp zzpD;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzGp;
        private Bitmap zzGq;

        public zza(WebView webView) {
            this.zzGp = webView;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            synchronized (this) {
                this.zzGq = Bitmap.createBitmap(zzgo.this.zzoG, zzgo.this.zzoH, Bitmap.Config.ARGB_8888);
                this.zzGp.setVisibility(0);
                this.zzGp.measure(View.MeasureSpec.makeMeasureSpec(zzgo.this.zzoG, 0), View.MeasureSpec.makeMeasureSpec(zzgo.this.zzoH, 0));
                this.zzGp.layout(0, 0, zzgo.this.zzoG, zzgo.this.zzoH);
                this.zzGp.draw(new Canvas(this.zzGq));
                this.zzGp.invalidate();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            synchronized (this) {
                int width = this.zzGq.getWidth();
                int height = this.zzGq.getHeight();
                if (width == 0 || height == 0) {
                    z = false;
                } else {
                    int i = 0;
                    for (int i2 = 0; i2 < width; i2 += 10) {
                        for (int i3 = 0; i3 < height; i3 += 10) {
                            if (this.zzGq.getPixel(i2, i3) != 0) {
                                i++;
                            }
                        }
                    }
                    z = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
                }
            }
            return z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void onPostExecute(Boolean bool) {
            zzgo.zzc(zzgo.this);
            if (bool.booleanValue() || zzgo.this.zzgg() || zzgo.this.zzGl <= 0) {
                zzgo.this.zzGo = bool.booleanValue();
                zzgo.this.zzGm.zza(zzgo.this.zzpD, true);
            } else if (zzgo.this.zzGl > 0) {
                if (zzin.zzQ(2)) {
                    zzin.zzaI("Ad not detected, scheduling another run.");
                }
                zzgo.this.zzGj.postDelayed(zzgo.this, zzgo.this.zzGk);
            }
        }
    }

    public zzgo(zzjq.zza zza2, zzjp zzjp, int i, int i2) {
        this(zza2, zzjp, i, i2, 200, 50);
    }

    public zzgo(zzjq.zza zza2, zzjp zzjp, int i, int i2, long j, long j2) {
        this.zzGk = j;
        this.zzGl = j2;
        this.zzGj = new Handler(Looper.getMainLooper());
        this.zzpD = zzjp;
        this.zzGm = zza2;
        this.zzGn = false;
        this.zzGo = false;
        this.zzoH = i2;
        this.zzoG = i;
    }

    static /* synthetic */ long zzc(zzgo zzgo) {
        long j = zzgo.zzGl - 1;
        zzgo.zzGl = j;
        return j;
    }

    public void run() {
        if (this.zzpD == null || zzgg()) {
            this.zzGm.zza(this.zzpD, true);
        } else {
            new zza(this.zzpD.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzjy(this, this.zzpD, adResponseParcel.zzIa));
    }

    public void zza(AdResponseParcel adResponseParcel, zzjy zzjy) {
        this.zzpD.setWebViewClient(zzjy);
        this.zzpD.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzEF) ? null : zzr.zzbC().zzaC(adResponseParcel.zzEF), adResponseParcel.body, "text/html", "UTF-8", (String) null);
    }

    public void zzge() {
        this.zzGj.postDelayed(this, this.zzGk);
    }

    public void zzgf() {
        synchronized (this) {
            this.zzGn = true;
        }
    }

    public boolean zzgg() {
        boolean z;
        synchronized (this) {
            z = this.zzGn;
        }
        return z;
    }

    public boolean zzgh() {
        return this.zzGo;
    }
}
