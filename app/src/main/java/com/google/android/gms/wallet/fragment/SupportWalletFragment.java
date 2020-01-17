package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    /* access modifiers changed from: private */
    public boolean mCreated = false;
    /* access modifiers changed from: private */
    public final Fragment zzalg = this;
    /* access modifiers changed from: private */
    public zzb zzbpW;
    /* access modifiers changed from: private */
    public final zzh zzbpX = zzh.zza(this);
    private final zzc zzbpY = new zzc();
    /* access modifiers changed from: private */
    public zza zzbpZ = new zza(this);
    /* access modifiers changed from: private */
    public WalletFragmentOptions zzbqa;
    /* access modifiers changed from: private */
    public WalletFragmentInitParams zzbqb;
    /* access modifiers changed from: private */
    public MaskedWalletRequest zzbqc;
    /* access modifiers changed from: private */
    public MaskedWallet zzbqd;
    /* access modifiers changed from: private */
    public Boolean zzbqe;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends zzry.zza {
        private OnStateChangedListener zzbqf;
        private final SupportWalletFragment zzbqg;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzbqg = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqf != null) {
                this.zzbqf.onStateChanged(this.zzbqg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqf = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzrx zzbqh;

        private zzb(zzrx zzrx) {
            this.zzbqh = zzrx;
        }

        /* access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzbqh.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.zzbqh.initialize(walletFragmentInitParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.zzbqh.onActivityResult(i, i2, intent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void setEnabled(boolean z) {
            try {
                this.zzbqh.setEnabled(z);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzbqh.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.zzbqh.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            try {
                this.zzbqh.onCreate(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.zzbqh.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzbqh.zza(zze.zzC(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzbqh.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzbqh.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzbqh.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzbqh.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzbqh.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements View.OnClickListener {
        private zzc() {
        }

        public void onClick(View view) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        /* access modifiers changed from: protected */
        public void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            int i = -1;
            int i2 = -2;
            Button button = new Button(SupportWalletFragment.this.zzalg.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            if (!(SupportWalletFragment.this.zzbqa == null || (fragmentStyle = SupportWalletFragment.this.zzbqa.getFragmentStyle()) == null)) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.zzalg.getResources().getDisplayMetrics();
                i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<zzb> zzf) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            if (SupportWalletFragment.this.zzbpW == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    zzb unused = SupportWalletFragment.this.zzbpW = new zzb(zzsf.zza(activity, SupportWalletFragment.this.zzbpX, SupportWalletFragment.this.zzbqa, SupportWalletFragment.this.zzbpZ));
                    WalletFragmentOptions unused2 = SupportWalletFragment.this.zzbqa = null;
                    zzf.zza(SupportWalletFragment.this.zzbpW);
                    if (SupportWalletFragment.this.zzbqb != null) {
                        SupportWalletFragment.this.zzbpW.initialize(SupportWalletFragment.this.zzbqb);
                        WalletFragmentInitParams unused3 = SupportWalletFragment.this.zzbqb = null;
                    }
                    if (SupportWalletFragment.this.zzbqc != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWalletRequest(SupportWalletFragment.this.zzbqc);
                        MaskedWalletRequest unused4 = SupportWalletFragment.this.zzbqc = null;
                    }
                    if (SupportWalletFragment.this.zzbqd != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWallet(SupportWalletFragment.this.zzbqd);
                        MaskedWallet unused5 = SupportWalletFragment.this.zzbqd = null;
                    }
                    if (SupportWalletFragment.this.zzbqe != null) {
                        SupportWalletFragment.this.zzbpW.setEnabled(SupportWalletFragment.this.zzbqe.booleanValue());
                        Boolean unused6 = SupportWalletFragment.this.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        supportWalletFragment.zzalg.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        if (this.zzbpW != null) {
            return this.zzbpW.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.zzbpW != null) {
            this.zzbpW.initialize(walletFragmentInitParams);
            this.zzbqb = null;
        } else if (this.zzbqb == null) {
            this.zzbqb = walletFragmentInitParams;
            if (this.zzbqc != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zzbpW != null) {
            this.zzbpW.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzbqb = walletFragmentInitParams;
            }
            if (this.zzbqc == null) {
                this.zzbqc = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.zzbqd == null) {
                this.zzbqd = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.zzbqa = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.zzbqe = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (!(this.zzalg.getArguments() == null || (walletFragmentOptions = (WalletFragmentOptions) this.zzalg.getArguments().getParcelable("extraWalletFragmentOptions")) == null)) {
            walletFragmentOptions.zzbc(this.zzalg.getActivity());
            this.zzbqa = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzbpY.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzbpY.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.zzbqa == null) {
            this.zzbqa = WalletFragmentOptions.zzb((Context) activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.zzbqa);
        this.zzbpY.onInflate(activity, bundle2, bundle);
    }

    public void onPause() {
        super.onPause();
        this.zzbpY.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzbpY.onResume();
        FragmentManager supportFragmentManager = this.zzalg.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzalg.getActivity()), this.zzalg.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbpY.onSaveInstanceState(bundle);
        if (this.zzbqb != null) {
            bundle.putParcelable("walletFragmentInitParams", this.zzbqb);
            this.zzbqb = null;
        }
        if (this.zzbqc != null) {
            bundle.putParcelable("maskedWalletRequest", this.zzbqc);
            this.zzbqc = null;
        }
        if (this.zzbqd != null) {
            bundle.putParcelable("maskedWallet", this.zzbqd);
            this.zzbqd = null;
        }
        if (this.zzbqa != null) {
            bundle.putParcelable("walletFragmentOptions", this.zzbqa);
            this.zzbqa = null;
        }
        if (this.zzbqe != null) {
            bundle.putBoolean("enabled", this.zzbqe.booleanValue());
            this.zzbqe = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzbpY.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzbpY.onStop();
    }

    public void setEnabled(boolean z) {
        if (this.zzbpW != null) {
            this.zzbpW.setEnabled(z);
            this.zzbqe = null;
            return;
        }
        this.zzbqe = Boolean.valueOf(z);
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzbpZ.zza(onStateChangedListener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbpW != null) {
            this.zzbpW.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
            return;
        }
        this.zzbqd = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.zzbpW != null) {
            this.zzbpW.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzbqc = null;
            return;
        }
        this.zzbqc = maskedWalletRequest;
    }
}
