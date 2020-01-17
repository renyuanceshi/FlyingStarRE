package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.fitness.service.FitnessSensorServiceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0031;
                    case 3: goto L_0x0051;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest> r0 = com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest r0 = (com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest) r0
            L_0x0024:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zzoi r2 = com.google.android.gms.internal.zzoi.zza.zzbD(r2)
                r3.zza((com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest) r0, (com.google.android.gms.internal.zzoi) r2)
                r0 = r1
                goto L_0x0009
            L_0x0031:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0044
                android.os.Parcelable$Creator<com.google.android.gms.fitness.service.FitnessSensorServiceRequest> r0 = com.google.android.gms.fitness.service.FitnessSensorServiceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.service.FitnessSensorServiceRequest r0 = (com.google.android.gms.fitness.service.FitnessSensorServiceRequest) r0
            L_0x0044:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zzow r2 = com.google.android.gms.internal.zzow.zza.zzbR(r2)
                r3.zza((com.google.android.gms.fitness.service.FitnessSensorServiceRequest) r0, (com.google.android.gms.internal.zzow) r2)
                r0 = r1
                goto L_0x0009
            L_0x0051:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0064
                android.os.Parcelable$Creator<com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest> r0 = com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest r0 = (com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest) r0
            L_0x0064:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zzow r2 = com.google.android.gms.internal.zzow.zza.zzbR(r2)
                r3.zza((com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest) r0, (com.google.android.gms.internal.zzow) r2)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.internal.service.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzoi zzoi) throws RemoteException;

    void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzow zzow) throws RemoteException;

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzow zzow) throws RemoteException;
}
