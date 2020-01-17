package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API = new Api<>("Cast.API", zzUJ, zzk.zzUI);
    public static final CastApi CastApi = new CastApi.zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final Api.zza<zze, CastOptions> zzUJ = new Api.zza<zze, CastOptions>() {
        public zze zza(Context context, Looper looper, zzf zzf, CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(castOptions, (Object) "Setting the API options is required.");
            return new zze(context, looper, zzf, castOptions.zzZL, (long) castOptions.zzZN, castOptions.zzZM, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        public static final class zza implements CastApi {
            public int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzol();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzom();
            }

            public double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzok();
            }

            public boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzUI)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
                return zza(googleApiClient, (String) null, (String) null, (JoinOptions) null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
                return zza(googleApiClient, str, (String) null, (JoinOptions) null);
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
                return zza(googleApiClient, str, str2, (JoinOptions) null);
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(str, false, (zza.zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str, final LaunchOptions launchOptions) {
                return googleApiClient.zzb(new zza(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(str, launchOptions, (zza.zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new LaunchOptions.Builder().setRelaunchIfRunning(z).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zzb((zza.zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzcg(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzoj();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zzh(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(str, str2, (zza.zzb<Status>) this);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zza(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzX(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzf(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza("", (zza.zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zzh(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        if (TextUtils.isEmpty(str)) {
                            zze(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zze.zza(str, (zza.zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, JoinOptions joinOptions) {
                final String str3 = str;
                final String str4 = str2;
                final JoinOptions joinOptions2 = joinOptions;
                return googleApiClient.zzb(new zza(googleApiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(str3, str4, joinOptions2, (zza.zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzZL;
        final Listener zzZM;
        /* access modifiers changed from: private */
        public final int zzZN;

        public static final class Builder {
            CastDevice zzZO;
            Listener zzZP;
            /* access modifiers changed from: private */
            public int zzZQ = 0;

            public Builder(CastDevice castDevice, Listener listener) {
                zzx.zzb(castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb(listener, (Object) "CastListener parameter cannot be null");
                this.zzZO = castDevice;
                this.zzZP = listener;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                if (z) {
                    this.zzZQ |= 1;
                } else {
                    this.zzZQ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzZM = builder.zzZP;
            this.zzZN = builder.zzZQ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private static abstract class zza extends zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzo */
        public ApplicationConnectionResult zzc(final Status status) {
            return new ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
