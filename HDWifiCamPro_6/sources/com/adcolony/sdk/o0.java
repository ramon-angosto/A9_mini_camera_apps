package com.adcolony.sdk;

import android.content.ContentValues;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.adcolony.sdk.o;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

class o0 {
    private static o0 e;
    /* access modifiers changed from: private */
    public n0 a;
    private final ExecutorService b = z0.h();
    /* access modifiers changed from: private */
    public o.b c = null;
    /* access modifiers changed from: private */
    public boolean d = false;

    class a implements x<o.b> {
        final /* synthetic */ o.b[] a;
        final /* synthetic */ CountDownLatch b;

        a(o0 o0Var, o.b[] bVarArr, CountDownLatch countDownLatch) {
            this.a = bVarArr;
            this.b = countDownLatch;
        }

        public void a(o.b bVar) {
            this.a[0] = bVar;
            this.b.countDown();
        }
    }

    class b implements x<o.b> {
        b(o0 o0Var) {
        }

        public void a(o.b bVar) {
        }
    }

    class c implements Runnable {
        final /* synthetic */ x a;
        final /* synthetic */ long b;

        c(x xVar, long j) {
            this.a = xVar;
            this.b = j;
        }

        public void run() {
            o.b bVar;
            x xVar = this.a;
            if (o0.this.d) {
                bVar = o0.this.c;
            } else {
                bVar = v.a().a(o0.this.a, this.b);
            }
            xVar.a(bVar);
        }
    }

    o0() {
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.d = false;
    }

    static o0 c() {
        if (e == null) {
            synchronized (o0.class) {
                if (e == null) {
                    e = new o0();
                }
            }
        }
        return e;
    }

    /* access modifiers changed from: package-private */
    public void a(n0 n0Var) {
        this.a = n0Var;
    }

    /* access modifiers changed from: package-private */
    public o.b b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = r3.p("request_type");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.adcolony.sdk.h0 r3) {
        /*
            r2 = this;
            com.adcolony.sdk.n0 r0 = r2.a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.adcolony.sdk.f1 r3 = r3.a()
            if (r3 != 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r0 = "payload"
            com.adcolony.sdk.f1 r3 = r3.n(r0)
            if (r3 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r0 = "request_type"
            java.lang.String r0 = r3.p(r0)
            com.adcolony.sdk.n0 r1 = r2.a
            com.adcolony.sdk.n0$a r1 = r1.a((java.lang.String) r0)
            if (r1 == 0) goto L_0x0026
            r2.a(r0, r3, r1)
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.o0.a(com.adcolony.sdk.h0):void");
    }

    private void a(String str, f1 f1Var, n0.a aVar) {
        try {
            ContentValues a2 = a(f1Var, aVar);
            v.a().a(aVar.f(), a2);
            v.a().a(aVar, a2);
            d();
        } catch (NullPointerException | NumberFormatException e2) {
            e2.printStackTrace();
            e0.a aVar2 = new e0.a();
            e0.a a3 = aVar2.a("Error parsing event:" + str + " ").a(f1Var.toString());
            a3.a("Schema version: " + this.a.b() + " ").a(" e: ").a(e2.toString()).a(e0.g);
        }
    }

    static ContentValues a(f1 f1Var, n0.a aVar) throws NumberFormatException, NullPointerException {
        ContentValues contentValues = new ContentValues();
        for (n0.b next : aVar.a()) {
            Object o = f1Var.o(next.b());
            if (o != null) {
                if (o instanceof Boolean) {
                    contentValues.put(next.b(), (Boolean) o);
                } else if (o instanceof Long) {
                    contentValues.put(next.b(), (Long) o);
                } else if (o instanceof Double) {
                    contentValues.put(next.b(), (Double) o);
                } else if (o instanceof Number) {
                    Number number = (Number) o;
                    if (number.doubleValue() != ((double) number.longValue()) || !"INTEGER".equalsIgnoreCase(next.c())) {
                        contentValues.put(next.b(), Double.valueOf(number.doubleValue()));
                    } else {
                        contentValues.put(next.b(), Long.valueOf(number.longValue()));
                    }
                } else if (o instanceof String) {
                    contentValues.put(next.b(), (String) o);
                }
            }
        }
        return contentValues;
    }

    /* access modifiers changed from: package-private */
    public o.b a(long j) {
        o.b[] bVarArr = new o.b[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        a((x<o.b>) new a(this, bVarArr, countDownLatch), j);
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        return bVarArr[0];
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a((x<o.b>) new b(this));
    }

    /* access modifiers changed from: package-private */
    public void a(x<o.b> xVar) {
        a(xVar, -1);
    }

    /* access modifiers changed from: package-private */
    public void a(x<o.b> xVar, long j) {
        if (this.a == null) {
            xVar.a(null);
        } else if (this.d) {
            xVar.a(this.c);
        } else if (!z0.a(this.b, (Runnable) new c(xVar, j))) {
            new e0.a().a("Execute ADCOdtEventsListener.calculateFeatureVectors failed").a(e0.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(o.b bVar) {
        this.c = bVar;
        this.d = true;
    }
}
