package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzm {
    private static zzd zza(zzfb zzfb) throws RemoteException {
        return new zzd(zzfb.getHeadline(), zzfb.getImages(), zzfb.getBody(), zzfb.zzdK(), zzfb.getCallToAction(), zzfb.getStarRating(), zzfb.getStore(), zzfb.getPrice(), (zza) null, zzfb.getExtras());
    }

    private static zze zza(zzfc zzfc) throws RemoteException {
        return new zze(zzfc.getHeadline(), zzfc.getImages(), zzfc.getBody(), zzfc.zzdO(), zzfc.getCallToAction(), zzfc.getAdvertiser(), (zza) null, zzfc.getExtras());
    }

    static zzdf zza(final zzfb zzfb, final zzfc zzfc, final zzf.zza zza) {
        return new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                View view = zzjp.getView();
                if (view != null) {
                    try {
                        if (zzfb != null) {
                            if (!zzfb.getOverrideClickHandling()) {
                                zzfb.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                                zza.onClick();
                                return;
                            }
                            zzm.zza(zzjp);
                        } else if (zzfc == null) {
                        } else {
                            if (!zzfc.getOverrideClickHandling()) {
                                zzfc.zzc(com.google.android.gms.dynamic.zze.zzC(view));
                                zza.onClick();
                                return;
                            }
                            zzm.zza(zzjp);
                        }
                    } catch (RemoteException e) {
                        zzin.zzd("Unable to call handleClick on mapper", e);
                    }
                }
            }
        };
    }

    static zzdf zza(final CountDownLatch countDownLatch) {
        return new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                countDownLatch.countDown();
                View view = zzjp.getView();
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        };
    }

    private static String zza(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzin.zzaK("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    static String zza(zzch zzch) {
        if (zzch == null) {
            zzin.zzaK("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzch.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzin.zzaK("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzch);
    }

    /* access modifiers changed from: private */
    public static JSONObject zza(Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (bundle.containsKey(next)) {
                    if ("image".equals(jSONObject2.getString(next))) {
                        Object obj = bundle.get(next);
                        if (obj instanceof Bitmap) {
                            jSONObject.put(next, zza((Bitmap) obj));
                        } else {
                            zzin.zzaK("Invalid type. An image type extra should return a bitmap");
                        }
                    } else if (bundle.get(next) instanceof Bitmap) {
                        zzin.zzaK("Invalid asset type. Bitmap should be returned only for image type");
                    } else {
                        jSONObject.put(next, String.valueOf(bundle.get(next)));
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void zza(zzif zzif, zzf.zza zza) {
        if (zzg(zzif)) {
            zzjp zzjp = zzif.zzED;
            View view = zzjp.getView();
            if (view == null) {
                zzin.zzaK("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzif.zzCp.zzBM;
                if (list == null || list.isEmpty()) {
                    zzin.zzaK("No template ids present in mediation response");
                    return;
                }
                zzfb zzeF = zzif.zzCq.zzeF();
                zzfc zzeG = zzif.zzCq.zzeG();
                if (list.contains("2") && zzeF != null) {
                    zzeF.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                    if (!zzeF.getOverrideImpressionRecording()) {
                        zzeF.recordImpression();
                    }
                    zzjp.zzhU().zza("/nativeExpressViewClicked", zza(zzeF, (zzfc) null, zza));
                } else if (!list.contains("1") || zzeG == null) {
                    zzin.zzaK("No matching template id and mapper");
                } else {
                    zzeG.zzd(com.google.android.gms.dynamic.zze.zzC(view));
                    if (!zzeG.getOverrideImpressionRecording()) {
                        zzeG.recordImpression();
                    }
                    zzjp.zzhU().zza("/nativeExpressViewClicked", zza((zzfb) null, zzeG, zza));
                }
            } catch (RemoteException e) {
                zzin.zzd("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void zza(zzjp zzjp) {
        View.OnClickListener zzif = zzjp.zzif();
        if (zzif != null) {
            zzif.onClick(zzjp.getView());
        }
    }

    private static void zza(final zzjp zzjp, final zzd zzd, final String str) {
        zzjp.zzhU().zza((zzjq.zza) new zzjq.zza() {
            public void zza(zzjp zzjp, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zzd.getHeadline());
                    jSONObject.put("body", zzd.getBody());
                    jSONObject.put("call_to_action", zzd.getCallToAction());
                    jSONObject.put("price", zzd.getPrice());
                    jSONObject.put("star_rating", String.valueOf(zzd.getStarRating()));
                    jSONObject.put("store", zzd.getStore());
                    jSONObject.put("icon", zzm.zza(zzd.zzdK()));
                    JSONArray jSONArray = new JSONArray();
                    List<Object> images = zzd.getImages();
                    if (images != null) {
                        for (Object zzd : images) {
                            jSONArray.put(zzm.zza(zzm.zzc(zzd)));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzm.zza(zzd.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "2");
                    zzjp.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(final zzjp zzjp, final zze zze, final String str) {
        zzjp.zzhU().zza((zzjq.zza) new zzjq.zza() {
            public void zza(zzjp zzjp, boolean z) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("headline", zze.getHeadline());
                    jSONObject.put("body", zze.getBody());
                    jSONObject.put("call_to_action", zze.getCallToAction());
                    jSONObject.put("advertiser", zze.getAdvertiser());
                    jSONObject.put("logo", zzm.zza(zze.zzdO()));
                    JSONArray jSONArray = new JSONArray();
                    List<Object> images = zze.getImages();
                    if (images != null) {
                        for (Object zzd : images) {
                            jSONArray.put(zzm.zza(zzm.zzc(zzd)));
                        }
                    }
                    jSONObject.put("images", jSONArray);
                    jSONObject.put("extras", zzm.zza(zze.getExtras(), str));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("assets", jSONObject);
                    jSONObject2.put("template_id", "1");
                    zzjp.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
                } catch (JSONException e) {
                    zzin.zzd("Exception occurred when loading assets", e);
                }
            }
        });
    }

    private static void zza(zzjp zzjp, CountDownLatch countDownLatch) {
        zzjp.zzhU().zza("/nativeExpressAssetsLoaded", zza(countDownLatch));
        zzjp.zzhU().zza("/nativeExpressAssetsLoadingFailed", zzb(countDownLatch));
    }

    public static boolean zza(zzjp zzjp, zzes zzes, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = zzb(zzjp, zzes, countDownLatch);
        } catch (RemoteException e) {
            zzin.zzd("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    static zzdf zzb(final CountDownLatch countDownLatch) {
        return new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzin.zzaK("Adapter returned an ad, but assets substitution failed");
                countDownLatch.countDown();
                zzjp.destroy();
            }
        };
    }

    private static String zzb(zzch zzch) {
        try {
            com.google.android.gms.dynamic.zzd zzdJ = zzch.zzdJ();
            if (zzdJ == null) {
                zzin.zzaK("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) com.google.android.gms.dynamic.zze.zzp(zzdJ);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzin.zzaK("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            zzin.zzaK("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static boolean zzb(zzjp zzjp, zzes zzes, CountDownLatch countDownLatch) throws RemoteException {
        View view = zzjp.getView();
        if (view == null) {
            zzin.zzaK("AdWebView is null");
            return false;
        }
        view.setVisibility(4);
        List<String> list = zzes.zzCp.zzBM;
        if (list == null || list.isEmpty()) {
            zzin.zzaK("No template ids present in mediation response");
            return false;
        }
        zza(zzjp, countDownLatch);
        zzfb zzeF = zzes.zzCq.zzeF();
        zzfc zzeG = zzes.zzCq.zzeG();
        if (list.contains("2") && zzeF != null) {
            zza(zzjp, zza(zzeF), zzes.zzCp.zzBL);
        } else if (!list.contains("1") || zzeG == null) {
            zzin.zzaK("No matching template id and mapper");
            return false;
        } else {
            zza(zzjp, zza(zzeG), zzes.zzCp.zzBL);
        }
        String str = zzes.zzCp.zzBJ;
        String str2 = zzes.zzCp.zzBK;
        if (str2 != null) {
            zzjp.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        } else {
            zzjp.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static zzch zzc(Object obj) {
        if (obj instanceof IBinder) {
            return zzch.zza.zzt((IBinder) obj);
        }
        return null;
    }

    public static View zzf(zzif zzif) {
        if (zzif == null) {
            zzin.e("AdState is null");
            return null;
        } else if (zzg(zzif)) {
            return zzif.zzED.getView();
        } else {
            try {
                com.google.android.gms.dynamic.zzd view = zzif.zzCq.getView();
                if (view != null) {
                    return (View) com.google.android.gms.dynamic.zze.zzp(view);
                }
                zzin.zzaK("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzin.zzd("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    public static boolean zzg(zzif zzif) {
        return (zzif == null || !zzif.zzHT || zzif.zzCp == null || zzif.zzCp.zzBJ == null) ? false : true;
    }
}
