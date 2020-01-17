package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zze extends zzge.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzFC;
    zzh zzFD;
    private zzk zzFF;
    private Context zzFK;
    private zzgc zzFL;
    private zzf zzFM;
    private zzj zzFN;
    private String zzFO = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzFD = zzh.zzy(this.mActivity.getApplicationContext());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int zzd = zzr.zzbM().zzd(intent);
                if (i2 == -1) {
                    zzr.zzbM();
                    if (zzd == 0) {
                        if (this.zzFF.zza(this.zzFO, i2, intent)) {
                            z = true;
                        }
                        this.zzFL.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzFL.getProductId(), z, i2, intent);
                    }
                }
                this.zzFD.zza(this.zzFM);
                this.zzFL.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzFL.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                zzin.zzaK("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzFO = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzFN = zzc.zzFy;
        this.zzFF = zzc.zzrI;
        this.zzFL = zzc.zzFw;
        this.zzFC = new zzb(this.mActivity.getApplicationContext());
        this.zzFK = zzc.zzFx;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
        } else {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.mActivity.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzFC.destroy();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzFC.zzN(iBinder);
        try {
            this.zzFO = this.zzFF.zzfZ();
            Bundle zzb = this.zzFC.zzb(this.mActivity.getPackageName(), this.zzFL.getProductId(), this.zzFO);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzr.zzbM().zzd(zzb);
                this.zzFL.recordPlayBillingResolution(zzd);
                zza(this.zzFL.getProductId(), false, zzd, (Intent) null);
                this.mActivity.finish();
                return;
            }
            this.zzFM = new zzf(this.zzFL.getProductId(), this.zzFO);
            this.zzFD.zzb(this.zzFM);
            Integer num = 0;
            Integer num2 = 0;
            Integer num3 = 0;
            this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
        } catch (IntentSender.SendIntentException | RemoteException e) {
            zzin.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzFN != null) {
            this.zzFN.zza(str, z, i, intent, this.zzFM);
        }
    }
}
