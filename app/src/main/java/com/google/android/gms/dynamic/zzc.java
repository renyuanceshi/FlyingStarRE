package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.dynamic.zzc$zza$zza  reason: collision with other inner class name */
        private static class C0059zza implements zzc {
            private IBinder zzoz;

            C0059zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Bundle getArguments() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getRetainInstance() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getUserVisibleHint() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdded() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isDetached() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isHidden() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isInLayout() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isRemoving() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isResumed() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isVisible() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHasOptionsMenu(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMenuVisibility(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRetainInstance(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserVisibleHint(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zztV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzc zztW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zza.zzbr(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zztX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzc zztY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return zza.zzbr(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static zzc zzbr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C0059zza(iBinder) : (zzc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r0v10, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r0v52, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v61, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v73, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v76, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v86, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v92 */
        /* JADX WARNING: type inference failed for: r0v93 */
        /* JADX WARNING: type inference failed for: r0v94 */
        /* JADX WARNING: type inference failed for: r0v95 */
        /* JADX WARNING: type inference failed for: r0v96 */
        /* JADX WARNING: type inference failed for: r0v97 */
        /* JADX WARNING: type inference failed for: r0v98 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                switch(r4) {
                    case 2: goto L_0x0012;
                    case 3: goto L_0x0029;
                    case 4: goto L_0x0044;
                    case 5: goto L_0x0055;
                    case 6: goto L_0x006c;
                    case 7: goto L_0x0083;
                    case 8: goto L_0x009a;
                    case 9: goto L_0x00ac;
                    case 10: goto L_0x00c4;
                    case 11: goto L_0x00d6;
                    case 12: goto L_0x00eb;
                    case 13: goto L_0x0103;
                    case 14: goto L_0x0118;
                    case 15: goto L_0x012d;
                    case 16: goto L_0x0142;
                    case 17: goto L_0x0157;
                    case 18: goto L_0x016c;
                    case 19: goto L_0x0181;
                    case 20: goto L_0x0196;
                    case 21: goto L_0x01ac;
                    case 22: goto L_0x01c1;
                    case 23: goto L_0x01d6;
                    case 24: goto L_0x01eb;
                    case 25: goto L_0x0200;
                    case 26: goto L_0x021c;
                    case 27: goto L_0x023c;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r6.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r3.zztV()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0024
                android.os.IBinder r0 = r2.asBinder()
            L_0x0024:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x000a
            L_0x0029:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                android.os.Bundle r0 = r3.getArguments()
                r6.writeNoException()
                if (r0 == 0) goto L_0x003f
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
                r0 = r1
                goto L_0x000a
            L_0x003f:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r3.getId()
                r6.writeNoException()
                r6.writeInt(r0)
                r0 = r1
                goto L_0x000a
            L_0x0055:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzc r2 = r3.zztW()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0067
                android.os.IBinder r0 = r2.asBinder()
            L_0x0067:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x000a
            L_0x006c:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r3.zztX()
                r6.writeNoException()
                if (r2 == 0) goto L_0x007e
                android.os.IBinder r0 = r2.asBinder()
            L_0x007e:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x000a
            L_0x0083:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.getRetainInstance()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0098
                r0 = r1
            L_0x0092:
                r6.writeInt(r0)
                r0 = r1
                goto L_0x000a
            L_0x0098:
                r0 = r2
                goto L_0x0092
            L_0x009a:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                java.lang.String r0 = r3.getTag()
                r6.writeNoException()
                r6.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x00ac:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzc r2 = r3.zztY()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00be
                android.os.IBinder r0 = r2.asBinder()
            L_0x00be:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x000a
            L_0x00c4:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r3.getTargetRequestCode()
                r6.writeNoException()
                r6.writeInt(r0)
                r0 = r1
                goto L_0x000a
            L_0x00d6:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.getUserVisibleHint()
                r6.writeNoException()
                if (r0 == 0) goto L_0x00e5
                r2 = r1
            L_0x00e5:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x00eb:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r3.getView()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00fd
                android.os.IBinder r0 = r2.asBinder()
            L_0x00fd:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x000a
            L_0x0103:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isAdded()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0112
                r2 = r1
            L_0x0112:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0118:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isDetached()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0127
                r2 = r1
            L_0x0127:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x012d:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isHidden()
                r6.writeNoException()
                if (r0 == 0) goto L_0x013c
                r2 = r1
            L_0x013c:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0142:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isInLayout()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0151
                r2 = r1
            L_0x0151:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0157:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isRemoving()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0166
                r2 = r1
            L_0x0166:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x016c:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isResumed()
                r6.writeNoException()
                if (r0 == 0) goto L_0x017b
                r2 = r1
            L_0x017b:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0181:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                boolean r0 = r3.isVisible()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0190
                r2 = r1
            L_0x0190:
                r6.writeInt(r2)
                r0 = r1
                goto L_0x000a
            L_0x0196:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.dynamic.zzd r0 = com.google.android.gms.dynamic.zzd.zza.zzbs(r0)
                r3.zzn(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01ac:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x01b8
                r2 = r1
            L_0x01b8:
                r3.setHasOptionsMenu(r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01c1:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x01cd
                r2 = r1
            L_0x01cd:
                r3.setMenuVisibility(r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01d6:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x01e2
                r2 = r1
            L_0x01e2:
                r3.setRetainInstance(r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01eb:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x01f7
                r2 = r1
            L_0x01f7:
                r3.setUserVisibleHint(r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0200:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0213
                android.os.Parcelable$Creator r0 = android.content.Intent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x0213:
                r3.startActivity(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x021c:
                java.lang.String r2 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x022f
                android.os.Parcelable$Creator r0 = android.content.Intent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x022f:
                int r2 = r5.readInt()
                r3.startActivityForResult(r0, r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x023c:
                java.lang.String r0 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.dynamic.zzd r0 = com.google.android.gms.dynamic.zzd.zza.zzbs(r0)
                r3.zzo(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void zzn(zzd zzd) throws RemoteException;

    void zzo(zzd zzd) throws RemoteException;

    zzd zztV() throws RemoteException;

    zzc zztW() throws RemoteException;

    zzd zztX() throws RemoteException;

    zzc zztY() throws RemoteException;
}
