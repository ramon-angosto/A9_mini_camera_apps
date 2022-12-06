package com.bytedance.sdk.component.e.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: DBHelper */
class b {
    /* access modifiers changed from: private */
    public static final Object c = new Object();
    private C0033b a;
    private Context b;

    b(Context context) {
        try {
            this.b = context.getApplicationContext();
            if (this.a == null) {
                this.a = new C0033b();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: com.bytedance.sdk.component.e.a.a.a.b$b  reason: collision with other inner class name */
    /* compiled from: DBHelper */
    public class C0033b {
        private volatile SQLiteDatabase b = null;

        public C0033b() {
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
        private synchronized void a() {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object r0 = com.bytedance.sdk.component.e.a.a.a.b.c     // Catch:{ all -> 0x0038 }
                monitor-enter(r0)     // Catch:{ all -> 0x0038 }
                android.database.sqlite.SQLiteDatabase r1 = r3.b     // Catch:{ all -> 0x0035 }
                if (r1 == 0) goto L_0x0012
                android.database.sqlite.SQLiteDatabase r1 = r3.b     // Catch:{ all -> 0x0035 }
                boolean r1 = r1.isOpen()     // Catch:{ all -> 0x0035 }
                if (r1 != 0) goto L_0x0033
            L_0x0012:
                com.bytedance.sdk.component.e.a.i r1 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x0035 }
                com.bytedance.sdk.component.e.a.a.e r1 = r1.b()     // Catch:{ all -> 0x0035 }
                com.bytedance.sdk.component.e.a.i r2 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x0035 }
                android.content.Context r2 = r2.d()     // Catch:{ all -> 0x0035 }
                android.database.sqlite.SQLiteDatabase r1 = r1.a(r2)     // Catch:{ all -> 0x0035 }
                r3.b = r1     // Catch:{ all -> 0x0035 }
                android.database.sqlite.SQLiteDatabase r1 = r3.b     // Catch:{ all -> 0x0035 }
                r2 = 0
                r1.setLockingEnabled(r2)     // Catch:{ all -> 0x0035 }
                java.lang.String r1 = "---------------DB CREATE  SUCCESS------------"
                com.bytedance.sdk.component.e.a.c.c.a(r1)     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                goto L_0x0042
            L_0x0035:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                throw r1     // Catch:{ all -> 0x0038 }
            L_0x0038:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x0045 }
                boolean r1 = r3.b()     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0044
            L_0x0042:
                monitor-exit(r3)
                return
            L_0x0044:
                throw r0     // Catch:{ all -> 0x0045 }
            L_0x0045:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.a.a.b.C0033b.a():void");
        }

        public synchronized void a(String str) throws SQLException {
            try {
                a();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (b()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                a();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                a aVar = new a();
                if (!b()) {
                    cursor = aVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                a();
                i = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
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
                a();
                j = this.b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
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
                a();
                i = this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!b()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        private synchronized boolean b() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    public C0033b a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class a extends AbstractCursor {
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

        private a() {
        }
    }
}
