package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;

public final class VideoEntity implements SafeParcelable, Video {
    public static final Parcelable.Creator<VideoEntity> CREATOR = new VideoEntityCreator();
    private final int mVersionCode;
    private final long zzCv;
    private final String zzTJ;
    private final String zzaLv;
    private final long zzaLw;
    private final int zzakd;

    VideoEntity(int i, int i2, String str, long j, long j2, String str2) {
        this.mVersionCode = i;
        this.zzakd = i2;
        this.zzaLv = str;
        this.zzaLw = j;
        this.zzCv = j2;
        this.zzTJ = str2;
    }

    public VideoEntity(Video video) {
        this.mVersionCode = 1;
        this.zzakd = video.getDuration();
        this.zzaLv = video.zzxX();
        this.zzaLw = video.getFileSize();
        this.zzCv = video.getStartTime();
        this.zzTJ = video.getPackageName();
        zzb.zzv(this.zzaLv);
        zzb.zzv(this.zzTJ);
    }

    static int zza(Video video) {
        return zzw.hashCode(Integer.valueOf(video.getDuration()), video.zzxX(), Long.valueOf(video.getFileSize()), Long.valueOf(video.getStartTime()), video.getPackageName());
    }

    static boolean zza(Video video, Object obj) {
        if (!(obj instanceof Video)) {
            return false;
        }
        if (video != obj) {
            Video video2 = (Video) obj;
            if (!zzw.equal(Integer.valueOf(video2.getDuration()), Integer.valueOf(video.getDuration())) || !zzw.equal(video2.zzxX(), video.zzxX()) || !zzw.equal(Long.valueOf(video2.getFileSize()), Long.valueOf(video.getFileSize())) || !zzw.equal(Long.valueOf(video2.getStartTime()), Long.valueOf(video.getStartTime())) || !zzw.equal(video2.getPackageName(), video.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    static String zzb(Video video) {
        return zzw.zzy(video).zzg("Duration", Integer.valueOf(video.getDuration())).zzg("File path", video.zzxX()).zzg("File size", Long.valueOf(video.getFileSize())).zzg("Start time", Long.valueOf(video.getStartTime())).zzg("Package name", video.getPackageName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public int getDuration() {
        return this.zzakd;
    }

    public long getFileSize() {
        return this.zzaLw;
    }

    public String getPackageName() {
        return this.zzTJ;
    }

    public long getStartTime() {
        return this.zzCv;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        VideoEntityCreator.zza(this, parcel, i);
    }

    public String zzxX() {
        return this.zzaLv;
    }

    /* renamed from: zzyg */
    public Video freeze() {
        return this;
    }
}
