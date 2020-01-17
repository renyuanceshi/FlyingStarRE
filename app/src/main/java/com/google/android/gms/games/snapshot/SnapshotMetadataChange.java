package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private Long zzaKN;
        private Long zzaKO;
        private BitmapTeleporter zzaKP;
        private Uri zzaKQ;
        private String zzaxl;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzaxl, this.zzaKN, this.zzaKP, this.zzaKQ, this.zzaKO);
        }

        public Builder fromMetadata(SnapshotMetadata snapshotMetadata) {
            this.zzaxl = snapshotMetadata.getDescription();
            this.zzaKN = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzaKO = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzaKN.longValue() == -1) {
                this.zzaKN = null;
            }
            this.zzaKQ = snapshotMetadata.getCoverImageUri();
            if (this.zzaKQ != null) {
                this.zzaKP = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap bitmap) {
            this.zzaKP = new BitmapTeleporter(bitmap);
            this.zzaKQ = null;
            return this;
        }

        public Builder setDescription(String str) {
            this.zzaxl = str;
            return this;
        }

        public Builder setPlayedTimeMillis(long j) {
            this.zzaKN = Long.valueOf(j);
            return this;
        }

        public Builder setProgressValue(long j) {
            this.zzaKO = Long.valueOf(j);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzxU();
}
