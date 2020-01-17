package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaKO;
    private final Uri zzaKQ;
    private final Long zzaKR;
    private BitmapTeleporter zzaKS;
    private final String zzaxl;

    SnapshotMetadataChangeEntity() {
        this(5, (String) null, (Long) null, (BitmapTeleporter) null, (Uri) null, (Long) null);
    }

    SnapshotMetadataChangeEntity(int i, String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        boolean z = true;
        boolean z2 = false;
        this.mVersionCode = i;
        this.zzaxl = str;
        this.zzaKR = l;
        this.zzaKS = bitmapTeleporter;
        this.zzaKQ = uri;
        this.zzaKO = l2;
        if (this.zzaKS != null) {
            zzx.zza(this.zzaKQ == null ? true : z2, (Object) "Cannot set both a URI and an image");
        } else if (this.zzaKQ != null) {
            zzx.zza(this.zzaKS != null ? false : z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this(5, str, l, bitmapTeleporter, uri, l2);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        if (this.zzaKS == null) {
            return null;
        }
        return this.zzaKS.zzqa();
    }

    public Uri getCoverImageUri() {
        return this.zzaKQ;
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public Long getPlayedTimeMillis() {
        return this.zzaKR;
    }

    public Long getProgressValue() {
        return this.zzaKO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        SnapshotMetadataChangeCreator.zza(this, parcel, i);
    }

    public BitmapTeleporter zzxU() {
        return this.zzaKS;
    }
}
