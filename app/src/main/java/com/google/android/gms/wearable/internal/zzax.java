package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzax extends IInterface {

    public static abstract class zza extends Binder implements zzax {

        /* renamed from: com.google.android.gms.wearable.internal.zzax$zza$zza  reason: collision with other inner class name */
        private static class C0248zza implements zzax {
            private IBinder zzoz;

            C0248zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeByte(b);
                    this.zzoz.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
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

            public void zza(zzav zzav, zzau zzau, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (zzau != null) {
                        iBinder = zzau.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zzoz.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzav zzav, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
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

            public void zzb(zzav zzav, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
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

            public void zzb(zzav zzav, zzau zzau, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (zzau != null) {
                        iBinder = zzau.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzav zzav, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav zzav, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeInt(i);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav zzav, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzav zzav, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzav zzav) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzav != null ? zzav.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzax zzeu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzax)) ? new C0248zza(iBinder) : (zzax) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.gms.wearable.ConnectionConfiguration} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: android.os.ParcelFileDescriptor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v91, resolved type: com.google.android.gms.wearable.internal.AncsNotificationParcelable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v112, resolved type: com.google.android.gms.wearable.internal.RemoveListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v117, resolved type: com.google.android.gms.wearable.internal.AddListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v146, resolved type: com.google.android.gms.wearable.Asset} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v155, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v160, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v165, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v170, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v179, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v184, resolved type: com.google.android.gms.wearable.PutDataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v205, resolved type: com.google.android.gms.wearable.ConnectionConfiguration} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v213 */
        /* JADX WARNING: type inference failed for: r0v214 */
        /* JADX WARNING: type inference failed for: r0v215 */
        /* JADX WARNING: type inference failed for: r0v216 */
        /* JADX WARNING: type inference failed for: r0v217 */
        /* JADX WARNING: type inference failed for: r0v218 */
        /* JADX WARNING: type inference failed for: r0v219 */
        /* JADX WARNING: type inference failed for: r0v220 */
        /* JADX WARNING: type inference failed for: r0v221 */
        /* JADX WARNING: type inference failed for: r0v222 */
        /* JADX WARNING: type inference failed for: r0v223 */
        /* JADX WARNING: type inference failed for: r0v224 */
        /* JADX WARNING: type inference failed for: r0v225 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r1 = 0
                r8 = 1
                r0 = 0
                switch(r10) {
                    case 2: goto L_0x051c;
                    case 3: goto L_0x0540;
                    case 4: goto L_0x0556;
                    case 5: goto L_0x056c;
                    case 6: goto L_0x0096;
                    case 7: goto L_0x00ba;
                    case 8: goto L_0x00de;
                    case 9: goto L_0x00f4;
                    case 11: goto L_0x0140;
                    case 12: goto L_0x018c;
                    case 13: goto L_0x01ae;
                    case 14: goto L_0x01d2;
                    case 15: goto L_0x01e8;
                    case 16: goto L_0x026a;
                    case 17: goto L_0x028e;
                    case 18: goto L_0x02b2;
                    case 19: goto L_0x02c8;
                    case 20: goto L_0x0012;
                    case 21: goto L_0x0035;
                    case 22: goto L_0x004e;
                    case 23: goto L_0x0063;
                    case 24: goto L_0x007c;
                    case 25: goto L_0x02de;
                    case 26: goto L_0x02f4;
                    case 27: goto L_0x030a;
                    case 28: goto L_0x032e;
                    case 29: goto L_0x0348;
                    case 30: goto L_0x0362;
                    case 31: goto L_0x0378;
                    case 32: goto L_0x0396;
                    case 33: goto L_0x03b0;
                    case 34: goto L_0x03ce;
                    case 35: goto L_0x03f0;
                    case 37: goto L_0x046e;
                    case 38: goto L_0x0412;
                    case 39: goto L_0x043a;
                    case 40: goto L_0x0118;
                    case 41: goto L_0x0164;
                    case 42: goto L_0x01fe;
                    case 43: goto L_0x021c;
                    case 46: goto L_0x0236;
                    case 47: goto L_0x0250;
                    case 48: goto L_0x0484;
                    case 49: goto L_0x04a3;
                    case 50: goto L_0x04b9;
                    case 51: goto L_0x04d6;
                    case 52: goto L_0x04ec;
                    case 53: goto L_0x0502;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r10, r11, r12, r13)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r12.writeString(r0)
                r0 = r8
                goto L_0x000a
            L_0x0012:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x002d
                android.os.Parcelable$Creator<com.google.android.gms.wearable.ConnectionConfiguration> r0 = com.google.android.gms.wearable.ConnectionConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.ConnectionConfiguration r0 = (com.google.android.gms.wearable.ConnectionConfiguration) r0
            L_0x002d:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.ConnectionConfiguration) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0035:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x004e:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zza(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0063:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x007c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zzc((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0096:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00b1
                android.os.Parcelable$Creator<com.google.android.gms.wearable.PutDataRequest> r0 = com.google.android.gms.wearable.PutDataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.PutDataRequest r0 = (com.google.android.gms.wearable.PutDataRequest) r0
            L_0x00b1:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.PutDataRequest) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x00ba:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00d5
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x00d5:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (android.net.Uri) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x00de:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzb(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x00f4:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x010f
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x010f:
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r1, (android.net.Uri) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0118:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0133
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0133:
                int r2 = r11.readInt()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (android.net.Uri) r0, (int) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0140:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x015b
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x015b:
                r9.zzc((com.google.android.gms.wearable.internal.zzav) r1, (android.net.Uri) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0164:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x017f
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x017f:
                int r2 = r11.readInt()
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r1, (android.net.Uri) r0, (int) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x018c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                byte[] r3 = r11.createByteArray()
                r9.zza(r0, r1, r2, r3)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x01ae:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x01c9
                android.os.Parcelable$Creator<com.google.android.gms.wearable.Asset> r0 = com.google.android.gms.wearable.Asset.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.Asset r0 = (com.google.android.gms.wearable.Asset) r0
            L_0x01c9:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.Asset) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x01d2:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzc(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x01e8:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzd(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x01fe:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                int r2 = r11.readInt()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1, (int) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x021c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                int r1 = r11.readInt()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (int) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0236:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zzd(r0, r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0250:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zze(r0, r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x026a:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0285
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AddListenerRequest> r0 = com.google.android.gms.wearable.internal.AddListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.AddListenerRequest r0 = (com.google.android.gms.wearable.internal.AddListenerRequest) r0
            L_0x0285:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.internal.AddListenerRequest) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x028e:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x02a9
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.RemoveListenerRequest> r0 = com.google.android.gms.wearable.internal.RemoveListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.RemoveListenerRequest r0 = (com.google.android.gms.wearable.internal.RemoveListenerRequest) r0
            L_0x02a9:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.internal.RemoveListenerRequest) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x02b2:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zze(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x02c8:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzf(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x02de:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzg(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x02f4:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzh(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x030a:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0325
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AncsNotificationParcelable> r0 = com.google.android.gms.wearable.internal.AncsNotificationParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.AncsNotificationParcelable r0 = (com.google.android.gms.wearable.internal.AncsNotificationParcelable) r0
            L_0x0325:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.internal.AncsNotificationParcelable) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x032e:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                int r1 = r11.readInt()
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r0, (int) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0348:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                int r1 = r11.readInt()
                r9.zzc((com.google.android.gms.wearable.internal.zzav) r0, (int) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0362:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzi(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0378:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1, (java.lang.String) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0396:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                r9.zzf(r0, r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x03b0:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                java.lang.String r1 = r11.readString()
                int r2 = r11.readInt()
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r0, (java.lang.String) r1, (int) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x03ce:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzer(r1)
                java.lang.String r2 = r11.readString()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (com.google.android.gms.wearable.internal.zzau) r1, (java.lang.String) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x03f0:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzer(r1)
                java.lang.String r2 = r11.readString()
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r0, (com.google.android.gms.wearable.internal.zzau) r1, (java.lang.String) r2)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0412:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                java.lang.String r2 = r11.readString()
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x0431
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
            L_0x0431:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r1, (java.lang.String) r2, (android.os.ParcelFileDescriptor) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x043a:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                java.lang.String r2 = r11.readString()
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x046c
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
                r3 = r0
            L_0x045a:
                long r4 = r11.readLong()
                long r6 = r11.readLong()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r6)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x046c:
                r3 = r0
                goto L_0x045a
            L_0x046e:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzj(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0484:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r2 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x04a1
                r0 = r8
            L_0x0498:
                r9.zza((com.google.android.gms.wearable.internal.zzav) r2, (boolean) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x04a1:
                r0 = r1
                goto L_0x0498
            L_0x04a3:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzk(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x04b9:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x04cd
                r1 = r8
            L_0x04cd:
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r0, (boolean) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x04d6:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzl(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x04ec:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzm(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0502:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                byte r1 = r11.readByte()
                r9.zza((com.google.android.gms.wearable.internal.zzav) r0, (byte) r1)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x051c:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r1 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0537
                android.os.Parcelable$Creator<com.google.android.gms.wearable.ConnectionConfiguration> r0 = com.google.android.gms.wearable.ConnectionConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.ConnectionConfiguration r0 = (com.google.android.gms.wearable.ConnectionConfiguration) r0
            L_0x0537:
                r9.zzb((com.google.android.gms.wearable.internal.zzav) r1, (com.google.android.gms.wearable.ConnectionConfiguration) r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0540:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzn(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x0556:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzo(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            L_0x056c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzav r0 = com.google.android.gms.wearable.internal.zzav.zza.zzes(r0)
                r9.zzp(r0)
                r12.writeNoException()
                r0 = r8
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzax.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzav zzav) throws RemoteException;

    void zza(zzav zzav, byte b) throws RemoteException;

    void zza(zzav zzav, int i) throws RemoteException;

    void zza(zzav zzav, Uri uri) throws RemoteException;

    void zza(zzav zzav, Uri uri, int i) throws RemoteException;

    void zza(zzav zzav, Asset asset) throws RemoteException;

    void zza(zzav zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzav zzav, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzav zzav, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzav zzav, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzav zzav, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzav zzav, zzau zzau, String str) throws RemoteException;

    void zza(zzav zzav, String str) throws RemoteException;

    void zza(zzav zzav, String str, int i) throws RemoteException;

    void zza(zzav zzav, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzav zzav, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzav zzav, String str, String str2) throws RemoteException;

    void zza(zzav zzav, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzav zzav, boolean z) throws RemoteException;

    void zzb(zzav zzav) throws RemoteException;

    void zzb(zzav zzav, int i) throws RemoteException;

    void zzb(zzav zzav, Uri uri) throws RemoteException;

    void zzb(zzav zzav, Uri uri, int i) throws RemoteException;

    void zzb(zzav zzav, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzav zzav, zzau zzau, String str) throws RemoteException;

    void zzb(zzav zzav, String str) throws RemoteException;

    void zzb(zzav zzav, String str, int i) throws RemoteException;

    void zzb(zzav zzav, boolean z) throws RemoteException;

    void zzc(zzav zzav) throws RemoteException;

    void zzc(zzav zzav, int i) throws RemoteException;

    void zzc(zzav zzav, Uri uri) throws RemoteException;

    void zzc(zzav zzav, String str) throws RemoteException;

    void zzd(zzav zzav) throws RemoteException;

    void zzd(zzav zzav, String str) throws RemoteException;

    void zze(zzav zzav) throws RemoteException;

    void zze(zzav zzav, String str) throws RemoteException;

    void zzf(zzav zzav) throws RemoteException;

    void zzf(zzav zzav, String str) throws RemoteException;

    void zzg(zzav zzav) throws RemoteException;

    void zzh(zzav zzav) throws RemoteException;

    void zzi(zzav zzav) throws RemoteException;

    void zzj(zzav zzav) throws RemoteException;

    void zzk(zzav zzav) throws RemoteException;

    void zzl(zzav zzav) throws RemoteException;

    void zzm(zzav zzav) throws RemoteException;

    void zzn(zzav zzav) throws RemoteException;

    void zzo(zzav zzav) throws RemoteException;

    void zzp(zzav zzav) throws RemoteException;
}
