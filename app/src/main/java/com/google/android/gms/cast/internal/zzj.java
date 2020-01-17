package com.google.android.gms.cast.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface zzj extends IInterface {

    public static abstract class zza extends Binder implements zzj {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.cast.internal.DeviceStatus} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.cast.internal.ApplicationStatus} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: com.google.android.gms.cast.ApplicationMetadata} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r1 = 0
                r0 = 0
                r2 = 1
                switch(r7) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x001e;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x0051;
                    case 5: goto L_0x0069;
                    case 6: goto L_0x007a;
                    case 7: goto L_0x008b;
                    case 8: goto L_0x0099;
                    case 9: goto L_0x00a7;
                    case 10: goto L_0x00b5;
                    case 11: goto L_0x00cb;
                    case 12: goto L_0x00dd;
                    case 13: goto L_0x00f5;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r2 = super.onTransact(r7, r8, r9, r10)
            L_0x000a:
                return r2
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r9.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.zzbk(r0)
                goto L_0x000a
            L_0x001e:
                java.lang.String r3 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r3)
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x0031
                android.os.Parcelable$Creator<com.google.android.gms.cast.ApplicationMetadata> r0 = com.google.android.gms.cast.ApplicationMetadata.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.cast.ApplicationMetadata r0 = (com.google.android.gms.cast.ApplicationMetadata) r0
            L_0x0031:
                java.lang.String r3 = r8.readString()
                java.lang.String r4 = r8.readString()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x0040
                r1 = r2
            L_0x0040:
                r6.zza(r0, r3, r4, r1)
                goto L_0x000a
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.zzbl(r0)
                goto L_0x000a
            L_0x0051:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                double r4 = r8.readDouble()
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x0065
                r1 = r2
            L_0x0065:
                r6.zza((java.lang.String) r0, (double) r4, (boolean) r1)
                goto L_0x000a
            L_0x0069:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                java.lang.String r1 = r8.readString()
                r6.zzt(r0, r1)
                goto L_0x000a
            L_0x007a:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                byte[] r1 = r8.createByteArray()
                r6.zzb(r0, r1)
                goto L_0x000a
            L_0x008b:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.zzbn(r0)
                goto L_0x000a
            L_0x0099:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.zzbm(r0)
                goto L_0x000a
            L_0x00a7:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.onApplicationDisconnected(r0)
                goto L_0x000a
            L_0x00b5:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                long r4 = r8.readLong()
                int r1 = r8.readInt()
                r6.zza((java.lang.String) r0, (long) r4, (int) r1)
                goto L_0x000a
            L_0x00cb:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                long r4 = r8.readLong()
                r6.zzc(r0, r4)
                goto L_0x000a
            L_0x00dd:
                java.lang.String r1 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x00f0
                android.os.Parcelable$Creator<com.google.android.gms.cast.internal.ApplicationStatus> r0 = com.google.android.gms.cast.internal.ApplicationStatus.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.cast.internal.ApplicationStatus r0 = (com.google.android.gms.cast.internal.ApplicationStatus) r0
            L_0x00f0:
                r6.zzb((com.google.android.gms.cast.internal.ApplicationStatus) r0)
                goto L_0x000a
            L_0x00f5:
                java.lang.String r1 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0108
                android.os.Parcelable$Creator<com.google.android.gms.cast.internal.DeviceStatus> r0 = com.google.android.gms.cast.internal.DeviceStatus.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.cast.internal.DeviceStatus r0 = (com.google.android.gms.cast.internal.DeviceStatus) r0
            L_0x0108:
                r6.zzb((com.google.android.gms.cast.internal.DeviceStatus) r0)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zzj.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onApplicationDisconnected(int i) throws RemoteException;

    void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void zza(String str, double d, boolean z) throws RemoteException;

    void zza(String str, long j, int i) throws RemoteException;

    void zzb(ApplicationStatus applicationStatus) throws RemoteException;

    void zzb(DeviceStatus deviceStatus) throws RemoteException;

    void zzb(String str, byte[] bArr) throws RemoteException;

    void zzbk(int i) throws RemoteException;

    void zzbl(int i) throws RemoteException;

    void zzbm(int i) throws RemoteException;

    void zzbn(int i) throws RemoteException;

    void zzc(String str, long j) throws RemoteException;

    void zzt(String str, String str2) throws RemoteException;
}
