package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzsf extends zzg<zzsa> {
    private static zzsf zzbqD;

    protected zzsf() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzsf zzIq() {
        if (zzbqD == null) {
            zzbqD = new zzsf();
        }
        return zzbqD;
    }

    public static zzrx zza(Activity activity, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzry zzry) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzsa) zzIq().zzaB(activity)).zza(zze.zzC(activity), zzc, walletFragmentOptions, zzry);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (zzg.zza e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzeq */
    public zzsa zzd(IBinder iBinder) {
        return zzsa.zza.zzem(iBinder);
    }
}
