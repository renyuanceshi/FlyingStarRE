package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1  reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzaGC, true);
        }

        /* renamed from: zzao */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2  reason: invalid class name */
    class AnonymousClass2 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzaGC, false);
        }

        /* renamed from: zzao */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3  reason: invalid class name */
    class AnonymousClass3 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusLoadResult> {
        final /* synthetic */ String zzaGC;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzaGC);
        }

        /* renamed from: zzap */
        public Notifications.GameMuteStatusLoadResult zzc(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4  reason: invalid class name */
    class AnonymousClass4 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaFO;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zza.zzb<Notifications.ContactSettingLoadResult>) this, this.zzaFO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5  reason: invalid class name */
    class AnonymousClass5 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzaGG;
        final /* synthetic */ Bundle zzaGH;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Status>) this, this.zzaGG, this.zzaGH);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6  reason: invalid class name */
    class AnonymousClass6 extends InboxCountImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        /* renamed from: zzaq */
        public Notifications.ContactSettingLoadResult zzc(final Status status) {
            return new Notifications.ContactSettingLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        /* renamed from: zzar */
        public Notifications.InboxCountResult zzc(final Status status) {
            return new Notifications.InboxCountResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void clear(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzgt(i);
        }
    }

    public void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 31);
    }
}
