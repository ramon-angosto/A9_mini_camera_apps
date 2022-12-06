package com.mbridge.msdk.foundation.db;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: BaseDao */
public class a<T> {
    protected f mHelper = null;

    public a(f fVar) {
        this.mHelper = fVar;
    }

    /* access modifiers changed from: protected */
    public synchronized SQLiteDatabase getReadableDatabase() {
        return this.mHelper.a();
    }

    /* access modifiers changed from: protected */
    public synchronized SQLiteDatabase getWritableDatabase() {
        return this.mHelper.b();
    }
}
