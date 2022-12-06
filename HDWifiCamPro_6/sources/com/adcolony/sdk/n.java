package com.adcolony.sdk;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class n {
    private final SQLiteDatabase a;
    private final n0 b;

    n(SQLiteDatabase sQLiteDatabase, n0 n0Var) {
        this.a = sQLiteDatabase;
        this.b = n0Var;
    }

    private void a(n0.a aVar, List<String> list) {
        a(aVar.f(), "manager_tmp_table");
        c(aVar);
        a("manager_tmp_table", aVar.f(), list);
        b("manager_tmp_table");
    }

    private void c(n0.c cVar, String str) {
        boolean z;
        ArrayList<String[]> c = c(cVar.b());
        if (cVar.a().length == c.size()) {
            z = false;
            for (int i = 0; i < cVar.a().length; i++) {
                if (!Objects.equals(cVar.a()[i], c.get(i)[2])) {
                    z = true;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            a(cVar.b());
            b(cVar, str);
        }
    }

    private void d(n0.a aVar) {
        List<n0.c> b2 = aVar.b();
        ArrayList<String> d = d(aVar.f());
        for (n0.c next : b2) {
            if (d.contains(next.b())) {
                c(next, aVar.f());
            } else {
                b(next, aVar.f());
            }
            d.remove(next.b());
        }
        Iterator<String> it = d.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void e(n0.a aVar) {
        boolean z;
        boolean z2;
        ArrayList<a> g = g(aVar.f());
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        boolean z4 = false;
        for (n0.b next : aVar.a()) {
            int size = g.size() - 1;
            while (true) {
                if (size < 0) {
                    z = false;
                    z2 = false;
                    break;
                }
                a aVar2 = g.get(size);
                if (Objects.equals(aVar2.a(), next.b())) {
                    arrayList.add(next.b());
                    boolean a2 = aVar2.a(next);
                    g.remove(size);
                    z2 = a2;
                    z = true;
                    break;
                }
                size--;
            }
            if (!z || !z2) {
                z4 = true;
            }
        }
        if (g.size() <= 0) {
            z3 = z4;
        }
        if (z3) {
            a(aVar, (List<String>) arrayList);
            b(aVar);
            return;
        }
        d(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int version = this.a.getVersion();
        this.a.beginTransaction();
        boolean z = false;
        try {
            List<n0.a> a2 = this.b.a();
            ArrayList<String> a3 = a();
            for (n0.a next : a2) {
                if (a3.contains(next.f())) {
                    e(next);
                } else {
                    c(next);
                    b(next);
                }
                a3.remove(next.f());
            }
            Iterator<String> it = a3.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            this.a.setVersion(this.b.b());
            this.a.setTransactionSuccessful();
            z = true;
            new e0.a().a("Success upgrading database from ").a(version).a(" to ").a(this.b.b()).a(e0.e);
        } catch (SQLException e) {
            new e0.a().a("Upgrading database from ").a(version).a(" to ").a(this.b.b()).a("caused: ").a(e.toString()).a(e0.g);
        } catch (Throwable th) {
            this.a.endTransaction();
            throw th;
        }
        this.a.endTransaction();
        return z;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> f(String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master  WHERE type='" + str + "' ORDER BY name", (String[]) null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            rawQuery.close();
            return arrayList;
        }
        do {
            arrayList.add(rawQuery.getString(0));
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<a> g(String str) {
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String[]> it = e("PRAGMA table_info(" + str + ")").iterator();
        while (it.hasNext()) {
            a a2 = a.a(it.next());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    static class a {
        private final String a;
        private final String b;
        private final String c;

        private a(String[] strArr) {
            this.a = strArr[1];
            this.b = strArr[2];
            this.c = strArr[4];
        }

        static a a(String[] strArr) {
            if (strArr.length >= 5) {
                return new a(strArr);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(n0.b bVar) {
            return Objects.equals(this.a, bVar.b()) && Objects.equals(this.b, bVar.c()) && Objects.equals(this.c, bVar.a());
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.a;
        }
    }

    private void a(String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        sQLiteDatabase.execSQL("DROP INDEX " + str);
    }

    private String a(n0.a aVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(aVar.f());
        sb.append(" (");
        for (int i = 0; i < aVar.a().size(); i++) {
            n0.b bVar = aVar.a().get(i);
            sb.append(bVar.b());
            sb.append(" ");
            sb.append(bVar.c());
            if (bVar.a() != null) {
                if (bVar.a() instanceof Boolean) {
                    str = ((Boolean) bVar.a()).booleanValue() ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL;
                } else if (bVar.a() instanceof String) {
                    str = "'" + bVar.a() + "'";
                } else {
                    str = bVar.a().toString();
                }
                sb.append(" DEFAULT ");
                sb.append(str);
            }
            if (i < aVar.a().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> d(String str) {
        ArrayList<String[]> e = e("PRAGMA index_list(" + str + ")");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String[]> it = e.iterator();
        while (it.hasNext()) {
            String[] next = it.next();
            if (next.length >= 3) {
                arrayList.add(next[1]);
            }
        }
        return arrayList;
    }

    private void c(n0.a aVar) {
        this.a.execSQL(a(aVar));
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String[]> c(String str) {
        return e("PRAGMA index_info(" + str + ")");
    }

    private String a(n0.c cVar, String str) {
        String join = TextUtils.join(", ", cVar.a());
        return "CREATE INDEX " + cVar.b() + " ON " + str + "(" + join + ")";
    }

    private void a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase = this.a;
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " RENAME TO " + str2);
    }

    private void a(String str, String str2, List<String> list) {
        String join = TextUtils.join(", ", list);
        SQLiteDatabase sQLiteDatabase = this.a;
        sQLiteDatabase.execSQL("INSERT INTO " + str2 + " (" + join + ") SELECT " + join + " FROM " + str);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String[]> e(String str) {
        Cursor rawQuery = this.a.rawQuery(str, (String[]) null);
        ArrayList<String[]> arrayList = new ArrayList<>();
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            rawQuery.close();
            return arrayList;
        }
        do {
            int columnCount = rawQuery.getColumnCount();
            String[] strArr = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {
                strArr[i] = rawQuery.getString(i);
            }
            arrayList.add(strArr);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> a() {
        ArrayList<String> f = f("table");
        for (int size = f.size() - 1; size >= 0; size--) {
            String str = f.get(size);
            if (str.startsWith("android_") || str.startsWith("sqlite_")) {
                f.remove(size);
            }
        }
        return f;
    }

    private void b(n0.a aVar) {
        for (n0.c b2 : aVar.b()) {
            b(b2, aVar.f());
        }
    }

    private void b(n0.c cVar, String str) {
        this.a.execSQL(a(cVar, str));
    }

    private void b(String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        sQLiteDatabase.execSQL("DROP TABLE " + str);
    }
}
