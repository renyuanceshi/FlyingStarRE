package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    private static final PlaceFilter zzaPz = new PlaceFilter();
    final int mVersionCode;
    final boolean zzaPA;
    final List<String> zzaPj;
    final List<Integer> zzaPk;
    final List<UserDataType> zzaPl;
    private final Set<String> zzaPo;
    private final Set<Integer> zzaPp;
    private final Set<UserDataType> zzaPq;

    @Deprecated
    public static final class zza {
        private boolean zzaPA;
        private Collection<Integer> zzaPB;
        private Collection<UserDataType> zzaPC;
        private String[] zzaPD;

        private zza() {
            this.zzaPB = null;
            this.zzaPA = false;
            this.zzaPC = null;
            this.zzaPD = null;
        }

        public PlaceFilter zzze() {
            List list = null;
            ArrayList arrayList = this.zzaPB != null ? new ArrayList(this.zzaPB) : null;
            ArrayList arrayList2 = this.zzaPC != null ? new ArrayList(this.zzaPC) : null;
            if (this.zzaPD != null) {
                list = Arrays.asList(this.zzaPD);
            }
            return new PlaceFilter(arrayList, this.zzaPA, list, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, (Collection<String>) null);
    }

    PlaceFilter(int i, @Nullable List<Integer> list, boolean z, @Nullable List<String> list2, @Nullable List<UserDataType> list3) {
        this.mVersionCode = i;
        this.zzaPk = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaPA = z;
        this.zzaPl = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaPj = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaPp = zzw(this.zzaPk);
        this.zzaPq = zzw(this.zzaPl);
        this.zzaPo = zzw(this.zzaPj);
    }

    public PlaceFilter(@Nullable Collection<Integer> collection, boolean z, @Nullable Collection<String> collection2, @Nullable Collection<UserDataType> collection3) {
        this(0, zzf(collection), z, zzf(collection2), zzf(collection3));
    }

    public PlaceFilter(boolean z, @Nullable Collection<String> collection) {
        this((Collection<Integer>) null, z, collection, (Collection<UserDataType>) null);
    }

    @Deprecated
    public static PlaceFilter zzzd() {
        return new zza().zzze();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PlaceFilter)) {
                return false;
            }
            PlaceFilter placeFilter = (PlaceFilter) obj;
            if (!this.zzaPp.equals(placeFilter.zzaPp) || this.zzaPA != placeFilter.zzaPA || !this.zzaPq.equals(placeFilter.zzaPq) || !this.zzaPo.equals(placeFilter.zzaPo)) {
                return false;
            }
        }
        return true;
    }

    public Set<String> getPlaceIds() {
        return this.zzaPo;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaPp;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPp, Boolean.valueOf(this.zzaPA), this.zzaPq, this.zzaPo);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaPA;
    }

    public String toString() {
        zzw.zza zzy = zzw.zzy(this);
        if (!this.zzaPp.isEmpty()) {
            zzy.zzg("types", this.zzaPp);
        }
        zzy.zzg("requireOpenNow", Boolean.valueOf(this.zzaPA));
        if (!this.zzaPo.isEmpty()) {
            zzy.zzg("placeIds", this.zzaPo);
        }
        if (!this.zzaPq.isEmpty()) {
            zzy.zzg("requestedUserDataTypes", this.zzaPq);
        }
        return zzy.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
