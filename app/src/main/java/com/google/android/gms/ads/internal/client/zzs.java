package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;

public interface zzs extends IInterface {

    public static abstract class zza extends Binder implements zzs {

        /* renamed from: com.google.android.gms.ads.internal.client.zzs$zza$zza  reason: collision with other inner class name */
        private static class C0003zza implements zzs {
            private IBinder zzoz;

            C0003zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
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

            public void zza(zzcr zzcr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzcr != null ? zzcr.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcs zzcs) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzcs != null ? zzcs.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzcu zzcu, zzct zzct) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzcu != null ? zzcu.asBinder() : null);
                    if (zzct != null) {
                        iBinder = zzct.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzq zzq) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzx zzx) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzx != null ? zzx.asBinder() : null);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzr zzbn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzr.zza.zzh(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzs zzi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new C0003zza(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v24, types: [android.os.IBinder] */
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
                    case 2: goto L_0x0028;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0052;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0088;
                    case 7: goto L_0x00a2;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzr r2 = r4.zzbn()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzq r0 = com.google.android.gms.ads.internal.client.zzq.zza.zzg(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzq) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcr r0 = com.google.android.gms.internal.zzcr.zza.zzz(r0)
                r4.zza((com.google.android.gms.internal.zzcr) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcs r0 = com.google.android.gms.internal.zzcs.zza.zzA(r0)
                r4.zza((com.google.android.gms.internal.zzcs) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcu r2 = com.google.android.gms.internal.zzcu.zza.zzC(r2)
                android.os.IBinder r3 = r6.readStrongBinder()
                com.google.android.gms.internal.zzct r3 = com.google.android.gms.internal.zzct.zza.zzB(r3)
                r4.zza(r0, r2, r3)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0088:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0099
                com.google.android.gms.ads.internal.formats.zzj r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = r0.createFromParcel(r6)
            L_0x0099:
                r4.zza((com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00a2:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzx r0 = com.google.android.gms.ads.internal.client.zzx.zza.zzn(r0)
                r4.zzb((com.google.android.gms.ads.internal.client.zzx) r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzs.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException;

    void zza(zzcr zzcr) throws RemoteException;

    void zza(zzcs zzcs) throws RemoteException;

    void zza(String str, zzcu zzcu, zzct zzct) throws RemoteException;

    void zzb(zzq zzq) throws RemoteException;

    void zzb(zzx zzx) throws RemoteException;

    zzr zzbn() throws RemoteException;
}
