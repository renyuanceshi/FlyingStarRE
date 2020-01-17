package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;

public final class Address {
    public static final Api<AddressOptions> API = new Api<>("Address.API", zzUJ, zzUI);
    static final Api.zzc<zzpn> zzUI = new Api.zzc<>();
    private static final Api.zza<zzpn, AddressOptions> zzUJ = new Api.zza<zzpn, AddressOptions>() {
        public zzpn zza(Context context, Looper looper, zzf zzf, AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzpn((Activity) context, looper, zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public static final class AddressOptions implements Api.ApiOptions.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int i) {
            this.theme = i;
        }
    }

    private static abstract class zza extends zza.C0030zza<Status, zzpn> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzUI, googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest userAddressRequest, final int i) {
        googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpn zzpn) throws RemoteException {
                zzpn.zza(userAddressRequest, i);
                zza(Status.zzagC);
            }
        });
    }
}
