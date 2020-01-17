package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@TargetApi(11)
@zzhb
public class zzjw extends zzjq {
    public zzjw(zzjp zzjp, boolean z) {
        super(zzjp, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zzjp)) {
                zzin.zzaK("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zzjp zzjp = (zzjp) webView;
            zzjp.zzhU().zzfo();
            String str2 = zzjp.zzaN().zzui ? zzbt.zzwf.get() : zzjp.zzhY() ? zzbt.zzwe.get() : zzbt.zzwd.get();
            zzin.v("shouldInterceptRequest(" + str2 + ")");
            return zzd(zzjp.getContext(), this.zzpD.zzhX().afmaVersion, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzin.zzaK("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzr.zzbC().zze(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zziw(context).zzb(str2, hashMap).get(60, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
