package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzgd;
import java.util.LinkedList;
import java.util.List;

@zzhb
class zzdw {
    /* access modifiers changed from: private */
    public final List<zza> zzpH = new LinkedList();

    interface zza {
        void zzb(zzdx zzdx) throws RemoteException;
    }

    zzdw() {
    }

    /* access modifiers changed from: package-private */
    public void zza(final zzdx zzdx) {
        Handler handler = zzir.zzMc;
        for (final zza next : this.zzpH) {
            handler.post(new Runnable() {
                public void run() {
                    try {
                        next.zzb(zzdx);
                    } catch (RemoteException e) {
                        zzin.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void zzc(zzk zzk) {
        zzk.zza((zzq) new zzq.zza() {
            public void onAdClosed() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzpK != null) {
                            zzdx.zzpK.onAdClosed();
                        }
                        zzr.zzbN().zzee();
                    }
                });
            }

            public void onAdFailedToLoad(final int i) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzpK != null) {
                            zzdx.zzpK.onAdFailedToLoad(i);
                        }
                    }
                });
                zzin.v("Pooled interstitial failed to load.");
            }

            public void onAdLeftApplication() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzpK != null) {
                            zzdx.zzpK.onAdLeftApplication();
                        }
                    }
                });
            }

            public void onAdLoaded() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzpK != null) {
                            zzdx.zzpK.onAdLoaded();
                        }
                    }
                });
                zzin.v("Pooled interstitial loaded.");
            }

            public void onAdOpened() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzpK != null) {
                            zzdx.zzpK.onAdOpened();
                        }
                    }
                });
            }
        });
        zzk.zza((zzw) new zzw.zza() {
            public void onAppEvent(final String str, final String str2) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAq != null) {
                            zzdx.zzAq.onAppEvent(str, str2);
                        }
                    }
                });
            }
        });
        zzk.zza((zzgd) new zzgd.zza() {
            public void zza(final zzgc zzgc) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAr != null) {
                            zzdx.zzAr.zza(zzgc);
                        }
                    }
                });
            }
        });
        zzk.zza((zzcf) new zzcf.zza() {
            public void zza(final zzce zzce) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAs != null) {
                            zzdx.zzAs.zza(zzce);
                        }
                    }
                });
            }
        });
        zzk.zza((zzp) new zzp.zza() {
            public void onAdClicked() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAt != null) {
                            zzdx.zzAt.onAdClicked();
                        }
                    }
                });
            }
        });
        zzk.zza((zzd) new zzd.zza() {
            public void onRewardedVideoAdClosed() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoAdClosed();
                        }
                    }
                });
            }

            public void onRewardedVideoAdFailedToLoad(final int i) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoAdFailedToLoad(i);
                        }
                    }
                });
            }

            public void onRewardedVideoAdLeftApplication() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoAdLeftApplication();
                        }
                    }
                });
            }

            public void onRewardedVideoAdLoaded() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }

            public void onRewardedVideoAdOpened() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoAdOpened();
                        }
                    }
                });
            }

            public void onRewardedVideoStarted() throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.onRewardedVideoStarted();
                        }
                    }
                });
            }

            public void zza(final com.google.android.gms.ads.internal.reward.client.zza zza) throws RemoteException {
                zzdw.this.zzpH.add(new zza() {
                    public void zzb(zzdx zzdx) throws RemoteException {
                        if (zzdx.zzAu != null) {
                            zzdx.zzAu.zza(zza);
                        }
                    }
                });
            }
        });
    }
}
