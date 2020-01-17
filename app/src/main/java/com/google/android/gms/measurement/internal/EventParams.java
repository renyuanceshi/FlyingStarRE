package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    /* access modifiers changed from: private */
    public final Bundle zzaVS;

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.zzaVS = bundle;
    }

    EventParams(Bundle bundle) {
        zzx.zzz(bundle);
        this.zzaVS = bundle;
        this.versionCode = 1;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public Object get(String str) {
        return this.zzaVS.get(str);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> zzaVT = EventParams.this.zzaVS.keySet().iterator();

            public boolean hasNext() {
                return this.zzaVT.hasNext();
            }

            public String next() {
                return this.zzaVT.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    public int size() {
        return this.zzaVS.size();
    }

    public String toString() {
        return this.zzaVS.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public Bundle zzCC() {
        return new Bundle(this.zzaVS);
    }
}
