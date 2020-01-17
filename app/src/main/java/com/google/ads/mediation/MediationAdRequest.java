package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzbf;
    private final AdRequest.Gender zzbg;
    private final Set<String> zzbh;
    private final boolean zzbi;
    private final Location zzbj;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzbf = date;
        this.zzbg = gender;
        this.zzbh = set;
        this.zzbi = z;
        this.zzbj = location;
    }

    public Integer getAgeInYears() {
        if (this.zzbf == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzbf);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzbf;
    }

    public AdRequest.Gender getGender() {
        return this.zzbg;
    }

    public Set<String> getKeywords() {
        return this.zzbh;
    }

    public Location getLocation() {
        return this.zzbj;
    }

    public boolean isTesting() {
        return this.zzbi;
    }
}