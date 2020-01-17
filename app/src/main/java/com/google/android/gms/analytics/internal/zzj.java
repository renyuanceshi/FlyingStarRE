package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmz;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zzj extends zzd implements Closeable {
    /* access modifiers changed from: private */
    public static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzQS = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zza zzQT;
    private final zzaj zzQU = new zzaj(zzjl());
    /* access modifiers changed from: private */
    public final zzaj zzQV = new zzaj(zzjl());

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase) {
            boolean z = true;
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            for (String str : new String[]{"hit_id", "hit_string", "hit_time", "hit_url"}) {
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database hits2 is missing required column: " + str);
                }
            }
            if (zzb.remove("hit_app_id")) {
                z = false;
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z) {
                sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0040 }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x0040 }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x0040 }
                r0 = 0
                r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x0040 }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0040 }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r1 = r9
            L_0x0028:
                com.google.android.gms.analytics.internal.zzj r2 = com.google.android.gms.analytics.internal.zzj.this     // Catch:{ all -> 0x0036 }
                java.lang.String r3 = "Error querying for table"
                r2.zzc(r3, r12, r0)     // Catch:{ all -> 0x0036 }
                if (r1 == 0) goto L_0x0034
                r1.close()
            L_0x0034:
                r0 = r8
                goto L_0x0025
            L_0x0036:
                r0 = move-exception
                r9 = r1
            L_0x0038:
                if (r9 == 0) goto L_0x003d
                r9.close()
            L_0x003d:
                throw r0
            L_0x003e:
                r0 = move-exception
                goto L_0x0028
            L_0x0040:
                r0 = move-exception
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zza.zza(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", (String[]) null);
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        private void zzb(SQLiteDatabase sQLiteDatabase) {
            Set<String> zzb = zzb(sQLiteDatabase, "properties");
            for (String str : new String[]{"app_uid", "cid", "tid", "params", "adid", "hits_count"}) {
                if (!zzb.remove(str)) {
                    throw new SQLiteException("Database properties is missing required column: " + str);
                }
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!zzj.this.zzQV.zzv(3600000)) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzj.this.zzQV.start();
                zzj.this.zzbh("Opening the database failed, dropping the table and recreating it");
                zzj.this.getContext().getDatabasePath(zzj.this.zzjQ()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zzj.this.zzQV.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zzj.this.zze("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzx.zzbo(sQLiteDatabase.getPath());
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
            if (!zza(sQLiteDatabase, "hits2")) {
                sQLiteDatabase.execSQL(zzj.zzQR);
            } else {
                zza(sQLiteDatabase);
            }
            if (!zza(sQLiteDatabase, "properties")) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            } else {
                zzb(sQLiteDatabase);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    zzj(zzf zzf) {
        super(zzf);
        this.zzQT = new zza(zzf.getContext(), zzjQ());
    }

    private static String zzI(Map<String, String> map) {
        zzx.zzz(map);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzd("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private String zzd(zzab zzab) {
        return zzab.zzlt() ? zzjn().zzkF() : zzjn().zzkG();
    }

    private static String zze(zzab zzab) {
        zzx.zzz(zzab);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : zzab.zzn().entrySet()) {
            String str = (String) next.getKey();
            if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str)) {
                builder.appendQueryParameter(str, (String) next.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        return encodedQuery == null ? "" : encodedQuery;
    }

    private void zzjP() {
        int zzkP = zzjn().zzkP();
        long zzjG = zzjG();
        if (zzjG > ((long) (zzkP - 1))) {
            List<Long> zzo = zzo((zzjG - ((long) zzkP)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzo.size()));
            zzo(zzo);
        }
    }

    /* access modifiers changed from: private */
    public String zzjQ() {
        return !zzjn().zzkr() ? zzjn().zzkR() : zzjn().zzks() ? zzjn().zzkR() : zzjn().zzkS();
    }

    public void beginTransaction() {
        zzjv();
        getWritableDatabase().beginTransaction();
    }

    public void close() {
        try {
            this.zzQT.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    public void endTransaction() {
        zzjv();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzQT.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return zzjG() == 0;
    }

    public void setTransactionSuccessful() {
        zzjv();
        getWritableDatabase().setTransactionSuccessful();
    }

    public long zza(long j, String str, String str2) {
        zzx.zzcM(str);
        zzx.zzcM(str2);
        zzjv();
        zzjk();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0);
    }

    public void zza(long j, String str) {
        zzx.zzcM(str);
        zzjv();
        zzjk();
        int delete = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(j), str});
        if (delete > 0) {
            zza("Deleted property records", Integer.valueOf(delete));
        }
    }

    public void zzb(zzh zzh) {
        zzx.zzz(zzh);
        zzjv();
        zzjk();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String zzI = zzI(zzh.zzn());
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_uid", Long.valueOf(zzh.zzjD()));
        contentValues.put("cid", zzh.getClientId());
        contentValues.put("tid", zzh.zzjE());
        contentValues.put("adid", Integer.valueOf(zzh.zzjF() ? 1 : 0));
        contentValues.put("hits_count", Long.valueOf(zzh.zzjG()));
        contentValues.put("params", zzI);
        try {
            if (writableDatabase.insertWithOnConflict("properties", (String) null, contentValues, 5) == -1) {
                zzbh("Failed to insert/update a property (got -1)");
            }
        } catch (SQLiteException e) {
            zze("Error storing a property", e);
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzbi(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            return zzmz.zza(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzbj(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            return zzmz.zza(new URI("?" + str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public void zzc(zzab zzab) {
        zzx.zzz(zzab);
        zzjk();
        zzjv();
        String zze = zze(zzab);
        if (zze.length() > 8192) {
            zzjm().zza(zzab, "Hit length exceeds the maximum allowed size");
            return;
        }
        zzjP();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", zze);
        contentValues.put("hit_time", Long.valueOf(zzab.zzlr()));
        contentValues.put("hit_app_id", Integer.valueOf(zzab.zzlp()));
        contentValues.put("hit_url", zzd(zzab));
        try {
            long insert = writableDatabase.insert("hits2", (String) null, contentValues);
            if (insert == -1) {
                zzbh("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzab);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    /* access modifiers changed from: protected */
    public void zziJ() {
    }

    public long zzjG() {
        zzjk();
        zzjv();
        return zzb("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    public void zzjL() {
        zzjk();
        zzjv();
        getWritableDatabase().delete("hits2", (String) null, (String[]) null);
    }

    public void zzjM() {
        zzjk();
        zzjv();
        getWritableDatabase().delete("properties", (String) null, (String[]) null);
    }

    public int zzjN() {
        zzjk();
        zzjv();
        if (!this.zzQU.zzv(86400000)) {
            return 0;
        }
        this.zzQU.start();
        zzbd("Deleting stale hits (if any)");
        int delete = getWritableDatabase().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzjl().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public long zzjO() {
        zzjk();
        zzjv();
        return zza(zzQS, (String[]) null, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Long> zzo(long r12) {
        /*
            r11 = this;
            r10 = 0
            r11.zzjk()
            r11.zzjv()
            r0 = 0
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0012
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0011:
            return r0
        L_0x0012:
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.String r1 = "%s ASC"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            java.lang.String r7 = java.lang.String.format(r1, r2)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            java.lang.String r8 = java.lang.Long.toString(r12)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            java.lang.String r1 = "hits2"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005e, all -> 0x006b }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 == 0) goto L_0x0057
        L_0x0045:
            r1 = 0
            long r2 = r0.getLong(r1)     // Catch:{ SQLiteException -> 0x0076 }
            java.lang.Long r1 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0076 }
            r9.add(r1)     // Catch:{ SQLiteException -> 0x0076 }
            boolean r1 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0076 }
            if (r1 != 0) goto L_0x0045
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()
        L_0x005c:
            r0 = r9
            goto L_0x0011
        L_0x005e:
            r1 = move-exception
            r0 = r10
        L_0x0060:
            java.lang.String r2 = "Error selecting hit ids"
            r11.zzd(r2, r1)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x005c
            r0.close()
            goto L_0x005c
        L_0x006b:
            r0 = move-exception
            r1 = r0
        L_0x006d:
            if (r10 == 0) goto L_0x0072
            r10.close()
        L_0x0072:
            throw r1
        L_0x0073:
            r1 = move-exception
            r10 = r0
            goto L_0x006d
        L_0x0076:
            r1 = move-exception
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzo(long):java.util.List");
    }

    public void zzo(List<Long> list) {
        zzx.zzz(list);
        zzjk();
        zzjv();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Long l = list.get(i2);
                    if (l != null && l.longValue() != 0) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        sb.append(l);
                        i = i2 + 1;
                    }
                } else {
                    sb.append(")");
                    String sb2 = sb.toString();
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                        int delete = writableDatabase.delete("hits2", sb2, (String[]) null);
                        if (delete != list.size()) {
                            zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                            return;
                        }
                        return;
                    } catch (SQLiteException e) {
                        zze("Error deleting hits", e);
                        throw e;
                    }
                }
            }
            throw new SQLiteException("Invalid hit id");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.zzab> zzp(long r12) {
        /*
            r11 = this;
            r1 = 1
            r0 = 0
            r9 = 0
            r2 = 0
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x000a
            r0 = r1
        L_0x000a:
            com.google.android.gms.common.internal.zzx.zzac(r0)
            r11.zzjk()
            r11.zzjv()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()
            java.lang.String r1 = "%s ASC"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            java.lang.String r7 = java.lang.String.format(r1, r2)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            java.lang.String r8 = java.lang.Long.toString(r12)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            java.lang.String r1 = "hits2"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 0
            java.lang.String r4 = "hit_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 1
            java.lang.String r4 = "hit_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 2
            java.lang.String r4 = "hit_string"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 3
            java.lang.String r4 = "hit_url"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 4
            java.lang.String r4 = "hit_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a5, all -> 0x009f }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r10.<init>()     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            if (r0 == 0) goto L_0x008a
        L_0x005a:
            r0 = 0
            long r6 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r0 = 1
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r0 = 2
            java.lang.String r0 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r1 = 3
            java.lang.String r1 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r2 = 4
            int r8 = r9.getInt(r2)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            java.util.Map r2 = r11.zzbi(r0)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            boolean r5 = com.google.android.gms.analytics.internal.zzam.zzbx(r1)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            com.google.android.gms.analytics.internal.zzab r0 = new com.google.android.gms.analytics.internal.zzab     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r1 = r11
            r0.<init>(r1, r2, r3, r5, r6, r8)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            r10.add(r0)     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0090, all -> 0x00a2 }
            if (r0 != 0) goto L_0x005a
        L_0x008a:
            if (r9 == 0) goto L_0x008f
            r9.close()
        L_0x008f:
            return r10
        L_0x0090:
            r0 = move-exception
        L_0x0091:
            java.lang.String r1 = "Error loading hits from the database"
            r11.zze(r1, r0)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x0097:
            r0 = move-exception
            r1 = r9
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            throw r0
        L_0x009f:
            r0 = move-exception
            r1 = r9
            goto L_0x0099
        L_0x00a2:
            r0 = move-exception
            r1 = r9
            goto L_0x0099
        L_0x00a5:
            r0 = move-exception
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzp(long):java.util.List");
    }

    public void zzq(long j) {
        zzjk();
        zzjv();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        zzo((List<Long>) arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.analytics.internal.zzh> zzr(long r14) {
        /*
            r13 = this;
            r13.zzjv()
            r13.zzjk()
            android.database.sqlite.SQLiteDatabase r0 = r13.getWritableDatabase()
            r9 = 0
            com.google.android.gms.analytics.internal.zzr r1 = r13.zzjn()     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            int r10 = r1.zzkQ()     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            java.lang.String r1 = "properties"
            r2 = 5
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r3 = 0
            java.lang.String r4 = "cid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r3 = 1
            java.lang.String r4 = "tid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r3 = 2
            java.lang.String r4 = "adid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r3 = 3
            java.lang.String r4 = "hits_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r3 = 4
            java.lang.String r4 = "params"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            java.lang.String r3 = "app_uid=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r5 = 0
            java.lang.String r6 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00b7, all -> 0x00ba }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r11.<init>()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 == 0) goto L_0x008b
        L_0x0053:
            r0 = 0
            java.lang.String r3 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r0 = 1
            java.lang.String r4 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r0 = 2
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 == 0) goto L_0x009c
            r5 = 1
        L_0x0065:
            r0 = 3
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r0 = 4
            java.lang.String r0 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            java.util.Map r8 = r13.zzbj(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 != 0) goto L_0x0080
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 == 0) goto L_0x009e
        L_0x0080:
            java.lang.String r0 = "Read property with empty client id or tracker id"
            r13.zzc(r0, r3, r4)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
        L_0x0085:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 != 0) goto L_0x0053
        L_0x008b:
            int r0 = r11.size()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            if (r0 < r10) goto L_0x0096
            java.lang.String r0 = "Sending hits to too many properties. Campaign report might be incorrect"
            r13.zzbg(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
        L_0x0096:
            if (r9 == 0) goto L_0x009b
            r9.close()
        L_0x009b:
            return r11
        L_0x009c:
            r5 = 0
            goto L_0x0065
        L_0x009e:
            com.google.android.gms.analytics.internal.zzh r0 = new com.google.android.gms.analytics.internal.zzh     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r1 = r14
            r0.<init>(r1, r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            r11.add(r0)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x00bd }
            goto L_0x0085
        L_0x00a8:
            r0 = move-exception
        L_0x00a9:
            java.lang.String r1 = "Error loading hits from the database"
            r13.zze(r1, r0)     // Catch:{ all -> 0x00af }
            throw r0     // Catch:{ all -> 0x00af }
        L_0x00af:
            r0 = move-exception
            r1 = r9
        L_0x00b1:
            if (r1 == 0) goto L_0x00b6
            r1.close()
        L_0x00b6:
            throw r0
        L_0x00b7:
            r0 = move-exception
            r9 = 0
            goto L_0x00a9
        L_0x00ba:
            r0 = move-exception
            r1 = r9
            goto L_0x00b1
        L_0x00bd:
            r0 = move-exception
            r1 = r9
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzj.zzr(long):java.util.List");
    }
}
