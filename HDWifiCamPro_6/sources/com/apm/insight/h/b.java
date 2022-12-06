package com.apm.insight.h;

import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.q;
import com.apm.insight.runtime.p;
import com.apm.insight.runtime.r;
import java.io.File;
import java.util.HashMap;

public class b {
    /* access modifiers changed from: private */
    public static HashMap<String, String> a;

    public static String a() {
        return h.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static String a(String str) {
        return h.g().getFilesDir() + "/apminsight/selflib/" + "lib" + str + ".so";
    }

    public static void b(final String str) {
        p.b().a((Runnable) new Runnable() {
            boolean a = false;

            public void run() {
                String str;
                String str2;
                b.d();
                if (!b.f(str)) {
                    r.a("updateSo", str);
                    File file = new File(b.a(str));
                    file.getParentFile().mkdirs();
                    if (file.exists()) {
                        file.delete();
                    }
                    q.a("doUnpackLibrary: " + str);
                    String str3 = null;
                    try {
                        str3 = c.a(h.g(), str, file);
                    } catch (Throwable th) {
                        r.a("updateSoError", str);
                        com.apm.insight.b.a().a("NPTH_CATCH", th);
                    }
                    if (str3 == null) {
                        b.a.put(file.getName(), "1.3.8.nourl-alpha.7");
                        try {
                            i.a(new File(b.e(str)), "1.3.8.nourl-alpha.7", false);
                        } catch (Throwable unused) {
                        }
                        str2 = str;
                        str = "updateSoSuccess";
                    } else if (!this.a) {
                        this.a = true;
                        r.a("updateSoPostRetry", str);
                        p.b().a((Runnable) this, 3000);
                        return;
                    } else {
                        str2 = str;
                        str = "updateSoFailed";
                    }
                    r.a(str, str2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void d() {
        if (a == null) {
            a = new HashMap<>();
            File file = new File(h.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        try {
                            a.put(str.substring(0, str.length() - 4), i.c(file.getAbsolutePath() + "/" + str));
                        } catch (Throwable th) {
                            com.apm.insight.b.a().a("NPTH_CATCH", th);
                        }
                    } else if (!str.endsWith(".so")) {
                        i.a(new File(file, str));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static String e(String str) {
        return h.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver";
    }

    /* access modifiers changed from: private */
    public static boolean f(String str) {
        return "1.3.8.nourl-alpha.7".equals(a.get(str)) && new File(a(str)).exists();
    }
}
