package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@zzhb
class zzec {
    final int zzAC;
    final String zzpS;
    final AdRequestParcel zzqH;

    zzec(AdRequestParcel adRequestParcel, String str, int i) {
        this.zzqH = adRequestParcel;
        this.zzpS = str;
        this.zzAC = i;
    }

    zzec(zzea zzea) {
        this(zzea.zzei(), zzea.getAdUnitId(), zzea.getNetworkType());
    }

    zzec(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            this.zzpS = new String(Base64.decode(split[0], 0), "UTF-8");
            this.zzAC = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            this.zzqH = AdRequestParcel.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        } catch (IllegalArgumentException e) {
            throw new IOException("Malformed QueueSeed encoding.");
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public String zzem() {
        Parcel obtain = Parcel.obtain();
        try {
            String encodeToString = Base64.encodeToString(this.zzpS.getBytes("UTF-8"), 0);
            String num = Integer.toString(this.zzAC);
            this.zzqH.writeToParcel(obtain, 0);
            String str = encodeToString + "\u0000" + num + "\u0000" + Base64.encodeToString(obtain.marshall(), 0);
            obtain.recycle();
            return str;
        } catch (UnsupportedEncodingException e) {
            zzin.e("QueueSeed encode failed because UTF-8 is not available.");
            obtain.recycle();
            return "";
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }
}
