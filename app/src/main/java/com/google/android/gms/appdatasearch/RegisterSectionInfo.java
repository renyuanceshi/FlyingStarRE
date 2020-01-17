package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzUd;
    public final boolean zzUe;
    public final boolean zzUf;
    public final String zzUg;
    public final Feature[] zzUh;
    final int[] zzUi;
    public final String zzUj;

    public static final class zza {
        private final String mName;
        private String zzUk;
        private boolean zzUl;
        private int zzUm = 1;
        private boolean zzUn;
        private String zzUo;
        private final List<Feature> zzUp = new ArrayList();
        private BitSet zzUq;
        private String zzUr;

        public zza(String str) {
            this.mName = str;
        }

        public zza zzM(boolean z) {
            this.zzUl = z;
            return this;
        }

        public zza zzN(boolean z) {
            this.zzUn = z;
            return this;
        }

        public zza zzap(int i) {
            if (this.zzUq == null) {
                this.zzUq = new BitSet();
            }
            this.zzUq.set(i);
            return this;
        }

        public zza zzbB(String str) {
            this.zzUk = str;
            return this;
        }

        public zza zzbC(String str) {
            this.zzUr = str;
            return this;
        }

        public RegisterSectionInfo zzmh() {
            int i = 0;
            int[] iArr = null;
            if (this.zzUq != null) {
                iArr = new int[this.zzUq.cardinality()];
                int nextSetBit = this.zzUq.nextSetBit(0);
                while (nextSetBit >= 0) {
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzUq.nextSetBit(nextSetBit + 1);
                    i++;
                }
            }
            return new RegisterSectionInfo(this.mName, this.zzUk, this.zzUl, this.zzUm, this.zzUn, this.zzUo, (Feature[]) this.zzUp.toArray(new Feature[this.zzUp.size()]), iArr, this.zzUr);
        }
    }

    RegisterSectionInfo(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this.mVersionCode = i;
        this.name = str;
        this.zzUd = str2;
        this.zzUe = z;
        this.weight = i2;
        this.zzUf = z2;
        this.zzUg = str3;
        this.zzUh = featureArr;
        this.zzUi = iArr;
        this.zzUj = str4;
    }

    RegisterSectionInfo(String str, String str2, boolean z, int i, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
    }

    public int describeContents() {
        zzi zzi = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi zzi = CREATOR;
        zzi.zza(this, parcel, i);
    }
}
