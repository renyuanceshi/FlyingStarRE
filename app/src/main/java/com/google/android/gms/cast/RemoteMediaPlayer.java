package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

@SuppressLint({"MissingRemoteException"})
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    /* access modifiers changed from: private */
    public final zzm zzabE = new zzm((String) null) {
        /* access modifiers changed from: protected */
        public void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        /* access modifiers changed from: protected */
        public void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        /* access modifiers changed from: protected */
        public void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        /* access modifiers changed from: protected */
        public void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    /* access modifiers changed from: private */
    public final zza zzabF = new zza();
    private OnPreloadStatusUpdatedListener zzabG;
    private OnQueueStatusUpdatedListener zzabH;
    private OnMetadataUpdatedListener zzabI;
    private OnStatusUpdatedListener zzabJ;
    /* access modifiers changed from: private */
    public final Object zzpV = new Object();

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzn {
        private GoogleApiClient zzaci;
        private long zzacj = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza  reason: collision with other inner class name */
        private final class C0027zza implements ResultCallback<Status> {
            private final long zzack;

            C0027zza(long j) {
                this.zzack = j;
            }

            /* renamed from: zzp */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    RemoteMediaPlayer.this.zzabE.zzb(this.zzack, status.getStatusCode());
                }
            }
        }

        public zza() {
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaci == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaci, str, str2).setResultCallback(new C0027zza(j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaci = googleApiClient;
        }

        public long zznQ() {
            long j = this.zzacj + 1;
            this.zzacj = j;
            return j;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzacm = new zzo() {
            public void zza(long j, int i, Object obj) {
                zzb.this.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                zzb.this.zza(zzb.this.zzc(new Status(2103)));
            }
        };

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzq */
        public MediaChannelResult zzc(final Status status) {
            return new MediaChannelResult() {
                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzUX;
        private final JSONObject zzaaU;

        zzc(Status status, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzaaU = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzaaU;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public RemoteMediaPlayer() {
        this.zzabE.zza(this.zzabF);
    }

    /* access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.zzabI != null) {
            this.zzabI.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onPreloadStatusUpdated() {
        if (this.zzabG != null) {
            this.zzabG.onPreloadStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onQueueStatusUpdated() {
        if (this.zzabH != null) {
            this.zzabH.onQueueStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.zzabJ != null) {
            this.zzabJ.onStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpV) {
            approximateStreamPosition = this.zzabE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpV) {
            mediaInfo = this.zzabE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpV) {
            mediaStatus = this.zzabE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzabE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpV) {
            streamDuration = this.zzabE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, 0, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z) {
        return load(googleApiClient, mediaInfo, z, 0, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j) {
        return load(googleApiClient, mediaInfo, z, j, (long[]) null, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z, j, (long[]) null, jSONObject);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z2 = z;
        final long j2 = j;
        final long[] jArr2 = jArr;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaInfo2, z2, j2, jArr2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String str, String str2) {
        this.zzabE.zzcf(str2);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient googleApiClient) {
        return pause(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, jSONObject);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient googleApiClient) {
        return play(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zzc(this.zzacm, jSONObject);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, JSONObject jSONObject) throws IllegalArgumentException {
        return queueInsertItems(googleApiClient, new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, long j, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaQueueItem mediaQueueItem2 = mediaQueueItem;
        final int i2 = i;
        final long j2 = j;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        zzm zzg = RemoteMediaPlayer.this.zzabE;
                        zzo zzo = this.zzacm;
                        MediaQueueItem mediaQueueItem = mediaQueueItem2;
                        MediaQueueItem[] mediaQueueItemArr = {mediaQueueItem};
                        zzg.zza(zzo, mediaQueueItemArr, i2, 0, 0, j2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i, JSONObject jSONObject) {
        return queueInsertAndPlayItem(googleApiClient, mediaQueueItem, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaQueueItemArr2, i2, 0, -1, -1, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, long j, JSONObject jSONObject) {
        final int i2 = i;
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final long j2 = j;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r12) {
                /*
                    r11 = this;
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r10 = r0.zzpV
                    monitor-enter(r10)
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004c }
                    int r1 = r4     // Catch:{ all -> 0x004c }
                    int r0 = r0.zzbf(r1)     // Catch:{ all -> 0x004c }
                    r1 = -1
                    if (r0 != r1) goto L_0x0021
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004c }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r11.zzc(r0)     // Catch:{ all -> 0x004c }
                    r11.zza(r0)     // Catch:{ all -> 0x004c }
                    monitor-exit(r10)     // Catch:{ all -> 0x004c }
                L_0x0020:
                    return
                L_0x0021:
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004c }
                    com.google.android.gms.common.api.GoogleApiClient r1 = r5     // Catch:{ all -> 0x004c }
                    r0.zzc(r1)     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x004f }
                    com.google.android.gms.cast.internal.zzm r1 = r0.zzabE     // Catch:{ IOException -> 0x004f }
                    com.google.android.gms.cast.internal.zzo r2 = r11.zzacm     // Catch:{ IOException -> 0x004f }
                    int r3 = r4     // Catch:{ IOException -> 0x004f }
                    long r4 = r6     // Catch:{ IOException -> 0x004f }
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    org.json.JSONObject r9 = r8     // Catch:{ IOException -> 0x004f }
                    r1.zza((com.google.android.gms.cast.internal.zzo) r2, (int) r3, (long) r4, (com.google.android.gms.cast.MediaQueueItem[]) r6, (int) r7, (java.lang.Integer) r8, (org.json.JSONObject) r9)     // Catch:{ IOException -> 0x004f }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004c }
                    r1 = 0
                    r0.zzc(r1)     // Catch:{ all -> 0x004c }
                L_0x004a:
                    monitor-exit(r10)     // Catch:{ all -> 0x004c }
                    goto L_0x0020
                L_0x004c:
                    r0 = move-exception
                    monitor-exit(r10)     // Catch:{ all -> 0x004c }
                    throw r0
                L_0x004f:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0069 }
                    r1 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r1)     // Catch:{ all -> 0x0069 }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r11.zzc(r0)     // Catch:{ all -> 0x0069 }
                    r11.zza(r0)     // Catch:{ all -> 0x0069 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004c }
                    r1 = 0
                    r0.zzc(r1)     // Catch:{ all -> 0x004c }
                    goto L_0x004a
                L_0x0069:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004c }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzabF     // Catch:{ all -> 0x004c }
                    r2 = 0
                    r1.zzc(r2)     // Catch:{ all -> 0x004c }
                    throw r0     // Catch:{ all -> 0x004c }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass15.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        return queueJumpToItem(googleApiClient, i, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        final int i3 = i;
        final int i4 = i2;
        final long j2 = j;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaQueueItemArr2, i3, i4, j2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IllegalArgumentException {
        return queueLoad(googleApiClient, mediaQueueItemArr, i, i2, -1, jSONObject);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
        final int i3 = i;
        final int i4 = i2;
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r9) {
                /*
                    r8 = this;
                    r0 = 0
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r2 = r1.zzpV
                    monitor-enter(r2)
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    int r3 = r3     // Catch:{ all -> 0x004a }
                    int r1 = r1.zzbf(r3)     // Catch:{ all -> 0x004a }
                    r3 = -1
                    if (r1 != r3) goto L_0x0022
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzc(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                L_0x0021:
                    return
                L_0x0022:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r3 >= 0) goto L_0x004d
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 2001(0x7d1, float:2.804E-42)
                    java.util.Locale r3 = java.util.Locale.ROOT     // Catch:{ all -> 0x004a }
                    java.lang.String r4 = "Invalid request: Invalid newIndex %d."
                    r5 = 1
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x004a }
                    r6 = 0
                    int r7 = r4     // Catch:{ all -> 0x004a }
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x004a }
                    r5[r6] = r7     // Catch:{ all -> 0x004a }
                    java.lang.String r3 = java.lang.String.format(r3, r4, r5)     // Catch:{ all -> 0x004a }
                    r0.<init>(r1, r3)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzc(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x004a:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    throw r0
                L_0x004d:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r1 != r3) goto L_0x0060
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzc(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x0060:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r3 <= r1) goto L_0x00a5
                    int r1 = r4     // Catch:{ all -> 0x004a }
                    int r1 = r1 + 1
                L_0x0068:
                    com.google.android.gms.cast.RemoteMediaPlayer r3 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.MediaStatus r3 = r3.getMediaStatus()     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.MediaQueueItem r1 = r3.getQueueItem(r1)     // Catch:{ all -> 0x004a }
                    if (r1 == 0) goto L_0x0078
                    int r0 = r1.getItemId()     // Catch:{ all -> 0x004a }
                L_0x0078:
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzabF     // Catch:{ all -> 0x004a }
                    com.google.android.gms.common.api.GoogleApiClient r3 = r5     // Catch:{ all -> 0x004a }
                    r1.zzc(r3)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.internal.zzm r1 = r1.zzabE     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.internal.zzo r3 = r8.zzacm     // Catch:{ IOException -> 0x00a8 }
                    int r4 = r3     // Catch:{ IOException -> 0x00a8 }
                    org.json.JSONObject r5 = r6     // Catch:{ IOException -> 0x00a8 }
                    r6 = 1
                    int[] r6 = new int[r6]     // Catch:{ IOException -> 0x00a8 }
                    r7 = 0
                    r6[r7] = r4     // Catch:{ IOException -> 0x00a8 }
                    r1.zza((com.google.android.gms.cast.internal.zzo) r3, (int[]) r6, (int) r0, (org.json.JSONObject) r5)     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzc(r1)     // Catch:{ all -> 0x004a }
                L_0x00a2:
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x00a5:
                    int r1 = r4     // Catch:{ all -> 0x004a }
                    goto L_0x0068
                L_0x00a8:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x00c2 }
                    r1 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r1)     // Catch:{ all -> 0x00c2 }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzc(r0)     // Catch:{ all -> 0x00c2 }
                    r8.zza(r0)     // Catch:{ all -> 0x00c2 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzc(r1)     // Catch:{ all -> 0x004a }
                    goto L_0x00a2
                L_0x00c2:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzabF     // Catch:{ all -> 0x004a }
                    r3 = 0
                    r1.zzc(r3)     // Catch:{ all -> 0x004a }
                    throw r0     // Catch:{ all -> 0x004a }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass16.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1, (MediaQueueItem[]) null, 1, (Integer) null, jSONObject);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1, (MediaQueueItem[]) null, -1, (Integer) null, jSONObject);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        final int i2 = i;
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r8) {
                /*
                    r7 = this;
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r1 = r0.zzpV
                    monitor-enter(r1)
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    int r2 = r3     // Catch:{ all -> 0x004d }
                    int r0 = r0.zzbf(r2)     // Catch:{ all -> 0x004d }
                    r2 = -1
                    if (r0 != r2) goto L_0x0021
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.<init>(r2)     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r7.zzc(r0)     // Catch:{ all -> 0x004d }
                    r7.zza(r0)     // Catch:{ all -> 0x004d }
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                L_0x0020:
                    return
                L_0x0021:
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004d }
                    com.google.android.gms.common.api.GoogleApiClient r2 = r4     // Catch:{ all -> 0x004d }
                    r0.zzc(r2)     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.internal.zzm r0 = r0.zzabE     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.internal.zzo r2 = r7.zzacm     // Catch:{ IOException -> 0x0050 }
                    int r3 = r3     // Catch:{ IOException -> 0x0050 }
                    org.json.JSONObject r4 = r5     // Catch:{ IOException -> 0x0050 }
                    r5 = 1
                    int[] r5 = new int[r5]     // Catch:{ IOException -> 0x0050 }
                    r6 = 0
                    r5[r6] = r3     // Catch:{ IOException -> 0x0050 }
                    r0.zza((com.google.android.gms.cast.internal.zzo) r2, (int[]) r5, (org.json.JSONObject) r4)     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.zzc(r2)     // Catch:{ all -> 0x004d }
                L_0x004b:
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                    goto L_0x0020
                L_0x004d:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                    throw r0
                L_0x0050:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x006a }
                    r2 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r2)     // Catch:{ all -> 0x006a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r7.zzc(r0)     // Catch:{ all -> 0x006a }
                    r7.zza(r0)     // Catch:{ all -> 0x006a }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzabF     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.zzc(r2)     // Catch:{ all -> 0x004d }
                    goto L_0x004b
                L_0x006a:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r2 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r2 = r2.zzabF     // Catch:{ all -> 0x004d }
                    r3 = 0
                    r2.zzc(r3)     // Catch:{ all -> 0x004d }
                    throw r0     // Catch:{ all -> 0x004d }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.AnonymousClass14.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient googleApiClient, int[] iArr, JSONObject jSONObject) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final int[] iArr2 = iArr;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, iArr2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient googleApiClient, int[] iArr, int i, JSONObject jSONObject) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final int[] iArr2 = iArr;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, iArr2, i2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient googleApiClient, int i, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1, (MediaQueueItem[]) null, 0, Integer.valueOf(i2), jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final MediaQueueItem[] mediaQueueItemArr2 = mediaQueueItemArr;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1, mediaQueueItemArr2, 0, (Integer) null, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j) {
        return seek(googleApiClient, j, 0, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i) {
        return seek(googleApiClient, j, i, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final long j2 = j;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, j2, i2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient googleApiClient, final long[] jArr) {
        if (jArr != null) {
            return googleApiClient.zzb(new zzb(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzpV) {
                        RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, jArr);
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzabI = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzabG = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zzabH = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzabJ = onStatusUpdatedListener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z) {
        return setStreamMute(googleApiClient, z, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final boolean z2 = z;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, z2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d) throws IllegalArgumentException {
        return setStreamVolume(googleApiClient, d, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient googleApiClient, double d, JSONObject jSONObject) throws IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        final GoogleApiClient googleApiClient2 = googleApiClient;
        final double d2 = d;
        final JSONObject jSONObject2 = jSONObject;
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient2);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, d2, jSONObject2);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient googleApiClient, final TextTrackStyle textTrackStyle) {
        if (textTrackStyle != null) {
            return googleApiClient.zzb(new zzb(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzpV) {
                        RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, textTrackStyle);
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient googleApiClient) {
        return stop(googleApiClient, (JSONObject) null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient googleApiClient, final JSONObject jSONObject) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zzb(this.zzacm, jSONObject);
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc((GoogleApiClient) null);
                        throw th;
                    }
                }
            }
        });
    }
}
