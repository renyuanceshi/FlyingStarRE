package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzmc extends ImageView {
    private Uri zzakr;
    private int zzaks;
    private int zzakt;
    private zza zzaku;
    private int zzakv;
    private float zzakw;

    public interface zza {
        Path zzl(int i, int i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.zzaku != null) {
            canvas.clipPath(this.zzaku.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzakt != 0) {
            canvas.drawColor(this.zzakt);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int i3;
        super.onMeasure(i, i2);
        switch (this.zzakv) {
            case 1:
                i3 = getMeasuredHeight();
                measuredWidth = (int) (((float) i3) * this.zzakw);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i3 = (int) (((float) measuredWidth) / this.zzakw);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i3);
    }

    public void zzbO(int i) {
        this.zzaks = i;
    }

    public void zzm(Uri uri) {
        this.zzakr = uri;
    }

    public int zzqp() {
        return this.zzaks;
    }
}