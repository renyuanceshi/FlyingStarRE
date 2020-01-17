package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Parcelable.Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) logicalFilter.zzaug, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzauv, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcs */
    public LogicalFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Operator operator = null;
        ArrayList<FilterHolder> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    operator = (Operator) zza.zza(parcel, zzat, Operator.CREATOR);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzat, FilterHolder.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LogicalFilter(i, operator, (List<FilterHolder>) arrayList);
        }
        throw new zza.C0033zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzen */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }
}
