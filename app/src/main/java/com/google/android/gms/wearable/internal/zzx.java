package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzb;
import java.io.IOException;
import java.io.InputStream;

public final class zzx implements DataApi {

    public static class zza implements DataApi.DataItemResult {
        private final Status zzUX;
        private final DataItem zzbsv;

        public zza(Status status, DataItem dataItem) {
            this.zzUX = status;
            this.zzbsv = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbsv;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements DataApi.DeleteDataItemsResult {
        private final Status zzUX;
        private final int zzbsw;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzbsw = i;
        }

        public int getNumDeleted() {
            return this.zzbsw;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzc implements DataApi.GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzUX;
        private volatile InputStream zzbsh;
        private volatile ParcelFileDescriptor zzbsx;

        public zzc(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzUX = status;
            this.zzbsx = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbsx;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbsx == null) {
                return null;
            } else {
                if (this.zzbsh == null) {
                    this.zzbsh = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbsx);
                }
                return this.zzbsh;
            }
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzbsx != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzbsh != null) {
                        this.zzbsh.close();
                    } else {
                        this.zzbsx.close();
                    }
                    this.mClosed = true;
                    this.zzbsx = null;
                    this.zzbsh = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), dataListener);
    }

    private static zzb.zza<DataApi.DataListener> zza(final IntentFilter[] intentFilterArr) {
        return new zzb.zza<DataApi.DataListener>() {
            public void zza(zzbp zzbp, zza.zzb<Status> zzb, DataApi.DataListener dataListener, zzq<DataApi.DataListener> zzq) throws RemoteException {
                zzbp.zza(zzb, dataListener, zzq, intentFilterArr);
            }
        };
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        return zza(googleApiClient, dataListener, new IntentFilter[]{zzbn.zzgM(DataApi.ACTION_DATA_CHANGED)});
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, Uri uri, int i) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(i == 0 || i == 1, (Object) "invalid filter type");
        return zza(googleApiClient, dataListener, new IntentFilter[]{zzbn.zza(DataApi.ACTION_DATA_CHANGED, uri, i)});
    }

    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return deleteDataItems(googleApiClient, uri, 0);
    }

    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, final Uri uri, final int i) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (i == 0 || i == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return googleApiClient.zza(new zzi<DataApi.DeleteDataItemsResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzb(this, uri, i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbx */
            public DataApi.DeleteDataItemsResult zzc(Status status) {
                return new zzb(status, 0);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient googleApiClient, final Uri uri) {
        return googleApiClient.zza(new zzi<DataApi.DataItemResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<DataApi.DataItemResult>) this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbv */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, (DataItem) null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzi<DataItemBuffer>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zzr(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbw */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        return getDataItems(googleApiClient, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, final Uri uri, final int i) {
        boolean z = false;
        com.google.android.gms.common.internal.zzx.zzb(uri != null, (Object) "uri must not be null");
        if (i == 0 || i == 1) {
            z = true;
        }
        com.google.android.gms.common.internal.zzx.zzb(z, (Object) "invalid filter type");
        return googleApiClient.zza(new zzi<DataItemBuffer>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<DataItemBuffer>) this, uri, i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbw */
            public DataItemBuffer zzc(Status status) {
                return new DataItemBuffer(DataHolder.zzbI(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, final Asset asset) {
        zza(asset);
        return googleApiClient.zza(new zzi<DataApi.GetFdForAssetResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<DataApi.GetFdForAssetResult>) this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzby */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, (ParcelFileDescriptor) null);
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, final DataItemAsset dataItemAsset) {
        return googleApiClient.zza(new zzi<DataApi.GetFdForAssetResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<DataApi.GetFdForAssetResult>) this, dataItemAsset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzby */
            public DataApi.GetFdForAssetResult zzc(Status status) {
                return new zzc(status, (ParcelFileDescriptor) null);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient googleApiClient, final PutDataRequest putDataRequest) {
        return googleApiClient.zza(new zzi<DataApi.DataItemResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<DataApi.DataItemResult>) this, putDataRequest);
            }

            /* renamed from: zzbv */
            public DataApi.DataItemResult zzc(Status status) {
                return new zza(status, (DataItem) null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final DataApi.DataListener dataListener) {
        return googleApiClient.zza(new zzi<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzbp zzbp) throws RemoteException {
                zzbp.zza((zza.zzb<Status>) this, dataListener);
            }

            /* renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
