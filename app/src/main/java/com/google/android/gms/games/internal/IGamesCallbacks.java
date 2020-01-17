package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;

public interface IGamesCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesCallbacks {

        private static class Proxy implements IGamesCallbacks {
            private IBinder zzoz;

            Proxy(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onInvitationRemoved(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(str);
                    this.zzoz.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.INVALID_SESSION_TIMESTAMPS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(str);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(str);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (realTimeMessage != null) {
                        obtain.writeInt(1);
                        realTimeMessage.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestRemoved(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(str);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTurnBasedMatchRemoved(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(str);
                    this.zzoz.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzA(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.DATASET_TIMESTAMP_INCONSISTENT_WITH_UPDATE_TIME_RANGE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzB(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzC(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzD(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzE(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzF(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzG(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzH(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzI(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzJ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzK(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzL(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzM(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzN(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzO(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzP(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzQ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzR(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzS(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzT(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzU(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzV(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzW(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(15001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzX(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(17001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, VideoCapabilities videoCapabilities) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (videoCapabilities != null) {
                        obtain.writeInt(1);
                        videoCapabilities.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(19001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, long[] jArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeLongArray(jArr);
                    this.zzoz.transact(19003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents2 != null) {
                        obtain.writeInt(1);
                        contents2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents3 != null) {
                        obtain.writeInt(1);
                        contents3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder[] dataHolderArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeTypedArray(dataHolderArr, 0);
                    this.zzoz.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.zzoz.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zzoz.transact(19002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zzoz.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgn(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zzoz.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zzoz.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgp(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zzoz.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzgq(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zzoz.transact(17002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzoz.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zzoz.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.APP_NOT_FIT_ENABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.API_EXCEPTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(PlacesStatusCodes.USAGE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzr(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzs(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzt(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(10001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzu(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzv(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzw(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzwr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.zzoz.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzx(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzy(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzz(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.DATA_SOURCE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static IGamesCallbacks zzbW(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesCallbacks)) ? new Proxy(iBinder) : (IGamesCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: com.google.android.gms.drive.Contents} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v73, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v75, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v77, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v81, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v85, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v87, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v89, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v91, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v93, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v95, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v97, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v99, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v24 */
        /* JADX WARNING: type inference failed for: r5v101 */
        /* JADX WARNING: type inference failed for: r5v102 */
        /* JADX WARNING: type inference failed for: r5v103 */
        /* JADX WARNING: type inference failed for: r5v104 */
        /* JADX WARNING: type inference failed for: r5v105 */
        /* JADX WARNING: type inference failed for: r5v106 */
        /* JADX WARNING: type inference failed for: r5v107 */
        /* JADX WARNING: type inference failed for: r5v108 */
        /* JADX WARNING: type inference failed for: r5v109 */
        /* JADX WARNING: type inference failed for: r5v110 */
        /* JADX WARNING: type inference failed for: r5v111 */
        /* JADX WARNING: type inference failed for: r5v112 */
        /* JADX WARNING: type inference failed for: r5v113 */
        /* JADX WARNING: type inference failed for: r5v114 */
        /* JADX WARNING: type inference failed for: r5v115 */
        /* JADX WARNING: type inference failed for: r5v116 */
        /* JADX WARNING: type inference failed for: r5v117 */
        /* JADX WARNING: type inference failed for: r5v118 */
        /* JADX WARNING: type inference failed for: r5v119 */
        /* JADX WARNING: type inference failed for: r5v120 */
        /* JADX WARNING: type inference failed for: r5v121 */
        /* JADX WARNING: type inference failed for: r5v122 */
        /* JADX WARNING: type inference failed for: r5v123 */
        /* JADX WARNING: type inference failed for: r5v124 */
        /* JADX WARNING: type inference failed for: r5v125 */
        /* JADX WARNING: type inference failed for: r5v126 */
        /* JADX WARNING: type inference failed for: r5v127 */
        /* JADX WARNING: type inference failed for: r5v128 */
        /* JADX WARNING: type inference failed for: r5v129 */
        /* JADX WARNING: type inference failed for: r5v130 */
        /* JADX WARNING: type inference failed for: r5v131 */
        /* JADX WARNING: type inference failed for: r5v132 */
        /* JADX WARNING: type inference failed for: r5v133 */
        /* JADX WARNING: type inference failed for: r5v134 */
        /* JADX WARNING: type inference failed for: r5v135 */
        /* JADX WARNING: type inference failed for: r5v136 */
        /* JADX WARNING: type inference failed for: r5v137 */
        /* JADX WARNING: type inference failed for: r5v138 */
        /* JADX WARNING: type inference failed for: r5v139 */
        /* JADX WARNING: type inference failed for: r5v140 */
        /* JADX WARNING: type inference failed for: r5v141 */
        /* JADX WARNING: type inference failed for: r5v142 */
        /* JADX WARNING: type inference failed for: r5v143 */
        /* JADX WARNING: type inference failed for: r5v144 */
        /* JADX WARNING: type inference failed for: r5v145 */
        /* JADX WARNING: type inference failed for: r5v146 */
        /* JADX WARNING: type inference failed for: r5v147 */
        /* JADX WARNING: type inference failed for: r5v148 */
        /* JADX WARNING: type inference failed for: r5v149 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r0 = 0
                r6 = 1
                r5 = 0
                switch(r8) {
                    case 5001: goto L_0x0011;
                    case 5002: goto L_0x0025;
                    case 5003: goto L_0x003f;
                    case 5004: goto L_0x0053;
                    case 5005: goto L_0x006b;
                    case 5006: goto L_0x0092;
                    case 5007: goto L_0x00ab;
                    case 5008: goto L_0x00c4;
                    case 5009: goto L_0x00dd;
                    case 5010: goto L_0x00f6;
                    case 5011: goto L_0x010f;
                    case 5016: goto L_0x0128;
                    case 5017: goto L_0x0135;
                    case 5018: goto L_0x0167;
                    case 5019: goto L_0x0180;
                    case 5020: goto L_0x0199;
                    case 5021: goto L_0x01ae;
                    case 5022: goto L_0x01c7;
                    case 5023: goto L_0x01e0;
                    case 5024: goto L_0x01f9;
                    case 5025: goto L_0x0212;
                    case 5026: goto L_0x022b;
                    case 5027: goto L_0x0248;
                    case 5028: goto L_0x0265;
                    case 5029: goto L_0x0282;
                    case 5030: goto L_0x029f;
                    case 5031: goto L_0x02bc;
                    case 5032: goto L_0x02d9;
                    case 5033: goto L_0x02f6;
                    case 5034: goto L_0x030f;
                    case 5035: goto L_0x0344;
                    case 5036: goto L_0x035d;
                    case 5037: goto L_0x014e;
                    case 5038: goto L_0x032b;
                    case 5039: goto L_0x036e;
                    case 5040: goto L_0x0387;
                    case 6001: goto L_0x0398;
                    case 6002: goto L_0x03a9;
                    case 8001: goto L_0x03ba;
                    case 8002: goto L_0x03d3;
                    case 8003: goto L_0x03f4;
                    case 8004: goto L_0x040d;
                    case 8005: goto L_0x0426;
                    case 8006: goto L_0x043f;
                    case 8007: goto L_0x0458;
                    case 8008: goto L_0x046d;
                    case 8009: goto L_0x0486;
                    case 8010: goto L_0x0497;
                    case 9001: goto L_0x04a8;
                    case 10001: goto L_0x04c1;
                    case 10002: goto L_0x04da;
                    case 10003: goto L_0x04eb;
                    case 10004: goto L_0x0504;
                    case 10005: goto L_0x051d;
                    case 10006: goto L_0x053e;
                    case 11001: goto L_0x0557;
                    case 12001: goto L_0x0578;
                    case 12003: goto L_0x063c;
                    case 12004: goto L_0x0591;
                    case 12005: goto L_0x060e;
                    case 12006: goto L_0x068f;
                    case 12007: goto L_0x06a8;
                    case 12008: goto L_0x06f3;
                    case 12011: goto L_0x0676;
                    case 12012: goto L_0x0627;
                    case 12013: goto L_0x065d;
                    case 12014: goto L_0x06c1;
                    case 12015: goto L_0x070c;
                    case 12016: goto L_0x06da;
                    case 12017: goto L_0x05bd;
                    case 13001: goto L_0x072d;
                    case 13002: goto L_0x0746;
                    case 14001: goto L_0x0757;
                    case 15001: goto L_0x076c;
                    case 17001: goto L_0x0785;
                    case 17002: goto L_0x079e;
                    case 19001: goto L_0x07af;
                    case 19002: goto L_0x07d0;
                    case 19003: goto L_0x07e8;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x000a:
                return r6
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r10.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzg((int) r0, (java.lang.String) r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0025:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x003d
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0036:
                r7.zzh(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x003d:
                r0 = r5
                goto L_0x0036
            L_0x003f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzh(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0053:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0064
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0064:
                r7.zzj(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x006b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0090
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x007c:
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0088
                com.google.android.gms.common.data.zze r1 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r1.createFromParcel(r9)
            L_0x0088:
                r7.zza((com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.common.data.DataHolder) r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0090:
                r0 = r5
                goto L_0x007c
            L_0x0092:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00a3
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00a3:
                r7.zzk(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x00ab:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00bc
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00bc:
                r7.zzl(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x00c4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00d5
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00d5:
                r7.zzm(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x00dd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00ee
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00ee:
                r7.zzn(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x00f6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0107
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0107:
                r7.zzo(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x010f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0120
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0120:
                r7.zzp(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0128:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                r7.zzwr()
                r10.writeNoException()
                goto L_0x000a
            L_0x0135:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0146
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0146:
                r7.zzr(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x014e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x015f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x015f:
                r7.zzs(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0167:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0178
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0178:
                r7.zzz(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0180:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0191
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0191:
                r7.zzA(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0199:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.onLeftRoom(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x01ae:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01bf
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01bf:
                r7.zzB(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x01c7:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01d8
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01d8:
                r7.zzC(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x01e0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01f1
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01f1:
                r7.zzD(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x01f9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x020a
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x020a:
                r7.zzE(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0212:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0223
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0223:
                r7.zzF(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x022b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x023c
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x023c:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zza((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0248:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0259
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0259:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzb(r5, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0265:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0276
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0276:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzc((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0282:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0293
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0293:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzd((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x029f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02b0
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02b0:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zze((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x02bc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02cd
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02cd:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzf((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x02d9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02f4
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RealTimeMessage> r0 = com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.games.multiplayer.realtime.RealTimeMessage r0 = (com.google.android.gms.games.multiplayer.realtime.RealTimeMessage) r0
            L_0x02ec:
                r7.onRealTimeMessageReceived(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x02f4:
                r0 = r5
                goto L_0x02ec
            L_0x02f6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                r7.zzb(r0, r1, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x030f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x0323
                r0 = r6
            L_0x0323:
                r7.zza(r1, r2, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x032b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x033c
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x033c:
                r7.zzG(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0344:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0355
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0355:
                r7.zzH(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x035d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzgn(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x036e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x037f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x037f:
                r7.zzI(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0387:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzgo(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0398:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PConnected(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x03a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PDisconnected(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x03ba:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03cb
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x03cb:
                r7.zzJ(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x03d3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03f2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x03ea:
                r7.zzc((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x03f2:
                r0 = r5
                goto L_0x03ea
            L_0x03f4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0405
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0405:
                r7.zzu(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x040d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x041e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x041e:
                r7.zzv(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0426:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0437
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0437:
                r7.zzw(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x043f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0450
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0450:
                r7.zzx(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0458:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzi(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x046d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x047e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x047e:
                r7.zzy(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0486:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onTurnBasedMatchRemoved(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0497:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onInvitationRemoved(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x04a8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04b9
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04b9:
                r7.zzq(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x04c1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04d2
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04d2:
                r7.zzt(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x04da:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onRequestRemoved(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x04eb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04fc
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04fc:
                r7.zzK(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0504:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0515
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0515:
                r7.zzL(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x051d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x053c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0534:
                r7.zzd((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x053c:
                r0 = r5
                goto L_0x0534
            L_0x053e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x054f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x054f:
                r7.zzM(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0557:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0576
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x056e:
                r7.zze((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0576:
                r0 = r5
                goto L_0x056e
            L_0x0578:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0589
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0589:
                r7.zzN(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0591:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05b9
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
                r1 = r0
            L_0x05a3:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05bb
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
            L_0x05b1:
                r7.zza((com.google.android.gms.common.data.DataHolder) r1, (com.google.android.gms.drive.Contents) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x05b9:
                r1 = r5
                goto L_0x05a3
            L_0x05bb:
                r0 = r5
                goto L_0x05b1
            L_0x05bd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0608
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r1 = r0.createFromParcel(r9)
            L_0x05ce:
                java.lang.String r2 = r9.readString()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060a
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r3 = r0
            L_0x05e1:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060c
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r4 = r0
            L_0x05f0:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05ff
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r5 = r0
            L_0x05ff:
                r0 = r7
                r0.zza(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0608:
                r1 = r5
                goto L_0x05ce
            L_0x060a:
                r3 = r5
                goto L_0x05e1
            L_0x060c:
                r4 = r5
                goto L_0x05f0
            L_0x060e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x061f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x061f:
                r7.zzO(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0627:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzj(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x063c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x065b
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0653:
                r7.zzf((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x065b:
                r0 = r5
                goto L_0x0653
            L_0x065d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x066e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x066e:
                r7.zzU(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0676:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0687
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0687:
                r7.zzi(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x068f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06a0
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06a0:
                r7.zzP(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x06a8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06b9
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06b9:
                r7.zzQ(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x06c1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06d2
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06d2:
                r7.zzR(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x06da:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06eb
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06eb:
                r7.zzS(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x06f3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0704
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0704:
                r7.zzT(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x070c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x072b
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0723:
                r7.zzg((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x072b:
                r0 = r5
                goto L_0x0723
            L_0x072d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x073e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x073e:
                r7.zzV(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0746:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzgp(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0757:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                java.lang.Object[] r0 = r9.createTypedArray(r0)
                com.google.android.gms.common.data.DataHolder[] r0 = (com.google.android.gms.common.data.DataHolder[]) r0
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x076c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x077d
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x077d:
                r7.zzW(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x0785:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0796
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0796:
                r7.zzX(r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x079e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzgq(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x07af:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x07ce
                android.os.Parcelable$Creator<com.google.android.gms.games.video.VideoCapabilities> r0 = com.google.android.gms.games.video.VideoCapabilities.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.games.video.VideoCapabilities r0 = (com.google.android.gms.games.video.VideoCapabilities) r0
            L_0x07c6:
                r7.zza((int) r1, (com.google.android.gms.games.video.VideoCapabilities) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x07ce:
                r0 = r5
                goto L_0x07c6
            L_0x07d0:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x07e0
                r0 = r6
            L_0x07e0:
                r7.zzd((int) r1, (boolean) r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x07e8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                long[] r1 = r9.createLongArray()
                r7.zza((int) r0, (long[]) r1)
                r10.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IGamesCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onInvitationRemoved(String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onRequestRemoved(String str) throws RemoteException;

    void onTurnBasedMatchRemoved(String str) throws RemoteException;

    void zzA(DataHolder dataHolder) throws RemoteException;

    void zzB(DataHolder dataHolder) throws RemoteException;

    void zzC(DataHolder dataHolder) throws RemoteException;

    void zzD(DataHolder dataHolder) throws RemoteException;

    void zzE(DataHolder dataHolder) throws RemoteException;

    void zzF(DataHolder dataHolder) throws RemoteException;

    void zzG(DataHolder dataHolder) throws RemoteException;

    void zzH(DataHolder dataHolder) throws RemoteException;

    void zzI(DataHolder dataHolder) throws RemoteException;

    void zzJ(DataHolder dataHolder) throws RemoteException;

    void zzK(DataHolder dataHolder) throws RemoteException;

    void zzL(DataHolder dataHolder) throws RemoteException;

    void zzM(DataHolder dataHolder) throws RemoteException;

    void zzN(DataHolder dataHolder) throws RemoteException;

    void zzO(DataHolder dataHolder) throws RemoteException;

    void zzP(DataHolder dataHolder) throws RemoteException;

    void zzQ(DataHolder dataHolder) throws RemoteException;

    void zzR(DataHolder dataHolder) throws RemoteException;

    void zzS(DataHolder dataHolder) throws RemoteException;

    void zzT(DataHolder dataHolder) throws RemoteException;

    void zzU(DataHolder dataHolder) throws RemoteException;

    void zzV(DataHolder dataHolder) throws RemoteException;

    void zzW(DataHolder dataHolder) throws RemoteException;

    void zzX(DataHolder dataHolder) throws RemoteException;

    void zza(int i, VideoCapabilities videoCapabilities) throws RemoteException;

    void zza(int i, String str, boolean z) throws RemoteException;

    void zza(int i, long[] jArr) throws RemoteException;

    void zza(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void zza(DataHolder dataHolder, Contents contents) throws RemoteException;

    void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    void zza(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zza(DataHolder[] dataHolderArr) throws RemoteException;

    void zzb(int i, int i2, String str) throws RemoteException;

    void zzb(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzc(int i, Bundle bundle) throws RemoteException;

    void zzc(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzd(int i, Bundle bundle) throws RemoteException;

    void zzd(int i, boolean z) throws RemoteException;

    void zzd(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zze(int i, Bundle bundle) throws RemoteException;

    void zze(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzf(int i, Bundle bundle) throws RemoteException;

    void zzf(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzg(int i, Bundle bundle) throws RemoteException;

    void zzg(int i, String str) throws RemoteException;

    void zzgn(int i) throws RemoteException;

    void zzgo(int i) throws RemoteException;

    void zzgp(int i) throws RemoteException;

    void zzgq(int i) throws RemoteException;

    void zzh(int i, String str) throws RemoteException;

    void zzh(DataHolder dataHolder) throws RemoteException;

    void zzi(int i, String str) throws RemoteException;

    void zzi(DataHolder dataHolder) throws RemoteException;

    void zzj(int i, String str) throws RemoteException;

    void zzj(DataHolder dataHolder) throws RemoteException;

    void zzk(DataHolder dataHolder) throws RemoteException;

    void zzl(DataHolder dataHolder) throws RemoteException;

    void zzm(DataHolder dataHolder) throws RemoteException;

    void zzn(DataHolder dataHolder) throws RemoteException;

    void zzo(DataHolder dataHolder) throws RemoteException;

    void zzp(DataHolder dataHolder) throws RemoteException;

    void zzq(DataHolder dataHolder) throws RemoteException;

    void zzr(DataHolder dataHolder) throws RemoteException;

    void zzs(DataHolder dataHolder) throws RemoteException;

    void zzt(DataHolder dataHolder) throws RemoteException;

    void zzu(DataHolder dataHolder) throws RemoteException;

    void zzv(DataHolder dataHolder) throws RemoteException;

    void zzw(DataHolder dataHolder) throws RemoteException;

    void zzwr() throws RemoteException;

    void zzx(DataHolder dataHolder) throws RemoteException;

    void zzy(DataHolder dataHolder) throws RemoteException;

    void zzz(DataHolder dataHolder) throws RemoteException;
}
