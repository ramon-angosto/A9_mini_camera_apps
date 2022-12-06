package com.apm.insight.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.e.b.b;
import com.apm.insight.h;
import com.apm.insight.l.q;

public class a {
    private static volatile a a;
    private b b;
    private SQLiteDatabase c;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private void b() {
        if (this.b == null) {
            a(h.g());
        }
    }

    public synchronized void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            q.b(th);
        }
        this.b = new b();
    }

    public synchronized void a(com.apm.insight.e.a.a aVar) {
        b();
        if (this.b != null) {
            this.b.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        b();
        if (this.b == null) {
            return false;
        }
        return this.b.a(this.c, str);
    }
}
