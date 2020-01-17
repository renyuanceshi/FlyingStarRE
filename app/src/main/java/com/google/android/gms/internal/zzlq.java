package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlu;

public class zzlq implements CastRemoteDisplayApi {
    /* access modifiers changed from: private */
    public static final zzl zzaaf = new zzl("CastRemoteDisplayApiImpl");
    /* access modifiers changed from: private */
    public Api.zzc<zzlr> zzaeE;
    /* access modifiers changed from: private */
    public VirtualDisplay zzaeF;
    /* access modifiers changed from: private */
    public final zzlu zzaeG = new zzlu.zza() {
        public void zzbp(int i) {
            zzlq.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
            zzlq.this.zzoB();
        }
    };

    private abstract class zza extends zzls.zza {
        private zza() {
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int i) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzoD() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private abstract class zzb extends zza.C0030zza<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzlr> {

        @TargetApi(19)
        protected final class zza extends zza {
            private final zzlr zzaeJ;

            public zza(zzlr zzlr) {
                super();
                this.zzaeJ = zzlr;
            }

            private int zzj(int i, int i2) {
                if (i < i2) {
                    i2 = i;
                }
                return (i2 * 320) / 1080;
            }

            public void onError(int i) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(i));
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagE));
            }

            public void zza(int i, int i2, Surface surface) {
                zzlq.zzaaf.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzaeJ.getContext().getSystemService("display");
                if (displayManager == null) {
                    zzlq.zzaaf.zzc("Unable to get the display manager", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                    return;
                }
                zzlq.this.zzoB();
                VirtualDisplay unused = zzlq.this.zzaeF = displayManager.createVirtualDisplay("private_display", i, i2, zzj(i, i2), surface, 2);
                if (zzlq.this.zzaeF == null) {
                    zzlq.zzaaf.zzc("Unable to create virtual display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                } else if (zzlq.this.zzaeF.getDisplay() == null) {
                    zzlq.zzaaf.zzc("Virtual display does not have a display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                } else {
                    try {
                        this.zzaeJ.zza(this, zzlq.this.zzaeF.getDisplay().getDisplayId());
                    } catch (RemoteException | IllegalStateException e) {
                        zzlq.zzaaf.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        zzb.this.zza(new zzc(Status.zzagE));
                    }
                }
            }

            public void zzoD() {
                zzlq.zzaaf.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = zzlq.this.zzaeF.getDisplay();
                if (display != null) {
                    zzb.this.zza(new zzc(display));
                    return;
                }
                zzlq.zzaaf.zzc("Virtual display no longer has a display", new Object[0]);
                zzb.this.zza(new zzc(Status.zzagE));
            }
        }

        /* renamed from: com.google.android.gms.internal.zzlq$zzb$zzb  reason: collision with other inner class name */
        protected final class C0104zzb extends zza {
            protected C0104zzb() {
                super();
            }

            public void onDisconnected() throws RemoteException {
                zzlq.zzaaf.zzb("onDisconnected", new Object[0]);
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagC));
            }

            public void onError(int i) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(i));
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagE));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzlq.this.zzaeE, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzt */
        public CastRemoteDisplay.CastRemoteDisplaySessionResult zzc(Status status) {
            return new zzc(status);
        }
    }

    private static final class zzc implements CastRemoteDisplay.CastRemoteDisplaySessionResult {
        private final Status zzUX;
        private final Display zzaar;

        public zzc(Display display) {
            this.zzUX = Status.zzagC;
            this.zzaar = display;
        }

        public zzc(Status status) {
            this.zzUX = status;
            this.zzaar = null;
        }

        public Display getPresentationDisplay() {
            return this.zzaar;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public zzlq(Api.zzc<zzlr> zzc2) {
        this.zzaeE = zzc2;
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    public void zzoB() {
        if (this.zzaeF != null) {
            if (this.zzaeF.getDisplay() != null) {
                zzaaf.zzb("releasing virtual display: " + this.zzaeF.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzaeF.release();
            this.zzaeF = null;
        }
    }

    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, final String str) {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzlr zzlr) throws RemoteException {
                zzlr.zza(new zzb.zza(zzlr), zzlq.this.zzaeG, str);
            }
        });
    }

    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzlr zzlr) throws RemoteException {
                zzlr.zza(new zzb.C0104zzb());
            }
        });
    }
}
