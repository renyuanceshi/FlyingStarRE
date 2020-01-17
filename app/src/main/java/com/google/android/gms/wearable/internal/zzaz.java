package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.MessageApi;

public final class zzaz implements MessageApi {

    private static final class zza extends zzi<Status> {
        private zzq<MessageApi.MessageListener> zzbbi;
        private MessageApi.MessageListener zzbsS;
        private IntentFilter[] zzbsT;

        private zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, zzq<MessageApi.MessageListener> zzq, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbsS = (MessageApi.MessageListener) zzx.zzz(messageListener);
            this.zzbbi = (zzq) zzx.zzz(zzq);
            this.zzbsT = (IntentFilter[]) zzx.zzz(intentFilterArr);
        }

        /* access modifiers changed from: protected */
        public void zza(zzbp zzbp) throws RemoteException {
            zzbp.zza((zza.zzb<Status>) this, this.zzbsS, this.zzbbi, this.zzbsT);
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
            return status;
        }
    }

    public static class zzb implements MessageApi.SendMessageResult {
        private final Status zzUX;
        private final int zzaox;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzaox = i;
        }

        public int getRequestId() {
            return this.zzaox;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, googleApiClient.zzr(messageListener), intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        return zza(googleApiClient, messageListener, new IntentFilter[]{zzbn.zzgM(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, Uri uri, int i) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        zzx.zzb(i == 0 || i == 1, (Object) "invalid filter type");
        return zza(googleApiClient, messageListener, new IntentFilter[]{zzbn.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, i)});
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final MessageApi.MessageListener messageListener) {
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<Status>) this, messageListener);
            }

            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return googleApiClient.zza(new zzi<MessageApi.SendMessageResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<MessageApi.SendMessageResult>) this, str3, str4, bArr2);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbz */
            public MessageApi.SendMessageResult zzc(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
