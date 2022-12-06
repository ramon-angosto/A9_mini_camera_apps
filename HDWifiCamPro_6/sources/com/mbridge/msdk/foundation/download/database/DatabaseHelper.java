package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper implements IDatabaseHelper {
    /* access modifiers changed from: private */
    public volatile SQLiteDatabase database;
    /* access modifiers changed from: private */
    public IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    /* access modifiers changed from: private */
    public String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler2, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler2;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
            /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    java.lang.String r0 = " = '"
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r1 = r1.database
                    boolean r1 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r1)
                    if (r1 == 0) goto L_0x001b
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = r1.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r1.database = r2
                L_0x001b:
                    r1 = 0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.<init>()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = "SELECT * FROM "
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r3 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = r3.tableName     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = " WHERE "
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = "download_id"
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.append(r0)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = "' AND "
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r3 = "director_path"
                    r2.append(r3)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.append(r0)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    r2.append(r0)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r0 = "'"
                    r2.append(r0)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    android.database.sqlite.SQLiteDatabase r2 = r2.database     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0082, all -> 0x007f }
                    if (r0 == 0) goto L_0x0075
                    boolean r2 = r0.moveToFirst()     // Catch:{ Exception -> 0x0073 }
                    if (r2 == 0) goto L_0x0075
                    com.mbridge.msdk.foundation.download.database.DownloadModel r1 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0073 }
                    goto L_0x0075
                L_0x0073:
                    r2 = move-exception
                    goto L_0x0084
                L_0x0075:
                    if (r0 == 0) goto L_0x007a
                    r0.close()
                L_0x007a:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x0093
                    goto L_0x0090
                L_0x007f:
                    r2 = move-exception
                    r0 = r1
                    goto L_0x0095
                L_0x0082:
                    r2 = move-exception
                    r0 = r1
                L_0x0084:
                    r2.printStackTrace()     // Catch:{ all -> 0x0094 }
                    if (r0 == 0) goto L_0x008c
                    r0.close()
                L_0x008c:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x0093
                L_0x0090:
                    r0.onDatabase(r1)
                L_0x0093:
                    return
                L_0x0094:
                    r2 = move-exception
                L_0x0095:
                    if (r0 == 0) goto L_0x009a
                    r0.close()
                L_0x009a:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r5
                    if (r0 == 0) goto L_0x00a1
                    r0.onDatabase(r1)
                L_0x00a1:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass1.run():void");
            }
        });
    }

    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
            /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = r0.database
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    if (r0 == 0) goto L_0x0019
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r1 = r0.databaseOpenHelper
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()
                    android.database.sqlite.SQLiteDatabase unused = r0.database = r1
                L_0x0019:
                    r0 = 0
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    r1.<init>()     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = "SELECT * FROM "
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = r2.tableName     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = " WHERE "
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = "download_url"
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = " = '"
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = r3     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r2 = "'"
                    r1.append(r2)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    android.database.sqlite.SQLiteDatabase r2 = r2.database     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    android.database.Cursor r1 = r2.rawQuery(r1, r0)     // Catch:{ Exception -> 0x007c, all -> 0x006d }
                    if (r1 == 0) goto L_0x0063
                    boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x007d, all -> 0x0061 }
                    if (r2 == 0) goto L_0x0063
                    com.mbridge.msdk.foundation.download.database.DownloadModel r0 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r1)     // Catch:{ Exception -> 0x007d, all -> 0x0061 }
                    goto L_0x0063
                L_0x0061:
                    r2 = move-exception
                    goto L_0x006f
                L_0x0063:
                    if (r1 == 0) goto L_0x0068
                    r1.close()
                L_0x0068:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r1 = r4
                    if (r1 == 0) goto L_0x0089
                    goto L_0x0086
                L_0x006d:
                    r2 = move-exception
                    r1 = r0
                L_0x006f:
                    if (r1 == 0) goto L_0x0074
                    r1.close()
                L_0x0074:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r1 = r4
                    if (r1 == 0) goto L_0x007b
                    r1.onDatabase(r0)
                L_0x007b:
                    throw r2
                L_0x007c:
                    r1 = r0
                L_0x007d:
                    if (r1 == 0) goto L_0x0082
                    r1.close()
                L_0x0082:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r1 = r4
                    if (r1 == 0) goto L_0x0089
                L_0x0086:
                    r1.onDatabase(r0)
                L_0x0089:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass2.run():void");
            }
        });
    }

    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DatabaseHelper.this.database.beginTransaction();
                try {
                    DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, (String) null, DownloadModel.create(downloadModel));
                    DatabaseHelper.this.database.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    DatabaseHelper.this.database.endTransaction();
                    throw th;
                }
                DatabaseHelper.this.database.endTransaction();
            }
        });
    }

    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    SQLiteDatabase access$000 = DatabaseHelper.this.database;
                    access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "' AND " + DownloadModel.DIRECTORY_PATH + " = '" + str2 + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void remove(final String str) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    SQLiteDatabase access$000 = DatabaseHelper.this.database;
                    access$000.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        if (r1 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        if (r1 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.mbridge.msdk.foundation.download.database.DownloadModel> getUnwantedModels(long r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch:{ Exception -> 0x0060 }
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch:{ Exception -> 0x0060 }
            if (r2 == 0) goto L_0x0016
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = r5.databaseOpenHelper     // Catch:{ Exception -> 0x0060 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0060 }
            r5.database = r2     // Catch:{ Exception -> 0x0060 }
        L_0x0016:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0060 }
            long r2 = r2 - r6
            android.database.sqlite.SQLiteDatabase r6 = r5.database     // Catch:{ Exception -> 0x0060 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0060 }
            r7.<init>()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = "SELECT * FROM "
            r7.append(r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = r5.tableName     // Catch:{ Exception -> 0x0060 }
            r7.append(r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = " WHERE "
            r7.append(r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = "last_modified_time"
            r7.append(r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r4 = " <= "
            r7.append(r4)     // Catch:{ Exception -> 0x0060 }
            r7.append(r2)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0060 }
            android.database.Cursor r1 = r6.rawQuery(r7, r1)     // Catch:{ Exception -> 0x0060 }
            if (r1 == 0) goto L_0x005b
            boolean r6 = r1.moveToFirst()     // Catch:{ Exception -> 0x0060 }
            if (r6 == 0) goto L_0x005b
        L_0x004e:
            com.mbridge.msdk.foundation.download.database.DownloadModel r6 = com.mbridge.msdk.foundation.download.database.DownloadModel.create((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0060 }
            r0.add(r6)     // Catch:{ Exception -> 0x0060 }
            boolean r6 = r1.moveToNext()     // Catch:{ Exception -> 0x0060 }
            if (r6 != 0) goto L_0x004e
        L_0x005b:
            if (r1 == 0) goto L_0x0069
            goto L_0x0066
        L_0x005e:
            r6 = move-exception
            goto L_0x006a
        L_0x0060:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0069
        L_0x0066:
            r1.close()
        L_0x0069:
            return r0
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.getUnwantedModels(long):java.util.List");
    }

    public void updateUnzipResource(final String str, String str2, long j) {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                SQLiteDatabase access$000 = DatabaseHelper.this.database;
                String access$200 = DatabaseHelper.this.tableName;
                access$000.update(access$200, contentValues, "download_id = '" + str + "'", (String[]) null);
            }
        });
    }

    public Cursor rawQuery(String str, String[] strArr) {
        Cursor cursor;
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            this.database.beginTransaction();
            cursor = this.database.rawQuery(str, strArr);
            this.database.setTransactionSuccessful();
        } catch (Exception unused) {
            cursor = null;
        } catch (Throwable th) {
            this.database.endTransaction();
            throw th;
        }
        this.database.endTransaction();
        return cursor;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        ? r1 = 0;
        try {
            if (Objects.isNull(this.database)) {
                this.database = this.databaseOpenHelper.getWritableDatabase();
            }
            Cursor rawQuery = rawQuery("SELECT * FROM " + this.tableName, r1);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    arrayList.add(DownloadModel.create(rawQuery));
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList;
        } catch (Exception unused) {
            return arrayList;
        } catch (Throwable unused2) {
            if (r1 != 0) {
                r1.close();
            }
            return arrayList;
        }
    }

    public void clear() {
        this.handler.post(new Runnable() {
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    SQLiteDatabase unused = databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                try {
                    DatabaseHelper.this.database.beginTransaction();
                    DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, (String) null, (String[]) null);
                    DatabaseHelper.this.database.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    DatabaseHelper.this.database.endTransaction();
                    throw th;
                }
                DatabaseHelper.this.database.endTransaction();
            }
        });
    }
}
