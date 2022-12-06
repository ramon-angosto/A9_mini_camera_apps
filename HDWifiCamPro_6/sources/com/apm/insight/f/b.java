package com.apm.insight.f;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.entity.a;
import com.apm.insight.entity.c;
import com.apm.insight.k.g;
import com.apm.insight.l.q;
import com.apm.insight.l.v;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.p;
import java.util.Map;
import org.json.JSONObject;

public final class b {
    private static String a(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i < stackTraceElementArr.length) {
            v.a(stackTraceElementArr[i], sb);
            i++;
        }
        return sb.toString();
    }

    public static void a(Object obj, Throwable th, String str, boolean z, Map<String, String> map, String str2, String str3) {
        try {
            final Object obj2 = obj;
            final Throwable th2 = th;
            final String str4 = str;
            final boolean z2 = z;
            final Map<String, String> map2 = map;
            final String str5 = str2;
            final String str6 = str3;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    b.c(obj2, th2, str4, z2, map2, str5, str6);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th, String str, boolean z) {
        a(th, str, z, "core_exception_monitor");
    }

    public static void a(Throwable th, String str, boolean z, String str2) {
        a(th, str, z, (Map<String, String>) null, str2);
    }

    public static void a(Throwable th, String str, boolean z, Map<String, String> map, String str2) {
        try {
            final Throwable th2 = th;
            final String str3 = str;
            final boolean z2 = z;
            final Map<String, String> map2 = map;
            final String str4 = str2;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    b.b((Object) null, th2, str3, z2, (Map<String, String>) map2, str4);
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(Map<String, String> map, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (String next : map.keySet()) {
                    jSONObject.put(next, map.get(next));
                }
                cVar.a("custom", (Object) jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(StackTraceElement[] stackTraceElementArr, int i, String str, String str2, Map<String, String> map) {
        try {
            final StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
            final int i2 = i;
            final String str3 = str;
            final String str4 = str2;
            final Map<String, String> map2 = map;
            p.b().a((Runnable) new Runnable() {
                public void run() {
                    b.b(stackTraceElementArr2, i2, str3, str4, "core_exception_monitor", (Map<String, String>) map2);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void b(Object obj, Throwable th, String str, boolean z, Map<String, String> map, String str2) {
        c(obj, th, str, z, map, "EnsureNotReachHere", str2);
    }

    /* access modifiers changed from: private */
    public static void b(StackTraceElement[] stackTraceElementArr, int i, String str, String str2, String str3, Map<String, String> map) {
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length > i + 1) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (stackTraceElement != null) {
                        String a = a(stackTraceElementArr, i);
                        if (!TextUtils.isEmpty(a)) {
                            c a2 = c.a(stackTraceElement, a, str, Thread.currentThread().getName(), true, str2, str3);
                            a(map, a2);
                            f.a().a(CrashType.ENSURE, (a) a2);
                            g.a(a2);
                            q.b((Object) "[report] " + str);
                        }
                    }
                }
            } catch (Throwable th) {
                q.b(th);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, Throwable th, String str, boolean z, Map<String, String> map, String str2, String str3) {
        if (th != null) {
            try {
                StackTraceElement[] stackTrace = th.getStackTrace();
                StackTraceElement stackTraceElement = stackTrace[0];
                if (stackTraceElement != null) {
                    String a = v.a(th);
                    if (!TextUtils.isEmpty(a)) {
                        c a2 = c.a(stackTraceElement, a, str, Thread.currentThread().getName(), z, str2, str3);
                        if (obj != null) {
                            a2.a("exception_line_num", (Object) com.apm.insight.entity.b.a(obj, th, stackTrace));
                        }
                        a(map, a2);
                        f.a().a(CrashType.ENSURE, (a) a2);
                        g.a(obj, a2);
                        q.b((Object) "[reportException] " + str);
                    }
                }
            } catch (Throwable th2) {
                q.b(th2);
            }
        }
    }
}
