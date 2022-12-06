package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import java.io.IOException;
import org.json.JSONException;

class c0 {
    static f1 a(String str, String str2) {
        String str3;
        try {
            return new f1(str);
        } catch (JSONException e) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + ": " + e.toString();
            }
            new e0.a().a(str3).a(e0.i);
            return new f1();
        }
    }

    static f1 b() {
        return new f1();
    }

    static double c(f1 f1Var, String str) {
        return f1Var.a(str, 0.0d);
    }

    static int d(f1 f1Var, String str) {
        return f1Var.j(str);
    }

    static e1 e(f1 f1Var, String str) {
        return f1Var.l(str);
    }

    static f1 f(f1 f1Var, String str) {
        return f1Var.m(str);
    }

    static Object g(f1 f1Var, String str) {
        Object o = f1Var.o(str);
        return o == null ? Boolean.FALSE : o;
    }

    static String h(f1 f1Var, String str) {
        return f1Var.p(str);
    }

    static String i(f1 f1Var, String str) {
        return f1Var.q(str);
    }

    static boolean j(f1 f1Var, String str) {
        try {
            a.b().p().a(str, f1Var.toString(), false);
            return true;
        } catch (IOException e) {
            new e0.a().a("IOException in ADCJSON's saveObject: ").a(e.toString()).a(e0.i);
            return false;
        }
    }

    static f1 b(String str) {
        return a(str, (String) null);
    }

    static f1 c(String str) {
        try {
            String sb = a.b().p().a(str, false).toString();
            return a(sb, "loadObject from filepath " + str);
        } catch (IOException e) {
            new e0.a().a("IOException in ADCJSON's loadObject: ").a(e.toString()).a(e0.i);
            return b();
        }
    }

    static String b(e1 e1Var, int i) {
        return e1Var.d(i);
    }

    static boolean b(f1 f1Var, String str) {
        return f1Var.f(str);
    }

    static boolean b(f1 f1Var, String str, int i) {
        try {
            f1Var.b(str, i);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putInteger(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + i).a(e0.i);
            return false;
        }
    }

    static e1 a() {
        return new e1();
    }

    static e1 a(String str) {
        try {
            return new e1(str);
        } catch (JSONException e) {
            new e0.a().a(e.toString()).a(e0.i);
            return new e1();
        }
    }

    static boolean b(f1 f1Var, String str, long j) {
        try {
            f1Var.b(str, j);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putLong(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + j).a(e0.i);
            return false;
        }
    }

    static int a(f1 f1Var, String str, int i) {
        return f1Var.a(str, i);
    }

    static long a(f1 f1Var, String str, long j) {
        return f1Var.a(str, j);
    }

    static boolean a(f1 f1Var, String str, boolean z) {
        return f1Var.a(str, z);
    }

    static f1 a(e1 e1Var, int i) {
        return e1Var.c(i);
    }

    static e1 a(f1 f1Var, String str) {
        return f1Var.k(str);
    }

    static boolean b(f1 f1Var, String str, boolean z) {
        try {
            f1Var.b(str, z);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putBoolean(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + z).a(e0.i);
            return false;
        }
    }

    static boolean a(f1 f1Var, String str, String str2) {
        try {
            f1Var.a(str, str2);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putString(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + str2).a(e0.i);
            return false;
        }
    }

    static f1[] b(e1 e1Var) {
        return e1Var.c();
    }

    static boolean a(f1 f1Var, String str, e1 e1Var) {
        try {
            f1Var.a(str, e1Var);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putArray(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + e1Var).a(e0.i);
            return false;
        }
    }

    static boolean a(f1 f1Var, String str, f1 f1Var2) {
        try {
            f1Var.a(str, f1Var2);
            return true;
        } catch (JSONException e) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putObject(): ").a(e.toString());
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + f1Var2).a(e0.i);
            return false;
        }
    }

    static boolean a(f1 f1Var, String str, double d) {
        try {
            f1Var.b(str, d);
            return true;
        } catch (JSONException unused) {
            e0.a a = new e0.a().a("JSON error in ADCJSON putDouble(): ");
            e0.a a2 = a.a(" with key: " + str);
            a2.a(" and value: " + d).a(e0.i);
            return false;
        }
    }

    static void a(e1 e1Var, String str) {
        e1Var.b(str);
    }

    static void a(e1 e1Var, f1 f1Var) {
        e1Var.a(f1Var);
    }

    static String[] a(e1 e1Var) {
        return e1Var.d();
    }

    static f1 a(f1... f1VarArr) {
        f1 f1Var = new f1();
        for (f1 a : f1VarArr) {
            f1Var.a(a);
        }
        return f1Var;
    }
}
