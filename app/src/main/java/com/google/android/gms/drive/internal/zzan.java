package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.zzm;

public interface zzan extends IInterface {

    public static abstract class zza extends Binder implements zzan {

        /* renamed from: com.google.android.gms.drive.internal.zzan$zza$zza  reason: collision with other inner class name */
        private static class C0042zza implements zzan {
            private IBinder zzoz;

            C0042zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (changeSequenceNumber != null) {
                        obtain.writeInt(1);
                        changeSequenceNumber.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (getPermissionsResponse != null) {
                        obtain.writeInt(1);
                        getPermissionsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnChangesResponse onChangesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onChangesResponse != null) {
                        obtain.writeInt(1);
                        onChangesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDeviceUsagePreferenceResponse != null) {
                        obtain.writeInt(1);
                        onDeviceUsagePreferenceResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onFetchThumbnailResponse != null) {
                        obtain.writeInt(1);
                        onFetchThumbnailResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzm != null ? zzm.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onPinnedDownloadPreferencesResponse != null) {
                        obtain.writeInt(1);
                        onPinnedDownloadPreferencesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnStartStreamSession onStartStreamSession) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onStartStreamSession != null) {
                        obtain.writeInt(1);
                        onStartStreamSession.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(StringListResponse stringListResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (stringListResponse != null) {
                        obtain.writeInt(1);
                        stringListResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaf(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static zzan zzbb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzan)) ? new C0042zza(iBinder) : (zzan) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.drive.internal.OnStartStreamSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.drive.internal.StringListResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.drive.internal.GetPermissionsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.drive.internal.OnChangesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: com.google.android.gms.drive.ChangeSequenceNumber} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.drive.internal.OnFetchThumbnailResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: com.google.android.gms.drive.internal.OnResourceIdSetResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: com.google.android.gms.drive.internal.OnLoadRealtimeResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: com.google.android.gms.drive.internal.OnSyncMoreResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: com.google.android.gms.drive.internal.OnListParentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v74, resolved type: com.google.android.gms.drive.internal.OnContentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: com.google.android.gms.drive.internal.OnMetadataResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: com.google.android.gms.drive.internal.OnDriveIdResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v89, resolved type: com.google.android.gms.drive.internal.OnListEntriesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v94, resolved type: com.google.android.gms.drive.internal.OnDownloadProgressResponse} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v102 */
        /* JADX WARNING: type inference failed for: r0v103 */
        /* JADX WARNING: type inference failed for: r0v104 */
        /* JADX WARNING: type inference failed for: r0v105 */
        /* JADX WARNING: type inference failed for: r0v106 */
        /* JADX WARNING: type inference failed for: r0v107 */
        /* JADX WARNING: type inference failed for: r0v108 */
        /* JADX WARNING: type inference failed for: r0v109 */
        /* JADX WARNING: type inference failed for: r0v110 */
        /* JADX WARNING: type inference failed for: r0v111 */
        /* JADX WARNING: type inference failed for: r0v112 */
        /* JADX WARNING: type inference failed for: r0v113 */
        /* JADX WARNING: type inference failed for: r0v114 */
        /* JADX WARNING: type inference failed for: r0v115 */
        /* JADX WARNING: type inference failed for: r0v116 */
        /* JADX WARNING: type inference failed for: r0v117 */
        /* JADX WARNING: type inference failed for: r0v118 */
        /* JADX WARNING: type inference failed for: r0v119 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r1 = 1
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002c;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x0062;
                    case 5: goto L_0x007d;
                    case 6: goto L_0x0099;
                    case 7: goto L_0x00b5;
                    case 8: goto L_0x00c3;
                    case 9: goto L_0x00df;
                    case 11: goto L_0x00fb;
                    case 12: goto L_0x011f;
                    case 13: goto L_0x013b;
                    case 14: goto L_0x0157;
                    case 15: goto L_0x0173;
                    case 16: goto L_0x018a;
                    case 17: goto L_0x01a6;
                    case 18: goto L_0x01c2;
                    case 20: goto L_0x01de;
                    case 21: goto L_0x01fa;
                    case 22: goto L_0x0216;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDownloadProgressResponse> r0 = com.google.android.gms.drive.internal.OnDownloadProgressResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDownloadProgressResponse r0 = (com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0
            L_0x0024:
                r3.zza((com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListEntriesResponse> r0 = com.google.android.gms.drive.internal.OnListEntriesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListEntriesResponse r0 = (com.google.android.gms.drive.internal.OnListEntriesResponse) r0
            L_0x003f:
                r3.zza((com.google.android.gms.drive.internal.OnListEntriesResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDriveIdResponse> r0 = com.google.android.gms.drive.internal.OnDriveIdResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDriveIdResponse r0 = (com.google.android.gms.drive.internal.OnDriveIdResponse) r0
            L_0x005a:
                r3.zza((com.google.android.gms.drive.internal.OnDriveIdResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnMetadataResponse> r0 = com.google.android.gms.drive.internal.OnMetadataResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnMetadataResponse r0 = (com.google.android.gms.drive.internal.OnMetadataResponse) r0
            L_0x0075:
                r3.zza((com.google.android.gms.drive.internal.OnMetadataResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0090
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnContentsResponse> r0 = com.google.android.gms.drive.internal.OnContentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnContentsResponse r0 = (com.google.android.gms.drive.internal.OnContentsResponse) r0
            L_0x0090:
                r3.zza((com.google.android.gms.drive.internal.OnContentsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0099:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ac
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x00ac:
                r3.onError(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00b5:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r0)
                r3.onSuccess()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListParentsResponse> r0 = com.google.android.gms.drive.internal.OnListParentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListParentsResponse r0 = (com.google.android.gms.drive.internal.OnListParentsResponse) r0
            L_0x00d6:
                r3.zza((com.google.android.gms.drive.internal.OnListParentsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00df:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00f2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnSyncMoreResponse> r0 = com.google.android.gms.drive.internal.OnSyncMoreResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnSyncMoreResponse r0 = (com.google.android.gms.drive.internal.OnSyncMoreResponse) r0
            L_0x00f2:
                r3.zza((com.google.android.gms.drive.internal.OnSyncMoreResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00fb:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x010e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnLoadRealtimeResponse> r0 = com.google.android.gms.drive.internal.OnLoadRealtimeResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnLoadRealtimeResponse r0 = (com.google.android.gms.drive.internal.OnLoadRealtimeResponse) r0
            L_0x010e:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzm r2 = com.google.android.gms.drive.realtime.internal.zzm.zza.zzbo(r2)
                r3.zza(r0, r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x011f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0132
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnResourceIdSetResponse> r0 = com.google.android.gms.drive.internal.OnResourceIdSetResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnResourceIdSetResponse r0 = (com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0
            L_0x0132:
                r3.zza((com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x013b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x014e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse> r0 = com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse r0 = (com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse) r0
            L_0x014e:
                r3.zza((com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0157:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x016a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse> r0 = com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse r0 = (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) r0
            L_0x016a:
                r3.zza((com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0173:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x0188
                r0 = r1
            L_0x017f:
                r3.zzaf(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0188:
                r0 = 0
                goto L_0x017f
            L_0x018a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x019d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnFetchThumbnailResponse> r0 = com.google.android.gms.drive.internal.OnFetchThumbnailResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnFetchThumbnailResponse r0 = (com.google.android.gms.drive.internal.OnFetchThumbnailResponse) r0
            L_0x019d:
                r3.zza((com.google.android.gms.drive.internal.OnFetchThumbnailResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01a6:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01b9
                android.os.Parcelable$Creator<com.google.android.gms.drive.ChangeSequenceNumber> r0 = com.google.android.gms.drive.ChangeSequenceNumber.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.ChangeSequenceNumber r0 = (com.google.android.gms.drive.ChangeSequenceNumber) r0
            L_0x01b9:
                r3.zza((com.google.android.gms.drive.ChangeSequenceNumber) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01c2:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01d5
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnChangesResponse> r0 = com.google.android.gms.drive.internal.OnChangesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnChangesResponse r0 = (com.google.android.gms.drive.internal.OnChangesResponse) r0
            L_0x01d5:
                r3.zza((com.google.android.gms.drive.internal.OnChangesResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01de:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01f1
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsResponse> r0 = com.google.android.gms.drive.internal.GetPermissionsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.GetPermissionsResponse r0 = (com.google.android.gms.drive.internal.GetPermissionsResponse) r0
            L_0x01f1:
                r3.zza((com.google.android.gms.drive.internal.GetPermissionsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01fa:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x020d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.StringListResponse> r0 = com.google.android.gms.drive.internal.StringListResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.StringListResponse r0 = (com.google.android.gms.drive.internal.StringListResponse) r0
            L_0x020d:
                r3.zza((com.google.android.gms.drive.internal.StringListResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0216:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0229
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnStartStreamSession> r0 = com.google.android.gms.drive.internal.OnStartStreamSession.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnStartStreamSession r0 = (com.google.android.gms.drive.internal.OnStartStreamSession) r0
            L_0x0229:
                r3.zza((com.google.android.gms.drive.internal.OnStartStreamSession) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzan.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onError(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;

    void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException;

    void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException;

    void zza(OnChangesResponse onChangesResponse) throws RemoteException;

    void zza(OnContentsResponse onContentsResponse) throws RemoteException;

    void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException;

    void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException;

    void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    void zza(OnListParentsResponse onListParentsResponse) throws RemoteException;

    void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException;

    void zza(OnMetadataResponse onMetadataResponse) throws RemoteException;

    void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException;

    void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    void zza(OnStartStreamSession onStartStreamSession) throws RemoteException;

    void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    void zza(StringListResponse stringListResponse) throws RemoteException;

    void zzaf(boolean z) throws RemoteException;
}
