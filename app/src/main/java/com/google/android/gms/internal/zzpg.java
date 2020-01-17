package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzov;
import java.util.concurrent.TimeUnit;

public class zzpg implements SessionsApi {

    private static class zza extends zzou.zza {
        private final zza.zzb<SessionReadResult> zzamC;

        private zza(zza.zzb<SessionReadResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzamC.zzs(sessionReadResult);
        }
    }

    private static class zzb extends zzov.zza {
        private final zza.zzb<SessionStopResult> zzamC;

        private zzb(zza.zzb<SessionStopResult> zzb) {
            this.zzamC = zzb;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzamC.zzs(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zzof.zza<SessionStopResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzO */
            public SessionStopResult zzc(Status status) {
                return SessionStopResult.zzV(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionStopRequest(str, str2, new zzb(this)));
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, final SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza(new zzof.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionInsertRequest(sessionInsertRequest, (zzow) new zzph(this)));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, final SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza(new zzof.zza<SessionReadResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzP */
            public SessionReadResult zzc(Status status) {
                return SessionReadResult.zzU(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionReadRequest(sessionReadRequest, (zzou) new zza(this)));
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, pendingIntent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, final Session session) {
        zzx.zzb(session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionStartRequest(session, new zzph(this)));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, (String) null, str);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionUnregistrationRequest(pendingIntent, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzof zzof) throws RemoteException {
                ((zzoq) zzof.zzqJ()).zza(new SessionRegistrationRequest(pendingIntent, new zzph(this), i));
            }
        });
    }
}
