package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.b.c.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;

public class b extends a {
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public static abstract class a<T extends a<T>> extends a.C0043a<T> {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;

        public T a(String str) {
            this.a = str;
            return (a) a();
        }

        public T b(String str) {
            this.b = str;
            return (a) a();
        }

        public T c(String str) {
            this.c = str;
            return (a) a();
        }

        public T d(String str) {
            this.d = str;
            return (a) a();
        }

        public T e(String str) {
            this.e = str;
            return (a) a();
        }

        public T f(String str) {
            this.f = str;
            return (a) a();
        }

        public T g(String str) {
            this.g = str;
            return (a) a();
        }

        public b b() {
            return new b(this);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.c.b$b  reason: collision with other inner class name */
    private static class C0044b extends a<C0044b> {
        /* access modifiers changed from: protected */
        /* renamed from: c */
        public C0044b a() {
            return this;
        }

        private C0044b() {
        }
    }

    public static a<?> d() {
        return new C0044b();
    }

    protected b(a<?> aVar) {
        super(aVar);
        this.e = aVar.b;
        this.f = aVar.c;
        this.d = aVar.a;
        this.g = aVar.d;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = aVar.g;
    }

    public c e() {
        c cVar = new c();
        cVar.a("event_name", this.d);
        cVar.a(PushConstants.TASK_ID, this.e);
        cVar.a("device_id", this.f);
        cVar.a("pushsdk_version", this.g);
        cVar.a("package_name", this.h);
        cVar.a("seq_id", this.i);
        cVar.a("message_seq", this.j);
        return a(cVar);
    }
}
