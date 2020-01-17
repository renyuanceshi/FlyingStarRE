package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;

public class zzp implements PlacePhotoMetadata {
    /* access modifiers changed from: private */
    public int mIndex;
    private final int zzDF;
    private final int zzDG;
    /* access modifiers changed from: private */
    public final String zzaQR;
    private final CharSequence zzaQS;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaQR = str;
        this.zzDF = i;
        this.zzDG = i2;
        this.zzaQS = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof zzp)) {
                return false;
            }
            zzp zzp = (zzp) obj;
            if (zzp.zzDF != this.zzDF || zzp.zzDG != this.zzDG || !zzw.equal(zzp.zzaQR, this.zzaQR) || !zzw.equal(zzp.zzaQS, this.zzaQS)) {
                return false;
            }
        }
        return true;
    }

    public CharSequence getAttributions() {
        return this.zzaQS;
    }

    public int getMaxHeight() {
        return this.zzDG;
    }

    public int getMaxWidth() {
        return this.zzDF;
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient googleApiClient) {
        return getScaledPhoto(googleApiClient, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient googleApiClient, int i, int i2) {
        final int i3 = i;
        final int i4 = i2;
        return googleApiClient.zza(new zzf.zza<zze>(Places.zzaPN, googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) throws RemoteException {
                zze.zza(new zzf((zzf.zza) this), zzp.this.zzaQR, i3, i4, zzp.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzDF), Integer.valueOf(this.zzDG), this.zzaQR, this.zzaQS);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: zzzz */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
