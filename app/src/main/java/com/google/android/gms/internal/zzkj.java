package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class zzkj {
    private static DocumentSection zza(String str, zzpm.zzc zzc) {
        return new DocumentSection(zzsu.toByteArray(zzc), new RegisterSectionInfo.zza(str).zzM(true).zzbC(str).zzbB("blob").zzmh());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzmk());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzkk.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        DocumentContents.zza zza2 = UsageInfo.zza(zza, string, parse, string2, (List<AppIndexApi.AppIndexingLink>) null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zzb(new Account(bundle.getString(".private:accountName"), "com.google"));
            bundle.remove(".private:accountName");
        }
        if (!bundle.containsKey(".private:isContextOnly") || !bundle.getBoolean(".private:isContextOnly")) {
            i2 = 0;
        } else {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzg(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, zza)).zzw(j).zzar(i2).zza(zza2.zzme()).zzO(z).zzas(i).zzmi();
    }

    private static zzpm.zzb zzb(String str, Bundle bundle) {
        zzpm.zzb zzb = new zzpm.zzb();
        zzb.name = str;
        zzb.zzaMt = new zzpm.zzd();
        zzb.zzaMt.zzaMy = zzg(bundle);
        return zzb;
    }

    static zzpm.zzc zzg(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                arrayList.add(zzp(str, (String) obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(zzb(str, (Bundle) obj));
            } else if (obj instanceof String[]) {
                for (String str2 : (String[]) obj) {
                    if (str2 != null) {
                        arrayList.add(zzp(str, str2));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                for (Bundle bundle2 : (Bundle[]) obj) {
                    if (bundle2 != null) {
                        arrayList.add(zzb(str, bundle2));
                    }
                }
            } else if (obj instanceof Boolean) {
                arrayList.add(zzi(str, ((Boolean) obj).booleanValue()));
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
        }
        zzpm.zzc zzc = new zzpm.zzc();
        if (bundle.containsKey("type")) {
            zzc.type = bundle.getString("type");
        }
        zzc.zzaMu = (zzpm.zzb[]) arrayList.toArray(new zzpm.zzb[arrayList.size()]);
        return zzc;
    }

    private static zzpm.zzb zzi(String str, boolean z) {
        zzpm.zzb zzb = new zzpm.zzb();
        zzb.name = str;
        zzb.zzaMt = new zzpm.zzd();
        zzb.zzaMt.zzaMv = z;
        return zzb;
    }

    private static zzpm.zzb zzp(String str, String str2) {
        zzpm.zzb zzb = new zzpm.zzb();
        zzb.name = str;
        zzb.zzaMt = new zzpm.zzd();
        zzb.zzaMt.zzamJ = str2;
        return zzb;
    }
}
