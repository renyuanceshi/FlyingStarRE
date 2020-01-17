package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;

public final class VideosImpl implements Videos {

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl$1  reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl<Status> {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHU;
        final /* synthetic */ VideoConfiguration zzaHV;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((Games.BaseGamesApiMethodImpl<Status>) this, this.zzaFQ, this.zzaHU, this.zzaHV);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl$2  reason: invalid class name */
    class AnonymousClass2 extends CapabilitiesImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl$3  reason: invalid class name */
    class AnonymousClass3 extends AvailableImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl$4  reason: invalid class name */
    class AnonymousClass4 extends ListImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }

    private static abstract class AvailableImpl extends Games.BaseGamesApiMethodImpl<Videos.VideoAvailableResult> {
        /* renamed from: zzaO */
        public Videos.VideoAvailableResult zzc(final Status status) {
            return new Videos.VideoAvailableResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class CapabilitiesImpl extends Games.BaseGamesApiMethodImpl<Videos.VideoCapabilitiesResult> {
        /* renamed from: zzaP */
        public Videos.VideoCapabilitiesResult zzc(final Status status) {
            return new Videos.VideoCapabilitiesResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ListImpl extends Games.BaseGamesApiMethodImpl<Videos.ListVideosResult> {
        /* renamed from: zzaQ */
        public Videos.ListVideosResult zzc(final Status status) {
            return new Videos.ListVideosResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }
}
