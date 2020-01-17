package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzqz implements People {

    private static abstract class zza extends Plus.zza<People.LoadPeopleResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzbg */
        public People.LoadPeopleResult zzc(final Status status) {
            return new People.LoadPeopleResult() {
                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzFa();
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> collection) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza((zza.zzb<People.LoadPeopleResult>) this, (Collection<String>) collection);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... strArr) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzd(this, strArr);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzp(this);
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int i, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zza(zze.zza(this, i, str));
            }
        });
    }

    @SuppressLint({"MissingRemoteException"})
    public PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zza(zze.zzq(this, str));
            }
        });
    }
}
