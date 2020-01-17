package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzq extends zzk<UserMetadata> {
    public zzq(String str, int i) {
        super(str, zzdg(str), Collections.emptyList(), i);
    }

    private static String zzB(String str, String str2) {
        return str + "." + str2;
    }

    private String zzdf(String str) {
        return zzB(getName(), str);
    }

    private static Collection<String> zzdg(String str) {
        return Arrays.asList(new String[]{zzB(str, "permissionId"), zzB(str, "displayName"), zzB(str, "picture"), zzB(str, "isAuthenticatedUser"), zzB(str, "emailAddress")});
    }

    /* access modifiers changed from: protected */
    public boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzcz(zzdf("permissionId")) && !dataHolder.zzi(zzdf("permissionId"), i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzj */
    public UserMetadata zzc(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzdf("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzdf("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzdf("picture"), i, i2);
        boolean zze = dataHolder.zze(zzdf("isAuthenticatedUser"), i, i2);
        return new UserMetadata(zzd, zzd2, zzd3, Boolean.valueOf(zze).booleanValue(), dataHolder.zzd(zzdf("emailAddress"), i, i2));
    }
}
