package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;
    private final List<Field> zzawE;

    public static class Builder {
        /* access modifiers changed from: private */
        public String mName;
        /* access modifiers changed from: private */
        public List<Field> zzawE = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzawE.contains(field)) {
                this.zzawE.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            zzx.zzb(str != null && !str.isEmpty(), (Object) "Invalid name specified");
            return addField(Field.zzn(str, i));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzx.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzawE.isEmpty()) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    DataTypeCreateRequest(int i, String str, List<Field> list, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzawE = Collections.unmodifiableList(list);
        this.zzaBa = zzoj.zza.zzbE(iBinder);
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzawE, (zzoj) null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzoj zzoj) {
        this(dataTypeCreateRequest.mName, dataTypeCreateRequest.zzawE, zzoj);
    }

    public DataTypeCreateRequest(String str, List<Field> list, zzoj zzoj) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzawE = Collections.unmodifiableList(list);
        this.zzaBa = zzoj;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzw.equal(this.mName, dataTypeCreateRequest.mName) && zzw.equal(this.zzawE, dataTypeCreateRequest.zzawE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBa == null) {
            return null;
        }
        return this.zzaBa.asBinder();
    }

    public List<Field> getFields() {
        return this.zzawE;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzawE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("fields", this.zzawE).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
