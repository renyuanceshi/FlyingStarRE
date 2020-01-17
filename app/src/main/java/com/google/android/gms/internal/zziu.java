package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.zzr;
import java.util.Map;

@zzhb
public class zziu {
    /* access modifiers changed from: private */
    public final Context mContext;
    private int mState;
    private final float zzDB;
    private String zzMh;
    private float zzMi;
    private float zzMj;
    private float zzMk;

    public zziu(Context context) {
        this.mState = 0;
        this.mContext = context;
        this.zzDB = context.getResources().getDisplayMetrics().density;
    }

    public zziu(Context context, String str) {
        this(context);
        this.zzMh = str;
    }

    private void showDialog() {
        if (!(this.mContext instanceof Activity)) {
            zzin.zzaJ("Can not create dialog without Activity Context");
            return;
        }
        final String zzaG = zzaG(this.zzMh);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setMessage(zzaG);
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                zzr.zzbC().zzb(zziu.this.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", zzaG), "Share via"));
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    static String zzaG(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder sb = new StringBuilder();
        Map<String, String> zze = zzr.zzbC().zze(build);
        for (String next : zze.keySet()) {
            sb.append(next).append(" = ").append(zze.get(next)).append("\n\n");
        }
        String trim = sb.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, float f, float f2) {
        if (i == 0) {
            this.mState = 0;
            this.zzMi = f;
            this.zzMj = f2;
            this.zzMk = f2;
        } else if (this.mState == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.zzMj) {
                    this.zzMj = f2;
                } else if (f2 < this.zzMk) {
                    this.zzMk = f2;
                }
                if (this.zzMj - this.zzMk > 30.0f * this.zzDB) {
                    this.mState = -1;
                    return;
                }
                if (this.mState == 0 || this.mState == 2) {
                    if (f - this.zzMi >= 50.0f * this.zzDB) {
                        this.zzMi = f;
                        this.mState++;
                    }
                } else if ((this.mState == 1 || this.mState == 3) && f - this.zzMi <= -50.0f * this.zzDB) {
                    this.zzMi = f;
                    this.mState++;
                }
                if (this.mState == 1 || this.mState == 3) {
                    if (f > this.zzMi) {
                        this.zzMi = f;
                    }
                } else if (this.mState == 2 && f < this.zzMi) {
                    this.zzMi = f;
                }
            } else if (i == 1 && this.mState == 4) {
                showDialog();
            }
        }
    }

    public void zzaF(String str) {
        this.zzMh = str;
    }

    public void zze(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }
}
