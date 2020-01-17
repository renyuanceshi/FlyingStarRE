package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.zza;
import com.google.android.gms.wearable.zzc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzbp extends zzj<zzax> {
    private final ExecutorService zzbkn = Executors.newCachedThreadPool();
    private final zzay<zzc.zza> zzbte = new zzay<>();
    private final zzay<zza.C0249zza> zzbtf = new zzay<>();
    private final zzay<ChannelApi.ChannelListener> zzbtg = new zzay<>();
    private final zzay<DataApi.DataListener> zzbth = new zzay<>();
    private final zzay<MessageApi.MessageListener> zzbti = new zzay<>();
    private final zzay<NodeApi.NodeListener> zzbtj = new zzay<>();
    private final zzay<NodeApi.zza> zzbtk = new zzay<>();
    private final zzay<CapabilityApi.CapabilityListener> zzbtl = new zzay<>();

    public zzbp(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 14, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask<>(new Callable<Boolean>() {
            /* renamed from: zzvt */
            public Boolean call() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        return true;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return false;
                } catch (Throwable th) {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                    throw th;
                }
            }
        });
    }

    private Runnable zzb(zza.zzb<Status> zzb, String str, Uri uri, long j, long j2) {
        zzx.zzz(zzb);
        zzx.zzz(str);
        zzx.zzz(uri);
        zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        zzx.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        final Uri uri2 = uri;
        final zza.zzb<Status> zzb2 = zzb;
        final String str2 = str;
        final long j3 = j;
        final long j4 = j2;
        return new Runnable() {
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing sendFileToChannelTask");
                }
                if (!"file".equals(uri2.getScheme())) {
                    Log.w("WearableClient", "Channel.sendFile used with non-file URI");
                    zzb2.zzw(new Status(10, "Channel.sendFile used with non-file URI"));
                    return;
                }
                File file = new File(uri2.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
                    try {
                        ((zzax) zzbp.this.zzqJ()).zza(new zzbo.zzr(zzb2), str2, open, j3, j4);
                        try {
                            open.close();
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close sourceFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.sendFile failed.", e2);
                        zzb2.zzw(new Status(8));
                        try {
                            open.close();
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close sourceFd", e3);
                        }
                    } catch (Throwable th) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close sourceFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: " + file);
                    zzb2.zzw(new Status(13));
                }
            }
        };
    }

    private Runnable zzb(zza.zzb<Status> zzb, String str, Uri uri, boolean z) {
        zzx.zzz(zzb);
        zzx.zzz(str);
        zzx.zzz(uri);
        final Uri uri2 = uri;
        final zza.zzb<Status> zzb2 = zzb;
        final boolean z2 = z;
        final String str2 = str;
        return new Runnable() {
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing receiveFileFromChannelTask");
                }
                if (!"file".equals(uri2.getScheme())) {
                    Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
                    zzb2.zzw(new Status(10, "Channel.receiveFile used with non-file URI"));
                    return;
                }
                File file = new File(uri2.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (z2 ? 33554432 : 0) | DriveFile.MODE_WRITE_ONLY);
                    try {
                        ((zzax) zzbp.this.zzqJ()).zza((zzav) new zzbo.zzu(zzb2), str2, open);
                        try {
                            open.close();
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close targetFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.receiveFile failed.", e2);
                        zzb2.zzw(new Status(8));
                        try {
                            open.close();
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close targetFd", e3);
                        }
                    } catch (Throwable th) {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close targetFd", e4);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + file);
                    zzb2.zzw(new Status(13));
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzbte.zzev(iBinder);
            this.zzbtf.zzev(iBinder);
            this.zzbtg.zzev(iBinder);
            this.zzbth.zzev(iBinder);
            this.zzbti.zzev(iBinder);
            this.zzbtj.zzev(iBinder);
            this.zzbtk.zzev(iBinder);
            this.zzbtl.zzev(iBinder);
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zza.zzb<DataApi.DataItemResult> zzb, Uri uri) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzk(zzb), uri);
    }

    public void zza(zza.zzb<DataItemBuffer> zzb, Uri uri, int i) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzl(zzb), uri, i);
    }

    public void zza(zza.zzb<DataApi.GetFdForAssetResult> zzb, Asset asset) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzm(zzb), asset);
    }

    public void zza(zza.zzb<Status> zzb, CapabilityApi.CapabilityListener capabilityListener) throws RemoteException {
        this.zzbtl.zza(this, zzb, capabilityListener);
    }

    public void zza(zza.zzb<Status> zzb, CapabilityApi.CapabilityListener capabilityListener, zzq<CapabilityApi.CapabilityListener> zzq, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtl.zza(this, zzb, capabilityListener, zzbq.zze(zzq, intentFilterArr));
    }

    public void zza(zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, zzq<ChannelApi.ChannelListener> zzq, String str, IntentFilter[] intentFilterArr) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, zzb, channelListener, zzbq.zzd(zzq, intentFilterArr));
            return;
        }
        this.zzbtg.zza(this, zzb, new zzbj(str, channelListener), zzbq.zza(zzq, str, intentFilterArr));
    }

    public void zza(zza.zzb<Status> zzb, ChannelApi.ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzbtg.zza(this, zzb, channelListener);
            return;
        }
        this.zzbtg.zza(this, zzb, new zzbj(str, channelListener));
    }

    public void zza(zza.zzb<Status> zzb, DataApi.DataListener dataListener) throws RemoteException {
        this.zzbth.zza(this, zzb, dataListener);
    }

    public void zza(zza.zzb<Status> zzb, DataApi.DataListener dataListener, zzq<DataApi.DataListener> zzq, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbth.zza(this, zzb, dataListener, zzbq.zza(zzq, intentFilterArr));
    }

    public void zza(zza.zzb<DataApi.GetFdForAssetResult> zzb, DataItemAsset dataItemAsset) throws RemoteException {
        zza(zzb, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zza.zzb<Status> zzb, MessageApi.MessageListener messageListener) throws RemoteException {
        this.zzbti.zza(this, zzb, messageListener);
    }

    public void zza(zza.zzb<Status> zzb, MessageApi.MessageListener messageListener, zzq<MessageApi.MessageListener> zzq, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbti.zza(this, zzb, messageListener, zzbq.zzb(zzq, intentFilterArr));
    }

    public void zza(zza.zzb<Status> zzb, NodeApi.NodeListener nodeListener) throws RemoteException {
        this.zzbtj.zza(this, zzb, nodeListener);
    }

    public void zza(zza.zzb<Status> zzb, NodeApi.NodeListener nodeListener, zzq<NodeApi.NodeListener> zzq, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbtj.zza(this, zzb, nodeListener, zzbq.zzc(zzq, intentFilterArr));
    }

    public void zza(zza.zzb<DataApi.DataItemResult> zzb, PutDataRequest putDataRequest) throws RemoteException {
        for (Map.Entry<String, Asset> value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest zzr = PutDataRequest.zzr(putDataRequest.getUri());
        zzr.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            zzr.setUrgent();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) next.getValue();
            if (asset2.getData() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzr.putAsset((String) next.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask<Boolean> zza = zza(createPipe[1], asset2.getData());
                    arrayList.add(zza);
                    this.zzbkn.submit(zza);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            } else if (asset2.getUri() != null) {
                try {
                    zzr.putAsset((String) next.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(asset2.getUri(), "r")));
                } catch (FileNotFoundException e2) {
                    new zzbo.zzq(zzb, arrayList).zza(new PutDataResponse(4005, (DataItemParcelable) null));
                    Log.w("WearableClient", "Couldn't resolve asset URI: " + asset2.getUri());
                    return;
                }
            } else {
                zzr.putAsset((String) next.getKey(), asset2);
            }
        }
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzq(zzb, arrayList), zzr);
    }

    public void zza(zza.zzb<Status> zzb, String str, Uri uri, long j, long j2) {
        try {
            this.zzbkn.execute(zzb(zzb, str, uri, j, j2));
        } catch (RuntimeException e) {
            zzb.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb<Status> zzb, String str, Uri uri, boolean z) {
        try {
            this.zzbkn.execute(zzb(zzb, str, uri, z));
        } catch (RuntimeException e) {
            zzb.zzw(new Status(8));
            throw e;
        }
    }

    public void zza(zza.zzb<MessageApi.SendMessageResult> zzb, String str, String str2, byte[] bArr) throws RemoteException {
        ((zzax) zzqJ()).zza(new zzbo.zzt(zzb), str, str2, bArr);
    }

    public void zzb(zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzb, int i) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzf(zzb), i);
    }

    public void zzb(zza.zzb<DataApi.DeleteDataItemsResult> zzb, Uri uri, int i) throws RemoteException {
        ((zzax) zzqJ()).zzb((zzav) new zzbo.zze(zzb), uri, i);
    }

    public void zze(zza.zzb<ChannelApi.OpenChannelResult> zzb, String str, String str2) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzp(zzb), str, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzew */
    public zzax zzW(IBinder iBinder) {
        return zzax.zza.zzeu(iBinder);
    }

    public void zzg(zza.zzb<CapabilityApi.GetCapabilityResult> zzb, String str, int i) throws RemoteException {
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzg(zzb), str, i);
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.wearable.BIND";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void zzh(zza.zzb<Status> zzb, String str, int i) throws RemoteException {
        ((zzax) zzqJ()).zzb((zzav) new zzbo.zzd(zzb), str, i);
    }

    public void zzr(zza.zzb<DataItemBuffer> zzb) throws RemoteException {
        ((zzax) zzqJ()).zzb(new zzbo.zzl(zzb));
    }

    public void zzr(zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzax) zzqJ()).zzd(new zzbo.zza(zzb), str);
    }

    public void zzs(zza.zzb<NodeApi.GetLocalNodeResult> zzb) throws RemoteException {
        ((zzax) zzqJ()).zzc(new zzbo.zzn(zzb));
    }

    public void zzs(zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzax) zzqJ()).zze(new zzbo.zzs(zzb), str);
    }

    public void zzt(zza.zzb<NodeApi.GetConnectedNodesResult> zzb) throws RemoteException {
        ((zzax) zzqJ()).zzd(new zzbo.zzj(zzb));
    }

    public void zzt(zza.zzb<Status> zzb, String str) throws RemoteException {
        ((zzax) zzqJ()).zzf(new zzbo.zzc(zzb), str);
    }

    public void zzu(zza.zzb<Channel.GetInputStreamResult> zzb, String str) throws RemoteException {
        zzt zzt = new zzt();
        ((zzax) zzqJ()).zza((zzav) new zzbo.zzh(zzb, zzt), (zzau) zzt, str);
    }

    public void zzv(zza.zzb<Channel.GetOutputStreamResult> zzb, String str) throws RemoteException {
        zzt zzt = new zzt();
        ((zzax) zzqJ()).zzb((zzav) new zzbo.zzi(zzb, zzt), (zzau) zzt, str);
    }
}
