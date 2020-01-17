package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new zze();
    final int mVersionCode;
    public Uri uri;
    private byte[] zzaKm;
    private String zzbqU;
    public ParcelFileDescriptor zzbqV;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri2) {
        this.mVersionCode = i;
        this.zzaKm = bArr;
        this.zzbqU = str;
        this.zzbqV = parcelFileDescriptor;
        this.uri = uri2;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, (String) null, (ParcelFileDescriptor) null, (Uri) null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, (byte[]) null, (String) null, parcelFileDescriptor, (Uri) null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String str) {
        if (str != null) {
            return new Asset(1, (byte[]) null, str, (ParcelFileDescriptor) null, (Uri) null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri2) {
        if (uri2 != null) {
            return new Asset(1, (byte[]) null, (String) null, (ParcelFileDescriptor) null, uri2);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Asset)) {
                return false;
            }
            Asset asset = (Asset) obj;
            if (!zzw.equal(this.zzaKm, asset.zzaKm) || !zzw.equal(this.zzbqU, asset.zzbqU) || !zzw.equal(this.zzbqV, asset.zzbqV) || !zzw.equal(this.uri, asset.uri)) {
                return false;
            }
        }
        return true;
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public String getDigest() {
        return this.zzbqU;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzbqV;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKm, this.zzbqU, this.zzbqV, this.uri);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzbqU == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.zzbqU);
        }
        if (this.zzaKm != null) {
            sb.append(", size=");
            sb.append(this.zzaKm.length);
        }
        if (this.zzbqV != null) {
            sb.append(", fd=");
            sb.append(this.zzbqV);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
