package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.k;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DBHelper */
class f {
    /* access modifiers changed from: private */
    public static final Object c = new Object();
    private c a;
    /* access modifiers changed from: private */
    public Context b;

    f(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = m.a();
            } catch (Throwable unused) {
                return;
            }
        } else {
            context2 = context.getApplicationContext();
        }
        this.b = context2;
        if (this.a == null) {
            this.a = new c();
        }
    }

    /* access modifiers changed from: private */
    public Context c() {
        Context context = this.b;
        return context == null ? m.a() : context;
    }

    /* compiled from: DBHelper */
    public class c {
        private SQLiteDatabase b = null;

        public c() {
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        private synchronized void e() {
            /*
                r4 = this;
                monitor-enter(r4)
                java.lang.Object r0 = com.bytedance.sdk.openadsdk.core.f.c     // Catch:{ all -> 0x0030 }
                monitor-enter(r0)     // Catch:{ all -> 0x0030 }
                android.database.sqlite.SQLiteDatabase r1 = r4.b     // Catch:{ all -> 0x002d }
                if (r1 == 0) goto L_0x0012
                android.database.sqlite.SQLiteDatabase r1 = r4.b     // Catch:{ all -> 0x002d }
                boolean r1 = r1.isOpen()     // Catch:{ all -> 0x002d }
                if (r1 != 0) goto L_0x002b
            L_0x0012:
                com.bytedance.sdk.openadsdk.core.f$a r1 = new com.bytedance.sdk.openadsdk.core.f$a     // Catch:{ all -> 0x002d }
                com.bytedance.sdk.openadsdk.core.f r2 = com.bytedance.sdk.openadsdk.core.f.this     // Catch:{ all -> 0x002d }
                com.bytedance.sdk.openadsdk.core.f r3 = com.bytedance.sdk.openadsdk.core.f.this     // Catch:{ all -> 0x002d }
                android.content.Context r3 = r3.c()     // Catch:{ all -> 0x002d }
                r1.<init>(r3)     // Catch:{ all -> 0x002d }
                android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x002d }
                r4.b = r1     // Catch:{ all -> 0x002d }
                android.database.sqlite.SQLiteDatabase r1 = r4.b     // Catch:{ all -> 0x002d }
                r2 = 0
                r1.setLockingEnabled(r2)     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                goto L_0x003a
            L_0x002d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r1     // Catch:{ all -> 0x0030 }
            L_0x0030:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x003d }
                boolean r1 = r4.f()     // Catch:{ all -> 0x003d }
                if (r1 != 0) goto L_0x003c
            L_0x003a:
                monitor-exit(r4)
                return
            L_0x003c:
                throw r0     // Catch:{ all -> 0x003d }
            L_0x003d:
                r0 = move-exception
                monitor-exit(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.f.c.e():void");
        }

        public SQLiteDatabase a() {
            e();
            return this.b;
        }

        public synchronized void a(String str) throws SQLException {
            try {
                e();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (f()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                e();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (!f()) {
                    cursor = bVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                e();
                i = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!f()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                e();
                j = this.b.replace(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!f()) {
                    j = -1;
                } else {
                    throw e;
                }
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i;
            try {
                e();
                i = this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!f()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized void b() {
            e();
            if (this.b != null) {
                this.b.beginTransaction();
            }
        }

        public synchronized void c() {
            e();
            if (this.b != null) {
                this.b.setTransactionSuccessful();
            }
        }

        public synchronized void d() {
            e();
            if (this.b != null) {
                this.b.endTransaction();
            }
        }

        private synchronized boolean f() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    /* compiled from: DBHelper */
    private class a extends SQLiteOpenHelper {
        final Context a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.a = context;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            l.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(d.a());
            sQLiteDatabase.execSQL(g.c());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.a());
            sQLiteDatabase.execSQL(k.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.k.b.a());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.a.b.a.c());
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                l.b("DBHelper", "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
                if (i > i2) {
                    b(sQLiteDatabase);
                    a(sQLiteDatabase, f.this.b);
                    l.b("DBHelper", "onUpgrade...Reverse installation. Database reset and create table.....");
                } else {
                    a(sQLiteDatabase, f.this.b);
                }
                switch (i) {
                    case 1:
                        l.b("DBHelper", "onUpgrade.....perform table creation.....");
                        a(sQLiteDatabase);
                        return;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        a(sQLiteDatabase);
                        return;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.a());
                        a(sQLiteDatabase);
                        return;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.a.b.a.c());
                        a(sQLiteDatabase);
                        return;
                    case 5:
                        sQLiteDatabase.execSQL(k.a());
                        a(sQLiteDatabase);
                        return;
                    case 6:
                        a(sQLiteDatabase);
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(d.b());
            sQLiteDatabase.execSQL(g.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.b());
            sQLiteDatabase.execSQL(k.b());
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> c = c(sQLiteDatabase);
            if (c != null && c.size() > 0) {
                Iterator<String> it = c.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", new Object[]{it.next()}));
                }
            }
        }

        private ArrayList<String> c(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", (String[]) null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        String string = rawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    rawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    public c a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class b extends AbstractCursor {
        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int i) {
            return 0.0d;
        }

        public float getFloat(int i) {
            return 0.0f;
        }

        public int getInt(int i) {
            return 0;
        }

        public long getLong(int i) {
            return 0;
        }

        public short getShort(int i) {
            return 0;
        }

        public String getString(int i) {
            return null;
        }

        public boolean isNull(int i) {
            return true;
        }

        private b() {
        }
    }
}
