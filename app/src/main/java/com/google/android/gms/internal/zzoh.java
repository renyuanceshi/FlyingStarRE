package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public interface zzoh extends IInterface {

    public static abstract class zza extends Binder implements zzoh {

        /* renamed from: com.google.android.gms.internal.zzoh$zza$zza  reason: collision with other inner class name */
        private static class C0114zza implements zzoh {
            private IBinder zzoz;

            C0114zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(DataReadResult dataReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataReadCallback");
                    if (dataReadResult != null) {
                        obtain.writeInt(1);
                        dataReadResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
        }

        public static zzoh zzbC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoh)) ? new C0114zza(iBinder) : (zzoh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
                    zza(parcel.readInt() != 0 ? DataReadResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataReadResult dataReadResult) throws RemoteException;
}
