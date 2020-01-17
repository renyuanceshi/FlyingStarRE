package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zzma extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzRD;
    private boolean zzajT;
    private int zzaka;
    private int zzakb;
    private int zzakc;
    private int zzakd;
    private int zzake;
    private boolean zzakf;
    private zzb zzakg;
    private Drawable zzakh;
    private Drawable zzaki;
    private boolean zzakj;
    private boolean zzakk;
    private boolean zzakl;
    private int zzakm;

    private static final class zza extends Drawable {
        /* access modifiers changed from: private */
        public static final zza zzakn = new zza();
        private static final C0110zza zzako = new C0110zza();

        /* renamed from: com.google.android.gms.internal.zzma$zza$zza  reason: collision with other inner class name */
        private static final class C0110zza extends Drawable.ConstantState {
            private C0110zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzakn;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return zzako;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends Drawable.ConstantState {
        int zzakp;
        int zzakq;

        zzb(zzb zzb) {
            if (zzb != null) {
                this.zzakp = zzb.zzakp;
                this.zzakq = zzb.zzakq;
            }
        }

        public int getChangingConfigurations() {
            return this.zzakp;
        }

        public Drawable newDrawable() {
            return new zzma(this);
        }
    }

    public zzma(Drawable drawable, Drawable drawable2) {
        this((zzb) null);
        drawable = drawable == null ? zza.zzakn : drawable;
        this.zzakh = drawable;
        drawable.setCallback(this);
        this.zzakg.zzakq |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.zzakn : drawable2;
        this.zzaki = drawable2;
        drawable2.setCallback(this);
        this.zzakg.zzakq |= drawable2.getChangingConfigurations();
    }

    zzma(zzb zzb2) {
        this.zzaka = 0;
        this.zzakc = 255;
        this.zzake = 0;
        this.zzajT = true;
        this.zzakg = new zzb(zzb2);
    }

    public boolean canConstantState() {
        if (!this.zzakj) {
            this.zzakk = (this.zzakh.getConstantState() == null || this.zzaki.getConstantState() == null) ? false : true;
            this.zzakj = true;
        }
        return this.zzakk;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.zzaka) {
            case 1:
                this.zzRD = SystemClock.uptimeMillis();
                this.zzaka = 2;
                z = false;
                break;
            case 2:
                if (this.zzRD >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzRD)) / ((float) this.zzakd);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.zzaka = 0;
                    }
                    this.zzake = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.zzakb - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        int i = this.zzake;
        boolean z2 = this.zzajT;
        Drawable drawable = this.zzakh;
        Drawable drawable2 = this.zzaki;
        if (z) {
            if (!z2 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzakc) {
                drawable2.setAlpha(this.zzakc);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.zzakc - i);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(this.zzakc);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzakc);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzakg.zzakp | this.zzakg.zzakq;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzakg.zzakp = getChangingConfigurations();
        return this.zzakg;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzakh.getIntrinsicHeight(), this.zzaki.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzakh.getIntrinsicWidth(), this.zzaki.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzakl) {
            this.zzakm = Drawable.resolveOpacity(this.zzakh.getOpacity(), this.zzaki.getOpacity());
            this.zzakl = true;
        }
        return this.zzakm;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.zzakf && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzakh.mutate();
            this.zzaki.mutate();
            this.zzakf = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.zzakh.setBounds(rect);
        this.zzaki.setBounds(rect);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.zzake == this.zzakc) {
            this.zzake = i;
        }
        this.zzakc = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.zzakh.setColorFilter(colorFilter);
        this.zzaki.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.mFrom = 0;
        this.zzakb = this.zzakc;
        this.zzake = 0;
        this.zzakd = i;
        this.zzaka = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback;
        if (zzne.zzsd() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Drawable zzqn() {
        return this.zzaki;
    }
}
