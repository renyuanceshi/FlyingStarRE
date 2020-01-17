package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class zzm {
    private static final WeakHashMap<String, zzm> zzXE = new WeakHashMap<>();
    private static final Lock zzXF = new ReentrantLock();
    private final Lock zzXG = new ReentrantLock();
    private final Map<String, zza> zzXH;

    public static class zza {
        private final String zzXI;
        private final long zzXJ;
        private final zzmq zzqW;

        public zza(String str, long j) {
            this(str, j, zzmt.zzsc());
        }

        private zza(String str, long j, zzmq zzmq) {
            this.zzXI = zzx.zzcM(str);
            zzx.zzac(j > 0);
            this.zzXJ = j;
            this.zzqW = (zzmq) zzx.zzz(zzmq);
        }

        public boolean zzb() {
            return this.zzqW.currentTimeMillis() / 1000 >= this.zzXJ - 300;
        }
    }

    static class zzb<K, V> extends LinkedHashMap<K, V> {
        private final int zzav;

        public zzb(int i) {
            this.zzav = i;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.zzav;
        }
    }

    private zzm(Map<String, zza> map) {
        this.zzXH = map;
    }

    public static zzm zzbN(String str) {
        zzx.zzcM(str);
        zzXF.lock();
        try {
            zzm zzm = zzXE.get(str);
            if (zzm == null) {
                zzm = new zzm(new zzb(20));
                zzXE.put(str, zzm);
            }
            return zzm;
        } finally {
            zzXF.unlock();
        }
    }

    public boolean zza(Set<String> set, zza zza2) {
        zzx.zzz(set);
        zzx.zzz(zza2);
        if (set.size() == 0 || zza2.zzb()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList);
        this.zzXG.lock();
        try {
            this.zzXH.put(TextUtils.join(" ", arrayList), zza2);
            return true;
        } finally {
            this.zzXG.unlock();
        }
    }
}
