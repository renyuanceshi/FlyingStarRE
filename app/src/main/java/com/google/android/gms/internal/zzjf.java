package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzhb
public class zzjf {

    public interface zza<D, R> {
        R zzf(D d);
    }

    public static <A, B> zzjg<B> zza(final zzjg<A> zzjg, final zza<A, B> zza2) {
        final zzjd zzjd = new zzjd();
        zzjg.zzb(new Runnable() {
            public void run() {
                try {
                    zzjd.zzg(zza2.zzf(zzjg.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzjd.cancel(true);
                }
            }
        });
        return zzjd;
    }

    public static <V> zzjg<List<V>> zzl(final List<zzjg<V>> list) {
        final zzjd zzjd = new zzjd();
        final int size = list.size();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzjg<V> zzb : list) {
            zzb.zzb(new Runnable() {
                public void run() {
                    if (atomicInteger.incrementAndGet() >= size) {
                        try {
                            zzjd.zzg(zzjf.zzm(list));
                        } catch (InterruptedException | ExecutionException e) {
                            zzin.zzd("Unable to convert list of futures to a future of list", e);
                        }
                    }
                }
            });
        }
        return zzjd;
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzm(List<zzjg<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzjg<V> zzjg : list) {
            Object obj = zzjg.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
