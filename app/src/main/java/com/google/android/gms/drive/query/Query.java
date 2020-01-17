package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new zza();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final boolean zzarL;
    final LogicalFilter zzatV;
    final String zzatW;
    final SortOrder zzatX;
    final List<String> zzatY;
    final boolean zzatZ;

    public static class Builder {
        private Set<DriveSpace> zzapC;
        private boolean zzarL;
        private String zzatW;
        private SortOrder zzatX;
        private List<String> zzatY;
        private boolean zzatZ;
        private final List<Filter> zzaua = new ArrayList();

        public Builder() {
        }

        public Builder(Query query) {
            this.zzaua.add(query.getFilter());
            this.zzatW = query.getPageToken();
            this.zzatX = query.getSortOrder();
            this.zzatY = query.zztJ();
            this.zzatZ = query.zztK();
            this.zzapC = query.zztL();
            this.zzarL = query.zztM();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzaua.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzauC, this.zzaua), this.zzatW, this.zzatX, (List) this.zzatY, this.zzatZ, (Set) this.zzapC, this.zzarL);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzatW = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzatX = sortOrder;
            return this;
        }
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, Set<DriveSpace> set, boolean z2) {
        this.mVersionCode = i;
        this.zzatV = logicalFilter;
        this.zzatW = str;
        this.zzatX = sortOrder;
        this.zzatY = list;
        this.zzatZ = z;
        this.zzapB = list2;
        this.zzapC = set;
        this.zzarL = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, List<DriveSpace> list2, boolean z2) {
        this(i, logicalFilter, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2), z2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private Query(LogicalFilter logicalFilter, String str, SortOrder sortOrder, List<String> list, boolean z, Set<DriveSpace> set, boolean z2) {
        this(1, logicalFilter, str, sortOrder, list, z, set == null ? null : new ArrayList(set), set, z2);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzatV;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzatW;
    }

    public SortOrder getSortOrder() {
        return this.zzatX;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzatV, this.zzatX, this.zzatW, this.zzapB});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<String> zztJ() {
        return this.zzatY;
    }

    public boolean zztK() {
        return this.zzatZ;
    }

    public Set<DriveSpace> zztL() {
        return this.zzapC;
    }

    public boolean zztM() {
        return this.zzarL;
    }
}
