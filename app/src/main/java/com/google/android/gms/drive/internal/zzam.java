package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public interface zzam extends IInterface {

    public static abstract class zza extends Binder implements zzam {

        /* renamed from: com.google.android.gms.drive.internal.zzam$zza$zza  reason: collision with other inner class name */
        private static class C0041zza implements zzam {
            private IBinder zzoz;

            C0041zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzan) throws RemoteException {
                DriveServiceResponse driveServiceResponse = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzan) throws RemoteException {
                DriveServiceResponse driveServiceResponse = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (streamContentsRequest != null) {
                        obtain.writeInt(1);
                        streamContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddEventListenerRequest addEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    obtain.writeString(str);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddPermissionRequest addPermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (changeResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        changeResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsRequest closeContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ControlProgressRequest controlProgressRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (controlProgressRequest != null) {
                        obtain.writeInt(1);
                        controlProgressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateContentsRequest createContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFileRequest createFileRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFolderRequest createFolderRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteResourceRequest deleteResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
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

            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChangesRequest getChangesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetMetadataRequest getMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsRequest getPermissionsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ListParentsRequest listParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzao zzao, zzan zzan) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    obtain.writeString(str);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemovePermissionRequest removePermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setPinnedDownloadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setPinnedDownloadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(TrashResourceRequest trashResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UntrashResourceRequest untrashResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzao zzao, zzan zzan) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(QueryRequest queryRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzam zzba(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzam)) ? new C0041zza(iBinder) : (zzam) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.drive.internal.StreamContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.drive.internal.ChangeResourceParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.google.android.gms.drive.internal.ControlProgressRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.google.android.gms.drive.internal.RemovePermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: com.google.android.gms.drive.internal.UpdatePermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.google.android.gms.drive.internal.AddPermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: com.google.android.gms.drive.internal.GetPermissionsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: com.google.android.gms.drive.internal.UnsubscribeResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: com.google.android.gms.drive.internal.GetChangesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: com.google.android.gms.drive.internal.FetchThumbnailRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v77, resolved type: com.google.android.gms.drive.internal.UntrashResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v82, resolved type: com.google.android.gms.drive.internal.CancelPendingActionsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v87, resolved type: com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v96, resolved type: com.google.android.gms.drive.RealtimeDocumentSyncRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v101, resolved type: com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v114, resolved type: com.google.android.gms.drive.internal.CheckResourceIdsExistRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v119, resolved type: com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v124, resolved type: com.google.android.gms.drive.internal.SetResourceParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v129, resolved type: com.google.android.gms.drive.internal.LoadRealtimeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v134, resolved type: com.google.android.gms.drive.internal.DeleteResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v139, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v144, resolved type: com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v149, resolved type: com.google.android.gms.drive.internal.TrashResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v154, resolved type: com.google.android.gms.drive.internal.DisconnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v159, resolved type: com.google.android.gms.drive.internal.RemoveEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v164, resolved type: com.google.android.gms.drive.internal.AddEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v169, resolved type: com.google.android.gms.drive.internal.ListParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v174, resolved type: com.google.android.gms.drive.internal.AuthorizeAccessRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v179, resolved type: com.google.android.gms.drive.internal.CreateFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v185, resolved type: com.google.android.gms.drive.internal.OpenFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v195, resolved type: com.google.android.gms.drive.internal.CloseContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v200, resolved type: com.google.android.gms.drive.internal.OpenContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v206, resolved type: com.google.android.gms.drive.internal.CreateFolderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v211, resolved type: com.google.android.gms.drive.internal.CreateFileRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v216, resolved type: com.google.android.gms.drive.internal.CreateContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v221, resolved type: com.google.android.gms.drive.internal.UpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v226, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v231, resolved type: com.google.android.gms.drive.internal.GetMetadataRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v239 */
        /* JADX WARNING: type inference failed for: r0v240 */
        /* JADX WARNING: type inference failed for: r0v241 */
        /* JADX WARNING: type inference failed for: r0v242 */
        /* JADX WARNING: type inference failed for: r0v243 */
        /* JADX WARNING: type inference failed for: r0v244 */
        /* JADX WARNING: type inference failed for: r0v245 */
        /* JADX WARNING: type inference failed for: r0v246 */
        /* JADX WARNING: type inference failed for: r0v247 */
        /* JADX WARNING: type inference failed for: r0v248 */
        /* JADX WARNING: type inference failed for: r0v249 */
        /* JADX WARNING: type inference failed for: r0v250 */
        /* JADX WARNING: type inference failed for: r0v251 */
        /* JADX WARNING: type inference failed for: r0v252 */
        /* JADX WARNING: type inference failed for: r0v253 */
        /* JADX WARNING: type inference failed for: r0v254 */
        /* JADX WARNING: type inference failed for: r0v255 */
        /* JADX WARNING: type inference failed for: r0v256 */
        /* JADX WARNING: type inference failed for: r0v257 */
        /* JADX WARNING: type inference failed for: r0v258 */
        /* JADX WARNING: type inference failed for: r0v259 */
        /* JADX WARNING: type inference failed for: r0v260 */
        /* JADX WARNING: type inference failed for: r0v261 */
        /* JADX WARNING: type inference failed for: r0v262 */
        /* JADX WARNING: type inference failed for: r0v263 */
        /* JADX WARNING: type inference failed for: r0v264 */
        /* JADX WARNING: type inference failed for: r0v265 */
        /* JADX WARNING: type inference failed for: r0v266 */
        /* JADX WARNING: type inference failed for: r0v267 */
        /* JADX WARNING: type inference failed for: r0v268 */
        /* JADX WARNING: type inference failed for: r0v269 */
        /* JADX WARNING: type inference failed for: r0v270 */
        /* JADX WARNING: type inference failed for: r0v271 */
        /* JADX WARNING: type inference failed for: r0v272 */
        /* JADX WARNING: type inference failed for: r0v273 */
        /* JADX WARNING: type inference failed for: r0v274 */
        /* JADX WARNING: type inference failed for: r0v275 */
        /* JADX WARNING: type inference failed for: r0v276 */
        /* JADX WARNING: type inference failed for: r0v277 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r3 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0058;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x009f;
                    case 6: goto L_0x00c3;
                    case 7: goto L_0x00e7;
                    case 8: goto L_0x0118;
                    case 9: goto L_0x013c;
                    case 10: goto L_0x0152;
                    case 11: goto L_0x017b;
                    case 12: goto L_0x01a4;
                    case 13: goto L_0x01c8;
                    case 14: goto L_0x01ec;
                    case 15: goto L_0x021c;
                    case 16: goto L_0x024c;
                    case 17: goto L_0x0268;
                    case 18: goto L_0x028c;
                    case 19: goto L_0x02b0;
                    case 24: goto L_0x02d4;
                    case 27: goto L_0x02f8;
                    case 28: goto L_0x031c;
                    case 29: goto L_0x0340;
                    case 30: goto L_0x0364;
                    case 31: goto L_0x0388;
                    case 32: goto L_0x039e;
                    case 33: goto L_0x03b4;
                    case 34: goto L_0x03d8;
                    case 35: goto L_0x03fc;
                    case 36: goto L_0x0412;
                    case 37: goto L_0x0436;
                    case 38: goto L_0x045a;
                    case 41: goto L_0x047e;
                    case 42: goto L_0x0494;
                    case 43: goto L_0x04b8;
                    case 44: goto L_0x04ce;
                    case 46: goto L_0x04f2;
                    case 47: goto L_0x0516;
                    case 48: goto L_0x053a;
                    case 49: goto L_0x055e;
                    case 50: goto L_0x0582;
                    case 51: goto L_0x05a6;
                    case 52: goto L_0x05d2;
                    case 53: goto L_0x05f0;
                    case 54: goto L_0x0614;
                    case 55: goto L_0x062a;
                    case 56: goto L_0x064e;
                    case 57: goto L_0x067f;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0025
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetMetadataRequest> r0 = com.google.android.gms.drive.internal.GetMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetMetadataRequest r0 = (com.google.android.gms.drive.internal.GetMetadataRequest) r0
            L_0x0025:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.GetMetadataRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0035:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0048
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x0048:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.QueryRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0058:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x006b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.UpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.UpdateMetadataRequest) r0
            L_0x006b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.UpdateMetadataRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x007b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x008e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateContentsRequest> r0 = com.google.android.gms.drive.internal.CreateContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateContentsRequest r0 = (com.google.android.gms.drive.internal.CreateContentsRequest) r0
            L_0x008e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CreateContentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x009f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00b2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileRequest> r0 = com.google.android.gms.drive.internal.CreateFileRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileRequest r0 = (com.google.android.gms.drive.internal.CreateFileRequest) r0
            L_0x00b2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CreateFileRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFolderRequest> r0 = com.google.android.gms.drive.internal.CreateFolderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFolderRequest r0 = (com.google.android.gms.drive.internal.CreateFolderRequest) r0
            L_0x00d6:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CreateFolderRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00e7:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenContentsRequest> r0 = com.google.android.gms.drive.internal.OpenContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenContentsRequest r0 = (com.google.android.gms.drive.internal.OpenContentsRequest) r0
            L_0x00fa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                com.google.android.gms.drive.internal.DriveServiceResponse r0 = r5.zza((com.google.android.gms.drive.internal.OpenContentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0114
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0111:
                r0 = r1
                goto L_0x000a
            L_0x0114:
                r8.writeInt(r3)
                goto L_0x0111
            L_0x0118:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x012b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsRequest> r0 = com.google.android.gms.drive.internal.CloseContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsRequest r0 = (com.google.android.gms.drive.internal.CloseContentsRequest) r0
            L_0x012b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CloseContentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x013c:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.zzan) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0152:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0165
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.OpenFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0
            L_0x0165:
                android.content.IntentSender r0 = r5.zza((com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0177
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0174:
                r0 = r1
                goto L_0x000a
            L_0x0177:
                r8.writeInt(r3)
                goto L_0x0174
            L_0x017b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x018e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.CreateFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0
            L_0x018e:
                android.content.IntentSender r0 = r5.zza((com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x01a0
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x019d:
                r0 = r1
                goto L_0x000a
            L_0x01a0:
                r8.writeInt(r3)
                goto L_0x019d
            L_0x01a4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01b7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AuthorizeAccessRequest> r0 = com.google.android.gms.drive.internal.AuthorizeAccessRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AuthorizeAccessRequest r0 = (com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0
            L_0x01b7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01c8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01db
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ListParentsRequest> r0 = com.google.android.gms.drive.internal.ListParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ListParentsRequest r0 = (com.google.android.gms.drive.internal.ListParentsRequest) r0
            L_0x01db:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.ListParentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01ec:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01ff
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddEventListenerRequest> r0 = com.google.android.gms.drive.internal.AddEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddEventListenerRequest r0 = (com.google.android.gms.drive.internal.AddEventListenerRequest) r0
            L_0x01ff:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r2 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r4 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r4)
                r5.zza((com.google.android.gms.drive.internal.AddEventListenerRequest) r0, (com.google.android.gms.drive.internal.zzao) r2, (java.lang.String) r3, (com.google.android.gms.drive.internal.zzan) r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x021c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x022f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemoveEventListenerRequest> r0 = com.google.android.gms.drive.internal.RemoveEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemoveEventListenerRequest r0 = (com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0
            L_0x022f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r2 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r4 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r4)
                r5.zza((com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0, (com.google.android.gms.drive.internal.zzao) r2, (java.lang.String) r3, (com.google.android.gms.drive.internal.zzan) r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x024c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x025f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DisconnectRequest> r0 = com.google.android.gms.drive.internal.DisconnectRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DisconnectRequest r0 = (com.google.android.gms.drive.internal.DisconnectRequest) r0
            L_0x025f:
                r5.zza((com.google.android.gms.drive.internal.DisconnectRequest) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0268:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x027b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.TrashResourceRequest> r0 = com.google.android.gms.drive.internal.TrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.TrashResourceRequest r0 = (com.google.android.gms.drive.internal.TrashResourceRequest) r0
            L_0x027b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.TrashResourceRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x028c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x029f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0
            L_0x029f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02b0:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x02c3
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x02c3:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zzb(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02d4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x02e7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DeleteResourceRequest> r0 = com.google.android.gms.drive.internal.DeleteResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DeleteResourceRequest r0 = (com.google.android.gms.drive.internal.DeleteResourceRequest) r0
            L_0x02e7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.DeleteResourceRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02f8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x030b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.LoadRealtimeRequest> r0 = com.google.android.gms.drive.internal.LoadRealtimeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.LoadRealtimeRequest r0 = (com.google.android.gms.drive.internal.LoadRealtimeRequest) r0
            L_0x030b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.LoadRealtimeRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x031c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x032f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetResourceParentsRequest> r0 = com.google.android.gms.drive.internal.SetResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetResourceParentsRequest r0 = (com.google.android.gms.drive.internal.SetResourceParentsRequest) r0
            L_0x032f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.SetResourceParentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0340:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0353
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest> r0 = com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest r0 = (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r0
            L_0x0353:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0364:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0377
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CheckResourceIdsExistRequest> r0 = com.google.android.gms.drive.internal.CheckResourceIdsExistRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CheckResourceIdsExistRequest r0 = (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r0
            L_0x0377:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0388:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzb(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x039e:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzc(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03b4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x03c7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest> r0 = com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest r0 = (com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest) r0
            L_0x03c7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03d8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x03eb
                android.os.Parcelable$Creator<com.google.android.gms.drive.RealtimeDocumentSyncRequest> r0 = com.google.android.gms.drive.RealtimeDocumentSyncRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.RealtimeDocumentSyncRequest r0 = (com.google.android.gms.drive.RealtimeDocumentSyncRequest) r0
            L_0x03eb:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.RealtimeDocumentSyncRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03fc:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzd(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0412:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0425
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest> r0 = com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest r0 = (com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest) r0
            L_0x0425:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0436:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0449
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CancelPendingActionsRequest> r0 = com.google.android.gms.drive.internal.CancelPendingActionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CancelPendingActionsRequest r0 = (com.google.android.gms.drive.internal.CancelPendingActionsRequest) r0
            L_0x0449:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.CancelPendingActionsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x045a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x046d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UntrashResourceRequest> r0 = com.google.android.gms.drive.internal.UntrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UntrashResourceRequest r0 = (com.google.android.gms.drive.internal.UntrashResourceRequest) r0
            L_0x046d:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.UntrashResourceRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x047e:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zze(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0494:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x04a7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.FetchThumbnailRequest> r0 = com.google.android.gms.drive.internal.FetchThumbnailRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.FetchThumbnailRequest r0 = (com.google.android.gms.drive.internal.FetchThumbnailRequest) r0
            L_0x04a7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.FetchThumbnailRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04b8:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzf(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04ce:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x04e1
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetChangesRequest> r0 = com.google.android.gms.drive.internal.GetChangesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetChangesRequest r0 = (com.google.android.gms.drive.internal.GetChangesRequest) r0
            L_0x04e1:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.GetChangesRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04f2:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0505
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UnsubscribeResourceRequest> r0 = com.google.android.gms.drive.internal.UnsubscribeResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UnsubscribeResourceRequest r0 = (com.google.android.gms.drive.internal.UnsubscribeResourceRequest) r0
            L_0x0505:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.UnsubscribeResourceRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0516:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0529
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsRequest> r0 = com.google.android.gms.drive.internal.GetPermissionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetPermissionsRequest r0 = (com.google.android.gms.drive.internal.GetPermissionsRequest) r0
            L_0x0529:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.GetPermissionsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x053a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x054d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddPermissionRequest> r0 = com.google.android.gms.drive.internal.AddPermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddPermissionRequest r0 = (com.google.android.gms.drive.internal.AddPermissionRequest) r0
            L_0x054d:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.AddPermissionRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x055e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0571
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdatePermissionRequest> r0 = com.google.android.gms.drive.internal.UpdatePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdatePermissionRequest r0 = (com.google.android.gms.drive.internal.UpdatePermissionRequest) r0
            L_0x0571:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.UpdatePermissionRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0582:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0595
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemovePermissionRequest> r0 = com.google.android.gms.drive.internal.RemovePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemovePermissionRequest r0 = (com.google.android.gms.drive.internal.RemovePermissionRequest) r0
            L_0x0595:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.RemovePermissionRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05a6:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x05b9
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x05b9:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r2 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r2)
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r3 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r3)
                r5.zza(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05d2:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r0 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r0)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.zzao) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05f0:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0603
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ControlProgressRequest> r0 = com.google.android.gms.drive.internal.ControlProgressRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ControlProgressRequest r0 = (com.google.android.gms.drive.internal.ControlProgressRequest) r0
            L_0x0603:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.ControlProgressRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0614:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzg(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x062a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x063d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ChangeResourceParentsRequest> r0 = com.google.android.gms.drive.internal.ChangeResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ChangeResourceParentsRequest r0 = (com.google.android.gms.drive.internal.ChangeResourceParentsRequest) r0
            L_0x063d:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza((com.google.android.gms.drive.internal.ChangeResourceParentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x064e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0661
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.StreamContentsRequest> r0 = com.google.android.gms.drive.internal.StreamContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.StreamContentsRequest r0 = (com.google.android.gms.drive.internal.StreamContentsRequest) r0
            L_0x0661:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                com.google.android.gms.drive.internal.DriveServiceResponse r0 = r5.zza((com.google.android.gms.drive.internal.StreamContentsRequest) r0, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                if (r0 == 0) goto L_0x067b
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0678:
                r0 = r1
                goto L_0x000a
            L_0x067b:
                r8.writeInt(r3)
                goto L_0x0678
            L_0x067f:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzh(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzam.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzan) throws RemoteException;

    DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzan) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzan) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzan zzan) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzan) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzan) throws RemoteException;

    void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzan) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzan) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzan) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzan zzan) throws RemoteException;

    void zza(ControlProgressRequest controlProgressRequest, zzan zzan) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzan zzan) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzan zzan) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzan zzan) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzan zzan) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzan) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzan zzan) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzan) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzan zzan) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzan zzan) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzan zzan) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzan) throws RemoteException;

    void zza(QueryRequest queryRequest, zzan zzan) throws RemoteException;

    void zza(QueryRequest queryRequest, zzao zzao, zzan zzan) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzan zzan) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzan) throws RemoteException;

    void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzan) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzan) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzan zzan) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzan) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzan zzan) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzan) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzan) throws RemoteException;

    void zza(zzan zzan) throws RemoteException;

    void zza(zzao zzao, zzan zzan) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzan zzan) throws RemoteException;

    void zzb(zzan zzan) throws RemoteException;

    void zzc(zzan zzan) throws RemoteException;

    void zzd(zzan zzan) throws RemoteException;

    void zze(zzan zzan) throws RemoteException;

    void zzf(zzan zzan) throws RemoteException;

    void zzg(zzan zzan) throws RemoteException;

    void zzh(zzan zzan) throws RemoteException;
}
