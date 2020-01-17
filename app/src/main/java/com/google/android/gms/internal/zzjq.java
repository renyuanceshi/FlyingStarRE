package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.iid.InstanceID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzhb
public class zzjq extends WebViewClient {
    private static final String[] zzNy = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", InstanceID.ERROR_TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzNz = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzft zzDk;
    private zza zzGm;
    private final HashMap<String, List<zzdf>> zzNA;
    private zzg zzNB;
    /* access modifiers changed from: private */
    public zzb zzNC;
    private boolean zzND;
    private boolean zzNE;
    private zzp zzNF;
    private final zzfr zzNG;
    private boolean zzNH;
    private boolean zzNI;
    private boolean zzNJ;
    private int zzNK;
    protected zzjp zzpD;
    private final Object zzpV;
    private boolean zzsz;
    private com.google.android.gms.ads.internal.client.zza zztz;
    private zzdb zzyW;
    private zze zzzA;
    private zzfn zzzB;
    private zzdh zzzD;
    private zzdj zzzy;

    public interface zza {
        void zza(zzjp zzjp, boolean z);
    }

    public interface zzb {
        void zzbi();
    }

    private static class zzc implements zzg {
        private zzg zzNB;
        private zzjp zzNM;

        public zzc(zzjp zzjp, zzg zzg) {
            this.zzNM = zzjp;
            this.zzNB = zzg;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzaW() {
            this.zzNB.zzaW();
            this.zzNM.zzhN();
        }

        public void zzaX() {
            this.zzNB.zzaX();
            this.zzNM.zzfr();
        }
    }

    private class zzd implements zzdf {
        private zzd() {
        }

        public void zza(zzjp zzjp, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                zzjq.this.zzij();
            } else if (map.keySet().contains("stop")) {
                zzjq.this.zzik();
            } else if (map.keySet().contains("cancel")) {
                zzjq.this.zzil();
            }
        }
    }

    public zzjq(zzjp zzjp, boolean z) {
        this(zzjp, z, new zzfr(zzjp, zzjp.zzhQ(), new zzbl(zzjp.getContext())), (zzfn) null);
    }

    zzjq(zzjp zzjp, boolean z, zzfr zzfr, zzfn zzfn) {
        this.zzNA = new HashMap<>();
        this.zzpV = new Object();
        this.zzND = false;
        this.zzpD = zzjp;
        this.zzsz = z;
        this.zzNG = zzfr;
        this.zzzB = zzfn;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (zzbt.zzwO.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzaN(str3));
            zzr.zzbC().zza(context, this.zzpD.zzhX().afmaVersion, "gmob-apps", bundle, true);
        }
    }

    private String zzaN(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* access modifiers changed from: private */
    public void zzij() {
        synchronized (this.zzpV) {
            this.zzNE = true;
        }
        this.zzNK++;
        zzim();
    }

    /* access modifiers changed from: private */
    public void zzik() {
        this.zzNK--;
        zzim();
    }

    /* access modifiers changed from: private */
    public void zzil() {
        this.zzNJ = true;
        zzim();
    }

    public final void onLoadResource(WebView webView, String str) {
        zzin.v("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzpV) {
            if (this.zzNH) {
                zzin.v("Blank page loaded, 1...");
                this.zzpD.zzhZ();
                return;
            }
            this.zzNI = true;
            zzim();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zza(this.zzpD.getContext(), "http_err", (i >= 0 || (-i) + -1 >= zzNy.length) ? String.valueOf(i) : zzNy[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zza(this.zzpD.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzNz.length) ? String.valueOf(primaryError) : zzNz[primaryError], zzr.zzbE().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        synchronized (this.zzpV) {
            this.zzNA.clear();
            this.zztz = null;
            this.zzNB = null;
            this.zzGm = null;
            this.zzyW = null;
            this.zzND = false;
            this.zzsz = false;
            this.zzNE = false;
            this.zzzD = null;
            this.zzNF = null;
            this.zzNC = null;
            if (this.zzzB != null) {
                this.zzzB.zzp(true);
                this.zzzB = null;
            }
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case TransportMediator.KEYCODE_MEDIA_PLAY:
            case TransportMediator.KEYCODE_MEDIA_PAUSE:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        zzin.v("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else if (this.zzND && webView == this.zzpD.getWebView() && zzg(parse)) {
            if (this.zztz != null && zzbt.zzww.get().booleanValue()) {
                this.zztz.onAdClicked();
                this.zztz = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (!this.zzpD.getWebView().willNotDraw()) {
            try {
                zzan zzhW = this.zzpD.zzhW();
                if (zzhW != null && zzhW.zzb(parse)) {
                    parse = zzhW.zza(parse, this.zzpD.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                zzin.zzaK("Unable to append parameter to URL: " + str);
                uri = parse;
            }
            if (this.zzzA == null || this.zzzA.zzbh()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.zzzA.zzq(str);
            }
        } else {
            zzin.zzaK("AdWebView unable to handle URL: " + str);
        }
        return true;
    }

    public void zzG(boolean z) {
        this.zzND = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzNG.zzf(i, i2);
        if (this.zzzB != null) {
            this.zzzB.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzg zzg = null;
        boolean zzhY = this.zzpD.zzhY();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null;
        if (!zzhY) {
            zzg = this.zzNB;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, zza2, zzg, this.zzNF, this.zzpD.zzhX()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzeN = this.zzzB != null ? this.zzzB.zzeN() : false;
        com.google.android.gms.ads.internal.overlay.zze zzbA = zzr.zzbA();
        Context context = this.zzpD.getContext();
        if (!zzeN) {
            z = true;
        }
        zzbA.zza(context, adOverlayInfoParcel, z);
    }

    public void zza(zza zza2) {
        this.zzGm = zza2;
    }

    public void zza(zzb zzb2) {
        this.zzNC = zzb2;
    }

    public void zza(String str, zzdf zzdf) {
        synchronized (this.zzpV) {
            List list = this.zzNA.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzNA.put(str, list);
            }
            list.add(zzdf);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzpD.zzhY() || this.zzpD.zzaN().zzui) ? this.zztz : null, this.zzNB, this.zzNF, this.zzpD, z, i, this.zzpD.zzhX()));
    }

    public final void zza(boolean z, int i, String str) {
        zzc zzc2 = null;
        boolean zzhY = this.zzpD.zzhY();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null;
        if (!zzhY) {
            zzc2 = new zzc(this.zzpD, this.zzNB);
        }
        zza(new AdOverlayInfoParcel(zza2, zzc2, this.zzyW, this.zzNF, this.zzpD, z, i, str, this.zzpD.zzhX(), this.zzzD));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzhY = this.zzpD.zzhY();
        zza(new AdOverlayInfoParcel((!zzhY || this.zzpD.zzaN().zzui) ? this.zztz : null, zzhY ? null : new zzc(this.zzpD, this.zzNB), this.zzyW, this.zzNF, this.zzpD, z, i, str, str2, this.zzpD.zzhX(), this.zzzD));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza zza2, zzg zzg, zzdb zzdb, zzp zzp, boolean z, zzdh zzdh, zzdj zzdj, zze zze, zzft zzft) {
        if (zze == null) {
            zze = new zze(false);
        }
        this.zzzB = new zzfn(this.zzpD, zzft);
        zza("/appEvent", (zzdf) new zzda(zzdb));
        zza("/backButton", zzde.zzzh);
        zza("/canOpenURLs", zzde.zzyY);
        zza("/canOpenIntents", zzde.zzyZ);
        zza("/click", zzde.zzza);
        zza("/close", zzde.zzzb);
        zza("/customClose", zzde.zzzd);
        zza("/instrument", zzde.zzzk);
        zza("/delayPageLoaded", (zzdf) new zzd());
        zza("/httpTrack", zzde.zzze);
        zza("/log", zzde.zzzf);
        zza("/mraid", (zzdf) new zzdl(zze, this.zzzB));
        zza("/mraidLoaded", (zzdf) this.zzNG);
        zza("/open", (zzdf) new zzdm(zzdh, zze, this.zzzB));
        zza("/precache", zzde.zzzj);
        zza("/touch", zzde.zzzg);
        zza("/video", zzde.zzzi);
        zza("/appStreaming", zzde.zzzc);
        if (zzdj != null) {
            zza("/setInterstitialProperties", (zzdf) new zzdi(zzdj));
        }
        this.zztz = zza2;
        this.zzNB = zzg;
        this.zzyW = zzdb;
        this.zzzD = zzdh;
        this.zzNF = zzp;
        this.zzzA = zze;
        this.zzDk = zzft;
        this.zzzy = zzdj;
        zzG(z);
    }

    public void zzb(String str, zzdf zzdf) {
        synchronized (this.zzpV) {
            List list = this.zzNA.get(str);
            if (list != null) {
                list.remove(zzdf);
            }
        }
    }

    public boolean zzcv() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsz;
        }
        return z;
    }

    public void zze(int i, int i2) {
        if (this.zzzB != null) {
            this.zzzB.zze(i, i2);
        }
    }

    public final void zzfo() {
        synchronized (this.zzpV) {
            this.zzND = false;
            this.zzsz = true;
            zzir.runOnUiThread(new Runnable() {
                public void run() {
                    zzjq.this.zzpD.zzid();
                    com.google.android.gms.ads.internal.overlay.zzd zzhS = zzjq.this.zzpD.zzhS();
                    if (zzhS != null) {
                        zzhS.zzfo();
                    }
                    if (zzjq.this.zzNC != null) {
                        zzjq.this.zzNC.zzbi();
                        zzb unused = zzjq.this.zzNC = null;
                    }
                }
            });
        }
    }

    public void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzdf> list = this.zzNA.get(path);
        if (list != null) {
            Map<String, String> zze = zzr.zzbC().zze(uri);
            if (zzin.zzQ(2)) {
                zzin.v("Received GMSG: " + path);
                for (String next : zze.keySet()) {
                    zzin.v("  " + next + ": " + zze.get(next));
                }
            }
            for (zzdf zza2 : list) {
                zza2.zza(this.zzpD, zze);
            }
            return;
        }
        zzin.v("No GMSG handler found for GMSG: " + uri);
    }

    public void zzh(zzjp zzjp) {
        this.zzpD = zzjp;
    }

    public zze zzig() {
        return this.zzzA;
    }

    public boolean zzih() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzNE;
        }
        return z;
    }

    public void zzii() {
        synchronized (this.zzpV) {
            zzin.v("Loading blank page in WebView, 2...");
            this.zzNH = true;
            this.zzpD.zzaL("about:blank");
        }
    }

    public final void zzim() {
        if (this.zzGm != null && ((this.zzNI && this.zzNK <= 0) || this.zzNJ)) {
            this.zzGm.zza(this.zzpD, !this.zzNJ);
            this.zzGm = null;
        }
        this.zzpD.zzie();
    }
}
