package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import java.util.List;

public interface zzey extends IInterface {

    public static abstract class zza extends Binder implements zzey {

        /* renamed from: com.google.android.gms.internal.zzey$zza$zza  reason: collision with other inner class name */
        private static class C0082zza implements zzey {
            private IBinder zzoz;

            C0082zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getInterstitialAdapterInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isInitialized() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showVideo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza, String str2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzez != null) {
                        iBinder = zzez.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzez != null) {
                        iBinder = zzez.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzez != null) {
                        iBinder = zzez.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzez != null) {
                        iBinder = zzez.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzez != null) {
                        iBinder = zzez.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzfb zzeF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzfb.zza.zzI(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzfc zzeG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzfc.zza.zzJ(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzeH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zzeI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzey zzF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzey)) ? new C0082zza(iBinder) : (zzey) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.ads.internal.client.AdRequestParcel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: com.google.android.gms.ads.internal.client.AdRequestParcel} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: com.google.android.gms.ads.internal.client.AdRequestParcel} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v10, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v12, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v41, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: type inference failed for: r0v51 */
        /* JADX WARNING: type inference failed for: r0v52 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r1 = 0
                r8 = 1
                r0 = 0
                switch(r10) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x004e;
                    case 3: goto L_0x0064;
                    case 4: goto L_0x0091;
                    case 5: goto L_0x009e;
                    case 6: goto L_0x00ab;
                    case 7: goto L_0x00ed;
                    case 8: goto L_0x0121;
                    case 9: goto L_0x012e;
                    case 10: goto L_0x013b;
                    case 11: goto L_0x016f;
                    case 12: goto L_0x018c;
                    case 13: goto L_0x0199;
                    case 14: goto L_0x01af;
                    case 15: goto L_0x01f5;
                    case 16: goto L_0x020c;
                    case 17: goto L_0x0223;
                    case 18: goto L_0x023e;
                    case 19: goto L_0x0259;
                    case 20: goto L_0x0274;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r8 = super.onTransact(r10, r11, r12, r13)
            L_0x000a:
                return r8
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r12.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x004a
                com.google.android.gms.ads.internal.client.zzi r2 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r2.createFromParcel(r11)
            L_0x002a:
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x004c
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r3 = r0.createFromParcel(r11)
            L_0x0036:
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzez r5 = com.google.android.gms.internal.zzez.zza.zzG(r0)
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdSizeParcel) r2, (com.google.android.gms.ads.internal.client.AdRequestParcel) r3, (java.lang.String) r4, (com.google.android.gms.internal.zzez) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x004a:
                r2 = r0
                goto L_0x002a
            L_0x004c:
                r3 = r0
                goto L_0x0036
            L_0x004e:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.dynamic.zzd r1 = r9.getView()
                r12.writeNoException()
                if (r1 == 0) goto L_0x0060
                android.os.IBinder r0 = r1.asBinder()
            L_0x0060:
                r12.writeStrongBinder(r0)
                goto L_0x000a
            L_0x0064:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x007d
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.createFromParcel(r11)
            L_0x007d:
                java.lang.String r2 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.internal.zzez r3 = com.google.android.gms.internal.zzez.zza.zzG(r3)
                r9.zza(r1, r0, r2, r3)
                r12.writeNoException()
                goto L_0x000a
            L_0x0091:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showInterstitial()
                r12.writeNoException()
                goto L_0x000a
            L_0x009e:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.destroy()
                r12.writeNoException()
                goto L_0x000a
            L_0x00ab:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00e9
                com.google.android.gms.ads.internal.client.zzi r2 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r2.createFromParcel(r11)
            L_0x00c4:
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x00eb
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r3 = r0.createFromParcel(r11)
            L_0x00d0:
                java.lang.String r4 = r11.readString()
                java.lang.String r5 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzez r6 = com.google.android.gms.internal.zzez.zza.zzG(r0)
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6)
                r12.writeNoException()
                goto L_0x000a
            L_0x00e9:
                r2 = r0
                goto L_0x00c4
            L_0x00eb:
                r3 = r0
                goto L_0x00d0
            L_0x00ed:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x011f
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r0.createFromParcel(r11)
            L_0x0106:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzez r5 = com.google.android.gms.internal.zzez.zza.zzG(r0)
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdRequestParcel) r2, (java.lang.String) r3, (java.lang.String) r4, (com.google.android.gms.internal.zzez) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x011f:
                r2 = r0
                goto L_0x0106
            L_0x0121:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.pause()
                r12.writeNoException()
                goto L_0x000a
            L_0x012e:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.resume()
                r12.writeNoException()
                goto L_0x000a
            L_0x013b:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x016d
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r0.createFromParcel(r11)
            L_0x0154:
                java.lang.String r3 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.ads.internal.reward.mediation.client.zza r4 = com.google.android.gms.ads.internal.reward.mediation.client.zza.C0020zza.zzae(r0)
                java.lang.String r5 = r11.readString()
                r0 = r9
                r0.zza((com.google.android.gms.dynamic.zzd) r1, (com.google.android.gms.ads.internal.client.AdRequestParcel) r2, (java.lang.String) r3, (com.google.android.gms.ads.internal.reward.mediation.client.zza) r4, (java.lang.String) r5)
                r12.writeNoException()
                goto L_0x000a
            L_0x016d:
                r2 = r0
                goto L_0x0154
            L_0x016f:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                int r1 = r11.readInt()
                if (r1 == 0) goto L_0x0180
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.createFromParcel(r11)
            L_0x0180:
                java.lang.String r1 = r11.readString()
                r9.zzb(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x018c:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showVideo()
                r12.writeNoException()
                goto L_0x000a
            L_0x0199:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                boolean r0 = r9.isInitialized()
                r12.writeNoException()
                if (r0 == 0) goto L_0x01ad
                r0 = r8
            L_0x01a8:
                r12.writeInt(r0)
                goto L_0x000a
            L_0x01ad:
                r0 = r1
                goto L_0x01a8
            L_0x01af:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbs(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x01f1
                com.google.android.gms.ads.internal.client.zzg r2 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r2.createFromParcel(r11)
            L_0x01c8:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r5 = r11.readStrongBinder()
                com.google.android.gms.internal.zzez r5 = com.google.android.gms.internal.zzez.zza.zzG(r5)
                int r6 = r11.readInt()
                if (r6 == 0) goto L_0x01f3
                com.google.android.gms.ads.internal.formats.zzj r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r6 = r0.createFromParcel(r11)
            L_0x01e4:
                java.util.ArrayList r7 = r11.createStringArrayList()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6, r7)
                r12.writeNoException()
                goto L_0x000a
            L_0x01f1:
                r2 = r0
                goto L_0x01c8
            L_0x01f3:
                r6 = r0
                goto L_0x01e4
            L_0x01f5:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.internal.zzfb r1 = r9.zzeF()
                r12.writeNoException()
                if (r1 == 0) goto L_0x0207
                android.os.IBinder r0 = r1.asBinder()
            L_0x0207:
                r12.writeStrongBinder(r0)
                goto L_0x000a
            L_0x020c:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.internal.zzfc r1 = r9.zzeG()
                r12.writeNoException()
                if (r1 == 0) goto L_0x021e
                android.os.IBinder r0 = r1.asBinder()
            L_0x021e:
                r12.writeStrongBinder(r0)
                goto L_0x000a
            L_0x0223:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.Bundle r0 = r9.zzeH()
                r12.writeNoException()
                if (r0 == 0) goto L_0x0239
                r12.writeInt(r8)
                r0.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x0239:
                r12.writeInt(r1)
                goto L_0x000a
            L_0x023e:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.Bundle r0 = r9.getInterstitialAdapterInfo()
                r12.writeNoException()
                if (r0 == 0) goto L_0x0254
                r12.writeInt(r8)
                r0.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x0254:
                r12.writeInt(r1)
                goto L_0x000a
            L_0x0259:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                android.os.Bundle r0 = r9.zzeI()
                r12.writeNoException()
                if (r0 == 0) goto L_0x026f
                r12.writeInt(r8)
                r0.writeToParcel(r12, r8)
                goto L_0x000a
            L_0x026f:
                r12.writeInt(r1)
                goto L_0x000a
            L_0x0274:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                int r1 = r11.readInt()
                if (r1 == 0) goto L_0x0285
                com.google.android.gms.ads.internal.client.zzg r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.createFromParcel(r11)
            L_0x0285:
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                r9.zza(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzey.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza2, String str2) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException;

    void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException;

    zzfb zzeF() throws RemoteException;

    zzfc zzeG() throws RemoteException;

    Bundle zzeH() throws RemoteException;

    Bundle zzeI() throws RemoteException;
}
