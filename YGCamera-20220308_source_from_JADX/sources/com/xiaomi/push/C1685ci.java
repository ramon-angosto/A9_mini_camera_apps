package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.service.C1995at;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.ci */
public class C1685ci {

    /* renamed from: a */
    private static volatile C1685ci f1919a;

    /* renamed from: a */
    private Context f1920a;

    /* renamed from: a */
    private C1684ch f1921a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ArrayList<C1686a> f1922a = new ArrayList<>();

    /* renamed from: a */
    private final HashMap<String, C1683cg> f1923a = new HashMap<>();

    /* renamed from: a */
    private ThreadPoolExecutor f1924a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: com.xiaomi.push.ci$a */
    public static abstract class C1686a implements Runnable {

        /* renamed from: a */
        private int f1925a = 0;

        /* renamed from: a */
        protected C1683cg f1926a = null;

        /* renamed from: a */
        private C1686a f1927a;

        /* renamed from: a */
        private String f1928a;

        /* renamed from: a */
        private WeakReference<Context> f1929a;

        /* renamed from: a */
        private Random f1930a = new Random();

        /* renamed from: b */
        protected String f1931b;

        public C1686a(String str) {
            this.f1928a = str;
        }

        /* renamed from: a */
        public SQLiteDatabase mo17307a() {
            return this.f1926a.getWritableDatabase();
        }

        /* renamed from: a */
        public Object m2847a() {
            return null;
        }

        /* renamed from: a */
        public String m2848a() {
            return this.f1928a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17316a(Context context) {
            C1686a aVar = this.f1927a;
            if (aVar != null) {
                aVar.mo17305a(context, mo17307a());
            }
            mo17320b(context);
        }

        /* renamed from: a */
        public abstract void mo17317a(Context context, SQLiteDatabase sQLiteDatabase);

        /* renamed from: a */
        public void mo17305a(Context context, Object obj) {
            C1685ci.m2838a(context).mo17312a(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17318a(C1683cg cgVar, Context context) {
            this.f1926a = cgVar;
            this.f1931b = this.f1926a.mo17309a();
            this.f1929a = new WeakReference<>(context);
        }

        /* renamed from: a */
        public void mo17319a(C1686a aVar) {
            this.f1927a = aVar;
        }

        /* renamed from: a */
        public boolean m2854a() {
            return this.f1926a == null || TextUtils.isEmpty(this.f1931b) || this.f1929a == null;
        }

        /* renamed from: b */
        public void mo17320b(Context context) {
        }

        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f1929a;
            if (weakReference != null && (context = (Context) weakReference.get()) != null && context.getFilesDir() != null && this.f1926a != null && !TextUtils.isEmpty(this.f1928a)) {
                File file = new File(this.f1928a);
                C2090x.m5386a(context, new File(file.getParentFile(), C1662bn.m2725b(file.getAbsolutePath())), new C1692ck(this, context));
            }
        }
    }

    /* renamed from: com.xiaomi.push.ci$b */
    public static abstract class C1687b<T> extends C1686a {

        /* renamed from: a */
        private int f1932a;

        /* renamed from: a */
        private String f1933a;

        /* renamed from: a */
        private List<String> f1934a;

        /* renamed from: a */
        private String[] f1935a;

        /* renamed from: b */
        private List<T> f1936b = new ArrayList();

        /* renamed from: c */
        private String f1937c;

        /* renamed from: d */
        private String f1938d;

        /* renamed from: e */
        private String f1939e;

        public C1687b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f1934a = list;
            this.f1933a = str2;
            this.f1935a = strArr;
            this.f1937c = str3;
            this.f1938d = str4;
            this.f1939e = str5;
            this.f1932a = i;
        }

        /* renamed from: a */
        public SQLiteDatabase mo17307a() {
            return this.f1926a.getReadableDatabase();
        }

        /* renamed from: a */
        public abstract T mo17306a(Context context, Cursor cursor);

        /* renamed from: a */
        public void mo17317a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f1936b.clear();
            List<String> list = this.f1934a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f1934a.size()];
                this.f1934a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.f1932a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(this.f1931b, strArr, this.f1933a, this.f1935a, this.f1937c, this.f1938d, this.f1939e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    Object a = mo17306a(context, query);
                    if (a != null) {
                        this.f1936b.add(a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            mo17308a(context, this.f1936b);
        }

        /* renamed from: a */
        public abstract void mo17308a(Context context, List<T> list);
    }

    /* renamed from: com.xiaomi.push.ci$c */
    public static class C1688c extends C1686a {

        /* renamed from: a */
        private ArrayList<C1686a> f1940a = new ArrayList<>();

        public C1688c(String str, ArrayList<C1686a> arrayList) {
            super(str);
            this.f1940a.addAll(arrayList);
        }

        /* renamed from: a */
        public final void mo17316a(Context context) {
            super.mo17316a(context);
            Iterator<C1686a> it = this.f1940a.iterator();
            while (it.hasNext()) {
                C1686a next = it.next();
                if (next != null) {
                    next.mo17316a(context);
                }
            }
        }

        /* renamed from: a */
        public void mo17317a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<C1686a> it = this.f1940a.iterator();
            while (it.hasNext()) {
                C1686a next = it.next();
                if (next != null) {
                    next.mo17317a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.ci$d */
    public static class C1689d extends C1686a {

        /* renamed from: a */
        private String f1941a;

        /* renamed from: a */
        protected String[] f1942a;

        public C1689d(String str, String str2, String[] strArr) {
            super(str);
            this.f1941a = str2;
            this.f1942a = strArr;
        }

        /* renamed from: a */
        public void mo17317a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f1931b, this.f1941a, this.f1942a);
        }
    }

    /* renamed from: com.xiaomi.push.ci$e */
    public static class C1690e extends C1686a {

        /* renamed from: a */
        private ContentValues f1943a;

        public C1690e(String str, ContentValues contentValues) {
            super(str);
            this.f1943a = contentValues;
        }

        /* renamed from: a */
        public void mo17317a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f1931b, (String) null, this.f1943a);
        }
    }

    private C1685ci(Context context) {
        this.f1920a = context;
    }

    /* renamed from: a */
    private C1683cg mo17311a(String str) {
        C1683cg cgVar = this.f1923a.get(str);
        if (cgVar == null) {
            synchronized (this.f1923a) {
                if (cgVar == null) {
                    cgVar = this.f1921a.mo17310a(this.f1920a, str);
                    this.f1923a.put(str, cgVar);
                }
            }
        }
        return cgVar;
    }

    /* renamed from: a */
    public static C1685ci m2838a(Context context) {
        if (f1919a == null) {
            synchronized (C1685ci.class) {
                if (f1919a == null) {
                    f1919a = new C1685ci(context);
                }
            }
        }
        return f1919a;
    }

    /* renamed from: a */
    private void m2840a() {
        C1618ak.m2518a(this.f1920a).mo17219b(new C1691cj(this), C1995at.m5047a(this.f1920a).mo18465a(C1873ht.StatDataProcessFrequency.mo17806a(), 5));
    }

    /* renamed from: a */
    public String m2841a(String str) {
        return mo17311a(str).mo17309a();
    }

    /* renamed from: a */
    public void mo17312a(C1686a aVar) {
        C1683cg cgVar;
        if (aVar != null) {
            if (this.f1921a != null) {
                String a = aVar.mo17307a();
                synchronized (this.f1923a) {
                    cgVar = this.f1923a.get(a);
                    if (cgVar == null) {
                        cgVar = this.f1921a.mo17310a(this.f1920a, a);
                        this.f1923a.put(a, cgVar);
                    }
                }
                if (!this.f1924a.isShutdown()) {
                    aVar.mo17318a(cgVar, this.f1920a);
                    synchronized (this.f1922a) {
                        this.f1922a.add(aVar);
                        m2840a();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    /* renamed from: a */
    public void mo17313a(Runnable runnable) {
        if (!this.f1924a.isShutdown()) {
            this.f1924a.execute(runnable);
        }
    }

    /* renamed from: a */
    public void mo17314a(ArrayList<C1686a> arrayList) {
        if (this.f1921a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f1924a.isShutdown()) {
                Iterator<C1686a> it = arrayList.iterator();
                while (it.hasNext()) {
                    C1686a next = it.next();
                    if (next.mo17307a()) {
                        next.mo17318a(mo17311a(next.mo17307a()), this.f1920a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.mo17307a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.mo17307a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        C1688c cVar = new C1688c(str, arrayList3);
                        cVar.mo17318a(((C1686a) arrayList3.get(0)).f1926a, this.f1920a);
                        this.f1924a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    /* renamed from: b */
    public void mo17315b(C1686a aVar) {
        C1683cg cgVar;
        if (aVar != null) {
            if (this.f1921a != null) {
                String a = aVar.mo17307a();
                synchronized (this.f1923a) {
                    cgVar = this.f1923a.get(a);
                    if (cgVar == null) {
                        cgVar = this.f1921a.mo17310a(this.f1920a, a);
                        this.f1923a.put(a, cgVar);
                    }
                }
                if (!this.f1924a.isShutdown()) {
                    aVar.mo17318a(cgVar, this.f1920a);
                    mo17313a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }
}
