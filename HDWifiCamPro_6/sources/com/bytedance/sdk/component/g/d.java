package com.bytedance.sdk.component.g;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PoolTaskStatistics */
public class d {
    public static final String[] a = {"com.bytedance.sdk", "com.bykv.vk", "com.ss", "tt_pangle"};
    public static final String[] b = {"tt_pangle", "bd_tracker"};
    private static AtomicInteger c = new AtomicInteger(0);
    private static int d = 0;
    private static int e = 0;

    public static void a() {
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    private static void b() {
        int i;
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it;
        c g = e.g();
        if (g != null) {
            int i2 = 1;
            int addAndGet = c.addAndGet(1);
            if (e.c >= 0 && addAndGet % e.c == 0 && Looper.getMainLooper() != Looper.myLooper()) {
                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                HashMap hashMap = new HashMap();
                if (allStackTraces != null) {
                    boolean a2 = l.a();
                    int size = allStackTraces.size();
                    if (size > e) {
                        e = size;
                    }
                    Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = allStackTraces.entrySet().iterator();
                    int i3 = 0;
                    int i4 = 0;
                    while (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        i4 += i2;
                        Thread thread = (Thread) next.getKey();
                        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                        StringBuilder sb = new StringBuilder("\n");
                        if (a2) {
                            sb.append("Thread Name is : " + thread.getName());
                            sb.append("\n");
                        }
                        String str = null;
                        int length = stackTraceElementArr.length;
                        int i5 = i3;
                        int i6 = 0;
                        while (i6 < length) {
                            String stackTraceElement = stackTraceElementArr[i6].toString();
                            if (a2) {
                                sb.append(stackTraceElement + "\n");
                            }
                            if (TextUtils.isEmpty(str)) {
                                if (!a(stackTraceElement, a)) {
                                    it = it2;
                                    if (!a(thread.getName(), b)) {
                                    }
                                } else {
                                    it = it2;
                                }
                                i5++;
                                str = stackTraceElement;
                            } else {
                                it = it2;
                            }
                            i6++;
                            it2 = it;
                        }
                        Iterator<Map.Entry<Thread, StackTraceElement[]>> it3 = it2;
                        if (a2) {
                            if (!TextUtils.isEmpty(str)) {
                                String str2 = str + "&" + thread.getName();
                                a aVar = (a) hashMap.get(str2);
                                if (aVar != null) {
                                    i = 1;
                                    aVar.a(aVar.a() + 1);
                                } else {
                                    i = 1;
                                    aVar = new a(str2, 1, sb.toString(), thread.getName());
                                }
                                hashMap.put(str2, aVar);
                            } else {
                                i = 1;
                            }
                            if (!TextUtils.isEmpty(sb.toString())) {
                                Log.e("PoolTaskStatistics", "Thread index = " + i4 + "   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                                Log.w("PoolTaskStatistics", sb.toString());
                            }
                        } else {
                            i = 1;
                        }
                        i2 = i;
                        i3 = i5;
                        it2 = it3;
                    }
                    if (i3 > d) {
                        d = i3;
                    }
                    if (a2) {
                        Log.e("PoolTaskStatistics", "SDK current threads=" + i3 + ", SDK Max threads=" + d + ", Application threads = " + size + ", Application max threads = " + e);
                        for (Map.Entry value : hashMap.entrySet()) {
                            Log.i("PoolTaskStatistics", ((a) value.getValue()).toString());
                        }
                    }
                    g.a(new com.bytedance.sdk.component.g.a.a(i3, d, size, e));
                }
            }
        }
    }

    private static boolean a(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String contains : strArr) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* compiled from: PoolTaskStatistics */
    public static class a {
        public int a = 0;
        public String b = null;
        public String c = null;
        public String d = null;

        public a(String str, int i, String str2, String str3) {
            this.c = str;
            this.a = i;
            this.d = str2;
            this.b = str3;
        }

        public void a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }

        public String toString() {
            return "ThreadModel{times=" + this.a + ", name='" + this.b + '\'' + ", lastStackStack='" + this.c + '\'' + '}';
        }
    }
}
