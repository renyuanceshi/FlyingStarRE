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
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzw implements DataLayer.zzc {
    /* access modifiers changed from: private */
    public static final String zzbiB = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Executor zzbiC;
    private zza zzbiD;
    private int zzbiE;
    private zzmq zzqW;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zza.zza(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
        }

        /* JADX INFO: finally extract failed */
        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", (String[]) null);
            HashSet hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (String add : columnNames) {
                    hashSet.add(add);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
            if (!zza("datalayer", sQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzw.zzbiB);
            } else {
                zzc(sQLiteDatabase);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class zzb {
        final byte[] zzbiK;
        final String zzvs;

        zzb(String str, byte[] bArr) {
            this.zzvs = str;
            this.zzbiK = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zzvs + " serialized hash = " + Arrays.hashCode(this.zzbiK);
        }
    }

    public zzw(Context context) {
        this(context, zzmt.zzsc(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzmq zzmq, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzqW = zzmq;
        this.zzbiE = i;
        this.zzbiC = executor;
        this.zzbiD = new zza(this.mContext, str);
    }

    private List<DataLayer.zza> zzC(List<zzb> list) {
        ArrayList arrayList = new ArrayList();
        for (zzb next : list) {
            arrayList.add(new DataLayer.zza(next.zzvs, zzw(next.zzbiK)));
        }
        return arrayList;
    }

    private List<zzb> zzD(List<DataLayer.zza> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza next : list) {
            arrayList.add(new zzb(next.zzvs, zzJ(next.zzNc)));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public List<DataLayer.zza> zzGr() {
        try {
            zzal(this.zzqW.currentTimeMillis());
            return zzC(zzGs());
        } finally {
            zzGu();
        }
    }

    private List<zzb> zzGs() {
        SQLiteDatabase zzgb = zzgb("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzgb != null) {
            Cursor query = zzgb.query("datalayer", new String[]{"key", "value"}, (String) null, (String[]) null, (String) null, (String) null, "ID", (String) null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
                } finally {
                    query.close();
                }
            }
        }
        return arrayList;
    }

    private int zzGt() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzgb = zzgb("Error opening database for getNumStoredEntries.");
        if (zzgb != null) {
            try {
                Cursor rawQuery = zzgb.rawQuery("SELECT COUNT(*) from datalayer", (String[]) null);
                if (rawQuery.moveToFirst()) {
                    i = (int) rawQuery.getLong(0);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e) {
                zzbg.zzaK("Error getting numStoredEntries");
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

    private void zzGu() {
        try {
            this.zzbiD.close();
        } catch (SQLiteException e) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC, Splitter:B:20:0x002d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] zzJ(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x001b, all -> 0x0028 }
            r1.writeObject(r6)     // Catch:{ IOException -> 0x003a, all -> 0x0034 }
            byte[] r0 = r4.toByteArray()     // Catch:{ IOException -> 0x003a, all -> 0x0034 }
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0017:
            r4.close()     // Catch:{ IOException -> 0x0038 }
        L_0x001a:
            return r0
        L_0x001b:
            r1 = move-exception
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0026 }
        L_0x0022:
            r4.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x001a
        L_0x0026:
            r1 = move-exception
            goto L_0x001a
        L_0x0028:
            r1 = move-exception
            r2 = r0
            r3 = r1
        L_0x002b:
            if (r2 == 0) goto L_0x0030
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x0030:
            r4.close()     // Catch:{ IOException -> 0x003c }
        L_0x0033:
            throw r3
        L_0x0034:
            r0 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x002b
        L_0x0038:
            r1 = move-exception
            goto L_0x001a
        L_0x003a:
            r2 = move-exception
            goto L_0x001d
        L_0x003c:
            r0 = move-exception
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzJ(java.lang.Object):byte[]");
    }

    private void zzal(long j) {
        SQLiteDatabase zzgb = zzgb("Error opening database for deleteOlderThan.");
        if (zzgb != null) {
            try {
                zzbg.v("Deleted " + zzgb.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbg.zzaK("Error deleting old entries.");
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzb(List<zzb> list, long j) {
        synchronized (this) {
            try {
                long currentTimeMillis = this.zzqW.currentTimeMillis();
                zzal(currentTimeMillis);
                zzkf(list.size());
                zzc(list, currentTimeMillis + j);
                zzGu();
            } catch (Throwable th) {
                zzGu();
                throw th;
            }
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzgb = zzgb("Error opening database for writeEntryToDatabase.");
        if (zzgb != null) {
            for (zzb next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", next.zzvs);
                contentValues.put("value", next.zzbiK);
                zzgb.insert("datalayer", (String) null, contentValues);
            }
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase zzgb;
        if (strArr != null && strArr.length != 0 && (zzgb = zzgb("Error opening database for deleteEntries.")) != null) {
            try {
                zzgb.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
            } catch (SQLiteException e) {
                zzbg.zzaK("Error deleting entries " + Arrays.toString(strArr));
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzga(String str) {
        SQLiteDatabase zzgb = zzgb("Error opening database for clearKeysWithPrefix.");
        if (zzgb != null) {
            try {
                zzbg.v("Cleared " + zzgb.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                zzbg.zzaK("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                zzGu();
            }
        }
    }

    private SQLiteDatabase zzgb(String str) {
        try {
            return this.zzbiD.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaK(str);
            return null;
        }
    }

    private void zzkf(int i) {
        int zzGt = (zzGt() - this.zzbiE) + i;
        if (zzGt > 0) {
            List<String> zzkg = zzkg(zzGt);
            zzbg.zzaJ("DataLayer store full, deleting " + zzkg.size() + " entries to make room.");
            zze((String[]) zzkg.toArray(new String[0]));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> zzkg(int r12) {
        /*
            r11 = this;
            r9 = 0
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            if (r12 > 0) goto L_0x000e
            java.lang.String r0 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzbg.zzaK(r0)
        L_0x000d:
            return r10
        L_0x000e:
            java.lang.String r0 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r0 = r11.zzgb(r0)
            if (r0 == 0) goto L_0x000d
            java.lang.String r1 = "%s ASC"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            r3 = 0
            java.lang.String r4 = "ID"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r7 = java.lang.String.format(r1, r2)     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r8 = java.lang.Integer.toString(r12)     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            java.lang.String r1 = "datalayer"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0058, all -> 0x007a }
            r3 = 0
            java.lang.String r4 = "ID"
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
            java.lang.String r3 = "Error in peekEntries fetching entryIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzkg(int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[SYNTHETIC, Splitter:B:20:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0037 A[SYNTHETIC, Splitter:B:27:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object zzw(byte[] r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
            r4.<init>(r6)
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0018, ClassNotFoundException -> 0x0025, all -> 0x0032 }
            java.lang.Object r0 = r1.readObject()     // Catch:{ IOException -> 0x0042, ClassNotFoundException -> 0x0044, all -> 0x003e }
            if (r1 == 0) goto L_0x0014
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0014:
            r4.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0017:
            return r0
        L_0x0018:
            r1 = move-exception
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x001f:
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0017
        L_0x0023:
            r1 = move-exception
            goto L_0x0017
        L_0x0025:
            r1 = move-exception
            r1 = r0
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x002c:
            r4.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0017
        L_0x0030:
            r1 = move-exception
            goto L_0x0017
        L_0x0032:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0035:
            if (r3 == 0) goto L_0x003a
            r3.close()     // Catch:{ IOException -> 0x0048 }
        L_0x003a:
            r4.close()     // Catch:{ IOException -> 0x0048 }
        L_0x003d:
            throw r2
        L_0x003e:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0035
        L_0x0042:
            r2 = move-exception
            goto L_0x001a
        L_0x0044:
            r2 = move-exception
            goto L_0x0027
        L_0x0046:
            r1 = move-exception
            goto L_0x0017
        L_0x0048:
            r0 = move-exception
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzw.zzw(byte[]):java.lang.Object");
    }

    public void zza(final DataLayer.zzc.zza zza2) {
        this.zzbiC.execute(new Runnable() {
            public void run() {
                zza2.zzB(zzw.this.zzGr());
            }
        });
    }

    public void zza(List<DataLayer.zza> list, final long j) {
        final List<zzb> zzD = zzD(list);
        this.zzbiC.execute(new Runnable() {
            public void run() {
                zzw.this.zzb(zzD, j);
            }
        });
    }

    public void zzfZ(final String str) {
        this.zzbiC.execute(new Runnable() {
            public void run() {
                zzw.this.zzga(str);
            }
        });
    }
}
