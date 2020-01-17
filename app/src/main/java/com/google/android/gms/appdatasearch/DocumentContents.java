package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final Account account;
    final int mVersionCode;
    final DocumentSection[] zzTC;
    public final String zzTD;
    public final boolean zzTE;

    public static class zza {
        private List<DocumentSection> zzTF;
        private String zzTG;
        private boolean zzTH;
        private Account zzTI;

        public zza zzL(boolean z) {
            this.zzTH = z;
            return this;
        }

        public zza zza(DocumentSection documentSection) {
            if (this.zzTF == null) {
                this.zzTF = new ArrayList();
            }
            this.zzTF.add(documentSection);
            return this;
        }

        public zza zzb(Account account) {
            this.zzTI = account;
            return this;
        }

        public zza zzbz(String str) {
            this.zzTG = str;
            return this;
        }

        public DocumentContents zzme() {
            return new DocumentContents(this.zzTG, this.zzTH, this.zzTI, this.zzTF != null ? (DocumentSection[]) this.zzTF.toArray(new DocumentSection[this.zzTF.size()]) : null);
        }
    }

    DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account2) {
        this.mVersionCode = i;
        this.zzTC = documentSectionArr;
        this.zzTD = str;
        this.zzTE = z;
        this.account = account2;
    }

    DocumentContents(String str, boolean z, Account account2, DocumentSection... documentSectionArr) {
        this(1, documentSectionArr, str, z, account2);
        BitSet bitSet = new BitSet(zzh.zzmg());
        for (DocumentSection documentSection : documentSectionArr) {
            int i = documentSection.zzTQ;
            if (i != -1) {
                if (bitSet.get(i)) {
                    throw new IllegalArgumentException("Duplicate global search section type " + zzh.zzao(i));
                }
                bitSet.set(i);
            }
        }
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }
}
