package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;

public interface zzqh extends IInterface {

    public static abstract class zza extends Binder implements zzqh {

        /* renamed from: com.google.android.gms.internal.zzqh$zza$zza  reason: collision with other inner class name */
        private static class C0139zza implements zzqh {
            private IBinder zzoz;

            C0139zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzqg zzqg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    obtain.writeStrongBinder(zzqg != null ? zzqg.asBinder() : null);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ConnectRequest connectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (connectRequest != null) {
                        obtain.writeInt(1);
                        connectRequest.writeToParcel(obtain, 0);
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

            public void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (continueConnectRequest != null) {
                        obtain.writeInt(1);
                        continueConnectRequest.writeToParcel(obtain, 0);
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

            public void zza(DisableTargetRequest disableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disableTargetRequest != null) {
                        obtain.writeInt(1);
                        disableTargetRequest.writeToParcel(obtain, 0);
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

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
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

            public void zza(EnableTargetRequest enableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (enableTargetRequest != null) {
                        obtain.writeInt(1);
                        enableTargetRequest.writeToParcel(obtain, 0);
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

            public void zza(SendDataRequest sendDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (sendDataRequest != null) {
                        obtain.writeInt(1);
                        sendDataRequest.writeToParcel(obtain, 0);
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

            public void zza(StartScanRequest startScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (startScanRequest != null) {
                        obtain.writeInt(1);
                        startScanRequest.writeToParcel(obtain, 0);
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

            public void zza(StopScanRequest stopScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (stopScanRequest != null) {
                        obtain.writeInt(1);
                        stopScanRequest.writeToParcel(obtain, 0);
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
        }

        public static zzqh zzdt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqh)) ? new C0139zza(iBinder) : (zzqh) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.google.android.gms.nearby.bootstrap.request.SendDataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.nearby.bootstrap.request.DisconnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.google.android.gms.nearby.bootstrap.request.ConnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: com.google.android.gms.nearby.bootstrap.request.StopScanRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: com.google.android.gms.nearby.bootstrap.request.StartScanRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: type inference failed for: r0v46 */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002a;
                    case 3: goto L_0x0043;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x0075;
                    case 6: goto L_0x008f;
                    case 7: goto L_0x00a9;
                    case 8: goto L_0x00c3;
                    case 9: goto L_0x00dd;
                    case 10: goto L_0x00ef;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.nearby.bootstrap.request.zzg r0 = com.google.android.gms.nearby.bootstrap.request.StartScanRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.StartScanRequest r0 = r0.createFromParcel(r5)
            L_0x0022:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.StartScanRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002a:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003b
                com.google.android.gms.nearby.bootstrap.request.zzh r0 = com.google.android.gms.nearby.bootstrap.request.StopScanRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.StopScanRequest r0 = r0.createFromParcel(r5)
            L_0x003b:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.StopScanRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0043:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                com.google.android.gms.nearby.bootstrap.request.zze r0 = com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest r0 = r0.createFromParcel(r5)
            L_0x0054:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x005c:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006d
                com.google.android.gms.nearby.bootstrap.request.zzc r0 = com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest r0 = r0.createFromParcel(r5)
            L_0x006d:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0075:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0086
                com.google.android.gms.nearby.bootstrap.request.zza r0 = com.google.android.gms.nearby.bootstrap.request.ConnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.ConnectRequest r0 = r0.createFromParcel(r5)
            L_0x0086:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.ConnectRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x008f:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00a0
                com.google.android.gms.nearby.bootstrap.request.zzd r0 = com.google.android.gms.nearby.bootstrap.request.DisconnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.DisconnectRequest r0 = r0.createFromParcel(r5)
            L_0x00a0:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.DisconnectRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00a9:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ba
                com.google.android.gms.nearby.bootstrap.request.zzf r0 = com.google.android.gms.nearby.bootstrap.request.SendDataRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.SendDataRequest r0 = r0.createFromParcel(r5)
            L_0x00ba:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.SendDataRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00d4
                com.google.android.gms.nearby.bootstrap.request.zzb r0 = com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest r0 = r0.createFromParcel(r5)
            L_0x00d4:
                r3.zza((com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00dd:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r0)
                java.lang.String r0 = r3.getToken()
                r6.writeNoException()
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x00ef:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.internal.zzqg r0 = com.google.android.gms.internal.zzqg.zza.zzds(r0)
                r3.zza((com.google.android.gms.internal.zzqg) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqh.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    String getToken() throws RemoteException;

    void zza(zzqg zzqg) throws RemoteException;

    void zza(ConnectRequest connectRequest) throws RemoteException;

    void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException;

    void zza(DisableTargetRequest disableTargetRequest) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(EnableTargetRequest enableTargetRequest) throws RemoteException;

    void zza(SendDataRequest sendDataRequest) throws RemoteException;

    void zza(StartScanRequest startScanRequest) throws RemoteException;

    void zza(StopScanRequest stopScanRequest) throws RemoteException;
}
