package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzbhM;
    private final DataLayer zzbhN;
    private zzcp zzbhO;
    private Map<String, FunctionCallMacroCallback> zzbhP = new HashMap();
    private Map<String, FunctionCallTagCallback> zzbhQ = new HashMap();
    private volatile long zzbhR;
    private volatile String zzbhS = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements zzt.zza {
        private zza() {
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzfP = Container.this.zzfP(str);
            if (zzfP == null) {
                return null;
            }
            return zzfP.getValue(str, map);
        }
    }

    private class zzb implements zzt.zza {
        private zzb() {
        }

        public Object zzc(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzfQ = Container.this.zzfQ(str);
            if (zzfQ != null) {
                zzfQ.execute(str, map);
            }
            return zzdf.zzHE();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzaf.zzj zzj) {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = str;
        this.zzbhR = j;
        zza(zzj.zzju);
        if (zzj.zzjt != null) {
            zza(zzj.zzjt);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzrs.zzc zzc) {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = str;
        this.zzbhR = j;
        zza(zzc);
    }

    private zzcp zzGc() {
        zzcp zzcp;
        synchronized (this) {
            zzcp = this.zzbhO;
        }
        return zzcp;
    }

    private void zza(zzaf.zzf zzf) {
        if (zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzrs.zzb(zzf));
        } catch (zzrs.zzg e) {
            zzbg.e("Not loading resource: " + zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzrs.zzc zzc) {
        this.zzbhS = zzc.getVersion();
        zzrs.zzc zzc2 = zzc;
        zza(new zzcp(this.mContext, zzc2, this.zzbhN, new zza(), new zzb(), zzfS(this.zzbhS)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzbhN.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbhM));
        }
    }

    private void zza(zzcp zzcp) {
        synchronized (this) {
            this.zzbhO = zzcp;
        }
    }

    private void zza(zzaf.zzi[] zziArr) {
        ArrayList arrayList = new ArrayList();
        for (zzaf.zzi add : zziArr) {
            arrayList.add(add);
        }
        zzGc().zzF(arrayList);
    }

    public boolean getBoolean(String str) {
        zzcp zzGc = zzGc();
        if (zzGc == null) {
            zzbg.e("getBoolean called for closed container.");
            return zzdf.zzHC().booleanValue();
        }
        try {
            return zzdf.zzk(zzGc.zzgn(str).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHC().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzbhM;
    }

    public double getDouble(String str) {
        zzcp zzGc = zzGc();
        if (zzGc == null) {
            zzbg.e("getDouble called for closed container.");
            return zzdf.zzHB().doubleValue();
        }
        try {
            return zzdf.zzj(zzGc.zzgn(str).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHB().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzbhR;
    }

    public long getLong(String str) {
        zzcp zzGc = zzGc();
        if (zzGc == null) {
            zzbg.e("getLong called for closed container.");
            return zzdf.zzHA().longValue();
        }
        try {
            return zzdf.zzi(zzGc.zzgn(str).getObject()).longValue();
        } catch (Exception e) {
            zzbg.e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHA().longValue();
        }
    }

    public String getString(String str) {
        zzcp zzGc = zzGc();
        if (zzGc == null) {
            zzbg.e("getString called for closed container.");
            return zzdf.zzHE();
        }
        try {
            return zzdf.zzg(zzGc.zzgn(str).getObject());
        } catch (Exception e) {
            zzbg.e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHE();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbhP) {
            this.zzbhP.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbhQ) {
            this.zzbhQ.put(str, functionCallTagCallback);
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        this.zzbhO = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzbhP) {
            this.zzbhP.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzbhQ) {
            this.zzbhQ.remove(str);
        }
    }

    public String zzGb() {
        return this.zzbhS;
    }

    /* access modifiers changed from: package-private */
    public FunctionCallMacroCallback zzfP(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzbhP) {
            functionCallMacroCallback = this.zzbhP.get(str);
        }
        return functionCallMacroCallback;
    }

    public FunctionCallTagCallback zzfQ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzbhQ) {
            functionCallTagCallback = this.zzbhQ.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzfR(String str) {
        zzGc().zzfR(str);
    }

    /* access modifiers changed from: package-private */
    public zzah zzfS(String str) {
        if (zzcb.zzGU().zzGV().equals(zzcb.zza.CONTAINER_DEBUG)) {
        }
        return new zzbo();
    }
}
