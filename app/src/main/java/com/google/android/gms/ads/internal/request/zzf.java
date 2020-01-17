package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<AdRequestInfoParcel> {
    static void zza(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, adRequestInfoParcel.versionCode);
        zzb.zza(parcel, 2, adRequestInfoParcel.zzHs, false);
        zzb.zza(parcel, 3, (Parcelable) adRequestInfoParcel.zzHt, i, false);
        zzb.zza(parcel, 4, (Parcelable) adRequestInfoParcel.zzrp, i, false);
        zzb.zza(parcel, 5, adRequestInfoParcel.zzrj, false);
        zzb.zza(parcel, 6, (Parcelable) adRequestInfoParcel.applicationInfo, i, false);
        zzb.zza(parcel, 7, (Parcelable) adRequestInfoParcel.zzHu, i, false);
        zzb.zza(parcel, 8, adRequestInfoParcel.zzHv, false);
        zzb.zza(parcel, 9, adRequestInfoParcel.zzHw, false);
        zzb.zza(parcel, 10, adRequestInfoParcel.zzHx, false);
        zzb.zza(parcel, 11, (Parcelable) adRequestInfoParcel.zzrl, i, false);
        zzb.zza(parcel, 12, adRequestInfoParcel.zzHy, false);
        zzb.zzc(parcel, 13, adRequestInfoParcel.zzHz);
        zzb.zzb(parcel, 14, adRequestInfoParcel.zzrH, false);
        zzb.zza(parcel, 15, adRequestInfoParcel.zzHA, false);
        zzb.zza(parcel, 17, (Parcelable) adRequestInfoParcel.zzHC, i, false);
        zzb.zza(parcel, 16, adRequestInfoParcel.zzHB);
        zzb.zzc(parcel, 19, adRequestInfoParcel.zzHE);
        zzb.zzc(parcel, 18, adRequestInfoParcel.zzHD);
        zzb.zza(parcel, 21, adRequestInfoParcel.zzHG, false);
        zzb.zza(parcel, 20, adRequestInfoParcel.zzHF);
        zzb.zza(parcel, 25, adRequestInfoParcel.zzHH);
        zzb.zzb(parcel, 27, adRequestInfoParcel.zzHJ, false);
        zzb.zza(parcel, 26, adRequestInfoParcel.zzHI, false);
        zzb.zza(parcel, 29, (Parcelable) adRequestInfoParcel.zzrD, i, false);
        zzb.zza(parcel, 28, adRequestInfoParcel.zzri, false);
        zzb.zza(parcel, 31, adRequestInfoParcel.zzHL);
        zzb.zzb(parcel, 30, adRequestInfoParcel.zzHK, false);
        zzb.zza(parcel, 34, adRequestInfoParcel.zzHO);
        zzb.zzc(parcel, 35, adRequestInfoParcel.zzHP);
        zzb.zza(parcel, 32, (Parcelable) adRequestInfoParcel.zzHM, i, false);
        zzb.zza(parcel, 33, adRequestInfoParcel.zzHN, false);
        zzb.zzc(parcel, 36, adRequestInfoParcel.zzHQ);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzG */
    public AdRequestInfoParcel[] newArray(int i) {
        return new AdRequestInfoParcel[i];
    }

    /* renamed from: zzi */
    public AdRequestInfoParcel createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        ArrayList<String> arrayList3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        float f2 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) zza.zza(parcel, zzat, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) zza.zza(parcel, zzat, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) zza.zza(parcel, zzat, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) zza.zza(parcel, zzat, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzat, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = zza.zzr(parcel, zzat);
                    break;
                case 13:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 14:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 15:
                    bundle3 = zza.zzr(parcel, zzat);
                    break;
                case 16:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 17:
                    messenger = (Messenger) zza.zza(parcel, zzat, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 19:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 20:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 21:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 25:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 26:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 27:
                    arrayList2 = zza.zzD(parcel, zzat);
                    break;
                case 28:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) zza.zza(parcel, zzat, NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    arrayList3 = zza.zzD(parcel, zzat);
                    break;
                case 31:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) zza.zza(parcel, zzat, CapabilityParcel.CREATOR);
                    break;
                case 33:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case 34:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case 35:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 36:
                    i6 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, arrayList, bundle3, z, messenger, i3, i4, f, str5, j, str6, arrayList2, str7, nativeAdOptionsParcel, arrayList3, j2, capabilityParcel, str8, f2, i5, i6);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }
}
