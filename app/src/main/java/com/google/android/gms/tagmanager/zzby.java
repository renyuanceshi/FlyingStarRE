package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.tagmanager.zzcx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class zzby implements zzau {
    /* access modifiers changed from: private */
    public static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    /* access modifiers changed from: private */
    public final Context mContext;
    private final zzb zzbjE;
    private volatile zzac zzbjF;
    private final zzav zzbjG;
    /* access modifiers changed from: private */
    public final String zzbjH;
    private long zzbjI;
    private final int zzbjJ;
    /* access modifiers changed from: private */
    public zzmq zzqW;

    class zza implements zzcx.zza {
        zza() {
        }

        public void zza(zzaq zzaq) {
            zzby.this.zzq(zzaq.zzGD());
        }

        public void zzb(zzaq zzaq) {
            zzby.this.zzq(zzaq.zzGD());
            zzbg.v("Permanent failure dispatching hitId: " + zzaq.zzGD());
        }

        public void zzc(zzaq zzaq) {
            long zzGE = zzaq.zzGE();
            if (zzGE == 0) {
                zzby.this.zzd(zzaq.zzGD(), zzby.this.zzqW.currentTimeMillis());
            } else if (zzGE + 14400000 < zzby.this.zzqW.currentTimeMillis()) {
                zzby.this.zzq(zzaq.zzGD());
                zzbg.v("Giving up on failed hitId: " + zzaq.zzGD());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private boolean zzbjL;
        private long zzbjM = 0;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(java.lang.String r11, android.database.sqlite.SQLiteDatabase r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r0 = 0
                r4[r0] = r11     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r12
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0045 }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x004d, all -> 0x004f }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r1 = r9
            L_0x0028:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
                r0.<init>()     // Catch:{ all -> 0x0051 }
                java.lang.String r2 = "Error querying for table "
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0051 }
                java.lang.StringBuilder r0 = r0.append(r11)     // Catch:{ all -> 0x0051 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0051 }
                com.google.android.gms.tagmanager.zzbg.zzaK(r0)     // Catch:{ all -> 0x0051 }
                if (r1 == 0) goto L_0x0043
                r1.close()
            L_0x0043:
                r0 = r8
                goto L_0x0025
            L_0x0045:
                r0 = move-exception
                r1 = r9
            L_0x0047:
                if (r1 == 0) goto L_0x004c
                r1.close()
            L_0x004c:
                throw r0
            L_0x004d:
                r0 = move-exception
                goto L_0x0028
            L_0x004f:
                r0 = move-exception
                goto L_0x0047
            L_0x0051:
                r0 = move-exception
                goto L_0x0047
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzb.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        /* JADX INFO: finally extract failed */
        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", (String[]) null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.zzbjL || this.zzbjM + 3600000 <= zzby.this.zzqW.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.zzbjL = true;
                this.zzbjM = zzby.this.zzqW.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    zzby.this.mContext.getDatabasePath(zzby.this.zzbjH).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.zzbjL = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzal.zzbo(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[]) null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (!zza("gtm_hits", sQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzby.zzQR);
            } else {
                zzc(sQLiteDatabase);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzby(zzav zzav, Context context) {
        this(zzav, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzav, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzbjH = str;
        this.zzbjG = zzav;
        this.zzqW = zzmt.zzsc();
        this.zzbjE = new zzb(this.mContext, this.zzbjH);
        this.zzbjF = new zzcx(this.mContext, new zza());
        this.zzbjI = 0;
        this.zzbjJ = i;
    }

    private void zzGQ() {
        int zzGR = (zzGR() - this.zzbjJ) + 1;
        if (zzGR > 0) {
            List<String> zzkl = zzkl(zzGR);
            zzbg.v("Store full, deleting " + zzkl.size() + " hits to make room.");
            zzf((String[]) zzkl.toArray(new String[0]));
        }
    }

    /* access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase zzgb = zzgb("Error opening database for getNumStoredHits.");
        if (zzgb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzgb.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                zzbg.zzaK("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
                zzq(j);
            }
        }
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbjE.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase zzgb = zzgb("Error opening database for putHit");
        if (zzgb != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", 0);
            try {
                zzgb.insert("gtm_hits", (String) null, contentValues);
                this.zzbjG.zzax(false);
            } catch (SQLiteException e) {
                zzbg.zzaK("Error storing hit");
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    public void dispatch() {
        zzbg.v("GTM Dispatch running...");
        if (this.zzbjF.zzGw()) {
            List<zzaq> zzkm = zzkm(40);
            if (zzkm.isEmpty()) {
                zzbg.v("...nothing to dispatch");
                this.zzbjG.zzax(true);
                return;
            }
            this.zzbjF.zzE(zzkm);
            if (zzGS() > 0) {
                zzcu.zzHo().dispatch();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int zzGR() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzgb = zzgb("Error opening database for getNumStoredHits.");
        if (zzgb != null) {
            try {
                Cursor rawQuery = zzgb.rawQuery("SELECT COUNT(*) from gtm_hits", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                zzbg.zzaK("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int zzGS() {
        /*
            r10 = this;
            r8 = 0
            r9 = 0
            java.lang.String r0 = "Error opening database for getNumStoredHits."
            android.database.sqlite.SQLiteDatabase r0 = r10.zzgb(r0)
            if (r0 != 0) goto L_0x000c
            r0 = r8
        L_0x000b:
            return r0
        L_0x000c:
            java.lang.String r1 = "gtm_hits"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            r3 = 1
            java.lang.String r4 = "hit_first_send_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            java.lang.String r3 = "hit_first_send_time=0"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x002f, all -> 0x003d }
            int r0 = r1.getCount()     // Catch:{ SQLiteException -> 0x0047, all -> 0x0049 }
            if (r1 == 0) goto L_0x000b
            r1.close()
            goto L_0x000b
        L_0x002f:
            r0 = move-exception
            r1 = r9
        L_0x0031:
            java.lang.String r0 = "Error getting num untried hits"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0045
            r1.close()
            r0 = r8
            goto L_0x000b
        L_0x003d:
            r0 = move-exception
            r1 = r9
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()
        L_0x0044:
            throw r0
        L_0x0045:
            r0 = r8
            goto L_0x000b
        L_0x0047:
            r0 = move-exception
            goto L_0x0031
        L_0x0049:
            r0 = move-exception
            goto L_0x003f
        L_0x004b:
            r0 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzGS():int");
    }

    /* access modifiers changed from: package-private */
    public void zzf(String[] strArr) {
        SQLiteDatabase zzgb;
        boolean z = false;
        if (strArr != null && strArr.length != 0 && (zzgb = zzgb("Error opening database for deleteHits.")) != null) {
            try {
                zzgb.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                zzav zzav = this.zzbjG;
                if (zzGR() == 0) {
                    z = true;
                }
                zzav.zzax(z);
            } catch (SQLiteException e) {
                zzbg.zzaK("Error deleting hits");
            }
        }
    }

    public void zzg(long j, String str) {
        zzjN();
        zzGQ();
        zzh(j, str);
    }

    /* access modifiers changed from: package-private */
    public int zzjN() {
        boolean z = false;
        long currentTimeMillis = this.zzqW.currentTimeMillis();
        if (currentTimeMillis > this.zzbjI + 86400000) {
            this.zzbjI = currentTimeMillis;
            SQLiteDatabase zzgb = zzgb("Error opening database for deleteStaleHits.");
            if (zzgb != null) {
                int delete = zzgb.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzqW.currentTimeMillis() - 2592000000L)});
                zzav zzav = this.zzbjG;
                if (zzGR() == 0) {
                    z = true;
                }
                zzav.zzax(z);
                return delete;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> zzkl(int r12) {
        /*
            r11 = this;
            r9 = 0
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            if (r12 > 0) goto L_0x000e
            java.lang.String r0 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)
        L_0x000d:
            return r10
        L_0x000e:
            java.lang.String r0 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r0 = r11.zzgb(r0)
            if (r0 == 0) goto L_0x000d
            java.lang.String r1 = "%s ASC"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r7 = java.lang.String.format(r1, r2)     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r8 = java.lang.Integer.toString(r12)     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r1 = "gtm_hits"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0085 }
            if (r1 == 0) goto L_0x0052
        L_0x0040:
            r1 = 0
            long r2 = r0.getLong(r1)     // Catch:{ SQLiteException -> 0x0085 }
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ SQLiteException -> 0x0085 }
            r10.add(r1)     // Catch:{ SQLiteException -> 0x0085 }
            boolean r1 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0085 }
            if (r1 != 0) goto L_0x0040
        L_0x0052:
            if (r0 == 0) goto L_0x000d
            r0.close()
            goto L_0x000d
        L_0x0058:
            r1 = move-exception
            r0 = r9
        L_0x005a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r2.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.tagmanager.zzbg.zzaK(r1)     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x000d
            r0.close()
            goto L_0x000d
        L_0x007a:
            r0 = move-exception
            r1 = r0
        L_0x007c:
            if (r9 == 0) goto L_0x0081
            r9.close()
        L_0x0081:
            throw r1
        L_0x0082:
            r1 = move-exception
            r9 = r0
            goto L_0x007c
        L_0x0085:
            r1 = move-exception
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzkl(int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e8, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f0, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0168, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0169, code lost:
        r3 = r2;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0177, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0177 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.tagmanager.zzaq> zzkm(int r17) {
        /*
            r16 = this;
            r15 = 1
            r14 = 0
            r13 = 0
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.lang.String r2 = "Error opening database for peekHits"
            r0 = r16
            android.database.sqlite.SQLiteDatabase r2 = r0.zzgb(r2)
            if (r2 != 0) goto L_0x0014
            r2 = r11
        L_0x0013:
            return r2
        L_0x0014:
            java.lang.String r3 = "%s ASC"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            r5 = 0
            java.lang.String r6 = "hit_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            java.lang.String r9 = java.lang.String.format(r3, r4)     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            java.lang.String r10 = java.lang.Integer.toString(r17)     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            java.lang.String r3 = "gtm_hits"
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            r5 = 0
            java.lang.String r6 = "hit_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            r5 = 1
            java.lang.String r6 = "hit_time"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            r5 = 2
            java.lang.String r6 = "hit_first_send_time"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00c9, all -> 0x017f }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0168, all -> 0x0177 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0168, all -> 0x0177 }
            boolean r3 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            if (r3 == 0) goto L_0x006a
        L_0x004d:
            com.google.android.gms.tagmanager.zzaq r3 = new com.google.android.gms.tagmanager.zzaq     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            r4 = 0
            long r4 = r13.getLong(r4)     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            r6 = 1
            long r6 = r13.getLong(r6)     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            r8 = 2
            long r8 = r13.getLong(r8)     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            r3.<init>(r4, r6, r8)     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            r12.add(r3)     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            boolean r3 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x016d, all -> 0x0177 }
            if (r3 != 0) goto L_0x004d
        L_0x006a:
            if (r13 == 0) goto L_0x006f
            r13.close()
        L_0x006f:
            java.lang.String r3 = "%s ASC"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            r5 = 0
            java.lang.String r6 = "hit_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            java.lang.String r9 = java.lang.String.format(r3, r4)     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            java.lang.String r10 = java.lang.Integer.toString(r17)     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            java.lang.String r3 = "gtm_hits"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            r5 = 0
            java.lang.String r6 = "hit_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            r5 = 1
            java.lang.String r6 = "hit_url"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0165, all -> 0x017c }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            if (r2 == 0) goto L_0x00c1
            r4 = r14
        L_0x009f:
            r0 = r3
            android.database.sqlite.SQLiteCursor r0 = (android.database.sqlite.SQLiteCursor) r0     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            r2 = r0
            android.database.CursorWindow r2 = r2.getWindow()     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            int r2 = r2.getNumRows()     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            if (r2 <= 0) goto L_0x00f4
            java.lang.Object r2 = r12.get(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            com.google.android.gms.tagmanager.zzaq r2 = (com.google.android.gms.tagmanager.zzaq) r2     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            r5 = 1
            java.lang.String r5 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            r2.zzgf(r5)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
        L_0x00bb:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            if (r2 != 0) goto L_0x0172
        L_0x00c1:
            if (r3 == 0) goto L_0x00c6
            r3.close()
        L_0x00c6:
            r2 = r12
            goto L_0x0013
        L_0x00c9:
            r2 = move-exception
            r3 = r2
            r2 = r11
        L_0x00cc:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r4.<init>()     // Catch:{ all -> 0x00ed }
            java.lang.String r5 = "Error in peekHits fetching hitIds: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00ed }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x00ed }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00ed }
            com.google.android.gms.tagmanager.zzbg.zzaK(r3)     // Catch:{ all -> 0x00ed }
            if (r13 == 0) goto L_0x0013
            r13.close()
            goto L_0x0013
        L_0x00ed:
            r2 = move-exception
        L_0x00ee:
            if (r13 == 0) goto L_0x00f3
            r13.close()
        L_0x00f3:
            throw r2
        L_0x00f4:
            java.lang.String r5 = "HitString for hitId %d too large.  Hit will be deleted."
            r2 = 1
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            r7 = 0
            java.lang.Object r2 = r12.get(r4)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            com.google.android.gms.tagmanager.zzaq r2 = (com.google.android.gms.tagmanager.zzaq) r2     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            long r8 = r2.zzGD()     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            java.lang.String r2 = java.lang.String.format(r5, r6)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            com.google.android.gms.tagmanager.zzbg.zzaK(r2)     // Catch:{ SQLiteException -> 0x0112, all -> 0x017a }
            goto L_0x00bb
        L_0x0112:
            r2 = move-exception
            r4 = r3
        L_0x0114:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r3.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r5 = "Error in peekHits fetching hit url: "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x015d }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x015d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.zzbg.zzaK(r2)     // Catch:{ all -> 0x015d }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x015d }
            r3.<init>()     // Catch:{ all -> 0x015d }
            java.util.Iterator r6 = r12.iterator()     // Catch:{ all -> 0x015d }
            r5 = r14
        L_0x0138:
            boolean r2 = r6.hasNext()     // Catch:{ all -> 0x015d }
            if (r2 == 0) goto L_0x0150
            java.lang.Object r2 = r6.next()     // Catch:{ all -> 0x015d }
            com.google.android.gms.tagmanager.zzaq r2 = (com.google.android.gms.tagmanager.zzaq) r2     // Catch:{ all -> 0x015d }
            java.lang.String r7 = r2.zzGF()     // Catch:{ all -> 0x015d }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x015d }
            if (r7 == 0) goto L_0x0159
            if (r5 == 0) goto L_0x0158
        L_0x0150:
            if (r4 == 0) goto L_0x0155
            r4.close()
        L_0x0155:
            r2 = r3
            goto L_0x0013
        L_0x0158:
            r5 = r15
        L_0x0159:
            r3.add(r2)     // Catch:{ all -> 0x015d }
            goto L_0x0138
        L_0x015d:
            r2 = move-exception
        L_0x015e:
            r3 = r4
        L_0x015f:
            if (r3 == 0) goto L_0x0164
            r3.close()
        L_0x0164:
            throw r2
        L_0x0165:
            r2 = move-exception
            r4 = r13
            goto L_0x0114
        L_0x0168:
            r2 = move-exception
            r3 = r2
            r2 = r11
            goto L_0x00cc
        L_0x016d:
            r2 = move-exception
            r3 = r2
            r2 = r12
            goto L_0x00cc
        L_0x0172:
            int r2 = r4 + 1
            r4 = r2
            goto L_0x009f
        L_0x0177:
            r2 = move-exception
            goto L_0x00ee
        L_0x017a:
            r2 = move-exception
            goto L_0x015f
        L_0x017c:
            r2 = move-exception
            r4 = r13
            goto L_0x015e
        L_0x017f:
            r2 = move-exception
            goto L_0x00ee
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzby.zzkm(int):java.util.List");
    }
}
