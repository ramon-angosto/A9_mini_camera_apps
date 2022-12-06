package com.adcolony.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class o {

    class a implements Runnable {
        final /* synthetic */ n0 a;
        final /* synthetic */ SQLiteDatabase b;
        final /* synthetic */ b c;
        final /* synthetic */ CountDownLatch d;

        a(n0 n0Var, SQLiteDatabase sQLiteDatabase, b bVar, CountDownLatch countDownLatch) {
            this.a = n0Var;
            this.b = sQLiteDatabase;
            this.c = bVar;
            this.d = countDownLatch;
        }

        public void run() {
            for (n0.a next : this.a.a()) {
                for (Map.Entry next2 : next.e().entrySet()) {
                    c a2 = o.a((String) next2.getValue(), this.b);
                    if (a2 != null) {
                        this.c.a(next.d(), (String) next2.getKey(), a2);
                    }
                }
            }
            o0.c().a(this.c);
            this.d.countDown();
        }
    }

    static class b {
        private final int a;
        private final Map<String, ArrayList<a>> b;

        static class a {
            private final String a;
            private final c b;

            /* synthetic */ a(String str, c cVar, a aVar) {
                this(str, cVar);
            }

            /* access modifiers changed from: package-private */
            public String a() {
                return this.a;
            }

            /* access modifiers changed from: package-private */
            public c b() {
                return this.b;
            }

            private a(String str, c cVar) {
                this.a = str;
                this.b = cVar;
            }
        }

        /* synthetic */ b(int i, a aVar) {
            this(i);
        }

        /* access modifiers changed from: package-private */
        public f1 b() {
            f1 b2 = c0.b();
            c0.b(b2, "version", a());
            for (Map.Entry next : this.b.entrySet()) {
                f1 b3 = c0.b();
                Iterator it = ((ArrayList) next.getValue()).iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    e1 a2 = c0.a();
                    for (String b4 : aVar.b().a((Character) ',')) {
                        a2.b(b4);
                    }
                    c0.a(b3, aVar.a(), a2);
                }
                c0.a(b2, (String) next.getKey(), b3);
            }
            return b2;
        }

        private b(int i) {
            this.b = new ConcurrentHashMap();
            this.a = i;
        }

        /* access modifiers changed from: private */
        public void a(String str, String str2, c cVar) {
            ArrayList arrayList;
            a aVar = new a(str2, cVar, (a) null);
            if (!this.b.containsKey(str) || (arrayList = this.b.get(str)) == null) {
                this.b.put(str, new ArrayList(Collections.singletonList(aVar)));
            } else {
                arrayList.add(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.a;
        }
    }

    static b a(n0 n0Var, SQLiteDatabase sQLiteDatabase, Executor executor, long j) {
        b bVar = new b(n0Var.b(), (a) null);
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            executor.execute(new a(n0Var, sQLiteDatabase, bVar, countDownLatch));
            if (j > 0) {
                countDownLatch.await(j, TimeUnit.MILLISECONDS);
            } else {
                countDownLatch.await();
            }
        } catch (InterruptedException | RejectedExecutionException e) {
            e0.a aVar = new e0.a();
            aVar.a("ADCDbReader.calculateFeatureVectors failed with: " + e.toString()).a(e0.i);
        }
        return bVar;
    }

    static class c {
        private final List<a> a = new ArrayList();
        private final List<ContentValues> b = new ArrayList();

        static class a {
            private final int a;
            /* access modifiers changed from: private */
            public final String b;
            /* access modifiers changed from: private */
            public final int c;

            /* synthetic */ a(int i, String str, int i2, a aVar) {
                this(i, str, i2);
            }

            /* access modifiers changed from: package-private */
            public int c() {
                return this.c;
            }

            private a(int i, String str, int i2) {
                this.a = i;
                this.b = str;
                this.c = i2;
            }

            /* access modifiers changed from: package-private */
            public int a() {
                return this.a;
            }

            /* access modifiers changed from: package-private */
            public String b() {
                return this.b;
            }
        }

        c() {
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            if (i < 0 || i >= this.a.size()) {
                return -1;
            }
            return this.a.get(i).c();
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                str = "\n";
                if (i >= this.a.size()) {
                    break;
                }
                sb.append(this.a.get(i).b);
                if (i != this.a.size() - 1) {
                    str = " | ";
                }
                sb.append(str);
                i++;
            }
            for (ContentValues next : this.b) {
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    sb.append(next.getAsString(a(i2)));
                    if (i2 == this.a.size() - 1) {
                        str2 = str;
                    } else {
                        str2 = " | ";
                    }
                    sb.append(str2);
                }
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(int i, String str, int i2) {
            this.a.add(new a(i, str, i2, (a) null));
        }

        /* access modifiers changed from: package-private */
        public String a(int i) {
            if (i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i).b();
        }

        /* access modifiers changed from: private */
        public void a(Cursor cursor) {
            ContentValues contentValues = new ContentValues();
            for (a next : this.a) {
                int a2 = next.c;
                if (a2 == 1) {
                    contentValues.put(next.b(), Long.valueOf(cursor.getLong(next.a())));
                } else if (a2 == 2) {
                    contentValues.put(next.b(), Double.valueOf(cursor.getDouble(next.a())));
                } else if (a2 != 4) {
                    contentValues.put(next.b(), cursor.getString(next.a()));
                } else {
                    contentValues.put(next.b(), cursor.getBlob(next.a()));
                }
            }
            this.b.add(contentValues);
        }

        /* access modifiers changed from: package-private */
        public String a(int i, Character ch) {
            if (i < 0 || i >= this.b.size()) {
                return null;
            }
            ContentValues contentValues = this.b.get(i);
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < this.a.size()) {
                if (b(i2) == 3) {
                    sb.append("\"");
                    sb.append(contentValues.get(a(i2)));
                    sb.append("\"");
                } else {
                    sb.append(contentValues.getAsString(a(i2)));
                }
                sb.append(i2 == this.a.size() + -1 ? "" : ch);
                i2++;
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public List<String> a(Character ch) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.b.size(); i++) {
                arrayList.add(a(i, ch));
            }
            return arrayList;
        }
    }

    static c a(String str, SQLiteDatabase sQLiteDatabase) {
        c cVar = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str, (String[]) null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        c cVar2 = new c();
                        int i = 0;
                        while (i < rawQuery.getColumnCount()) {
                            try {
                                cVar2.a(i, rawQuery.getColumnName(i), rawQuery.getType(i));
                                i++;
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                cVar = cVar2;
                                th = th2;
                                try {
                                    rawQuery.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th;
                            }
                        }
                        do {
                            cVar2.a(rawQuery);
                        } while (rawQuery.moveToNext());
                        cVar = cVar2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    rawQuery.close();
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (SQLException e) {
            new e0.a().a("SQLException on execute query: ").a(e.toString()).a(e0.i);
        } catch (Throwable th5) {
            new e0.a().a("Error on execute query: ").a(th5.toString()).a(e0.i);
        }
        return cVar;
    }
}
