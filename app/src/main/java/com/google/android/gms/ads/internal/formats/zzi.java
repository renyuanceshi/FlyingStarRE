package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzi implements zzh {
    private final Context mContext;
    /* access modifiers changed from: private */
    public zzjp zzpD;
    private final VersionInfoParcel zzpT;
    private final Object zzpV = new Object();
    private final zzp zzyn;
    private final JSONObject zzyq;
    /* access modifiers changed from: private */
    public final zzed zzyr;
    private final zzh.zza zzys;
    private final zzan zzyt;
    private boolean zzyu;
    /* access modifiers changed from: private */
    public String zzyv;
    private WeakReference<View> zzyw = null;

    public zzi(Context context, zzp zzp, zzed zzed, zzan zzan, JSONObject jSONObject, zzh.zza zza, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzyn = zzp;
        this.zzyr = zzed;
        this.zzyt = zzan;
        this.zzyq = jSONObject;
        this.zzys = zza;
        this.zzpT = versionInfoParcel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void recordImpression() {
        zzx.zzcD("recordImpression must be called on the main UI thread.");
        zzn(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzyq);
            this.zzyr.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
        } catch (JSONException e) {
            zzin.zzb("Unable to create impression JSON.", e);
        }
        this.zzyn.zza((zzh) this);
    }

    public zzb zza(View.OnClickListener onClickListener) {
        zza zzdN = this.zzys.zzdN();
        if (zzdN == null) {
            return null;
        }
        zzb zzb = new zzb(this.mContext, zzdN);
        zzb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        zzb.zzdI().setOnClickListener(onClickListener);
        zzb.zzdI().setContentDescription("Ad attribution icon");
        return zzb;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcD("performClick must be called on the main UI thread.");
        for (Map.Entry next : map.entrySet()) {
            if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                zza((String) next.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
    }

    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcD("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.zzys.zzdM());
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzyq);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.zzyn.zzs(this.zzys.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            this.zzyr.zza("google.afma.nativeAds.handleClickGmsg", jSONObject5);
        } catch (JSONException e) {
            zzin.zzb("Unable to create click JSON.", e);
        }
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzyt.zza(motionEvent);
    }

    public zzjp zzdR() {
        this.zzpD = zzdT();
        this.zzpD.getView().setVisibility(8);
        this.zzyr.zza("/loadHtml", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, final Map<String, String> map) {
                zzi.this.zzpD.zzhU().zza((zzjq.zza) new zzjq.zza() {
                    public void zza(zzjp zzjp, boolean z) {
                        String unused = zzi.this.zzyv = (String) map.get("id");
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("messageType", "htmlLoaded");
                            jSONObject.put("id", zzi.this.zzyv);
                            zzi.this.zzyr.zzb("sendMessageToNativeJs", jSONObject);
                        } catch (JSONException e) {
                            zzin.zzb("Unable to dispatch sendMessageToNativeJsevent", e);
                        }
                    }
                });
                String str = map.get("overlayHtml");
                String str2 = map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzi.this.zzpD.loadData(str, "text/html", "UTF-8");
                } else {
                    zzi.this.zzpD.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
                }
            }
        });
        this.zzyr.zza("/showOverlay", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(0);
            }
        });
        this.zzyr.zza("/hideOverlay", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(8);
            }
        });
        this.zzpD.zzhU().zza("/hideOverlay", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                zzi.this.zzpD.getView().setVisibility(8);
            }
        });
        this.zzpD.zzhU().zza("/sendMessageToSdk", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String next : map.keySet()) {
                        jSONObject.put(next, map.get(next));
                    }
                    jSONObject.put("id", zzi.this.zzyv);
                    zzi.this.zzyr.zzb("sendMessageToNativeJs", jSONObject);
                } catch (JSONException e) {
                    zzin.zzb("Unable to dispatch sendMessageToNativeJs event", e);
                }
            }
        });
        return this.zzpD;
    }

    public View zzdS() {
        if (this.zzyw != null) {
            return (View) this.zzyw.get();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public zzjp zzdT() {
        return zzr.zzbD().zza(this.mContext, AdSizeParcel.zzt(this.mContext), false, false, this.zzyt, this.zzpT);
    }

    public void zzg(View view) {
    }

    public void zzh(View view) {
        synchronized (this.zzpV) {
            if (!this.zzyu) {
                if (view.isShown()) {
                    if (view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                        recordImpression();
                    }
                }
            }
        }
    }

    public void zzi(View view) {
        this.zzyw = new WeakReference<>(view);
    }

    /* access modifiers changed from: protected */
    public void zzn(boolean z) {
        this.zzyu = z;
    }
}
