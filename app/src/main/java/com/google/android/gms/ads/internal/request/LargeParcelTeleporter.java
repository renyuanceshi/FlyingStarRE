package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzna;
import java.io.DataInputStream;
import java.io.IOException;

@zzhb
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Parcelable.Creator<LargeParcelTeleporter> CREATOR = new zzl();
    final int mVersionCode;
    ParcelFileDescriptor zzIq;
    private Parcelable zzIr;
    private boolean zzIs;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzIq = parcelFileDescriptor;
        this.zzIr = null;
        this.zzIs = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.mVersionCode = 1;
        this.zzIq = null;
        this.zzIr = safeParcelable;
        this.zzIs = false;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzIq == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzIr.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzIq = zzf(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        zzl.zza(this, parcel, i);
    }

    /* JADX INFO: finally extract failed */
    public <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.zzIs) {
            if (this.zzIq == null) {
                zzin.e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzIq));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzna.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzIr = (SafeParcelable) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzIs = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th2) {
                zzna.zzb(dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.zzIr;
    }

    /* access modifiers changed from: protected */
    public <T> ParcelFileDescriptor zzf(final byte[] bArr) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
                    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
                    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
                    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r4 = this;
                            r2 = 0
                            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x001f, all -> 0x004a }
                            java.io.OutputStream r0 = r1     // Catch:{ IOException -> 0x001f, all -> 0x004a }
                            r1.<init>(r0)     // Catch:{ IOException -> 0x001f, all -> 0x004a }
                            byte[] r0 = r7     // Catch:{ IOException -> 0x0048 }
                            int r0 = r0.length     // Catch:{ IOException -> 0x0048 }
                            r1.writeInt(r0)     // Catch:{ IOException -> 0x0048 }
                            byte[] r0 = r7     // Catch:{ IOException -> 0x0048 }
                            r1.write(r0)     // Catch:{ IOException -> 0x0048 }
                            if (r1 != 0) goto L_0x001b
                            java.io.OutputStream r0 = r1
                            com.google.android.gms.internal.zzna.zzb(r0)
                        L_0x001a:
                            return
                        L_0x001b:
                            com.google.android.gms.internal.zzna.zzb(r1)
                            goto L_0x001a
                        L_0x001f:
                            r0 = move-exception
                            r1 = r2
                        L_0x0021:
                            java.lang.String r2 = "Error transporting the ad response"
                            com.google.android.gms.internal.zzin.zzb(r2, r0)     // Catch:{ all -> 0x003a }
                            com.google.android.gms.internal.zzih r2 = com.google.android.gms.ads.internal.zzr.zzbF()     // Catch:{ all -> 0x003a }
                            r3 = 1
                            r2.zzb((java.lang.Throwable) r0, (boolean) r3)     // Catch:{ all -> 0x003a }
                            if (r1 != 0) goto L_0x0036
                            java.io.OutputStream r0 = r1
                            com.google.android.gms.internal.zzna.zzb(r0)
                            goto L_0x001a
                        L_0x0036:
                            com.google.android.gms.internal.zzna.zzb(r1)
                            goto L_0x001a
                        L_0x003a:
                            r0 = move-exception
                            r2 = r1
                        L_0x003c:
                            if (r2 != 0) goto L_0x0044
                            java.io.OutputStream r1 = r1
                            com.google.android.gms.internal.zzna.zzb(r1)
                        L_0x0043:
                            throw r0
                        L_0x0044:
                            com.google.android.gms.internal.zzna.zzb(r2)
                            goto L_0x0043
                        L_0x0048:
                            r0 = move-exception
                            goto L_0x0021
                        L_0x004a:
                            r0 = move-exception
                            goto L_0x003c
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.AnonymousClass1.run():void");
                    }
                }).start();
                return createPipe[0];
            } catch (IOException e) {
                e = e;
                zzin.zzb("Error transporting the ad response", e);
                zzr.zzbF().zzb((Throwable) e, true);
                zzna.zzb(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
            zzin.zzb("Error transporting the ad response", e);
            zzr.zzbF().zzb((Throwable) e, true);
            zzna.zzb(autoCloseOutputStream);
            return null;
        }
    }
}
