package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzhb
public class zziw {
    private static zzl zzMy;
    public static final zza<Void> zzMz = new zza() {
        /* renamed from: zzhB */
        public Void zzgp() {
            return null;
        }

        /* renamed from: zzi */
        public Void zzh(InputStream inputStream) {
            return null;
        }
    };
    private static final Object zzqy = new Object();

    public interface zza<T> {
        T zzgp();

        T zzh(InputStream inputStream);
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzMD;
        private final zzm.zzb<T> zzaG;

        public zzb(String str, final zza<T> zza, final zzm.zzb<T> zzb) {
            super(0, str, new zzm.zza() {
                public void zze(zzr zzr) {
                    zzm.zzb.this.zzb(zza.zzgp());
                }
            });
            this.zzMD = zza;
            this.zzaG = zzb;
        }

        /* access modifiers changed from: protected */
        public zzm<InputStream> zza(zzi zzi) {
            return zzm.zza(new ByteArrayInputStream(zzi.data), zzx.zzb(zzi));
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzj */
        public void zza(InputStream inputStream) {
            this.zzaG.zzb(this.zzMD.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzjd<T> implements zzm.zzb<T> {
        private zzc() {
        }

        public void zzb(T t) {
            super.zzg(t);
        }
    }

    public zziw(Context context) {
        zzMy = zzS(context);
    }

    private static zzl zzS(Context context) {
        zzl zzl;
        synchronized (zzqy) {
            if (zzMy == null) {
                zzMy = zzac.zza(context.getApplicationContext());
            }
            zzl = zzMy;
        }
        return zzl;
    }

    public <T> zzjg<T> zza(String str, zza<T> zza2) {
        zzc zzc2 = new zzc();
        zzMy.zze(new zzb(str, zza2, zzc2));
        return zzc2;
    }

    public zzjg<String> zzb(final String str, Map<String, String> map) {
        final zzc zzc2 = new zzc();
        final Map<String, String> map2 = map;
        zzMy.zze(new zzab(str, zzc2, new zzm.zza() {
            public void zze(zzr zzr) {
                zzin.zzaK("Failed to load URL: " + str + "\n" + zzr.toString());
                zzc2.zzb(null);
            }
        }) {
            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }
        });
        return zzc2;
    }
}
