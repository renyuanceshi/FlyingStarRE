package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzqy implements Moments {

    private static abstract class zza extends Plus.zza<Moments.LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzbf */
        public Moments.LoadMomentsResult zzc(final Status status) {
            return new Moments.LoadMomentsResult() {
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class zzb extends Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzo(this);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
        final int i2 = i;
        final String str4 = str;
        final Uri uri2 = uri;
        final String str5 = str2;
        final String str6 = str3;
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza(this, i2, str4, uri2, str5, str6);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzfG(str);
                zza(Status.zzagC);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza((zza.zzb<Status>) this, moment);
            }
        });
    }
}
