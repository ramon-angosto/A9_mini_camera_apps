package sg.bigo.ads.common.d.b;

public class a {
    String a;
    sg.bigo.ads.common.d.a b;
    d c;
    float d;
    int e;
    String f;

    public a(sg.bigo.ads.common.d.a aVar) {
        this.b = aVar;
        this.a = aVar.a;
    }

    /* access modifiers changed from: protected */
    public final void a(long j) {
        this.b.h = j;
    }

    /* access modifiers changed from: protected */
    public final void b(long j) {
        this.b.f = j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.d.equals(aVar.b.d) && this.b.c.equals(aVar.b.c);
    }

    public String toString() {
        return this.b.toString();
    }
}
