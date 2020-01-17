package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

@KeepName
public class CommonWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new zza();
    private final int mVersionCode;
    String name;
    int state;
    String zzboQ;
    String zzboS;
    String zzboT;
    String zzboU;
    String zzboV;
    String zzboW;
    ArrayList<WalletObjectMessage> zzboX;
    TimeInterval zzboY;
    ArrayList<LatLng> zzboZ;
    String zzbpa;
    String zzbpb;
    ArrayList<LabelValueRow> zzbpc;
    boolean zzbpd;
    ArrayList<UriData> zzbpe;
    ArrayList<TextModuleData> zzbpf;
    ArrayList<UriData> zzbpg;
    String zzio;

    public final class zza {
        private zza() {
        }

        public CommonWalletObject zzIs() {
            return CommonWalletObject.this;
        }

        public zza zzgK(String str) {
            CommonWalletObject.this.zzio = str;
            return this;
        }
    }

    CommonWalletObject() {
        this.mVersionCode = 1;
        this.zzboX = zzmn.zzsa();
        this.zzboZ = zzmn.zzsa();
        this.zzbpc = zzmn.zzsa();
        this.zzbpe = zzmn.zzsa();
        this.zzbpf = zzmn.zzsa();
        this.zzbpg = zzmn.zzsa();
    }

    CommonWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, ArrayList<WalletObjectMessage> arrayList, TimeInterval timeInterval, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<LabelValueRow> arrayList3, boolean z, ArrayList<UriData> arrayList4, ArrayList<TextModuleData> arrayList5, ArrayList<UriData> arrayList6) {
        this.mVersionCode = i;
        this.zzio = str;
        this.zzboW = str2;
        this.name = str3;
        this.zzboQ = str4;
        this.zzboS = str5;
        this.zzboT = str6;
        this.zzboU = str7;
        this.zzboV = str8;
        this.state = i2;
        this.zzboX = arrayList;
        this.zzboY = timeInterval;
        this.zzboZ = arrayList2;
        this.zzbpa = str9;
        this.zzbpb = str10;
        this.zzbpc = arrayList3;
        this.zzbpd = z;
        this.zzbpe = arrayList4;
        this.zzbpf = arrayList5;
        this.zzbpg = arrayList6;
    }

    public static zza zzIr() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzio;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
