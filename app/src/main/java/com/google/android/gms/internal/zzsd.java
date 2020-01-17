package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

@SuppressLint({"MissingRemoteException"})
public class zzsd implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        final String str3 = str;
        final String str4 = str2;
        final int i2 = i;
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zzf(str3, str4, i2);
                zza(Status.zzagC);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zzln(i);
                zza(Status.zzagC);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zzlo(i);
                zza(Status.zzagC);
            }
        });
    }

    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new Wallet.zza<BooleanResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzA */
            public BooleanResult zzc(Status status) {
                return new BooleanResult(status, false);
            }

            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zza(IsReadyToPayRequest.zzIj().zzIk(), (zza.zzb<BooleanResult>) this);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest fullWalletRequest, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zza(fullWalletRequest, i);
                zza(Status.zzagC);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest maskedWalletRequest, final int i) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zza(maskedWalletRequest, i);
                zza(Status.zzagC);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzse zzse) {
                zzse.zza(notifyTransactionStatusRequest);
                zza(Status.zzagC);
            }
        });
    }
}
