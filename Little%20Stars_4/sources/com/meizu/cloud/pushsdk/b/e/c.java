package com.meizu.cloud.pushsdk.b.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.f.b;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c {
    private static final String n = "c";
    protected final String a = "3.3.170110";
    protected com.meizu.cloud.pushsdk.b.b.c b;
    protected b c;
    protected a d;
    protected String e;
    protected String f;
    protected boolean g;
    protected b h;
    protected boolean i;
    protected long j;
    protected int k;
    protected TimeUnit l;
    protected AtomicBoolean m = new AtomicBoolean(true);

    public static class a {
        protected final com.meizu.cloud.pushsdk.b.b.c a;
        protected final String b;
        protected final String c;
        protected final Context d;
        protected b e = null;
        protected boolean f = false;
        protected b g = b.OFF;
        protected boolean h = false;
        protected long i = 600;
        protected long j = 300;
        protected long k = 15;
        protected int l = 10;
        protected TimeUnit m = TimeUnit.SECONDS;
        private Class<? extends c> n;

        public a(com.meizu.cloud.pushsdk.b.b.c cVar, String str, String str2, Context context, Class<? extends c> cls) {
            this.a = cVar;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.n = cls;
        }

        public a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }

        public a a(b bVar) {
            this.g = bVar;
            return this;
        }

        public a a(int i2) {
            this.l = i2;
            return this;
        }
    }

    public c(a aVar) {
        this.b = aVar.a;
        this.f = aVar.c;
        this.g = aVar.f;
        this.e = aVar.b;
        this.c = aVar.e;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.k;
        this.k = aVar.l >= 2 ? aVar.l : 2;
        this.l = aVar.m;
        if (this.i) {
            this.d = new a(aVar.i, aVar.j, aVar.m, aVar.d);
        }
        com.meizu.cloud.pushsdk.b.f.c.a(aVar.g);
        com.meizu.cloud.pushsdk.b.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private void a(com.meizu.cloud.pushsdk.b.a.c cVar, List<com.meizu.cloud.pushsdk.b.a.b> list) {
        b bVar = this.c;
        if (bVar != null) {
            cVar.a(new HashMap(bVar.c()));
        }
        cVar.a(PushConstants.EXTRA, (Object) a(list).a());
        com.meizu.cloud.pushsdk.b.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a((com.meizu.cloud.pushsdk.b.a.a) cVar);
    }

    private com.meizu.cloud.pushsdk.b.a.b a(List<com.meizu.cloud.pushsdk.b.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        b bVar = this.c;
        if (bVar != null) {
            if (!bVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.b.a.b("geolocation", this.c.a()));
            }
            if (!this.c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.b.a.b("mobileinfo", this.c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.b.a.b a2 : list) {
            linkedList.add(a2.a());
        }
        return new com.meizu.cloud.pushsdk.b.a.b("push_extra_info", linkedList);
    }

    public void a(com.meizu.cloud.pushsdk.b.c.b bVar) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a());
        }
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public com.meizu.cloud.pushsdk.b.b.c b() {
        return this.b;
    }
}
