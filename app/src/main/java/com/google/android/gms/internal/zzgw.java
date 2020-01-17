package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzgw implements Callable<zzif> {
    private static final long zzGF = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zziw zzGG;
    /* access modifiers changed from: private */
    public final zzp zzGH;
    private final zzee zzGI;
    private boolean zzGJ;
    private List<String> zzGK;
    private JSONObject zzGL;
    private final zzif.zza zzGd;
    private int zzGu;
    private final Object zzpV = new Object();
    private final zzan zzyt;

    public interface zza<T extends zzh.zza> {
        T zza(zzgw zzgw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        public zzdf zzHb;

        zzb() {
        }
    }

    public zzgw(Context context, zzp zzp, zzee zzee, zziw zziw, zzan zzan, zzif.zza zza2) {
        this.mContext = context;
        this.zzGH = zzp;
        this.zzGG = zziw;
        this.zzGI = zzee;
        this.zzGd = zza2;
        this.zzyt = zzan;
        this.zzGJ = false;
        this.zzGu = -2;
        this.zzGK = null;
    }

    private zzh.zza zza(zzed zzed, zza zza2, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzgn()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzc = zzc(jSONObject2, "impression_tracking_urls");
        this.zzGK = zzc == null ? null : Arrays.asList(zzc);
        this.zzGL = jSONObject2.optJSONObject("active_view");
        zzh.zza zza3 = zza2.zza(this, jSONObject);
        if (zza3 == null) {
            zzin.e("Failed to retrieve ad assets.");
            return null;
        }
        zza3.zzb(new zzi(this.mContext, this.zzGH, zzed, this.zzyt, jSONObject, zza3, this.zzGd.zzLd.zzrl));
        return zza3;
    }

    private zzif zza(zzh.zza zza2) {
        int i;
        synchronized (this.zzpV) {
            i = this.zzGu;
            if (zza2 == null && this.zzGu == -2) {
                i = 0;
            }
        }
        return new zzif(this.zzGd.zzLd.zzHt, (zzjp) null, this.zzGd.zzLe.zzBQ, i, this.zzGd.zzLe.zzBR, this.zzGK, this.zzGd.zzLe.orientation, this.zzGd.zzLe.zzBU, this.zzGd.zzLd.zzHw, false, (zzen) null, (zzey) null, (String) null, (zzeo) null, (zzeq) null, 0, this.zzGd.zzrp, this.zzGd.zzLe.zzHS, this.zzGd.zzKY, this.zzGd.zzKZ, this.zzGd.zzLe.zzHY, this.zzGL, i != -2 ? null : zza2, (RewardItemParcel) null, (List<String>) null, (List<String>) null, this.zzGd.zzLe.zzIm);
    }

    private zzjg<zzc> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (TextUtils.isEmpty(string)) {
            zza(0, z);
            return new zzje(null);
        } else if (z2) {
            return new zzje(new zzc((Drawable) null, Uri.parse(string), optDouble));
        } else {
            final boolean z3 = z;
            return this.zzGG.zza(string, new zziw.zza<zzc>() {
                /* renamed from: zzg */
                public zzc zzh(InputStream inputStream) {
                    byte[] bArr;
                    try {
                        bArr = zzna.zzk(inputStream);
                    } catch (IOException e) {
                        bArr = null;
                    }
                    if (bArr == null) {
                        zzgw.this.zza(2, z3);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray == null) {
                        zzgw.this.zza(2, z3);
                        return null;
                    }
                    decodeByteArray.setDensity((int) (160.0d * optDouble));
                    return new zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(string), optDouble);
                }

                /* renamed from: zzgo */
                public zzc zzgp() {
                    zzgw.this.zza(2, z3);
                    return null;
                }
            });
        }
    }

    private void zza(zzh.zza zza2, zzed zzed) {
        if (zza2 instanceof zzf) {
            final zzf zzf = (zzf) zza2;
            zzb zzb2 = new zzb();
            AnonymousClass3 r1 = new zzdf() {
                public void zza(zzjp zzjp, Map<String, String> map) {
                    zzgw.this.zzb((zzcp) zzf, map.get("asset"));
                }
            };
            zzb2.zzHb = r1;
            zzed.zza("/nativeAdCustomClick", (zzdf) r1);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(final zzed zzed) throws TimeoutException, JSONException {
        if (zzgn()) {
            return null;
        }
        final zzjd zzjd = new zzjd();
        final zzb zzb2 = new zzb();
        AnonymousClass1 r2 = new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzed.zzb("/nativeAdPreProcess", zzb2.zzHb);
                try {
                    String str = map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        zzjd.zzg(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (JSONException e) {
                    zzin.zzb("Malformed native JSON response.", e);
                }
                zzgw.this.zzF(0);
                zzx.zza(zzgw.this.zzgn(), (Object) "Unable to set the ad state error!");
                zzjd.zzg(null);
            }
        };
        zzb2.zzHb = r2;
        zzed.zza("/nativeAdPreProcess", (zzdf) r2);
        zzed.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzGd.zzLe.body));
        return (JSONObject) zzjd.get(zzGF, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public void zzb(zzcp zzcp, String str) {
        try {
            zzct zzs = this.zzGH.zzs(zzcp.getCustomTemplateId());
            if (zzs != null) {
                zzs.zza(zzcp, str);
            }
        } catch (RemoteException e) {
            zzin.zzd("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public static List<Drawable> zzf(List<zzc> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        for (zzc zzdJ : list) {
            arrayList.add((Drawable) zze.zzp(zzdJ.zzdJ()));
        }
        return arrayList;
    }

    private zzed zzgm() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzgn()) {
            return null;
        }
        zzed zzed = this.zzGI.zza(this.mContext, this.zzGd.zzLd.zzrl, (this.zzGd.zzLe.zzEF.indexOf("https") == 0 ? "https:" : "http:") + zzbt.zzwC.get(), this.zzyt).get(zzGF, TimeUnit.MILLISECONDS);
        zzed.zza(this.zzGH, this.zzGH, this.zzGH, this.zzGH, false, (zzdh) null, (zzdj) null, (com.google.android.gms.ads.internal.zze) null, (zzft) null);
        return zzed;
    }

    public void zzF(int i) {
        synchronized (this.zzpV) {
            this.zzGJ = true;
            this.zzGu = i;
        }
    }

    public zzjg<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzjg<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
        } else {
            int length = z3 ? jSONArray.length() : 1;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                arrayList.add(zza(jSONObject2, z, z2));
            }
        }
        return arrayList;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzF(i);
        }
    }

    /* access modifiers changed from: protected */
    public zza zze(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzgn()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzGd.zzLd.zzrD != null ? this.zzGd.zzLd.zzrD.zzyA : false;
        boolean z2 = this.zzGd.zzLd.zzrD != null ? this.zzGd.zzLd.zzrD.zzyC : false;
        if ("2".equals(string)) {
            return new zzgx(z, z2);
        }
        if ("1".equals(string)) {
            return new zzgy(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzjd zzjd = new zzjd();
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    zzjd.zzg(zzgw.this.zzGH.zzbv().get(string2));
                }
            });
            if (zzjd.get(zzGF, TimeUnit.MILLISECONDS) != null) {
                return new zzgz(z);
            }
            zzin.e("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzF(0);
        }
        return null;
    }

    public zzjg<com.google.android.gms.ads.internal.formats.zza> zzf(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzje(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb2 = zzb(optJSONObject, "text_color");
        Integer zzb3 = zzb(optJSONObject, "bg_color");
        final int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        final int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        final String str = optString;
        final Integer num = zzb3;
        final Integer num2 = zzb2;
        final int i = optInt;
        return zzjf.zza(zzjf.zzl(arrayList), new zzjf.zza<List<zzc>, com.google.android.gms.ads.internal.formats.zza>() {
            /* renamed from: zzh */
            public com.google.android.gms.ads.internal.formats.zza zzf(List<zzc> list) {
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            return new com.google.android.gms.ads.internal.formats.zza(str, zzgw.zzf(list), num, num2, i > 0 ? Integer.valueOf(i) : null, optInt3 + optInt2);
                        }
                    } catch (RemoteException e) {
                        zzin.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                return null;
            }
        });
    }

    /* renamed from: zzgl */
    public zzif call() {
        try {
            zzed zzgm = zzgm();
            JSONObject zzb2 = zzb(zzgm);
            zzh.zza zza2 = zza(zzgm, zze(zzb2), zzb2);
            zza(zza2, zzgm);
            return zza(zza2);
        } catch (InterruptedException | CancellationException | ExecutionException e) {
        } catch (JSONException e2) {
            zzin.zzd("Malformed native JSON response.", e2);
        } catch (TimeoutException e3) {
            zzin.zzd("Timeout when loading native ad.", e3);
        }
        if (!this.zzGJ) {
            zzF(0);
        }
        return zza((zzh.zza) null);
    }

    public boolean zzgn() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzGJ;
        }
        return z;
    }
}
