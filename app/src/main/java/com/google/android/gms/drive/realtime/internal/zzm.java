package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public interface zzm extends IInterface {

    public static abstract class zza extends Binder implements zzm {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zzm$zza$zza  reason: collision with other inner class name */
        private static class C0055zza implements zzm {
            private IBinder zzoz;

            C0055zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(int i, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DriveId driveId, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        obtain.writeInt(1);
                        driveId.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    this.zzoz.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzi zzi) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzk zzk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzk != null ? zzk.asBinder() : null);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(boolean z, zzo zzo) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ParcelableEventList.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zztT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.zzoz.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzm zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new C0055zza(iBinder) : (zzm) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.drive.DriveId} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: com.google.android.gms.drive.realtime.internal.ParcelableIndexReference} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v82, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v108, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v138 */
        /* JADX WARNING: type inference failed for: r0v139 */
        /* JADX WARNING: type inference failed for: r0v140 */
        /* JADX WARNING: type inference failed for: r0v141 */
        /* JADX WARNING: type inference failed for: r0v142 */
        /* JADX WARNING: type inference failed for: r0v143 */
        /* JADX WARNING: type inference failed for: r0v144 */
        /* JADX WARNING: type inference failed for: r0v145 */
        /* JADX WARNING: type inference failed for: r0v146 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r1 = 0
                r6 = 1
                r0 = 0
                switch(r8) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0029;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x00c0;
                    case 5: goto L_0x00dd;
                    case 6: goto L_0x00f6;
                    case 7: goto L_0x011b;
                    case 8: goto L_0x016a;
                    case 9: goto L_0x0183;
                    case 10: goto L_0x019c;
                    case 11: goto L_0x01bd;
                    case 12: goto L_0x01de;
                    case 13: goto L_0x01fb;
                    case 14: goto L_0x0214;
                    case 15: goto L_0x022d;
                    case 16: goto L_0x0256;
                    case 17: goto L_0x027f;
                    case 18: goto L_0x02c6;
                    case 19: goto L_0x052f;
                    case 20: goto L_0x0134;
                    case 21: goto L_0x014d;
                    case 22: goto L_0x030c;
                    case 23: goto L_0x0321;
                    case 24: goto L_0x0336;
                    case 25: goto L_0x034b;
                    case 26: goto L_0x0397;
                    case 27: goto L_0x03ba;
                    case 28: goto L_0x03d3;
                    case 29: goto L_0x03f0;
                    case 30: goto L_0x0405;
                    case 31: goto L_0x041e;
                    case 32: goto L_0x0433;
                    case 33: goto L_0x0051;
                    case 34: goto L_0x0448;
                    case 35: goto L_0x0065;
                    case 36: goto L_0x045d;
                    case 37: goto L_0x02a0;
                    case 38: goto L_0x0472;
                    case 39: goto L_0x048b;
                    case 40: goto L_0x0079;
                    case 41: goto L_0x02e9;
                    case 42: goto L_0x04a4;
                    case 43: goto L_0x04c1;
                    case 44: goto L_0x04ea;
                    case 45: goto L_0x008e;
                    case 46: goto L_0x00a3;
                    case 47: goto L_0x0360;
                    case 48: goto L_0x04f7;
                    case 49: goto L_0x051a;
                    case 50: goto L_0x037e;
                    case 51: goto L_0x0552;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x000a:
                return r6
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r10.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzn) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0029:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzc) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x003d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzo) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0051:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r7.zzb((com.google.android.gms.drive.realtime.internal.zzc) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0065:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r7.zzb((com.google.android.gms.drive.realtime.internal.zzo) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0079:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzl) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x008e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r7.zzc((com.google.android.gms.drive.realtime.internal.zzc) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x00a3:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r2 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r2)
                r7.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.drive.realtime.internal.zzn) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x00c0:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r2 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r2)
                r7.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzf) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x00dd:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzl) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x00f6:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x010b
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x010b:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r2 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r2)
                r7.zza((java.lang.String) r1, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.zzj) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x011b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0134:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzf) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x014d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r2 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r2)
                r7.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzg) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x016a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r7.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzl) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0183:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r1)
                r7.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzn) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x019c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r3)
                r7.zza((java.lang.String) r0, (int) r1, (java.lang.String) r2, (com.google.android.gms.drive.realtime.internal.zzj) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x01bd:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r3)
                r7.zza((java.lang.String) r0, (int) r1, (int) r2, (com.google.android.gms.drive.realtime.internal.zzj) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x01de:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r2 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r2)
                r7.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzj) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x01fb:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r1)
                r7.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzf) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0214:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r7.zzc(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x022d:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x0246
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0246:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r3)
                r7.zza((java.lang.String) r1, (int) r2, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.zzj) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x0256:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x026f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x026f:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r3 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r3)
                r7.zza((java.lang.String) r1, (int) r2, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.zzg) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x027f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r3 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r3)
                r7.zza((java.lang.String) r0, (int) r1, (int) r2, (com.google.android.gms.drive.realtime.internal.zzg) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x02a0:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                java.lang.String r3 = r9.readString()
                int r4 = r9.readInt()
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r5 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r0 = r7
                r0.zza(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x02c6:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02d9
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r0
            L_0x02d9:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x02e9:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02fc
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x02fc:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r7.zza((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x030c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzj) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0321:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r7.zzb((com.google.android.gms.drive.realtime.internal.zzj) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0336:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r7.zzd(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x034b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r7.zze(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0360:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x037c
                r0 = r6
            L_0x036c:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((boolean) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x037c:
                r0 = r1
                goto L_0x036c
            L_0x037e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((int) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0397:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x03aa
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.ParcelableIndexReference> r0 = com.google.android.gms.drive.realtime.internal.ParcelableIndexReference.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.ParcelableIndexReference r0 = (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0
            L_0x03aa:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r1)
                r7.zza((com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0, (com.google.android.gms.drive.realtime.internal.zzn) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x03ba:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzk r1 = com.google.android.gms.drive.realtime.internal.zzk.zza.zzbm(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzk) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x03d3:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r2 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r2)
                r7.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.drive.realtime.internal.zzo) r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x03f0:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r0)
                r7.zzb((com.google.android.gms.drive.realtime.internal.zzl) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0405:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r7.zza((int) r0, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x041e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zze r0 = com.google.android.gms.drive.realtime.internal.zze.zza.zzbg(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zze) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0433:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzd r0 = com.google.android.gms.drive.realtime.internal.zzd.zza.zzbf(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzd) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0448:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzi r0 = com.google.android.gms.drive.realtime.internal.zzi.zza.zzbk(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzi) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x045d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzh r0 = com.google.android.gms.drive.realtime.internal.zzh.zza.zzbj(r0)
                r7.zza((com.google.android.gms.drive.realtime.internal.zzh) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0472:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x048b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x04a4:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r2 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r2)
                r7.zzb(r0, r1, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x04c1:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                java.lang.String r2 = r9.readString()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x04da
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x04da:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r3)
                r7.zza((java.lang.String) r1, (java.lang.String) r2, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.zzj) r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x04ea:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                r7.zztT()
                r10.writeNoException()
                goto L_0x000a
            L_0x04f7:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x050a
                android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r0 = com.google.android.gms.drive.DriveId.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.DriveId r0 = (com.google.android.gms.drive.DriveId) r0
            L_0x050a:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((com.google.android.gms.drive.DriveId) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x051a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r7.zzc((com.google.android.gms.drive.realtime.internal.zzo) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x052f:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0542
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x0542:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r7.zza((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0552:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r2 = r9.readString()
                java.lang.String r3 = r9.readString()
                com.google.android.gms.drive.realtime.internal.event.ParcelableEventList r0 = r7.zzf(r0, r2, r3)
                r10.writeNoException()
                if (r0 == 0) goto L_0x0574
                r10.writeInt(r6)
                r0.writeToParcel(r10, r6)
                goto L_0x000a
            L_0x0574:
                r10.writeInt(r1)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.realtime.internal.zzm.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, zzj zzj) throws RemoteException;

    void zza(int i, zzo zzo) throws RemoteException;

    void zza(DriveId driveId, zzo zzo) throws RemoteException;

    void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException;

    void zza(zzc zzc) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(zze zze) throws RemoteException;

    void zza(zzh zzh) throws RemoteException;

    void zza(zzi zzi) throws RemoteException;

    void zza(zzj zzj) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(zzo zzo) throws RemoteException;

    void zza(String str, int i, int i2, zzg zzg) throws RemoteException;

    void zza(String str, int i, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, int i, zzn zzn) throws RemoteException;

    void zza(String str, int i, zzo zzo) throws RemoteException;

    void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, String str2, zzj zzj) throws RemoteException;

    void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, zzf zzf) throws RemoteException;

    void zza(String str, zzj zzj) throws RemoteException;

    void zza(String str, zzk zzk) throws RemoteException;

    void zza(String str, zzl zzl) throws RemoteException;

    void zza(String str, zzn zzn) throws RemoteException;

    void zza(String str, zzo zzo) throws RemoteException;

    void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, String str2, zzf zzf) throws RemoteException;

    void zza(String str, String str2, zzg zzg) throws RemoteException;

    void zza(String str, String str2, zzj zzj) throws RemoteException;

    void zza(boolean z, zzo zzo) throws RemoteException;

    void zzb(zzc zzc) throws RemoteException;

    void zzb(zzj zzj) throws RemoteException;

    void zzb(zzl zzl) throws RemoteException;

    void zzb(zzo zzo) throws RemoteException;

    void zzb(String str, zzf zzf) throws RemoteException;

    void zzb(String str, zzl zzl) throws RemoteException;

    void zzb(String str, zzn zzn) throws RemoteException;

    void zzb(String str, zzo zzo) throws RemoteException;

    void zzb(String str, String str2, zzf zzf) throws RemoteException;

    void zzc(zzc zzc) throws RemoteException;

    void zzc(zzo zzo) throws RemoteException;

    void zzc(String str, zzl zzl) throws RemoteException;

    void zzd(zzc zzc) throws RemoteException;

    void zze(zzc zzc) throws RemoteException;

    ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException;

    void zztT() throws RemoteException;
}
