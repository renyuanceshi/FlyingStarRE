package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAdshieldEvent;
import com.google.ads.afma.nano.NanoAfmaSignals;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzaq;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class zzal extends zzak {
    private static long startTime = 0;
    private static Method zznH;
    private static Method zznI;
    private static Method zznJ;
    private static Method zznK;
    private static Method zznL;
    private static Method zznM;
    private static Method zznN;
    private static Method zznO;
    private static Method zznP;
    private static Method zznQ;
    private static Method zznR;
    private static Method zznS;
    private static Method zznT;
    private static String zznU;
    private static String zznV;
    private static String zznW;
    private static zzaq zznX;
    static boolean zznY = false;
    protected static zzb zznZ = null;
    protected static NanoAdshieldEvent.AdShieldEvent zzoa;
    protected static int zzob;
    private static Random zzoc = new Random();
    private static zzc zzod = zzc.zzoK();
    private static boolean zzoe;
    protected static boolean zzof = false;
    protected static boolean zzog = false;
    protected static boolean zzoh = false;
    protected static boolean zzoi = false;
    private static boolean zzoj = false;

    static class zza extends Exception {
        public zza() {
        }

        public zza(Throwable th) {
            super(th);
        }
    }

    protected zzal(Context context, zzap zzap) {
        super(context, zzap);
        zzoa = new NanoAdshieldEvent.AdShieldEvent();
        zzoa.appId = context.getPackageName();
    }

    private void zzT() {
        if (zzoi && zznZ != null) {
            zznZ.zza(zznG, 100, TimeUnit.MILLISECONDS);
            zznG.disconnect();
        }
    }

    static String zzU() throws zza {
        if (zznU != null) {
            return zznU;
        }
        throw new zza();
    }

    static Long zzV() throws zza {
        if (zznH == null) {
            throw new zza();
        }
        try {
            return (Long) zznH.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzW() throws zza {
        if (zznJ == null) {
            throw new zza();
        }
        try {
            return (String) zznJ.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzX() throws zza {
        if (zznI == null) {
            throw new zza();
        }
        try {
            return (Long) zznI.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zza(Context context, zzap zzap) throws zza {
        if (zznV != null) {
            return zznV;
        }
        if (zznK == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznK.invoke((Object) null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznV = zzap.zza(byteBuffer.array(), true);
            return zznV;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zza(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zza {
        if (zznL == null || motionEvent == null) {
            throw new zza();
        }
        try {
            return (ArrayList) zznL.invoke((Object) null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    protected static void zza(int i, int i2) throws IOException {
        if (zzoi && zzof && zznZ != null) {
            zzb.zza zzi = zznZ.zzi(zzsu.toByteArray(zzoa));
            zzi.zzbr(i2);
            zzi.zzbq(i);
            zzi.zzd(zznG);
        }
    }

    protected static void zza(String str, Context context, zzap zzap) {
        synchronized (zzal.class) {
            try {
                if (!zznY) {
                    try {
                        zznX = new zzaq(zzap, (SecureRandom) null);
                        zznU = str;
                        zzbt.initialize(context);
                        zzm(context);
                        startTime = zzV().longValue();
                        zzoc = new Random();
                        try {
                            zznG = new GoogleApiClient.Builder(context).addApi(zzb.API).build();
                            zzod = zzc.zzoK();
                            zzoe = zzod.isGooglePlayServicesAvailable(context) == 0;
                            zzbt.initialize(context);
                            zzof = zzbt.zzwZ.get().booleanValue();
                            zznZ = new zzb(context, "ADSHIELD", (String) null, (String) null);
                        } catch (NoClassDefFoundError e) {
                        }
                        zzoj = zzod.zzaj(context) > 0;
                        zznY = true;
                    } catch (zza | UnsupportedOperationException e2) {
                    }
                }
            } catch (Throwable th) {
                Class<zzal> cls = zzal.class;
                throw th;
            }
        }
    }

    static String zzb(Context context, zzap zzap) throws zza {
        if (zznW != null) {
            return zznW;
        }
        if (zznN == null) {
            throw new zza();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) zznN.invoke((Object) null, new Object[]{context});
            if (byteBuffer == null) {
                throw new zza();
            }
            zznW = zzap.zza(byteBuffer.array(), true);
            return zznW;
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zznX.zzc(bArr, str), "UTF-8");
        } catch (zzaq.zza e) {
            throw new zza(e);
        } catch (UnsupportedEncodingException e2) {
            throw new zza(e2);
        }
    }

    private void zze(Context context) {
        if (zzoe) {
            zznG.connect();
            zzoi = true;
            return;
        }
        zzoi = false;
    }

    static String zzf(Context context) throws zza {
        if (zznM == null) {
            throw new zza();
        }
        try {
            String str = (String) zznM.invoke((Object) null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static String zzg(Context context) throws zza {
        if (zznQ == null) {
            throw new zza();
        }
        try {
            return (String) zznQ.invoke((Object) null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static Long zzh(Context context) throws zza {
        if (zznR == null) {
            throw new zza();
        }
        try {
            return (Long) zznR.invoke((Object) null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static ArrayList<Long> zzi(Context context) throws zza {
        if (zznO == null) {
            throw new zza();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) zznO.invoke((Object) null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new zza();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int[] zzj(Context context) throws zza {
        if (zznP == null) {
            throw new zza();
        }
        try {
            return (int[]) zznP.invoke((Object) null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzk(Context context) throws zza {
        if (zznS == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznS.invoke((Object) null, new Object[]{context})).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    static int zzl(Context context) throws zza {
        if (zznT == null) {
            throw new zza();
        }
        try {
            return ((Integer) zznT.invoke((Object) null, new Object[]{context})).intValue();
        } catch (IllegalAccessException e) {
            throw new zza(e);
        } catch (InvocationTargetException e2) {
            throw new zza(e2);
        }
    }

    private static void zzm(Context context) throws zza {
        File file;
        File createTempFile;
        try {
            byte[] zzl = zznX.zzl(zzar.getKey());
            byte[] zzc = zznX.zzc(zzl, zzar.zzac());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new zza();
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), (String) null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(zzb(zzl, zzar.zzal()));
            Class loadClass2 = dexClassLoader.loadClass(zzb(zzl, zzar.zzaz()));
            Class loadClass3 = dexClassLoader.loadClass(zzb(zzl, zzar.zzat()));
            Class loadClass4 = dexClassLoader.loadClass(zzb(zzl, zzar.zzap()));
            Class loadClass5 = dexClassLoader.loadClass(zzb(zzl, zzar.zzaB()));
            Class loadClass6 = dexClassLoader.loadClass(zzb(zzl, zzar.zzan()));
            Class loadClass7 = dexClassLoader.loadClass(zzb(zzl, zzar.zzax()));
            Class loadClass8 = dexClassLoader.loadClass(zzb(zzl, zzar.zzav()));
            Class loadClass9 = dexClassLoader.loadClass(zzb(zzl, zzar.zzaj()));
            Class loadClass10 = dexClassLoader.loadClass(zzb(zzl, zzar.zzah()));
            Class loadClass11 = dexClassLoader.loadClass(zzb(zzl, zzar.zzaf()));
            Class loadClass12 = dexClassLoader.loadClass(zzb(zzl, zzar.zzar()));
            Class loadClass13 = dexClassLoader.loadClass(zzb(zzl, zzar.zzad()));
            zznH = loadClass.getMethod(zzb(zzl, zzar.zzam()), new Class[0]);
            zznI = loadClass2.getMethod(zzb(zzl, zzar.zzaA()), new Class[0]);
            zznJ = loadClass3.getMethod(zzb(zzl, zzar.zzau()), new Class[0]);
            zznK = loadClass4.getMethod(zzb(zzl, zzar.zzaq()), new Class[]{Context.class});
            zznL = loadClass5.getMethod(zzb(zzl, zzar.zzaC()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            zznM = loadClass6.getMethod(zzb(zzl, zzar.zzao()), new Class[]{Context.class});
            zznN = loadClass7.getMethod(zzb(zzl, zzar.zzay()), new Class[]{Context.class});
            zznO = loadClass8.getMethod(zzb(zzl, zzar.zzaw()), new Class[]{Context.class});
            zznP = loadClass9.getMethod(zzb(zzl, zzar.zzak()), new Class[]{Context.class});
            zznQ = loadClass10.getMethod(zzb(zzl, zzar.zzai()), new Class[]{Context.class});
            zznR = loadClass11.getMethod(zzb(zzl, zzar.zzag()), new Class[]{Context.class});
            zznS = loadClass12.getMethod(zzb(zzl, zzar.zzas()), new Class[]{Context.class});
            zznT = loadClass13.getMethod(zzb(zzl, zzar.zzae()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (FileNotFoundException e) {
            throw new zza(e);
        } catch (IOException e2) {
            throw new zza(e2);
        } catch (ClassNotFoundException e3) {
            throw new zza(e3);
        } catch (zzaq.zza e4) {
            throw new zza(e4);
        } catch (NoSuchMethodException e5) {
            throw new zza(e5);
        } catch (NullPointerException e6) {
            throw new zza(e6);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzS() {
        return zzoj;
    }

    /* access modifiers changed from: protected */
    public NanoAfmaSignals.AFMASignals zzc(Context context) {
        NanoAfmaSignals.AFMASignals aFMASignals = new NanoAfmaSignals.AFMASignals();
        try {
            zze(context);
            zzob = zzoc.nextInt();
            zza(0, zzob);
            try {
                aFMASignals.osVersion = zzW();
                zza(1, zzob);
            } catch (zza e) {
            }
            try {
                aFMASignals.afmaVersion = zzU();
                zza(2, zzob);
            } catch (zza e2) {
            }
            try {
                long longValue = zzV().longValue();
                aFMASignals.evtTime = Long.valueOf(longValue);
                if (startTime != 0) {
                    aFMASignals.uptSignal = Long.valueOf(longValue - startTime);
                    aFMASignals.usgSignal = Long.valueOf(startTime);
                }
                zza(25, zzob);
            } catch (zza e3) {
            }
            try {
                ArrayList<Long> zzi = zzi(context);
                aFMASignals.uwSignal = Long.valueOf(zzi.get(0).longValue());
                aFMASignals.uhSignal = Long.valueOf(zzi.get(1).longValue());
                zza(31, zzob);
            } catch (zza e4) {
            }
            try {
                aFMASignals.utzSignal = zzX();
                zza(33, zzob);
            } catch (zza e5) {
            }
            try {
                if (!zzog || !zzoh) {
                    aFMASignals.intSignal = zza(context, this.zznF);
                    zza(27, zzob);
                }
            } catch (zza e6) {
            }
            try {
                aFMASignals.cerSignal = zzb(context, this.zznF);
                zza(29, zzob);
            } catch (zza e7) {
            }
            try {
                int[] zzj = zzj(context);
                aFMASignals.btsSignal = Long.valueOf((long) zzj[0]);
                aFMASignals.btlSignal = Long.valueOf((long) zzj[1]);
                zza(5, zzob);
            } catch (zza e8) {
            }
            try {
                aFMASignals.ornSignal = Long.valueOf((long) zzk(context));
                zza(12, zzob);
            } catch (zza e9) {
            }
            try {
                aFMASignals.atvSignal = Long.valueOf((long) zzl(context));
                zza(3, zzob);
            } catch (zza e10) {
            }
            try {
                aFMASignals.vnmSignal = zzg(context);
                zza(34, zzob);
            } catch (zza e11) {
            }
            try {
                aFMASignals.vcdSignal = zzh(context);
                zza(35, zzob);
            } catch (zza e12) {
            }
            zzT();
        } catch (IOException e13) {
        }
        return aFMASignals;
    }

    /* access modifiers changed from: protected */
    public NanoAfmaSignals.AFMASignals zzd(Context context) {
        NanoAfmaSignals.AFMASignals aFMASignals = new NanoAfmaSignals.AFMASignals();
        zze(context);
        zzob = zzoc.nextInt();
        try {
            aFMASignals.afmaVersion = zzU();
        } catch (zza e) {
        }
        try {
            aFMASignals.osVersion = zzW();
        } catch (zza e2) {
        }
        try {
            aFMASignals.evtTime = zzV();
        } catch (zza e3) {
        }
        zza(0, zzob);
        try {
            ArrayList<Long> zza2 = zza(this.zznx, this.zznE);
            aFMASignals.tcxSignal = zza2.get(0);
            aFMASignals.tcySignal = zza2.get(1);
            if (zza2.get(2).longValue() >= 0) {
                aFMASignals.tctSignal = zza2.get(2);
            }
            aFMASignals.tcpSignal = zza2.get(3);
            aFMASignals.tcdSignal = zza2.get(4);
            zza(14, zzob);
        } catch (zza e4) {
        }
        try {
            if (this.zznz > 0) {
                aFMASignals.tcdnSignal = Long.valueOf(this.zznz);
            }
            if (this.zznA > 0) {
                aFMASignals.tcmSignal = Long.valueOf(this.zznA);
            }
            if (this.zznB > 0) {
                aFMASignals.tcuSignal = Long.valueOf(this.zznB);
            }
            if (this.zznC > 0) {
                aFMASignals.tccSignal = Long.valueOf(this.zznC);
            }
            try {
                int size = this.zzny.size() - 1;
                if (size > 0) {
                    aFMASignals.previousTouches = new NanoAfmaSignals.AFMASignals.TouchInfo[size];
                    for (int i = 0; i < size; i++) {
                        ArrayList<Long> zza3 = zza((MotionEvent) this.zzny.get(i), this.zznE);
                        NanoAfmaSignals.AFMASignals.TouchInfo touchInfo = new NanoAfmaSignals.AFMASignals.TouchInfo();
                        touchInfo.tcxSignal = zza3.get(0);
                        touchInfo.tcySignal = zza3.get(1);
                        aFMASignals.previousTouches[i] = touchInfo;
                    }
                }
            } catch (zza e5) {
                aFMASignals.previousTouches = null;
            }
            try {
                aFMASignals.vnmSignal = zzg(context);
            } catch (zza e6) {
            }
            try {
                aFMASignals.vcdSignal = zzh(context);
            } catch (zza e7) {
            }
            zzT();
        } catch (IOException e8) {
        }
        return aFMASignals;
    }
}
