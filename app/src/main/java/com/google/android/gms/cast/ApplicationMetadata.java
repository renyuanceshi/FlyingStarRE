package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();
    String mName;
    private final int mVersionCode;
    String zzZC;
    List<String> zzZD;
    String zzZE;
    Uri zzZF;
    List<WebImage> zzxX;

    private ApplicationMetadata() {
        this.mVersionCode = 1;
        this.zzxX = new ArrayList();
        this.zzZD = new ArrayList();
    }

    ApplicationMetadata(int i, String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.mVersionCode = i;
        this.zzZC = str;
        this.mName = str2;
        this.zzxX = list;
        this.zzZD = list2;
        this.zzZE = str3;
        this.zzZF = uri;
    }

    public boolean areNamespacesSupported(List<String> list) {
        return this.zzZD != null && this.zzZD.containsAll(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof ApplicationMetadata)) {
                return false;
            }
            ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
            if (!zzf.zza(this.zzZC, applicationMetadata.zzZC) || !zzf.zza(this.zzxX, applicationMetadata.zzxX) || !zzf.zza(this.mName, applicationMetadata.mName) || !zzf.zza(this.zzZD, applicationMetadata.zzZD) || !zzf.zza(this.zzZE, applicationMetadata.zzZE) || !zzf.zza(this.zzZF, applicationMetadata.zzZF)) {
                return false;
            }
        }
        return true;
    }

    public String getApplicationId() {
        return this.zzZC;
    }

    public List<WebImage> getImages() {
        return this.zzxX;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.zzZE;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzZD);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzZC, this.mName, this.zzxX, this.zzZD, this.zzZE, this.zzZF);
    }

    public boolean isNamespaceSupported(String str) {
        return this.zzZD != null && this.zzZD.contains(str);
    }

    public String toString() {
        int i = 0;
        StringBuilder append = new StringBuilder().append("applicationId: ").append(this.zzZC).append(", name: ").append(this.mName).append(", images.count: ").append(this.zzxX == null ? 0 : this.zzxX.size()).append(", namespaces.count: ");
        if (this.zzZD != null) {
            i = this.zzZD.size();
        }
        return append.append(i).append(", senderAppIdentifier: ").append(this.zzZE).append(", senderAppLaunchUrl: ").append(this.zzZF).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zznx() {
        return this.zzZF;
    }
}
