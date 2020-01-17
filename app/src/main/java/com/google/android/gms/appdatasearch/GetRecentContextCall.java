package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetRecentContextCall {

    public static class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        final int mVersionCode;
        public final Account zzTT;
        public final boolean zzTU;
        public final boolean zzTV;
        public final boolean zzTW;
        public final String zzTX;

        public Request() {
            this((Account) null, false, false, false, (String) null);
        }

        Request(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
            this.mVersionCode = i;
            this.zzTT = account;
            this.zzTU = z;
            this.zzTV = z2;
            this.zzTW = z3;
            this.zzTX = str;
        }

        public Request(Account account, boolean z, boolean z2, boolean z3, String str) {
            this(1, account, z, z2, z3, str);
        }

        public int describeContents() {
            zzf zzf = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzf zzf = CREATOR;
            zzf.zza(this, parcel, i);
        }
    }

    public static class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();
        final int mVersionCode;
        public Status zzTY;
        public List<UsageInfo> zzTZ;
        @Deprecated
        public String[] zzUa;

        public Response() {
            this.mVersionCode = 1;
        }

        Response(int i, Status status, List<UsageInfo> list, String[] strArr) {
            this.mVersionCode = i;
            this.zzTY = status;
            this.zzTZ = list;
            this.zzUa = strArr;
        }

        public int describeContents() {
            zzg zzg = CREATOR;
            return 0;
        }

        public Status getStatus() {
            return this.zzTY;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzg zzg = CREATOR;
            zzg.zza(this, parcel, i);
        }
    }
}
