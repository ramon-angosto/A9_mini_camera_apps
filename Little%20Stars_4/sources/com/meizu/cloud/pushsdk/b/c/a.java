package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.a.b;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.b.f.d;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a {
    protected final List<b> a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    public static abstract class C0043a<T extends C0043a<T>> {
        /* access modifiers changed from: private */
        public List<b> a = new LinkedList();
        /* access modifiers changed from: private */
        public long b = System.currentTimeMillis();
        /* access modifiers changed from: private */
        public String c = e.b();

        /* access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    protected a(C0043a<?> aVar) {
        d.a(aVar.a);
        d.a(aVar.c);
        d.a(!aVar.c.isEmpty(), (Object) "eventId cannot be empty");
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
    }

    public List<b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a("event_id", c());
        cVar.a("timestamp", Long.toString(b()));
        return cVar;
    }
}
