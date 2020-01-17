package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzl CREATOR = new zzl();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaPc;
    private final List<Integer> zzaPd;
    private final String zzaPe;
    private final Uri zzaPf;
    private final String zzaQA;
    private final boolean zzaQB;
    private final float zzaQC;
    private final int zzaQD;
    private final long zzaQE;
    private final List<Integer> zzaQF;
    private final String zzaQG;
    private final List<String> zzaQH;
    private final Map<Integer, String> zzaQI;
    private final TimeZone zzaQJ;
    private Locale zzaQr;
    private final Bundle zzaQw;
    @Deprecated
    private final PlaceLocalization zzaQx;
    private final float zzaQy;
    private final LatLngBounds zzaQz;
    private final String zzawc;
    private final String zzyv;

    public static class zza {
        private String mName;
        private int mVersionCode = 0;
        private LatLng zzaPc;
        private String zzaPe;
        private Uri zzaPf;
        private String zzaQA;
        private boolean zzaQB;
        private float zzaQC;
        private int zzaQD;
        private long zzaQE;
        private String zzaQG;
        private List<String> zzaQH;
        private Bundle zzaQK;
        private List<Integer> zzaQL;
        private float zzaQy;
        private LatLngBounds zzaQz;
        private String zzawc;
        private String zzyv;

        public zza zza(LatLng latLng) {
            this.zzaPc = latLng;
            return this;
        }

        public zza zza(LatLngBounds latLngBounds) {
            this.zzaQz = latLngBounds;
            return this;
        }

        public zza zzan(boolean z) {
            this.zzaQB = z;
            return this;
        }

        public zza zzem(String str) {
            this.zzyv = str;
            return this;
        }

        public zza zzen(String str) {
            this.mName = str;
            return this;
        }

        public zza zzeo(String str) {
            this.zzawc = str;
            return this;
        }

        public zza zzep(String str) {
            this.zzaPe = str;
            return this;
        }

        public zza zzf(float f) {
            this.zzaQy = f;
            return this;
        }

        public zza zzg(float f) {
            this.zzaQC = f;
            return this;
        }

        public zza zzhX(int i) {
            this.zzaQD = i;
            return this;
        }

        public zza zzo(Uri uri) {
            this.zzaPf = uri;
            return this;
        }

        public zza zzx(List<Integer> list) {
            this.zzaQL = list;
            return this;
        }

        public zza zzy(List<String> list) {
            this.zzaQH = list;
            return this;
        }

        public PlaceImpl zzzx() {
            return new PlaceImpl(this.mVersionCode, this.zzyv, this.zzaQL, Collections.emptyList(), this.zzaQK, this.mName, this.zzawc, this.zzaPe, this.zzaQG, this.zzaQH, this.zzaPc, this.zzaQy, this.zzaQz, this.zzaQA, this.zzaPf, this.zzaQB, this.zzaQC, this.zzaQD, this.zzaQE, PlaceLocalization.zza(this.mName, this.zzawc, this.zzaPe, this.zzaQG, this.zzaQH));
        }
    }

    PlaceImpl(int i, String str, List<Integer> list, List<Integer> list2, Bundle bundle, String str2, String str3, String str4, String str5, List<String> list3, LatLng latLng, float f, LatLngBounds latLngBounds, String str6, Uri uri, boolean z, float f2, int i2, long j, PlaceLocalization placeLocalization) {
        this.mVersionCode = i;
        this.zzyv = str;
        this.zzaPd = Collections.unmodifiableList(list);
        this.zzaQF = list2;
        this.zzaQw = bundle == null ? new Bundle() : bundle;
        this.mName = str2;
        this.zzawc = str3;
        this.zzaPe = str4;
        this.zzaQG = str5;
        this.zzaQH = list3 == null ? Collections.emptyList() : list3;
        this.zzaPc = latLng;
        this.zzaQy = f;
        this.zzaQz = latLngBounds;
        this.zzaQA = str6 == null ? "UTC" : str6;
        this.zzaPf = uri;
        this.zzaQB = z;
        this.zzaQC = f2;
        this.zzaQD = i2;
        this.zzaQE = j;
        this.zzaQI = Collections.unmodifiableMap(new HashMap());
        this.zzaQJ = null;
        this.zzaQr = null;
        this.zzaQx = placeLocalization;
    }

    public int describeContents() {
        zzl zzl = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof PlaceImpl)) {
                return false;
            }
            PlaceImpl placeImpl = (PlaceImpl) obj;
            if (!this.zzyv.equals(placeImpl.zzyv) || !zzw.equal(this.zzaQr, placeImpl.zzaQr) || this.zzaQE != placeImpl.zzaQE) {
                return false;
            }
        }
        return true;
    }

    public String getAddress() {
        return this.zzawc;
    }

    public CharSequence getAttributions() {
        return zzc.zzj(this.zzaQH);
    }

    public String getId() {
        return this.zzyv;
    }

    public LatLng getLatLng() {
        return this.zzaPc;
    }

    public Locale getLocale() {
        return this.zzaQr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzaPe;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaPd;
    }

    public int getPriceLevel() {
        return this.zzaQD;
    }

    public float getRating() {
        return this.zzaQC;
    }

    public LatLngBounds getViewport() {
        return this.zzaQz;
    }

    public Uri getWebsiteUri() {
        return this.zzaPf;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzyv, this.zzaQr, Long.valueOf(this.zzaQE));
    }

    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzaQr = locale;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return zzw.zzy(this).zzg("id", this.zzyv).zzg("placeTypes", this.zzaPd).zzg("locale", this.zzaQr).zzg("name", this.mName).zzg("address", this.zzawc).zzg("phoneNumber", this.zzaPe).zzg("latlng", this.zzaPc).zzg("viewport", this.zzaQz).zzg("websiteUri", this.zzaPf).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaQB)).zzg("priceLevel", Integer.valueOf(this.zzaQD)).zzg("timestampSecs", Long.valueOf(this.zzaQE)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl zzl = CREATOR;
        zzl.zza(this, parcel, i);
    }

    public List<Integer> zzzn() {
        return this.zzaQF;
    }

    public float zzzo() {
        return this.zzaQy;
    }

    public String zzzp() {
        return this.zzaQG;
    }

    public List<String> zzzq() {
        return this.zzaQH;
    }

    public boolean zzzr() {
        return this.zzaQB;
    }

    public long zzzs() {
        return this.zzaQE;
    }

    public Bundle zzzt() {
        return this.zzaQw;
    }

    public String zzzu() {
        return this.zzaQA;
    }

    @Deprecated
    public PlaceLocalization zzzv() {
        return this.zzaQx;
    }

    /* renamed from: zzzw */
    public Place freeze() {
        return this;
    }
}
