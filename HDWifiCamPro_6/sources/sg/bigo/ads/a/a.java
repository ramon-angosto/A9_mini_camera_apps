package sg.bigo.ads.a;

import android.content.Context;
import android.graphics.Bitmap;

public final class a {
    public final String a;
    public final int b;
    public final int c;
    public final boolean d;
    public final Bitmap e;
    public final c f;
    public final b g;

    /* renamed from: sg.bigo.ads.a.a$a  reason: collision with other inner class name */
    public static class C0109a {
        public String a;
        public c b;
        public b c;
        private int d = 0;
        private int e = 0;
        private boolean f = true;
        private Bitmap g;

        public final a a() {
            return new a(this.a, this.d, this.e, this.f, this.g, this.b, this.c);
        }
    }

    public interface b {
        void a(Context context, String str, int i, String str2);

        void a(String str, String str2, String str3);
    }

    public interface c {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public a(String str, int i, int i2, boolean z, Bitmap bitmap, c cVar, b bVar) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = bitmap;
        this.f = cVar;
        this.g = bVar;
    }
}
