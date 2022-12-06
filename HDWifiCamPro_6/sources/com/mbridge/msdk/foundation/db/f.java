package com.mbridge.msdk.foundation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: CommonAbsDBHelper */
public abstract class f {
    private a a;

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase);

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void b(SQLiteDatabase sQLiteDatabase, int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public abstract int d();

    public f(Context context) {
        this.a = new a(context, c(), d());
    }

    public final SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.database.sqlite.SQLiteDatabase b() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            com.mbridge.msdk.foundation.db.f$a r1 = r2.a     // Catch:{ Exception -> 0x000c, all -> 0x0009 }
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x000c, all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x000c:
            monitor-exit(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.f.b():android.database.sqlite.SQLiteDatabase");
    }

    /* compiled from: CommonAbsDBHelper */
    private class a extends SQLiteOpenHelper {
        public a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            f.this.a(sQLiteDatabase);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            f.this.a(sQLiteDatabase, i, i2);
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            f.this.b(sQLiteDatabase, i, i2);
        }
    }
}
