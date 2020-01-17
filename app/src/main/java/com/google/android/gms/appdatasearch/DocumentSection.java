package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public static final int zzTM = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzTN = new RegisterSectionInfo.zza("SsbContext").zzM(true).zzbB("blob").zzmh();
    final int mVersionCode;
    public final String zzTO;
    final RegisterSectionInfo zzTP;
    public final int zzTQ;
    public final byte[] zzTR;

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        zzx.zzb(i2 == zzTM || zzh.zzao(i2) != null, (Object) "Invalid section type " + i2);
        this.mVersionCode = i;
        this.zzTO = str;
        this.zzTP = registerSectionInfo;
        this.zzTQ = i2;
        this.zzTR = bArr;
        String zzmf = zzmf();
        if (zzmf != null) {
            throw new IllegalArgumentException(zzmf);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, zzTM, (byte[]) null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.zzbA(str2), (byte[]) null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, (String) null, registerSectionInfo, zzTM, bArr);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzTN);
    }

    public int describeContents() {
        zzd zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd zzd = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public String zzmf() {
        if (this.zzTQ != zzTM && zzh.zzao(this.zzTQ) == null) {
            return "Invalid section type " + this.zzTQ;
        }
        if (this.zzTO == null || this.zzTR == null) {
            return null;
        }
        return "Both content and blobContent set";
    }
}
