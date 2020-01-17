package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;
import java.util.Iterator;

public class PreviewActivity extends Activity {
    public static final String ACTION_PREVIEW = "com.google.android.gms.appinvite.ACTION_PREVIEW";
    public static final String EXTRA_LAYOUT_RES_ID = "com.google.android.gms.appinvite.LAYOUT_RES_ID";
    public static final String EXTRA_TABS = "com.google.android.gms.appinvite.TABS";
    public static final String EXTRA_VIEWS = "com.google.android.gms.appinvite.VIEWS";
    public static final String KEY_TAB_CONTENT_ID = "tabContentId";
    public static final String KEY_TAB_TAG = "tabTag";
    public static final String KEY_TEXT_VIEW_IS_TITLE = "TextView_isTitle";
    public static final String KEY_TEXT_VIEW_TEXT = "TextView_text";
    public static final String KEY_TEXT_VIEW_TEXT_COLOR = "TextView_textColor";
    public static final String KEY_VIEW_BACKGROUND_COLOR = "View_backgroundColor";
    public static final String KEY_VIEW_ID = "View_id";
    public static final String KEY_VIEW_MIN_HEIGHT = "View_minHeight";
    public static final String KEY_VIEW_ON_CLICK_LISTENER = "View_onClickListener";
    public static final String KEY_WEB_VIEW_DATA = "WebView_data";
    public static final String ON_CLICK_LISTENER_CLOSE = "close";

    private View zza(Context context, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(context).inflate(bundle.getInt(EXTRA_LAYOUT_RES_ID), viewGroup, false);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(EXTRA_VIEWS);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                zza(inflate, (Bundle) it.next());
            }
        }
        return inflate;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(android.view.View r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r4 = 0
            r3 = -1
            java.lang.String r0 = "View_id"
            int r0 = r10.getInt(r0)
            android.view.View r2 = r9.findViewById(r0)
            java.util.Set r0 = r10.keySet()
            java.util.Iterator r5 = r0.iterator()
        L_0x0014:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00fd
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r0.hashCode()
            switch(r1) {
                case -1829808865: goto L_0x003e;
                case -499175494: goto L_0x0052;
                case -111184848: goto L_0x0070;
                case 573559753: goto L_0x005c;
                case 966644059: goto L_0x0034;
                case 1729346977: goto L_0x0066;
                case 1920443715: goto L_0x0048;
                default: goto L_0x0027;
            }
        L_0x0027:
            r1 = r3
        L_0x0028:
            switch(r1) {
                case 0: goto L_0x002c;
                case 1: goto L_0x007a;
                case 2: goto L_0x0082;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00dc;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0014
        L_0x002c:
            int r0 = r10.getInt(r0)
            r2.setBackgroundColor(r0)
            goto L_0x0014
        L_0x0034:
            java.lang.String r1 = "View_backgroundColor"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = r4
            goto L_0x0028
        L_0x003e:
            java.lang.String r1 = "View_minHeight"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0048:
            java.lang.String r1 = "View_onClickListener"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 2
            goto L_0x0028
        L_0x0052:
            java.lang.String r1 = "TextView_text"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 3
            goto L_0x0028
        L_0x005c:
            java.lang.String r1 = "TextView_textColor"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0066:
            java.lang.String r1 = "TextView_isTitle"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 5
            goto L_0x0028
        L_0x0070:
            java.lang.String r1 = "WebView_data"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0027
            r1 = 6
            goto L_0x0028
        L_0x007a:
            int r0 = r10.getInt(r0)
            r2.setMinimumHeight(r0)
            goto L_0x0014
        L_0x0082:
            java.lang.String r0 = r10.getString(r0)
            int r1 = r0.hashCode()
            switch(r1) {
                case 94756344: goto L_0x009c;
                default: goto L_0x008d;
            }
        L_0x008d:
            r0 = r3
        L_0x008e:
            switch(r0) {
                case 0: goto L_0x0092;
                default: goto L_0x0091;
            }
        L_0x0091:
            goto L_0x0014
        L_0x0092:
            com.google.android.gms.appinvite.PreviewActivity$1 r0 = new com.google.android.gms.appinvite.PreviewActivity$1
            r0.<init>()
            r2.setOnClickListener(r0)
            goto L_0x0014
        L_0x009c:
            java.lang.String r1 = "close"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x008d
            r0 = r4
            goto L_0x008e
        L_0x00a6:
            boolean r1 = r2 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0014
            r1 = r2
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r0 = r10.getCharSequence(r0)
            r1.setText(r0)
            goto L_0x0014
        L_0x00b6:
            boolean r1 = r2 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0014
            r1 = r2
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r0 = r10.getInt(r0)
            r1.setTextColor(r0)
            goto L_0x0014
        L_0x00c6:
            boolean r1 = r2 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0014
            boolean r0 = r10.getBoolean(r0)
            if (r0 == 0) goto L_0x0014
            r0 = r2
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r0 = r0.getText()
            r8.setTitle(r0)
            goto L_0x0014
        L_0x00dc:
            boolean r1 = r2 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0014
            android.webkit.WebView r1 = new android.webkit.WebView
            r1.<init>(r8)
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r6 = "text/html; charset=utf-8"
            java.lang.String r7 = "UTF-8"
            r1.loadData(r0, r6, r7)
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r6.<init>(r3, r3)
            r0.addView(r1, r6)
            goto L_0x0014
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.appinvite.PreviewActivity.zza(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getCallingActivity() == null || !"com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            finish();
            return;
        }
        try {
            Context createPackageContext = createPackageContext("com.google.android.gms", 0);
            Bundle extras = getIntent().getExtras();
            View zza = zza(createPackageContext, (ViewGroup) null, extras);
            if (zza == null) {
                finish();
                return;
            }
            TabHost tabHost = (TabHost) zza.findViewById(16908306);
            TabWidget tabWidget = (TabWidget) zza.findViewById(16908307);
            ArrayList parcelableArrayList = extras.getParcelableArrayList(EXTRA_TABS);
            if (!(tabHost == null || tabWidget == null || parcelableArrayList == null)) {
                tabHost.setup();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    Bundle bundle2 = (Bundle) it.next();
                    TabHost.TabSpec newTabSpec = tabHost.newTabSpec(bundle2.getString(KEY_TAB_TAG));
                    newTabSpec.setContent(bundle2.getInt(KEY_TAB_CONTENT_ID));
                    newTabSpec.setIndicator(zza(createPackageContext, tabWidget, bundle2));
                    tabHost.addTab(newTabSpec);
                }
            }
            setContentView(zza);
        } catch (PackageManager.NameNotFoundException e) {
            finish();
        }
    }
}
