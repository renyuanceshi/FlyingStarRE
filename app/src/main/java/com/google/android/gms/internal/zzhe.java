package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzhe {
    private static final SimpleDateFormat zzJg = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static String zzL(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0134 A[Catch:{ JSONException -> 0x01e5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r39, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r40, java.lang.String r41) {
        /*
            org.json.JSONObject r28 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01e5 }
            r0 = r28
            r1 = r41
            r0.<init>(r1)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "ad_base_url"
            r5 = 0
            r0 = r28
            java.lang.String r6 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "ad_url"
            r5 = 0
            r0 = r28
            java.lang.String r7 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "ad_size"
            r5 = 0
            r0 = r28
            java.lang.String r19 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            if (r40 == 0) goto L_0x0093
            r0 = r40
            int r4 = r0.zzHz     // Catch:{ JSONException -> 0x01e5 }
            if (r4 == 0) goto L_0x0093
            r27 = 1
        L_0x002e:
            if (r27 == 0) goto L_0x0096
            java.lang.String r4 = "ad_json"
            r5 = 0
            r0 = r28
            java.lang.String r4 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
        L_0x0039:
            r20 = -1
            java.lang.String r5 = "debug_dialog"
            r8 = 0
            r0 = r28
            java.lang.String r22 = r0.optString(r5, r8)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r5 = "interstitial_timeout"
            r0 = r28
            boolean r5 = r0.has(r5)     // Catch:{ JSONException -> 0x01e5 }
            if (r5 == 0) goto L_0x00a0
            java.lang.String r5 = "interstitial_timeout"
            r0 = r28
            double r8 = r0.getDouble(r5)     // Catch:{ JSONException -> 0x01e5 }
            r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r8 = r8 * r10
            long r0 = (long) r8     // Catch:{ JSONException -> 0x01e5 }
            r16 = r0
        L_0x005f:
            java.lang.String r5 = "orientation"
            r8 = 0
            r0 = r28
            java.lang.String r8 = r0.optString(r5, r8)     // Catch:{ JSONException -> 0x01e5 }
            r5 = -1
            java.lang.String r9 = "portrait"
            boolean r9 = r9.equals(r8)     // Catch:{ JSONException -> 0x01e5 }
            if (r9 == 0) goto L_0x00a3
            com.google.android.gms.internal.zzis r5 = com.google.android.gms.ads.internal.zzr.zzbE()     // Catch:{ JSONException -> 0x01e5 }
            int r5 = r5.zzhw()     // Catch:{ JSONException -> 0x01e5 }
            r13 = r5
        L_0x007a:
            r5 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x01e5 }
            if (r8 != 0) goto L_0x00b5
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x01e5 }
            if (r7 == 0) goto L_0x0251
            java.lang.String r4 = "Could not parse the mediation config: Missing required ad_base_url field"
            com.google.android.gms.internal.zzin.zzaK(r4)     // Catch:{ JSONException -> 0x01e5 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x01e5 }
            r5 = 0
            r4.<init>(r5)     // Catch:{ JSONException -> 0x01e5 }
        L_0x0092:
            return r4
        L_0x0093:
            r27 = 0
            goto L_0x002e
        L_0x0096:
            java.lang.String r4 = "ad_html"
            r5 = 0
            r0 = r28
            java.lang.String r4 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x0039
        L_0x00a0:
            r16 = -1
            goto L_0x005f
        L_0x00a3:
            java.lang.String r9 = "landscape"
            boolean r8 = r9.equals(r8)     // Catch:{ JSONException -> 0x01e5 }
            if (r8 == 0) goto L_0x0254
            com.google.android.gms.internal.zzis r5 = com.google.android.gms.ads.internal.zzr.zzbE()     // Catch:{ JSONException -> 0x01e5 }
            int r5 = r5.zzhv()     // Catch:{ JSONException -> 0x01e5 }
            r13 = r5
            goto L_0x007a
        L_0x00b5:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x01e5 }
            if (r4 != 0) goto L_0x0208
            r0 = r40
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r0.zzrl     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r6 = r4.afmaVersion     // Catch:{ JSONException -> 0x01e5 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r4 = r40
            r5 = r39
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = com.google.android.gms.internal.zzhd.zza(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r6 = r4.zzEF     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r7 = r4.body     // Catch:{ JSONException -> 0x01e5 }
            long r0 = r4.zzHX     // Catch:{ JSONException -> 0x01e5 }
            r20 = r0
            r5 = r4
        L_0x00d7:
            java.lang.String r4 = "click_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            if (r5 != 0) goto L_0x023f
            r8 = 0
        L_0x00e2:
            if (r4 == 0) goto L_0x00e8
            java.util.List r8 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r8)     // Catch:{ JSONException -> 0x01e5 }
        L_0x00e8:
            java.lang.String r4 = "impression_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            if (r5 != 0) goto L_0x0243
            r9 = 0
        L_0x00f3:
            if (r4 == 0) goto L_0x00f9
            java.util.List r9 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r9)     // Catch:{ JSONException -> 0x01e5 }
        L_0x00f9:
            java.lang.String r4 = "manual_impression_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            if (r5 != 0) goto L_0x0247
            r15 = 0
        L_0x0104:
            if (r4 == 0) goto L_0x010a
            java.util.List r15 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r15)     // Catch:{ JSONException -> 0x01e5 }
        L_0x010a:
            if (r5 == 0) goto L_0x024b
            int r4 = r5.orientation     // Catch:{ JSONException -> 0x01e5 }
            r10 = -1
            if (r4 == r10) goto L_0x0113
            int r13 = r5.orientation     // Catch:{ JSONException -> 0x01e5 }
        L_0x0113:
            long r10 = r5.zzHS     // Catch:{ JSONException -> 0x01e5 }
            r24 = 0
            int r4 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            if (r4 <= 0) goto L_0x024b
            long r10 = r5.zzHS     // Catch:{ JSONException -> 0x01e5 }
            r18 = r13
        L_0x011f:
            java.lang.String r4 = "active_view"
            r0 = r28
            java.lang.String r25 = r0.optString(r4)     // Catch:{ JSONException -> 0x01e5 }
            r24 = 0
            java.lang.String r4 = "ad_is_javascript"
            r5 = 0
            r0 = r28
            boolean r23 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            if (r23 == 0) goto L_0x013d
            java.lang.String r4 = "ad_passback_url"
            r5 = 0
            r0 = r28
            java.lang.String r24 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
        L_0x013d:
            java.lang.String r4 = "mediation"
            r5 = 0
            r0 = r28
            boolean r12 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "custom_render_allowed"
            r5 = 0
            r0 = r28
            boolean r26 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "content_url_opted_out"
            r5 = 1
            r0 = r28
            boolean r29 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "prefetch"
            r5 = 0
            r0 = r28
            boolean r30 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "oauth2_token_status"
            r5 = 0
            r0 = r28
            int r31 = r0.optInt(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "refresh_interval_milliseconds"
            r16 = -1
            r0 = r28
            r1 = r16
            long r16 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "mediation_config_cache_time_milliseconds"
            r32 = -1
            r0 = r28
            r1 = r32
            long r13 = r0.optLong(r4, r1)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "gws_query_id"
            java.lang.String r5 = ""
            r0 = r28
            java.lang.String r32 = r0.optString(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "height"
            java.lang.String r5 = "fluid"
            java.lang.String r33 = ""
            r0 = r28
            r1 = r33
            java.lang.String r5 = r0.optString(r5, r1)     // Catch:{ JSONException -> 0x01e5 }
            boolean r33 = r4.equals(r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "native_express"
            r5 = 0
            r0 = r28
            boolean r34 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "video_start_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            r5 = 0
            java.util.List r36 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "video_complete_urls"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            r5 = 0
            java.util.List r37 = zza((org.json.JSONArray) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "rewards"
            r0 = r28
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ JSONException -> 0x01e5 }
            com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel r35 = com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel.zza(r4)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = "use_displayed_impression"
            r5 = 0
            r0 = r28
            boolean r38 = r0.optBoolean(r4, r5)     // Catch:{ JSONException -> 0x01e5 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x01e5 }
            r0 = r40
            boolean r0 = r0.zzHB     // Catch:{ JSONException -> 0x01e5 }
            r28 = r0
            r5 = r40
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x0092
        L_0x01e5:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Could not parse the mediation config: "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.zzin.zzaK(r4)
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r5 = 0
            r4.<init>(r5)
            goto L_0x0092
        L_0x0208:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01e5 }
            r4.<init>()     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r5 = "Could not parse the mediation config: Missing required "
            java.lang.StringBuilder r5 = r4.append(r5)     // Catch:{ JSONException -> 0x01e5 }
            if (r27 == 0) goto L_0x023c
            java.lang.String r4 = "ad_json"
        L_0x0217:
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r5 = " or "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r5 = "ad_url"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r5 = " field."
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ JSONException -> 0x01e5 }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x01e5 }
            com.google.android.gms.internal.zzin.zzaK(r4)     // Catch:{ JSONException -> 0x01e5 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r4 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x01e5 }
            r5 = 0
            r4.<init>(r5)     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x0092
        L_0x023c:
            java.lang.String r4 = "ad_html"
            goto L_0x0217
        L_0x023f:
            java.util.List<java.lang.String> r8 = r5.zzBQ     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x00e2
        L_0x0243:
            java.util.List<java.lang.String> r9 = r5.zzBR     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x00f3
        L_0x0247:
            java.util.List<java.lang.String> r15 = r5.zzHV     // Catch:{ JSONException -> 0x01e5 }
            goto L_0x0104
        L_0x024b:
            r18 = r13
            r10 = r16
            goto L_0x011f
        L_0x0251:
            r7 = r4
            goto L_0x00d7
        L_0x0254:
            r13 = r5
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhe.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new LinkedList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzhj zzhj, zzhn.zza zza, Location location, zzbm zzbm, String str, String str2, List<String> list, Bundle bundle) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzHs != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzHs);
            }
            zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.zzHt);
            hashMap.put("format", adRequestInfoParcel.zzrp.zzuh);
            if (adRequestInfoParcel.zzrp.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzrp.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzrp.zzul) {
                hashMap.put("fluid", "height");
            }
            if (adRequestInfoParcel.zzrp.zzuj != null) {
                StringBuilder sb = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzrp.zzuj) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / zzhj.zzHF) : adSizeParcel.width);
                    sb.append("x");
                    sb.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / zzhj.zzHF) : adSizeParcel.height);
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.zzHz != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzHz));
                if (!adRequestInfoParcel.zzrp.zzum) {
                    hashMap.put("native_templates", adRequestInfoParcel.zzrH);
                    hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzrD));
                    if (!adRequestInfoParcel.zzHK.isEmpty()) {
                        hashMap.put("native_custom_templates", adRequestInfoParcel.zzHK);
                    }
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzrj);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzHu != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzHu.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.zzHw);
            hashMap.put("session_id", adRequestInfoParcel.zzHx);
            hashMap.put("js", adRequestInfoParcel.zzrl.afmaVersion);
            zza((HashMap<String, Object>) hashMap, zzhj, zza);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzHt.versionCode >= 2 && adRequestInfoParcel.zzHt.zztK != null) {
                zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.zzHt.zztK);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzHy);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzHB) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzHB));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzHF));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzHE));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzHD));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzhj.zzHF));
                hashMap.put("sh", Integer.valueOf(zzhj.zzHE));
                hashMap.put("sw", Integer.valueOf(zzhj.zzHD));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzHG)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzHG));
                    } catch (JSONException e) {
                        zzin.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzHH));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzHI);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzHM != null) {
                hashMap.put("capability", adRequestInfoParcel.zzHM.toBundle());
            }
            zza((HashMap<String, Object>) hashMap, str);
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzHN)) {
                hashMap.put("anchor", adRequestInfoParcel.zzHN);
            }
            if (adRequestInfoParcel.versionCode >= 13) {
                hashMap.put("avol", Float.valueOf(adRequestInfoParcel.zzHO));
            }
            if (adRequestInfoParcel.versionCode >= 14 && adRequestInfoParcel.zzHP > 0) {
                hashMap.put("target_api", Integer.valueOf(adRequestInfoParcel.zzHP));
            }
            if (adRequestInfoParcel.versionCode >= 15) {
                hashMap.put("scroll_index", Integer.valueOf(adRequestInfoParcel.zzHQ == -1 ? -1 : adRequestInfoParcel.zzHQ));
            }
            if (zzin.zzQ(2)) {
                zzin.v("Ad Request JSON: " + zzr.zzbC().zzG(hashMap).toString(2));
            }
            return zzr.zzbC().zzG(hashMap);
        } catch (JSONException e2) {
            zzin.zzaK("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        float accuracy = location.getAccuracy();
        long time = location.getTime();
        hashMap2.put("radius", Float.valueOf(accuracy * 1000.0f));
        hashMap2.put("lat", Long.valueOf((long) (location.getLatitude() * 1.0E7d)));
        hashMap2.put("long", Long.valueOf((long) (location.getLongitude() * 1.0E7d)));
        hashMap2.put("time", Long.valueOf(time * 1000));
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzhm = zzil.zzhm();
        if (zzhm != null) {
            hashMap.put("abf", zzhm);
        }
        if (adRequestParcel.zztC != -1) {
            hashMap.put("cust_age", zzJg.format(new Date(adRequestParcel.zztC)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zztD != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zztD));
        }
        if (adRequestParcel.zztE != null) {
            hashMap.put("kw", adRequestParcel.zztE);
        }
        if (adRequestParcel.zztG != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zztG));
        }
        if (adRequestParcel.zztF) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zztH) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zztI)) {
                hashMap.put("ppid", adRequestParcel.zztI);
            }
            if (adRequestParcel.zztJ != null) {
                zza(hashMap, adRequestParcel.zztJ);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zztL != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, adRequestParcel.zztL);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zztN != null) {
                hashMap.put("custom_targeting", adRequestParcel.zztN);
            }
            if (adRequestParcel.zztO != null) {
                hashMap.put("category_exclusions", adRequestParcel.zztO);
            }
            if (adRequestParcel.zztP != null) {
                hashMap.put("request_agent", adRequestParcel.zztP);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zztQ != null) {
            hashMap.put("request_pkg", adRequestParcel.zztQ);
        }
        if (adRequestParcel.versionCode >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zztR));
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzvd) != 0) {
            hashMap.put("acolor", zzL(searchAdRequestParcel.zzvd));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzL(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzve) == 0 || Color.alpha(searchAdRequestParcel.zzvf) == 0)) {
            hashMap.put("gradientto", zzL(searchAdRequestParcel.zzve));
            hashMap.put("gradientfrom", zzL(searchAdRequestParcel.zzvf));
        }
        if (Color.alpha(searchAdRequestParcel.zzvg) != 0) {
            hashMap.put("bcolor", zzL(searchAdRequestParcel.zzvg));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zzvh));
        switch (searchAdRequestParcel.zzvi) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (searchAdRequestParcel.zzvj) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zzvk != null) {
            hashMap.put("channel", searchAdRequestParcel.zzvk);
        }
        if (Color.alpha(searchAdRequestParcel.zzvl) != 0) {
            hashMap.put("dcolor", zzL(searchAdRequestParcel.zzvl));
        }
        if (searchAdRequestParcel.zzvm != null) {
            hashMap.put("font", searchAdRequestParcel.zzvm);
        }
        if (Color.alpha(searchAdRequestParcel.zzvn) != 0) {
            hashMap.put("hcolor", zzL(searchAdRequestParcel.zzvn));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzvo));
        if (searchAdRequestParcel.zzvp != null) {
            hashMap.put("q", searchAdRequestParcel.zzvp);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzhj zzhj, zzhn.zza zza) {
        hashMap.put("am", Integer.valueOf(zzhj.zzJQ));
        hashMap.put("cog", zzy(zzhj.zzJR));
        hashMap.put("coh", zzy(zzhj.zzJS));
        if (!TextUtils.isEmpty(zzhj.zzJT)) {
            hashMap.put("carrier", zzhj.zzJT);
        }
        hashMap.put("gl", zzhj.zzJU);
        if (zzhj.zzJV) {
            hashMap.put("simulator", 1);
        }
        if (zzhj.zzJW) {
            hashMap.put("is_sidewinder", 1);
        }
        hashMap.put("ma", zzy(zzhj.zzJX));
        hashMap.put("sp", zzy(zzhj.zzJY));
        hashMap.put("hl", zzhj.zzJZ);
        if (!TextUtils.isEmpty(zzhj.zzKa)) {
            hashMap.put("mv", zzhj.zzKa);
        }
        hashMap.put("muv", Integer.valueOf(zzhj.zzKb));
        if (zzhj.zzKc != -2) {
            hashMap.put("cnt", Integer.valueOf(zzhj.zzKc));
        }
        hashMap.put("gnt", Integer.valueOf(zzhj.zzKd));
        hashMap.put("pt", Integer.valueOf(zzhj.zzKe));
        hashMap.put("rm", Integer.valueOf(zzhj.zzKf));
        hashMap.put("riv", Integer.valueOf(zzhj.zzKg));
        Bundle bundle = new Bundle();
        bundle.putString("build", zzhj.zzKl);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", zzhj.zzKi);
        bundle2.putDouble("battery_level", zzhj.zzKh);
        bundle.putBundle("battery", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("active_network_state", zzhj.zzKk);
        bundle3.putBoolean("active_network_metered", zzhj.zzKj);
        if (zza != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("predicted_latency_micros", zza.zzKq);
            bundle4.putLong("predicted_down_throughput_bps", zza.zzKr);
            bundle4.putLong("predicted_up_throughput_bps", zza.zzKs);
            bundle3.putBundle("predictions", bundle4);
        }
        bundle.putBundle("network", bundle3);
        hashMap.put("device", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("token", str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzyB : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (adResponseParcel.zzEF != null) {
            jSONObject.put("ad_base_url", adResponseParcel.zzEF);
        }
        if (adResponseParcel.zzHW != null) {
            jSONObject.put("ad_size", adResponseParcel.zzHW);
        }
        jSONObject.put("native", adResponseParcel.zzuk);
        if (adResponseParcel.zzuk) {
            jSONObject.put("ad_json", adResponseParcel.body);
        } else {
            jSONObject.put("ad_html", adResponseParcel.body);
        }
        if (adResponseParcel.zzHY != null) {
            jSONObject.put("debug_dialog", adResponseParcel.zzHY);
        }
        if (adResponseParcel.zzHS != -1) {
            jSONObject.put("interstitial_timeout", ((double) adResponseParcel.zzHS) / 1000.0d);
        }
        if (adResponseParcel.orientation == zzr.zzbE().zzhw()) {
            jSONObject.put("orientation", "portrait");
        } else if (adResponseParcel.orientation == zzr.zzbE().zzhv()) {
            jSONObject.put("orientation", "landscape");
        }
        if (adResponseParcel.zzBQ != null) {
            jSONObject.put("click_urls", zzi(adResponseParcel.zzBQ));
        }
        if (adResponseParcel.zzBR != null) {
            jSONObject.put("impression_urls", zzi(adResponseParcel.zzBR));
        }
        if (adResponseParcel.zzHV != null) {
            jSONObject.put("manual_impression_urls", zzi(adResponseParcel.zzHV));
        }
        if (adResponseParcel.zzIb != null) {
            jSONObject.put("active_view", adResponseParcel.zzIb);
        }
        jSONObject.put("ad_is_javascript", adResponseParcel.zzHZ);
        if (adResponseParcel.zzIa != null) {
            jSONObject.put("ad_passback_url", adResponseParcel.zzIa);
        }
        jSONObject.put("mediation", adResponseParcel.zzHT);
        jSONObject.put("custom_render_allowed", adResponseParcel.zzIc);
        jSONObject.put("content_url_opted_out", adResponseParcel.zzId);
        jSONObject.put("prefetch", adResponseParcel.zzIe);
        jSONObject.put("oauth2_token_status", adResponseParcel.zzIf);
        if (adResponseParcel.zzBU != -1) {
            jSONObject.put("refresh_interval_milliseconds", adResponseParcel.zzBU);
        }
        if (adResponseParcel.zzHU != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", adResponseParcel.zzHU);
        }
        if (!TextUtils.isEmpty(adResponseParcel.zzIi)) {
            jSONObject.put("gws_query_id", adResponseParcel.zzIi);
        }
        jSONObject.put("fluid", adResponseParcel.zzul ? "height" : "");
        jSONObject.put("native_express", adResponseParcel.zzum);
        if (adResponseParcel.zzIk != null) {
            jSONObject.put("video_start_urls", zzi(adResponseParcel.zzIk));
        }
        if (adResponseParcel.zzIl != null) {
            jSONObject.put("video_complete_urls", zzi(adResponseParcel.zzIl));
        }
        if (adResponseParcel.zzIj != null) {
            jSONObject.put("rewards", adResponseParcel.zzIj.zzgR());
        }
        jSONObject.put("use_displayed_impression", adResponseParcel.zzIm);
        return jSONObject;
    }

    @Nullable
    static JSONArray zzi(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private static Integer zzy(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
