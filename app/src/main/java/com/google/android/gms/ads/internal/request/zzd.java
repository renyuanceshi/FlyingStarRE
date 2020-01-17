package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;

@zzhb
public abstract class zzd implements zzc.zza, zzit<Void> {
    private final zzji<AdRequestInfoParcel> zzHl;
    private final zzc.zza zzHm;
    private final Object zzpV = new Object();

    @zzhb
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzji<AdRequestInfoParcel> zzji, zzc.zza zza) {
            super(zzji, zza);
            this.mContext = context;
        }

        public /* synthetic */ Object zzgd() {
            return zzd.super.zzgd();
        }

        public void zzgr() {
        }

        public zzj zzgs() {
            return zzhd.zza(this.mContext, new zzbm(zzbt.zzvB.get()), zzhc.zzgA());
        }
    }

    @zzhb
    public static class zzb extends zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private Context mContext;
        private zzji<AdRequestInfoParcel> zzHl;
        private final zzc.zza zzHm;
        protected zze zzHp;
        private boolean zzHq;
        private VersionInfoParcel zzpT;
        private final Object zzpV = new Object();

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzji, zzc.zza zza) {
            super(zzji, zza);
            Looper mainLooper;
            this.mContext = context;
            this.zzpT = versionInfoParcel;
            this.zzHl = zzji;
            this.zzHm = zza;
            if (zzbt.zzwa.get().booleanValue()) {
                this.zzHq = true;
                mainLooper = zzr.zzbO().zzhC();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzHp = new zze(context, mainLooper, this, this, this.zzpT.zzNa);
            connect();
        }

        /* access modifiers changed from: protected */
        public void connect() {
            this.zzHp.zzqG();
        }

        public void onConnected(Bundle bundle) {
            zzgd();
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzin.zzaI("Cannot connect to remote service, fallback to local instance.");
            zzgt().zzgd();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzr.zzbC().zzb(this.mContext, this.zzpT.afmaVersion, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int i) {
            zzin.zzaI("Disconnected from remote ad request service.");
        }

        public /* synthetic */ Object zzgd() {
            return zzd.super.zzgd();
        }

        public void zzgr() {
            synchronized (this.zzpV) {
                if (this.zzHp.isConnected() || this.zzHp.isConnecting()) {
                    this.zzHp.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzHq) {
                    zzr.zzbO().zzhD();
                    this.zzHq = false;
                }
            }
        }

        public zzj zzgs() {
            zzj zzj;
            synchronized (this.zzpV) {
                try {
                    zzj = this.zzHp.zzgw();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzj = null;
                }
            }
            return zzj;
        }

        /* access modifiers changed from: package-private */
        public zzit zzgt() {
            return new zza(this.mContext, this.zzHl, this.zzHm);
        }
    }

    public zzd(zzji<AdRequestInfoParcel> zzji, zzc.zza zza2) {
        this.zzHl = zzji;
        this.zzHm = zza2;
    }

    public void cancel() {
        zzgr();
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzj zzj, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzj.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            zzin.zzd("Could not fetch ad response from ad request service.", e);
            zzr.zzbF().zzb((Throwable) e, true);
        } catch (NullPointerException e2) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzr.zzbF().zzb((Throwable) e2, true);
        } catch (SecurityException e3) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzr.zzbF().zzb((Throwable) e3, true);
        } catch (Throwable th) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzr.zzbF().zzb(th, true);
        }
        this.zzHm.zzb(new AdResponseParcel(0));
        return false;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzpV) {
            this.zzHm.zzb(adResponseParcel);
            zzgr();
        }
    }

    /* renamed from: zzga */
    public Void zzgd() {
        final zzj zzgs = zzgs();
        if (zzgs == null) {
            this.zzHm.zzb(new AdResponseParcel(0));
            zzgr();
            return null;
        }
        this.zzHl.zza(new zzji.zzc<AdRequestInfoParcel>() {
            /* renamed from: zzc */
            public void zze(AdRequestInfoParcel adRequestInfoParcel) {
                if (!zzd.this.zza(zzgs, adRequestInfoParcel)) {
                    zzd.this.zzgr();
                }
            }
        }, new zzji.zza() {
            public void run() {
                zzd.this.zzgr();
            }
        });
        return null;
    }

    public abstract void zzgr();

    public abstract zzj zzgs();
}
