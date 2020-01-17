package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzm;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlf;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private zzq zzXP;
    private zzk zzXQ;
    private SignInConfiguration zzXR;
    private boolean zzXS;
    private String zzXT;
    private String zzXU;
    private boolean zzXV;
    /* access modifiers changed from: private */
    public int zzXW;
    /* access modifiers changed from: private */
    public Intent zzXX;

    private class zza implements LoaderManager.LoaderCallbacks<Void> {
        private zza() {
        }

        public Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(SignInHubActivity.this, GoogleApiClient.zzoV());
        }

        public void onLoaderReset(Loader<Void> loader) {
        }

        /* renamed from: zza */
        public void onLoadFinished(Loader<Void> loader, Void voidR) {
            SignInHubActivity.this.setResult(SignInHubActivity.this.zzXW, SignInHubActivity.this.zzXX);
            SignInHubActivity.this.finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            com.google.android.gms.auth.api.signin.internal.zzk r0 = r3.zzXQ
            java.util.Collection r0 = r0.zznh()
            java.util.Iterator r1 = r0.iterator()
        L_0x000a:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0022
            java.lang.Object r0 = r1.next()
            com.google.android.gms.internal.zzlf r0 = (com.google.android.gms.internal.zzlf) r0
            java.lang.String r2 = r3.zzXU
            com.google.android.gms.internal.zzlf$zza r2 = r3.zzbO(r2)
            boolean r0 = r0.zza(r4, r5, r6, r2)
            if (r0 == 0) goto L_0x000a
        L_0x0022:
            if (r5 != 0) goto L_0x0027
            r3.finish()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.zza(int, int, android.content.Intent):void");
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.zzmV() != null) {
                GoogleSignInAccount zzmV = signInAccount.zzmV();
                this.zzXP.zzb(zzmV, this.zzXR.zznm());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", zzmV);
                this.zzXV = true;
                this.zzXW = i;
                this.zzXX = intent;
                zzd(i, intent);
                return;
            } else if (intent.hasExtra("errorCode")) {
                zzaS(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzaS(8);
    }

    /* access modifiers changed from: private */
    public void zzaR(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void zzaS(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzb(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null) {
                this.zzXP.zzb(signInAccount, this.zzXR);
                String stringExtra = intent.getStringExtra("accessToken");
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.zzXU)) {
                    zzm.zzbN(signInAccount.getUserId()).zza(new HashSet(Arrays.asList(TextUtils.split(this.zzXU, " "))), new zzm.zza(stringExtra, intent.getLongExtra("accessTokenExpiresAtSecs", 0)));
                    intent.removeExtra("accessTokenExpiresAtSecs");
                }
                setResult(-1, intent);
                finish();
                return;
            }
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            zzaR(2);
        } else if (intent == null) {
            finish();
        } else {
            String stringExtra2 = intent.getStringExtra("email");
            zzd zzbL = zzd.zzbL(intent.getStringExtra("idProvider"));
            if (zzbL == null) {
                setResult(i, intent);
                finish();
                return;
            }
            this.zzXT = intent.getStringExtra("pendingToken");
            zzlf zza2 = this.zzXQ.zza(zzbL);
            if (zza2 == null) {
                Log.w("AuthSignInClient", zzbL.zzae(this) + " is not supported. Please check your configuration");
                zzaR(1);
                return;
            }
            int intExtra = intent.getIntExtra("idpAction", -1);
            if (intExtra == 0) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    zza2.zza(zzbO(this.zzXU));
                } else {
                    zza2.zza(stringExtra2, zzbO(this.zzXU));
                }
            } else if (intExtra != 1 || TextUtils.isEmpty(this.zzXT) || TextUtils.isEmpty(stringExtra2)) {
                Log.w("AuthSignInClient", "Internal error!");
                zzaR(2);
            } else {
                zza2.zza(stringExtra2, this.zzXT, zzbO(this.zzXU));
            }
        }
    }

    private zzlf.zza zzbO(final String str) {
        return new zzlf.zza() {
            public void zzk(Intent intent) {
                if (intent != null) {
                    if (!TextUtils.isEmpty(str)) {
                        intent.putExtra("scopes", str);
                    }
                    SignInHubActivity.this.zzj(intent);
                    return;
                }
                Log.w("AuthSignInClient", "Idp signin failed!");
                SignInHubActivity.this.zzaR(4);
            }
        };
    }

    private void zzc(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.zzXA);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.zzXT);
        intent2.putExtra("idProvider", zzd.FACEBOOK.zzmT());
        zzj(intent2);
    }

    private void zzd(int i, Intent intent) {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new zza());
    }

    /* access modifiers changed from: private */
    public void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.zzXR);
        try {
            startActivityForResult(intent, this.zzXS ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.zzXS) {
                zzaS(8);
            } else {
                zzaR(2);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        setResult(0);
        switch (i) {
            case 40961:
                zzb(i2, intent);
                return;
            case 40962:
                zza(i2, intent);
                return;
            case 45057:
                zzc(i2, intent);
                return;
            default:
                zza(i, i2, intent);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Intent intent;
        SignInAccount signInAccount = null;
        super.onCreate(bundle);
        this.zzXP = zzq.zzaf(this);
        Intent intent2 = getIntent();
        this.zzXR = (SignInConfiguration) intent2.getParcelableExtra("config");
        this.zzXS = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(intent2.getAction());
        this.zzXU = intent2.getStringExtra("scopes");
        if (this.zzXR == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        zzi.zza(this.zzXR, linkedList, hashMap);
        this.zzXQ = new zzk(this, linkedList, hashMap);
        if (bundle == null) {
            if (this.zzXS) {
                intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            } else {
                intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
                if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(intent2.getAction())) {
                    intent.fillIn(intent2, 3);
                    signInAccount = (SignInAccount) intent2.getParcelableExtra("signInAccount");
                } else {
                    this.zzXP.zznq();
                }
            }
            if (signInAccount == null || signInAccount.zzmU() != zzd.FACEBOOK) {
                zzj(intent);
            } else {
                zzbO(this.zzXU);
                throw new NullPointerException();
            }
        } else {
            this.zzXT = bundle.getString("pendingToken");
            this.zzXV = bundle.getBoolean("signingInGoogleApiClients");
            if (this.zzXV) {
                this.zzXW = bundle.getInt("signInResultCode");
                this.zzXX = (Intent) bundle.getParcelable("signInResultData");
                zzd(this.zzXW, this.zzXX);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("pendingToken", this.zzXT);
        bundle.putBoolean("signingInGoogleApiClients", this.zzXV);
        if (this.zzXV) {
            bundle.putInt("signInResultCode", this.zzXW);
            bundle.putParcelable("signInResultData", this.zzXX);
        }
    }
}
