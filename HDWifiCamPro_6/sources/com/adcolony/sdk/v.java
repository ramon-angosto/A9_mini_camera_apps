package com.adcolony.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.adcolony.sdk.o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

class v {
    private static v f;
    private final Executor a = Executors.newSingleThreadExecutor();
    private SQLiteDatabase b;
    private boolean c = false;
    private c d;
    private Set<String> e = new HashSet();

    class a implements Runnable {
        final /* synthetic */ f1 a;
        final /* synthetic */ x b;
        final /* synthetic */ Context c;

        a(f1 f1Var, x xVar, Context context) {
            this.a = f1Var;
            this.b = xVar;
            this.c = context;
        }

        public void run() {
            n0 a2 = n0.a(this.a);
            if (a2 != null) {
                v.this.a(a2, (x<n0>) this.b, this.c);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ ContentValues b;

        b(String str, ContentValues contentValues) {
            this.a = str;
            this.b = contentValues;
        }

        public void run() {
            v.this.b(this.a, this.b);
        }
    }

    interface c {
        void a();
    }

    v() {
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e.clear();
    }

    /* access modifiers changed from: private */
    public synchronized void b(String str, ContentValues contentValues) {
        p.a(str, contentValues, this.b);
    }

    public static v a() {
        if (f == null) {
            synchronized (v.class) {
                if (f == null) {
                    f = new v();
                }
            }
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.d = cVar;
    }

    /* access modifiers changed from: package-private */
    public void a(f1 f1Var, x<n0> xVar) {
        Context applicationContext = a.c() ? a.a().getApplicationContext() : null;
        if (applicationContext != null && f1Var != null) {
            try {
                this.a.execute(new a(f1Var, xVar, applicationContext));
            } catch (RejectedExecutionException e2) {
                e0.a aVar = new e0.a();
                aVar.a("ADCEventsRepository.open failed with: " + e2.toString()).a(e0.i);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(n0 n0Var, x<n0> xVar, Context context) {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                this.b = context.openOrCreateDatabase("adc_events_db", 0, (SQLiteDatabase.CursorFactory) null);
            }
            boolean z = true;
            if (this.b.needUpgrade(n0Var.b())) {
                if (!a(n0Var) || this.d == null) {
                    z = false;
                }
                this.c = z;
                if (z) {
                    this.d.a();
                }
            } else {
                this.c = true;
            }
            if (this.c) {
                xVar.a(n0Var);
            }
        } catch (SQLiteException e2) {
            new e0.a().a("Database cannot be opened").a(e2.toString()).a(e0.g);
        }
        return;
    }

    private boolean a(n0 n0Var) {
        return new n(this.b, n0Var).b();
    }

    /* access modifiers changed from: package-private */
    public void a(n0.a aVar, ContentValues contentValues) {
        String str;
        if (aVar != null && !this.e.contains(aVar.f())) {
            this.e.add(aVar.f());
            int c2 = aVar.c();
            long j = -1;
            n0.d g = aVar.g();
            if (g != null) {
                j = contentValues.getAsLong(g.a()).longValue() - g.b();
                str = g.a();
            } else {
                str = null;
            }
            p.a(c2, j, str, aVar.f(), this.b);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, ContentValues contentValues) {
        if (this.c) {
            try {
                this.a.execute(new b(str, contentValues));
            } catch (RejectedExecutionException e2) {
                e0.a aVar = new e0.a();
                aVar.a("ADCEventsRepository.saveEvent failed with: " + e2.toString()).a(e0.i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public o.b a(n0 n0Var, long j) {
        if (this.c) {
            return o.a(n0Var, this.b, this.a, j);
        }
        return null;
    }
}
