package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10  reason: invalid class name */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzacQ;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Achievements.LoadAchievementsResult>) this, this.zzacQ, this.zzaFQ, this.zzaFO);
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzZ */
        public Achievements.LoadAchievementsResult zzc(final Status status) {
            return new Achievements.LoadAchievementsResult() {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzbI(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
        /* access modifiers changed from: private */
        public final String zzyv;

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzyv = str;
        }

        /* renamed from: zzaa */
        public Achievements.UpdateAchievementResult zzc(final Status status) {
            return new Achievements.UpdateAchievementResult() {
                public String getAchievementId() {
                    return UpdateImpl.this.zzyv;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzh(googleApiClient).zzwA();
    }

    public void increment(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, str2, i2);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) this, str2, i2);
            }
        });
    }

    public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zza.zzb<Achievements.LoadAchievementsResult>) this, z);
            }
        });
    }

    public void reveal(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, str);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) this, str);
            }
        });
    }

    public void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, str2, i2);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) this, str2, i2);
            }
        });
    }

    public void unlock(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, str);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) this, str);
            }
        });
    }
}
