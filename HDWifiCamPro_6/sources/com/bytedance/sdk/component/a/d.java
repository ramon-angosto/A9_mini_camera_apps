package com.bytedance.sdk.component.a;

/* compiled from: BaseStatefulMethod */
public abstract class d<P, R> extends b<P, R> {
    private boolean a = true;
    private a b;
    private f c;

    /* compiled from: BaseStatefulMethod */
    interface a {
        void a(Throwable th);
    }

    /* compiled from: BaseStatefulMethod */
    public interface b {
        d a();
    }

    /* access modifiers changed from: protected */
    public abstract void a(P p, f fVar) throws Exception;

    /* access modifiers changed from: protected */
    public abstract void d();

    public /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        if (g()) {
            this.b.a(th);
            e();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        a((Throwable) null);
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.a = false;
        this.c = null;
    }

    /* access modifiers changed from: package-private */
    public void a(P p, f fVar, a aVar) throws Exception {
        this.c = fVar;
        this.b = aVar;
        a(p, fVar);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        d();
        e();
    }

    private boolean g() {
        if (this.a) {
            return true;
        }
        i.a((RuntimeException) new IllegalStateException("Jsb async call already finished: " + a() + ", hashcode: " + hashCode()));
        return false;
    }
}
