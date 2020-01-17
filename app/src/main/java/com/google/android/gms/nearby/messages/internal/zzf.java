package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        /* renamed from: com.google.android.gms.nearby.messages.internal.zzf$zza$zza  reason: collision with other inner class name */
        private static class C0223zza implements zzf {
            private IBinder zzoz;

            C0223zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (getPermissionStatusRequest != null) {
                        obtain.writeInt(1);
                        getPermissionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (handleClientLifecycleEventRequest != null) {
                        obtain.writeInt(1);
                        handleClientLifecycleEventRequest.writeToParcel(obtain, 0);
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

            public void zza(PublishRequest publishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (publishRequest != null) {
                        obtain.writeInt(1);
                        publishRequest.writeToParcel(obtain, 0);
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

            public void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (registerStatusCallbackRequest != null) {
                        obtain.writeInt(1);
                        registerStatusCallbackRequest.writeToParcel(obtain, 0);
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

            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
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

            public void zza(UnpublishRequest unpublishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unpublishRequest != null) {
                        obtain.writeInt(1);
                        unpublishRequest.writeToParcel(obtain, 0);
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

            public void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
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

            public void zzfB(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    obtain.writeString(str);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzf zzdA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new C0223zza(iBinder) : (zzf) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.nearby.messages.internal.UnsubscribeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.gms.nearby.messages.internal.SubscribeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.google.android.gms.nearby.messages.internal.UnpublishRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.google.android.gms.nearby.messages.internal.PublishRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v42 */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: type inference failed for: r0v46 */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002c;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x0062;
                    case 6: goto L_0x007d;
                    case 7: goto L_0x008f;
                    case 8: goto L_0x00ab;
                    case 9: goto L_0x00c7;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.PublishRequest> r0 = com.google.android.gms.nearby.messages.internal.PublishRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.PublishRequest r0 = (com.google.android.gms.nearby.messages.internal.PublishRequest) r0
            L_0x0024:
                r3.zza((com.google.android.gms.nearby.messages.internal.PublishRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002c:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003f
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.UnpublishRequest> r0 = com.google.android.gms.nearby.messages.internal.UnpublishRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.UnpublishRequest r0 = (com.google.android.gms.nearby.messages.internal.UnpublishRequest) r0
            L_0x003f:
                r3.zza((com.google.android.gms.nearby.messages.internal.UnpublishRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.SubscribeRequest> r0 = com.google.android.gms.nearby.messages.internal.SubscribeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.SubscribeRequest r0 = (com.google.android.gms.nearby.messages.internal.SubscribeRequest) r0
            L_0x005a:
                r3.zza((com.google.android.gms.nearby.messages.internal.SubscribeRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.UnsubscribeRequest> r0 = com.google.android.gms.nearby.messages.internal.UnsubscribeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.UnsubscribeRequest r0 = (com.google.android.gms.nearby.messages.internal.UnsubscribeRequest) r0
            L_0x0075:
                r3.zza((com.google.android.gms.nearby.messages.internal.UnsubscribeRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r0 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r0)
                java.lang.String r0 = r5.readString()
                r3.zzfB(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x008f:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00a2
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest> r0 = com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest r0 = (com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest) r0
            L_0x00a2:
                r3.zza((com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00ab:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00be
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest> r0 = com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest r0 = (com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest) r0
            L_0x00be:
                r3.zza((com.google.android.gms.nearby.messages.internal.RegisterStatusCallbackRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00c7:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00da
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest> r0 = com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest r0 = (com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest) r0
            L_0x00da:
                r3.zza((com.google.android.gms.nearby.messages.internal.HandleClientLifecycleEventRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzf.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException;

    void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest) throws RemoteException;

    void zza(PublishRequest publishRequest) throws RemoteException;

    void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest) throws RemoteException;

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(UnpublishRequest unpublishRequest) throws RemoteException;

    void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException;

    void zzfB(String str) throws RemoteException;
}
