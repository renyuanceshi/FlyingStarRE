package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzb;
import com.google.android.gms.wearable.internal.zzl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();
    private final String mPath;
    final int mVersionCode;
    /* access modifiers changed from: private */
    public final String zzVo;
    private final String zzbrb;

    static final class zza implements Channel.GetInputStreamResult {
        private final Status zzUX;
        private final InputStream zzbsh;

        zza(Status status, InputStream inputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsh = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzbsh;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsh != null) {
                try {
                    this.zzbsh.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements Channel.GetOutputStreamResult {
        private final Status zzUX;
        private final OutputStream zzbsi;

        zzb(Status status, OutputStream outputStream) {
            this.zzUX = (Status) zzx.zzz(status);
            this.zzbsi = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzbsi;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsi != null) {
                try {
                    this.zzbsi.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzVo = (String) zzx.zzz(str);
        this.zzbrb = (String) zzx.zzz(str2);
        this.mPath = (String) zzx.zzz(str3);
    }

    private static zzb.zza<ChannelApi.ChannelListener> zza(final String str, final IntentFilter[] intentFilterArr) {
        return new zzb.zza<ChannelApi.ChannelListener>() {
            public void zza(zzbp zzbp, zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, zzq<ChannelApi.ChannelListener> zzq) throws RemoteException {
                zzbp.zza(zzb, channelListener, zzq, str, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        IntentFilter zzgM = zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT);
        return zzb.zza(googleApiClient, zza(this.zzVo, new IntentFilter[]{zzgM}), channelListener);
    }

    public PendingResult<Status> close(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzt(this, ChannelImpl.this.zzVo);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> close(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzh(this, ChannelImpl.this.zzVo, i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ChannelImpl)) {
                return false;
            }
            ChannelImpl channelImpl = (ChannelImpl) obj;
            if (!this.zzVo.equals(channelImpl.zzVo) || !zzw.equal(channelImpl.zzbrb, this.zzbrb) || !zzw.equal(channelImpl.mPath, this.mPath) || channelImpl.mVersionCode != this.mVersionCode) {
                return false;
            }
        }
        return true;
    }

    public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<Channel.GetInputStreamResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzu(this, ChannelImpl.this.zzVo);
            }

            /* renamed from: zzbt */
            public Channel.GetInputStreamResult zzc(Status status) {
                return new zza(status, (InputStream) null);
            }
        });
    }

    public String getNodeId() {
        return this.zzbrb;
    }

    public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<Channel.GetOutputStreamResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzv(this, ChannelImpl.this.zzVo);
            }

            /* renamed from: zzbu */
            public Channel.GetOutputStreamResult zzc(Status status) {
                return new zzb(status, (OutputStream) null);
            }
        });
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return this.zzVo.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient googleApiClient, final Uri uri, final boolean z) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(uri, (Object) "uri is null");
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<Status>) this, ChannelImpl.this.zzVo, uri, z);
            }

            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(channelListener, (Object) "listener is null");
        return googleApiClient.zza(new zzl.zzb(googleApiClient, channelListener, this.zzVo));
    }

    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri) {
        return sendFile(googleApiClient, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
        zzx.zzb(googleApiClient, (Object) "client is null");
        zzx.zzb(this.zzVo, (Object) "token is null");
        zzx.zzb(uri, (Object) "uri is null");
        zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        zzx.zzb(j2 >= 0 || j2 == -1, "invalid length: %s", Long.valueOf(j2));
        final Uri uri2 = uri;
        final long j3 = j;
        final long j4 = j2;
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<Status>) this, ChannelImpl.this.zzVo, uri2, j3, j4);
            }

            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzVo + '\'' + ", nodeId='" + this.zzbrb + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
