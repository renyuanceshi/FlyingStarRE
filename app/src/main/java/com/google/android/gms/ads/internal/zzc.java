package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdj;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

@zzhb
public abstract class zzc extends zzb implements zzg, zzft {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzex zzex, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzex, versionInfoParcel, zzd);
    }

    /* access modifiers changed from: protected */
    public zzjp zza(zzif.zza zza, zze zze) {
        zzjp zzjp;
        View nextView = this.zzpj.zzrm.getNextView();
        if (nextView instanceof zzjp) {
            zzin.zzaI("Reusing webview...");
            zzjp zzjp2 = (zzjp) nextView;
            zzjp2.zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            zzjp = zzjp2;
        } else {
            if (nextView != null) {
                this.zzpj.zzrm.removeView(nextView);
            }
            zzjp zza2 = zzr.zzbD().zza(this.zzpj.context, this.zzpj.zzrp, false, false, this.zzpj.zzrk, this.zzpj.zzrl, this.zzpe, this.zzpm);
            if (this.zzpj.zzrp.zzuj == null) {
                zzb(zza2.getView());
            }
            zzjp = zza2;
        }
        zzjp.zzhU().zzb(this, this, this, this, false, this, (zzdj) null, zze, this);
        zza((zzeh) zzjp);
        zzjp.zzaM(zza.zzLd.zzHI);
        return zzjp;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzaS();
    }

    public void zza(zzcf zzcf) {
        zzx.zzcD("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrE = zzcf;
    }

    /* access modifiers changed from: protected */
    public void zza(zzeh zzeh) {
        zzeh.zza("/trackActiveViewUnit", (zzdf) new zzdf() {
            public void zza(zzjp zzjp, Map<String, String> map) {
                if (zzc.this.zzpj.zzrq != null) {
                    zzc.this.zzpl.zza(zzc.this.zzpj.zzrp, zzc.this.zzpj.zzrq, zzjp.getView(), (zzeh) zzjp);
                } else {
                    zzin.zzaK("Request to enable ActiveView before adState is available.");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void zza(final zzif.zza zza, final zzcb zzcb) {
        if (zza.errorCode != -2) {
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    zzc.this.zzb(new zzif(zza, (zzjp) null, (zzen) null, (zzey) null, (String) null, (zzeq) null, (zzh.zza) null));
                }
            });
            return;
        }
        if (zza.zzrp != null) {
            this.zzpj.zzrp = zza.zzrp;
        }
        if (!zza.zzLe.zzHT || zza.zzLe.zzum) {
            zzir.zzMc.post(new Runnable() {
                public void run() {
                    if (zza.zzLe.zzIc && zzc.this.zzpj.zzrE != null) {
                        String str = null;
                        if (zza.zzLe.zzEF != null) {
                            str = zzr.zzbC().zzaC(zza.zzLe.zzEF);
                        }
                        zzcc zzcc = new zzcc(zzc.this, str, zza.zzLe.body);
                        zzc.this.zzpj.zzrL = 1;
                        try {
                            zzc.this.zzph = false;
                            zzc.this.zzpj.zzrE.zza(zzcc);
                            return;
                        } catch (RemoteException e) {
                            zzin.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                            zzc.this.zzph = true;
                        }
                    }
                    final zze zze = new zze();
                    zzjp zza = zzc.this.zza(zza, zze);
                    zze.zza(new zze.zzb(zza, zza));
                    zza.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            zze.recordClick();
                            return false;
                        }
                    });
                    zza.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            zze.recordClick();
                        }
                    });
                    zzc.this.zzpj.zzrL = 0;
                    zzc.this.zzpj.zzro = zzr.zzbB().zza(zzc.this.zzpj.context, zzc.this, zza, zzc.this.zzpj.zzrk, zza, zzc.this.zzpn, zzc.this, zzcb);
                }
            });
            return;
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this, zza, this.zzpj.zzrk, (zzjp) null, this.zzpn, this, zzcb);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzif zzif, zzif zzif2) {
        if (this.zzpj.zzbW() && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.zzcc().zzaF(zzif2.zzHY);
        }
        return super.zza(zzif, zzif2);
    }

    public void zzbd() {
        onAdClicked();
    }

    public void zzbe() {
        recordImpression();
        zzaP();
    }

    public void zzbf() {
        zzaQ();
    }

    public void zzc(View view) {
        this.zzpj.zzrK = view;
        zzb(new zzif(this.zzpj.zzrr, (zzjp) null, (zzen) null, (zzey) null, (String) null, (zzeq) null, (zzh.zza) null));
    }
}
