package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzb();
    private final int mVersionCode;
    private int zzBc;
    private String zzZT;
    String zzZU;
    private Inet4Address zzZV;
    private String zzZW;
    private String zzZX;
    private String zzZY;
    private int zzZZ;
    private List<WebImage> zzaaa;
    private int zzaab;
    private String zzaac;

    private CastDevice() {
        this(4, (String) null, (String) null, (String) null, (String) null, (String) null, -1, new ArrayList(), 0, -1, (String) null);
    }

    CastDevice(int i, String str, String str2, String str3, String str4, String str5, int i2, List<WebImage> list, int i3, int i4, String str6) {
        this.mVersionCode = i;
        this.zzZT = zzbZ(str);
        this.zzZU = zzbZ(str2);
        if (!TextUtils.isEmpty(this.zzZU)) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzZU);
                if (byName instanceof Inet4Address) {
                    this.zzZV = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                Log.i("CastDevice", "Unable to convert host address (" + this.zzZU + ") to ipaddress: " + e.getMessage());
            }
        }
        this.zzZW = zzbZ(str3);
        this.zzZX = zzbZ(str4);
        this.zzZY = zzbZ(str5);
        this.zzZZ = i2;
        this.zzaaa = list == null ? new ArrayList<>() : list;
        this.zzaab = i3;
        this.zzBc = i4;
        this.zzaac = zzbZ(str6);
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzbZ(String str) {
        return str == null ? "" : str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof CastDevice)) {
                return false;
            }
            CastDevice castDevice = (CastDevice) obj;
            if (this.zzZT == null) {
                if (castDevice.zzZT != null) {
                    return false;
                }
            } else if (!zzf.zza(this.zzZT, castDevice.zzZT) || !zzf.zza(this.zzZV, castDevice.zzZV) || !zzf.zza(this.zzZX, castDevice.zzZX) || !zzf.zza(this.zzZW, castDevice.zzZW) || !zzf.zza(this.zzZY, castDevice.zzZY) || this.zzZZ != castDevice.zzZZ || !zzf.zza(this.zzaaa, castDevice.zzaaa) || this.zzaab != castDevice.zzaab || this.zzBc != castDevice.zzBc || !zzf.zza(this.zzaac, castDevice.zzaac)) {
                return false;
            }
        }
        return true;
    }

    public int getCapabilities() {
        return this.zzaab;
    }

    public String getDeviceId() {
        return this.zzZT.startsWith("__cast_nearby__") ? this.zzZT.substring("__cast_nearby__".length() + 1) : this.zzZT;
    }

    public String getDeviceVersion() {
        return this.zzZY;
    }

    public String getFriendlyName() {
        return this.zzZW;
    }

    public WebImage getIcon(int i, int i2) {
        if (this.zzaaa.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return this.zzaaa.get(0);
        }
        WebImage webImage = null;
        WebImage webImage2 = null;
        for (WebImage next : this.zzaaa) {
            int width = next.getWidth();
            int height = next.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2) {
                    if (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height)) {
                        webImage2 = next;
                    }
                }
            } else if (webImage == null || (webImage.getWidth() > width && webImage.getHeight() > height)) {
                webImage = next;
            }
        }
        if (webImage != null) {
            webImage2 = webImage;
        } else if (webImage2 == null) {
            webImage2 = this.zzaaa.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzaaa);
    }

    public Inet4Address getIpAddress() {
        return this.zzZV;
    }

    public String getModelName() {
        return this.zzZX;
    }

    public int getServicePort() {
        return this.zzZZ;
    }

    public int getStatus() {
        return this.zzBc;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int hasCapability : iArr) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i) {
        return (this.zzaab & i) == i;
    }

    public boolean hasIcons() {
        return !this.zzaaa.isEmpty();
    }

    public int hashCode() {
        if (this.zzZT == null) {
            return 0;
        }
        return this.zzZT.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzZT.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        return this.zzZT == null ? castDevice.zzZT == null : zzf.zza(this.zzZT, castDevice.zzZT);
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzZW, this.zzZT});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzny() {
        return this.zzZT;
    }

    public String zznz() {
        return this.zzaac;
    }
}
