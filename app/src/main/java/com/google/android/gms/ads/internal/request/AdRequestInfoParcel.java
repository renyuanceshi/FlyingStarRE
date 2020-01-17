package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.List;

@zzhb
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final Bundle zzHA;
    public final boolean zzHB;
    public final Messenger zzHC;
    public final int zzHD;
    public final int zzHE;
    public final float zzHF;
    public final String zzHG;
    public final long zzHH;
    public final String zzHI;
    public final List<String> zzHJ;
    public final List<String> zzHK;
    public final long zzHL;
    public final CapabilityParcel zzHM;
    public final String zzHN;
    public final float zzHO;
    public final int zzHP;
    public final int zzHQ;
    public final Bundle zzHs;
    public final AdRequestParcel zzHt;
    public final PackageInfo zzHu;
    public final String zzHv;
    public final String zzHw;
    public final String zzHx;
    public final Bundle zzHy;
    public final int zzHz;
    public final NativeAdOptionsParcel zzrD;
    public final List<String> zzrH;
    public final String zzri;
    public final String zzrj;
    public final VersionInfoParcel zzrl;
    public final AdSizeParcel zzrp;

    @zzhb
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final Bundle zzHA;
        public final boolean zzHB;
        public final Messenger zzHC;
        public final int zzHD;
        public final int zzHE;
        public final float zzHF;
        public final String zzHG;
        public final long zzHH;
        public final String zzHI;
        public final List<String> zzHJ;
        public final List<String> zzHK;
        public final CapabilityParcel zzHM;
        public final String zzHN;
        public final float zzHO;
        public final int zzHP;
        public final int zzHQ;
        public final Bundle zzHs;
        public final AdRequestParcel zzHt;
        public final PackageInfo zzHu;
        public final String zzHw;
        public final String zzHx;
        public final Bundle zzHy;
        public final int zzHz;
        public final NativeAdOptionsParcel zzrD;
        public final List<String> zzrH;
        public final String zzri;
        public final String zzrj;
        public final VersionInfoParcel zzrl;
        public final AdSizeParcel zzrp;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, int i3, int i4) {
            this.zzHs = bundle;
            this.zzHt = adRequestParcel;
            this.zzrp = adSizeParcel;
            this.zzrj = str;
            this.applicationInfo = applicationInfo2;
            this.zzHu = packageInfo;
            this.zzHw = str2;
            this.zzHx = str3;
            this.zzrl = versionInfoParcel;
            this.zzHy = bundle2;
            this.zzHB = z;
            this.zzHC = messenger;
            this.zzHD = i;
            this.zzHE = i2;
            this.zzHF = f;
            if (list == null || list.size() <= 0) {
                if (adSizeParcel.zzum) {
                    this.zzHz = 4;
                } else {
                    this.zzHz = 0;
                }
                this.zzrH = null;
                this.zzHK = null;
            } else {
                this.zzHz = 3;
                this.zzrH = list;
                this.zzHK = list2;
            }
            this.zzHA = bundle3;
            this.zzHG = str4;
            this.zzHH = j;
            this.zzHI = str5;
            this.zzHJ = list3;
            this.zzri = str6;
            this.zzrD = nativeAdOptionsParcel;
            this.zzHM = capabilityParcel;
            this.zzHN = str7;
            this.zzHO = f2;
            this.zzHP = i3;
            this.zzHQ = i4;
        }
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i5, int i6) {
        this.versionCode = i;
        this.zzHs = bundle;
        this.zzHt = adRequestParcel;
        this.zzrp = adSizeParcel;
        this.zzrj = str;
        this.applicationInfo = applicationInfo2;
        this.zzHu = packageInfo;
        this.zzHv = str2;
        this.zzHw = str3;
        this.zzHx = str4;
        this.zzrl = versionInfoParcel;
        this.zzHy = bundle2;
        this.zzHz = i2;
        this.zzrH = list;
        this.zzHK = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzHA = bundle3;
        this.zzHB = z;
        this.zzHC = messenger;
        this.zzHD = i3;
        this.zzHE = i4;
        this.zzHF = f;
        this.zzHG = str5;
        this.zzHH = j;
        this.zzHI = str6;
        this.zzHJ = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzri = str7;
        this.zzrD = nativeAdOptionsParcel;
        this.zzHL = j2;
        this.zzHM = capabilityParcel;
        this.zzHN = str8;
        this.zzHO = f2;
        this.zzHP = i5;
        this.zzHQ = i6;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, int i4, int i5) {
        this(15, bundle, adRequestParcel, adSizeParcel, str, applicationInfo2, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, i4, i5);
    }

    public AdRequestInfoParcel(zza zza2, String str, long j) {
        this(zza2.zzHs, zza2.zzHt, zza2.zzrp, zza2.zzrj, zza2.applicationInfo, zza2.zzHu, str, zza2.zzHw, zza2.zzHx, zza2.zzrl, zza2.zzHy, zza2.zzHz, zza2.zzrH, zza2.zzHK, zza2.zzHA, zza2.zzHB, zza2.zzHC, zza2.zzHD, zza2.zzHE, zza2.zzHF, zza2.zzHG, zza2.zzHH, zza2.zzHI, zza2.zzHJ, zza2.zzri, zza2.zzrD, j, zza2.zzHM, zza2.zzHN, zza2.zzHO, zza2.zzHP, zza2.zzHQ);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
