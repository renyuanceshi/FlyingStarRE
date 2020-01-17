package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;

public class zzpn extends zzj<zzpp> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzVa;
    private zza zzaMC;

    public static final class zza extends zzpo.zza {
        private Activity mActivity;
        private final int zzagz;

        public zza(int i, Activity activity) {
            this.zzagz = i;
            this.mActivity = activity;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzh(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.mActivity.createPendingResult(this.zzagz, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (PendingIntent.CanceledException e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                    }
                }
            } else {
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this.mActivity, this.zzagz);
                    } catch (IntentSender.SendIntentException e2) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    }
                } else {
                    try {
                        PendingIntent createPendingResult2 = this.mActivity.createPendingResult(this.zzagz, new Intent(), 1073741824);
                        if (createPendingResult2 != null) {
                            createPendingResult2.send(1);
                        }
                    } catch (PendingIntent.CanceledException e3) {
                        Log.w("AddressClientImpl", "Exception setting pending result", e3);
                    }
                }
            }
        }
    }

    public zzpn(Activity activity, Looper looper, zzf zzf, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzVa = zzf.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzaMC != null) {
            this.zzaMC.setActivity((Activity) null);
            this.zzaMC = null;
        }
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzyx();
        this.zzaMC = new zza(i, this.mActivity);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzVa)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzVa, "com.google"));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzyw().zza(this.zzaMC, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_ERROR_CODE, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzaMC.zzh(1, bundle2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzca */
    public zzpp zzW(IBinder iBinder) {
        return zzpp.zza.zzcc(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.identity.service.BIND";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public boolean zzqK() {
        return true;
    }

    /* access modifiers changed from: protected */
    public zzpp zzyw() throws DeadObjectException {
        return (zzpp) super.zzqJ();
    }

    /* access modifiers changed from: protected */
    public void zzyx() {
        super.zzqI();
    }
}
