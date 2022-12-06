package com.apm.insight.b;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class j {
    /* access modifiers changed from: private */
    public static int a = 5;
    private static b b;
    /* access modifiers changed from: private */
    public static a c;
    private static boolean d;
    private static Printer e;

    public interface a {
        void a(long j);
    }

    static class b implements Printer {
        List<Printer> a = new ArrayList();
        List<Printer> b = new ArrayList();
        List<Printer> c = new ArrayList();
        boolean d = false;
        boolean e = false;

        b() {
        }

        public void println(String str) {
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = j.c != null ? System.currentTimeMillis() : 0;
                if (str.charAt(0) == '>' && this.e) {
                    for (Printer next : this.c) {
                        if (!this.a.contains(next)) {
                            this.a.add(next);
                        }
                    }
                    this.c.clear();
                    this.e = false;
                }
                if (this.a.size() > j.a) {
                    Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
                }
                for (Printer next2 : this.a) {
                    if (next2 != null) {
                        next2.println(str);
                    }
                }
                if (str.charAt(0) == '<' && this.d) {
                    for (Printer next3 : this.b) {
                        this.a.remove(next3);
                        this.c.remove(next3);
                    }
                    this.b.clear();
                    this.d = false;
                }
                if (j.c != null && currentTimeMillis > 0) {
                    j.c.a(System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    public static void a() {
        if (!d) {
            d = true;
            b = new b();
            e = d();
            if (e != null) {
                b.a.add(e);
            }
            Looper.getMainLooper().setMessageLogging(b);
        }
    }

    public static void a(Printer printer) {
        if (printer != null && !b.c.contains(printer)) {
            b.c.add(printer);
            b.e = true;
        }
    }

    private static Printer d() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception unused) {
            return null;
        }
    }
}
