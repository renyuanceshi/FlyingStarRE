package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzbnG;
    private final zzg zzbnH;
    private boolean zzbnI;
    private final Object zzpV;

    public static class Builder {
        private final Context mContext;
        private int zzaoy = 0;
        private int zzbnJ = 0;
        private boolean zzbnK = false;
        private int zzbnL = 0;
        private boolean zzbnM = true;
        private float zzbnN = -1.0f;

        public Builder(Context context) {
            this.mContext = context;
        }

        public FaceDetector build() {
            FaceSettingsParcel faceSettingsParcel = new FaceSettingsParcel();
            faceSettingsParcel.mode = this.zzaoy;
            faceSettingsParcel.zzbnV = this.zzbnJ;
            faceSettingsParcel.zzbnW = this.zzbnL;
            faceSettingsParcel.zzbnX = this.zzbnK;
            faceSettingsParcel.zzbnY = this.zzbnM;
            faceSettingsParcel.zzbnZ = this.zzbnN;
            return new FaceDetector(new zzg(this.mContext, faceSettingsParcel));
        }

        public Builder setClassificationType(int i) {
            if (i == 0 || i == 1) {
                this.zzbnL = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid classification type: " + i);
        }

        public Builder setLandmarkType(int i) {
            if (i == 0 || i == 1) {
                this.zzbnJ = i;
                return this;
            }
            throw new IllegalArgumentException("Invalid landmark type: " + i);
        }

        public Builder setMinFaceSize(float f) {
            if (f < 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("Invalid proportional face size: " + f);
            }
            this.zzbnN = f;
            return this;
        }

        public Builder setMode(int i) {
            switch (i) {
                case 0:
                case 1:
                    this.zzaoy = i;
                    return this;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + i);
            }
        }

        public Builder setProminentFaceOnly(boolean z) {
            this.zzbnK = z;
            return this;
        }

        public Builder setTrackingEnabled(boolean z) {
            this.zzbnM = z;
            return this;
        }
    }

    private FaceDetector() {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg zzg) {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        this.zzbnH = zzg;
    }

    public SparseArray<Face> detect(Frame frame) {
        Face[] zzb;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.zzpV) {
            if (!this.zzbnI) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            zzb = this.zzbnH.zzb(grayscaleImageData, FrameMetadataParcel.zzc(frame));
        }
        HashSet hashSet = new HashSet();
        SparseArray<Face> sparseArray = new SparseArray<>(zzb.length);
        int i = 0;
        for (Face face : zzb) {
            int id = face.getId();
            int max = Math.max(i, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                max++;
                id = max;
            }
            i = max;
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzbnG.zzkr(id), face);
        }
        return sparseArray;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this.zzpV) {
                if (this.zzbnI) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isOperational() {
        return this.zzbnH.isOperational();
    }

    public void release() {
        synchronized (this.zzpV) {
            if (this.zzbnI) {
                this.zzbnH.zzIh();
                this.zzbnI = false;
            }
        }
    }

    public boolean setFocus(int i) {
        boolean zzkJ;
        int zzks = this.zzbnG.zzks(i);
        synchronized (this.zzpV) {
            if (!this.zzbnI) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            zzkJ = this.zzbnH.zzkJ(zzks);
        }
        return zzkJ;
    }
}
