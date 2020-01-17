package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public interface zzj extends IInterface {

    public static abstract class zza extends Binder implements zzj {

        /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzj$zza$zza  reason: collision with other inner class name */
        private static class C0024zza implements zzj {
            private IBinder zzoz;

            C0024zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzi zzi) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzi zzi, CredentialRequest credentialRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    if (credentialRequest != null) {
                        obtain.writeInt(1);
                        credentialRequest.writeToParcel(obtain, 0);
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

            public void zza(zzi zzi, DeleteRequest deleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    if (deleteRequest != null) {
                        obtain.writeInt(1);
                        deleteRequest.writeToParcel(obtain, 0);
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

            public void zza(zzi zzi, GeneratePasswordRequest generatePasswordRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    if (generatePasswordRequest != null) {
                        obtain.writeInt(1);
                        generatePasswordRequest.writeToParcel(obtain, 0);
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

            public void zza(zzi zzi, SaveRequest saveRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    if (saveRequest != null) {
                        obtain.writeInt(1);
                        saveRequest.writeToParcel(obtain, 0);
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

        public static zzj zzax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzj)) ? new C0024zza(iBinder) : (zzj) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.gms.auth.api.credentials.internal.DeleteRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.auth.api.credentials.internal.SaveRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.google.android.gms.auth.api.credentials.CredentialRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
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
                    case 3: goto L_0x0057;
                    case 4: goto L_0x007a;
                    case 5: goto L_0x0090;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.credentials.internal.zzi r2 = com.google.android.gms.auth.api.credentials.internal.zzi.zza.zzaw(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.CredentialRequest> r0 = com.google.android.gms.auth.api.credentials.CredentialRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.credentials.CredentialRequest r0 = (com.google.android.gms.auth.api.credentials.CredentialRequest) r0
            L_0x002c:
                r4.zza((com.google.android.gms.auth.api.credentials.internal.zzi) r2, (com.google.android.gms.auth.api.credentials.CredentialRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0034:
                java.lang.String r2 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.credentials.internal.zzi r2 = com.google.android.gms.auth.api.credentials.internal.zzi.zza.zzaw(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x004f
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.internal.SaveRequest> r0 = com.google.android.gms.auth.api.credentials.internal.SaveRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.credentials.internal.SaveRequest r0 = (com.google.android.gms.auth.api.credentials.internal.SaveRequest) r0
            L_0x004f:
                r4.zza((com.google.android.gms.auth.api.credentials.internal.zzi) r2, (com.google.android.gms.auth.api.credentials.internal.SaveRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0057:
                java.lang.String r2 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.credentials.internal.zzi r2 = com.google.android.gms.auth.api.credentials.internal.zzi.zza.zzaw(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0072
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.internal.DeleteRequest> r0 = com.google.android.gms.auth.api.credentials.internal.DeleteRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.credentials.internal.DeleteRequest r0 = (com.google.android.gms.auth.api.credentials.internal.DeleteRequest) r0
            L_0x0072:
                r4.zza((com.google.android.gms.auth.api.credentials.internal.zzi) r2, (com.google.android.gms.auth.api.credentials.internal.DeleteRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007a:
                java.lang.String r0 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.auth.api.credentials.internal.zzi r0 = com.google.android.gms.auth.api.credentials.internal.zzi.zza.zzaw(r0)
                r4.zza(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0090:
                java.lang.String r2 = "com.google.android.gms.auth.api.credentials.internal.ICredentialsService"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.auth.api.credentials.internal.zzi r2 = com.google.android.gms.auth.api.credentials.internal.zzi.zza.zzaw(r2)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x00ab
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest> r0 = com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest r0 = (com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest) r0
            L_0x00ab:
                r4.zza((com.google.android.gms.auth.api.credentials.internal.zzi) r2, (com.google.android.gms.auth.api.credentials.internal.GeneratePasswordRequest) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.internal.zzj.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzi zzi) throws RemoteException;

    void zza(zzi zzi, CredentialRequest credentialRequest) throws RemoteException;

    void zza(zzi zzi, DeleteRequest deleteRequest) throws RemoteException;

    void zza(zzi zzi, GeneratePasswordRequest generatePasswordRequest) throws RemoteException;

    void zza(zzi zzi, SaveRequest saveRequest) throws RemoteException;
}
