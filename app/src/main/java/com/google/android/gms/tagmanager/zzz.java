package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzz implements zzar {
    private static final Object zzbhz = new Object();
    private static zzz zzbiM;
    private String zzbiN;
    private String zzbiO;
    private zzas zzbiP;
    private zzcd zzbic;

    private zzz(Context context) {
        this(zzat.zzaZ(context), new zzcs());
    }

    zzz(zzas zzas, zzcd zzcd) {
        this.zzbiP = zzas;
        this.zzbic = zzcd;
    }

    public static zzar zzaX(Context context) {
        zzz zzz;
        synchronized (zzbhz) {
            if (zzbiM == null) {
                zzbiM = new zzz(context);
            }
            zzz = zzbiM;
        }
        return zzz;
    }

    public boolean zzgc(String str) {
        if (!this.zzbic.zzlw()) {
            zzbg.zzaK("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        if (!(this.zzbiN == null || this.zzbiO == null)) {
            try {
                str = this.zzbiN + "?" + this.zzbiO + "=" + URLEncoder.encode(str, "UTF-8");
                zzbg.v("Sending wrapped url hit: " + str);
            } catch (UnsupportedEncodingException e) {
                zzbg.zzd("Error wrapping URL for testing.", e);
                return false;
            }
        }
        this.zzbiP.zzgg(str);
        return true;
    }
}
