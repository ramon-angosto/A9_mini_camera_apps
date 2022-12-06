package com.bytedance.sdk.component.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.t;
import com.bytedance.sdk.component.a.v;
import com.bytedance.sdk.component.a.w;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* compiled from: CallHandler */
class g implements w.a {
    private final h a;
    private final u b;
    private final Map<String, b> c = new HashMap();
    private final Map<String, d.b> d = new HashMap();
    private final List<q> e = new ArrayList();
    /* access modifiers changed from: private */
    public final Set<d> f = new HashSet();
    private final m g;
    private final boolean h;
    private final boolean i;
    /* access modifiers changed from: private */
    public final a j;

    g(j jVar, a aVar, v vVar) {
        this.j = aVar;
        this.a = jVar.d;
        this.b = new u(vVar, jVar.l, jVar.m);
        this.b.a((w.a) this);
        this.b.a(jVar.p);
        this.g = jVar.i;
        this.h = jVar.h;
        this.i = jVar.o;
    }

    /* access modifiers changed from: package-private */
    public a a(q qVar, f fVar) throws Exception {
        b bVar = this.c.get(qVar.d);
        if (bVar != null) {
            try {
                x b2 = b(fVar.b, bVar);
                fVar.d = b2;
                if (b2 == null) {
                    if (this.g != null) {
                        this.g.a(fVar.b, qVar.d, 1);
                    }
                    i.a("Permission denied, call: " + qVar);
                    throw new s(-1);
                } else if (bVar instanceof e) {
                    i.a("Processing stateless call: " + qVar);
                    return a(qVar, (e) bVar, fVar);
                } else if (bVar instanceof c) {
                    i.a("Processing raw call: " + qVar);
                    return a(qVar, (c) bVar, b2);
                }
            } catch (v.a e2) {
                i.a("No remote permission config fetched, call pending: " + qVar, e2);
                this.e.add(qVar);
                return new a(false, y.a());
            }
        }
        d.b bVar2 = this.d.get(qVar.d);
        if (bVar2 != null) {
            d a2 = bVar2.a();
            a2.a(qVar.d);
            x b3 = b(fVar.b, a2);
            fVar.d = b3;
            if (b3 != null) {
                i.a("Processing stateful call: " + qVar);
                return a(qVar, a2, fVar);
            }
            i.a("Permission denied, call: " + qVar);
            a2.e();
            throw new s(-1);
        }
        m mVar = this.g;
        if (mVar != null) {
            mVar.a(fVar.b, qVar.d, 2);
        }
        i.b("Received call: " + qVar + ", but not registered.");
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, e<?, ?> eVar) {
        eVar.a(str);
        this.c.put(str, eVar);
        i.a("JsBridge stateless method registered: " + str);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, d.b bVar) {
        this.d.put(str, bVar);
        i.a("JsBridge stateful method registered: " + str);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (d f2 : this.f) {
            f2.f();
        }
        this.f.clear();
        this.c.clear();
        this.d.clear();
        this.b.b(this);
    }

    private a a(q qVar, e eVar, f fVar) throws Exception {
        return new a(true, y.a(this.a.a(eVar.a(a(qVar.e, (b) eVar), fVar))));
    }

    private a a(final q qVar, final d dVar, f fVar) throws Exception {
        this.f.add(dVar);
        dVar.a(a(qVar.e, (b) dVar), fVar, new d.a() {
            public void a(Throwable th) {
                if (g.this.j != null) {
                    g.this.j.b(y.a(th), qVar);
                    g.this.f.remove(dVar);
                }
            }
        });
        return new a(false, y.a());
    }

    private a a(final q qVar, c cVar, x xVar) throws Exception {
        cVar.a(qVar, new t(qVar.d, xVar, new t.a() {
        }));
        return new a(false, y.a());
    }

    private Object a(String str, b bVar) throws JSONException {
        return this.a.a(str, a((Object) bVar)[0]);
    }

    private x b(String str, b bVar) {
        if (this.i) {
            return x.PRIVATE;
        }
        return this.b.a(this.h, str, bVar);
    }

    private static Type[] a(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        }
        throw new IllegalStateException("Method is not parameterized?!");
    }

    /* compiled from: CallHandler */
    static final class a {
        boolean a;
        String b;

        private a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }
}
