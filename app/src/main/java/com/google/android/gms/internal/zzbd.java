package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzbd {
    private final Object zzpV = new Object();
    private int zzsW;
    private List<zzbc> zzsX = new LinkedList();

    public boolean zza(zzbc zzbc) {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsX.contains(zzbc);
        }
        return z;
    }

    public boolean zzb(zzbc zzbc) {
        boolean z;
        synchronized (this.zzpV) {
            Iterator<zzbc> it = this.zzsX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzbc next = it.next();
                if (zzbc != next && next.zzcy().equals(zzbc.zzcy())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzbc zzbc) {
        synchronized (this.zzpV) {
            if (this.zzsX.size() >= 10) {
                zzin.zzaI("Queue is full, current size = " + this.zzsX.size());
                this.zzsX.remove(0);
            }
            int i = this.zzsW;
            this.zzsW = i + 1;
            zzbc.zzh(i);
            this.zzsX.add(zzbc);
        }
    }

    public zzbc zzcF() {
        zzbc zzbc = null;
        synchronized (this.zzpV) {
            if (this.zzsX.size() == 0) {
                zzin.zzaI("Queue empty");
                return null;
            } else if (this.zzsX.size() >= 2) {
                int i = Integer.MIN_VALUE;
                for (zzbc next : this.zzsX) {
                    int score = next.getScore();
                    if (score <= i) {
                        score = i;
                        next = zzbc;
                    }
                    i = score;
                    zzbc = next;
                }
                this.zzsX.remove(zzbc);
                return zzbc;
            } else {
                zzbc zzbc2 = this.zzsX.get(0);
                zzbc2.zzcA();
                return zzbc2;
            }
        }
    }
}
