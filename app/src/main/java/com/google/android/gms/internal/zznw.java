package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.internal.zznx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class zznw {
    private static final Set<String> zzazD = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{zznt.zzaxI.name, zznt.zzaxW.name})));

    public static String zzd(DataPoint dataPoint) {
        double asFloat;
        DataType dataType = dataPoint.getDataType();
        if (!zznu.zzdD(dataType.getName())) {
            return null;
        }
        for (Field next : dataType.getFields()) {
            Value value = dataPoint.getValue(next);
            if (value.isSet()) {
                if (next.getFormat() == 1) {
                    asFloat = (double) value.asInt();
                } else if (next.getFormat() == 2) {
                    asFloat = (double) value.asFloat();
                } else {
                    continue;
                }
                zznx.zza zzdE = zznx.zzuG().zzdE(next.getName());
                if (zzdE != null && !zzdE.zzh(asFloat)) {
                    return "Field out of range";
                }
                zznx.zza zzC = zznx.zzuG().zzC(dataType.getName(), next.getName());
                if (zzC != null) {
                    long timestampNanos = dataPoint.getTimestampNanos() - dataPoint.zzuj();
                    if (timestampNanos == 0) {
                        if (asFloat == 0.0d) {
                            return null;
                        }
                        return "DataPoint out of range";
                    } else if (!zzC.zzh(asFloat / ((double) timestampNanos))) {
                        return "DataPoint out of range";
                    }
                } else {
                    continue;
                }
            } else if (!zzazD.contains(next.getName())) {
                return next.getName() + " not set";
            }
        }
        return null;
    }

    public static void zze(DataPoint dataPoint) throws IllegalArgumentException {
        String zzd = zzd(dataPoint);
        if (zzd != null) {
            Log.w("Fitness", "Invalid data point: " + dataPoint);
            throw new IllegalArgumentException(zzd);
        }
    }
}
