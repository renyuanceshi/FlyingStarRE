package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzfq {
    private final boolean zzDu;
    private final boolean zzDv;
    private final boolean zzDw;
    private final boolean zzDx;
    private final boolean zzDy;

    public static final class zza {
        /* access modifiers changed from: private */
        public boolean zzDu;
        /* access modifiers changed from: private */
        public boolean zzDv;
        /* access modifiers changed from: private */
        public boolean zzDw;
        /* access modifiers changed from: private */
        public boolean zzDx;
        /* access modifiers changed from: private */
        public boolean zzDy;

        public zzfq zzeP() {
            return new zzfq(this);
        }

        public zza zzq(boolean z) {
            this.zzDu = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzDv = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzDw = z;
            return this;
        }

        public zza zzt(boolean z) {
            this.zzDx = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzDy = z;
            return this;
        }
    }

    private zzfq(zza zza2) {
        this.zzDu = zza2.zzDu;
        this.zzDv = zza2.zzDv;
        this.zzDw = zza2.zzDw;
        this.zzDx = zza2.zzDx;
        this.zzDy = zza2.zzDy;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzDu).put("tel", this.zzDv).put("calendar", this.zzDw).put("storePicture", this.zzDx).put("inlineVideo", this.zzDy);
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
