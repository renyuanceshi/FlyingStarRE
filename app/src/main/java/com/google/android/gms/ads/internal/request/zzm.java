package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public class zzm extends zzim {
    /* access modifiers changed from: private */
    public static zzdk zzIA = null;
    private static zzdf zzIB = null;
    static final long zzIw = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzIx = false;
    /* access modifiers changed from: private */
    public static zzeg zzIy = null;
    private static zzdg zzIz = null;
    private static final Object zzqy = new Object();
    private final Context mContext;
    private final Object zzGg = new Object();
    /* access modifiers changed from: private */
    public final zza.C0012zza zzHg;
    private final AdRequestInfoParcel.zza zzHh;
    /* access modifiers changed from: private */
    public zzeg.zzd zzIC;

    public static class zza implements zzeg.zzb<zzed> {
        /* renamed from: zza */
        public void zze(zzed zzed) {
            zzm.zzd(zzed);
        }
    }

    public static class zzb implements zzeg.zzb<zzed> {
        /* renamed from: zza */
        public void zze(zzed zzed) {
            zzm.zzc(zzed);
        }
    }

    public static class zzc implements zzdf {
        public void zza(zzjp zzjp, Map<String, String> map) {
            zzin.zzaK("Invalid request: " + map.get("errors"));
            zzm.zzIA.zzS(map.get("request_id"));
        }
    }

    public zzm(Context context, AdRequestInfoParcel.zza zza2, zza.C0012zza zza3) {
        super(true);
        this.zzHg = zza3;
        this.mContext = context;
        this.zzHh = zza2;
        synchronized (zzqy) {
            if (!zzIx) {
                zzIA = new zzdk();
                zzIz = new zzdg(context.getApplicationContext(), zza2.zzrl);
                zzIB = new zzc();
                zzIy = new zzeg(this.mContext.getApplicationContext(), this.zzHh.zzrl, zzbt.zzvB.get(), new zzb(), new zza());
                zzIx = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject zza2;
        AdvertisingIdClient.Info info;
        Bundle bundle = adRequestInfoParcel.zzHt.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzHt.extras.getString("sdk_less_network_id");
        if (bundle == null || (zza2 = zzhe.zza(this.mContext, adRequestInfoParcel, zzr.zzbI().zzE(this.mContext), (zzhn.zza) null, (Location) null, new zzbm(zzbt.zzvB.get()), (String) null, (String) null, new ArrayList(), (Bundle) null)) == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzin.zzd("Cannot get advertising id info", e);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("network_id", string);
        hashMap.put("request_param", zza2);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzr.zzbC().zzG(hashMap);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static void zzc(zzed zzed) {
        zzed.zza("/loadAd", (zzdf) zzIA);
        zzed.zza("/fetchHttpRequest", (zzdf) zzIz);
        zzed.zza("/invalidRequest", zzIB);
    }

    protected static void zzd(zzed zzed) {
        zzed.zzb("/loadAd", (zzdf) zzIA);
        zzed.zzb("/fetchHttpRequest", (zzdf) zzIz);
        zzed.zzb("/invalidRequest", zzIB);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        final String uuid = UUID.randomUUID().toString();
        final JSONObject zza2 = zza(adRequestInfoParcel, uuid);
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzr.zzbG().elapsedRealtime();
        Future<JSONObject> zzR = zzIA.zzR(uuid);
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() {
            public void run() {
                zzeg.zzd unused = zzm.this.zzIC = zzm.zzIy.zzer();
                zzm.this.zzIC.zza(new zzji.zzc<zzeh>() {
                    /* renamed from: zzd */
                    public void zze(zzeh zzeh) {
                        try {
                            zzeh.zza("AFMA_getAdapterLessMediationAd", zza2);
                        } catch (Exception e) {
                            zzin.zzb("Error requesting an ad url", e);
                            zzm.zzIA.zzS(uuid);
                        }
                    }
                }, new zzji.zza() {
                    public void run() {
                        zzm.zzIA.zzS(uuid);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = zzR.get(zzIw - (zzr.zzbG().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza3 = zzhe.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza3.errorCode == -3 || !TextUtils.isEmpty(zza3.body)) ? zza3 : new AdResponseParcel(3);
        } catch (InterruptedException | CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e2) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        }
    }

    public void onStop() {
        synchronized (this.zzGg) {
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() {
                public void run() {
                    if (zzm.this.zzIC != null) {
                        zzm.this.zzIC.release();
                        zzeg.zzd unused = zzm.this.zzIC = null;
                    }
                }
            });
        }
    }

    public void zzbr() {
        zzin.zzaI("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzHh, (String) null, -1);
        AdResponseParcel zze = zze(adRequestInfoParcel);
        final zzif.zza zza2 = new zzif.zza(adRequestInfoParcel, zze, (zzeo) null, (AdSizeParcel) null, zze.errorCode, zzr.zzbG().elapsedRealtime(), zze.zzHX, (JSONObject) null);
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() {
            public void run() {
                zzm.this.zzHg.zza(zza2);
                if (zzm.this.zzIC != null) {
                    zzm.this.zzIC.release();
                    zzeg.zzd unused = zzm.this.zzIC = null;
                }
            }
        });
    }
}
