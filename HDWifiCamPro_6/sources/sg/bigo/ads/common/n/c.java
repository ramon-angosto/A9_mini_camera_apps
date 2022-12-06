package sg.bigo.ads.common.n;

import android.content.SharedPreferences;

public final class c {

    public static final class a {
        private static a a;
        private final C0125a b = new C0125a();

        /* renamed from: sg.bigo.ads.common.n.c$a$a  reason: collision with other inner class name */
        public static class C0125a {
            C0125a() {
            }

            public static void a(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private a() {
        }

        public static a a() {
            if (a == null) {
                a = new a();
            }
            return a;
        }
    }
}
