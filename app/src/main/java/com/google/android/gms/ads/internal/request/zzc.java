package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.request.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;

@zzhb
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzit zza(final Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        return zza(context, versionInfoParcel, zzji, zza2, new zzb() {
            public boolean zza(VersionInfoParcel versionInfoParcel) {
                return versionInfoParcel.zzNb || (zze.zzap(context) && !zzbt.zzwb.get().booleanValue());
            }
        });
    }

    static zzit zza(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2, zzb zzb2) {
        return zzb2.zza(versionInfoParcel) ? zza(context, zzji, zza2) : zzb(context, versionInfoParcel, zzji, zza2);
    }

    private static zzit zza(Context context, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        zzin.zzaI("Fetching ad response from local ad request service.");
        zzd.zza zza3 = new zzd.zza(context, zzji, zza2);
        zza3.zzgd();
        return zza3;
    }

    private static zzit zzb(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zza zza2) {
        zzin.zzaI("Fetching ad response from remote ad request service.");
        if (zzn.zzcS().zzU(context)) {
            return new zzd.zzb(context, versionInfoParcel, zzji, zza2);
        }
        zzin.zzaK("Failed to connect to remote ad request service.");
        return null;
    }
}
