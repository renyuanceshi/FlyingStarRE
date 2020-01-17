package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzhb
public class zzgb implements zzfz {
    private final Context mContext;
    final Set<WebView> zzFr = Collections.synchronizedSet(new HashSet());

    public zzgb(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzin.zzaI("Fetching assets for the given html");
        zzir.zzMc.post(new Runnable() {
            public void run() {
                final WebView zzfR = zzgb.this.zzfR();
                zzfR.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView webView, String str) {
                        zzin.zzaI("Loading assets have finished");
                        zzgb.this.zzFr.remove(zzfR);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        zzin.zzaK("Loading assets have failed.");
                        zzgb.this.zzFr.remove(zzfR);
                    }
                });
                zzgb.this.zzFr.add(zzfR);
                zzfR.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", (String) null);
                zzin.zzaI("Fetching assets finished.");
            }
        });
    }

    public WebView zzfR() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
