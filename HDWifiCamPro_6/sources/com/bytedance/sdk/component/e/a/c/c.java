package com.bytedance.sdk.component.e.a.c;

import android.util.Log;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;

/* compiled from: LDebug */
public class c {
    public static void a(String str) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.d(c + "log", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.i(c + "log", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.w(c + "log", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(String str) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.w(c + "log", str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.d((c + "log") + str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, String str2) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.w((c + "log") + str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(String str, String str2) {
        try {
            f m = i.e().m();
            if (m != null && m.b()) {
                String c = m.c();
                if (c == null) {
                    c = "";
                }
                Log.e((c + "log") + str, str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
