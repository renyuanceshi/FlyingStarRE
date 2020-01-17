package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zze;
import com.google.android.gms.common.api.internal.zzf;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GamesClientImpl extends zzj<IGamesService> {
    EventIncrementManager zzaDZ = new EventIncrementManager() {
        public EventIncrementCache zzwS() {
            return new GameClientEventIncrementCache();
        }
    };
    private final String zzaEa;
    private PlayerEntity zzaEb;
    private GameEntity zzaEc;
    private final PopupManager zzaEd;
    private boolean zzaEe = false;
    private final Binder zzaEf;
    private final long zzaEg;
    private final Games.GamesOptions zzaEh;

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzaEj = new ArrayList<>();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            for (String add : strArr) {
                this.zzaEj.add(add);
            }
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaEj);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zze<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzY(dataHolder), dataHolder.getStatusCode());
        }

        /* access modifiers changed from: protected */
        public abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zze<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzY(dataHolder));
        }

        /* access modifiers changed from: protected */
        public abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements Quests.AcceptQuestResult {
        private final Quest zzaEk;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaEk = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.UpdateAchievementResult> zzamC;

        AchievementUpdatedBinderCallback(zza.zzb<Achievements.UpdateAchievementResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzamC.zzs(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.LoadAchievementsResult> zzamC;

        AchievementsLoadedBinderCallback(zza.zzb<Achievements.LoadAchievementsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AppContents.LoadAppContentResult> zzaEl;

        public AppContentLoadedBinderCallbacks(zza.zzb<AppContents.LoadAppContentResult> zzb) {
            this.zzaEl = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaEl.zzs(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzUX;
        private final String zzaEm;

        CancelMatchResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzaEm = str;
        }

        public String getMatchId() {
            return this.zzaEm;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements Quests.ClaimMilestoneResult {
        private final Quest zzaEk;
        private final Milestone zzaEn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                    List<Milestone> zzxR = this.zzaEk.zzxR();
                    int size = zzxR.size();
                    for (int i = 0; i < size; i++) {
                        if (zzxR.get(i).getMilestoneId().equals(str)) {
                            this.zzaEn = zzxR.get(i);
                            return;
                        }
                    }
                    this.zzaEn = null;
                } else {
                    this.zzaEn = null;
                    this.zzaEk = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaEn;
        }

        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzaEo;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaEo = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaEo = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaEo;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.ContactSettingLoadResult> zzamC;

        ContactSettingsLoadedBinderCallback(zza.zzb<Notifications.ContactSettingLoadResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzamC.zzs(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzgo(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
        private final Status zzUX;
        private final String zzaEp;

        DeleteSnapshotResultImpl(int i, String str) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaEp = str;
        }

        public String getSnapshotId() {
            return this.zzaEp;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Events.LoadEventsResult> zzamC;

        EventsLoadedBinderCallback(zza.zzb<Events.LoadEventsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExperimentsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Games.LoadExperimentsResult> zzamC;

        ExperimentsLoadedBinderCallback(zza.zzb<Games.LoadExperimentsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(int i, long[] jArr) {
            this.zzamC.zzs(new LoadExperimentsResultImpl(i, jArr));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        /* access modifiers changed from: protected */
        public void zzs(String str, int i) {
            try {
                if (GamesClientImpl.this.isConnected()) {
                    ((IGamesService) GamesClientImpl.this.zzqJ()).zzp(str, i);
                } else {
                    GamesLog.zzA("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesClientImpl.this.zzb(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameInstancesResult> zzamC;

        GameInstancesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameInstancesResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaEq = str;
            this.zzaEr = z;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusChangeResult> zzamC;

        GameMuteStatusChangedBinderCallback(zza.zzb<Notifications.GameMuteStatusChangeResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzamC.zzs(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzUX = GamesStatusCodes.zzgc(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaEq = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzaEr = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaEq = null;
                    this.zzaEr = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusLoadResult> zzamC;

        GameMuteStatusLoadedBinderCallback(zza.zzb<Notifications.GameMuteStatusLoadResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzamC.zzs(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzamC;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static abstract class GamesDataHolderResult extends zzf {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzgc(dataHolder.getStatusCode()));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGamesResult> zzamC;

        GamesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGamesResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Games.GetTokenResult> zzamC;

        public GetAuthTokenBinderCallbacks(zza.zzb<Games.GetTokenResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetTokenResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class GetServerAuthCodeBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Games.GetServerAuthCodeResult> zzamC;

        public GetServerAuthCodeBinderCallbacks(zza.zzb<Games.GetServerAuthCodeResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetServerAuthCodeResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class GetServerAuthCodeResultImpl implements Games.GetServerAuthCodeResult {
        private final Status zzUX;
        private final String zzaEs;

        GetServerAuthCodeResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzaEs = str;
        }

        public String getCode() {
            return this.zzaEs;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GetTokenResultImpl implements Games.GetTokenResult {
        private final Status zzUX;
        private final String zzVo;

        GetTokenResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzVo = str;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
        private final Status zzUX;
        private final Bundle zzaEt;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEt = bundle;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.InboxCountResult> zzamC;

        InboxCountsLoadedBinderCallback(zza.zzb<Notifications.InboxCountResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new InboxCountResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnInvitationReceivedListener> zzari;

        InvitationReceivedBinderCallback(zzq<OnInvitationReceivedListener> zzq) {
            this.zzari = zzq;
        }

        public void onInvitationRemoved(String str) {
            this.zzari.zza(new InvitationRemovedNotifier(str));
        }

        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                if (invitation != null) {
                    this.zzari.zza(new InvitationReceivedNotifier(invitation));
                }
            } finally {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzq.zzb<OnInvitationReceivedListener> {
        private final Invitation zzaEu;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaEu = invitation;
        }

        /* renamed from: zza */
        public void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaEu);
        }

        public void zzpr() {
        }
    }

    private static final class InvitationRemovedNotifier implements zzq.zzb<OnInvitationReceivedListener> {
        private final String zzUO;

        InvitationRemovedNotifier(String str) {
            this.zzUO = str;
        }

        /* renamed from: zza */
        public void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzUO);
        }

        public void zzpr() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Invitations.LoadInvitationsResult> zzamC;

        InvitationsLoadedBinderCallback(zza.zzb<Invitations.LoadInvitationsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaEv;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEv = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzaEv;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadScoresResult> zzamC;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<Leaderboards.LoadScoresResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzamC.zzs(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LeaderboardMetadataResult> zzamC;

        LeaderboardsLoadedBinderCallback(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzamC.zzs(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements zzq.zzb<RoomUpdateListener> {
        private final String zzaEw;
        private final int zzade;

        LeftRoomNotifier(int i, String str) {
            this.zzade = i;
            this.zzaEw = str;
        }

        /* renamed from: zza */
        public void zzt(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzade, this.zzaEw);
        }

        public void zzpr() {
        }
    }

    private static final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.ListVideosResult> zzamC;

        ListVideosBinderCallback(zza.zzb<Videos.ListVideosResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzX(DataHolder dataHolder) {
            this.zzamC.zzs(new ListVideosResultImpl(dataHolder));
        }
    }

    public static final class ListVideosResultImpl extends GamesDataHolderResult implements Videos.ListVideosResult {
        private final VideoBuffer zzaEx;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEx = new VideoBuffer(dataHolder);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzaEy;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEy = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaEy;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements AppContents.LoadAppContentResult {
        private final ArrayList<DataHolder> zzaEz;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.zzaEz = new ArrayList<>(Arrays.asList(dataHolderArr));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements Events.LoadEventsResult {
        private final EventBuffer zzaEA;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEA = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaEA;
        }
    }

    private static final class LoadExperimentsResultImpl implements Games.LoadExperimentsResult {
        private final Status zzUX;
        private final Set<Long> zzaEB = new HashSet();

        LoadExperimentsResultImpl(int i, long[] jArr) {
            this.zzUX = new Status(i);
            for (long valueOf : jArr) {
                this.zzaEB.add(Long.valueOf(valueOf));
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameInstancesResult {
        private final GameInstanceBuffer zzaEC;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEC = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaED;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaED = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzaEE;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEE = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaEE;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzaEF;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEF = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaEF;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzUX;
        private final LoadMatchesResponse zzaEG;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEG = new LoadMatchesResponse(bundle);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaEG;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            this.zzaEG.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaEH;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaEH = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaEH = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaEH;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements Stats.LoadPlayerStatsResult {
        private final PlayerStats zzaEI;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaEI = new PlayerStatsEntity(playerStatsBuffer.get(0));
                } else {
                    this.zzaEI = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        public PlayerStats getPlayerStats() {
            return this.zzaEI;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements Players.LoadPlayersResult {
        private final PlayerBuffer zzaEJ;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEJ = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaEJ;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements Players.LoadProfileSettingsResult {
        private final boolean zzaEK;
        private final boolean zzsj;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbH = dataHolder.zzbH(0);
                    this.zzsj = dataHolder.zze("profile_visible", 0, zzbH);
                    this.zzaEK = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbH);
                } else {
                    this.zzsj = true;
                    this.zzaEK = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements Quests.LoadQuestsResult {
        private final DataHolder zzahi;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzahi = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzahi);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
        private final Status zzUX;
        private final Bundle zzaEL;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEL = bundle;
        }

        public GameRequestBuffer getRequests(int i) {
            String zzgw = RequestType.zzgw(i);
            if (!this.zzaEL.containsKey(zzgw)) {
                return null;
            }
            return new GameRequestBuffer((DataHolder) this.zzaEL.get(zzgw));
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            for (String parcelable : this.zzaEL.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaEL.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzaEM;
        private final LeaderboardScoreBuffer zzaEN;

        /* JADX INFO: finally extract failed */
        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaEM = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaEM = null;
                }
                leaderboardBuffer.release();
                this.zzaEN = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaEM;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaEN;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzahi);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
        private final Status zzUX;
        private final List<String> zzaEO;
        private final Bundle zzaEP;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEO = bundle.getStringArrayList("game_category_list");
            this.zzaEP = bundle;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements Players.LoadXpStreamResult {
        private final ExperienceEventBuffer zzaEQ;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEQ = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements zzq.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaER;

        MatchRemovedNotifier(String str) {
            this.zzaER = str;
        }

        /* renamed from: zza */
        public void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaER);
        }

        public void zzpr() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnTurnBasedMatchUpdateReceivedListener> zzari;

        MatchUpdateReceivedBinderCallback(zzq<OnTurnBasedMatchUpdateReceivedListener> zzq) {
            this.zzari = zzq;
        }

        public void onTurnBasedMatchRemoved(String str) {
            this.zzari.zza(new MatchRemovedNotifier(str));
        }

        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                if (turnBasedMatch != null) {
                    this.zzari.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzq.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaES;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.zzaES = turnBasedMatch;
        }

        /* renamed from: zza */
        public void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaES);
        }

        public void zzpr() {
        }
    }

    private static final class MessageReceivedNotifier implements zzq.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaET;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.zzaET = realTimeMessage;
        }

        /* renamed from: zza */
        public void zzt(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaET);
        }

        public void zzpr() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzq.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaEU;

        /* renamed from: zza */
        public void zzt(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaEU);
        }

        public void zzpr() {
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Acls.LoadAclResult> zzamC;

        NotifyAclLoadedBinderCallback(zza.zzb<Acls.LoadAclResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzgn(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.OpenSnapshotResult {
        private final Snapshot zzaEV;
        private final String zzaEW;
        private final Snapshot zzaEX;
        private final Contents zzaEY;
        private final SnapshotContents zzaEZ;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents contents) {
            this(dataHolder, (String) null, contents, (Contents) null, (Contents) null);
        }

        /* JADX INFO: finally extract failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        OpenSnapshotResultImpl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            boolean z = false;
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaEV = null;
                    this.zzaEX = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    zzb.zzab(dataHolder.getStatusCode() != 4004 ? true : z);
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaEX = null;
                } else {
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaEX = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                }
                snapshotMetadataBuffer.release();
                this.zzaEW = str;
                this.zzaEY = contents3;
                this.zzaEZ = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        public String getConflictId() {
            return this.zzaEW;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaEX;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaEZ;
        }

        public Snapshot getSnapshot() {
            return this.zzaEV;
        }
    }

    private static final class P2PConnectedNotifier implements zzq.zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PConnectedNotifier(String str) {
            this.zzaFa = str;
        }

        /* renamed from: zza */
        public void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaFa);
        }

        public void zzpr() {
        }
    }

    private static final class P2PDisconnectedNotifier implements zzq.zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PDisconnectedNotifier(String str) {
            this.zzaFa = str;
        }

        /* renamed from: zza */
        public void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaFa);
        }

        public void zzpr() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadPlayerScoreResult> zzamC;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<Leaderboards.LoadPlayerScoreResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Stats.LoadPlayerStatsResult> zzamC;

        public PlayerStatsLoadedBinderCallbacks(zza.zzb<Stats.LoadPlayerStatsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzW(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpForGameCategoriesResult> zzamC;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<Players.LoadXpForGameCategoriesResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpStreamResult> zzamC;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<Players.LoadXpStreamResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadPlayersResult> zzamC;

        PlayersLoadedBinderCallback(zza.zzb<Players.LoadPlayersResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzm(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaEd;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaEd = popupManager;
        }

        public PopupLocationInfoParcelable zzws() {
            return new PopupLocationInfoParcelable(this.zzaEd.zzxk());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadProfileSettingsResult> zzamC;

        ProfileSettingsLoadedBinderCallback(zza.zzb<Players.LoadProfileSettingsResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzV(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzgp(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.AcceptQuestResult> zzaFb;

        public QuestAcceptedBinderCallbacks(zza.zzb<Quests.AcceptQuestResult> zzb) {
            this.zzaFb = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzaFb.zzs(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements zzq.zzb<QuestUpdateListener> {
        private final Quest zzaEk;

        QuestCompletedNotifier(Quest quest) {
            this.zzaEk = quest;
        }

        /* renamed from: zza */
        public void zzt(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaEk);
        }

        public void zzpr() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.ClaimMilestoneResult> zzaFc;
        private final String zzaFd;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<Quests.ClaimMilestoneResult> zzb, String str) {
            this.zzaFc = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
            this.zzaFd = (String) zzx.zzb(str, (Object) "MilestoneId must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzaFc.zzs(new ClaimMilestoneResultImpl(dataHolder, this.zzaFd));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzq<QuestUpdateListener> zzari;

        QuestUpdateBinderCallback(zzq<QuestUpdateListener> zzq) {
            this.zzari = zzq;
        }

        private Quest zzaa(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                return quest;
            } finally {
                questBuffer.release();
            }
        }

        public void zzR(DataHolder dataHolder) {
            Quest zzaa = zzaa(dataHolder);
            if (zzaa != null) {
                this.zzari.zza(new QuestCompletedNotifier(zzaa));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.LoadQuestsResult> zzaFe;

        public QuestsLoadedBinderCallbacks(zza.zzb<Quests.LoadQuestsResult> zzb) {
            this.zzaFe = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzaFe.zzs(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzq.zzb<RealTimeMultiplayer.ReliableMessageSentCallback> {
        private final String zzaFf;
        private final int zzaFg;
        private final int zzade;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.zzade = i;
            this.zzaFg = i2;
            this.zzaFf = str;
        }

        /* renamed from: zza */
        public void zzt(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzade, this.zzaFg, this.zzaFf);
            }
        }

        public void zzpr() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzq<RealTimeMultiplayer.ReliableMessageSentCallback> zzaFh;

        public RealTimeReliableMessageBinderCallbacks(zzq<RealTimeMultiplayer.ReliableMessageSentCallback> zzq) {
            this.zzaFh = zzq;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzaFh != null) {
                this.zzaFh.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnRequestReceivedListener> zzari;

        RequestReceivedBinderCallback(zzq<OnRequestReceivedListener> zzq) {
            this.zzari = zzq;
        }

        public void onRequestRemoved(String str) {
            this.zzari.zza(new RequestRemovedNotifier(str));
        }

        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                if (gameRequest != null) {
                    this.zzari.zza(new RequestReceivedNotifier(gameRequest));
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestReceivedNotifier implements zzq.zzb<OnRequestReceivedListener> {
        private final GameRequest zzaFi;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.zzaFi = gameRequest;
        }

        /* renamed from: zza */
        public void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaFi);
        }

        public void zzpr() {
        }
    }

    private static final class RequestRemovedNotifier implements zzq.zzb<OnRequestReceivedListener> {
        private final String zzEY;

        RequestRemovedNotifier(String str) {
            this.zzEY = str;
        }

        /* renamed from: zza */
        public void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzEY);
        }

        public void zzpr() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.SendRequestResult> zzaFj;

        public RequestSentBinderCallbacks(zza.zzb<Requests.SendRequestResult> zzb) {
            this.zzaFj = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaFj.zzs(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestSummariesResult> zzaFk;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestSummariesResult> zzb) {
            this.zzaFk = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzaFk.zzs(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestsResult> zzaFl;

        public RequestsLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestsResult> zzb) {
            this.zzaFl = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFl.zzs(new LoadRequestsResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.UpdateRequestsResult> zzaFm;

        public RequestsUpdatedBinderCallbacks(zza.zzb<Requests.UpdateRequestsResult> zzb) {
            this.zzaFm = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaFm.zzs(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzq<? extends RoomUpdateListener> zzaFn;
        private final zzq<? extends RoomStatusUpdateListener> zzaFo;
        private final zzq<RealTimeMessageReceivedListener> zzaFp;

        public RoomBinderCallbacks(zzq<RoomUpdateListener> zzq) {
            this.zzaFn = (zzq) zzx.zzb(zzq, (Object) "Callbacks must not be null");
            this.zzaFo = null;
            this.zzaFp = null;
        }

        public RoomBinderCallbacks(zzq<? extends RoomUpdateListener> zzq, zzq<? extends RoomStatusUpdateListener> zzq2, zzq<RealTimeMessageReceivedListener> zzq3) {
            this.zzaFn = (zzq) zzx.zzb(zzq, (Object) "Callbacks must not be null");
            this.zzaFo = zzq2;
            this.zzaFp = zzq3;
        }

        public void onLeftRoom(int i, String str) {
            this.zzaFn.zza(new LeftRoomNotifier(i, str));
        }

        public void onP2PConnected(String str) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PConnectedNotifier(str));
            }
        }

        public void onP2PDisconnected(String str) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PDisconnectedNotifier(str));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.zzaFp != null) {
                this.zzaFp.zza(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        public void zzA(DataHolder dataHolder) {
            this.zzaFn.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzB(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzE(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzF(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzz(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements Requests.SendRequestResult {
        private final GameRequest zzaFi;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaFi = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaFi = null;
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzwr() {
            this.zzamC.zzs(GamesStatusCodes.zzgc(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.CommitSnapshotResult> zzaFq;

        public SnapshotCommittedBinderCallbacks(zza.zzb<Snapshots.CommitSnapshotResult> zzb) {
            this.zzaFq = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaFq.zzs(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.DeleteSnapshotResult> zzamC;

        public SnapshotDeletedBinderCallbacks(zza.zzb<Snapshots.DeleteSnapshotResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzj(int i, String str) {
            this.zzamC.zzs(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.OpenSnapshotResult> zzaFr;

        public SnapshotOpenedBinderCallbacks(zza.zzb<Snapshots.OpenSnapshotResult> zzb) {
            this.zzaFr = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.LoadSnapshotsResult> zzaFs;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<Snapshots.LoadSnapshotsResult> zzb) {
            this.zzaFs = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzaFs.zzs(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class StartRecordingBinderCallback extends AbstractGamesCallbacks {
        private final Games.BaseGamesApiMethodImpl<Status> zzaFt;

        StartRecordingBinderCallback(Games.BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl) {
            this.zzaFt = (Games.BaseGamesApiMethodImpl) zzx.zzb(baseGamesApiMethodImpl, (Object) "Holder must not be null");
        }

        public void zzgq(int i) {
            this.zzaFt.zza(new Status(i));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.SubmitScoreResult> zzamC;

        public SubmitScoreBinderCallbacks(zza.zzb<Leaderboards.SubmitScoreResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzamC.zzs(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzaFu;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaFu = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzaFu;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzaFv;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzb) {
            this.zzaFv = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzaFv.zzs(new CancelMatchResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzaFw;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb) {
            this.zzaFw = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzaFw.zzs(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzaFx;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzb) {
            this.zzaFx = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzx(DataHolder dataHolder) {
            this.zzaFx.zzs(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzaFy;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzb) {
            this.zzaFy = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzaFy.zzs(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaES;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaES = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaES = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaES;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzaFz;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzb) {
            this.zzaFz = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzw(DataHolder dataHolder) {
            this.zzaFz.zzs(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzaFA;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzb) {
            this.zzaFA = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFA.zzs(new LoadMatchesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
        private final Status zzUX;
        private final String zzaDj;

        UpdateAchievementResultImpl(int i, String str) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaDj = str;
        }

        public String getAchievementId() {
            return this.zzaDj;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements Requests.UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaFB;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaFB = RequestUpdateOutcomes.zzab(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzaFB.getRequestIds();
        }

        public int getRequestOutcome(String str) {
            return this.zzaFB.getRequestOutcome(str);
        }
    }

    public static final class VideoAvailableResultImpl implements Videos.VideoAvailableResult {
        private final Status zzUX;
        private final boolean zzaFC;

        VideoAvailableResultImpl(Status status, boolean z) {
            this.zzUX = status;
            this.zzaFC = z;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static final class VideoCapabilitiesResultImpl implements Videos.VideoCapabilitiesResult {
        private final Status zzUX;
        private final VideoCapabilities zzaFD;

        VideoCapabilitiesResultImpl(Status status, VideoCapabilities videoCapabilities) {
            this.zzUX = status;
            this.zzaFD = videoCapabilities;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class VideoRecordingAvailableBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.VideoAvailableResult> zzamC;

        VideoRecordingAvailableBinderCallback(zza.zzb<Videos.VideoAvailableResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzd(int i, boolean z) {
            this.zzamC.zzs(new VideoAvailableResultImpl(new Status(i), z));
        }
    }

    private static final class VideoRecordingCapabilitiesBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.VideoCapabilitiesResult> zzamC;

        VideoRecordingCapabilitiesBinderCallback(zza.zzb<Videos.VideoCapabilitiesResult> zzb) {
            this.zzamC = (zza.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zza(int i, VideoCapabilities videoCapabilities) {
            this.zzamC.zzs(new VideoCapabilitiesResultImpl(new Status(i), videoCapabilities));
        }
    }

    public GamesClientImpl(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaEa = zzf.zzqv();
        this.zzaEf = new Binder();
        this.zzaEd = PopupManager.zza(this, zzf.zzqr());
        zzo(zzf.zzqx());
        this.zzaEg = (long) hashCode();
        this.zzaEh = gamesOptions;
    }

    /* access modifiers changed from: private */
    public static Room zzY(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            return room;
        } finally {
            roomBuffer.release();
        }
    }

    /* access modifiers changed from: private */
    public void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzwv() {
        this.zzaEb = null;
        this.zzaEc = null;
    }

    public void disconnect() {
        this.zzaEe = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzqJ();
                iGamesService.zzwR();
                this.zzaDZ.flush();
                iGamesService.zzF(this.zzaEg);
            } catch (RemoteException e) {
                GamesLog.zzz("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzaEe = false;
    }

    public int zza(zzq<RealTimeMultiplayer.ReliableMessageSentCallback> zzq, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RealTimeReliableMessageBinderCallbacks(zzq), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb(strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzqJ()).zza(i, bArr, i2, str);
            zzx.zzb(bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzqJ()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzqJ()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzqJ()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaEe = bundle.getBoolean("show_welcome_popup");
            this.zzaEb = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaEc = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(GoogleApiClient.zza zza) {
        zzwv();
        super.zza(zza);
    }

    public void zza(zza.zzb<Invitations.LoadInvitationsResult> zzb, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzb), i);
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzb, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestsLoadedBinderCallbacks(zzb), i, i2, i3);
    }

    public void zza(zza.zzb<AppContents.LoadAppContentResult> zzb, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new AppContentLoadedBinderCallbacks(zzb), i, str, strArr, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzb, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new TurnBasedMatchesLoadedBinderCallbacks(zzb), i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzb, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(zzb), leaderboardScoreBuffer.zzxJ().asBundle(), i, i2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(zzb), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzxP(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<Snapshots.CommitSnapshotResult> zzb, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzxU = snapshotMetadataChange.zzxU();
        if (zzxU != null) {
            zzxU.zzc(getContext().getCacheDir());
        }
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new SnapshotCommittedBinderCallbacks(zzb), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsx);
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(zzb), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        char c = 65535;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((IGamesService) zzqJ()).zzd(new PlayersLoadedBinderCallback(zzb), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzb, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new TurnBasedMatchesLoadedBinderCallbacks(zzb), str, i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.SubmitScoreResult> zzb, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) zzb == null ? null : new SubmitScoreBinderCallbacks(zzb), str, j, str2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new TurnBasedMatchLeftBinderCallbacks(zzb), str, str2);
    }

    public void zza(zza.zzb<Leaderboards.LoadPlayerScoreResult> zzb, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new PlayerLeaderboardScoreLoadedBinderCallback(zzb), str, str2, i, i2);
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzb, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestsLoadedBinderCallbacks(zzb), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzb, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(zzb), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        char c = 65535;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    c = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    c = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                ((IGamesService) zzqJ()).zza((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzb, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzxU = snapshotMetadataChange.zzxU();
        if (zzxU != null) {
            zzxU.zzc(getContext().getCacheDir());
        }
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new SnapshotOpenedBinderCallbacks(zzb), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsx);
    }

    public void zza(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(zzb), str, str2, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzb, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new QuestsLoadedBinderCallbacks(zzb), str, str2, strArr, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzb, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new QuestsLoadedBinderCallbacks(zzb), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<Requests.UpdateRequestsResult> zzb, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(zzb), str, str2, strArr);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzf((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), str, z);
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzb, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new SnapshotOpenedBinderCallbacks(zzb), str, z, i);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzb, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new TurnBasedMatchUpdatedBinderCallbacks(zzb), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzb, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new TurnBasedMatchUpdatedBinderCallbacks(zzb), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<Requests.SendRequestResult> zzb, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestSentBinderCallbacks(zzb), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), z);
    }

    public void zza(zza.zzb<Status> zzb, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new ContactSettingsUpdatedBinderCallback(zzb), z, bundle);
    }

    public void zza(zza.zzb<Events.LoadEventsResult> zzb, boolean z, String... strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new EventsLoadedBinderCallback(zzb), z, strArr);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzb, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new QuestsLoadedBinderCallbacks(zzb), iArr, i, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), strArr);
    }

    public void zza(zzq<OnInvitationReceivedListener> zzq) {
        try {
            ((IGamesService) zzqJ()).zza((IGamesCallbacks) new InvitationReceivedBinderCallback(zzq), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> zzq, zzq<RoomStatusUpdateListener> zzq2, zzq<RealTimeMessageReceivedListener> zzq3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RoomBinderCallbacks(zzq, zzq2, zzq3), (IBinder) this.zzaEf, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> zzq, String str) {
        try {
            ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new RoomBinderCallbacks(zzq), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(Games.BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new StartRecordingBinderCallback(baseGamesApiMethodImpl), str, str2, videoConfiguration);
    }

    public void zza(@NonNull IGamesService iGamesService) {
        super.zza(iGamesService);
        if (this.zzaEe) {
            this.zzaEd.zzxh();
            this.zzaEe = false;
        }
        if (!this.zzaEh.zzaCE) {
            zzb(iGamesService);
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzsx = snapshotContents.zzsx();
        snapshotContents.close();
        try {
            ((IGamesService) zzqJ()).zza(zzsx);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzah(boolean z) {
        if (z && this.zzaEb != null) {
            return this.zzaEb.getPlayerId();
        }
        try {
            return ((IGamesService) zzqJ()).zzwT();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzqJ()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzb(Set<Scope> set) {
        boolean z;
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        boolean z2 = false;
        boolean z3 = false;
        for (Scope next : set) {
            if (next.equals(scope)) {
                z = true;
            } else if (next.equals(scope2)) {
                z = z2;
                z3 = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (z3) {
            zzx.zza(!z2, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z2, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) zzb == null ? null : new AchievementUpdatedBinderCallback(zzb), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzb, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new LeaderboardScoresLoadedBinderCallback(zzb), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzb, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), str, i, z, z2);
    }

    public void zzb(zza.zzb<Quests.ClaimMilestoneResult> zzb, String str, String str2) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf((IGamesCallbacks) new QuestMilestoneClaimBinderCallbacks(zzb, str2), str, str2);
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzb, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb(new LeaderboardScoresLoadedBinderCallback(zzb), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzb, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.LoadAchievementsResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new AchievementsLoadedBinderCallback(zzb), str, str2, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(zzb), str, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(zzb), z);
    }

    public void zzb(zza.zzb<Quests.LoadQuestsResult> zzb, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new QuestsLoadedBinderCallbacks(zzb), strArr, z);
    }

    public void zzb(zza.zzb<Requests.UpdateRequestsResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(zzb), strArr);
    }

    public void zzb(zzq<OnTurnBasedMatchUpdateReceivedListener> zzq) {
        try {
            ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new MatchUpdateReceivedBinderCallback(zzq), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzq<RoomUpdateListener> zzq, zzq<RoomStatusUpdateListener> zzq2, zzq<RealTimeMessageReceivedListener> zzq3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RoomBinderCallbacks(zzq, zzq2, zzq3), (IBinder) this.zzaEf, roomConfig.getInvitationId(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(IGamesService iGamesService) {
        try {
            iGamesService.zza((IGamesClient) new PopupLocationInfoBinderCallbacks(this.zzaEd), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(String str, zza.zzb<Games.GetServerAuthCodeResult> zzb) throws RemoteException {
        zzx.zzh(str, "Please provide a valid serverClientId");
        ((IGamesService) zzqJ()).zza(str, (IGamesCallbacks) new GetServerAuthCodeBinderCallbacks(zzb));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbV */
    public IGamesService zzW(IBinder iBinder) {
        return IGamesService.Stub.zzbY(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zza.zzb<Players.LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str);
    }

    public void zzc(zza.zzb<Players.LoadXpStreamResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new PlayerXpStreamLoadedBinderCallback(zzb), str, i);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zzd((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(zzb), str, str2);
    }

    public void zzc(zza.zzb<Snapshots.LoadSnapshotsResult> zzb, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new SnapshotsLoadedBinderCallbacks(zzb), str, str2, z);
    }

    public void zzc(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzd((IGamesCallbacks) new LeaderboardsLoadedBinderCallback(zzb), str, z);
    }

    public void zzc(zza.zzb<Achievements.LoadAchievementsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new AchievementsLoadedBinderCallback(zzb), z);
    }

    public void zzc(zza.zzb<Requests.UpdateRequestsResult> zzb, String[] strArr) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new RequestsUpdatedBinderCallbacks(zzb), strArr);
    }

    public void zzc(zzq<QuestUpdateListener> zzq) {
        try {
            ((IGamesService) zzqJ()).zzd((IGamesCallbacks) new QuestUpdateBinderCallback(zzq), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zza.zzb<Games.GetTokenResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzk(new GetAuthTokenBinderCallbacks(zzb));
    }

    public void zzd(zza.zzb<Players.LoadPlayersResult> zzb, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqJ()).zze(new PlayersLoadedBinderCallback(zzb), i, z, z2);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzb), str);
    }

    public void zzd(zza.zzb<Players.LoadXpStreamResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new PlayerXpStreamLoadedBinderCallback(zzb), str, i);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzb, String str, String str2) throws RemoteException {
        ((IGamesService) zzqJ()).zze((IGamesCallbacks) new TurnBasedMatchInitiatedBinderCallbacks(zzb), str, str2);
    }

    public void zzd(zza.zzb<Notifications.GameMuteStatusChangeResult> zzb, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new GameMuteStatusChangedBinderCallback(zzb), str, z);
    }

    public void zzd(zza.zzb<Events.LoadEventsResult> zzb, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf((IGamesCallbacks) new EventsLoadedBinderCallback(zzb), z);
    }

    public void zzd(zzq<OnRequestReceivedListener> zzq) {
        try {
            ((IGamesService) zzqJ()).zzc((IGamesCallbacks) new RequestReceivedBinderCallback(zzq), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzdH(String str) {
        try {
            ((IGamesService) zzqJ()).zzdP(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzdI(String str) {
        try {
            return ((IGamesService) zzqJ()).zzdI(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzdJ(String str) {
        try {
            ((IGamesService) zzqJ()).zza(str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zza.zzb<GamesMetadata.LoadGamesResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzd(new GamesLoadedBinderCallback(zzb));
    }

    public void zze(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzo(new TurnBasedMatchLeftBinderCallbacks(zzb), str);
    }

    public void zze(zza.zzb<Invitations.LoadInvitationsResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzb), str, i, false);
    }

    public void zze(zza.zzb<Stats.LoadPlayerStatsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzi((IGamesCallbacks) new PlayerStatsLoadedBinderCallbacks(zzb), z);
    }

    public void zzf(zza.zzb<Status> zzb) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new SignOutCompleteBinderCallbacks(zzb));
    }

    public void zzf(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzn(new TurnBasedMatchCanceledBinderCallbacks(zzb), str);
    }

    public void zzf(zza.zzb<Requests.LoadRequestSummariesResult> zzb, String str, int i) throws RemoteException {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestSummariesLoadedBinderCallbacks(zzb), str, i);
    }

    public void zzf(zza.zzb<Snapshots.LoadSnapshotsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzd((IGamesCallbacks) new SnapshotsLoadedBinderCallbacks(zzb), z);
    }

    public void zzg(zza.zzb<Videos.VideoCapabilitiesResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzm(new VideoRecordingCapabilitiesBinderCallback(zzb));
    }

    public void zzg(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzp((IGamesCallbacks) new TurnBasedMatchLoadedBinderCallbacks(zzb), str);
    }

    public void zzg(zza.zzb<Players.LoadProfileSettingsResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzg((IGamesCallbacks) new ProfileSettingsLoadedBinderCallback(zzb), z);
    }

    public void zzgs(int i) {
        this.zzaEd.setGravity(i);
    }

    public void zzgt(int i) {
        try {
            ((IGamesService) zzqJ()).zzgt(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.games.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzh(zza.zzb<Videos.VideoAvailableResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzn((IGamesCallbacks) new VideoRecordingAvailableBinderCallback(zzb));
    }

    public void zzh(zza.zzb<Quests.AcceptQuestResult> zzb, String str) throws RemoteException {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzu((IGamesCallbacks) new QuestAcceptedBinderCallbacks(zzb), str);
    }

    public void zzh(zza.zzb<Status> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zzh((IGamesCallbacks) new ProfileSettingsUpdatedBinderCallback(zzb), z);
    }

    public void zzi(zza.zzb<Videos.ListVideosResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzl(new ListVideosBinderCallback(zzb));
    }

    public void zzi(zza.zzb<Snapshots.DeleteSnapshotResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzr((IGamesCallbacks) new SnapshotDeletedBinderCallbacks(zzb), str);
    }

    public void zzi(zza.zzb<Notifications.ContactSettingLoadResult> zzb, boolean z) throws RemoteException {
        ((IGamesService) zzqJ()).zze((IGamesCallbacks) new ContactSettingsLoadedBinderCallback(zzb), z);
    }

    public void zzj(zza.zzb<Acls.LoadAclResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzh(new NotifyAclLoadedBinderCallback(zzb));
    }

    public void zzj(zza.zzb<GamesMetadata.LoadGameInstancesResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzf((IGamesCallbacks) new GameInstancesLoadedBinderCallback(zzb), str);
    }

    public void zzk(zza.zzb<Notifications.InboxCountResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzt((IGamesCallbacks) new InboxCountsLoadedBinderCallback(zzb), (String) null);
    }

    public void zzk(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzq((IGamesCallbacks) new GameSearchSuggestionsLoadedBinderCallback(zzb), str);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzqJ()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzl(zza.zzb<Games.LoadExperimentsResult> zzb) throws RemoteException {
        ((IGamesService) zzqJ()).zzo(new ExperimentsLoadedBinderCallback(zzb));
    }

    public void zzl(zza.zzb<Players.LoadXpForGameCategoriesResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzb), str);
    }

    public void zzm(zza.zzb<Invitations.LoadInvitationsResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzk(new InvitationsLoadedBinderCallback(zzb), str);
    }

    public boolean zzmE() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzvD = this.zzaEh.zzvD();
        zzvD.putString("com.google.android.gms.games.key.gamePackageName", this.zzaEa);
        zzvD.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzvD.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaEd.zzxj()));
        zzvD.putInt("com.google.android.gms.games.key.API_VERSION", 3);
        zzvD.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zzqH()));
        return zzvD;
    }

    public void zzn(zza.zzb<Status> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzj(new NotifyAclUpdatedBinderCallback(zzb), str);
    }

    public void zzo(View view) {
        this.zzaEd.zzp(view);
    }

    public void zzo(zza.zzb<Notifications.GameMuteStatusLoadResult> zzb, String str) throws RemoteException {
        ((IGamesService) zzqJ()).zzi((IGamesCallbacks) new GameMuteStatusLoadedBinderCallback(zzb), str);
    }

    public Bundle zzoi() {
        try {
            Bundle zzoi = ((IGamesService) zzqJ()).zzoi();
            if (zzoi == null) {
                return zzoi;
            }
            zzoi.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzoi;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzp(String str, int i) {
        this.zzaDZ.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwA() {
        try {
            return ((IGamesService) zzqJ()).zzwA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwB() {
        try {
            return ((IGamesService) zzqJ()).zzwB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwC() {
        try {
            return ((IGamesService) zzqJ()).zzwC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzwD() {
        try {
            ((IGamesService) zzqJ()).zzG(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwE() {
        try {
            ((IGamesService) zzqJ()).zzH(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwF() {
        try {
            ((IGamesService) zzqJ()).zzJ(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwG() {
        try {
            ((IGamesService) zzqJ()).zzI(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwH() {
        try {
            return ((IGamesService) zzqJ()).zzwH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwI() {
        try {
            return ((IGamesService) zzqJ()).zzwI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwJ() {
        try {
            return ((IGamesService) zzqJ()).zzwJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzwK() {
        try {
            return ((IGamesService) zzqJ()).zzwK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwL() {
        try {
            return ((IGamesService) zzqJ()).zzwL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzwM() {
        try {
            return ((IGamesService) zzqJ()).zzwM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwN() {
        try {
            return ((IGamesService) zzqJ()).zzwN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwO() {
        try {
            return ((IGamesService) zzqJ()).zzwO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwP() {
        try {
            return ((IGamesService) zzqJ()).zzwP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwQ() {
        try {
            return ((IGamesService) zzqJ()).zzwQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzwR() {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zzwR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public String zzww() {
        try {
            return ((IGamesService) zzqJ()).zzww();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzwx() {
        PlayerBuffer playerBuffer;
        zzqI();
        synchronized (this) {
            if (this.zzaEb == null) {
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzqJ()).zzwU());
                    if (playerBuffer.getCount() > 0) {
                        this.zzaEb = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzaEb;
    }

    public Game zzwy() {
        GameBuffer gameBuffer;
        zzqI();
        synchronized (this) {
            if (this.zzaEc == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzqJ()).zzwW());
                    if (gameBuffer.getCount() > 0) {
                        this.zzaEc = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzaEc;
    }

    public Intent zzwz() {
        try {
            return ((IGamesService) zzqJ()).zzwz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
