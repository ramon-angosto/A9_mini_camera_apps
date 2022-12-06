package com.bytedance.sdk.component.f.d;

/* compiled from: Logger */
public class b {
    private a a;
    private C0036b b;

    /* compiled from: Logger */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* renamed from: com.bytedance.sdk.component.f.d.b$b  reason: collision with other inner class name */
    /* compiled from: Logger */
    public interface C0036b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* compiled from: Logger */
    private static class c {
        /* access modifiers changed from: private */
        public static final b a = new b();
    }

    private b() {
        this.a = a.OFF;
        this.b = new a();
    }

    public static void a(a aVar) {
        synchronized (b.class) {
            c.a.a = aVar;
        }
    }

    public static void a(String str, String str2) {
        if (c.a.a.compareTo(a.ERROR) <= 0) {
            c.a.b.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c.a.a.compareTo(a.DEBUG) <= 0) {
            c.a.b.b(str, str2);
        }
    }
}
