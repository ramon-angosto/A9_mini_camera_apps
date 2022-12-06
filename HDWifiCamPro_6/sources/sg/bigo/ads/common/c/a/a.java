package sg.bigo.ads.common.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.c.a.c;
import sg.bigo.ads.common.utils.r;

public final class a {
    static c a;
    static AtomicBoolean b = new AtomicBoolean(false);
    static SQLiteDatabase c;

    /* renamed from: sg.bigo.ads.common.c.a.a$a  reason: collision with other inner class name */
    public interface C0121a {
        void a();

        void a(String str);
    }

    public static int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = c;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.update(str, contentValues, str2, strArr);
        } catch (SQLException unused) {
            sg.bigo.ads.common.k.a.a(0, "DbHelper", "Failed: ".concat(String.valueOf(contentValues)));
            return 0;
        }
    }

    public static long a(String str, ContentValues contentValues) {
        b();
        if (c == null || sg.bigo.ads.common.n.a.c()) {
            return 0;
        }
        return c.insert(str, (String) null, contentValues);
    }

    public static Cursor a(String str, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = c;
        if (sQLiteDatabase == null) {
            return null;
        }
        return sQLiteDatabase.query(str, (String[]) null, str2, strArr, (String) null, (String) null, (String) null);
    }

    public static Cursor a(String str, String str2, String[] strArr, String str3, int i) {
        b();
        SQLiteDatabase sQLiteDatabase = c;
        if (sQLiteDatabase == null) {
            return null;
        }
        return sQLiteDatabase.query(str, (String[]) null, str2, strArr, (String) null, (String) null, str3, Integer.toString(i));
    }

    public static SQLiteDatabase a() {
        return c;
    }

    public static void a(final Context context, final C0121a aVar) {
        c cVar = new c();
        a = cVar;
        c.a aVar2 = new c.a(new Runnable() {
            public final void run() {
                String str;
                sg.bigo.ads.common.k.a.a(0, 3, "DbHelper", "init start");
                try {
                    a.c = b.a(context).getWritableDatabase();
                    str = "";
                } catch (Throwable th) {
                    sg.bigo.ads.common.k.a.a(0, "DbHelper", "can't get db final," + th.getMessage());
                    a.c = null;
                }
                a.b.set(true);
                a.a = null;
                if (a.c != null) {
                    aVar.a();
                } else {
                    aVar.a(str);
                }
                sg.bigo.ads.common.k.a.a(0, 3, "DbHelper", "init end");
            }
        });
        Runnable runnable = aVar2.b;
        synchronized (cVar.b) {
            cVar.a.add(runnable);
        }
        cVar.c.execute(new Runnable(aVar2, runnable) {
            final /* synthetic */ a a;
            final /* synthetic */ Runnable b;

            {
                this.a = r2;
                this.b = r3;
            }

            public final void run() {
                this.a.run();
                this.b.run();
                synchronized (c.this.b) {
                    c.this.a.remove(this.b);
                }
            }
        });
    }

    public static int b(String str, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = c;
        if (sQLiteDatabase == null) {
            return 0;
        }
        return sQLiteDatabase.delete(str, str2, strArr);
    }

    public static long b(String str, ContentValues contentValues) {
        b();
        if (c == null || sg.bigo.ads.common.n.a.c()) {
            return 0;
        }
        return c.insertWithOnConflict(str, (String) null, contentValues, 5);
    }

    public static void b() {
        Runnable poll;
        c cVar = a;
        if (cVar != null && !b.get()) {
            while (true) {
                synchronized (cVar.b) {
                    poll = cVar.a.poll();
                }
                if (poll != null) {
                    poll.run();
                } else {
                    return;
                }
            }
            while (true) {
            }
        }
    }

    public static void c() {
        r.a();
    }
}
