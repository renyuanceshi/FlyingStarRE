package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzUs;
    final long zzUt;
    int zzUu;
    final DocumentContents zzUv;
    final boolean zzUw;
    int zzUx;
    int zzUy;
    public final String zzvp;

    public static final class zza {
        private String zzOJ;
        private DocumentId zzUs;
        private long zzUt = -1;
        private int zzUu = -1;
        private DocumentContents zzUv;
        private boolean zzUw = false;
        private int zzUx = -1;
        private int zzUy = 0;

        public zza zzO(boolean z) {
            this.zzUw = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzUv = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzUs = documentId;
            return this;
        }

        public zza zzar(int i) {
            this.zzUu = i;
            return this;
        }

        public zza zzas(int i) {
            this.zzUy = i;
            return this;
        }

        public UsageInfo zzmi() {
            return new UsageInfo(this.zzUs, this.zzUt, this.zzUu, this.zzOJ, this.zzUv, this.zzUw, this.zzUx, this.zzUy);
        }

        public zza zzw(long j) {
            this.zzUt = j;
            return this;
        }
    }

    UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.mVersionCode = i;
        this.zzUs = documentId;
        this.zzUt = j;
        this.zzUu = i2;
        this.zzvp = str;
        this.zzUv = documentContents;
        this.zzUw = z;
        this.zzUx = i3;
        this.zzUy = i4;
    }

    private UsageInfo(DocumentId documentId, long j, int i, String str, DocumentContents documentContents, boolean z, int i2, int i3) {
        this(1, documentId, j, i, str, documentContents, z, i2, i3);
    }

    public UsageInfo(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexApi.AppIndexingLink> list, int i) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, (String) null, zza(intent, str2, uri, str3, list).zzme(), false, -1, i);
    }

    public static DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexApi.AppIndexingLink> list) {
        String string;
        DocumentContents.zza zza2 = new DocumentContents.zza();
        zza2.zza(zzbD(str));
        if (uri != null) {
            zza2.zza(zzi(uri));
        }
        if (list != null) {
            zza2.zza(zzs(list));
        }
        String action = intent.getAction();
        if (action != null) {
            zza2.zza(zzo("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zza2.zza(zzo("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zza2.zza(zzo("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (!(extras == null || (string = extras.getString("intent_extra_data_key")) == null)) {
            zza2.zza(zzo("intent_extra_data", string));
        }
        return zza2.zzbz(str2).zzL(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzn(str, zzg(intent));
    }

    private static DocumentSection zzbD(String str) {
        return new DocumentSection(str, new RegisterSectionInfo.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzap(1).zzN(true).zzbC("name").zzmh(), "text1");
    }

    private static String zzg(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new RegisterSectionInfo.zza("web_url").zzap(4).zzM(true).zzbC(PlusShare.KEY_CALL_TO_ACTION_URL).zzmh());
    }

    private static DocumentId zzn(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzo(String str, String str2) {
        return new DocumentSection(str2, new RegisterSectionInfo.zza(str).zzM(true).zzmh(), str);
    }

    private static DocumentSection zzs(List<AppIndexApi.AppIndexingLink> list) {
        zzpm.zza zza2 = new zzpm.zza();
        zzpm.zza.C0133zza[] zzaArr = new zzpm.zza.C0133zza[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < zzaArr.length) {
                zzaArr[i2] = new zzpm.zza.C0133zza();
                AppIndexApi.AppIndexingLink appIndexingLink = list.get(i2);
                zzaArr[i2].zzaMq = appIndexingLink.appIndexingUrl.toString();
                zzaArr[i2].viewId = appIndexingLink.viewId;
                if (appIndexingLink.webUrl != null) {
                    zzaArr[i2].zzaMr = appIndexingLink.webUrl.toString();
                }
                i = i2 + 1;
            } else {
                zza2.zzaMo = zzaArr;
                return new DocumentSection(zzsu.toByteArray(zza2), new RegisterSectionInfo.zza("outlinks").zzM(true).zzbC(".private:outLinks").zzbB("blob").zzmh());
            }
        }
    }

    public int describeContents() {
        zzj zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzUs, Long.valueOf(this.zzUt), Integer.valueOf(this.zzUu), Integer.valueOf(this.zzUy)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj zzj = CREATOR;
        zzj.zza(this, parcel, i);
    }
}
