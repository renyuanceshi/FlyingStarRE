package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlf;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlh extends zzlg {
    public static final List<String> zzYf = Collections.singletonList("email");
    private Class<?> zzYg;
    private Class<?> zzYh;
    private Object zzYi;
    private Object zzYj;

    public zzlh(Activity activity, List<String> list) {
        super(activity, zzYf, list);
    }

    public static void zzag(Context context) throws IllegalStateException {
        zzx.zzz(context);
        try {
            Class<?> cls = Class.forName("com.facebook.FacebookSdk");
            cls.getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke((Object) null, new Object[]{context.getApplicationContext(), 64206});
            Class<?> cls2 = Class.forName("com.facebook.login.LoginManager");
            cls2.getDeclaredMethod("logOut", new Class[0]).invoke(cls2.getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("AuthSignInClient", "Facebook logout error.", e);
            throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
        } catch (ClassNotFoundException e2) {
            try {
                Class<?> cls3 = Class.forName("com.facebook.Session");
                Object invoke = cls3.getDeclaredMethod("getActiveSession", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke != null) {
                    cls3.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(invoke, new Object[0]);
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
                Log.e("AuthSignInClient", "Facebook logout error.", e3);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void zznv() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (this.zzYj != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.zzYj, new Object[]{this.mActivity, new ArrayList(zzns())});
            return;
        }
        Class<?> cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.mActivity});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(zzns())});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{64206});
        Class<?> cls2 = Class.forName("com.facebook.Session");
        cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")}).invoke(newInstance, new Object[]{zznw()});
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mActivity});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke((Object) null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object zznw() throws ClassNotFoundException {
        final Class<?> cls = Class.forName("com.facebook.Session");
        Class<?> cls2 = Class.forName("com.facebook.Session$StatusCallback");
        ClassLoader classLoader = cls2.getClassLoader();
        AnonymousClass1 r3 = new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Class<?> cls = Class.forName("com.facebook.SessionState");
                Class<Exception>[] parameterTypes = method.getParameterTypes();
                if (!method.getName().equals("call") || parameterTypes.length != 3 || parameterTypes[0] != cls || parameterTypes[1] != cls || parameterTypes[2] != Exception.class) {
                    throw new ExceptionInInitializerError("Method not supported!");
                } else if (!((Boolean) cls.getDeclaredMethod("isOpened", new Class[0]).invoke(objArr[0], new Object[0])).booleanValue()) {
                    return null;
                } else {
                    zzlh.this.zznt().zzk(zzlh.this.zza(IdpTokenType.zzXA, (String) cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), zzlh.this.zznu()));
                    return null;
                }
            }
        };
        return Proxy.newProxyInstance(classLoader, new Class[]{cls2}, r3);
    }

    public void zza(zzlf.zza zza) {
        zzb((String) null, (String) null, (zzlf.zza) zzx.zzz(zza));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, zzlf.zza zza) {
        zzb((String) zzx.zzz(str), (String) null, (zzlf.zza) zzx.zzz(zza));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(String str, String str2, zzlf.zza zza) {
        zzb((String) zzx.zzz(str), (String) zzx.zzz(str2), (zzlf.zza) zzx.zzz(zza));
        try {
            zznv();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean zza(int i, int i2, Intent intent, zzlf.zza zza) {
        zzb(zza);
        if (i != 64206 && this.zzYg == null) {
            return false;
        }
        if (this.zzYg == null || this.zzYh == null || this.zzYi == null) {
            try {
                Class<?> cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke((Object) null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.mActivity, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                if (!((Boolean) this.zzYg.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                    return false;
                }
                return ((Boolean) this.zzYh.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.zzYi, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public zzd zzmU() {
        return zzd.FACEBOOK;
    }
}
