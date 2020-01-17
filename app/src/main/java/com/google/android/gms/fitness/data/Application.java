package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class Application implements SafeParcelable {
    public static final Parcelable.Creator<Application> CREATOR = new zza();
    public static final Application zzawa = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), (String) null);
    private final int mVersionCode;
    private final String zzTJ;
    private final String zzadc;
    private final String zzawb;

    Application(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzTJ = (String) zzx.zzz(str);
        this.zzadc = "";
        this.zzawb = str3;
    }

    public Application(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean zza(Application application) {
        return this.zzTJ.equals(application.zzTJ) && zzw.equal(this.zzadc, application.zzadc) && zzw.equal(this.zzawb, application.zzawb);
    }

    public static Application zzdn(String str) {
        return zzg(str, (String) null, (String) null);
    }

    public static Application zzg(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzawa : new Application(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Application) && zza((Application) obj));
    }

    public String getPackageName() {
        return this.zzTJ;
    }

    public String getVersion() {
        return this.zzadc;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTJ, this.zzadc, this.zzawb);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.zzTJ, this.zzadc, this.zzawb});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzua() {
        return this.zzawb;
    }
}
