package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzUJ, zzUI);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final Api.zzc<GamesClientImpl> zzUI = new Api.zzc<>();
    private static final Api.zza<GamesClientImpl, GamesOptions> zzUJ = new GamesClientBuilder() {
        /* renamed from: zza */
        public List<Scope> zzo(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }
    };
    public static final Videos zzaCA = new VideosImpl();
    public static final Acls zzaCB = new AclsImpl();
    private static final Api.zza<GamesClientImpl, GamesOptions> zzaCv = new GamesClientBuilder() {
        /* renamed from: zza */
        public List<Scope> zzo(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzaCw);
        }
    };
    public static final Scope zzaCw = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzaCx = new Api<>("Games.API_1P", zzaCv, zzUI);
    public static final AppContents zzaCy = new AppContentsImpl();
    public static final Multiplayer zzaCz = new MultiplayerImpl();

    /* renamed from: com.google.android.gms.games.Games$3  reason: invalid class name */
    static final class AnonymousClass3 extends GetTokenImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<GetTokenResult>) this);
        }
    }

    /* renamed from: com.google.android.gms.games.Games$6  reason: invalid class name */
    static final class AnonymousClass6 extends BaseGamesApiMethodImpl<LoadExperimentsResult> {
        /* access modifiers changed from: protected */
        /* renamed from: zzW */
        public LoadExperimentsResult zzc(final Status status) {
            return new LoadExperimentsResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zza.C0030zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzUI, googleApiClient);
        }
    }

    private static abstract class GamesClientBuilder extends Api.zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf zzf, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class GamesOptions implements Api.ApiOptions.Optional {
        public final boolean zzaCE;
        public final boolean zzaCF;
        public final int zzaCG;
        public final boolean zzaCH;
        public final int zzaCI;
        public final String zzaCJ;
        public final ArrayList<String> zzaCK;
        public final boolean zzaCL;

        public static final class Builder {
            boolean zzaCE;
            boolean zzaCF;
            int zzaCG;
            boolean zzaCH;
            int zzaCI;
            String zzaCJ;
            ArrayList<String> zzaCK;
            boolean zzaCL;

            private Builder() {
                this.zzaCE = false;
                this.zzaCF = true;
                this.zzaCG = 17;
                this.zzaCH = false;
                this.zzaCI = 4368;
                this.zzaCJ = null;
                this.zzaCK = new ArrayList<>();
                this.zzaCL = false;
            }

            public GamesOptions build() {
                return new GamesOptions(this);
            }

            public Builder setRequireGooglePlus(boolean z) {
                this.zzaCL = z;
                return this;
            }

            public Builder setSdkVariant(int i) {
                this.zzaCI = i;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zzaCF = z;
                this.zzaCG = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int i) {
                this.zzaCF = z;
                this.zzaCG = i;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaCE = false;
            this.zzaCF = true;
            this.zzaCG = 17;
            this.zzaCH = false;
            this.zzaCI = 4368;
            this.zzaCJ = null;
            this.zzaCK = new ArrayList<>();
            this.zzaCL = false;
        }

        private GamesOptions(Builder builder) {
            this.zzaCE = builder.zzaCE;
            this.zzaCF = builder.zzaCF;
            this.zzaCG = builder.zzaCG;
            this.zzaCH = builder.zzaCH;
            this.zzaCI = builder.zzaCI;
            this.zzaCJ = builder.zzaCJ;
            this.zzaCK = builder.zzaCK;
            this.zzaCL = builder.zzaCL;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzvD() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzaCE);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaCF);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaCG);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaCH);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaCI);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaCJ);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaCK);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzaCL);
            return bundle;
        }
    }

    private static abstract class GetServerAuthCodeImpl extends BaseGamesApiMethodImpl<GetServerAuthCodeResult> {
        private GetServerAuthCodeImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzX */
        public GetServerAuthCodeResult zzc(final Status status) {
            return new GetServerAuthCodeResult() {
                public String getCode() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {
        /* renamed from: zzY */
        public GetTokenResult zzc(final Status status) {
            return new GetTokenResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public interface GetTokenResult extends Result {
    }

    public interface LoadExperimentsResult extends Result {
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient googleApiClient) {
        return zzh(googleApiClient).zzwK();
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zzh(googleApiClient).zzww();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, final String str) {
        zzx.zzh(str, "Please provide a valid serverClientId");
        return googleApiClient.zzb(new GetServerAuthCodeImpl(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(str, (zza.zzb<GetServerAuthCodeResult>) this);
            }
        });
    }

    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zzh(googleApiClient).zzwJ();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zzh(googleApiClient).zzwI();
    }

    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzgs(i);
        }
    }

    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        zzx.zzz(view);
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzo(view);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new SignOutImpl(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza((Api<?>) API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        } else if (hasConnectedApi) {
            return (GamesClientImpl) googleApiClient.zza(zzUI);
        } else {
            return null;
        }
    }

    public static GamesClientImpl zzh(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
