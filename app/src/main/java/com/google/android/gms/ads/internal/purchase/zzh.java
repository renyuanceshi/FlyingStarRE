package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.Locale;

@zzhb
public class zzh {
    /* access modifiers changed from: private */
    public static final String zzFV = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    private static zzh zzFX;
    private static final Object zzpV = new Object();
    private final zza zzFW;

    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(zzh.zzFV);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            zzin.zzaJ("Database updated from version " + i + " to version " + i2);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(sQLiteDatabase);
        }
    }

    zzh(Context context) {
        this.zzFW = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh zzy(Context context) {
        zzh zzh;
        synchronized (zzpV) {
            if (zzFX == null) {
                zzFX = new zzh(context);
            }
            zzh = zzFX;
        }
        return zzh;
    }

    public int getRecordCount() {
        int i = 0;
        Cursor cursor = null;
        synchronized (zzpV) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    Cursor rawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", (String[]) null);
                    if (rawQuery.moveToFirst()) {
                        i = rawQuery.getInt(0);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } else if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzin.zzaK("Error getting record count" + e.getMessage());
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
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzFW.getWritableDatabase();
        } catch (SQLiteException e) {
            zzin.zzaK("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void zza(zzf zzf) {
        if (zzf != null) {
            synchronized (zzpV) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.delete("InAppPurchase", String.format(Locale.US, "%s = %d", new Object[]{"purchase_id", Long.valueOf(zzf.zzFP)}), (String[]) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzb(com.google.android.gms.ads.internal.purchase.zzf r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.Object r1 = zzpV
            monitor-enter(r1)
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            goto L_0x0002
        L_0x000e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            throw r0
        L_0x0011:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x000e }
            r2.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "product_id"
            java.lang.String r4 = r7.zzFR     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "developer_payload"
            java.lang.String r4 = r7.zzFQ     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "record_time"
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x000e }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x000e }
            r2.put(r3, r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "InAppPurchase"
            r4 = 0
            long r2 = r0.insert(r3, r4, r2)     // Catch:{ all -> 0x000e }
            r7.zzFP = r2     // Catch:{ all -> 0x000e }
            int r0 = r6.getRecordCount()     // Catch:{ all -> 0x000e }
            long r2 = (long) r0     // Catch:{ all -> 0x000e }
            r4 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0048
            r6.zzfY()     // Catch:{ all -> 0x000e }
        L_0x0048:
            monitor-exit(r1)     // Catch:{ all -> 0x000e }
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzb(com.google.android.gms.ads.internal.purchase.zzf):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzfY() {
        /*
            r11 = this;
            r9 = 0
            java.lang.Object r10 = zzpV
            monitor-enter(r10)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x000c
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
        L_0x000b:
            return
        L_0x000c:
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "record_time ASC"
            java.lang.String r8 = "1"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0034, all -> 0x0060 }
            if (r1 == 0) goto L_0x002a
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x005e }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.ads.internal.purchase.zzf r0 = r11.zza((android.database.Cursor) r1)     // Catch:{ SQLiteException -> 0x005e }
            r11.zza((com.google.android.gms.ads.internal.purchase.zzf) r0)     // Catch:{ SQLiteException -> 0x005e }
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
            goto L_0x000b
        L_0x0031:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0031 }
            throw r0
        L_0x0034:
            r0 = move-exception
            r1 = r9
        L_0x0036:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r2.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "Error remove oldest record"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0056 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0056 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0056 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0056 }
            com.google.android.gms.internal.zzin.zzaK(r0)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x0031 }
            goto L_0x002f
        L_0x0056:
            r0 = move-exception
            r9 = r1
        L_0x0058:
            if (r9 == 0) goto L_0x005d
            r9.close()     // Catch:{ all -> 0x0031 }
        L_0x005d:
            throw r0     // Catch:{ all -> 0x0031 }
        L_0x005e:
            r0 = move-exception
            goto L_0x0036
        L_0x0060:
            r0 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzfY():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[Catch:{ all -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.ads.internal.purchase.zzf> zzg(long r14) {
        /*
            r13 = this;
            r9 = 0
            java.lang.Object r10 = zzpV
            monitor-enter(r10)
            java.util.LinkedList r11 = new java.util.LinkedList     // Catch:{ all -> 0x0019 }
            r11.<init>()     // Catch:{ all -> 0x0019 }
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            monitor-exit(r10)     // Catch:{ all -> 0x0019 }
        L_0x0010:
            return r11
        L_0x0011:
            android.database.sqlite.SQLiteDatabase r0 = r13.getWritableDatabase()     // Catch:{ all -> 0x0019 }
            if (r0 != 0) goto L_0x001c
            monitor-exit(r10)     // Catch:{ all -> 0x0019 }
            goto L_0x0010
        L_0x0019:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0019 }
            throw r0
        L_0x001c:
            java.lang.String r1 = "InAppPurchase"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "record_time ASC"
            java.lang.String r8 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x0047, all -> 0x0073 }
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0047, all -> 0x0073 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0071 }
            if (r0 == 0) goto L_0x0040
        L_0x0033:
            com.google.android.gms.ads.internal.purchase.zzf r0 = r13.zza((android.database.Cursor) r1)     // Catch:{ SQLiteException -> 0x0071 }
            r11.add(r0)     // Catch:{ SQLiteException -> 0x0071 }
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0071 }
            if (r0 != 0) goto L_0x0033
        L_0x0040:
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ all -> 0x0019 }
        L_0x0045:
            monitor-exit(r10)     // Catch:{ all -> 0x0019 }
            goto L_0x0010
        L_0x0047:
            r0 = move-exception
            r1 = r9
        L_0x0049:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r2.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r3 = "Error extracing purchase info: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.zzin.zzaK(r0)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ all -> 0x0019 }
            goto L_0x0045
        L_0x0069:
            r0 = move-exception
            r9 = r1
        L_0x006b:
            if (r9 == 0) goto L_0x0070
            r9.close()     // Catch:{ all -> 0x0019 }
        L_0x0070:
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x0071:
            r0 = move-exception
            goto L_0x0049
        L_0x0073:
            r0 = move-exception
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.zzh.zzg(long):java.util.List");
    }
}
