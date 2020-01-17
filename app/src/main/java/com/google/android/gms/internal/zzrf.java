package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzrd;
import java.util.List;

public class zzrf extends zzj<zzrd> {
    private final Context mContext;

    public zzrf(Context context, Looper looper, zzf zzf, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
    }

    private String zznn() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                return null;
            }
            return (String) bundle.get("com.google.android.safetynet.API_KEY");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public void zza(zzrc zzrc, List<Integer> list, int i, String str) throws RemoteException {
        int[] iArr = new int[list.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                iArr[i3] = list.get(i3).intValue();
                i2 = i3 + 1;
            } else {
                ((zzrd) zzqJ()).zza(zzrc, zznn(), iArr, i, str);
                return;
            }
        }
    }

    public void zza(zzrc zzrc, byte[] bArr) throws RemoteException {
        ((zzrd) zzqJ()).zza(zzrc, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdW */
    public zzrd zzW(IBinder iBinder) {
        return zzrd.zza.zzdV(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.safetynet.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }
}
