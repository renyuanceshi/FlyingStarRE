package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.afma.nano.NanoAfmaSignals;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzal;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam extends zzal {
    /* access modifiers changed from: private */
    public static AdvertisingIdClient zzok = null;
    /* access modifiers changed from: private */
    public static CountDownLatch zzol = new CountDownLatch(1);
    private boolean zzom;

    class zza {
        private String zzon;
        private boolean zzoo;

        public zza(String str, boolean z) {
            this.zzon = str;
            this.zzoo = z;
        }

        public String getId() {
            return this.zzon;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzoo;
        }
    }

    private static final class zzb implements Runnable {
        private Context zzoq;

        public zzb(Context context) {
            this.zzoq = context.getApplicationContext();
            if (this.zzoq == null) {
                this.zzoq = context;
            }
        }

        public void run() {
            synchronized (zzam.class) {
                try {
                    if (zzam.zzok == null) {
                        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzoq);
                        advertisingIdClient.start();
                        AdvertisingIdClient unused = zzam.zzok = advertisingIdClient;
                    }
                    zzam.zzol.countDown();
                } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
                    AdvertisingIdClient unused2 = zzam.zzok = null;
                    zzam.zzol.countDown();
                } catch (Throwable th) {
                    Class<zzam> cls = zzam.class;
                    throw th;
                }
            }
        }
    }

    protected zzam(Context context, zzap zzap, boolean z) {
        super(context, zzap);
        this.zzom = z;
    }

    public static zzam zza(String str, Context context, boolean z) {
        zzah zzah = new zzah();
        zza(str, context, zzah);
        if (z) {
            synchronized (zzam.class) {
                try {
                    if (zzok == null) {
                        new Thread(new zzb(context)).start();
                    }
                } catch (Throwable th) {
                    while (true) {
                        Class<zzam> cls = zzam.class;
                        throw th;
                    }
                }
            }
        }
        return new zzam(context, zzah, z);
    }

    private void zza(Context context, NanoAfmaSignals.AFMASignals aFMASignals) {
        if (this.zzom) {
            try {
                if (zzS()) {
                    zza zzY = zzY();
                    String id = zzY.getId();
                    if (id != null) {
                        aFMASignals.didOptOut = Boolean.valueOf(zzY.isLimitAdTrackingEnabled());
                        aFMASignals.didSignalType = 5;
                        aFMASignals.didSignal = id;
                        zza(28, zzob);
                        return;
                    }
                    return;
                }
                aFMASignals.didSignal = zzf(context);
                zza(24, zzob);
            } catch (IOException e) {
            } catch (zzal.zza e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zza zzY() throws IOException {
        try {
            if (!zzol.await(2, TimeUnit.SECONDS)) {
                return new zza((String) null, false);
            }
            synchronized (zzam.class) {
                try {
                    if (zzok == null) {
                        zza zza2 = new zza((String) null, false);
                        return zza2;
                    }
                    AdvertisingIdClient.Info info = zzok.getInfo();
                    return new zza(zzk(info.getId()), info.isLimitAdTrackingEnabled());
                } catch (Throwable th) {
                    Class<zzam> cls = zzam.class;
                    throw th;
                }
            }
        } catch (InterruptedException e) {
            return new zza((String) null, false);
        }
    }

    /* access modifiers changed from: protected */
    public NanoAfmaSignals.AFMASignals zzc(Context context) {
        NanoAfmaSignals.AFMASignals zzc = super.zzc(context);
        zza(context, zzc);
        return zzc;
    }
}
