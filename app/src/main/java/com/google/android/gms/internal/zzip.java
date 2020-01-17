package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzhb
public final class zzip {

    private static abstract class zza extends zzim {
        private zza() {
        }

        public void onStop() {
        }
    }

    public interface zzb {
        void zze(Bundle bundle);
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            public void zzbr() {
                SharedPreferences.Editor edit = zzip.zzw(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.apply();
            }
        }.zzgd();
    }

    public static Future zza(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzbr() {
                SharedPreferences zzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzw.getBoolean("use_https", true));
                if (zzb2 != null) {
                    zzb2.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            public void zzbr() {
                SharedPreferences.Editor edit = zzip.zzw(context).edit();
                edit.putBoolean("use_https", z);
                edit.apply();
            }
        }.zzgd();
    }

    public static Future zzb(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzbr() {
                SharedPreferences zzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzw.getInt("webview_cache_version", 0));
                if (zzb2 != null) {
                    zzb2.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzb(final Context context, final boolean z) {
        return new zza() {
            public void zzbr() {
                SharedPreferences.Editor edit = zzip.zzw(context).edit();
                edit.putBoolean("content_url_opted_out", z);
                edit.apply();
            }
        }.zzgd();
    }

    public static Future zzc(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzbr() {
                SharedPreferences zzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", zzw.getBoolean("content_url_opted_out", true));
                if (zzb2 != null) {
                    zzb2.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzd(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzbr() {
                SharedPreferences zzw = zzip.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putString("content_url_hashes", zzw.getString("content_url_hashes", ""));
                if (zzb2 != null) {
                    zzb2.zze(bundle);
                }
            }
        }.zzgd();
    }

    public static Future zzd(final Context context, final String str) {
        return new zza() {
            public void zzbr() {
                SharedPreferences.Editor edit = zzip.zzw(context).edit();
                edit.putString("content_url_hashes", str);
                edit.apply();
            }
        }.zzgd();
    }

    public static SharedPreferences zzw(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
