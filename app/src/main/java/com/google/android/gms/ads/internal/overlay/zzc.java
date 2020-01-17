package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@zzhb
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzDN = new HashMap();
    private final zzt zzDO;
    private int zzDP = 0;
    private int zzDQ = 0;
    private MediaPlayer zzDR;
    private Uri zzDS;
    private int zzDT;
    private int zzDU;
    private int zzDV;
    private int zzDW;
    private int zzDX;
    private float zzDY = 1.0f;
    private boolean zzDZ;
    private boolean zzEa;
    private int zzEb;
    /* access modifiers changed from: private */
    public zzh zzEc;

    static {
        zzDN.put(-1004, "MEDIA_ERROR_IO");
        zzDN.put(-1007, "MEDIA_ERROR_MALFORMED");
        zzDN.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        zzDN.put(-110, "MEDIA_ERROR_TIMED_OUT");
        zzDN.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzDN.put(1, "MEDIA_ERROR_UNKNOWN");
        zzDN.put(1, "MEDIA_INFO_UNKNOWN");
        zzDN.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzDN.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        zzDN.put(701, "MEDIA_INFO_BUFFERING_START");
        zzDN.put(702, "MEDIA_INFO_BUFFERING_END");
        zzDN.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzDN.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzDN.put(802, "MEDIA_INFO_METADATA_UPDATE");
        zzDN.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzDN.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzc(Context context, zzt zzt) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzDO = zzt;
        this.zzDO.zza((zzi) this);
    }

    private void zzb(float f) {
        if (this.zzDR != null) {
            try {
                this.zzDR.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        } else {
            zzin.zzaK("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private void zzfa() {
        zzin.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzDS != null && surfaceTexture != null) {
            zzv(false);
            try {
                this.zzDR = new MediaPlayer();
                this.zzDR.setOnBufferingUpdateListener(this);
                this.zzDR.setOnCompletionListener(this);
                this.zzDR.setOnErrorListener(this);
                this.zzDR.setOnInfoListener(this);
                this.zzDR.setOnPreparedListener(this);
                this.zzDR.setOnVideoSizeChangedListener(this);
                this.zzDV = 0;
                this.zzDR.setDataSource(getContext(), this.zzDS);
                this.zzDR.setSurface(new Surface(surfaceTexture));
                this.zzDR.setAudioStreamType(3);
                this.zzDR.setScreenOnWhilePlaying(true);
                this.zzDR.prepareAsync();
                zzw(1);
            } catch (IOException | IllegalArgumentException e) {
                zzin.zzd("Failed to initialize MediaPlayer at " + this.zzDS, e);
                onError(this.zzDR, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzfb() {
        /*
            r8 = this;
            boolean r0 = r8.zzfe()
            if (r0 == 0) goto L_0x0054
            android.media.MediaPlayer r0 = r8.zzDR
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0054
            int r0 = r8.zzDQ
            r1 = 3
            if (r0 == r1) goto L_0x0054
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.zzin.v(r0)
            r0 = 0
            r8.zzb(r0)
            android.media.MediaPlayer r0 = r8.zzDR
            r0.start()
            android.media.MediaPlayer r0 = r8.zzDR
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.internal.zzmq r1 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r2 = r1.currentTimeMillis()
        L_0x002f:
            boolean r1 = r8.zzfe()
            if (r1 == 0) goto L_0x004c
            android.media.MediaPlayer r1 = r8.zzDR
            int r1 = r1.getCurrentPosition()
            if (r1 != r0) goto L_0x004c
            com.google.android.gms.internal.zzmq r1 = com.google.android.gms.ads.internal.zzr.zzbG()
            long r4 = r1.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x002f
        L_0x004c:
            android.media.MediaPlayer r0 = r8.zzDR
            r0.pause()
            r8.zzfj()
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zzfb():void");
    }

    private void zzfc() {
        AudioManager zzfk = zzfk();
        if (zzfk != null && !this.zzEa) {
            if (zzfk.requestAudioFocus(this, 3, 2) == 1) {
                zzfh();
            } else {
                zzin.zzaK("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void zzfd() {
        zzin.v("AdMediaPlayerView abandon audio focus");
        AudioManager zzfk = zzfk();
        if (zzfk != null && this.zzEa) {
            if (zzfk.abandonAudioFocus(this) == 1) {
                this.zzEa = false;
            } else {
                zzin.zzaK("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean zzfe() {
        return (this.zzDR == null || this.zzDP == -1 || this.zzDP == 0 || this.zzDP == 1) ? false : true;
    }

    private void zzfh() {
        zzin.v("AdMediaPlayerView audio focus gained");
        this.zzEa = true;
        zzfj();
    }

    private void zzfi() {
        zzin.v("AdMediaPlayerView audio focus lost");
        this.zzEa = false;
        zzfj();
    }

    private void zzfj() {
        if (this.zzDZ || !this.zzEa) {
            zzb(0.0f);
        } else {
            zzb(this.zzDY);
        }
    }

    private AudioManager zzfk() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        zzin.v("AdMediaPlayerView release");
        if (this.zzDR != null) {
            this.zzDR.reset();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            if (z) {
                this.zzDQ = 0;
                zzx(0);
            }
            zzfd();
        }
    }

    private void zzw(int i) {
        if (i == 3) {
            this.zzDO.zzfO();
        } else if (this.zzDP == 3 && i != 3) {
            this.zzDO.zzfP();
        }
        this.zzDP = i;
    }

    private void zzx(int i) {
        this.zzDQ = i;
    }

    public int getCurrentPosition() {
        if (zzfe()) {
            return this.zzDR.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (zzfe()) {
            return this.zzDR.getDuration();
        }
        return -1;
    }

    public int getVideoHeight() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.zzDR != null) {
            return this.zzDR.getVideoWidth();
        }
        return 0;
    }

    public void onAudioFocusChange(int i) {
        if (i > 0) {
            zzfh();
        } else if (i < 0) {
            zzfi();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzDV = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        zzin.v("AdMediaPlayerView completion");
        zzw(5);
        zzx(5);
        zzir.zzMc.post(new Runnable() {
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfB();
                }
            }
        });
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = zzDN.get(Integer.valueOf(i));
        final String str2 = zzDN.get(Integer.valueOf(i2));
        zzin.zzaK("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzw(-1);
        zzx(-1);
        zzir.zzMc.post(new Runnable() {
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzg(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        zzin.v("AdMediaPlayerView MediaPlayer info: " + zzDN.get(Integer.valueOf(i)) + ":" + zzDN.get(Integer.valueOf(i2)));
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r1 > r0) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            r3 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = r7.zzDT
            int r0 = getDefaultSize(r0, r8)
            int r1 = r7.zzDU
            int r1 = getDefaultSize(r1, r9)
            int r2 = r7.zzDT
            if (r2 <= 0) goto L_0x00a3
            int r2 = r7.zzDU
            if (r2 <= 0) goto L_0x00a3
            int r4 = android.view.View.MeasureSpec.getMode(r8)
            int r0 = android.view.View.MeasureSpec.getSize(r8)
            int r5 = android.view.View.MeasureSpec.getMode(r9)
            int r2 = android.view.View.MeasureSpec.getSize(r9)
            if (r4 != r3) goto L_0x006b
            if (r5 != r3) goto L_0x006b
            int r1 = r7.zzDT
            int r1 = r1 * r2
            int r3 = r7.zzDU
            int r3 = r3 * r0
            if (r1 >= r3) goto L_0x005b
            int r0 = r7.zzDT
            int r0 = r0 * r2
            int r1 = r7.zzDU
            int r0 = r0 / r1
        L_0x003a:
            r7.setMeasuredDimension(r0, r2)
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r1 != r3) goto L_0x005a
            int r1 = r7.zzDW
            if (r1 <= 0) goto L_0x004b
            int r1 = r7.zzDW
            if (r1 != r0) goto L_0x0053
        L_0x004b:
            int r1 = r7.zzDX
            if (r1 <= 0) goto L_0x0056
            int r1 = r7.zzDX
            if (r1 == r2) goto L_0x0056
        L_0x0053:
            r7.zzfb()
        L_0x0056:
            r7.zzDW = r0
            r7.zzDX = r2
        L_0x005a:
            return
        L_0x005b:
            int r1 = r7.zzDT
            int r1 = r1 * r2
            int r3 = r7.zzDU
            int r3 = r3 * r0
            if (r1 <= r3) goto L_0x003a
            int r1 = r7.zzDU
            int r1 = r1 * r0
            int r2 = r7.zzDT
            int r1 = r1 / r2
            r2 = r1
            goto L_0x003a
        L_0x006b:
            if (r4 != r3) goto L_0x0079
            int r1 = r7.zzDU
            int r1 = r1 * r0
            int r3 = r7.zzDT
            int r1 = r1 / r3
            if (r5 != r6) goto L_0x0077
            if (r1 > r2) goto L_0x003a
        L_0x0077:
            r2 = r1
            goto L_0x003a
        L_0x0079:
            if (r5 != r3) goto L_0x0087
            int r1 = r7.zzDT
            int r1 = r1 * r2
            int r3 = r7.zzDU
            int r1 = r1 / r3
            if (r4 != r6) goto L_0x0085
            if (r1 > r0) goto L_0x003a
        L_0x0085:
            r0 = r1
            goto L_0x003a
        L_0x0087:
            int r1 = r7.zzDT
            int r3 = r7.zzDU
            if (r5 != r6) goto L_0x00a1
            if (r3 <= r2) goto L_0x00a1
            int r1 = r7.zzDT
            int r1 = r1 * r2
            int r3 = r7.zzDU
            int r1 = r1 / r3
        L_0x0095:
            if (r4 != r6) goto L_0x0085
            if (r1 <= r0) goto L_0x0085
            int r1 = r7.zzDU
            int r1 = r1 * r0
            int r2 = r7.zzDT
            int r1 = r1 / r2
            r2 = r1
            goto L_0x003a
        L_0x00a1:
            r2 = r3
            goto L_0x0095
        L_0x00a3:
            r2 = r1
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.onMeasure(int, int):void");
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zzin.v("AdMediaPlayerView prepared");
        zzw(2);
        this.zzDO.zzfz();
        zzir.zzMc.post(new Runnable() {
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfz();
                }
            }
        });
        this.zzDT = mediaPlayer.getVideoWidth();
        this.zzDU = mediaPlayer.getVideoHeight();
        if (this.zzEb != 0) {
            seekTo(this.zzEb);
        }
        zzfb();
        zzin.zzaJ("AdMediaPlayerView stream dimensions: " + this.zzDT + " x " + this.zzDU);
        if (this.zzDQ == 3) {
            play();
        }
        zzfc();
        zzfj();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzin.v("AdMediaPlayerView surface created");
        zzfa();
        zzir.zzMc.post(new Runnable() {
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.zzfy();
                }
            }
        });
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzin.v("AdMediaPlayerView surface destroyed");
        if (this.zzDR != null && this.zzEb == 0) {
            this.zzEb = this.zzDR.getCurrentPosition();
        }
        zzir.zzMc.post(new Runnable() {
            public void run() {
                if (zzc.this.zzEc != null) {
                    zzc.this.zzEc.onPaused();
                    zzc.this.zzEc.zzfC();
                }
            }
        });
        zzv(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = true;
        zzin.v("AdMediaPlayerView surface changed");
        boolean z2 = this.zzDQ == 3;
        if (!(this.zzDT == i && this.zzDU == i2)) {
            z = false;
        }
        if (this.zzDR != null && z2 && z) {
            if (this.zzEb != 0) {
                seekTo(this.zzEb);
            }
            play();
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzDO.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzin.v("AdMediaPlayerView size changed: " + i + " x " + i2);
        this.zzDT = mediaPlayer.getVideoWidth();
        this.zzDU = mediaPlayer.getVideoHeight();
        if (this.zzDT != 0 && this.zzDU != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zzin.v("AdMediaPlayerView pause");
        if (zzfe() && this.zzDR.isPlaying()) {
            this.zzDR.pause();
            zzw(4);
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    if (zzc.this.zzEc != null) {
                        zzc.this.zzEc.onPaused();
                    }
                }
            });
        }
        zzx(4);
    }

    public void play() {
        zzin.v("AdMediaPlayerView play");
        if (zzfe()) {
            this.zzDR.start();
            zzw(3);
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    if (zzc.this.zzEc != null) {
                        zzc.this.zzEc.zzfA();
                    }
                }
            });
        }
        zzx(3);
    }

    public void seekTo(int i) {
        zzin.v("AdMediaPlayerView seek " + i);
        if (zzfe()) {
            this.zzDR.seekTo(i);
            this.zzEb = 0;
            return;
        }
        this.zzEb = i;
    }

    public void setMimeType(String str) {
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.zzDS = uri;
        this.zzEb = 0;
        zzfa();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzin.v("AdMediaPlayerView stop");
        if (this.zzDR != null) {
            this.zzDR.stop();
            this.zzDR.release();
            this.zzDR = null;
            zzw(0);
            zzx(0);
            zzfd();
        }
        this.zzDO.onStop();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public void zza(float f) {
        this.zzDY = f;
        zzfj();
    }

    public void zza(zzh zzh) {
        this.zzEc = zzh;
    }

    public String zzeZ() {
        return "MediaPlayer";
    }

    public void zzff() {
        this.zzDZ = true;
        zzfj();
    }

    public void zzfg() {
        this.zzDZ = false;
        zzfj();
    }
}
