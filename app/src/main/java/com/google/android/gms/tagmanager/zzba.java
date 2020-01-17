package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm;

@TargetApi(12)
class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzbjq;

    zzba(int i, final zzm.zza<K, V> zza) {
        this.zzbjq = new LruCache<K, V>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(K k, V v) {
                return zza.sizeOf(k, v);
            }
        };
    }

    public V get(K k) {
        return this.zzbjq.get(k);
    }

    public void zzh(K k, V v) {
        this.zzbjq.put(k, v);
    }
}
