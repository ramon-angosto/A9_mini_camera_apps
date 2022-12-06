package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.a.b;
import com.meizu.cloud.pushsdk.a.a.c;
import com.meizu.cloud.pushsdk.a.c.a;
import com.meizu.cloud.pushsdk.a.d.k;

public final class e {
    public static <T> c<T> a(b bVar) {
        int h = bVar.h();
        if (h == 0) {
            return b(bVar);
        }
        if (h == 1) {
            return c(bVar);
        }
        if (h != 2) {
            return new c<>(new a());
        }
        return d(bVar);
    }

    private static <T> c<T> b(b bVar) {
        k kVar = null;
        try {
            kVar = b.a(bVar);
            if (kVar == null) {
                return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a()));
            }
            if (bVar.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                c<T> cVar = new c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return cVar;
            } else if (kVar.a() >= 400) {
                c<T> cVar2 = new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a(kVar), bVar, kVar.a()));
                cVar2.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return cVar2;
            } else {
                c<T> a = bVar.a(kVar);
                a.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return a;
            }
        } catch (a e) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a((Throwable) e)));
        } catch (Exception e2) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
        }
    }

    private static <T> c<T> c(b bVar) {
        try {
            k b = b.b(bVar);
            if (b == null) {
                return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a()));
            }
            if (b.a() >= 400) {
                c<T> cVar = new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            c<T> cVar2 = new c<>("success");
            cVar2.a(b);
            return cVar2;
        } catch (a e) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a((Throwable) e)));
        } catch (Exception e2) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(e2));
        }
    }

    private static <T> c<T> d(b bVar) {
        k kVar = null;
        try {
            kVar = b.c(bVar);
            if (kVar == null) {
                return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a()));
            }
            if (bVar.g() == com.meizu.cloud.pushsdk.a.a.e.OK_HTTP_RESPONSE) {
                c<T> cVar = new c<>(kVar);
                cVar.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return cVar;
            } else if (kVar.a() >= 400) {
                c<T> cVar2 = new c<>(com.meizu.cloud.pushsdk.a.i.b.a(new a(kVar), bVar, kVar.a()));
                cVar2.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return cVar2;
            } else {
                c<T> a = bVar.a(kVar);
                a.a(kVar);
                com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
                return a;
            }
        } catch (a e) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(e));
        } catch (Exception e2) {
            return new c<>(com.meizu.cloud.pushsdk.a.i.b.a(e2));
        } finally {
            com.meizu.cloud.pushsdk.a.i.a.a(kVar, bVar);
        }
    }
}
