package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzhb
public class zzga extends Handler {
    private final zzfz zzFq;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzga(Context context) {
        this((zzfz) new zzgb(context.getApplicationContext() != null ? context.getApplicationContext() : context));
    }

    public zzga(zzfz zzfz) {
        this.zzFq = zzfz;
    }

    private void zzd(JSONObject jSONObject) {
        try {
            this.zzFq.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    zzd(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
