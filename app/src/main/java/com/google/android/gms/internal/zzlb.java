package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public interface zzlb extends IInterface {

    public static abstract class zza extends Binder implements zzlb {

        /* renamed from: com.google.android.gms.internal.zzlb$zza$zza  reason: collision with other inner class name */
        private static class C0103zza implements zzlb {
            private IBinder zzoz;

            C0103zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzla zzla, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzla != null ? zzla.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
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

            public void zza(zzla zzla, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzla != null ? zzla.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
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
        }

        public static zzlb zzaA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlb)) ? new C0103zza(iBinder) : (zzlb) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.auth.api.proxy.ProxyGrpcRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.auth.api.proxy.ProxyRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v14 */
        /* JADX WARNING: type inference failed for: r0v15 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0034;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.auth.api.internal.IAuthService"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.auth.api.internal.IAuthService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzla r2 = com.google.android.gms.internal.zzla.zza.zzaz(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.proxy.ProxyRequest> r0 = com.google.android.gms.auth.api.proxy.ProxyRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.proxy.ProxyRequest r0 = (com.google.android.gms.auth.api.proxy.ProxyRequest) r0
            L_0x002c:
                r4.zza((com.google.android.gms.internal.zzla) r2, (com.google.android.gms.auth.api.proxy.ProxyRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0034:
                java.lang.String r2 = "com.google.android.gms.auth.api.internal.IAuthService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzla r2 = com.google.android.gms.internal.zzla.zza.zzaz(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x004f
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.proxy.ProxyGrpcRequest> r0 = com.google.android.gms.auth.api.proxy.ProxyGrpcRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.proxy.ProxyGrpcRequest r0 = (com.google.android.gms.auth.api.proxy.ProxyGrpcRequest) r0
            L_0x004f:
                r4.zza((com.google.android.gms.internal.zzla) r2, (com.google.android.gms.auth.api.proxy.ProxyGrpcRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlb.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzla zzla, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzla zzla, ProxyRequest proxyRequest) throws RemoteException;
}
